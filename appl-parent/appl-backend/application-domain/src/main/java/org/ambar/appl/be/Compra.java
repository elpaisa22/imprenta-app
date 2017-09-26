/**
 * application-domain [31/05/2015 17:28:44]
 */
package org.ambar.appl.be;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Version;
import javax.validation.Valid;

import org.ambar.appl.commons.enums.CondicionVentaValues;
import org.ambar.appl.commons.enums.EstadoPagoFacturaValues;
import org.ambar.core.be.Persistible;
import org.ambar.core.be.TrackInfo;
import org.ambar.core.be.Trackingable;
import org.ambar.core.be.Versionable;
import org.ambar.core.enums.converters.dozer.EnumConverter;

/**
 * <p>
 * Entidad Compra.
 * </p>
 *
 * @author Sebastian
 *
 *
 */
@Entity
@Table(name = "AP_COMPRA")
public class Compra implements Persistible<Long>, Trackingable, Versionable {

	private Long id;

	private Date fecha;
	private CondicionVentaValues condicionVenta;
	private Proveedor proveedor;
	private EstadoPagoFacturaValues estadoPago;
	private BigDecimal importeTotal;
	private BigDecimal saldo;

	private List<DetalleCompra> coleccionDetalleCompra;

	private Pago pago;

	private TrackInfo trackInfo;
	private int version;


	/**
	 * Constructor Default.
	 */
	public Compra() {
		this.coleccionDetalleCompra = new ArrayList<DetalleCompra>();
		this.importeTotal = BigDecimal.ZERO;
		this.saldo = BigDecimal.ZERO;
	}

	/* (non-JSDoc)
	 * @see org.ambar.core.be.Persistible#getId()
	 */
	@Override
	@Id
    @Column(name = "IDCOMPRA")
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
	 * @return Retorna el valor del atributo coleccionDetalleCompra.
	 */
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "compra")
	@Valid
	public List<DetalleCompra> getColeccionDetalleCompra() {
		return coleccionDetalleCompra;
	}

	/**
	 * @param pColeccionDetalleCompra Establece el valor del atributo coleccionDetalleCompra.
	 */
	public void setColeccionDetalleCompra(List<DetalleCompra> pColeccionDetalleCompra) {
		coleccionDetalleCompra = pColeccionDetalleCompra;
	}

	/**
	 * Agrega una DetalleCompra.
	 * @param pElement DetalleCompra a agregar
	 */
	public void agregarDetalleCompra(final DetalleCompra pElement) {
		pElement.setCompra(this);
		this.coleccionDetalleCompra.add(pElement);
	}

	/**
	 * Remueve una DetalleCompra.
	 * @param pElement DetalleCompra a remover
	 */
	public void removerDetalleCompra(final DetalleCompra pElement) {
		this.coleccionDetalleCompra.remove(pElement);
		pElement.setCompra(null);
	}

	/**
	 * @return Retorna el valor del atributo condicionVenta.
	 */
	@Transient
	public CondicionVentaValues getCondicionVenta() {
		return condicionVenta;
	}

	/**
	 * @param pCondicionVenta Establece el valor del atributo condicionVenta.
	 */
	public void setCondicionVenta(CondicionVentaValues pCondicionVenta) {
		condicionVenta = pCondicionVenta;
	}


	/**
	 * @param pCondicionVentaDB Establece el valor del atributo condicionVenta a partir
	 * de un {@link String}.
	 */
	@SuppressWarnings("unused")
	private void setCondicionVentaPersistent(String pCondicionVentaDB) {
		this.condicionVenta = EnumConverter.getEnumFromString(CondicionVentaValues.class, pCondicionVentaDB);
	}

	/**
	 * @return {@link String} condicionVenta
	 */
	@Basic(optional = true)
	@Column(name = "CONDICION")
	private String getCondicionVentaPersistent() {
		if (this.condicionVenta == null) {
			return null;
		} else {
			return this.condicionVenta.getValor();
		}
	}

	/**
	 * @return Retorna el valor del atributo proveedor.
	 */
	@ManyToOne
	@Basic(optional = true)
	@JoinColumn(name = "IDPROVEEDOR")
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
	 * @return Retorna el valor del atributo estadoPago.
	 */
	@Transient
	public EstadoPagoFacturaValues getEstadoPago() {
		return estadoPago;
	}

	/**
	 * @param pEstadoPago Establece el valor del atributo estadoPago.
	 */
	public void setEstadoPago(EstadoPagoFacturaValues pEstadoPago) {
		estadoPago = pEstadoPago;
	}

	/**
	 * @param pEstadoPagoDB Establece el valor del atributo estadoPago a partir
	 * de un {@link String}.
	 */
	@SuppressWarnings("unused")
	private void setEstadoPagoPersistent(String pEstadoPagoDB) {
		this.estadoPago = EnumConverter.getEnumFromString(EstadoPagoFacturaValues.class, pEstadoPagoDB);
	}

	/**
	 * @return {@link String} Estado de Movimiento
	 */
	@Basic(optional = true)
	@Column(name = "ESTADOPAGO")
	private String getEstadoPagoPersistent() {
		if (this.estadoPago == null) {
			return null;
		} else {
			return this.estadoPago.getValor();
		}
	}

	/**
	 * @return Retorna el valor del atributo importeTotal.
	 */
	@Basic(optional = false)
	@Column(name = "IMPORTETOTAL")
	public BigDecimal getImporteTotal() {
		return importeTotal;
	}

	/**
	 * @param pImporteTotal Establece el valor del atributo importeTotal.
	 */
	public void setImporteTotal(BigDecimal pImporteTotal) {
		importeTotal = pImporteTotal;
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
	 * @return Retorna el valor del atributo pago.
	 */
	@Transient
	public Pago getPago() {
		return pago;
	}

	/**
	 * @param pPago Establece el valor del atributo pago.
	 */
	public void setPago(Pago pPago) {
		pago = pPago;
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
		if (!(pObj instanceof Compra)) {
			return false;
		}
		Compra other = (Compra) pObj;
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
		builder.append("Compra [id=");
		builder.append(this.id);

		builder.append(", trackInfo=");
		builder.append(this.trackInfo);
		builder.append(", version=");
		builder.append(this.version);
		builder.append("]");
		return builder.toString();
	}
}
