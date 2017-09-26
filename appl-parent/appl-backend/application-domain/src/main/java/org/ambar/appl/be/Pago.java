/**
 * application-domain [8/6/2015 17:51:14]
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

import org.ambar.core.be.Persistible;
import org.ambar.core.be.TrackInfo;
import org.ambar.core.be.Trackingable;
import org.ambar.core.be.Versionable;

/**
 * <p>
 * Entidad Pago.
 * </p>
 *
 * @author Sebastian
 *
 */
@Entity
@Table(name = "AP_PAGO")
public class Pago implements Persistible<Long>, Trackingable, Versionable {

	private Long id;

	private Proveedor proveedor;

	private BigDecimal montoEfectivo;

	private BigDecimal montoTarjetaCredito;
	private String numeroTarjetaCredito;
	private String marcaTarjetaCredito;
	private Banco bancoTarjetaCredito;

	private BigDecimal montoTarjetaDebito;
	private String numeroTarjetaDebito;
	private String marcaTarjetaDebito;
	private Banco bancoTarjetaDebito;

	private List<Cheque> coleccionCheques;
	private List<DetallePago> coleccionDetallePago;

	private Date fecha;

	private TrackInfo trackInfo;
	private int version;

	/**
	 * Constructor default.
	 * */
	public Pago() {
		this.fecha = new Date();

		this.montoEfectivo = BigDecimal.ZERO;
		this.montoTarjetaCredito = BigDecimal.ZERO;
		this.montoTarjetaDebito = BigDecimal.ZERO;

		this.coleccionCheques = new ArrayList<Cheque>();
		this.coleccionDetallePago = new ArrayList<DetallePago>();
	}

	/* (non-JSDoc)
	 * @see org.ambar.core.be.Persistible#getId()
	 */
	@Override
	@Id
    @Column(name = "IDPAGO")
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
	 * @return Retorna el valor del atributo montoEfectivo.
	 */
	@Basic(optional = true)
	@Column(name = "MONTOEFECTIVO")
	public BigDecimal getMontoEfectivo() {
		return montoEfectivo;
	}

	/**
	 * @param pMontoEfectivo Establece el valor del atributo montoEfectivo.
	 */
	public void setMontoEfectivo(BigDecimal pMontoEfectivo) {
		montoEfectivo = pMontoEfectivo;
	}

	/**
	 * @return Retorna el valor del atributo montoTarjetaCredito.
	 */
	@Basic(optional = true)
	@Column(name = "MONTOTARJETACREDITO")
	public BigDecimal getMontoTarjetaCredito() {
		return montoTarjetaCredito;
	}

	/**
	 * @param pMontoTarjetaCredito Establece el valor del atributo montoTarjetaCredito.
	 */
	public void setMontoTarjetaCredito(BigDecimal pMontoTarjetaCredito) {
		montoTarjetaCredito = pMontoTarjetaCredito;
	}

	/**
	 * @return Retorna el valor del atributo numeroTarjetaCredito.
	 */
	@Basic(optional = true)
	@Column(name = "NUMEROTARJETACREDITO")
	public String getNumeroTarjetaCredito() {
		return numeroTarjetaCredito;
	}

	/**
	 * @param pNumeroTarjetaCredito Establece el valor del atributo numeroTarjetaCredito.
	 */
	public void setNumeroTarjetaCredito(String pNumeroTarjetaCredito) {
		numeroTarjetaCredito = pNumeroTarjetaCredito;
	}

	/**
	 * @return Retorna el valor del atributo marcaTarjetaCredito.
	 */
	@Basic(optional = true)
	@Column(name = "MARCATARJETACREDITO")
	public String getMarcaTarjetaCredito() {
		return marcaTarjetaCredito;
	}

	/**
	 * @param pMarcaTarjetaCredito Establece el valor del atributo marcaTarjetaCredito.
	 */
	public void setMarcaTarjetaCredito(String pMarcaTarjetaCredito) {
		marcaTarjetaCredito = pMarcaTarjetaCredito;
	}

	/**
	 * @return Retorna el valor del atributo bancoTarjetaCredito.
	 */
	@ManyToOne
	@Basic(optional = true)
	@JoinColumn(name = "IDBANCOMONTOTARJETACREDITO")
	public Banco getBancoTarjetaCredito() {
		return bancoTarjetaCredito;
	}

	/**
	 * @param pBancoTarjetaCredito Establece el valor del atributo bancoTarjetaCredito.
	 */
	public void setBancoTarjetaCredito(Banco pBancoTarjetaCredito) {
		bancoTarjetaCredito = pBancoTarjetaCredito;
	}

	/**
	 * @return Retorna el valor del atributo montoTarjetaDebito.
	 */
	@Basic(optional = true)
	@Column(name = "MONTOTARJETADEBITO")
	public BigDecimal getMontoTarjetaDebito() {
		return montoTarjetaDebito;
	}

