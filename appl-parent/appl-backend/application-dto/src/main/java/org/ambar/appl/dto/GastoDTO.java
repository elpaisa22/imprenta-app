/**
 * application-dto [31/05/2015 17:59:50]
 */
package org.ambar.appl.dto;

import java.math.BigDecimal;
import java.util.Date;

import org.ambar.core.dto.DTO;
import org.ambar.core.dto.TrackInfoDTO;
import org.ambar.core.dto.TrackingableDTO;
import org.ambar.core.dto.VersionableDTO;

/**
 * <p>
 * DTO a ser usado en las transacciones CRUD correspondiente a la
 * entidad {@link org.ambar.appl.be.Gasto}.
 * </p>
 *
 * @author Sebastian
 *
 */
public class GastoDTO implements DTO<Long>, TrackingableDTO, VersionableDTO {

	private static final long serialVersionUID = -1169117324494426948L;

	private Long id;

	private Date fecha;
	private String  idTipoGasto;
	private String  descripcionTipoGasto;
	private String nombre;
	private BigDecimal importe;
	private String observaciones;

	private TrackInfoDTO trackInfo;
	private int version;

	/**
	 * Constructor default.
	 */
	public GastoDTO() {
		this.fecha = new Date();
		this.importe = BigDecimal.ZERO;
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
	 * @return Retorna el valor del atributo fecha.
	 */
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
	 * @return Retorna el valor del atributo idTipoGasto.
	 */
	public String getIdTipoGasto() {
		return idTipoGasto;
	}

	/**
	 * @param pIdTipoGasto Establece el valor del atributo idTipoGasto.
	 */
	public void setIdTipoGasto(String pIdTipoGasto) {
		idTipoGasto = pIdTipoGasto;
	}

	/**
	 * @return Retorna el valor del atributo descripcionTipoGasto.
	 */
	public String getDescripcionTipoGasto() {
		return descripcionTipoGasto;
	}

	/**
	 * @param pDescripcionTipoGasto Establece el valor del atributo descripcionTipoGasto.
	 */
	public void setDescripcionTipoGasto(String pDescripcionTipoGasto) {
		descripcionTipoGasto = pDescripcionTipoGasto;
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
	 * @return Retorna el valor del atributo importe.
	 */
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
		if (!(pObj instanceof GastoDTO)) {
			return false;
		}
		GastoDTO other = (GastoDTO) pObj;
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
		builder.append("GastoDTO [id=");
		builder.append(this.id);

		builder.append(", trackInfo=");
		builder.append(this.trackInfo);
		builder.append(", version=");
		builder.append(this.version);
		builder.append("]");
		return builder.toString();
	}
}
