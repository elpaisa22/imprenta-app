/**
 * appl-frontend-web [07/03/2013 17:46:53]
 */
package org.ambar.appl.frontend.beans.autocomplete;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.ambar.appl.dto.FacturaDTO;
import org.ambar.appl.services.FacturaServices;
import org.ambar.core.commons.context.RequestContext;

/**
 * <p>
 * Autocomplete para las facturas.
 * </p>
 *
 * @author Sebastian
 *
 */
public class AutoCompleteFacturaBean implements Serializable, Converter {

	private static final long serialVersionUID = 654418387912089178L;

	private FacturaServices facturaServices;

	private RequestContext requestContext;

	private List<FacturaDTO> facturas = null;

	private FacturaDTO facturaSelected;

	/**
	 * @return Retorna el valor del atributo facturaServices.
	 */
	public FacturaServices getFacturaServices() {
		return facturaServices;
	}

	/**
	 * @param pFacturaServices Establece el valor del atributo facturaServices.
	 */
	public void setFacturaServices(FacturaServices pFacturaServices) {
		facturaServices = pFacturaServices;
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
	 * @return Retorna el valor del atributo facturas.
	 */
	public List<FacturaDTO> getFacturas() {
		return facturas;
	}

	/**
	 * @param pFacturas Establece el valor del atributo facturas.
	 */
	public void setFacturas(List<FacturaDTO> pFacturas) {
		facturas = pFacturas;
	}

	/**
	 * @return Retorna el valor del atributo facturaSelected.
	 */
	public FacturaDTO getFacturaSelected() {
		return facturaSelected;
	}

	/**
	 * @param pFacturaSelected Establece el valor del atributo facturaSelected.
	 */
	public void setFacturaSelected(FacturaDTO pFacturaSelected) {
		facturaSelected = pFacturaSelected;
	}

	/**
	 *	Completa el factura de acuerdo a un String.
	 *	@param pQuery Query String
	 *	@return {@link List} Facturas
	 **/
	public List<FacturaDTO> completeFactura(String pQuery) {

		facturas = facturaServices.getFilteredList(null, this.requestContext).getResultList();

        List<FacturaDTO> suggestions = new ArrayList<FacturaDTO>();

        for (FacturaDTO c : facturas) {
            if ((pQuery != null)
            		&&
            		(c.getId().toString().toUpperCase().contains(pQuery.toUpperCase()))
            		|| (c.getRazonSocialCliente().toString().toUpperCase().contains(pQuery.toUpperCase()))) {
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
            Long number = Long.valueOf(pValue);
            FacturaDTO factura = facturaServices.getById(number, this.requestContext).getResult();
            return factura;
       }

	}

	@Override
	public String getAsString(FacesContext pContext, UIComponent pComponent, Object pValue) {
		if (pValue == null || pValue.equals("")) {
            return "";
        } else {
            return String.valueOf(((FacturaDTO) pValue).getId());
        }
	}

	/**
	 * Obtiene el ID de la factura seleccionado.
	 * @return {@link Long} ID del elemento seleccionado
	 * */
	public Long getIdFromSelected() {
		if (this.getFacturaSelected() != null) {
			return this.getFacturaSelected().getId();
		}
		return null;
	}

	/**
	 * Carga el item seleccionado a partir del ID.
	 * @param pId ID del elemento
	 * */
	public void loadFromId(Long pId) {
		if (pId == null) {
			this.facturaSelected = null;
		} else {
			this.facturaSelected = this.facturaServices.getById(pId, this.requestContext).getResult();
		}
	}
}

