/**
 * application-domain [22/05/2012 16:43:16]
 */
package org.ambar.appl.be;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Version;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.ambar.appl.commons.constraint.Constraints;
import org.ambar.appl.commons.enums.EstadoOrdenTrabajoValues;
import org.ambar.core.be.Persistible;
import org.ambar.core.be.TrackInfo;
import org.ambar.core.be.Trackingable;
import org.ambar.core.be.Versionable;
import org.ambar.core.enums.converters.dozer.EnumConverter;


/**
 * <p>
 * Entidad OrdenTrabajo.
 * </p>
 *
 * @author Sebastian
 *
 */
@Entity
@Table(name = "AP_ORDENTRABAJO")
public class OrdenTrabajo implements Persistible<Long>, Trackingable, Versionable {

	private Long id;

	private Date fechaInicio;
	private Date fechaEntrega;
	private Date fechaPautada;
	private Cliente cliente;
	private String descripcion;
	private Integer cantidad;
	private EstadoOrdenTrabajoValues estadoOrden;
	private BigDecimal importeTotal;
	private Long ancho;
	private Long alto;
	private String tipoMaterial;
	private Integer coloresFrontales;
	private Integer coloresTraseros;
	private Factura factura;
	private Remito remito;

	private TrackInfo trackInfo;
	private int version;

	/**
	 * Constructor default.
	 * */
	public OrdenTrabajo() {
		this.fechaInicio = new Date();
		this.estadoOrden = EstadoOrdenTrabajoValues.EMITIDA;
	}

	/* (non-JSDoc)
	 * @see org.ambar.core.be.Persistible#getId()
	 */
	@Override
	@Id
    @Column(name = "IDORDENTRABAJO")
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
	 * @return Retorna el valor del atributo fechaInicio.
	 */
	@Basic(optional = false)
    @Column(name = "FECHAINICIO")
	@NotNull(message = "{org.ambar.appl.be.OrdenTrabajo.fechaInicio.NotNull}")
	public Date getFechaInicio() {
		return fechaInicio;
	}

	/**
	 * @param pFechaInicio Establece el valor del atributo fechaInicio.
	 */
	public void setFechaInicio(Date pFechaInicio) {
		fechaInicio = pFechaInicio;
	}

	/**
	 * @return Retorna el valor del atributo fechaEntrega.
	 */
	@Basic(optional = true)
    @Column(name = "FECHAENTREGA")
	public Date getFechaEntrega() {
		return fechaEntrega;
	}

	/**
	 * @param pFechaEntrega Establece el valor del atributo fechaEntrega.
	 */
	public void setFechaEntrega(Date pFechaEntrega) {
		fechaEntrega = pFechaEntrega;
	}

	/**
	 * @return Retorna el valor del atributo fechaPautada.
	 */
	@Basic(optional = true)
    @Column(name = "FECHAPAUTADA")
	public Date getFechaPautada() {
		return fechaPautada;
	}

	/**
	 * @param pFechaPautada Establece el valor del atributo fechaPautada.
	 */
	public void setFechaPautada(Date pFechaPautada) {
		fechaPautada = pFechaPautada;
	}

	/**
	 * @return Retorna el valor del atributo cliente.
	 */
	@ManyToOne
	@Basic(optional = false)
	@JoinColumn(name = "IDCLIENTE")
	@NotNull(message = "{org.ambar.appl.be.OrdenTrabajo.cliente.NotNull}")
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
	 * @return Retorna el valor del atributo descripcion.
	 */
	@Basic(optional = false)
    @Column(name = "DESCRIPCION")
	@NotNull(message = "{org.ambar.appl.be.OrdenTrabajo.descripcion.NotNull}")
	@Size(max = Constraints.STRING40_SIZE_MAX,
		  message = "{org.ambar.appl.be.OrdenTrabajo.descripcion.Size}")
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
	 * @return Retorna el valor del atributo cantidad.
	 */
	@Basic(optional = false)
    @Column(name = "CANTIDAD")
	@NotNull(message = "{org.ambar.appl.be.OrdenTrabajo.cantidad.NotNull}")
	public Integer getCantidad() {
		return cantidad;
	}

	/**
	 * @param pCantidad Establece el valor del atributo cantidad.
	 */
	public void setCantidad(Integer pCantidad) {
		cantidad = pCantidad;
	}

	/**
	 * @return Retorna el valor del atributo estadoOrden.
	 */
	@Transient
	public EstadoOrdenTrabajoValues getEstadoOrden() {
		return estadoOrden;
	}

	/**
	 * @param pEstadoOrden Establece el valor del atributo estadoOrden.
	 */
	public void setEstadoOrden(EstadoOrdenTrabajoValues pEstadoOrden) {
		estadoOrden = pEstadoOrden;
	}

	/**
	 * @param pEstadoOrdenDB Establece el valor del atributo estadoOrden a partir
	 * de un {@link String}.
	 */
	@SuppressWarnings("unused")
	private void setEstadoOrdenPersistent(String pEstadoOrdenDB) {
		this.estadoOrden = EnumConverter.getEnumFromString(EstadoOrdenTrabajoValues.class, pEstadoOrdenDB);
	}

	/**
	 * @return Devuelve un {@link String} con el valor del atributo
	 * tipoDocumento convertido.
	 */
	@Basic(optional = false)
	@Column(name = "ESTADOORDENTRABAJO")
	@NotNull(message = "{org.ambar.appl.be.OrdenTrabajo.estado.NotNull}")
	private String getEstadoOrdenPersistent() {
		if (this.estadoOrden == null) {
			return null;
		} else {
			return this.estadoOrden.toString();
		}
	}

