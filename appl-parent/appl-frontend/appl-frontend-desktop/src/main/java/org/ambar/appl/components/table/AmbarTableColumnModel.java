/**
 *
 */
package org.ambar.appl.components.table;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.TableColumn;

import org.ambar.core.dictionary.domain.entities.Attribute;

/**
 * @author Sebastian
 *
 */
public class AmbarTableColumnModel extends DefaultTableColumnModel {

	/**
	 *
	 */
	private static final long serialVersionUID = -3684119451253129711L;

	private Map<String, Attribute> attributes = null;


	/**
	 * @param pAttributes Attributes
	 * */
	public void setAttributes(List<Attribute> pAttributes) {
		this.attributes = new HashMap<String, Attribute>();

		for (Attribute attribute : pAttributes) {
			this.attributes.put(attribute.getId().toUpperCase(), attribute);
		}
	}

	@Override
	public void addColumn(TableColumn pTableColumn) {
	  if (this.attributes.size() > 0) {

          Attribute attribute = this.attributes.get(((String) pTableColumn.getHeaderValue()).toUpperCase());

			if ((attribute != null)) {
				super.addColumn(pTableColumn);
				pTableColumn.setHeaderValue(attribute.getVisibleName());

				if (attribute.getWidth() != 0) {
					pTableColumn.setPreferredWidth(attribute.getWidth());
					pTableColumn.setResizable(true);
				}
			}
	  }
	}

}
