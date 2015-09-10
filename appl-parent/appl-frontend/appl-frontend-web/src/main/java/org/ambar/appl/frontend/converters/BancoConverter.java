/**
 * appl-frontend-web [11/6/2015 23:13:58]
 */
package org.ambar.appl.frontend.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.ambar.appl.dto.BancoDTO;
import org.ambar.appl.services.BancoServices;
import org.ambar.core.commons.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>Insertar descripción funcional.</p>
 * @author Sebastian
 * @see <<Insertar clases relacionadas>>
 */
@FacesConverter(value = "BancoConverter")
public class BancoConverter implements Converter {

	@Autowired
	private BancoServices bancoServices;

	@Autowired
	private RequestContext requestContext;

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

	@Override
	public Object getAsObject(FacesContext pContext, UIComponent pComponent, String pValue) {
		if (pValue.trim().equals("")) {
            return null;
        } else {
        		BancoDTO banco = bancoServices.getById(pValue, this.requestContext).getResult();
        		return banco.getId();
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
}
