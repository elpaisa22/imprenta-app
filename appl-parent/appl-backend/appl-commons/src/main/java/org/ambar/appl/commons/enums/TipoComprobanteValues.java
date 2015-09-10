/**
 * appl-commons [10/6/2015 21:40:00]
 */
package org.ambar.appl.commons.enums;

import org.ambar.core.enums.EnumType;

/**
 * <p>
 * Tipos de Comprobantes.
 * </p>
 *
 * @author Sebastian
 *
 */
public enum TipoComprobanteValues implements EnumType {
	FACTURA_A("1", "Factura A"),
	FACTURA_B("6", "Factura B");

	private String valor;
	private String descripcion;


	/**
	 * Constructor default.
	 * @param pValor Valor del Enum
	 * @param pDescripcion Descripcion del Enum
	 * */
	TipoComprobanteValues(String pValor, String pDescripcion) {
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

	/**
	 * Retorna el valor para el String pString.
	 * @param pString Valor
	 * @return {@link TipoComprobanteValues} Tipo Comprobante
	 * */
	public static TipoComprobanteValues fromString(String pString) {
		if (FACTURA_A.valor.equals(pString)) {
			return FACTURA_A;
		} else if (FACTURA_B.valor.equals(pString)) {
			return FACTURA_B;
		}
		return null;
	}
}
