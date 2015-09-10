/**
 * 
 */
package org.ambar.appl.components.table.simple;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.table.AbstractTableModel;

import org.ambar.core.dictionary.domain.entities.DataType;
import org.apache.commons.beanutils.PropertyUtils;

/**
 * @author Sebastian
 *
 */
public class AmbarSimpleTableModel extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5462033567971797085L;

	private List<?> data;
	private Map<Integer, AmbarSimpleColumn> columns;
	
	public AmbarSimpleTableModel(Map<Integer, AmbarSimpleColumn> pColumns) {
		this.data = new ArrayList<Object>();
		this.columns = pColumns;
	}

	/**
	 * @param pData the data to set
	 */
	public void setData(List<?> pData) {
		this.data = pData;
		fireTableChanged(null); // notify everyone that we have a new table.
	}

	@Override
	public int getRowCount() {
		return data.size();
	}
	
	@Override
	public String getColumnName(int pIndex) {
		if (columns.containsKey(pIndex)) {
			return columns.get(pIndex).getField();
		} else {
			return String.valueOf(pIndex);
		}
		
	}

	@Override
	public int getColumnCount() {
		return columns.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		try {
			Object object = data.get(rowIndex);
			
			String property = columns.get(columnIndex).getField();

			Object value = PropertyUtils.getProperty(object, property);
			
			if (columns.get(columnIndex).getDataType().equals(DataType.DateTime)) {
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				String stringValue = sdf.format(value);
				return stringValue;
			}

			return value;
		} catch (Exception e) {
			return null;
		} 
	}


}
