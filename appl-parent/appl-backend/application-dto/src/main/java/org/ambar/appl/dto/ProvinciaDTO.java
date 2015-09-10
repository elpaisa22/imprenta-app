/**
 * application-dto [23/05/2015 11:32:05]
 */
package org.ambar.appl.dto;

import org.ambar.core.dto.DTO;
import org.ambar.core.dto.TrackInfoDTO;
import org.ambar.core.dto.TrackingableDTO;
import org.ambar.core.dto.VersionableDTO;

/**
 * <p>
 * DTO a ser usado en las transacciones CRUD correspondiente a la
 * entidad {@link org.ambar.appl.be.Provincia}.
 * </p>
 *
 * @author Sebastian
 *
 */
public class ProvinciaDTO implements DTO<ProvinciaDTO>, TrackingableDTO, VersionableDTO {

	private static final long serialVersionUID = 7539816723796897367L;

	private String idProvincia;
	private String descripcion;

	private String idPais;
	private String descripcionPais;

	private TrackInfoDTO trackInfo;
	private int version;

	/* (non-JSDoc)
	 * @see org.ambar.core.dto.DTO#getId()
	 */
	@Override
	public ProvinciaDTO getId() {
		return this;
	}

	/* (non-JSDoc)
	 * @see org.ambar.core.dto.DTO#setId(java.lang.Object)
	 */
	@Override
	public void setId(ProvinciaDTO pId) {
	}

	/**
	 * @return Retorna el valor del atributo idProvincia.
	 */
	public String getIdProvincia() {
		return idProvincia;
	}

	/**
	 * @param pIdProvincia Establece el valor del atributo idProvincia.
	 */
	public void setIdProvincia(String pIdProvincia) {
		idProvincia = pIdProvincia;
	}

	/**
	 * @return Retorna el valor del atributo idPais.
	 */
	public String getIdPais() {
		return idPais;
	}

	/**
	 * @param pIdPais Establece el valor del atributo idPais.
	 */
	public void setIdPais(String pIdPais) {
		idPais = pIdPais;
	}

	/**
	 * @return Retorna el valor del atributo descripcion.
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param pDescripcion Establece el valor del atributo descripcion.
	 */
	public void setDescripcion(String pDescripcion) {
		descripcion = pDescripcion;
	}

	/**
	 * @return Retorna el valor del atributo descripcionPais.
	 */
	public String getDescripcionPais() {
		return descripcionPais;
	}

	/**
	 * @param pDescripcionPais Establece el valor del atributo descripcionPais.
	 */
	public void setDescripcionPais(String pDescripcionPais) {
		descripcionPais = pDescripcionPais;
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
		int result = idProvincia != null ? idProvincia.hashCode() : 0;
        result = prime * result + (idPais != null ? idPais.hashCode() : 0);
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
        if ((pObj == null) || (this.getClass() != pObj.getClass())) {
            return false;
        }

        final ProvinciaDTO that = (ProvinciaDTO) pObj;

        if (idPais != null ? !idPais.equals(that.idPais) : that.idPais != null) {
			return false;
		}
        if (idProvincia != null ? !idProvincia.equals(that.idProvincia) : that.idProvincia != null) {
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
		builder.append("ProvinciaDTO [idProvincia=");
		builder.append(this.idProvincia);
		builder.append(", idPais=");
		builder.append(this.idPais);
		builder.append(", descripcion=");
		builder.append(this.descripcion);

		builder.append(", trackInfo=");
		builder.append(this.trackInfo);
		builder.append(", version=");
		builder.append(this.version);
		builder.append("]");
		return builder.toString();
	}
}

