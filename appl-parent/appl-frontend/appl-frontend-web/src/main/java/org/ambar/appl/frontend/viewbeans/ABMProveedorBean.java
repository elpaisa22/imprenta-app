/**
 * appl-frontend-web [26/05/2015 20:01:49]
 */
package org.ambar.appl.frontend.viewbeans;

import java.io.Serializable;
import java.util.List;

import javax.faces.event.ValueChangeEvent;

import org.ambar.appl.dto.PaisDTO;
import org.ambar.appl.dto.ProveedorDTO;
import org.ambar.appl.dto.ProvinciaDTO;
import org.ambar.appl.services.PaisServices;
import org.ambar.appl.services.ProvinciaServices;
import org.ambar.core.commons.context.RequestContext;

/**
 * <p>
 * Bean utilizado en el ABM de Proveedor.
 * </p>
 *
 * @author Sebastian
 *
 */
public class ABMProveedorBean implements Serializable {

	private static final long serialVersionUID = 3932621621391364566L;

	private PaisServices paisServices;
	private ProvinciaServices provinciaServices;

	private RequestContext requestContext;

	private List<PaisDTO> paises;
	private List<ProvinciaDTO> provincias;
	
	
	/**
	 * @param pPaisServices Establece el valor del atributo paisServices.
	 */
	public void setPaisServices(PaisServices pPaisServices) {
		paisServices = pPaisServices;
	}
	
	/**
	 * @param pProvinciaServices Establece el valor del atributo provinciaServices.
	 */
	public void setProvinciaServices(ProvinciaServices pProvinciaServices) {
		provinciaServices = pProvinciaServices;
	}

	/**
	 * @param pRequestContext Establece el valor del atributo requestContext.
	 */
	public void setRequestContext(RequestContext pRequestContext) {
		requestContext = pRequestContext;
	}

	/**
	 * @return Retorna el valor del atributo paises.
	 */
	public List<PaisDTO> getPaises() {
		return paises;
	}

	/**
	 * @param pPaises Establece el valor del atributo paises.
	 */
	public void setPaises(List<PaisDTO> pPaises) {
		paises = pPaises;
	}

	/**
	 * @return Retorna el valor del atributo provincias.
	 */
	public List<ProvinciaDTO> getProvincias() {
		return provincias;
	}

	/**
	 * @param pProvincias Establece el valor del atributo provincias.
	 */
	public void setProvincias(List<ProvinciaDTO> pProvincias) {
		provincias = pProvincias;
	}

	public void init(ProveedorDTO pCliente){
		this.paises = this.paisServices.getFilteredList(null, this.requestContext).getResultList();

		if (pCliente != null && pCliente.getIdPais() != null) {
			this.provincias = this.provinciaServices.getByIdPais(pCliente.getIdPais(), this.requestContext).getResultList();
		} else {
			this.provincias = null;
		}
	}
	
	public void paisChanged(ValueChangeEvent pEvent) {
	    if (pEvent.getNewValue() != null) {
	    	this.provincias = this.provinciaServices.getByIdPais(pEvent.getNewValue().toString(),
	    			                                             this.requestContext).getResultList();
	    } else {
	    	this.provincias = null;
	    }
	}
}