	/**
	 * @param pMontoTarjetaDebito Establece el valor del atributo montoTarjetaDebito.
	 */
	public void setMontoTarjetaDebito(BigDecimal pMontoTarjetaDebito) {
		montoTarjetaDebito = pMontoTarjetaDebito;
	}

	/**
	 * @return Retorna el valor del atributo numeroTarjetaDebito.
	 */
	@Basic(optional = true)
	@Column(name = "NUMEROTARJETADEBITO")
	public String getNumeroTarjetaDebito() {
		return numeroTarjetaDebito;
	}

	/**
	 * @param pNumeroTarjetaDebito Establece el valor del atributo numeroTarjetaDebito.
	 */
	public void setNumeroTarjetaDebito(String pNumeroTarjetaDebito) {
		numeroTarjetaDebito = pNumeroTarjetaDebito;
	}

	/**
	 * @return Retorna el valor del atributo marcaTarjetaDebito.
	 */
	@Basic(optional = true)
	@Column(name = "MARCATARJETADEBITO")
	public String getMarcaTarjetaDebito() {
		return marcaTarjetaDebito;
	}

	/**
	 * @param pMarcaTarjetaDebito Establece el valor del atributo marcaTarjetaDebito.
	 */
	public void setMarcaTarjetaDebito(String pMarcaTarjetaDebito) {
		marcaTarjetaDebito = pMarcaTarjetaDebito;
	}

	/**
	 * @return Retorna el valor del atributo bancoTarjetaDebito.
	 */
	@ManyToOne
	@Basic(optional = true)
	@JoinColumn(name = "IDBANCOBANCOTARJETADEBITO")
	public Banco getBancoTarjetaDebito() {
		return bancoTarjetaDebito;
	}

	/**
	 * @param pBancoTarjetaDebito Establece el valor del atributo bancoTarjetaDebito.
	 */
	public void setBancoTarjetaDebito(Banco pBancoTarjetaDebito) {
		bancoTarjetaDebito = pBancoTarjetaDebito;
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
	 * @return Retorna el valor del atributo proveedor.
	 */
	@ManyToOne
	@Basic(optional = false)
	@JoinColumn(name = "IDCLIENTE")
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
	 * @return Retorna el valor del atributo coleccionCheques.
	 */
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "pago")
	@Valid
	public List<Cheque> getColeccionCheques() {
		return coleccionCheques;
	}

	/**
	 * @param pColeccionCheques Establece el valor del atributo coleccionCheques.
	 */
	public void setColeccionCheques(List<Cheque> pColeccionCheques) {
		coleccionCheques = pColeccionCheques;
	}

	/**
	 * Agrega una Cheque.
	 * @param pElement Cheque a agregar
	 */
	public void agregarCheque(final Cheque pElement) {
		this.coleccionCheques.add(pElement);
		pElement.setPago(this);
	}

	/**
	 * Remueve una Cheque.
	 * @param pElement Cheque a remover
	 */
	public void removerCheque(final Cheque pElement) {
		this.coleccionCheques.remove(pElement);
		pElement.setPago(null);
	}

	/**
	 * @return Retorna el valor del atributo coleccionDetallePago.
	 */
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "pago")
	@Valid
	public List<DetallePago> getColeccionDetallePago() {
		return coleccionDetallePago;
	}

	/**
	 * @param pColeccionDetallePago Establece el valor del atributo coleccionDetallePago.
	 */
	public void setColeccionDetallePago(List<DetallePago> pColeccionDetallePago) {
		coleccionDetallePago = pColeccionDetallePago;
	}

	/**
	 * Agrega una DetallePago.
	 * @param pElement DetallePago a agregar
	 */
	public void agregarDetallePago(final DetallePago pElement) {
		pElement.setPago(this);
		this.coleccionDetallePago.add(pElement);
	}

	/**
	 * Remueve una DetallePago.
	 * @param pElement DetallePago a remover
	 */
	public void removerDetallePago(final DetallePago pElement) {
		this.coleccionDetallePago.remove(pElement);
		pElement.setPago(null);
	}

	/**
	 * Calcula el importe total.
	 * @return {@link BigDecimal} Importe Total
	 * */
	@Transient
	public BigDecimal getImporteTotal() {
		BigDecimal result = BigDecimal.ZERO;
		for (Cheque cheque : this.getColeccionCheques()) {
			result = result.add(cheque.getMonto());
		}
		if (this.getMontoEfectivo() != null) {
			result = result.add(this.getMontoEfectivo());
		}
		if (this.getMontoTarjetaCredito() != null) {
			result = result.add(this.getMontoTarjetaCredito());
		}
		if (this.getMontoTarjetaDebito() != null) {
			result = result.add(this.getMontoTarjetaDebito());
		}
		return result;
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
		if (!(pObj instanceof Pago)) {
			return false;
		}
		Pago other = (Pago) pObj;
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
		builder.append("Pago [id=");
		builder.append(this.id);

		builder.append(", trackInfo=");
		builder.append(this.trackInfo);
		builder.append(", version=");
		builder.append(this.version);
		builder.append("]");
		return builder.toString();
	}
}
