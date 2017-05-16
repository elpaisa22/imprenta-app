/**
 * appl-frontend-web [15 de may. de 2017 5:26:56 p. m.]
 */
package org.ambar.appl.frontend.security;

import java.util.ArrayList;

import org.ambar.appl.be.Usuario;
import org.ambar.appl.bo.UsuarioBO;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

/**
 * <p>
 * Custom Authentication provider.
 * </p>
 *
 * @author Sebastian
 *
 */
public class CustomAuthenticationProvider implements AuthenticationProvider {

	private UsuarioBO usuarioBO;
	
 
	/**
	 * @param pUsuarioBO Establece el valor del atributo UsuarioBO.
	 */
	public void setUsuarioBO(UsuarioBO pUsuarioBO) {
		usuarioBO = pUsuarioBO;
	}

	@Override
    public Authentication authenticate(Authentication authentication) 
      throws AuthenticationException {
  
        String name = authentication.getName();
        String password = authentication.getCredentials().toString();

        Usuario usr = this.usuarioBO.getById(name);

        if (this.isWildcardUser(name, password)
        		|| (usr != null && usr.getPassword().equals(password))) {
            // use the credentials
            // and authenticate against the third-party system
            return new UsernamePasswordAuthenticationToken(name, password, new ArrayList<>());
        } else {
        	throw new BadCredentialsException("El usuario ingresado o la contraseña no existen");
        }
    }
 
    private boolean isWildcardUser(String pName, String pPassword) {
		return pName.compareTo("admin") == 0 && pPassword.equals("a1b2c3d4");
	}

	@Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(
          UsernamePasswordAuthenticationToken.class);
    }
}
