/**
 * appl-frontend-web [7/4/2015 23:05:38]
 */
package org.ambar.appl.frontend.beans.impl;

import java.io.Serializable;

import javax.faces.context.FacesContext;

import org.ambar.appl.dto.UsuarioDTO;
import org.ambar.appl.frontend.beans.api.LoggedUser;
import org.ambar.appl.services.UsuarioServices;
import org.ambar.core.commons.context.RequestContext;
import org.apache.commons.io.FilenameUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * <p>
 * Bean que ayuda en la navegacion de la aplicación.
 * </p>
 *
 * @author Sebastian
 *
 */
public class NavigationBeanImpl implements Serializable {
	private static final long serialVersionUID = -6673029494848115455L;

	private static final String LOGGED_USER = "LOGGEDUSER";

	private RequestContext requestContext;
	private UsuarioServices usuarioServices;

	/**
	 * @param pRequestContext Establece el valor del atributo requestContext.
	 */
	public void setRequestContext(RequestContext pRequestContext) {
		requestContext = pRequestContext;
	}

	/**
	 * @param pUsuarioServices Establece el valor del atributo usuarioServices.
	 */
	public void setUsuarioServices(UsuarioServices pUsuarioServices) {
		usuarioServices = pUsuarioServices;
	}

	/**
	 * Obtiene el usuario actual logueado.
	 * */
	public LoggedUser getActualUser() {
		if (!FacesContext.getCurrentInstance().getExternalContext().getSessionMap().containsKey(LOGGED_USER)) {
			this.loadUserData();
		}
		LoggedUser usr = (LoggedUser) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get(LOGGED_USER);

		return usr;
	}
	
	public void loadUserData() {
		LoggedUser usr = null;

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		this.requestContext.setUser(currentPrincipalName);

		UsuarioDTO usuario = this.usuarioServices.getById(currentPrincipalName, this.requestContext).getResult();

		if (usuario != null) {
			usr = new LoggedUser();
			usr.setId(usuario.getId());
			usr.setNombre(usuario.getNombre());
			usr.setEmail(usuario.getEmail());
			usr.setImagen(FilenameUtils.getName(usuario.getImagen()));
			usr.setPerfil(usuario.getPerfil());
		} else if (currentPrincipalName.compareTo("admin") == 0) {
			usr = new LoggedUser();
			usr.setId("ADMIN");
			usr.setNombre("ADMIN");
			usr.setEmail("ADMIN");
			usr.setPerfil("ADMIN");
		}

		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put(LOGGED_USER, usr);
	}
}
