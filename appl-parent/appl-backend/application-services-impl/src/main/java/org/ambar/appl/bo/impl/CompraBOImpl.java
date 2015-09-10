/**
 * application-services-impl [01/06/2015 18:16:33]
 */
package org.ambar.appl.bo.impl;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.ambar.appl.be.Compra;
import org.ambar.appl.be.MovimientoCuentaCorrienteProveedor;
import org.ambar.appl.bo.CompraBO;
import org.ambar.appl.bo.MovimientoCuentaCorrienteProveedorBO;
import org.ambar.appl.bo.PagoBO;
import org.ambar.appl.commons.enums.CondicionVentaValues;
import org.ambar.appl.commons.enums.EstadoPagoFacturaValues;
import org.ambar.core.bo.impl.CrudBusinessObjectImpl;
import org.ambar.core.commons.context.RequestContext;
import org.ambar.core.exceptions.BusinessException;
import org.ambar.core.validation.configuration.Validation;
import org.ambar.core.validation.configuration.ValidationStrategy;
import org.ambar.core.validation.configuration.Validations;

/**
 * <p>
 * Implementación por default de {@link CompraBO}.
 * </p>
 *
 * @author Sebastian
 *
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
public class CompraBOImpl extends CrudBusinessObjectImpl<Long, Compra> implements CompraBO {

	private MovimientoCuentaCorrienteProveedorBO movimientoCuentaCorrienteProveedorBO;
	private PagoBO pagoBO;

	/**
	 * @param pMovimientoCuentaCorrienteProveedorBO
	 * Establece el valor del atributo movimientoCuentaCorrienteProveedorBO.
	 */
	public void setMovimientoCuentaCorrienteProveedorBO(
			MovimientoCuentaCorrienteProveedorBO pMovimientoCuentaCorrienteProveedorBO) {
		movimientoCuentaCorrienteProveedorBO = pMovimientoCuentaCorrienteProveedorBO;
	}

	/**
	 * @param pPagoBO Establece el valor del atributo pagoBO.
	 */
	public void setPagoBO(PagoBO pPagoBO) {
		pagoBO = pPagoBO;
	}

	@Override
	public void insert(Compra pCompra,
			           List<String> pWarnings,
			           RequestContext pRequestContext) throws BusinessException {
		if (pCompra.getCondicionVenta().equals(CondicionVentaValues.CUENTA_CORRIENTE)) {
			pCompra.setEstadoPago(EstadoPagoFacturaValues.PENDIENTE);
			this.agregarMovimientoACompra(pCompra, pWarnings, pRequestContext);
		}

		pCompra.setSaldo(pCompra.getImporteTotal());
		super.insert(pCompra, pWarnings, pRequestContext);

		//Si la compra fue pagada al contado, agrega el pago
		if (pCompra.getCondicionVenta().equals(CondicionVentaValues.CONTADO)) {
			this.pagoBO.guardarCobroContado(pCompra.getPago(),
					                        pCompra,
					                        pWarnings, pRequestContext);
		}
	}

	@Override
	@Transactional
	public void remove(Compra pCompra,
			           List<String> pWarnings,
			           RequestContext pRequestContext) throws BusinessException {
		this.eliminarMovimiento(pCompra, pWarnings, pRequestContext);
		super.remove(pCompra, pWarnings, pRequestContext);
	}

	@Override
	public void update(Compra pCompra,
			           List<String> pWarnings,
			           RequestContext pRequestContext) throws BusinessException {
		this.eliminarMovimiento(pCompra, pWarnings, pRequestContext);
		if (pCompra.getCondicionVenta().equals(CondicionVentaValues.CUENTA_CORRIENTE)) {
			pCompra.setEstadoPago(EstadoPagoFacturaValues.PENDIENTE);
			this.agregarMovimientoACompra(pCompra, pWarnings, pRequestContext);
		}

		pCompra.setSaldo(pCompra.getImporteTotal());
		super.update(pCompra, pWarnings, pRequestContext);

		//Si la compra fue pagada al contado, agrega el pago
		if (pCompra.getCondicionVenta().equals(CondicionVentaValues.CONTADO)) {
			this.pagoBO.guardarCobroContado(pCompra.getPago(),
					                        pCompra,
					                        pWarnings, pRequestContext);
		}
	}

	/**
	 * Crea y agrega un movimiento a la factura.
	 * @param pCompra Compra
	 * @param pWarnings Warnings
	 * @param pRequestContext Request Context
	 * @throws BusinessException Excepciones de negocio
	 * */
	private void agregarMovimientoACompra(Compra pCompra, List<String> pWarnings, RequestContext pRequestContext)
			throws BusinessException {

		MovimientoCuentaCorrienteProveedor movCtaCorriente = new MovimientoCuentaCorrienteProveedor();
		movCtaCorriente.setCompra(pCompra);
		movCtaCorriente.setDescripcion("VENTA");
		movCtaCorriente.setFecha(new Date());
		movCtaCorriente.setSaldo(pCompra.getProveedor().getCuentaCorriente().getSaldo()
				                 .add(pCompra.getImporteTotal()));

		pCompra.getProveedor().getCuentaCorriente().agregarMovimiento(movCtaCorriente);
	}

	/**
	 * Elimina un movimiento a la factura.
	 * @param pCompra Compra
	 * @param pWarnings Warnings
	 * @param pRequestContext Request Context
	 * @throws BusinessException Excepciones de negocio
	 * */
	private void eliminarMovimiento(Compra pCompra, List<String> pWarnings, RequestContext pRequestContext)
			throws BusinessException {
		MovimientoCuentaCorrienteProveedor movimientoCuentaCorriente =  pCompra.getProveedor()
				                                                        .getCuentaCorriente()
				                                                        .getByCompra(pCompra);
		if (movimientoCuentaCorriente != null) {
			pCompra.getProveedor().getCuentaCorriente().removerMovimiento(movimientoCuentaCorriente);
			this.movimientoCuentaCorrienteProveedorBO.remove(movimientoCuentaCorriente,
					                                         pWarnings,
					                                         pRequestContext);
		}
	}
}
