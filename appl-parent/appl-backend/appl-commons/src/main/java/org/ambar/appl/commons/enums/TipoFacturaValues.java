/**
 * appl-commons [26/05/2015 21:09:41]
 */
package org.ambar.appl.commons.enums;

import org.ambar.core.enums.EnumType;

/**
 * <p>
 * Tipos de Factura.
 * </p>
 *
 * @author Sebastian
 *
 */
public enum TipoFacturaValues implements EnumType {
	A("A", "Factura A"),
	B("B", "Factura B");

	private String valor;
	private String descripcion;


	/**
	 * Constructor default.
	 * @param pValor Valor del Enum
	 * @param pDescripcion Descripcion del Enum
	 * */
	TipoFacturaValues(String pValor, String pDescripcion) {
		this.valor = pValor;
		this.descripcion = pDescripcion;
	}

	/* (non-JSDoc)
	 * @see org.ambar.core.enums.EnumType#getValor()
	 */
	@Override
	public String getValor() {
		return this.valor;
	}

	/* (non-JSDoc)
	 * @see org.ambar.core.enums.EnumType#getDescripcion()
	 */
	@Override
	public String getDescripcion() {
		return this.descripcion;
	}
}
