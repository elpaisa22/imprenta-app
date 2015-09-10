/**
 * appl-frontend-web [12/05/2012 17:44:57]
 */
package org.ambar.appl.frontend.beans.api;

import java.io.Serializable;

import javax.faces.convert.Converter;

/**
 * <p>
 * Model de una columns.
 * </p>
 *
 * @author Sebastian
 *
 */
public class ColumnModel implements Serializable {

	private static final long serialVersionUID = -8685245829305305137L;

	private String header;
    private String property;
    private Converter converter;

    /**
     * Constructor por default.
     * @param pHeader Header
     * @param pProperty Property
     * */
    public ColumnModel(String pHeader, String pProperty) {
        this.header = pHeader;
        this.property = pProperty;
    }

    /**
     * Obtiene el header.
     * @return {@link String} header
     * */
    public String getHeader() {
        return header;
    }

    /**
     * Obtiene la propiedad.
     * @return {@link String} Property
     * */
    public String getProperty() {
        return property;
    }

	/**
	 * @return Retorna el valor del atributo converter.
	 */
	public Converter getConverter() {
		return converter;
	}

	/**
	 * @param pConverter Establece el valor del atributo converter.
	 */
	public void setConverter(Converter pConverter) {
		converter = pConverter;
	}
}
