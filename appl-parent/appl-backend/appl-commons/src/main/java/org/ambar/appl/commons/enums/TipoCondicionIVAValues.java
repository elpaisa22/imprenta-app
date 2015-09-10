/**
 * appl-commons [21/08/2012 00:43:09]
 */
package org.ambar.appl.commons.enums;

import org.ambar.core.enums.EnumType;

/**
 * <p>
 * Tipo de Condiciones de IVA.
 * </p>
 *
 * @author Sebastian
 *
 *
 */
public enum TipoCondicionIVAValues implements EnumType {
	RESPONSABLE_INSCRIPTO("1", "Responsable Inscripto"),
	RESPONSABLE_NOINSCRIPTO("2", "Responsable No Inscripto"),
	NO_RESPONSABLE("3", "No Responsable"),
	EXCENTO("4", "Excento"),
	CONSUMIDOR_FINAL("5", "Consumidor Final"),
	MONOTRIBUTISTA("6", "Monotributista"),
	NO_CATEGORIZADO("7", "No Categorizado");
	

	private String valor;
	private String descripcion;


	/**
	 * Constructor default.
	 * @param pValor Valor del Enum
	 * @param pDescripcion Descripcion del Enum
	 * */
	TipoCondicionIVAValues(String pValor, String pDescripcion) {
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
