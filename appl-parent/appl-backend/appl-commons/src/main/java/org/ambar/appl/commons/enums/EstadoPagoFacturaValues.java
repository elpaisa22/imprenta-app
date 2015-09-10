/**
 * appl-commons [21/08/2012 01:23:57]
 */
package org.ambar.appl.commons.enums;

import org.ambar.core.enums.EnumType;

/**
 * <p>
 * Estado de Pago de la factura.
 * </p>
 *
 * @author Sebastian
 *
 *
 */
public enum EstadoPagoFacturaValues implements EnumType {
	PENDIENTE("PENDIENTE", "Pago Pendiente"),
	PARCIAL("PARCIAL", "Pago Parcial"),
	PAGADA("PAGADA", "Totalmente Pagada");

	private String valor;
	private String descripcion;

	/**
	 * Constructor default.
	 * @param pValor Valor del Enum
	 * @param pDescripcion Descripcion del Enum
	 * */
	EstadoPagoFacturaValues(String pValor, String pDescripcion) {
		this.valor = pValor;
		this.descripcion = pDescripcion;
	}

	@Override
	public String getValor() {
		return this.valor;
	}
	@Override
	public String getDescripcion() {
		return this.descripcion;
	}

}
