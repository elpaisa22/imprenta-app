/**
 * appl-frontend-desktop [01/06/2012 19:02:03]
 */
package org.ambar.appl.components.lookup;

import java.util.List;

import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.TableColumn;

import org.ambar.core.dictionary.domain.entities.Attribute;
import org.ambar.core.dictionary.domain.entities.Entity;

/**
 * <p>
 * Column Table Model del LookUp.
 * </p>
 *
 * @author Sebastian
 *
 */
public class AmbarLookUpColumnTableModel extends DefaultTableColumnModel {

	private static final long serialVersionUID = 7811186510954924302L;

	private String valueField;
	private String descField;
	private Entity entity;
	private List<String> visibleFiels;

	/**
	 * @return Retorna el valor del atributo valueField.
	 */
	public String getValueField() {
		return valueField;
	}

	/**
	 * @param pValueField Establece el valor del atributo valueField.
	 */
	public void setValueField(String pValueField) {
		valueField = pValueField;
	}

	/**
	 * @return Retorna el valor del atributo descField.
	 */
	public String getDescField() {
		return descField;
	}

	/**
	 * @param pDescField Establece el valor del atributo descField.
	 */
	public void setDescField(String pDescField) {
		descField = pDescField;
	}

	/**
	 * @return the entity
	 */
	public Entity getEntity() {
		return entity;
	}

	/**
	 * @param entity the entity to set
	 */
	public void setEntity(Entity entity) {
		this.entity = entity;
	}
	
	public void setVisibleFields(List<String> pVisibleFields) {
		this.visibleFiels = pVisibleFields;		
	}

	@Override
	public void addColumn(TableColumn pTableColumn) {		
			if (visibleFiels.contains(pTableColumn.getHeaderValue())) {
				super.addColumn(pTableColumn);
				
				Attribute property = this.getEntity().getAttributes().get(pTableColumn.getModelIndex());
				
				pTableColumn.setHeaderValue(property.getVisibleName());
				pTableColumn.setPreferredWidth(property.getWidth());
			}					
	}



}
