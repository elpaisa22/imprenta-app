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

import org.ambar.appl.dto.MarcaDTO;
import org.ambar.appl.services.MarcaServices;
import org.ambar.core.commons.context.RequestContext;

/**
 * <p>
 * Autocomplete para los Marca.
 * </p>
 *
 * @author Sebastian
 *
 */
public class AutoCompleteMarcaBean implements Serializable, Converter {

	private static final long serialVersionUID = 678152461709147699L;

	private MarcaServices marcaServices;

	private RequestContext requestContext;

	private List<MarcaDTO> coleccionMarca = null;

	private MarcaDTO marcaSelected;

	/**
	 * @return Retorna el valor del atributo marcaServices.
	 */
	public MarcaServices getMarcaServices() {
		return marcaServices;
	}

	/**
	 * @param pMarcaServices Establece el valor del atributo marcaServices.
	 */
	public void setMarcaServices(MarcaServices pMarcaServices) {
		marcaServices = pMarcaServices;
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
	 * @return Retorna el valor del atributo coleccionMarca.
	 */
	public List<MarcaDTO> getColeccionMarca() {
		return coleccionMarca;
	}

	/**
	 * @param pMarca Establece el valor del atributo coleccionMarca.
	 */
	public void setColeccionMarca(List<MarcaDTO> pMarca) {
		coleccionMarca = pMarca;
	}

	/**
	 * @return Retorna el valor del atributo marcaSelected.
	 */
	public MarcaDTO getMarcaSelected() {
		return marcaSelected;
	}

	/**
	 * @param pMarcaSelected Establece el valor del atributo marcaSelected.
	 */
	public void setMarcaSelected(MarcaDTO pMarcaSelected) {
		marcaSelected = pMarcaSelected;
	}

	/**
	 *	Completa el coleccionMarca de acuerdo a un String.
	 *	@param pQuery Query String
	 *	@return {@link List} Marca
	 **/
	public List<MarcaDTO> completeMarca(String pQuery) {

		coleccionMarca =
				marcaServices.getFilteredList(null, this.requestContext).getResultList();

        List<MarcaDTO> suggestions = new ArrayList<MarcaDTO>();

        for (MarcaDTO c : coleccionMarca) {
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
        		MarcaDTO marca =
        				marcaServices.getById(pValue, this.requestContext).getResult();

        		return marca;
        }
	}

	@Override
	public String getAsString(FacesContext pContext, UIComponent pComponent, Object pValue) {
		if (pValue == null || pValue.equals("")) {
            return "";
        } else {
            return String.valueOf(((MarcaDTO) pValue).getId());
        }
	}

	/**
	 * Carga el selected a partir del ID.
	 * @param pId ID a cargar en el selected
	 *
	 * */
	public void loadSelectedFromID(String pId) {
        this.marcaSelected = this.marcaServices.getById(pId, this.requestContext).getResult();
	}

	/**
	 * Obtiene el ID de la factura seleccionado.
	 * @return {@link Long} ID del elemento seleccionado
	 * */
	public String getIdFromSelected() {
		if (this.marcaSelected != null) {
			return this.marcaSelected.getId();
		}
		return null;
	}

	/**
	 * Carga el item seleccionado a partir del ID.
	 * @param pId ID del elemento
	 * */
	public void loadFromId(String pId) {
		if (pId == null) {
			this.marcaSelected = null;
		} else {
			this.marcaSelected =
					this.marcaServices.getById(pId, this.requestContext).getResult();
		}
	}
}
