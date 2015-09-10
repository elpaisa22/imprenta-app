/**
 * appl-frontend-web [23/05/2015 16:40:22]
 */
package org.ambar.appl.frontend.beans.autocomplete;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.ambar.appl.dto.ProveedorDTO;
import org.ambar.appl.services.ProveedorServices;
import org.ambar.core.commons.context.RequestContext;

/**
 * <p>
 * Autocomplete para los proveedors.
 * </p>
 *
 * @author Sebastian
 *
 */
public class AutoCompleteProveedorBean implements Serializable, Converter {

	private static final long serialVersionUID = -2687379743995302633L;

	private ProveedorServices proveedorServices;

	private RequestContext requestContext;

	private List<ProveedorDTO> proveedors = null;

	private ProveedorDTO proveedorSelected;

	/**
	 * @return Retorna el valor del atributo proveedorServices.
	 */
	public ProveedorServices getProveedorServices() {
		return proveedorServices;
	}

	/**
	 * @param pProveedorServices Establece el valor del atributo proveedorServices.
	 */
	public void setProveedorServices(ProveedorServices pProveedorServices) {
		proveedorServices = pProveedorServices;
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
	 * @return Retorna el valor del atributo proveedors.
	 */
	public List<ProveedorDTO> getProveedors() {
		return proveedors;
	}

	/**
	 * @param pProveedors Establece el valor del atributo proveedors.
	 */
	public void setProveedors(List<ProveedorDTO> pProveedors) {
		proveedors = pProveedors;
	}

	/**
	 * @return Retorna el valor del atributo proveedorSelected.
	 */
	public ProveedorDTO getProveedorSelected() {
		return proveedorSelected;
	}

	/**
	 * @param pProveedorSelected Establece el valor del atributo proveedorSelected.
	 */
	public void setProveedorSelected(ProveedorDTO pProveedorSelected) {
		proveedorSelected = pProveedorSelected;
	}

	/**
	 *	Completa el proveedor de acuerdo a un String.
	 *	@param pQuery Query String
	 *	@return {@link List} Proveedors
	 **/
	public List<ProveedorDTO> completeProveedor(String pQuery) {

		proveedors = proveedorServices.getFilteredList(null, this.requestContext).getResultList();

        List<ProveedorDTO> suggestions = new ArrayList<ProveedorDTO>();

        for (ProveedorDTO c : proveedors) {
            if (pQuery != null
            	&&
            	(c.getRazonSocial().toUpperCase().contains(pQuery.toUpperCase()))
                || (c.getCuit().toUpperCase().contains(pQuery.toUpperCase()))
                || (c.getId().toString().toUpperCase().contains(pQuery.toUpperCase()))) {
            	suggestions.add(c);
            }
        }

        return suggestions;
    }

	@Override
	public Object getAsObject(FacesContext pContext, UIComponent pComponent, String pValue) {
		if (pValue.trim().equals("") || !pValue.matches("\\d+")) {
            return null;
        } else {
            Long number = Long.valueOf(pValue);
            ProveedorDTO proveedor = proveedorServices.getById(number, this.requestContext).getResult();
            return proveedor;
        }

	}

	@Override
	public String getAsString(FacesContext pContext, UIComponent pComponent, Object pValue) {
		if (pValue == null || pValue.equals("")) {
            return "";
        } else {
            return String.valueOf(((ProveedorDTO) pValue).getId());
        }
	}

	/**
	 * Obtiene el ID del proveedor seleccionado.
	 * @return {@link Long} ID del elemento seleccionado
	 * */
	public Long getIdFromSelected() {
		if (this.getProveedorSelected() != null) {
			return this.getProveedorSelected().getId();
		}
		return null;
	}

	/**
	 * Carga el item seleccionado a partir del ID.
	 * @param pId ID del elemento
	 * */
	public void loadFromId(Long pId) {
		if (pId == null) {
			this.proveedorSelected = null;
		} else {
			this.proveedorSelected = this.proveedorServices.getById(pId, this.requestContext).getResult();
		}
	}
}

