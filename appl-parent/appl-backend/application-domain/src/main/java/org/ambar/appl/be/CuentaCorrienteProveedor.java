/**
 * application-domain [15/6/2015 16:26:42]
 */
package org.ambar.appl.be;

import java.beans.Transient;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.ambar.core.be.Persistible;
import org.ambar.core.be.TrackInfo;
import org.ambar.core.be.Trackingable;
import org.ambar.core.be.Versionable;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;

/**
 * <p>
 * Entidad que representa la cuenta corriente del proveedor.
 * </p>
 *
 * @author Sebastian
 *
 */
@Entity
@Table(name = "AP_CUENTACORRIENTEPROVEEDOR")
public class CuentaCorrienteProveedor implements Persistible<Long>, Trackingable, Versionable {

	private Long id;
	private Proveedor proveedor;
	private BigDecimal saldo;
	private List<MovimientoCuentaCorrienteProveedor> coleccionMovimientos;

	private TrackInfo trackInfo;
	private int version;

	/**
	 * Constructor default.
	 * */
	public CuentaCorrienteProveedor() {
		this.coleccionMovimientos = new ArrayList<MovimientoCuentaCorrienteProveedor>();

		this.saldo = BigDecimal.ZERO;
	}

	/* (non-JSDoc)
	 * @see org.ambar.core.be.Persistible#getId()
	 */
	@Override
	@Id
	@Column(name = "IDCUENTACORRIENTE")
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
	 * @return Retorna el valor del atributo proveedor.
	 */
	@OneToOne
	@JoinColumn(name = "IDPROVEEDOR", unique = true)
	@Basic(optional = false)
	@NotNull(message = "{org.ambar.appl.be.CuentaCorrienteProveedor.proveedor.NotNull}")
	public Proveedor getProveedor() {
		return proveedor;
	}

	/**
	 * @param pProveedor Establece el valor del atributo proveedor.
	 */
	public void setProveedor(Proveedor pProveedor) {
		proveedor = pProveedor;
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
	 * @return Retorna el valor del atributo coleccionMovimientos.
	 */
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "cuentaCorriente", fetch = FetchType.EAGER)
	@Valid
	public List<MovimientoCuentaCorrienteProveedor> getColeccionMovimientos() {
		return coleccionMovimientos;
	}

	/**
	 * @param pColeccionMovimientos Establece el valor del atributo coleccionMovimientos.
	 */
	public void setColeccionMovimientos(List<MovimientoCuentaCorrienteProveedor> pColeccionMovimientos) {
		coleccionMovimientos = pColeccionMovimientos;
	}

	/**
	 * Agrega una Movimiento.
	 * @param pElement Movimiento a agregar
	 */
	public void agregarMovimiento(final MovimientoCuentaCorrienteProveedor pElement) {
		this.coleccionMovimientos.add(pElement);
		this.saldo = this.saldo.add(pElement.getImporteMovimiento());
		pElement.setCuentaCorriente(this);
	}

	/**
	 * Remueve una Movimiento.
	 * @param pElement Movimiento a remover
	 */
	public void removerMovimiento(final MovimientoCuentaCorrienteProveedor pElement) {
		this.coleccionMovimientos.remove(pElement);
		this.saldo = this.saldo.subtract(pElement.getImporteMovimiento());
		pElement.setCuentaCorriente(null);
	}

	/**
	 * Busca en los detalles de la cuenta por Compra.
	 * @param pCompra Compra
	 * @return {@link MovimientoCuentaCorrienteProveedor} Detalle
	 */
	@Transient
	public MovimientoCuentaCorrienteProveedor getByCompra(final Compra pCompra) {
		Predicate condition = new Predicate() {
			@Override
			public boolean evaluate(Object pObject) {
				 return (((MovimientoCuentaCorrienteProveedor) pObject).getCompra() != null)
                         && ((MovimientoCuentaCorrienteProveedor) pObject).getCompra().equals(pCompra);
			}
		};

		@SuppressWarnings("unchecked")
		List<MovimientoCuentaCorrienteProveedor> result = (List<MovimientoCuentaCorrienteProveedor>)
		                                              CollectionUtils.select(this.coleccionMovimientos,
				                                                             condition);
		if (result != null && result.size() > 0) {
			return result.get(0);
		} else {
			return null;
		}
	}


	/**
	 * Busca en los detalles de la cuenta por Pago.
	 * @param pPago Pago
	 * @return {@link MovimientoCuentaCorrienteProveedor} Detalle
	 */
	@Transient
	public MovimientoCuentaCorrienteProveedor getByPago(final Pago pPago) {
		Predicate condition = new Predicate() {
			@Override
			public boolean evaluate(Object pObject) {
				 return (((MovimientoCuentaCorrienteProveedor) pObject).getPago() != null)
                        && ((MovimientoCuentaCorrienteProveedor) pObject).getPago().equals(pPago);
			}
		};

		@SuppressWarnings("unchecked")
		List<MovimientoCuentaCorrienteProveedor> result = (List<MovimientoCuentaCorrienteProveedor>)
		                                              CollectionUtils.select(this.coleccionMovimientos,
				                                                             condition);
		if (result != null && result.size() > 0) {
			return result.get(0);
		} else {
			return null;
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
		if (!(pObj instanceof CuentaCorrienteProveedor)) {
			return false;
		}

		CuentaCorrienteProveedor other = (CuentaCorrienteProveedor) pObj;
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
		builder.append("CuentaCorrienteProveedor [id=");
		builder.append(this.getId());

		if (this.proveedor != null) {
			builder.append(", proveedor(id)=");
			builder.append(this.proveedor.getId());
		}

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
