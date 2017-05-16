/**
 * application-services-impl [15 de may. de 2017 4:56:10 p. m.]
 */
package org.ambar.appl.services.impl;

import java.io.File;
import java.io.IOException;

import org.ambar.appl.be.Usuario;
import org.ambar.appl.dto.UsuarioDTO;
import org.ambar.appl.services.UsuarioServices;
import org.ambar.core.commons.context.RequestContext;
import org.ambar.core.dto.results.MessageKind;
import org.ambar.core.dto.results.MessageResult;
import org.ambar.core.dto.results.ResultVoidDTO;
import org.ambar.core.services.impl.CrudServiceDefaultImpl;

/**
 * <p>
 * Implementación por default de {@link UsuarioServices}.
 * </p>
 *
 * @author Sebastian
 *
 */
public class UsuarioServicesImpl extends CrudServiceDefaultImpl<String, UsuarioDTO, String, Usuario>
                                 implements UsuarioServices {
	private static final long serialVersionUID = -3927632992579677300L;

	@Override
	public ResultVoidDTO<UsuarioDTO> actualizarImagenDePerfil(String pIdUsuario, File pFile, RequestContext pRequestContext) {
		UsuarioDTO usuario = this.getById(pIdUsuario, pRequestContext).getResult();
		if (usuario != null) {
			try {
				usuario.setImagen(pFile.getCanonicalPath());
				return this.update(usuario, pRequestContext);
			} catch (IOException e) {
				ResultVoidDTO<UsuarioDTO> result = new ResultVoidDTO<UsuarioDTO>();
				MessageResult msg = new MessageResult("Error al leer el archivo");
				result.getMessages().add(msg);
				return result;
			}
		} else {
			ResultVoidDTO<UsuarioDTO> result = new ResultVoidDTO<UsuarioDTO>();
			MessageResult msg = new MessageResult("El usuario no se ha encotrado");
			result.getMessages().add(msg);
			return result;
		}
	}

	@Override
	public ResultVoidDTO<UsuarioDTO> actualizarPassword(String pIdUsuario,
														String pPassword,
														String pRepetirPassword,
														RequestContext pRequestContext) {
		UsuarioDTO usuario = this.getById(pIdUsuario, pRequestContext).getResult();
		if (usuario != null) {
			if (pPassword.compareTo(pRepetirPassword) != 0
					|| pPassword.compareTo(usuario.getPassword()) != 0) {
				ResultVoidDTO<UsuarioDTO> result = new ResultVoidDTO<UsuarioDTO>();
				MessageResult msg = new MessageResult("Las contraseñas no coinciden");
				msg.setKind(MessageKind.Error);
				result.getMessages().add(msg);
				return result;
			} else {
				usuario.setPassword(pPassword);
				return this.update(usuario, pRequestContext);
			}
		} else {
			ResultVoidDTO<UsuarioDTO> result = new ResultVoidDTO<UsuarioDTO>();
			MessageResult msg = new MessageResult("El usuario no se ha encotrado");
			result.getMessages().add(msg);
			return result;
		}
	}
	
	
}
