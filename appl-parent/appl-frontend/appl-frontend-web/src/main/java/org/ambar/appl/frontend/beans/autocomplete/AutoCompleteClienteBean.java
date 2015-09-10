/**
 * appl-frontend-web [11/08/2012 01:14:34]
 */
package org.ambar.appl.frontend.beans.autocomplete;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.ambar.appl.dto.ClienteDTO;
import org.ambar.appl.services.ClienteServices;
import org.ambar.core.commons.context.RequestContext;

/**
 * <p>
 * Autocomplete para los clientes.
 * </p>
 *
 * @author Sebastian
 *
 */
public class AutoCompleteClienteBean implements Serializable, Converter {

	private static final long serialVersionUID = -2687379743995302633L;

	private ClienteServices clienteServices;

	private RequestContext requestContext;

	private List<ClienteDTO> clientes = null;

	private ClienteDTO clienteSelected;

	/**
	 * @return Retorna el valor del atributo clienteServices.
	 */
	public ClienteServices getClienteServices() {
		return clienteServices;
	}

	/**
	 * @param pClienteServices Establece el valor del atributo clienteServices.
	 */
	public void setClienteServices(ClienteServices pClienteServices) {
		clienteServices = pClienteServices;
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
	 * @return Retorna el valor del atributo clientes.
	 */
	public List<ClienteDTO> getClientes() {
		return clientes;
	}

	/**
	 * @param pClientes Establece el valor del atributo clientes.
	 */
	public void setClientes(List<ClienteDTO> pClientes) {
		clientes = pClientes;
	}

	/**
	 * @return Retorna el valor del atributo clienteSelected.
	 */
	public ClienteDTO getClienteSelected() {
		return clienteSelected;
	}

	/**
	 * @param pClienteSelected Establece el valor del atributo clienteSelected.
	 */
	public void setClienteSelected(ClienteDTO pClienteSelected) {
		clienteSelected = pClienteSelected;
	}

	/**
	 *	Completa el cliente de acuerdo a un String.
	 *	@param pQuery Query String
	 *	@return {@link List} Clientes
	 **/
	public List<ClienteDTO> completeCliente(String pQuery) {

		clientes = clienteServices.getFilteredList(null, this.requestContext).getResultList();

        List<ClienteDTO> suggestions = new ArrayList<ClienteDTO>();

        for (ClienteDTO c : clientes) {
            if (pQuery != null
            	&&
            	(c.getRazonSocial().toUpperCase().contains(pQuery.toUpperCase()))
                || (c.getNumeroDocumento().toUpperCase().contains(pQuery.toUpperCase()))
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
            ClienteDTO cliente = clienteServices.getById(number, this.requestContext).getResult();
            return cliente;
        }

	}

	@Override
	public String getAsString(FacesContext pContext, UIComponent pComponent, Object pValue) {
		if (pValue == null || pValue.equals("")) {
            return "";
        } else {
            return String.valueOf(((ClienteDTO) pValue).getId());
        }
	}

	/**
	 * Obtiene el ID del cliente seleccionado.
	 * @return {@link Long} ID del elemento seleccionado
	 * */
	public Long getIdFromSelected() {
		if (this.getClienteSelected() != null) {
			return this.getClienteSelected().getId();
		}
		return null;
	}

	/**
	 * Carga el item seleccionado a partir del ID.
	 * @param pId ID del elemento
	 * */
	public void loadFromId(Long pId) {
		if (pId == null) {
			this.clienteSelected = null;
		} else {
			this.clienteSelected = this.clienteServices.getById(pId, this.requestContext).getResult();
		}
	}
}
