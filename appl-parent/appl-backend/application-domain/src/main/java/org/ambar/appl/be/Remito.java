/**
 * application-domain [21/08/2012 01:10:30]
 */
package org.ambar.appl.be;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Version;
import javax.validation.Valid;

import org.ambar.core.be.Persistible;
import org.ambar.core.be.TrackInfo;
import org.ambar.core.be.Trackingable;
import org.ambar.core.be.Versionable;

/**
 * <p>
 * Entidad que representa los Remito.
 * </p>
 *
 * @author Sebastian
 *
 */
@Entity
@Table(name = "AP_REMITO")
public class Remito implements Persistible<Long>, Trackingable, Versionable {

	private Long id;

	private Date fechaEmision;
	private List<OrdenTrabajo> coleccionOrdenesTrabajo;

	private TrackInfo trackInfo;
	private int version;

	/**
	 * Constructor Default.
	 */
	public Remito() {
		this.coleccionOrdenesTrabajo = new ArrayList<OrdenTrabajo>();
	}

	/* (non-JSDoc)
	 * @see org.ambar.core.be.Persistible#getId()
	 */
	@Override
	@Id
    @Column(name = "IDREMITO")
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
	 * @return Retorna el valor del atributo fechaEmision.
	 */
	@Basic(optional = true)
    @Column(name = "FECHAEMISION")
	public Date getFechaEmision() {
		return fechaEmision;
	}

	/**
	 * @param pFechaEmision Establece el valor del atributo fechaEmision.
	 */
	public void setFechaEmision(Date pFechaEmision) {
		fechaEmision = pFechaEmision;
	}

	/**
	 * @return Retorna el valor del atributo coleccionOrdenesTrabajo.
	 */
	@OneToMany(mappedBy = "remito")
	@Valid
	public List<OrdenTrabajo> getColeccionOrdenesTrabajo() {
		return coleccionOrdenesTrabajo;
	}

	/**
	 * @param pColeccionOrdenesTrabajo Establece el valor del atributo coleccionOrdenesTrabajo.
	 */
	public void setColeccionOrdenesTrabajo(List<OrdenTrabajo> pColeccionOrdenesTrabajo) {
		coleccionOrdenesTrabajo = pColeccionOrdenesTrabajo;
	}

	/**
	 * Agrega una OrdenTrabajo.
	 * @param pElement OrdenTrabajo a agregar
	 */
	public void agregarOrdenTrabajo(final OrdenTrabajo pElement) {
		this.coleccionOrdenesTrabajo.add(pElement);
		pElement.setRemito(this);
	}

	/**
	 * Remueve una OrdenTrabajo.
	 * @param pElement OrdenTrabajo a remover
	 */
	public void removerOrdenTrabajo(final OrdenTrabajo pElement) {
		this.coleccionOrdenesTrabajo.remove(pElement);
		pElement.setRemito(null);
	}

	/**
	 * @return Retorna el valor del atributo cliente.
	 */
	@Transient
	public Cliente getCliente() {
		if (this.getColeccionOrdenesTrabajo().size() > 0) {
			return this.getColeccionOrdenesTrabajo().get(0).getCliente();
		}
		return null;
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
		if (!(pObj instanceof Remito)) {
			return false;
		}
		Remito other = (Remito) pObj;
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
		builder.append("Remito [id=");
		builder.append(this.id);

		builder.append("]");
		return builder.toString();
	}
}
