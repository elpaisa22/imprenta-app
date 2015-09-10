/**
 * application-domain [15/02/2014 12:38:43]
 */
package org.ambar.appl.be;

import java.math.BigDecimal;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Version;

import org.ambar.core.be.Persistible;
import org.ambar.core.be.TrackInfo;
import org.ambar.core.be.Trackingable;
import org.ambar.core.be.Versionable;

/**
 * <p>
 * Entidad Articulo.
 * </p>
 *
 * @author Sebastian
 *
 */
@Entity
@Table(name = "AP_ARTICULO")
public class Articulo implements Persistible<String>, Trackingable, Versionable {

	private String id;

	private String descripcion;
	private Marca marca;
	private BigDecimal costo;
	private BigDecimal porcGanancia;
	private BigDecimal porcIva;
	private Rubro rubro;
	private Integer stock;
	private Integer stockMinimo;
	private Boolean costoEnDolares;
	private BigDecimal precioNeto;
	private BigDecimal precioBruto;

	private TrackInfo trackInfo;
	private int version;



	/* (non-JSDoc)
	 * @see org.ambar.core.be.Persistible#getId()
	 */
	@Override
	@Id
    @Column(name = "IDARTICULO")
	public String getId() {
		return this.id;
	}

	/* (non-JSDoc)
	 * @see org.ambar.core.be.Persistible#setId(java.lang.Object)
	 */
	@Override
	public void setId(String pId) {
		this.id = pId;
	}

	/**
	 * @return Retorna el valor del atributo descripcion.
	 */
	@Column(name = "DESCRIPCION")
	@Basic(optional = true)
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
	 * @return Retorna el valor del atributo marca.
	 */
	@ManyToOne
	@Basic(optional = false)
	@JoinColumn(name = "IDMARCA")
	public Marca getMarca() {
		return marca;
	}

	/**
	 * @param pMarca Establece el valor del atributo marca.
	 */
	public void setMarca(Marca pMarca) {
		marca = pMarca;
	}

	/**
	 * @return Retorna el valor del atributo costo.
	 */
	@Column(name = "COSTO")
	@Basic(optional = true)
	public BigDecimal getCosto() {
		return costo;
	}

	/**
	 * @param pCosto Establece el valor del atributo costo.
	 */
	public void setCosto(BigDecimal pCosto) {
		costo = pCosto;
	}

	/**
	 * @return Retorna el valor del atributo porcGanancia.
	 */
	@Column(name = "PORCENTAJEGANANCIA")
	@Basic(optional = true)
	public BigDecimal getPorcGanancia() {
		return porcGanancia;
	}

	/**
	 * @param pPorcGanancia Establece el valor del atributo porcGanancia.
	 */
	public void setPorcGanancia(BigDecimal pPorcGanancia) {
		porcGanancia = pPorcGanancia;
	}

	/**
	 * @return Retorna el valor del atributo porcIva.
	 */
	@Column(name = "PORCENTAJEIVA")
	@Basic(optional = true)
	public BigDecimal getPorcIva() {
		return porcIva;
	}

	/**
	 * @param pPorcIva Establece el valor del atributo porcIva.
	 */
	public void setPorcIva(BigDecimal pPorcIva) {
		porcIva = pPorcIva;
	}

	/**
	 * @return Retorna el valor del atributo rubro.
	 */
	@ManyToOne
	@Basic(optional = false)
	@JoinColumn(name = "IDRUBRO")
	public Rubro getRubro() {
		return rubro;
	}

	/**
	 * @param pRubro Establece el valor del atributo rubro.
	 */
	public void setRubro(Rubro pRubro) {
		rubro = pRubro;
	}

	/**
	 * @return Retorna el valor del atributo stock.
	 */
	@Column(name = "STOCK")
	@Basic(optional = true)
	public Integer getStock() {
		return stock;
	}

	/**
	 * @param pStock Establece el valor del atributo stock.
	 */
	public void setStock(Integer pStock) {
		stock = pStock;
	}

	/**
	 * @return Retorna el valor del atributo stockMinimo.
	 */
	@Column(name = "STOCKMINIMO")
	@Basic(optional = true)
	public Integer getStockMinimo() {
		return stockMinimo;
	}

	/**
	 * @param pStockMinimo Establece el valor del atributo stockMinimo.
	 */
	public void setStockMinimo(Integer pStockMinimo) {
		stockMinimo = pStockMinimo;
	}

	/**
	 * @return Retorna el valor del atributo costoEnDolares.
	 */
	@Column(name = "ENDOLARES")
	@Basic(optional = true)
	public Boolean getCostoEnDolares() {
		return costoEnDolares;
	}

	/**
	 * @param pCostoEnDolares Establece el valor del atributo costoEnDolares.
	 */
	public void setCostoEnDolares(Boolean pCostoEnDolares) {
		costoEnDolares = pCostoEnDolares;
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
	 * Calcula el precio final.
	 * @return {@link BigDecimal} Precio final calculado
	 * */
	@Transient
	public BigDecimal getPrecioNeto() {
		this.precioNeto = this.costo;

		if (this.porcGanancia.compareTo(BigDecimal.ZERO) != 0) {
			BigDecimal ganancia = precioNeto.multiply(this.porcGanancia.divide(new BigDecimal("100")));
			this.precioNeto = this.costo.add(ganancia);
		}

		return this.precioNeto;
	}

	/**
	 * Simula para el mapper que setea el campo de precio final.
	 * @param pPrecioNeto Precio Final
	 * */
	public void setPrecioNeto(BigDecimal pPrecioNeto) {
		this.precioNeto = pPrecioNeto;
	}

	/**
	 * @return Retorna el valor del atributo precioBruto.
	 */
	@Transient
	public BigDecimal getPrecioBruto() {
		this.precioBruto = this.costo;

		if (this.porcGanancia.compareTo(BigDecimal.ZERO) != 0) {
			BigDecimal ganancia = precioBruto.multiply(this.porcGanancia.divide(new BigDecimal("100")));
			this.precioBruto = this.costo.add(ganancia);

			BigDecimal iva = precioBruto.multiply(this.porcIva.divide(new BigDecimal("100")));
			this.precioBruto = this.precioBruto.add(iva);
		}

		return precioBruto;
	}

	/**
	 * @param pPrecioBruto Establece el valor del atributo precioBruto.
	 */
	public void setPrecioBruto(BigDecimal pPrecioBruto) {
		precioBruto = pPrecioBruto;
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
		if (!(pObj instanceof Articulo)) {
			return false;
		}

		Articulo other = (Articulo) pObj;
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
		builder.append("Articulo [id=");
		builder.append(this.id);

		builder.append(", descripcion=");
		builder.append(this.descripcion);
		if (this.marca != null) {
			builder.append(", marca(id)=");
			builder.append(this.marca.getId());
		}
		builder.append(", costo=");
		builder.append(this.costo);
		builder.append(", porcGanancia=");
		builder.append(this.porcGanancia);
		builder.append(", porcIva=");
		builder.append(this.porcIva);
		if (this.rubro != null) {
			builder.append(", rubro(id)=");
			builder.append(this.rubro.getId());
		}
		builder.append(", stock=");
		builder.append(this.stock);
		builder.append(", stockMinimo=");
		builder.append(this.stockMinimo);
		builder.append(", costoEnDolares=");
		builder.append(this.costoEnDolares);

		builder.append(", trackInfo=");
		builder.append(this.trackInfo);
		builder.append(", version=");
		builder.append(this.version);
		builder.append("]");
		return builder.toString();
	}
}
