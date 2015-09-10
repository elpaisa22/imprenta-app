/**
 * application-domain [28/04/2015 18:28:20]
 */
package org.ambar.appl.be;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Version;

import org.ambar.appl.commons.enums.TipoComprobanteValues;
import org.ambar.core.be.Persistible;
import org.ambar.core.be.TrackInfo;
import org.ambar.core.be.Trackingable;
import org.ambar.core.be.Versionable;

/**
 * <p>
 * Entidad que representa la numeracion de comprobantes.
 * </p>
 *
 * @author Sebastian
 *
 */
@Entity
@Table(name = "AP_NUMERADORCOMPROBANTE")
public class NumeradorComprobante implements Persistible<Long>, Trackingable, Versionable {

	private Long id;

	private Long prefijo;
	private Long numero;

	private TrackInfo trackInfo;
	private int version;


	/* (non-JSDoc)
	 * @see org.ambar.core.be.Persistible#getId()
	 */
	@Override
	@Id
    @Column(name = "IDCOMPROBANTE")
	public Long getId() {
		return this.id;
	}

	/* (non-JSDoc)
	 * @see org.ambar.core.be.Persistible#setId(java.lang.Object)
	 */
	@Override
	public void setId(Long pId) {
		this.id = pId;
	}

	/**
	 * @return Retorna el valor del atributo prefijo.
	 */
	@Column
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
	@Column
	public Long getNumero() {
		return numero;
	}

	/**
	 * @param pNumero Establece el valor del atributo numero.
	 */
	public void setNumero(Long pNumero) {
		numero = pNumero;
	}

	/**
	 * Retorna la descripcion del comprobante asociado con el numerador.
	 * @return {@link String} Descripcion
	 * */
	@Transient
	public String getDescripcionComprobante() {
		if (this.id != null) {
			return TipoComprobanteValues.fromString(this.id.toString()).getDescripcion();
		} else {
			return "";
		}
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
		if (!(pObj instanceof MovimientoCuentaCorriente)) {
			return false;
		}

		NumeradorComprobante other = (NumeradorComprobante) pObj;
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
		builder.append("NumeradorComprobante [id=");
		builder.append(this.id);
		builder.append(", trackInfo=");
		builder.append(this.trackInfo);
		builder.append(", version=");
		builder.append(this.version);
		builder.append("]");
		return builder.toString();
	}
}
