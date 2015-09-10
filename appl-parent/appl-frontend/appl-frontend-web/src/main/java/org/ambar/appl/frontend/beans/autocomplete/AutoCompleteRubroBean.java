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

import org.ambar.appl.dto.RubroDTO;
import org.ambar.appl.services.RubroServices;
import org.ambar.core.commons.context.RequestContext;

/**
 * <p>
 * Autocomplete para los Rubro.
 * </p>
 *
 * @author Sebastian
 *
 */
public class AutoCompleteRubroBean implements Serializable, Converter {

	private static final long serialVersionUID = 678152461709147699L;

	private RubroServices rubroServices;

	private RequestContext requestContext;

	private List<RubroDTO> coleccionRubro = null;

	private RubroDTO rubroSelected;

	/**
	 * @return Retorna el valor del atributo rubroServices.
	 */
	public RubroServices getRubroServices() {
		return rubroServices;
	}

	/**
	 * @param pRubroServices Establece el valor del atributo rubroServices.
	 */
	public void setRubroServices(RubroServices pRubroServices) {
		rubroServices = pRubroServices;
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
	 * @return Retorna el valor del atributo coleccionRubro.
	 */
	public List<RubroDTO> getColeccionRubro() {
		return coleccionRubro;
	}

	/**
	 * @param pRubro Establece el valor del atributo coleccionRubro.
	 */
	public void setColeccionRubro(List<RubroDTO> pRubro) {
		coleccionRubro = pRubro;
	}

	/**
	 * @return Retorna el valor del atributo rubroSelected.
	 */
	public RubroDTO getRubroSelected() {
		return rubroSelected;
	}

	/**
	 * @param pRubroSelected Establece el valor del atributo rubroSelected.
	 */
	public void setRubroSelected(RubroDTO pRubroSelected) {
		rubroSelected = pRubroSelected;
	}

	/**
	 *	Completa el coleccionRubro de acuerdo a un String.
	 *	@param pQuery Query String
	 *	@return {@link List} Rubro
	 **/
	public List<RubroDTO> completeRubro(String pQuery) {

		coleccionRubro =
				rubroServices.getFilteredList(null, this.requestContext).getResultList();

        List<RubroDTO> suggestions = new ArrayList<RubroDTO>();

        for (RubroDTO c : coleccionRubro) {
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
        		RubroDTO rubro =
        				rubroServices.getById(pValue, this.requestContext).getResult();

        		return rubro;
        }
	}

	@Override
	public String getAsString(FacesContext pContext, UIComponent pComponent, Object pValue) {
		if (pValue == null || pValue.equals("")) {
            return "";
        } else {
            return String.valueOf(((RubroDTO) pValue).getId());
        }
	}

	/**
	 * Carga el selected a partir del ID.
	 * @param pId ID a cargar en el selected
	 *
	 * */
	public void loadSelectedFromID(String pId) {
        this.rubroSelected = this.rubroServices.getById(pId, this.requestContext).getResult();
	}

	/**
	 * Obtiene el ID de la factura seleccionado.
	 * @return {@link Long} ID del elemento seleccionado
	 * */
	public String getIdFromSelected() {
		if (this.rubroSelected != null) {
			return this.rubroSelected.getId();
		}
		return null;
	}

	/**
	 * Carga el item seleccionado a partir del ID.
	 * @param pId ID del elemento
	 * */
	public void loadFromId(String pId) {
		if (pId == null) {
			this.rubroSelected = null;
		} else {
			this.rubroSelected =
					this.rubroServices.getById(pId, this.requestContext).getResult();
		}
	}
}
