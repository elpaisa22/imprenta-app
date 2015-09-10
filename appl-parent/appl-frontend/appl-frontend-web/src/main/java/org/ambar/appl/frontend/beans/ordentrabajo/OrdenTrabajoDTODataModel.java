/**
 * appl-frontend-web [06/09/2012 16:53:28]
 */
package org.ambar.appl.frontend.beans.ordentrabajo;

import java.io.Serializable;
import java.util.List;

import javax.faces.model.ListDataModel;

import org.ambar.appl.dto.OrdenTrabajoDTO;
import org.primefaces.model.SelectableDataModel;

/**
 * <p>
 * DataModel de la OrdenTrabajoDTO.
 * </p>
 * @author Sebastian
 *
 */
public class OrdenTrabajoDTODataModel
            extends ListDataModel<OrdenTrabajoDTO>
			implements Serializable, SelectableDataModel<OrdenTrabajoDTO> {

	private static final long serialVersionUID = 3111042629831391107L;

	/* (non-JSDoc)
	 * @see org.primefaces.model.SelectableDataModel#getRowKey(java.lang.Object)
	 */
	@Override
	public Object getRowKey(OrdenTrabajoDTO pObject) {
		return pObject.getId();
	}

	/* (non-JSDoc)
	 * @see org.primefaces.model.SelectableDataModel#getRowData(java.lang.String)
	 */
	@Override
	public OrdenTrabajoDTO getRowData(String pRowKey) {
		@SuppressWarnings("unchecked")
		List<OrdenTrabajoDTO> ordenTrabajoDTO = (List<OrdenTrabajoDTO>) getWrappedData();

        for (OrdenTrabajoDTO ot : ordenTrabajoDTO) {
            if (ot.getId().equals(pRowKey)) {
            	return ot;
            }
        }

        return null;
	}
}