	/**
	 * @return Retorna el valor del atributo importeTotal.
	 */
	@Basic(optional = false)
	@Column(name = "IMPORTETOTAL")
	@NotNull(message = "{org.ambar.appl.be.OrdenTrabajo.importeTotal.NotNull}")
	@Digits(integer = Constraints.IMP17_INT_MAX,
			fraction = Constraints.IMP2_FRAC_MAX,
			message = "{org.ambar.appl.be.OrdenTrabajo.importeTotal.Digits}")
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
	 * @return Retorna el valor del atributo ancho.
	 */
	@Basic(optional = true)
    @Column(name = "ANCHO")
	public Long getAncho() {
		return ancho;
	}

	/**
	 * @param pAncho Establece el valor del atributo ancho.
	 */
	public void setAncho(Long pAncho) {
		ancho = pAncho;
	}

	/**
	 * @return Retorna el valor del atributo alto.
	 */
	@Basic(optional = true)
    @Column(name = "ALTO")
	public Long getAlto() {
		return alto;
	}

	/**
	 * @param pAlto Establece el valor del atributo alto.
	 */
	public void setAlto(Long pAlto) {
		alto = pAlto;
	}

	/**
	 * @return Retorna el valor del atributo tipoMaterial.
	 */
	@Basic(optional = true)
    @Column(name = "TIPOMATERIAL")
	public String getTipoMaterial() {
		return tipoMaterial;
	}

	/**
	 * @param pTipoMaterial Establece el valor del atributo tipoMaterial.
	 */
	public void setTipoMaterial(String pTipoMaterial) {
		tipoMaterial = pTipoMaterial;
	}

	/**
	 * @return Retorna el valor del atributo coloresFrontales.
	 */
	@Basic(optional = true)
    @Column(name = "COLORESFRONTALES")
	public Integer getColoresFrontales() {
		return coloresFrontales;
	}

	/**
	 * @param pColoresFrontales Establece el valor del atributo coloresFrontales.
	 */
	public void setColoresFrontales(Integer pColoresFrontales) {
		coloresFrontales = pColoresFrontales;
	}

	/**
	 * @return Retorna el valor del atributo coloresTraseros.
	 */
	@Basic(optional = true)
    @Column(name = "COLORESTRASEROS")
	public Integer getColoresTraseros() {
		return coloresTraseros;
	}

	/**
	 * @param pColoresTraseros Establece el valor del atributo coloresTraseros.
	 */
	public void setColoresTraseros(Integer pColoresTraseros) {
		coloresTraseros = pColoresTraseros;
	}

	/**
	 * @return Retorna el valor del atributo factura.
	 */
	@Basic(optional = true)
	@JoinColumn(name = "IDFACTURA")
	@ManyToOne
	public Factura getFactura() {
		return factura;
	}

	/**
	 * @param pFactura Establece el valor del atributo factura.
	 */
	public void setFactura(Factura pFactura) {
		factura = pFactura;
	}

	/**
	 * @return Retorna el valor del atributo remito.
	 */
	@JoinColumn(name = "IDREMITO")
	@ManyToOne
	public Remito getRemito() {
		return remito;
	}

	/**
	 * @param pRemito Establece el valor del atributo remito.
	 */
	public void setRemito(Remito pRemito) {
		remito = pRemito;
	}

	/* (non-JSDoc)
	 * @see org.ambar.core.be.Trackingable#getTrackInfo()
	 */
	@Override
	public TrackInfo getTrackInfo() {
		return this.trackInfo;
	}

	/* (non-JSDoc)
	 * @see org.ambar.core.be.Trackingable#setTrackInfo(org.ambar.core.be.TrackInfo)
	 */
	@Override
	public void setTrackInfo(TrackInfo pTrackInfo) {
		this.trackInfo = pTrackInfo;
	}

	/* (non-JSDoc)
	 * @see org.ambar.core.be.Versionable#getVersion()
	 */
	@Override
	public int getVersion() {
		return this.version;
	}

	/* (non-JSDoc)
	 * @see org.ambar.core.be.Versionable#setVersion(int)
	 */
	@Override
	@Version
	@Column(name = "VERSION", nullable = false)
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
		if (!(pObj instanceof OrdenTrabajo)) {
			return false;
		}
		OrdenTrabajo other = (OrdenTrabajo) pObj;
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
		builder.append("OrdenTrabajo [id=");
		builder.append(this.id);

		builder.append(", fechaInicio=");
		builder.append(this.fechaInicio);
		builder.append(", fechaEntrega=");
		builder.append(this.fechaEntrega);
		builder.append(", fechaPautada=");
		builder.append(this.fechaPautada);
		if (this.cliente != null) {
			builder.append(", cliente(id)=");
			builder.append(this.cliente.getId());
		}
		builder.append(", descripcion=");
		builder.append(this.descripcion);
		builder.append(", cantidad=");
		builder.append(this.cantidad);
		builder.append(", estadoOrden=");
		builder.append(this.estadoOrden);
		builder.append(", importeTotal=");
		builder.append(this.importeTotal);
		builder.append(", ancho=");
		builder.append(this.ancho);
		builder.append(", alto=");
		builder.append(this.alto);
		builder.append(", tipoMaterial=");
		builder.append(this.tipoMaterial);
		builder.append(", coloresFrontales=");
		builder.append(this.coloresFrontales);
		builder.append(", coloresTraseros=");
		builder.append(this.coloresTraseros);

		if (this.factura != null) {
			builder.append(", factura(id)=");
			builder.append(this.factura.getId());
		}

		builder.append(", trackInfo=");
		builder.append(this.trackInfo);
		builder.append(", version=");
		builder.append(this.version);
		builder.append("]");
		return builder.toString();
	}
}
