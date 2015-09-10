/**
 * 
 */
package org.ambar.appl.components.table.simple;

import org.ambar.core.dictionary.domain.entities.DataType;

/**
 * @author Sebastian
 *
 */
public class AmbarSimpleColumn {
	
	private String field;
	private String headerText;
	private Integer width;
	private DataType dataType;
	
	
	public AmbarSimpleColumn(String pField, String pHeaderText, Integer pWidth, DataType pDataType) {
		this.field = pField;
		this.headerText = pHeaderText;
		this.width = pWidth;
		this.dataType = pDataType;
	}
	
	/**
	 * @return the field
	 */
	public String getField() {
		return field;
	}
	/**
	 * @param field the field to set
	 */
	public void setField(String field) {
		this.field = field;
	}
	/**
	 * @return the headerText
	 */
	public String getHeaderText() {
		return headerText;
	}
	/**
	 * @param headerText the headerText to set
	 */
	public void setHeaderText(String headerText) {
		this.headerText = headerText;
	}
	/**
	 * @return the width
	 */
	public Integer getWidth() {
		return width;
	}
	/**
	 * @param width the width to set
	 */
	public void setWidth(Integer width) {
		this.width = width;
	}

	/**
	 * @return the dataType
	 */
	public DataType getDataType() {
		return dataType;
	}

	/**
	 * @param pDataType the dataType to set
	 */
	public void setDataType(DataType pDataType) {
		dataType = pDataType;
	}

}
