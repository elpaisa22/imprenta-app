/**
 * appl-frontend-web [23/05/2015 16:40:48]
 */
package org.ambar.appl.frontend.beans.autocomplete;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.ambar.appl.dto.PaisDTO;
import org.ambar.appl.services.PaisServices;
import org.ambar.core.commons.context.RequestContext;

/**
 * <p>
 * Autocomplete para los Pais.
 * </p>
 *
 * @author Sebastian
 *
 */
public class AutoCompletePaisBean implements Serializable, Converter {

	private static final long serialVersionUID = 678152461709147699L;

	private PaisServices paisServices;

	private RequestContext requestContext;

	private List<PaisDTO> coleccionPais = null;

	private PaisDTO paisSelected;

	/**
	 * @return Retorna el valor del atributo paisServices.
	 */
	public PaisServices getPaisServices() {
		return paisServices;
	}

	/**
	 * @param pPaisServices Establece el valor del atributo paisServices.
	 */
	public void setPaisServices(PaisServices pPaisServices) {
		paisServices = pPaisServices;
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
	 * @return Retorna el valor del atributo coleccionPais.
	 */
	public List<PaisDTO> getColeccionPais() {
		return coleccionPais;
	}

	/**
	 * @param pPais Establece el valor del atributo coleccionPais.
	 */
	public void setColeccionPais(List<PaisDTO> pPais) {
		coleccionPais = pPais;
	}

	/**
	 * @return Retorna el valor del atributo paisSelected.
	 */
	public PaisDTO getPaisSelected() {
		return paisSelected;
	}

	/**
	 * @param pPaisSelected Establece el valor del atributo paisSelected.
	 */
	public void setPaisSelected(PaisDTO pPaisSelected) {
		paisSelected = pPaisSelected;
	}

	/**
	 *	Completa el coleccionPais de acuerdo a un String.
	 *	@param pQuery Query String
	 *	@return {@link List} Pais
	 **/
	public List<PaisDTO> completePais(String pQuery) {

		coleccionPais =
				paisServices.getFilteredList(null, this.requestContext).getResultList();

        List<PaisDTO> suggestions = new ArrayList<PaisDTO>();

        for (PaisDTO c : coleccionPais) {
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
        		PaisDTO pais =
        				paisServices.getById(pValue, this.requestContext).getResult();

        		return pais;
        }
	}

	@Override
	public String getAsString(FacesContext pContext, UIComponent pComponent, Object pValue) {
		if (pValue == null || pValue.equals("")) {
            return "";
        } else {
            return String.valueOf(((PaisDTO) pValue).getId());
        }
	}

	/**
	 * Carga el selected a partir del ID.
	 * @param pId ID a cargar en el selected
	 *
	 * */
	public void loadSelectedFromID(String pId) {
        this.paisSelected = this.paisServices.getById(pId, this.requestContext).getResult();
	}

	/**
	 * Obtiene el ID de la factura seleccionado.
	 * @return {@link Long} ID del elemento seleccionado
	 * */
	public String getIdFromSelected() {
		if (this.paisSelected != null) {
			return this.paisSelected.getId();
		}
		return null;
	}

	/**
	 * Carga el item seleccionado a partir del ID.
	 * @param pId ID del elemento
	 * */
	public void loadFromId(String pId) {
		if (pId == null) {
			this.paisSelected = null;
		} else {
			this.paisSelected =
					this.paisServices.getById(pId, this.requestContext).getResult();
		}
	}
}
