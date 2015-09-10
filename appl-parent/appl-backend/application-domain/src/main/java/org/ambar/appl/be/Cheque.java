/**
 * application-domain [01/03/2013 16:16:44]
 */
package org.ambar.appl.be;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
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
 * Entidad que representa a un cheque.
 * </p>
 *
 * @author Sebastian
 *
 */
@Entity
@Table(name = "AP_CHEQUE")
public class Cheque implements Persistible<Long>, Trackingable, Versionable {

	private Long id;

	private BigDecimal monto;
	private Date fecha;
	private Date fechaVencimiento;

	private String cuenta;
	private Banco banco;
	private String sucursal;
	private Cobranza cobranza;
	private Pago pago;

	private String emisor;
	private String cuit;

	private TrackInfo trackInfo;
	private int version;


	/* (non-JSDoc)
	 * @see org.ambar.core.be.Persistible#getId()
	 */
	@Override
	@Id
    @Column(name = "IDCHEQUE")
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
	 * @return Retorna el valor del atributo monto.
	 */
	@Basic(optional = true)
	@Column(name = "MONTO")
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
	@Basic(optional = true)
	@Column(name = "FECHA")
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
	 * @return Retorna el valor del atributo cuenta.
	 */
	@Basic(optional = true)
	@Column(name = "CUENTA")
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
	 * @return Retorna el valor del atributo banco.
	 */
	@ManyToOne
	@Basic(optional = true)
	@JoinColumn(name = "IDBANCO")
	public Banco getBanco() {
		return banco;
	}

	/**
	 * @param pBanco Establece el valor del atributo banco.
	 */
	public void setBanco(Banco pBanco) {
		banco = pBanco;
	}

	/**
	 * @return Retorna el valor del atributo sucursal.
	 */
	@Basic(optional = true)
	@Column(name = "SUCURSAL")
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
	 * @return Retorna el valor del atributo cobranza.
	 */
	@ManyToOne
	@Basic(optional = true)
	@JoinColumn(name = "IDCOBRANZA")
	public Cobranza getCobranza() {
		return cobranza;
	}

	/**
	 * @param pCobranza Establece el valor del atributo cobranza.
	 */
	public void setCobranza(Cobranza pCobranza) {
		cobranza = pCobranza;
	}

	/**
	 * @return Retorna el valor del atributo pago.
	 */
	@ManyToOne
	@Basic(optional = true)
	@JoinColumn(name = "IDPAGO")
	public Pago getPago() {
		return pago;
	}

	/**
	 * @param pPago Establece el valor del atributo pago.
	 */
	public void setPago(Pago pPago) {
		pago = pPago;
	}

	/**
	 * @return Retorna el valor del atributo fechaVencimiento.
	 */
	@Basic(optional = true)
	@Column(name = "FECHAVENCIMIENTO")
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
	@Basic(optional = true)
	@Column(name = "EMISOR")
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
	@Basic(optional = true)
	@Column(name = "CUIT")
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
		if (!(pObj instanceof Cheque)) {
			return false;
		}

		Cheque other = (Cheque) pObj;
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
		builder.append("Cheque [id=");
		builder.append(this.id);

		builder.append(", monto=");
		builder.append(this.monto);
		builder.append(", fecha=");
		builder.append(this.fecha);

		builder.append(", cuenta=");
		builder.append(this.cuenta);

		if (this.banco != null) {
			builder.append(", banco(id)=");
			builder.append(this.banco.getId());
		}
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
