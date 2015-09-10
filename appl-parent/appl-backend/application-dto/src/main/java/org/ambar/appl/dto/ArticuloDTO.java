/**
 * application-dto [15/02/2014 13:11:45]
 */
package org.ambar.appl.dto;

import java.math.BigDecimal;

import org.ambar.core.dto.DTO;
import org.ambar.core.dto.TrackInfoDTO;
import org.ambar.core.dto.TrackingableDTO;
import org.ambar.core.dto.VersionableDTO;

/**
 * <p>
 * DTO a ser usado en las transacciones CRUD correspondiente a la
 * entidad {@link org.ambar.appl.be.Articulo}.
 * </p>
 *
 * @author Sebastian
 *
 */
public class ArticuloDTO implements DTO<String>, TrackingableDTO, VersionableDTO {

	private static final long serialVersionUID = 1109183405707583506L;

	private String id;

	private String descripcion;
	private String idMarca;
	private String descripcionMarca;
	private BigDecimal costo;
	private BigDecimal porcGanancia;
	private BigDecimal porcIva;
	private String idRubro;
	private String descripcionRubro;
	private Integer stock;
	private Integer stockMinimo;
	private Boolean costoEnDolares;

	private BigDecimal precioNeto;
	private BigDecimal precioBruto;

	private TrackInfoDTO trackInfo;
	private int version;

	/**
	 * Constructor default.
	 * */
	public ArticuloDTO() {
		this.costo = new BigDecimal("0.00");
		this.porcIva = new BigDecimal("21.00");
		this.stock = 0;
		this.stockMinimo = 0;
		this.porcGanancia = new BigDecimal("0.00");

		this.precioBruto = new BigDecimal("0.00");
		this.precioNeto = new BigDecimal("0.00");
	}

	/* (non-JSDoc)
	 * @see org.ambar.core.dto.DTO#getId()
	 */
	@Override
	public String getId() {
		return this.id;
	}

	/* (non-JSDoc)
	 * @see org.ambar.core.dto.DTO#setId(java.lang.Object)
	 */
	@Override
	public void setId(String pId) {
		this.id = pId;
	}

	/**
	 * @return Retorna el valor del atributo descripcion.
	 */
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
	 * @return Retorna el valor del atributo idMarca.
	 */
	public String getIdMarca() {
		return idMarca;
	}

	/**
	 * @param pIdMarca Establece el valor del atributo idMarca.
	 */
	public void setIdMarca(String pIdMarca) {
		idMarca = pIdMarca;
	}

	/**
	 * @return Retorna el valor del atributo descripcionMarca.
	 */
	public String getDescripcionMarca() {
		return descripcionMarca;
	}

	/**
	 * @param pDescripcionMarca Establece el valor del atributo descripcionMarca.
	 */
	public void setDescripcionMarca(String pDescripcionMarca) {
		descripcionMarca = pDescripcionMarca;
	}

	/**
	 * @return Retorna el valor del atributo costo.
	 */
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
	 * @return Retorna el valor del atributo idRubro.
	 */
	public String getIdRubro() {
		return idRubro;
	}

	/**
	 * @param pIdRubro Establece el valor del atributo idRubro.
	 */
	public void setIdRubro(String pIdRubro) {
		idRubro = pIdRubro;
	}

	/**
	 * @return Retorna el valor del atributo descripcionRubro.
	 */
	public String getDescripcionRubro() {
		return descripcionRubro;
	}

	/**
	 * @param pDescripcionRubro Establece el valor del atributo descripcionRubro.
	 */
	public void setDescripcionRubro(String pDescripcionRubro) {
		descripcionRubro = pDescripcionRubro;
	}

	/**
	 * @return Retorna el valor del atributo stock.
	 */
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
	public Boolean getCostoEnDolares() {
		return costoEnDolares;
	}

	/**
	 * @param pCostoEnDolares Establece el valor del atributo costoEnDolares.
	 */
	public void setCostoEnDolares(Boolean pCostoEnDolares) {
		costoEnDolares = pCostoEnDolares;
	}

	/**
	 * @return Retorna el valor del atributo precioNeto.
	 */
	public BigDecimal getPrecioNeto() {
		return precioNeto;
	}

	/**
	 * @param pPrecioNeto Establece el valor del atributo precioNeto.
	 */
	public void setPrecioNeto(BigDecimal pPrecioNeto) {
		precioNeto = pPrecioNeto;
	}

	/**
	 * @return Retorna el valor del atributo precioBruto.
	 */
	public BigDecimal getPrecioBruto() {
		return precioBruto;
	}

	/**
	 * @param pPrecioBruto Establece el valor del atributo precioBruto.
	 */
	public void setPrecioBruto(BigDecimal pPrecioBruto) {
		precioBruto = pPrecioBruto;
	}

	/* (non-JSDoc)
	 * @see org.ambar.core.dto.VersionableDTO#getVersion()
	 */
	@Override
	public int getVersion() {
		return this.version;
	}

	/* (non-JSDoc)
	 * @see org.ambar.core.dto.VersionableDTO#setVersion(int)
	 */
	@Override
	public void setVersion(int pVersion) {
		this.version = pVersion;
	}

	/* (non-JSDoc)
	 * @see org.ambar.core.dto.TrackingableDTO#getTrackInfo()
	 */
	@Override
	public TrackInfoDTO getTrackInfo() {
		return this.trackInfo;
	}

	/* (non-JSDoc)
	 * @see org.ambar.core.dto.TrackingableDTO#setTrackInfo(org.ambar.core.dto.TrackInfoDTO)
	 */
	@Override
	public void setTrackInfo(TrackInfoDTO pTrackInfo) {
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
		if (!(pObj instanceof ArticuloDTO)) {
			return false;
		}
		ArticuloDTO other = (ArticuloDTO) pObj;
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
		builder.append("ArticuloDTO [id=");
		builder.append(this.id);

		builder.append(", descripcion=");
		builder.append(this.descripcion);

		builder.append(", idMarca=");
		builder.append(this.idMarca);
		builder.append(", descripcionMarca=");
		builder.append(this.descripcionMarca);

		builder.append(", costo=");
		builder.append(this.costo);
		builder.append(", porcGanancia=");
		builder.append(this.porcGanancia);
		builder.append(", porcIva=");
		builder.append(this.porcIva);

		builder.append(", idRubro=");
		builder.append(this.idRubro);
		builder.append(", descripcionRubro=");
		builder.append(this.descripcionRubro);

		builder.append(", stock=");
		builder.append(this.stock);
		builder.append(", stockMinimo=");
		builder.append(this.stockMinimo);
		builder.append(", costoEnDolares=");
		builder.append(this.costoEnDolares);

		builder.append(", precioBruto=");
		builder.append(this.precioBruto);
		builder.append(", precioNeto=");
		builder.append(this.precioNeto);

		builder.append(", trackInfo=");
		builder.append(this.trackInfo);
		builder.append(", version=");
		builder.append(this.version);
		builder.append("]");
		return builder.toString();
	}
}
