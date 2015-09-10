/**
 * application-services-impl [6/11/2014 18:52:04]
 */
package org.ambar.appl.bo.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.ambar.appl.be.Cobranza;
import org.ambar.appl.be.DetalleCobranza;
import org.ambar.appl.be.Factura;
import org.ambar.appl.be.MovimientoCuentaCorriente;
import org.ambar.appl.bo.CobranzaBO;
import org.ambar.appl.bo.MovimientoCuentaCorrienteBO;
import org.ambar.appl.commons.enums.EstadoPagoFacturaValues;
import org.ambar.core.bo.impl.CrudBusinessObjectImpl;
import org.ambar.core.commons.context.RequestContext;
import org.ambar.core.exceptions.BusinessException;
import org.ambar.core.validation.configuration.Validation;
import org.ambar.core.validation.configuration.ValidationStrategy;
import org.ambar.core.validation.configuration.Validations;

/**
 * <p>
 * Implementación por default de {@link CobranzaBO}.
 * </p>
 *
 * @author Sebastian
 *
 */
@Validations(
		validations = {
				@Validation(
						transactionNames = { "insert" },
						validators = { "applicationHibernateValidators" }
						),
				@Validation(
						transactionNames = { "update" },
						validators = { "applicationHibernateValidators" })
		},
		strategy = ValidationStrategy.CONTINUE
)
public class CobranzaBOImpl extends CrudBusinessObjectImpl<Long, Cobranza> implements CobranzaBO {

	private MovimientoCuentaCorrienteBO movimientoCuentaCorrienteBO;

	/**
	 * @param pMovimientoCuentaCorrienteBO Establece el valor del atributo movimientoCuentaCorrienteBO.
	 */
	public void setMovimientoCuentaCorrienteBO(MovimientoCuentaCorrienteBO pMovimientoCuentaCorrienteBO) {
		movimientoCuentaCorrienteBO = pMovimientoCuentaCorrienteBO;
	}

	/* (non-JSDoc)
	 * @see org.ambar.core.bo.impl.CrudBusinessObjectImpl#
	 * insert(org.ambar.core.be.Persistible, java.util.List, org.ambar.core.commons.context.RequestContext)
	 */
	@Override
	public void insert(Cobranza pCobranza, List<String> pWarnings, RequestContext pRequestContext)
		   throws BusinessException {
		this.agregarMovimiento(pCobranza, pWarnings, pRequestContext);
		this.actualizarMontoFacturas(pCobranza, pWarnings, pRequestContext);
		super.insert(pCobranza, pWarnings, pRequestContext);
	}

	/* (non-JSDoc)
	 * @see org.ambar.core.bo.impl.CrudBusinessObjectImpl#
	 * remove(org.ambar.core.be.Persistible, java.util.List, org.ambar.core.commons.context.RequestContext)
	 */
	@Override
	public void remove(Cobranza pCobranza, List<String> pWarnings, RequestContext pRequestContext)
		   throws BusinessException {
		this.eliminarMovimiento(pCobranza, pWarnings, pRequestContext);
		this.cancelarMontoFacturas(pCobranza, pWarnings, pRequestContext);
		super.remove(pCobranza, pWarnings, pRequestContext);
	}

	/* (non-JSDoc)
	 * @see org.ambar.core.bo.impl.CrudBusinessObjectImpl#
	 * update(org.ambar.core.be.Persistible, java.util.List, org.ambar.core.commons.context.RequestContext)
	 */
	@Override
	public void update(Cobranza pCobranza, List<String> pWarnings, RequestContext pRequestContext)
		   throws BusinessException {
		this.eliminarMovimiento(pCobranza, pWarnings, pRequestContext);
		this.agregarMovimiento(pCobranza, pWarnings, pRequestContext);
		this.cancelarMontoFacturas(pCobranza, pWarnings, pRequestContext);
		this.actualizarMontoFacturas(pCobranza, pWarnings, pRequestContext);
		super.update(pCobranza, pWarnings, pRequestContext);
	}

	private void agregarMovimiento(Cobranza pCobranza, List<String> pWarnings, RequestContext pRequestContext)
			throws BusinessException {

		MovimientoCuentaCorriente movCtaCorriente = new MovimientoCuentaCorriente();
		movCtaCorriente.setCobranza(pCobranza);
		movCtaCorriente.setDescripcion("PAGO");
		movCtaCorriente.setFecha(new Date());
		movCtaCorriente.setSaldo(pCobranza.getCliente().getCuentaCorriente().getSaldo()
                                 .subtract(pCobranza.getImporteTotal()));

		pCobranza.getCliente().getCuentaCorriente().agregarMovimiento(movCtaCorriente);
	}

