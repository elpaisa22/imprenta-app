/**
 * application-domain [21/08/2012 01:08:52]
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
import javax.persistence.Transient;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

import org.ambar.core.be.Persistible;
import org.ambar.core.be.TrackInfo;
import org.ambar.core.be.Trackingable;
import org.ambar.core.be.Versionable;

/**
 * <p>
 * Entidad que representa los movimientos de la Cuenta Corriente del Cliente.
 * </p>
 *
 * @author Sebastian
 *
 */
@Entity
@Table(name = "AP_MOVIMIENTOCUENTACORRIENTE")
public class MovimientoCuentaCorriente implements Persistible<Long>, Trackingable, Versionable {

	private Long id;

	private CuentaCorriente cuentaCorriente;

	private String descripcion;
	private BigDecimal saldo;
	private Date fecha;

	private Factura factura;
	private Cobranza cobranza;

	private TrackInfo trackInfo;
	private int version;

	/**
	 * Constructor default.
	 * */
	public MovimientoCuentaCorriente() {
		this.fecha = new Date();
	}

	/* (non-JSDoc)
	 * @see org.ambar.core.be.Persistible#getId()
	 */
	@Override
	@Id
    @Column(name = "IDMOVIMIENTO")
	@GeneratedValue(strategy = GenerationType.AUTO)
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
	 * @return Retorna el valor del atributo factura.
	 */
	@ManyToOne
	@Basic(optional = true)
	@JoinColumn(name = "IDFACTURA")
	public Factura getFactura() {
		return factura;
	}

	/**
	 * @param pFactura Establece el valor del atributo factura.
	 */
	public void setFactura(Factura pFactura) {
		this.factura = pFactura;
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
	 * @return Retorna el valor del atributo cuentaCorriente.
	 */
	@JoinColumn(name = "IDCUENTACORRIENTE")
	@NotNull(message = "{org.ambar.appl.be.MovimientoCuentaCorriente.cuentaCorriente.NotNull}")
	@ManyToOne
	public CuentaCorriente getCuentaCorriente() {
		return cuentaCorriente;
	}

	/**
	 * @param pCuentaCorriente Establece el valor del atributo cuentaCorriente.
	 */
	public void setCuentaCorriente(CuentaCorriente pCuentaCorriente) {
		cuentaCorriente = pCuentaCorriente;
	}

	/**
	 * @return Retorna el valor del atributo descripcion.
	 */
	@Basic(optional = true)
	@Column(name = "DESCRIPCION")
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
	@Column(name = "SALDO")
	public BigDecimal getSaldo() {
		return saldo;
	}

	/**
	 * @param pSaldo Establece el valor del atributo saldo.
	 */
	public void setSaldo(BigDecimal pSaldo) {
		saldo = pSaldo;
	}

	/**
	 * Calcula el importe del movimiento.
	 * @return {@link BigDecimal} Importe Movimiento
	 * */
	@Transient
	public BigDecimal getImporteMovimiento() {
		if (this.factura != null) {
			if (cobranza != null) {
				return this.factura.getImporteTotal().subtract(cobranza.getImporteTotal());
			} else {
				return this.factura.getImporteTotal();
			}
		} else if (this.cobranza != null) {
			return this.cobranza.getImporteTotal().negate();
		} else {
			return BigDecimal.ZERO;
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
		MovimientoCuentaCorriente other = (MovimientoCuentaCorriente) pObj;
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
		builder.append("Movimiento [id=");
		builder.append(this.id);
		builder.append(", trackInfo=");
		builder.append(this.trackInfo);
		builder.append(", version=");
		builder.append(this.version);
		builder.append("]");
		return builder.toString();
	}

}
