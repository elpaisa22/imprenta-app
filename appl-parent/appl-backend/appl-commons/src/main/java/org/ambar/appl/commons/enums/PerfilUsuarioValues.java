/**
 * appl-commons [15 de may. de 2017 4:28:09 p. m.]
 */
package org.ambar.appl.commons.enums;

import org.ambar.core.enums.EnumType;

/**
 * <p>
 * Representan los perfiles de usuario.
 * </p>
 *
 * @author Sebastian
 *
 */
public enum PerfilUsuarioValues implements EnumType {
	ADMIN("ADMIN", "Administrador"),
	USER("USER", "Usuario");
	
	private String valor;
	private String descripcion;


	/**
	 * Constructor default.
	 * @param pValor Valor del Enum
	 * @param pDescripcion Descripcion del Enum
	 * */
	PerfilUsuarioValues(String pValor, String pDescripcion) {
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
