/**
 * appl-frontend-desktop [09/06/2012 20:38:32]
 */
package org.ambar.appl.components.breadcrumb;

import org.ambar.core.commons.filters.Filter;

/**
 * <p>Insertar descripción funcional.</p>
 * @author Sebastian
 * @see <<Insertar clases relacionadas>>
 */
public class BreadCrumbNavigationItem {

	private Filter filterCondition;
	private String idEntity;
	private Integer selectedIndex;
	/**
	 * @return Retorna el valor del atributo filterCondition.
	 */
	public Filter getFilterCondition() {
		return filterCondition;
	}
	/**
	 * @param pFilterCondition Establece el valor del atributo filterCondition.
	 */
	public void setFilterCondition(Filter pFilterCondition) {
		filterCondition = pFilterCondition;
	}
	/**
	 * @return Retorna el valor del atributo idEntity.
	 */
	public String getIdEntity() {
		return idEntity;
	}
	/**
	 * @param pIdEntity Establece el valor del atributo idEntity.
	 */
	public void setIdEntity(String pIdEntity) {
		idEntity = pIdEntity;
	}
	/**
	 * @return Retorna el valor del atributo selectedIndex.
	 */
	public Integer getSelectedIndex() {
		return selectedIndex;
	}
	/**
	 * @param pSelectedIndex Establece el valor del atributo selectedIndex.
	 */
	public void setSelectedIndex(Integer pSelectedIndex) {
		selectedIndex = pSelectedIndex;
	}

}
