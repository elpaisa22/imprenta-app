/**
 * application-dto [25/08/2012 12:51:59]
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
 * entidad {@link org.ambar.appl.be.MovimientoCuentaCorriente}.
 * </p>
 *
 * @author Sebastian
 *
 */
public class MovimientoCuentaCorrienteDTO implements DTO<Long>, TrackingableDTO, VersionableDTO {

	private static final long serialVersionUID = -1680351624479004408L;

	private Long id;

	private Long idCuentaCorriente;
	private Long idCliente;
	private String razonSocialCliente;
	private Date fecha;
	private BigDecimal importeMovimiento;
	private String descripcion;
	private BigDecimal saldo;

	private Long idFactura;
	private Long idCobranza;

	private TrackInfoDTO trackInfo;
	private int version;

	/**
	 * Constructor default.
	 */
	public MovimientoCuentaCorrienteDTO() {
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
	 * @return Retorna el valor del atributo idFactura.
	 */
	public Long getIdFactura() {
		return idFactura;
	}

	/**
	 * @param pIdFactura Establece el valor del atributo idFactura.
	 */
	public void setIdFactura(Long pIdFactura) {
		idFactura = pIdFactura;
	}

	/**
	 * @return Retorna el valor del atributo idCobranza.
	 */
	public Long getIdCobranza() {
		return idCobranza;
	}

	/**
	 * @param pIdCobranza Establece el valor del atributo idCobranza.
	 */
	public void setIdCobranza(Long pIdCobranza) {
		idCobranza = pIdCobranza;
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
	 * @return Retorna el valor del atributo idCuentaCorriente.
	 */
	public Long getIdCuentaCorriente() {
		return idCuentaCorriente;
	}

	/**
	 * @param pIdCuentaCorriente Establece el valor del atributo idCuentaCorriente.
	 */
	public void setIdCuentaCorriente(Long pIdCuentaCorriente) {
		idCuentaCorriente = pIdCuentaCorriente;
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
	 * @return Retorna el valor del atributo importeMovimiento.
	 */
	public BigDecimal getImporteMovimiento() {
		return importeMovimiento;
	}

	/**
	 * @param pImporteMovimiento Establece el valor del atributo importeMovimiento.
	 */
	public void setImporteMovimiento(BigDecimal pImporteMovimiento) {
		importeMovimiento = pImporteMovimiento;
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
		if (!(pObj instanceof MovimientoCuentaCorrienteDTO)) {
			return false;
		}
		MovimientoCuentaCorrienteDTO other = (MovimientoCuentaCorrienteDTO) pObj;
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
		builder.append("MovimientoCuentaCorrienteDTO [id=");
		builder.append(this.id);
		builder.append(", idFactura=");
		builder.append(this.idFactura);
		builder.append(", idCobranza=");
		builder.append(this.idCobranza);
		builder.append(", importeMovimiento=");
		builder.append(this.importeMovimiento);
		builder.append(", idCliente=");
		builder.append(this.idCliente);
		builder.append(", razonSocialCliente=");
		builder.append(this.razonSocialCliente);
		builder.append(", fecha=");
		builder.append(this.fecha);


		builder.append(", trackInfo=");
		builder.append(this.trackInfo);
		builder.append(", version=");
		builder.append(this.version);
		builder.append("]");
		return builder.toString();
	}

}
