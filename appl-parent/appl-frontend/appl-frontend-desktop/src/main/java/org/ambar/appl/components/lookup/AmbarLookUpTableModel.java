/**
 * appl-frontend-desktop [01/06/2012 18:35:20]
 */
package org.ambar.appl.components.lookup;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import org.ambar.core.dictionary.domain.entities.Entity;
import org.ambar.core.dto.DTO;

/**
 * <p>
 * Table model del LookUp.
 * </p>
 * @author Sebastian
 *
 */
public class AmbarLookUpTableModel extends AbstractTableModel {

	private static final long serialVersionUID = -6800695292511578460L;

	private List<DTO<Object>> data;
	private Entity entity;
	private String valueField;
	private String descField;

	/**
	 * Default constructor.
	 * */
	public AmbarLookUpTableModel() {
		this.data = new ArrayList<DTO<Object>>();
	}

	/**
	 * @return Retorna el valor del atributo data.
	 */
	public List<DTO<Object>> getData() {
		return data;
	}

	/**
	 * @param pData Establece el valor del atributo data.
	 */
	public void setData(List<DTO<Object>> pData, Entity pEntity) {
		data = pData;
		entity = pEntity;
		fireTableChanged(null); // notify everyone that we have a new table.
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

	@Override
	public String getColumnName(int pIndex) {
		return this.getEntity().getAttributes().get(pIndex).getId();
	}

	@Override
	public int getRowCount() {
		if (data != null) {
			return data.size();
		}
		return 0;
	}

	@Override
	public int getColumnCount() {
		if (this.getEntity() != null) {
			return this.getEntity().getAttributes().size();
		} else {
			return 0;
		}
		
	}

	@Override
	public Object getValueAt(int pRowIndex, int pColumnIndex) {
		DTO<Object> dto = getData().get(pRowIndex);

		Object value = null;
		try {
		    Class<?> c = dto.getClass();

		    String property = this.getEntity().getAttributes().get(pColumnIndex).getId();
		    
		    Field field = c.getDeclaredField(property);
		    field.setAccessible(true);

		    value = field.get(dto);
		} catch (Exception e) {
		}
		return value;
	}
}
