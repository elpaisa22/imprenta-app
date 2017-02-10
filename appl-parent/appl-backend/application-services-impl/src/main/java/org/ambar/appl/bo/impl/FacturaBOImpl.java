/**
 * application-services-impl [25/08/2012 13:29:51]
 */
package org.ambar.appl.bo.impl;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.ambar.appl.be.Factura;
import org.ambar.appl.be.MovimientoCuentaCorriente;
import org.ambar.appl.bo.CobranzaBO;
import org.ambar.appl.bo.FacturaBO;
import org.ambar.appl.bo.MovimientoCuentaCorrienteBO;
import org.ambar.appl.bo.NumeradorComprobanteBO;
import org.ambar.appl.commons.enums.CondicionVentaValues;
import org.ambar.appl.commons.enums.EstadoPagoFacturaValues;
import org.ambar.appl.commons.enums.TipoComprobanteValues;
import org.ambar.core.bo.impl.CrudBusinessObjectImpl;
import org.ambar.core.commons.context.RequestContext;
import org.ambar.core.exceptions.BusinessException;
import org.ambar.core.parameters.ParameterHelper;
import org.ambar.core.validation.configuration.Validation;
import org.ambar.core.validation.configuration.ValidationStrategy;
import org.ambar.core.validation.configuration.Validations;

/**
 * <p>
 * Implementación por default de {@link FacturaBO}.
 * </p>
 *
 * @author Sebastian
 *
 */
@Validations(
		validations = {
				@Validation(
						transactionNames = { "insert" },
						validators = { "applicationHibernateValidators",
								       "facturaUniqueIdValidator",
								       "facturaInsertUpdateValidator" }
						),
				@Validation(
						transactionNames = { "update" },
						validators = { "applicationHibernateValidators",
								       "facturaInsertUpdateValidator" })
		},
		strategy = ValidationStrategy.CONTINUE
)
public class FacturaBOImpl extends CrudBusinessObjectImpl<Long, Factura> implements FacturaBO {

	private MovimientoCuentaCorrienteBO movimientoCuentaCorrienteBO;
	private NumeradorComprobanteBO numeradorComprobanteBO;
	private CobranzaBO cobranzaBO;
	private ParameterHelper parameter;

	/**
	 * @param pMovimientoCuentaCorrienteBO Establece el valor del atributo movimientoCuentaCorrienteBO.
	 */
	public void setMovimientoCuentaCorrienteBO(MovimientoCuentaCorrienteBO pMovimientoCuentaCorrienteBO) {
		movimientoCuentaCorrienteBO = pMovimientoCuentaCorrienteBO;
	}

	/**
	 * @param pCobranzaBO Establece el valor del atributo cobranzaBO.
	 */
	public void setCobranzaBO(CobranzaBO pCobranzaBO) {
		cobranzaBO = pCobranzaBO;
	}

	/**
	 * @return Retorna el valor del atributo numeradorComprobanteBO.
	 */
	public NumeradorComprobanteBO getNumeradorComprobanteBO() {
		return numeradorComprobanteBO;
	}

	/**
	 * @param pNumeradorComprobanteBO Establece el valor del atributo numeradorComprobanteBO.
	 */
	public void setNumeradorComprobanteBO(NumeradorComprobanteBO pNumeradorComprobanteBO) {
		numeradorComprobanteBO = pNumeradorComprobanteBO;
	}


	/**
	 * @param pParameterHelper Establece el valor del atributo parameter.
	 */
	public void setParameter(ParameterHelper pParameterHelper) {
		parameter = pParameterHelper;
	}