	private void eliminarMovimiento(Cobranza pCobranza, List<String> pWarnings, RequestContext pRequestContext)
			throws BusinessException {
		MovimientoCuentaCorriente movimientoCuentaCorriente =  pCobranza.getCliente()
				                                                        .getCuentaCorriente()
				                                                        .getByCobranza(pCobranza);
		if (movimientoCuentaCorriente != null) {
			pCobranza.getCliente().getCuentaCorriente().removerMovimiento(movimientoCuentaCorriente);
			this.movimientoCuentaCorrienteBO.remove(movimientoCuentaCorriente, pWarnings, pRequestContext);
		}
	}

	private void actualizarMontoFacturas(Cobranza pCobranza, List<String> pWarnings, RequestContext pRequestContext) {
		for (DetalleCobranza detCob : pCobranza.getColeccionDetalleCobranza()) {
			Factura fac = detCob.getFactura();
			fac.setSaldo(fac.getSaldo().subtract(detCob.getMontoPagado()));
			if (fac.getSaldo().compareTo(BigDecimal.ZERO) == 0) {
				fac.setEstadoPago(EstadoPagoFacturaValues.PAGADA);
			} else {
				fac.setEstadoPago(EstadoPagoFacturaValues.PARCIAL);
			}
		}
	}

	private void cancelarMontoFacturas(Cobranza pCobranza, List<String> pWarnings, RequestContext pRequestContext) {
		for (DetalleCobranza detCob : pCobranza.getColeccionDetalleCobranza()) {
			Factura fac = detCob.getFactura();
			fac.setSaldo(fac.getSaldo().add(detCob.getMontoPagado()));
			if (fac.getSaldo().compareTo(fac.getImporteTotal()) == 0) {
				fac.setEstadoPago(EstadoPagoFacturaValues.PENDIENTE);
			} else {
				fac.setEstadoPago(EstadoPagoFacturaValues.PARCIAL);
			}
		}
	}

	@Override
	public void guardarCobroContado(Cobranza pCobranza,
			                        Factura pFactura,
			                        List<String> pWarnings,
			                        RequestContext pRequestContext) throws BusinessException {

		//Agrega un detalle a la cobranza
		DetalleCobranza detalleCobranza = new DetalleCobranza();
		detalleCobranza.setFactura(pFactura);
		detalleCobranza.setMontoPagado(pCobranza.getImporteTotal());
		detalleCobranza.setSaldo(pFactura.getImporteTotal().subtract(pCobranza.getImporteTotal()));
		pCobranza.agregarDetalleCobranza(detalleCobranza);

		//Setea el cliente
		pCobranza.setCliente(pFactura.getCliente());

		//Si el importe pagado y el importe de la factura difieren,
		//se genera un movimiento en la cuenta corriente del cliente
		if (pCobranza.getImporteTotal().compareTo(pFactura.getImporteTotal()) != 0) {
			//Agrega un movimiento a la cuenta corriente si es necesario
			MovimientoCuentaCorriente movCtaCorriente = new MovimientoCuentaCorriente();
			movCtaCorriente.setFactura(pFactura);
			movCtaCorriente.setCobranza(pCobranza);
			movCtaCorriente.setCuentaCorriente(pFactura.getCliente().getCuentaCorriente());
			movCtaCorriente.setFecha(new Date());
			if (pCobranza.getImporteTotal().compareTo(pFactura.getImporteTotal()) > 0) {
				pFactura.setEstadoPago(EstadoPagoFacturaValues.PAGADA);
				movCtaCorriente.setSaldo(pCobranza.getImporteTotal()
	                                              .subtract(pFactura.getImporteTotal()));
				movCtaCorriente.setDescripcion("REMANENTE DE PAGO CONTADO");
			} else if (pCobranza.getImporteTotal().compareTo(pFactura.getImporteTotal()) < 0) {
				pFactura.setEstadoPago(EstadoPagoFacturaValues.PARCIAL);
				movCtaCorriente.setSaldo(pFactura.getImporteTotal()
	                                             .subtract(pCobranza.getImporteTotal()));
				movCtaCorriente.setDescripcion("PENDIENTE DE PAGO CONTADO");
			}
			//Agrega el movimiento
			pCobranza.getCliente().getCuentaCorriente().agregarMovimiento(movCtaCorriente);
		}

		//Inserta la cobranza
		super.insert(pCobranza, pWarnings, pRequestContext);
	}
}
