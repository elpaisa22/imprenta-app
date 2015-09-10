/**
 * appl-frontend-web [07/03/2013 17:40:58]
 */
package org.ambar.appl.frontend.beans.autocomplete;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.ambar.appl.dto.ChequeDTO;
import org.ambar.appl.services.ChequeServices;
import org.ambar.core.commons.context.RequestContext;

/**
 * <p>
 * Autocomplete para los cheques.
 * </p>
 *
 * @author Sebastian
 *
 */
public class AutoCompleteChequeBean implements Serializable, Converter {

	private static final long serialVersionUID = 678152461709147699L;

	private ChequeServices chequeServices;

	private RequestContext requestContext;

	private List<ChequeDTO> cheques = null;

	private ChequeDTO chequeSelected;

	/**
	 * @return Retorna el valor del atributo chequeServices.
	 */
	public ChequeServices getChequeServices() {
		return chequeServices;
	}

	/**
	 * @param pChequeServices Establece el valor del atributo chequeServices.
	 */
	public void setChequeServices(ChequeServices pChequeServices) {
		chequeServices = pChequeServices;
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
	 * @return Retorna el valor del atributo cheques.
	 */
	public List<ChequeDTO> getCheques() {
		return cheques;
	}

	/**
	 * @param pCheques Establece el valor del atributo cheques.
	 */
	public void setCheques(List<ChequeDTO> pCheques) {
		cheques = pCheques;
	}

	/**
	 * @return Retorna el valor del atributo chequeSelected.
	 */
	public ChequeDTO getChequeSelected() {
		return chequeSelected;
	}

	/**
	 * @param pChequeSelected Establece el valor del atributo chequeSelected.
	 */
	public void setChequeSelected(ChequeDTO pChequeSelected) {
		chequeSelected = pChequeSelected;
	}

	/**
	 *	Completa el cheque de acuerdo a un String.
	 *	@param pQuery Query String
	 *	@return {@link List} Cheques
	 **/
	public List<ChequeDTO> completeCheque(String pQuery) {

		cheques = chequeServices.getFilteredList(null, this.requestContext).getResultList();

        List<ChequeDTO> suggestions = new ArrayList<ChequeDTO>();

        for (ChequeDTO c : cheques) {
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
        		Long number = Long.valueOf(pValue);
        		ChequeDTO cheque = chequeServices.getById(number, this.requestContext).getResult();
        		return cheque;
        }
	}

	@Override
	public String getAsString(FacesContext pContext, UIComponent pComponent, Object pValue) {
		if (pValue == null || pValue.equals("")) {
            return "";
        } else {
            return String.valueOf(((ChequeDTO) pValue).getId());
        }
	}

	/**
	 * Obtiene el ID del cheque seleccionado.
	 * @return {@link Long} ID del elemento seleccionado
	 * */
	public Long getIdFromSelected() {
		if (this.getChequeSelected() != null) {
			return this.getChequeSelected().getId();
		}
		return null;
	}

	/**
	 * Carga el item seleccionado a partir del ID.
	 * @param pId ID del elemento
	 * */
	public void loadFromId(Long pId) {
		if (pId == null) {
			this.chequeSelected = null;
		} else {
			this.chequeSelected = this.chequeServices.getById(pId, this.requestContext).getResult();
		}
	}
}
