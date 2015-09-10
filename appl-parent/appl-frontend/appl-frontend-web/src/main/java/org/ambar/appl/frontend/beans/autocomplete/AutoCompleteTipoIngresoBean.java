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

import org.ambar.appl.dto.TipoIngresoDTO;
import org.ambar.appl.services.TipoIngresoServices;
import org.ambar.core.commons.context.RequestContext;

/**
 * <p>
 * Autocomplete para los Tipo Ingreso.
 * </p>
 *
 * @author Sebastian
 *
 */
public class AutoCompleteTipoIngresoBean implements Serializable, Converter {

	private static final long serialVersionUID = 678152461709147699L;

	private TipoIngresoServices tipoIngresoServices;

	private RequestContext requestContext;

	private List<TipoIngresoDTO> coleccionTipoIngreso = null;

	private TipoIngresoDTO tipoIngresoSelected;

	/**
	 * @return Retorna el valor del atributo tipoIngresoServices.
	 */
	public TipoIngresoServices getTipoIngresoServices() {
		return tipoIngresoServices;
	}

	/**
	 * @param pTipoIngresoServices Establece el valor del atributo tipoIngresoServices.
	 */
	public void setTipoIngresoServices(TipoIngresoServices pTipoIngresoServices) {
		tipoIngresoServices = pTipoIngresoServices;
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
	 * @return Retorna el valor del atributo coleccionTipoIngreso.
	 */
	public List<TipoIngresoDTO> getColeccionTipoIngreso() {
		return coleccionTipoIngreso;
	}

	/**
	 * @param pTipoIngreso Establece el valor del atributo coleccionTipoIngreso.
	 */
	public void setColeccionTipoIngreso(List<TipoIngresoDTO> pTipoIngreso) {
		coleccionTipoIngreso = pTipoIngreso;
	}

	/**
	 * @return Retorna el valor del atributo tipoIngresoSelected.
	 */
	public TipoIngresoDTO getTipoIngresoSelected() {
		return tipoIngresoSelected;
	}

	/**
	 * @param pTipoIngresoSelected Establece el valor del atributo tipoIngresoSelected.
	 */
	public void setTipoIngresoSelected(TipoIngresoDTO pTipoIngresoSelected) {
		tipoIngresoSelected = pTipoIngresoSelected;
	}

	/**
	 *	Completa el coleccionTipoIngreso de acuerdo a un String.
	 *	@param pQuery Query String
	 *	@return {@link List} TipoIngreso
	 **/
	public List<TipoIngresoDTO> completeTipoIngreso(String pQuery) {

		coleccionTipoIngreso =
				tipoIngresoServices.getFilteredList(null, this.requestContext).getResultList();

        List<TipoIngresoDTO> suggestions = new ArrayList<TipoIngresoDTO>();

        for (TipoIngresoDTO c : coleccionTipoIngreso) {
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
        		TipoIngresoDTO tipoIngreso =
        				tipoIngresoServices.getById(pValue, this.requestContext).getResult();

        		return tipoIngreso;
        }
	}

	@Override
	public String getAsString(FacesContext pContext, UIComponent pComponent, Object pValue) {
		if (pValue == null || pValue.equals("")) {
            return "";
        } else {
            return String.valueOf(((TipoIngresoDTO) pValue).getId());
        }
	}

	/**
	 * Carga el selected a partir del ID.
	 * @param pId ID a cargar en el selected
	 *
	 * */
	public void loadSelectedFromID(String pId) {
        this.tipoIngresoSelected = this.tipoIngresoServices.getById(pId, this.requestContext).getResult();
	}

	/**
	 * Obtiene el ID de la factura seleccionado.
	 * @return {@link Long} ID del elemento seleccionado
	 * */
	public String getIdFromSelected() {
		if (this.tipoIngresoSelected != null) {
			return this.tipoIngresoSelected.getId();
		}
		return null;
	}

	/**
	 * Carga el item seleccionado a partir del ID.
	 * @param pId ID del elemento
	 * */
	public void loadFromId(String pId) {
		if (pId == null) {
			this.tipoIngresoSelected = null;
		} else {
			this.tipoIngresoSelected =
					this.tipoIngresoServices.getById(pId, this.requestContext).getResult();
		}
	}
}
