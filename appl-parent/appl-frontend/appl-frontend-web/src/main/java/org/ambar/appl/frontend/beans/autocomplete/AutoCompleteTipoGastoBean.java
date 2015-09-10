/**
 * appl-frontend-web [07/03/2014 17:08:00]
 */
package org.ambar.appl.frontend.beans.autocomplete;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.ambar.appl.dto.TipoGastoDTO;
import org.ambar.appl.services.TipoGastoServices;
import org.ambar.core.commons.context.RequestContext;

/**
 * <p>
 * Autocomplete para los Tipo Gasto.
 * </p>
 *
 * @author Sebastian
 *
 */
public class AutoCompleteTipoGastoBean implements Serializable, Converter {

	private static final long serialVersionUID = 678152461709147699L;

	private TipoGastoServices tipoGastoServices;

	private RequestContext requestContext;

	private List<TipoGastoDTO> coleccionTipoGasto = null;

	private TipoGastoDTO tipoGastoSelected;

	/**
	 * @return Retorna el valor del atributo tipoGastoServices.
	 */
	public TipoGastoServices getTipoGastoServices() {
		return tipoGastoServices;
	}

	/**
	 * @param pTipoGastoServices Establece el valor del atributo tipoGastoServices.
	 */
	public void setTipoGastoServices(TipoGastoServices pTipoGastoServices) {
		tipoGastoServices = pTipoGastoServices;
	}

	/**
	 * @return Retorna el valor del atributo requestContext.
	 */
	public RequestContext getRequestContext() {
		return requestContext;
	}

	/**
	 * @param pRequestContext Establece el valor del atributo requestContext.
	 */
	public void setRequestContext(RequestContext pRequestContext) {
		requestContext = pRequestContext;
	}

	/**
	 * @return Retorna el valor del atributo coleccionTipoGasto.
	 */
	public List<TipoGastoDTO> getColeccionTipoGasto() {
		return coleccionTipoGasto;
	}

	/**
	 * @param pTipoGasto Establece el valor del atributo coleccionTipoGasto.
	 */
	public void setColeccionTipoGasto(List<TipoGastoDTO> pTipoGasto) {
		coleccionTipoGasto = pTipoGasto;
	}

	/**
	 * @return Retorna el valor del atributo tipoGastoSelected.
	 */
	public TipoGastoDTO getTipoGastoSelected() {
		return tipoGastoSelected;
	}

	/**
	 * @param pTipoGastoSelected Establece el valor del atributo tipoGastoSelected.
	 */
	public void setTipoGastoSelected(TipoGastoDTO pTipoGastoSelected) {
		tipoGastoSelected = pTipoGastoSelected;
	}

	/**
	 *	Completa el coleccionTipoGasto de acuerdo a un String.
	 *	@param pQuery Query String
	 *	@return {@link List} TipoGasto
	 **/
	public List<TipoGastoDTO> completeTipoGasto(String pQuery) {

		coleccionTipoGasto =
				tipoGastoServices.getFilteredList(null, this.requestContext).getResultList();

        List<TipoGastoDTO> suggestions = new ArrayList<TipoGastoDTO>();

        for (TipoGastoDTO c : coleccionTipoGasto) {
            if (pQuery != null && c.getId().toString().toUpperCase().contains(pQuery.toUpperCase())) {
            	suggestions.add(c);
            }
        }

        return suggestions;
    }

	@Override
	public Object getAsObject(FacesContext pContext, UIComponent pComponent, String pValue) {
		if (pValue.trim().equals("")) {
            return null;
        } else {
        		TipoGastoDTO tipoGasto =
        				tipoGastoServices.getById(pValue, this.requestContext).getResult();

        		return tipoGasto;
        }
	}

	@Override
	public String getAsString(FacesContext pContext, UIComponent pComponent, Object pValue) {
		if (pValue == null || pValue.equals("")) {
            return "";
        } else {
            return String.valueOf(((TipoGastoDTO) pValue).getId());
        }
	}

	/**
	 * Carga el selected a partir del ID.
	 * @param pId ID a cargar en el selected
	 *
	 * */
	public void loadSelectedFromID(String pId) {
        this.tipoGastoSelected = this.tipoGastoServices.getById(pId, this.requestContext).getResult();
	}

	/**
	 * Obtiene el ID de la factura seleccionado.
	 * @return {@link Long} ID del elemento seleccionado
	 * */
	public String getIdFromSelected() {
		if (this.tipoGastoSelected != null) {
			return this.tipoGastoSelected.getId();
		}
		return null;
	}

	/**
	 * Carga el item seleccionado a partir del ID.
	 * @param pId ID del elemento
	 * */
	public void loadFromId(String pId) {
		if (pId == null) {
			this.tipoGastoSelected = null;
		} else {
			this.tipoGastoSelected =
					this.tipoGastoServices.getById(pId, this.requestContext).getResult();
		}
	}
}
