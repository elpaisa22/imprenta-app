/**
 * application-domain [16/08/2012 20:52:51]
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
import org.ambar.appl.commons.enums.TipoComprobanteValues;
import org.ambar.appl.commons.enums.TipoFacturaValues;
import org.ambar.core.be.Persistible;
import org.ambar.core.be.TrackInfo;
import org.ambar.core.be.Trackingable;
import org.ambar.core.be.Versionable;
import org.ambar.core.enums.converters.dozer.EnumConverter;

/**
 * <p>
 * Entidad Factura.
 * </p>
 *
 * @author Sebastian
 *
 */
@Entity
@Table(name = "AP_FACTURA")
public class Factura implements Persistible<Long>, Trackingable, Versionable {

	private Long id;
	private TipoFacturaValues tipoFactura;
	private Date fechaEmision;
	private CondicionVentaValues condicionVenta;
	private Cliente cliente;
	private Remito remito;
	private EstadoPagoFacturaValues estadoPago;
	private BigDecimal importeTotal;
	private BigDecimal saldo;

	private Cobranza cobranza;

	private List<DetalleFactura> coleccionDetalleFacturas;

	private TrackInfo trackInfo;
	private int version;

	/**
	 * Constructor Default.
	 */
	public Factura() {
		this.coleccionDetalleFacturas = new ArrayList<DetalleFactura>();
		this.importeTotal = BigDecimal.ZERO;
		this.saldo = BigDecimal.ZERO;
	}

	/* (non-JSDoc)
	 * @see org.ambar.core.be.Persistible#getId()
	 */
	@Override
	@Id
    @Column(name = "IDFACTURA")
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
	 * @return Retorna el valor del atributo tipoFactura.
	 */
	@Transient
	public TipoFacturaValues getTipoFactura() {
		return tipoFactura;
	}

	/**
	 * @param pTipoFactura Establece el valor del atributo tipoFactura.
	 */
	public void setTipoFactura(TipoFacturaValues pTipoFactura) {
		tipoFactura = pTipoFactura;
	}

	/**
	 * @param pTipoFactura Establece el valor del atributo tipoFactura a partir
	 * de un {@link String}.
	 */
	@SuppressWarnings("unused")
	private void setTipoFacturaPersistent(String pTipoFactura) {
		this.tipoFactura = EnumConverter.getEnumFromString(TipoFacturaValues.class, pTipoFactura);
	}

	/**
	 * @return {@link String} Tipo de Factura
	 */
	@Basic(optional = true)
	@Column(name = "TIPOFACTURA")
	private String getTipoFacturaPersistent() {
		if (this.tipoFactura == null) {
			return null;
		} else {
			return this.tipoFactura.getValor();
		}
	}

	/**
	 * @return Retorna el valor del atributo fechaEmision.
	 */
	@Basic(optional = true)
	@Column(name = "FECHAEMISION")
	public Date getFechaEmision() {
		return fechaEmision;
	}

	/**
	 * @param pFechaEmision Establece el valor del atributo fechaEmision.
	 */
	public void setFechaEmision(Date pFechaEmision) {
		fechaEmision = pFechaEmision;
	}

	/**
	 * @return Retorna el valor del atributo coleccionDetalleFacturas.
	 */
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "factura")
	@Valid
	public List<DetalleFactura> getColeccionDetalleFacturas() {
		return coleccionDetalleFacturas;
	}

	/**
	 * @param pColeccionDetalleFacturas Establece el valor del atributo coleccionDetalleFacturas.
	 */
	public void setColeccionDetalleFacturas(List<DetalleFactura> pColeccionDetalleFacturas) {
		coleccionDetalleFacturas = pColeccionDetalleFacturas;
	}

	/**
	 * Agrega una DetalleFactura.
	 * @param pElement DetalleFactura a agregar
	 */
	public void agregarDetalleFactura(final DetalleFactura pElement) {
		pElement.setFactura(this);
		this.coleccionDetalleFacturas.add(pElement);
	}

	/**
	 * Remueve una DetalleFactura.
	 * @param pElement DetalleFactura a remover
	 */
	public void removerDetalleFactura(final DetalleFactura pElement) {
		this.coleccionDetalleFacturas.remove(pElement);
		pElement.setFactura(null);
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
	@Column(name = "CONDICIONVENTA")
	private String getCondicionVentaPersistent() {
		if (this.condicionVenta == null) {
			return null;
		} else {
			return this.condicionVenta.getValor();
		}
	}

	/**
	 * @return Retorna el valor del atributo cliente.
	 */
	@ManyToOne
	@Basic(optional = false)
	@JoinColumn(name = "IDCLIENTE")
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
	 * @return Retorna el valor del atributo remito.
	 */
	@ManyToOne
	@Basic(optional = true)
	@JoinColumn(name = "IDREMITO")
	public Remito getRemito() {
		return remito;
	}

	/**
	 * @param pRemito Establece el valor del atributo remito.
	 */
	public void setRemito(Remito pRemito) {
		remito = pRemito;
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
	 * @return Retorna el valor del atributo cobranza.
	 */
	@Transient
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
	 * Retorna el tipo de comprobante al que pertenece.
	 * @return {@link TipoComprobanteValues} Tipo de Comprobante
	 * */
	@Transient
	public TipoComprobanteValues getTipoComprobante() {
		if (this.tipoFactura.equals(TipoFacturaValues.A)) {
			return TipoComprobanteValues.FACTURA_A;
		} else if (this.tipoFactura.equals(TipoFacturaValues.B)) {
			return TipoComprobanteValues.FACTURA_B;
		}
		return null;
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

	/**
	 * Retorna el importe de iva de la Factura.
	 * @return {@link BigDecimal} Importe IVA
	 * */
	@Transient
	public BigDecimal getImporteIVA() {
		BigDecimal iva = new BigDecimal("21");
		BigDecimal total = new BigDecimal("100");
		return iva.multiply(this.importeTotal).divide(total);
	}

	/**
	 * Retorna el importe Sub Total.
	 * @return {@link BigDecimal} Importe Sub Total.
	 * */
	@Transient
	public BigDecimal getImporteSubTotal() {
		return this.importeTotal.subtract(this.getImporteIVA());
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
		if (!(pObj instanceof Factura)) {
			return false;
		}
		Factura other = (Factura) pObj;
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
		builder.append("Factura [id=");
		builder.append(this.id);
		builder.append(", fechaEmision=");
		builder.append(this.fechaEmision);
		builder.append(", condicionVenta=");
		builder.append(this.condicionVenta);
		if (this.cliente != null) {
			builder.append(", cliente(id)=");
			builder.append(this.cliente.getId());
		}
		if (this.remito != null) {
			builder.append(", remito(id)=");
			builder.append(this.remito.getId());
		}
		builder.append(", estadoPago=");
		builder.append(this.estadoPago);
		builder.append(", trackInfo=");
		builder.append(this.trackInfo);
		builder.append(", version=");
		builder.append(this.version);
		builder.append("]");
		return builder.toString();
	}

}
