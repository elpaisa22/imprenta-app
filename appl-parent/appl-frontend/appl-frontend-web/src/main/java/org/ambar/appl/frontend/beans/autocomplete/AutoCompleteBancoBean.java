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

import org.ambar.appl.dto.BancoDTO;
import org.ambar.appl.services.BancoServices;
import org.ambar.core.commons.context.RequestContext;

/**
 * <p>
 * Autocomplete para los Banco.
 * </p>
 *
 * @author Sebastian
 *
 */
public class AutoCompleteBancoBean implements Serializable, Converter {

	private static final long serialVersionUID = 678152461709147699L;

	private BancoServices bancoServices;

	private RequestContext requestContext;

	private List<BancoDTO> coleccionBanco = null;

	private BancoDTO bancoSelected;

	/**
	 * @return Retorna el valor del atributo bancoServices.
	 */
	public BancoServices getBancoServices() {
		return bancoServices;
	}

	/**
	 * @param pBancoServices Establece el valor del atributo bancoServices.
	 */
	public void setBancoServices(BancoServices pBancoServices) {
		bancoServices = pBancoServices;
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
	 * @return Retorna el valor del atributo coleccionBanco.
	 */
	public List<BancoDTO> getColeccionBanco() {
		return coleccionBanco;
	}

	/**
	 * @param pBanco Establece el valor del atributo coleccionBanco.
	 */
	public void setColeccionBanco(List<BancoDTO> pBanco) {
		coleccionBanco = pBanco;
	}

	/**
	 * @return Retorna el valor del atributo bancoSelected.
	 */
	public BancoDTO getBancoSelected() {
		return bancoSelected;
	}

	/**
	 * @param pBancoSelected Establece el valor del atributo bancoSelected.
	 */
	public void setBancoSelected(BancoDTO pBancoSelected) {
		bancoSelected = pBancoSelected;
	}

	/**
	 *	Completa el coleccionBanco de acuerdo a un String.
	 *	@param pQuery Query String
	 *	@return {@link List} Banco
	 **/
	public List<BancoDTO> completeBanco(String pQuery) {

		coleccionBanco =
				bancoServices.getFilteredList(null, this.requestContext).getResultList();

        List<BancoDTO> suggestions = new ArrayList<BancoDTO>();

        for (BancoDTO c : coleccionBanco) {
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
        		BancoDTO banco =
        				bancoServices.getById(pValue, this.requestContext).getResult();

        		return banco;
        }
	}

	@Override
	public String getAsString(FacesContext pContext, UIComponent pComponent, Object pValue) {
		if (pValue == null || pValue.equals("")) {
            return "";
        } else {
            return String.valueOf(((BancoDTO) pValue).getId());
        }
	}

	/**
	 * Carga el selected a partir del ID.
	 * @param pId ID a cargar en el selected
	 *
	 * */
	public void loadSelectedFromID(String pId) {
        this.bancoSelected = this.bancoServices.getById(pId, this.requestContext).getResult();
	}

	/**
	 * Obtiene el ID de la factura seleccionado.
	 * @return {@link Long} ID del elemento seleccionado
	 * */
	public String getIdFromSelected() {
		if (this.bancoSelected != null) {
			return this.bancoSelected.getId();
		}
		return null;
	}

	/**
	 * Carga el item seleccionado a partir del ID.
	 * @param pId ID del elemento
	 * */
	public void loadFromId(String pId) {
		if (pId == null) {
			this.bancoSelected = null;
		} else {
			this.bancoSelected =
					this.bancoServices.getById(pId, this.requestContext).getResult();
		}
	}
}
