/**
 * appl-clientes-domain [28/02/2012 17:48:00]
 */
package org.ambar.appl.commons.enums;

import org.ambar.core.enums.EnumType;


/**
 * <p>
 * Representa el Tipo Documento de un Cliente.
 * </p>
 *
 * @author Sebastian
 *
 */
public enum TipoDocumentoValues implements EnumType {
	DNI("DNI", "DNI"),
	CUIT("CUIT", "CUIT"),
	CUIL("CUIL", "CUIL");

	private String valor;
	private String descripcion;

	/**
	 * Constructor default.
	 * @param pValor Valor del Enum
	 * @param pDescripcion Descripcion del Enum
	 * */
	TipoDocumentoValues(String pValor, String pDescripcion) {
		this.valor = pValor;
		this.descripcion = pDescripcion;
	}

	@Override
	public String getValor() {
		return valor;
	}

	@Override
	public String getDescripcion() {
		return descripcion;
	}
}
