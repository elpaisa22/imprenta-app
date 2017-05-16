package org.ambar.appl.be;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.ambar.appl.commons.constraint.Constraints;
import org.ambar.appl.commons.enums.PerfilUsuarioValues;
import org.ambar.core.be.Persistible;
import org.ambar.core.be.TrackInfo;
import org.ambar.core.be.Trackingable;
import org.ambar.core.be.Versionable;
import org.ambar.core.enums.converters.dozer.EnumConverter;

/**
 * <p>
 * Entidad Usuario.
 * </p>
 *
 * @author Sebastian
 *
 */
@Entity
@Table(name = "AP_USUARIO")
public class Usuario implements Persistible<String>, Trackingable, Versionable {
	
	private String id;

	private String password;
	private String nombre;
	private String email;
	private PerfilUsuarioValues perfil;
	private String imagen;
	
	private TrackInfo trackInfo;
	private int version;

	/* (non-JSDoc)
	 * @see org.ambar.core.be.Persistible#getId()
	 */
	@Override
	@Id
    @Column(name = "IDUSUARIO")
	@NotNull(message = "{org.ambar.appl.be.Usuario.id.NotNull}")
	public String getId() {
		return this.id;
	}

	/* (non-JSDoc)
	 * @see org.ambar.core.be.Persistible#setId(java.lang.Object)
	 */
	@Override
	public void setId(String pId) {
		this.id = pId;
	}

	/**
	 * @return Retorna el valor del atributo password.
	 */
	@Basic(optional = false)
    @Column(name = "PASSWORD")
    @NotNull(message = "{org.ambar.appl.be.Usuario.password.NotNull}")
    @Size(max = Constraints.STRING40_SIZE_MAX, message = "{org.ambar.appl.be.Usuario.password.Size}")
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
	@Basic(optional = false)
    @Column(name = "NOMBRE")
    @NotNull(message = "{org.ambar.appl.be.Usuario.nombre.NotNull}")
    @Size(max = Constraints.STRING40_SIZE_MAX, message = "{org.ambar.appl.be.Usuario.nombre.Size}")
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
	@Basic(optional = true)
    @Column(name = "EMAIL")
    @Size(max = Constraints.STRING40_SIZE_MAX, message = "{org.ambar.appl.be.Usuario.email.Size}")
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
	@Transient
	public PerfilUsuarioValues getPerfil() {
		return perfil;
	}

	/**
	 * @param pPerfil Establece el valor del atributo perfil.
	 */
	public void setPerfil(PerfilUsuarioValues pPerfil) {
		perfil = pPerfil;
	}


	/**
	 * @param pPerfilDB Establece el valor del atributo perfil a partir
	 * de un {@link String}.
	 */
	@SuppressWarnings("unused")
	private void setPerfilPersistent(String pPerfilDB) {
		this.perfil = EnumConverter.getEnumFromString(PerfilUsuarioValues.class, pPerfilDB);
	}

	/**
	 * @return {@link String} perfil
	 */
	@Basic(optional = false)
	@Column(name = "PERFIL")
	@NotNull(message = "{org.ambar.appl.be.Usuario.perfil.NotNull}")
	private String getPerfilPersistent() {
		if (this.perfil == null) {
			return null;
		} else {
			return this.perfil.getValor();
		}
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
	 * @see org.ambar.core.be.Versionable#getVersion()
	 */
	@Override
	@Version
	@Column(name = "VERSION", nullable = false)
	public int getVersion() {
		return this.version;
	}

	/* (non-JSDoc)
	 * @see org.ambar.core.be.Versionable#setVersion(int)
	 */
	@Override
	public void setVersion(int pVersion) {
		this.version = pVersion;
	}

	/* (non-JSDoc)
	 * @see org.ambar.core.be.Trackingable#getTrackInfo()
	 */
	@Override
	@Embedded
	public TrackInfo getTrackInfo() {
		return this.trackInfo;
	}

	/* (non-JSDoc)
	 * @see org.ambar.core.be.Trackingable#setTrackInfo(
	 * 		org.ambar.core.be.TrackInfo)
	 */
	@Override
	public void setTrackInfo(TrackInfo pTrackInfo) {
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
		if (!(pObj instanceof Usuario)) {
			return false;
		}

		Usuario other = (Usuario) pObj;
		if (this.id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!this.id.equals(other.id)) {
			return false;
		}
		return true;
	}

	/* (non-JSDoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Usuario [id=");
		builder.append(this.id);

		builder.append(", trackInfo=");
		builder.append(this.trackInfo);
		builder.append(", version=");
		builder.append(this.version);
		builder.append("]");
		return builder.toString();
	}
}
