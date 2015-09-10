/**
 * application-dto [2/7/2015 16:14:08]
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
 * entidad {@link org.ambar.appl.be.MovimientoCuentaBancaria}.
 * </p>
 */
public class MovimientoCuentaBancariaDTO implements DTO<Long>, TrackingableDTO, VersionableDTO {

	private static final long serialVersionUID = 7179571440944734999L;

	private Long id;

	private Long idCuentaBancaria;

	private Date fecha;
	private BigDecimal importe;
	private String descripcion;
	private BigDecimal saldo;

	private TrackInfoDTO trackInfo;
	private int version;

	/**
	 * Constructor default.
	 */
	public MovimientoCuentaBancariaDTO() {
		this.fecha = new Date();
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
	 * @return Retorna el valor del atributo idCuentaBancaria.
	 */
	public Long getIdCuentaBancaria() {
		return idCuentaBancaria;
	}

	/**
	 * @param pIdCuentaBancaria Establece el valor del atributo idCuentaBancaria.
	 */
	public void setIdCuentaBancaria(Long pIdCuentaBancaria) {
		idCuentaBancaria = pIdCuentaBancaria;
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
	 * @return Retorna el valor del atributo saldo.
	 */
	public BigDecimal getSaldo() {
		return saldo;
	}

	/**
	 * @param pSaldo Establece el valor del atributo saldo.
	 */
	public void setSaldo(BigDecimal pSaldo) {
		saldo = pSaldo;
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
		if (!(pObj instanceof MovimientoCuentaBancariaDTO)) {
			return false;
		}
		MovimientoCuentaBancariaDTO other = (MovimientoCuentaBancariaDTO) pObj;
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
		builder.append("MovimientoCuentaBancariaDTO [id=");
		builder.append(this.id);

		builder.append(", importe=");
		builder.append(this.importe);
		builder.append(", idCuentaBancaria=");
		builder.append(this.idCuentaBancaria);
		builder.append(", descripcion=");
		builder.append(this.descripcion);
		builder.append(", fecha=");
		builder.append(this.fecha);
		builder.append(", saldo=");
		builder.append(this.saldo);

		builder.append(", trackInfo=");
		builder.append(this.trackInfo);
		builder.append(", version=");
		builder.append(this.version);
		builder.append("]");
		return builder.toString();
	}
}
