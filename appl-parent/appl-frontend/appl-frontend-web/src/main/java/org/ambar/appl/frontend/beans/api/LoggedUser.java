/**
 * appl-frontend-web [15 de may. de 2017 5:50:24 p. m.]
 */
package org.ambar.appl.frontend.beans.api;

import java.io.Serializable;

/**
 * <p>
 * Representa un usuario logueado.
 * </p>
 *
 * @author Sebastian
 *
 */
public class LoggedUser implements Serializable {

	private static final long serialVersionUID = 701072809652967305L;

	private String id;
	private String nombre;
	private String email;
	private String perfil;
	private String imagen;

	/**
	 * @return Retorna el valor del atributo id.
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param pId Establece el valor del atributo id.
	 */
	public void setId(String pId) {
		id = pId;
	}
	/**
	 * @return Retorna el valor del atributo nombre.
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param pNombre Establece el valor del atributo nombre.
	 */
	public void setNombre(String pNombre) {
		nombre = pNombre;
	}
	/**
	 * @return Retorna el valor del atributo email.
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param pEmail Establece el valor del atributo email.
	 */
	public void setEmail(String pEmail) {
		email = pEmail;
	}
	/**
	 * @return Retorna el valor del atributo perfil.
	 */
	public String getPerfil() {
		return perfil;
	}
	/**
	 * @param pPerfil Establece el valor del atributo perfil.
	 */
	public void setPerfil(String pPerfil) {
		perfil = pPerfil;
	}
	/**
	 * @return Retorna el valor del atributo imagen.
	 */
	public String getImagen() {
		return imagen;
	}
	/**
	 * @param pImagen Establece el valor del atributo imagen.
	 */
	public void setImagen(String pImagen) {
		imagen = pImagen;
	}

}
