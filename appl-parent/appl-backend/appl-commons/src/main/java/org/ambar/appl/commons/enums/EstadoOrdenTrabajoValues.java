/**
 * appl-commons [11/06/2012 17:40:53]
 */
package org.ambar.appl.commons.enums;

import org.ambar.core.enums.EnumType;

/**
 * <p>
 * Representa el estado de la orden de trabajo.
 * </p>
 *
 * @author Sebastian
 *
 */
public enum EstadoOrdenTrabajoValues implements EnumType {
	EMITIDA("EMITIDA", "Emitida"),
	LISTADA("LISTADA", "Listada"),
	COMPLETADA("COMPLETADA", "Completada"),
	REMITIDA("REMITIDA", "Remitida"),
	FACTURADA("FACTURADA", "Facturada");

	private String valor;
	private String descripcion;

	/**
	 * Constructor default.
	 * @param pValor Valor del Enum
	 * @param pDescripcion Descripcion del Enum
	 * */
	EstadoOrdenTrabajoValues(String pValor, String pDescripcion) {
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
