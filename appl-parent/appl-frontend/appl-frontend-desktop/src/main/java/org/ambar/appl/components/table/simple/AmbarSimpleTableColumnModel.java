/**
 * 
 */
package org.ambar.appl.components.table.simple;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.TableColumn;

/**
 * @author Sebastian
 *
 */
public class AmbarSimpleTableColumnModel extends DefaultTableColumnModel {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6002218586387275195L;
	
	private Map<Integer, AmbarSimpleColumn> columns;
	
	public AmbarSimpleTableColumnModel(Map<Integer, AmbarSimpleColumn> pColumns) {
		this.columns = pColumns;
	}
	
	@Override
	public void addColumn(TableColumn aColumn) {
		
		AmbarSimpleColumn column = getColumnByName(aColumn.getHeaderValue().toString());
		
		if (column != null) {
			super.addColumn(aColumn);
			aColumn.setHeaderValue(column.getHeaderText());
			aColumn.setPreferredWidth(column.getWidth());
		}		
		
	}

	private AmbarSimpleColumn getColumnByName(String string) {
		
		Collection<AmbarSimpleColumn> values = this.columns.values();
		Iterator<AmbarSimpleColumn> iterator = values.iterator();
		while (iterator.hasNext()) {
			AmbarSimpleColumn elem = iterator.next();
			if (elem.getField().equals(string)) {
				return elem;
			}
		}
		
		return null;
	}

}
