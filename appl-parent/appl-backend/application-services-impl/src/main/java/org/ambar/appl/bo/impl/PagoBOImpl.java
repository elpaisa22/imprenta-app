/**
 * application-services-impl [9/6/2015 19:24:56]
 */
package org.ambar.appl.bo.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.ambar.appl.be.Cheque;
import org.ambar.appl.be.Compra;
import org.ambar.appl.be.DetallePago;
import org.ambar.appl.be.MovimientoCuentaCorrienteProveedor;
import org.ambar.appl.be.Pago;
import org.ambar.appl.bo.MovimientoCuentaCorrienteProveedorBO;
import org.ambar.appl.bo.PagoBO;
import org.ambar.appl.commons.enums.EstadoPagoFacturaValues;
import org.ambar.core.bo.impl.CrudBusinessObjectImpl;
import org.ambar.core.commons.context.RequestContext;
import org.ambar.core.exceptions.BusinessException;
import org.ambar.core.validation.configuration.Validation;
import org.ambar.core.validation.configuration.ValidationStrategy;
import org.ambar.core.validation.configuration.Validations;

/**
 * <p>
 * Implementación por default de {@link PagoBO}.
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
public class PagoBOImpl extends CrudBusinessObjectImpl<Long, Pago> implements PagoBO {

	private MovimientoCuentaCorrienteProveedorBO movimientoCuentaCorrienteProveedorBO;

	/**
	 * @param pMovimientoCuentaCorrienteProveedorBO
	 * Establece el valor del atributo movimientoCuentaCorrienteProveedorBO.
	 */
	public void setMovimientoCuentaCorrienteProveedorBO(
			MovimientoCuentaCorrienteProveedorBO pMovimientoCuentaCorrienteProveedorBO) {
		movimientoCuentaCorrienteProveedorBO = pMovimientoCuentaCorrienteProveedorBO;
	}


	/* (non-JSDoc)
	 * @see org.ambar.core.bo.impl.CrudBusinessObjectImpl#
	 * insert(org.ambar.core.be.Persistible, java.util.List, org.ambar.core.commons.context.RequestContext)
	 */
	@Override
	public void insert(Pago pPago, List<String> pWarnings, RequestContext pRequestContext)
		   throws BusinessException {
		this.agregarMovimiento(pPago, pWarnings, pRequestContext);
		this.actualizarMontoCompras(pPago, pWarnings, pRequestContext);
		super.insert(pPago, pWarnings, pRequestContext);
	}

	/* (non-JSDoc)
	 * @see org.ambar.core.bo.impl.CrudBusinessObjectImpl#
	 * remove(org.ambar.core.be.Persistible, java.util.List, org.ambar.core.commons.context.RequestContext)
	 */
	@Override
	public void remove(Pago pPago, List<String> pWarnings, RequestContext pRequestContext)
		   throws BusinessException {
		this.eliminarMovimiento(pPago, pWarnings, pRequestContext);
		this.cancelarMontoCompras(pPago, pWarnings, pRequestContext);
		super.remove(pPago, pWarnings, pRequestContext);
	}

	/* (non-JSDoc)
	 * @see org.ambar.core.bo.impl.CrudBusinessObjectImpl#
	 * update(org.ambar.core.be.Persistible, java.util.List, org.ambar.core.commons.context.RequestContext)
	 */
	@Override
	public void update(Pago pPago, List<String> pWarnings, RequestContext pRequestContext)
		   throws BusinessException {
		this.eliminarMovimiento(pPago, pWarnings, pRequestContext);
		this.agregarMovimiento(pPago, pWarnings, pRequestContext);
		this.cancelarMontoCompras(pPago, pWarnings, pRequestContext);
		this.actualizarMontoCompras(pPago, pWarnings, pRequestContext);
		super.update(pPago, pWarnings, pRequestContext);
	}

	private void agregarMovimiento(Pago pPago, List<String> pWarnings, RequestContext pRequestContext)
			throws BusinessException {

		MovimientoCuentaCorrienteProveedor movCtaCorriente = new MovimientoCuentaCorrienteProveedor();
		movCtaCorriente.setPago(pPago);
		movCtaCorriente.setDescripcion("PAGO");
		movCtaCorriente.setFecha(new Date());
		movCtaCorriente.setSaldo(pPago.getImporteTotal().negate());

		pPago.getProveedor().getCuentaCorriente().agregarMovimiento(movCtaCorriente);
	}

	private void eliminarMovimiento(Pago pPago, List<String> pWarnings, RequestContext pRequestContext)
			throws BusinessException {
		MovimientoCuentaCorrienteProveedor movimientoCuentaCorriente =
				pPago.getProveedor().getCuentaCorriente().getByPago(pPago);
		if (movimientoCuentaCorriente != null) {
			pPago.getProveedor().getCuentaCorriente().removerMovimiento(movimientoCuentaCorriente);
			this.movimientoCuentaCorrienteProveedorBO.remove(movimientoCuentaCorriente,
					                                         pWarnings,
					                                         pRequestContext);
		}
	}

	private void actualizarMontoCompras(Pago pPago, List<String> pWarnings, RequestContext pRequestContext) {
		for (DetallePago detCob : pPago.getColeccionDetallePago()) {
			Compra fac = detCob.getCompra();
			fac.setSaldo(fac.getSaldo().subtract(detCob.getMontoPagado()));
			if (fac.getSaldo().compareTo(BigDecimal.ZERO) == 0) {
				fac.setEstadoPago(EstadoPagoFacturaValues.PAGADA);
			} else {
				fac.setEstadoPago(EstadoPagoFacturaValues.PARCIAL);
			}
		}
	}

	private void cancelarMontoCompras(Pago pPago, List<String> pWarnings, RequestContext pRequestContext) {
		for (DetallePago detCob : pPago.getColeccionDetallePago()) {
			Compra fac = detCob.getCompra();
			fac.setSaldo(fac.getSaldo().add(detCob.getMontoPagado()));
			if (fac.getSaldo().compareTo(fac.getImporteTotal()) == 0) {
				fac.setEstadoPago(EstadoPagoFacturaValues.PENDIENTE);
			} else {
				fac.setEstadoPago(EstadoPagoFacturaValues.PARCIAL);
			}
		}
	}


	/* (non-JSDoc)
	 * @see org.ambar.appl.bo.PagoBO#guardarCobroContado(org.ambar.appl.be.Pago,
	 *  org.ambar.appl.be.Compra, java.util.List, org.ambar.core.commons.context.RequestContext)
	 */
	@Override
	public void guardarCobroContado(Pago pPago,
			                        Compra pCompra,
			                        List<String> pWarnings,
			                        RequestContext pRequestContext) throws BusinessException {
		//Agrega un detalle al Pago
		DetallePago detallePago = new DetallePago();
		detallePago.setCompra(pCompra);
		detallePago.setMontoPagado(pPago.getImporteTotal());
		detallePago.setSaldo(pCompra.getImporteTotal().subtract(pPago.getImporteTotal()));
		pPago.agregarDetallePago(detallePago);

		//Se asigna el Pago a todos los Cheques
		for (Cheque cheque : pPago.getColeccionCheques()) {
			cheque.setPago(pPago);
		}

		//Setea el cliente
		pPago.setProveedor(pCompra.getProveedor());

		//Si el importe pagado y el importe de la compra difieren,
		//se genera un movimiento en la cuenta corriente del proveedor
		if (pPago.getImporteTotal().compareTo(pCompra.getImporteTotal()) != 0) {
			//Agrega un movimiento a la cuenta corriente si es necesario
			MovimientoCuentaCorrienteProveedor movCtaCorriente = new MovimientoCuentaCorrienteProveedor();
			movCtaCorriente.setCompra(pCompra);
			movCtaCorriente.setPago(pPago);
			movCtaCorriente.setCuentaCorriente(pCompra.getProveedor().getCuentaCorriente());
			movCtaCorriente.setFecha(new Date());
			BigDecimal saldo = pCompra.getImporteTotal().subtract(pPago.getImporteTotal());
			//Si se pago mas del valor de compra
			if (pPago.getImporteTotal().compareTo(pCompra.getImporteTotal()) > 0) {
				pCompra.setEstadoPago(EstadoPagoFacturaValues.PAGADA);
				pCompra.setSaldo(BigDecimal.ZERO);
                movCtaCorriente.setSaldo(saldo);
				movCtaCorriente.setDescripcion("REMANENTE DE PAGO CONTADO");
			//Si se pago de menos del valor de compra
			} else {
				pCompra.setEstadoPago(EstadoPagoFacturaValues.PARCIAL);
				pCompra.setSaldo(pCompra.getImporteTotal().subtract(pPago.getImporteTotal()));
                movCtaCorriente.setSaldo(saldo);
				movCtaCorriente.setDescripcion("PENDIENTE DE PAGO CONTADO");
			}
			//Agrega el movimiento
			pPago.getProveedor().getCuentaCorriente().agregarMovimiento(movCtaCorriente);
		} else {
			pCompra.setSaldo(BigDecimal.ZERO);
		}

		//Inserta la cobranza
		super.insert(pPago, pWarnings, pRequestContext);
	}
}
