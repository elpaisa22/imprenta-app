/**
 * appl-commons [16/08/2012 21:00:50]
 */
package org.ambar.appl.commons.enums;

import org.ambar.core.enums.EnumType;

/**
 * <p>
 * Representan los modos de pago.
 * </p>
 *
 * @author Sebastian
 *
 */
public enum ModoPagoValues implements EnumType {
	EFECTIVO("EFECTIVO", "Efectivo"),
	TARJETACREDITO("TARJETACREDITO", "Tarjeta de Crédito"),
	CHEQUE("CHEQUE", "Cheque"),
	TARJETADEBITO("TARJETADEBITO", "Tarjeta de Débito");

	private String valor;
	private String descripcion;


	/**
	 * Constructor default.
	 * @param pValor Valor del Enum
	 * @param pDescripcion Descripcion del Enum
	 * */
	ModoPagoValues(String pValor, String pDescripcion) {
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
