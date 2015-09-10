/**
 * appl-frontend-web [25/08/2014 22:34:58]
 */
package org.ambar.appl.frontend.beans.impl;

import java.io.Serializable;

import org.ambar.core.commons.filters.Filter;
import org.primefaces.component.datatable.DataTable;

/**
 * <p>Insertar descripción funcional.</p>
 * @author Sebastian
 * @see <<Insertar clases relacionadas>>
 */
public class DataTableContext implements Serializable {
	
	private static final long serialVersionUID = 8258212702278843612L;

	private Filter previousFilter;
	private DataTable dataTable;
	private String searchText;

	/**
	 * @return Retorna el valor del atributo previousFilter.
	 */
	public Filter getPreviousFilter() {
		return previousFilter;
	}
	/**
	 * @param pPreviousFilter Establece el valor del atributo previousFilter.
	 */
	public void setPreviousFilter(Filter pPreviousFilter) {
		previousFilter = pPreviousFilter;
	}
	/**
	 * @return Retorna el valor del atributo dataTable.
	 */
	public DataTable getDataTable() {
		return dataTable;
	}
	/**
	 * @param pDataTable Establece el valor del atributo dataTable.
	 */
	public void setDataTable(DataTable pDataTable) {
		dataTable = pDataTable;
	}
	/**
	 * @return Retorna el valor del atributo searchText.
	 */
	public String getSearchText() {
		return searchText;
	}
	/**
	 * @param pSearchText Establece el valor del atributo searchText.
	 */
	public void setSearchText(String pSearchText) {
		searchText = pSearchText;
	}
	
}
