/**
 * application-domain [07/01/2014 17:38:45]
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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
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
 * Entidad que representa la cuenta corriente del cliente.
 * </p>
 *
 * @author Sebastian
 *
 */
@Entity
@Table(name = "AP_CUENTACORRIENTE")
public class CuentaCorriente implements Persistible<Long>, Trackingable, Versionable {

	private Long id;
	private Cliente cliente;

	private BigDecimal saldo;

	private List<MovimientoCuentaCorriente> coleccionMovimientos;

	private TrackInfo trackInfo;
	private int version;

	/**
	 * Constructor default.
	 * */
	public CuentaCorriente() {
		this.coleccionMovimientos = new ArrayList<MovimientoCuentaCorriente>();

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
	 * @return Retorna el valor del atributo cliente.
	 */
	@OneToOne
	@JoinColumn(name = "IDCLIENTE", unique = true)
	@Basic(optional = false)
	@NotNull(message = "{org.ambar.appl.be.CuentaCorriente.cliente.NotNull}")
	public Cliente getCliente() {
		return cliente;
	}

	/**
	 * @param pCliente Establece el valor del atributo cliente.
	 */
	public void setCliente(Cliente pCliente) {
		cliente = pCliente;
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
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "cuentaCorriente")
    @OrderBy("id desc")
	@Valid
	public List<MovimientoCuentaCorriente> getColeccionMovimientos() {
		return coleccionMovimientos;
	}

	/**
	 * @param pColeccionMovimientos Establece el valor del atributo coleccionMovimientos.
	 */
	public void setColeccionMovimientos(List<MovimientoCuentaCorriente> pColeccionMovimientos) {
		coleccionMovimientos = pColeccionMovimientos;
	}

	/**
	 * Agrega una Movimiento.
	 * @param pElement Movimiento a agregar
	 */
	public void agregarMovimiento(final MovimientoCuentaCorriente pElement) {
		this.coleccionMovimientos.add(pElement);
		this.saldo = this.saldo.add(pElement.getSaldo());
		pElement.setSaldo(this.saldo);
		pElement.setCuentaCorriente(this);
	}

	/**
	 * Remueve una Movimiento.
	 * @param pElement Movimiento a remover
	 */
	public void removerMovimiento(final MovimientoCuentaCorriente pElement) {
		this.coleccionMovimientos.remove(pElement);
		this.saldo = this.saldo.subtract(pElement.getSaldo());
		pElement.setSaldo(this.saldo);
		pElement.setCuentaCorriente(null);
	}

	/**
	 * Busca en los detalles de la cuenta por Factura.
	 * @param pFactura Factura
	 * @return {@link MovimientoCuentaCorriente} Detalle
	 */
	@Transient
	public MovimientoCuentaCorriente getByFactura(final Factura pFactura) {
		Predicate condition = new Predicate() {
			@Override
			public boolean evaluate(Object pObject) {
				 return (((MovimientoCuentaCorriente) pObject).getFactura() != null)
						 && ((MovimientoCuentaCorriente) pObject).getFactura().equals(pFactura);
			}
		};

		@SuppressWarnings("unchecked")
		List<MovimientoCuentaCorriente> result = (List<MovimientoCuentaCorriente>)
		                                              CollectionUtils.select(this.coleccionMovimientos,
				                                                             condition);
		if (result != null && result.size() > 0) {
			return result.get(0);
		} else {
			return null;
		}
	}


	/**
	 * Busca en los detalles de la cuenta por Cobranza.
	 * @param pCobranza Cobranza
	 * @return {@link MovimientoCuentaCorriente} Detalle
	 */
	@Transient
	public MovimientoCuentaCorriente getByCobranza(final Cobranza pCobranza) {
		Predicate condition = new Predicate() {
			@Override
			public boolean evaluate(Object pObject) {
				 return (((MovimientoCuentaCorriente) pObject).getCobranza() != null)
                        && ((MovimientoCuentaCorriente) pObject).getCobranza().equals(pCobranza);
			}
		};

		@SuppressWarnings("unchecked")
		List<MovimientoCuentaCorriente> result = (List<MovimientoCuentaCorriente>)
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
		if (!(pObj instanceof CuentaCorriente)) {
			return false;
		}

		CuentaCorriente other = (CuentaCorriente) pObj;
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
		builder.append("CuentaCorriente [id=");
		builder.append(this.getId());

		if (this.cliente != null) {
			builder.append(", cliente(id)=");
			builder.append(this.cliente.getId());
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
