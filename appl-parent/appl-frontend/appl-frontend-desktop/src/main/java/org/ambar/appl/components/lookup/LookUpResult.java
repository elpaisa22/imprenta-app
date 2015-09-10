/**
 * appl-frontend-desktop [01/06/2012 21:00:40]
 */
package org.ambar.appl.components.lookup;

import java.io.Serializable;

/**
 * <p>
 * Objeto que representa el resultado de un LookUp.
 * </p>
 * @author Sebastian
 *
 */
public class LookUpResult implements Serializable {

	private static final long serialVersionUID = 6311419095540144770L;

	private String value;
	private String description;
	/**
	 * @return Retorna el valor del atributo value.
	 */
	public String getValue() {
		return value;
	}
	/**
	 * @param pValue Establece el valor del atributo value.
	 */
	public void setValue(String pValue) {
		value = pValue;
	}
	/**
	 * @return Retorna el valor del atributo description.
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param pDescription Establece el valor del atributo Description.
	 */
	public void setDescription(String pDescription) {
		description = pDescription;
	}
}
