/**
 * application-domain [1/7/2015 21:43:57]
 */
package org.ambar.appl.be;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.Valid;

import org.ambar.core.be.Persistible;
import org.ambar.core.be.TrackInfo;
import org.ambar.core.be.Trackingable;
import org.ambar.core.be.Versionable;

/**
 * <p>
 * Entidad que representa una Cuenta Bancaria.
 * </p>
 *
 * @author Sebastian
 *
 */
@Entity
@Table(name = "AP_CUENTABANCARIA")
public class CuentaBancaria implements Persistible<Long>, Trackingable, Versionable {

	private Long id;
	private BigDecimal saldo;

	private Banco banco;
	private String sucursal;

	private List<MovimientoCuentaBancaria> coleccionMovimientos;

	private TrackInfo trackInfo;
	private int version;

	/**
	 * Constructor default.
	 * */
	public CuentaBancaria() {
		this.coleccionMovimientos = new ArrayList<MovimientoCuentaBancaria>();

		this.saldo = BigDecimal.ZERO;
	}

	/* (non-JSDoc)
	 * @see org.ambar.core.be.Persistible#getId()
	 */
	@Override
	@Id
	@Column(name = "IDCUENTA")
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
	 * @return Retorna el valor del atributo saldo.
	 */
	@Basic(optional = false)
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
	 * @return Retorna el valor del atributo coleccionMovimientos.
	 */
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "cuentaBancaria")
	@Valid
	public List<MovimientoCuentaBancaria> getColeccionMovimientos() {
		return coleccionMovimientos;
	}

	/**
	 * @param pColeccionMovimientos Establece el valor del atributo coleccionMovimientos.
	 */
	public void setColeccionMovimientos(List<MovimientoCuentaBancaria> pColeccionMovimientos) {
		coleccionMovimientos = pColeccionMovimientos;
	}

	/**
	 * Agrega una Movimiento.
	 * @param pElement Movimiento a agregar
	 */
	public void agregarMovimiento(final MovimientoCuentaBancaria pElement) {
		this.coleccionMovimientos.add(pElement);
		this.saldo = this.saldo.add(pElement.getImporte());
		pElement.setCuentaBancaria(this);
	}

	/**
	 * Remueve una Movimiento.
	 * @param pElement Movimiento a remover
	 */
	public void removerMovimiento(final MovimientoCuentaBancaria pElement) {
		this.coleccionMovimientos.remove(pElement);
		this.saldo = this.saldo.subtract(pElement.getImporte());
		pElement.setCuentaBancaria(null);
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
		result = prime * result + ((this.getId() == null) ? 0 : this.getId().hashCode());
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
		if (!(pObj instanceof CuentaBancaria)) {
			return false;
		}

		CuentaBancaria other = (CuentaBancaria) pObj;
		if (this.getId() == null) {
			if (other.getId() != null) {
				return false;
			}
		} else if (!this.getId().equals(other.getId())) {
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
		builder.append("CuentaBancaria [id=");
		builder.append(this.getId());

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
