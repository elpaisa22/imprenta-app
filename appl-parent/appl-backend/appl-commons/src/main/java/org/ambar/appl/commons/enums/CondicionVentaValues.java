/**
 * appl-commons [21/08/2012 00:53:26]
 */
package org.ambar.appl.commons.enums;

import org.ambar.core.enums.EnumType;

/**
 * <p>
 * Condiciones de Venta.
 * </p>
 *
 * @author Sebastian
 *
 */
public enum CondicionVentaValues implements EnumType {
	CONTADO("CONTADO", "Contado"),
	CUENTA_CORRIENTE("CUENTA_CORRIENTE", "Cuenta Corriente");

	private String valor;
	private String descripcion;


	/**
	 * Constructor default.
	 * @param pValor Valor del Enum
	 * @param pDescripcion Descripcion del Enum
	 * */
	CondicionVentaValues(String pValor, String pDescripcion) {
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
