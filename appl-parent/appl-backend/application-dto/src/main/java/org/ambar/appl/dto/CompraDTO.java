/**
 * application-dto [31/05/2015 18:00:07]
 */
package org.ambar.appl.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.ambar.appl.commons.enums.EstadoPagoFacturaValues;
import org.ambar.core.dto.DTO;
import org.ambar.core.dto.TrackInfoDTO;
import org.ambar.core.dto.TrackingableDTO;
import org.ambar.core.dto.VersionableDTO;

/**
 * <p>
 * DTO a ser usado en las transacciones CRUD correspondiente a la
 * entidad {@link org.ambar.appl.be.Compra}.
 * </p>
 *
 * @author Sebastian
 *
 */
public class CompraDTO implements DTO<Long>, TrackingableDTO, VersionableDTO {

	private static final long serialVersionUID = -1187901882499252259L;

	private Long id;

	private Date fecha;
	private String condicionVenta;
	private String descripcionCondicionVenta;
	private Long idProveedor;
	private String razonSocialProveedor;
	private String estadoPago;
	private String descripcionEstadoPago;
	private BigDecimal importeTotal;
	private BigDecimal saldo;

	private List<DetalleCompraDTO> coleccionDetalleCompra;

	private PagoDTO pago;

	private TrackInfoDTO trackInfo;
	private int version;

	/**
	 * Constructor Default.
	 */
	public CompraDTO() {
		this.coleccionDetalleCompra = new ArrayList<DetalleCompraDTO>();
		this.fecha = new Date();
		this.estadoPago = EstadoPagoFacturaValues.PENDIENTE.getValor();
		this.importeTotal = BigDecimal.ZERO;
		this.importeTotal = BigDecimal.ZERO;
		this.saldo = BigDecimal.ZERO;
	}

	/* (non-JSDoc)
	 * @see org.ambar.core.dto.DTO#getId()
	 */
	@Override
	public Long getId() {
		return this.id;
	}

	/* (non-JSDoc)
	 * @see org.ambar.core.dto.DTO#setId(java.lang.Object)
	 */
	@Override
	public void setId(Long pId) {
		this.id = pId;
	}

	/**
	 * @return Retorna el valor del atributo fecha.
	 */
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
	 * @return Retorna el valor del atributo condicionVenta.
	 */
	public String getCondicionVenta() {
		return condicionVenta;
	}

	/**
	 * @param pCondicionVenta Establece el valor del atributo condicionVenta.
	 */
	public void setCondicionVenta(String pCondicionVenta) {
		condicionVenta = pCondicionVenta;
	}

	/**
	 * @return Retorna el valor del atributo descripcionCondicionVenta.
	 */
	public String getDescripcionCondicionVenta() {
		return descripcionCondicionVenta;
	}

	/**
	 * @param pDescripcionCondicionVenta Establece el valor del atributo descripcionCondicionVenta.
	 */
	public void setDescripcionCondicionVenta(String pDescripcionCondicionVenta) {
		descripcionCondicionVenta = pDescripcionCondicionVenta;
	}

	/**
	 * @return Retorna el valor del atributo idProveedor.
	 */
	public Long getIdProveedor() {
		return idProveedor;
	}

	/**
	 * @param pIdProveedor Establece el valor del atributo idProveedor.
	 */
	public void setIdProveedor(Long pIdProveedor) {
		idProveedor = pIdProveedor;
	}

	/**
	 * @return Retorna el valor del atributo razonSocialProveedor.
	 */
	public String getRazonSocialProveedor() {
		return razonSocialProveedor;
	}

	/**
	 * @param pRazonSocialProveedor Establece el valor del atributo razonSocialProveedor.
	 */
	public void setRazonSocialProveedor(String pRazonSocialProveedor) {
		razonSocialProveedor = pRazonSocialProveedor;
	}

	/**
	 * @return Retorna el valor del atributo estadoPago.
	 */
	public String getEstadoPago() {
		return estadoPago;
	}

	/**
	 * @param pEstadoPago Establece el valor del atributo estadoPago.
	 */
	public void setEstadoPago(String pEstadoPago) {
		estadoPago = pEstadoPago;
	}

	/**
	 * @return Retorna el valor del atributo descripcionEstadoPago.
	 */
	public String getDescripcionEstadoPago() {
		return descripcionEstadoPago;
	}

	/**
	 * @param pDescripcionEstadoPago Establece el valor del atributo descripcionEstadoPago.
	 */
	public void setDescripcionEstadoPago(String pDescripcionEstadoPago) {
		descripcionEstadoPago = pDescripcionEstadoPago;
	}

	/**
	 * @return Retorna el valor del atributo importeTotal.
	 */
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
	 * @return Retorna el valor del atributo coleccionDetalleCompra.
	 */
	public List<DetalleCompraDTO> getColeccionDetalleCompra() {
		return coleccionDetalleCompra;
	}

	/**
	 * @param pColeccionDetalleCompra Establece el valor del atributo coleccionDetalleCompra.
	 */
	public void setColeccionDetalleCompra(List<DetalleCompraDTO> pColeccionDetalleCompra) {
		coleccionDetalleCompra = pColeccionDetalleCompra;
	}

	/**
	 * Agrega una DetalleCompraDTO.
	 * @param pElement DetalleCompraDTO a agregar
	 */
	public void agregarDetalleCompra(final DetalleCompraDTO pElement) {
		pElement.setIdCompra(this.id);
		this.coleccionDetalleCompra.add(pElement);
	}

	/**
	 * Remueve una DetalleCompraDTO.
	 * @param pElement DetalleCompraDTO a remover
	 */
	public void removerDetalleCompra(final DetalleCompraDTO pElement) {
		this.coleccionDetalleCompra.remove(pElement);
		pElement.setIdCompra(null);
	}

	/**
	 * @return Retorna el valor del atributo pago.
	 */
	public PagoDTO getPago() {
		return pago;
	}

	/**
	 * @param pPago Establece el valor del atributo pago.
	 */
	public void setPago(PagoDTO pPago) {
		pago = pPago;
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
		if (!(pObj instanceof CompraDTO)) {
			return false;
		}
		CompraDTO other = (CompraDTO) pObj;
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
		builder.append("CompraDTO [id=");
		builder.append(this.id);

		builder.append(", trackInfo=");
		builder.append(this.trackInfo);
		builder.append(", version=");
		builder.append(this.version);
		builder.append("]");
		return builder.toString();
	}
}
