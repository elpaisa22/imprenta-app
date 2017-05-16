/**
 * application-services-api [15 de may. de 2017 4:53:20 p. m.]
 */
package org.ambar.appl.services;

import java.io.File;

import org.ambar.appl.be.Usuario;
import org.ambar.appl.dto.UsuarioDTO;
import org.ambar.core.commons.context.RequestContext;
import org.ambar.core.dto.results.ResultVoidDTO;
import org.ambar.core.services.CrudServices;

/**
 * <p>
 * Interfaz que implementa los servicios de la entidad Usuario.
 * </p>
 *
 * @author Sebastian
 *
 * @see org.ambar.core.services.CrudServices
 */
public interface UsuarioServices extends CrudServices<String, UsuarioDTO, String, Usuario> {
	
	/**
	* Actualiza la imagen de perfil del usuario.
	* @param pIdUsuario Id Usuario
	* @param pFile Archivo
	* @param pRequestContext Contexto de la petición
	* @return {@link ResultVoidDTO} Encapsula mensajes con el resultado de la operación
	*/
	ResultVoidDTO<UsuarioDTO> actualizarImagenDePerfil(String pIdUsuario,
			                                           File pFile,
			                                           RequestContext pRequestContext);
	
	/**
	* Actualiza la contraseña del usuario.
	* @param pIdUsuario Id Usuario
	* @param pPassword Contraseña
	* @param pRepetirContraseña Contraseña Otra vez
	* @param pRequestContext Contexto de la petición
	* @return {@link ResultVoidDTO} Encapsula mensajes con el resultado de la operación
	*/
	ResultVoidDTO<UsuarioDTO> actualizarPassword(String pIdUsuario,
			                                     String pPassword,
			                                     String pRepetirContraseña,
			                                     RequestContext pRequestContext);
}