	@Override
	public void insert(Factura pFactura,
			           List<String> pWarnings,
			           RequestContext pRequestContext) throws BusinessException {
		if (pFactura.getCondicionVenta().equals(CondicionVentaValues.CUENTA_CORRIENTE)) {
			pFactura.setEstadoPago(EstadoPagoFacturaValues.PENDIENTE);
			this.agregarMovimientoAFactura(pFactura, pWarnings, pRequestContext);
		}

		pFactura.setSaldo(pFactura.getImporteTotal());

		//Obtiene el ID si es necesario
		if (this.parameter.getBoolean("numeracion_automatica_factura", false)) {
			TipoComprobanteValues tipo = pFactura.getTipoComprobante();
			Long id = this.numeradorComprobanteBO.getNextNumber(tipo);
			pFactura.setId(id);
		}

		super.insert(pFactura, pWarnings, pRequestContext);

		//Si la factura fue cobrada al contado, agrega la cobranza
		if (pFactura.getCondicionVenta().equals(CondicionVentaValues.CONTADO)) {
			this.cobranzaBO.guardarCobroContado(pFactura.getCobranza(),
					                            pFactura,
					                            pWarnings, pRequestContext);
		}
	}

	@Override
	@Transactional
	public void remove(Factura pFactura,
			           List<String> pWarnings,
			           RequestContext pRequestContext) throws BusinessException {
		this.eliminarMovimiento(pFactura, pWarnings, pRequestContext);
		super.remove(pFactura, pWarnings, pRequestContext);
	}

	@Override
	public void update(Factura pFactura,
			           List<String> pWarnings,
			           RequestContext pRequestContext) throws BusinessException {
		this.eliminarMovimiento(pFactura, pWarnings, pRequestContext);
		if (pFactura.getCondicionVenta().equals(CondicionVentaValues.CUENTA_CORRIENTE)) {
			pFactura.setEstadoPago(EstadoPagoFacturaValues.PENDIENTE);
			this.agregarMovimientoAFactura(pFactura, pWarnings, pRequestContext);
		}

		pFactura.setSaldo(pFactura.getImporteTotal());
		super.update(pFactura, pWarnings, pRequestContext);

		//Si la factura fue cobrada al contado, agrega la cobranza
		if (pFactura.getCondicionVenta().equals(CondicionVentaValues.CONTADO)) {
			this.cobranzaBO.guardarCobroContado(pFactura.getCobranza(),
					                            pFactura,
					                            pWarnings, pRequestContext);
		}
	}

	/**
	 * Crea y agrega un movimiento a la factura.
	 * @param pFactura Factura
	 * @param pWarnings Warnings
	 * @param pRequestContext Request Context
	 * @throws BusinessException Excepciones de negocio
	 * */
	private void agregarMovimientoAFactura(Factura pFactura, List<String> pWarnings, RequestContext pRequestContext)
			throws BusinessException {

		MovimientoCuentaCorriente movCtaCorriente = new MovimientoCuentaCorriente();
		movCtaCorriente.setFactura(pFactura);
		movCtaCorriente.setDescripcion("VENTA");
		movCtaCorriente.setFecha(new Date());
		movCtaCorriente.setSaldo(pFactura.getCliente().getCuentaCorriente().getSaldo()
				                 .add(pFactura.getImporteTotal()));

		pFactura.getCliente().getCuentaCorriente().agregarMovimiento(movCtaCorriente);
	}

	/**
	 * Elimina un movimiento a la factura.
	 * @param pFactura Factura
	 * @param pWarnings Warnings
	 * @param pRequestContext Request Context
	 * @throws BusinessException Excepciones de negocio
	 * */
	private void eliminarMovimiento(Factura pFactura, List<String> pWarnings, RequestContext pRequestContext)
			throws BusinessException {
		MovimientoCuentaCorriente movimientoCuentaCorriente =  pFactura.getCliente()
				                                                        .getCuentaCorriente()
				                                                        .getByFactura(pFactura);
		if (movimientoCuentaCorriente != null) {
			pFactura.getCliente().getCuentaCorriente().removerMovimiento(movimientoCuentaCorriente);
			this.movimientoCuentaCorrienteBO.remove(movimientoCuentaCorriente, pWarnings, pRequestContext);
		}
	}
}
