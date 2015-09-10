/**
 * application-dto [02/03/2013 14:10:07]
 */
package org.ambar.appl.dto;

import java.math.BigDecimal;
import java.util.Date;

import org.ambar.core.dto.DTO;
import org.ambar.core.dto.TrackInfoDTO;
import org.ambar.core.dto.TrackingableDTO;
import org.ambar.core.dto.VersionableDTO;

/**
 * <p>DTO a ser usado en las transacciones CRUD correspondiente a la
 * entidad {@link org.ambar.appl.be.Cheque}.</p>
 *
 * @author Sebastian
 *
 *
 */
public class ChequeDTO implements DTO<Long>, TrackingableDTO, VersionableDTO {

	private static final long serialVersionUID = -668318122829440453L;

	private Long id;

	private BigDecimal monto;
	private Date fecha;
	private Date fechaVencimiento;
	private Long idCliente;
	private String razonSocialCliente;
	private String cuenta;
	private String idBanco;
	private String descripcionBanco;
	private String sucursal;
	private String emisor;
	private String cuit;

	private Long idCobranza;
	private Long idPago;

	private TrackInfoDTO trackInfo;
	private int version;

	/**
	 * Constructor Default.
	 */
	public ChequeDTO() {
		this.monto = BigDecimal.ZERO;
		this.fecha = new Date();
		this.fechaVencimiento = new Date();
		this.trackInfo = new TrackInfoDTO();
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
	 * @return Retorna el valor del atributo monto.
	 */
	public BigDecimal getMonto() {
		return monto;
	}

	/**
	 * @param pMonto Establece el valor del atributo monto.
	 */
	public void setMonto(BigDecimal pMonto) {
		monto = pMonto;
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
	 * @return Retorna el valor del atributo cuenta.
	 */
	public String getCuenta() {
		return cuenta;
	}

	/**
	 * @param pCuenta Establece el valor del atributo cuenta.
	 */
	public void setCuenta(String pCuenta) {
		cuenta = pCuenta;
	}

	/**
	 * @return Retorna el valor del atributo idBanco.
	 */
	public String getIdBanco() {
		return idBanco;
	}


	/**
	 * @param pIdBanco Establece el valor del atributo idBanco.
	 */
	public void setIdBanco(String pIdBanco) {
		idBanco = pIdBanco;
	}


	/**
	 * @return Retorna el valor del atributo descripcionBanco.
	 */
	public String getDescripcionBanco() {
		return descripcionBanco;
	}


	/**
	 * @param pDescripcionBanco Establece el valor del atributo descripcionBanco.
	 */
	public void setDescripcionBanco(String pDescripcionBanco) {
		descripcionBanco = pDescripcionBanco;
	}


	/**
	 * @return Retorna el valor del atributo sucursal.
	 */
	public String getSucursal() {
		return sucursal;
	}

	/**
	 * @param pSucursal Establece el valor del atributo sucursal.
	 */
	public void setSucursal(String pSucursal) {
		sucursal = pSucursal;
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
	 * @return Retorna el valor del atributo fechaVencimiento.
	 */
	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}


	/**
	 * @param pFechaVencimiento Establece el valor del atributo fechaVencimiento.
	 */
	public void setFechaVencimiento(Date pFechaVencimiento) {
		fechaVencimiento = pFechaVencimiento;
	}


	/**
	 * @return Retorna el valor del atributo emisor.
	 */
	public String getEmisor() {
		return emisor;
	}


	/**
	 * @param pEmisor Establece el valor del atributo emisor.
	 */
	public void setEmisor(String pEmisor) {
		emisor = pEmisor;
	}


	/**
	 * @return Retorna el valor del atributo cuit.
	 */
	public String getCuit() {
		return cuit;
	}


	/**
	 * @param pCuit Establece el valor del atributo cuit.
	 */
	public void setCuit(String pCuit) {
		cuit = pCuit;
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
		if (!(pObj instanceof ChequeDTO)) {
			return false;
		}
		ChequeDTO other = (ChequeDTO) pObj;
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
		builder.append("ChequeDTO [id=");
		builder.append(this.id);

		builder.append(", monto=");
		builder.append(this.monto);
		builder.append(", fecha=");
		builder.append(this.fecha);
		builder.append(", idCliente=");
		builder.append(this.idCliente);
		builder.append(", razonSocialCliente=");
		builder.append(this.razonSocialCliente);
		builder.append(", cuenta=");
		builder.append(this.cuenta);
		builder.append(", idBanco=");
		builder.append(this.idBanco);
		builder.append(", sucursal=");
		builder.append(this.sucursal);

		builder.append(", trackInfo=");
		builder.append(this.trackInfo);
		builder.append(", version=");
		builder.append(this.version);
		builder.append("]");
		return builder.toString();
	}
}
