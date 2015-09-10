/**
 * application-dto [25/08/2012 12:59:06]
 */
package org.ambar.appl.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.ambar.core.dto.DTO;
import org.ambar.core.dto.TrackInfoDTO;
import org.ambar.core.dto.TrackingableDTO;
import org.ambar.core.dto.VersionableDTO;

/**
 * <p>DTO a ser usado en las transacciones CRUD correspondiente a la
 * entidad {@link org.ambar.appl.be.Remito}.</p>
 *
 * @author Sebastian
 *
 */
public class RemitoDTO implements DTO<Long>, TrackingableDTO, VersionableDTO {

	private static final long serialVersionUID = 2467661590578873196L;

	private Long id;

	private Date fechaEmision;
	private List<OrdenTrabajoDTO> coleccionOrdenesTrabajo;
	private Long idCliente;
	private String razonSocialCliente;

	private TrackInfoDTO trackInfo;
	private int version;

	/**
	 * Constructor Default.
	 */
	public RemitoDTO() {
		this.coleccionOrdenesTrabajo = new ArrayList<OrdenTrabajoDTO>();
		this.fechaEmision = new Date();
	}

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
	 * @return Retorna el valor del atributo fechaEmision.
	 */
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
	public List<OrdenTrabajoDTO> getColeccionOrdenesTrabajo() {
		return coleccionOrdenesTrabajo;
	}

	/**
	 * @param pColeccionOrdenesTrabajo Establece el valor del atributo coleccionOrdenesTrabajo.
	 */
	public void setColeccionOrdenesTrabajo(List<OrdenTrabajoDTO> pColeccionOrdenesTrabajo) {
		coleccionOrdenesTrabajo = pColeccionOrdenesTrabajo;
	}

	/**
	 * Agrega una OrdenTrabajoDTO.
	 * @param pElement OrdenTrabajoDTO a agregar
	 */
	public void agregarOrdenTrabajo(final OrdenTrabajoDTO pElement) {
		this.coleccionOrdenesTrabajo.add(pElement);
		pElement.setIdRemito(this.getId());
	}

	/**
	 * Remueve una OrdenTrabajoDTO.
	 * @param pElement OrdenTrabajoDTO a remover
	 */
	public void removerOrdenTrabajo(final OrdenTrabajoDTO pElement) {
		this.coleccionOrdenesTrabajo.remove(pElement);
		pElement.setIdRemito(null);
	}

	/**
	 * @return Retorna el valor del atributo idCliente.
	 */
	public Long getIdCliente() {
		return idCliente;
	}

	/**
	 * @param pIdCliente Establece el valor del atributo idCliente.
	 */
	public void setIdCliente(Long pIdCliente) {
		idCliente = pIdCliente;
	}

	/**
	 * @return Retorna el valor del atributo razonSocialCliente.
	 */
	public String getRazonSocialCliente() {
		return razonSocialCliente;
	}

	/**
	 * @param pRazonSocialCliente Establece el valor del atributo razonSocialCliente.
	 */
	public void setRazonSocialCliente(String pRazonSocialCliente) {
		razonSocialCliente = pRazonSocialCliente;
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
		if (!(pObj instanceof RemitoDTO)) {
			return false;
		}
		RemitoDTO other = (RemitoDTO) pObj;
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
		builder.append("RemitoDTO [id=");
		builder.append(this.id);
		builder.append(", fechaEmision=");
		builder.append(this.fechaEmision);
		builder.append(", idCliente=");
		builder.append(this.idCliente);
		builder.append(", razonSocialCliente=");
		builder.append(this.razonSocialCliente);
		builder.append(", trackInfo=");
		builder.append(this.trackInfo);
		builder.append(", version=");
		builder.append(this.version);
		builder.append("]");
		return builder.toString();
	}
}
