/**
 * application-domain [31/05/2015 17:26:40]
 */
package org.ambar.appl.be;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import org.ambar.core.be.Persistible;
import org.ambar.core.be.TrackInfo;
import org.ambar.core.be.Trackingable;
import org.ambar.core.be.Versionable;

/**
 * <p>
 * Entidad Gasto.
 * </p>
 *
 * @author Sebastian
 *
 *
 */
@Entity
@Table(name = "AP_GASTO")
public class Gasto implements Persistible<Long>, Trackingable, Versionable {

	private Long id;

	private Date fecha;
	private TipoGasto tipoGasto;
	private String nombre;
	private BigDecimal importe;
	private String observaciones;

	private TrackInfo trackInfo;
	private int version;

	/* (non-JSDoc)
	 * @see org.ambar.core.be.Persistible#getId()
	 */
	@Override
	@Id
    @Column(name = "IDGASTO")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	 * @return Retorna el valor del atributo fecha.
	 */
	@Column(name = "FECHA")
	@Basic(optional = false)
	public Date getFecha() {
		return fecha;
	}

	/**
	 * @param pFecha Establece el valor del atributo fecha.
	 */
	public void setFecha(Date pFecha) {
		fecha = pFecha;
	}

	/**
	 * @return Retorna el valor del atributo tipoGasto.
	 */
	@ManyToOne
	@Basic(optional = false)
	@JoinColumn(name = "IDTIPOGASTO")
	public TipoGasto getTipoGasto() {
		return tipoGasto;
	}

	/**
	 * @param pTipoGasto Establece el valor del atributo tipoGasto.
	 */
	public void setTipoGasto(TipoGasto pTipoGasto) {
		tipoGasto = pTipoGasto;
	}

	/**
	 * @return Retorna el valor del atributo nombre.
	 */
	@Column(name = "NOMBRE")
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
	 * @return Retorna el valor del atributo importe.
	 */
	@Column(name = "IMPORTE")
	public BigDecimal getImporte() {
		return importe;
	}

	/**
	 * @param pImporte Establece el valor del atributo importe.
	 */
	public void setImporte(BigDecimal pImporte) {
		importe = pImporte;
	}

	/**
	 * @return Retorna el valor del atributo observaciones.
	 */
	@Column(name = "OBSERVACIONES")
	public String getObservaciones() {
		return observaciones;
	}

	/**
	 * @param pObservaciones Establece el valor del atributo observaciones.
	 */
	public void setObservaciones(String pObservaciones) {
		observaciones = pObservaciones;
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
		if (!(pObj instanceof Gasto)) {
			return false;
		}
		Gasto other = (Gasto) pObj;
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
		builder.append("Gasto [id=");
		builder.append(this.id);

		builder.append(", trackInfo=");
		builder.append(this.trackInfo);
		builder.append(", version=");
		builder.append(this.version);
		builder.append("]");
		return builder.toString();
	}
}
