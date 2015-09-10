/**
 * appl-frontend-web [17/03/2014 23:48:23]
 */
package org.ambar.appl.frontend.beans.autocomplete;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.ambar.appl.dto.ArticuloDTO;
import org.ambar.appl.services.ArticuloServices;
import org.ambar.core.commons.context.RequestContext;

/**
 * <p>
 * Autocomplete para los Articulos.
 * </p>
 *
 * @author Sebastian
 *
 */
public class AutoCompleteArticuloBean implements Serializable, Converter {

	private static final long serialVersionUID = 6606434917480916148L;

	private ArticuloServices articuloServices;

	private RequestContext requestContext;

	private List<ArticuloDTO> coleccionArticulo = null;

	private ArticuloDTO articuloSelected;

	/**
	 * @return Retorna el valor del atributo articuloServices.
	 */
	public ArticuloServices getArticuloServices() {
		return articuloServices;
	}

	/**
	 * @param pArticuloServices Establece el valor del atributo articuloServices.
	 */
	public void setArticuloServices(ArticuloServices pArticuloServices) {
		articuloServices = pArticuloServices;
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
	 * @return Retorna el valor del atributo coleccionArticulo.
	 */
	public List<ArticuloDTO> getColeccionArticulo() {
		return coleccionArticulo;
	}

	/**
	 * @param pArticulo Establece el valor del atributo coleccionArticulo.
	 */
	public void setColeccionArticulo(List<ArticuloDTO> pArticulo) {
		coleccionArticulo = pArticulo;
	}

	/**
	 * @return Retorna el valor del atributo articuloSelected.
	 */
	public ArticuloDTO getArticuloSelected() {
		return articuloSelected;
	}

	/**
	 * @param pArticuloSelected Establece el valor del atributo articuloSelected.
	 */
	public void setArticuloSelected(ArticuloDTO pArticuloSelected) {
		articuloSelected = pArticuloSelected;
	}

	/**
	 *	Completa el coleccionArticulo de acuerdo a un String.
	 *	@param pQuery Query String
	 *	@return {@link List} Articulo
	 **/
	public List<ArticuloDTO> completeArticulo(String pQuery) {

		coleccionArticulo =
				articuloServices.getFilteredList(null, this.requestContext).getResultList();

	    List<ArticuloDTO> suggestions = new ArrayList<ArticuloDTO>();

	    for (ArticuloDTO c : coleccionArticulo) {
	        if ((pQuery != null)
	        	&& ((c.getId().toString().toUpperCase().contains(pQuery.toUpperCase()))
	        	|| (c.getDescripcion().toString().toUpperCase().contains(pQuery.toUpperCase()))
	        	|| (c.getDescripcionMarca().toString().toUpperCase().contains(pQuery.toUpperCase())))) {
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
	    		ArticuloDTO articulo =
	    				articuloServices.getById(pValue, this.requestContext).getResult();

	    		return articulo;
	    }
	}

	@Override
	public String getAsString(FacesContext pContext, UIComponent pComponent, Object pValue) {
		if (pValue == null || pValue.equals("")) {
	        return "";
	    } else {
	        return String.valueOf(((ArticuloDTO) pValue).getId());
	    }
	}

	/**
	 * Carga el selected a partir del ID.
	 * @param pId ID a cargar en el selected
	 *
	 * */
	public void loadSelectedFromID(String pId) {
	    this.articuloSelected =
	    		this.articuloServices.getById(pId, this.requestContext).getResult();
	}

	/**
	 * Obtiene el ID de la factura seleccionado.
	 * @return {@link Long} ID del elemento seleccionado
	 * */
	public String getIdFromSelected() {
		if (this.articuloSelected != null) {
			return this.articuloSelected.getId();
		}
		return null;
	}

	/**
	 * Carga el item seleccionado a partir del ID.
	 * @param pId ID del elemento
	 * */
	public void loadFromId(String pId) {
		if (pId == null) {
			this.articuloSelected = null;
		} else {
			this.articuloSelected =
					this.articuloServices.getById(pId, this.requestContext).getResult();
		}
	}
}
