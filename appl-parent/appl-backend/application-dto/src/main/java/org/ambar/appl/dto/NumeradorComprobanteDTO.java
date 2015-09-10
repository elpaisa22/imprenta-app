/**
 * application-dto [28/04/2015 19:00:48]
 */
package org.ambar.appl.dto;

import org.ambar.core.dto.DTO;
import org.ambar.core.dto.TrackInfoDTO;
import org.ambar.core.dto.TrackingableDTO;
import org.ambar.core.dto.VersionableDTO;

/**
 * <p>
 * DTO a ser usado en las transacciones CRUD correspondiente a la
 * entidad {@link org.ambar.appl.be.NumeradorComprobante}.
 * </p>
 *
 * @author Sebastian
 *
 */
public class NumeradorComprobanteDTO implements DTO<Long>, TrackingableDTO, VersionableDTO {

	private static final long serialVersionUID = 6009860854745797310L;

	private Long id;
	private String descripcionComprobante;
	private Long prefijo;
	private Long numero;

	private TrackInfoDTO trackInfo;
	private int version;

	/* (non-JSDoc)
	 * @see org.ambar.core.dto.DTO#getId()
	 */
	@Override
	public Long getId() {
		return this.id;
	}

	/* (non-JSDoc)
	 * @see org.ambar.core.dto.DTO#setId(java.lang.Object)
	 */
	@Override
	public void setId(Long pId) {
		this.id = pId;
	}

	/**
	 * @return Retorna el valor del atributo descripcionComprobante.
	 */
	public String getDescripcionComprobante() {
		return descripcionComprobante;
	}

	/**
	 * @param pDescripcionComprobante Establece el valor del atributo descripcionComprobante.
	 */
	public void setDescripcionComprobante(String pDescripcionComprobante) {
		descripcionComprobante = pDescripcionComprobante;
	}

	/**
	 * @return Retorna el valor del atributo prefijo.
	 */
	public Long getPrefijo() {
		return prefijo;
	}
	/**
	 * @param pPrefijo Establece el valor del atributo prefijo.
	 */
	public void setPrefijo(Long pPrefijo) {
		prefijo = pPrefijo;
	}
	/**
	 * @return Retorna el valor del atributo numero.
	 */
	public Long getNumero() {
		return numero;
	}
	/**
	 * @param pNumero Establece el valor del atributo numero.
	 */
	public void setNumero(Long pNumero) {
		numero = pNumero;
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
		if (!(pObj instanceof NumeradorComprobanteDTO)) {
			return false;
		}
		NumeradorComprobanteDTO other = (NumeradorComprobanteDTO) pObj;
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
		builder.append("NumeradorComprobanteDTO [id=");
		builder.append(this.id);

		builder.append(", trackInfo=");
		builder.append(this.trackInfo);
		builder.append(", version=");
		builder.append(this.version);
		builder.append("]");
		return builder.toString();
	}

}
