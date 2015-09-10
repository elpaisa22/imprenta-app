/**
 * application-dto [15/6/2015 16:38:14]
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
 * entidad {@link org.ambar.appl.be.MovimientoCuentaCorrienteProveedor}.
 * </p>
 *
 * @author Sebastian
 *
 */
public class MovimientoCuentaCorrienteProveedorDTO implements DTO<Long>, TrackingableDTO, VersionableDTO {

	private static final long serialVersionUID = -3424351412160616266L;

	private Long id;

	private Long idCuentaCorriente;
	private Long idProveedor;
	private String razonSocialProveedor;
	private Date fecha;
	private BigDecimal importeMovimiento;
	private String descripcion;
	private BigDecimal saldo;

	private Long idCompra;
	private Long idPago;

	private TrackInfoDTO trackInfo;
	private int version;

	/**
	 * Constructor default.
	 */
	public MovimientoCuentaCorrienteProveedorDTO() {
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
	 * @return Retorna el valor del atributo idCompra.
	 */
	public Long getIdCompra() {
		return idCompra;
	}

	/**
	 * @param pIdCompra Establece el valor del atributo idCompra.
	 */
	public void setIdCompra(Long pIdCompra) {
		idCompra = pIdCompra;
	}

	/**
	 * @return Retorna el valor del atributo idPago.
	 */
	public Long getIdPago() {
		return idPago;
	}

	/**
	 * @param pIdPago Establece el valor del atributo idPago.
	 */
	public void setIdPago(Long pIdPago) {
		idPago = pIdPago;
	}

	/**
	 * @return Retorna el valor del atributo idProveedor.
	 */
	public Long getIdProveedor() {
		return idProveedor;
	}

	/**
	 * @param pIdProveedor Establece el valor del atributo idProveedor.
	 */
	public void setIdProveedor(Long pIdProveedor) {
		idProveedor = pIdProveedor;
	}

	/**
	 * @return Retorna el valor del atributo razonSocialProveedor.
	 */
	public String getRazonSocialProveedor() {
		return razonSocialProveedor;
	}

	/**
	 * @param pRazonSocialProveedor Establece el valor del atributo razonSocialProveedor.
	 */
	public void setRazonSocialProveedor(String pRazonSocialProveedor) {
		razonSocialProveedor = pRazonSocialProveedor;
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
		if (!(pObj instanceof MovimientoCuentaCorrienteProveedorDTO)) {
			return false;
		}
		MovimientoCuentaCorrienteProveedorDTO other = (MovimientoCuentaCorrienteProveedorDTO) pObj;
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
		builder.append("MovimientoCuentaCorrienteProveedorDTO [id=");
		builder.append(this.id);
		builder.append(", idCompra=");
		builder.append(this.idCompra);
		builder.append(", idPago=");
		builder.append(this.idPago);
		builder.append(", importeMovimiento=");
		builder.append(this.importeMovimiento);
		builder.append(", idProveedor=");
		builder.append(this.idProveedor);
		builder.append(", razonSocialProveedor=");
		builder.append(this.razonSocialProveedor);
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
