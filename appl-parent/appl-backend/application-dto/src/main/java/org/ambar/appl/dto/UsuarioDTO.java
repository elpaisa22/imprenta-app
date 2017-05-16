package org.ambar.appl.dto;

import org.ambar.core.dto.DTO;
import org.ambar.core.dto.TrackInfoDTO;
import org.ambar.core.dto.TrackingableDTO;
import org.ambar.core.dto.VersionableDTO;

/**
 * <p>
 * DTO a ser usado en las transacciones CRUD correspondiente a la
 * entidad {@link org.ambar.appl.be.Usuario}.
 * </p>
 *
 * @author Sebastian
 *
 */
public class UsuarioDTO implements DTO<String>, TrackingableDTO, VersionableDTO {
	private static final long serialVersionUID = -7534984895837672976L;

	private String id;

	private String password;
	private String nombre;
	private String email;
	private String perfil;
	private String descripcionPerfil;
	private String imagen;
	
	private TrackInfoDTO trackInfo;
	private int version;


	/* (non-JSDoc)
	 * @see org.ambar.core.dto.DTO#getId()
	 */
	@Override
	public String getId() {
		return this.id;
	}

	/* (non-JSDoc)
	 * @see org.ambar.core.dto.DTO#setId(java.lang.Object)
	 */
	@Override
	public void setId(String pId) {
		this.id = pId;
	}
	
	/**
	 * @return Retorna el valor del atributo password.
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param pPassword Establece el valor del atributo password.
	 */
	public void setPassword(String pPassword) {
		password = pPassword;
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
	 * @return Retorna el valor del atributo descripcionPerfil.
	 */
	public String getDescripcionPerfil() {
		return descripcionPerfil;
	}

	/**
	 * @param pDescripcionPerfil Establece el valor del atributo descripcionPerfil.
	 */
	public void setDescripcionPerfil(String pDescripcionPerfil) {
		descripcionPerfil = pDescripcionPerfil;
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

	/* (non-JSDoc)
	 * @see org.ambar.core.dto.VersionableDTO#getVersion()
	 */
	@Override
	public int getVersion() {
		return this.version;
	}

	/* (non-JSDoc)
	 * @see org.ambar.core.dto.VersionableDTO#setVersion(int)
	 */
	@Override
	public void setVersion(int pVersion) {
		this.version = pVersion;
	}

	/* (non-JSDoc)
	 * @see org.ambar.core.dto.TrackingableDTO#getTrackInfo()
	 */
	@Override
	public TrackInfoDTO getTrackInfo() {
		return this.trackInfo;
	}

	/* (non-JSDoc)
	 * @see org.ambar.core.dto.TrackingableDTO#setTrackInfo(org.ambar.core.dto.TrackInfoDTO)
	 */
	@Override
	public void setTrackInfo(TrackInfoDTO pTrackInfo) {
		this.trackInfo = pTrackInfo;
	}

	/* (non-JSDoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
		return result;
	}

	/* (non-JSDoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object pObj) {
		if (this == pObj) {
			return true;
		}
		if (pObj == null) {
			return false;
		}
		if (!(pObj instanceof UsuarioDTO)) {
			return false;
		}
		UsuarioDTO other = (UsuarioDTO) pObj;
		if (this.id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!this.id.equals(other.id)) {
			return false;
		}
		return true;
	}
}
