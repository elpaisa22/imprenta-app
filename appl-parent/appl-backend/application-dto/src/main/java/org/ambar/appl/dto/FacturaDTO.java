/**
 * application-dto [25/08/2012 12:45:07]
 */
package org.ambar.appl.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.ambar.appl.commons.enums.EstadoPagoFacturaValues;
import org.ambar.appl.commons.enums.TipoFacturaValues;
import org.ambar.core.dto.DTO;
import org.ambar.core.dto.TrackInfoDTO;
import org.ambar.core.dto.TrackingableDTO;
import org.ambar.core.dto.VersionableDTO;

/**
 * <p>DTO a ser usado en las transacciones CRUD correspondiente a la
 * entidad {@link org.ambar.appl.be.Factura}.</p>
 *
 * @author Sebastian
 *
 */
public class FacturaDTO implements DTO<Long>, TrackingableDTO, VersionableDTO {

	private static final long serialVersionUID = 911578514206067924L;

	private Long id;
	private Date fechaEmision;

	private String tipoFactura;
	private String descripcionTipoFactura;

	private String condicionVenta;
	private String descripcionCondicionVenta;

	private Long idCliente;
	private String razonSocialCliente;
	private String tipoDocumentoCliente;
	private String numeroDocumentoCliente;
	private String direccionCliente;

	private Long idRemito;
	private String estadoPago;
	private String descripcionEstadoPago;

	private BigDecimal importeSubTotal;
	private BigDecimal importeIVA;

	private BigDecimal importeTotal;
	private BigDecimal saldo;

	private CobranzaDTO cobranza;

	private List<DetalleFacturaDTO> coleccionDetalleFacturas;

	private TrackInfoDTO trackInfo;
	private int version;

	/**
	 * Constructor Default.
	 */
	public FacturaDTO() {
		this.coleccionDetalleFacturas = new ArrayList<DetalleFacturaDTO>();
		this.fechaEmision = new Date();
		this.estadoPago = EstadoPagoFacturaValues.PENDIENTE.getValor();
		this.importeTotal = BigDecimal.ZERO;
		this.importeSubTotal = BigDecimal.ZERO;
		this.importeIVA = BigDecimal.ZERO;
		this.tipoFactura = TipoFacturaValues.A.getValor();
		this.descripcionTipoFactura = TipoFacturaValues.A.getDescripcion();
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
	 * @return Retorna el valor del atributo tipoFactura.
	 */
	public String getTipoFactura() {
		return tipoFactura;
	}

	/**
	 * @param pTipoFactura Establece el valor del atributo tipoFactura.
	 */
	public void setTipoFactura(String pTipoFactura) {
		tipoFactura = pTipoFactura;
	}

	/**
	 * @return Retorna el valor del atributo descripcionTipoFactura.
	 */
	public String getDescripcionTipoFactura() {
		return descripcionTipoFactura;
	}

	/**
	 * @param pDescripcionTipoFactura Establece el valor del atributo descripcionTipoFactura.
	 */
	public void setDescripcionTipoFactura(String pDescripcionTipoFactura) {
		descripcionTipoFactura = pDescripcionTipoFactura;
	}

	/**
	 * @return Retorna el valor del atributo fechaEmision.
	 */
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
	 * @return Retorna el valor del atributo idRemito.
	 */
	public Long getIdRemito() {
		return idRemito;
	}

	/**
	 * @param pIdRemito Establece el valor del atributo idRemito.
	 */
	public void setIdRemito(Long pIdRemito) {
		idRemito = pIdRemito;
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
	 * @return Retorna el valor del atributo idCliente.
	 */
	public Long getIdCliente() {
		return idCliente;
	}

	/**
	 * @param pIdCliente Establece el valor del atributo idCliente.
	 */
	public void setIdCliente(Long pIdCliente) {
		idCliente = pIdCliente;
	}

	/**
	 * @return Retorna el valor del atributo razonSocialCliente.
	 */
	public String getRazonSocialCliente() {
		return razonSocialCliente;
	}

	/**
	 * @param pRazonSocialCliente Establece el valor del atributo razonSocialCliente.
	 */
	public void setRazonSocialCliente(String pRazonSocialCliente) {
		razonSocialCliente = pRazonSocialCliente;
	}

	/**
	 * @return Retorna el valor del atributo tipoDocumentoCliente.
	 */
	public String getTipoDocumentoCliente() {
		return tipoDocumentoCliente;
	}

	/**
	 * @param pTipoDocumentoCliente Establece el valor del atributo tipoDocumentoCliente.
	 */
	public void setTipoDocumentoCliente(String pTipoDocumentoCliente) {
		tipoDocumentoCliente = pTipoDocumentoCliente;
	}

	/**
	 * @return Retorna el valor del atributo numeroDocumentoCliente.
	 */
	public String getNumeroDocumentoCliente() {
		return numeroDocumentoCliente;
	}

	/**
	 * @param pNumeroDocumentoCliente Establece el valor del atributo numeroDocumentoCliente.
	 */
	public void setNumeroDocumentoCliente(String pNumeroDocumentoCliente) {
		numeroDocumentoCliente = pNumeroDocumentoCliente;
	}

	/**
	 * @return Retorna el valor del atributo direccionCliente.
	 */
	public String getDireccionCliente() {
		return direccionCliente;
	}

	/**
	 * @param pDireccionCliente Establece el valor del atributo direccionCliente.
	 */
	public void setDireccionCliente(String pDireccionCliente) {
		direccionCliente = pDireccionCliente;
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
	 * @return Retorna el valor del atributo importeSubTotal.
	 */
	public BigDecimal getImporteSubTotal() {
		return importeSubTotal;
	}

	/**
	 * @param pImporteSubTotal Establece el valor del atributo importeSubTotal.
	 */
	public void setImporteSubTotal(BigDecimal pImporteSubTotal) {
		importeSubTotal = pImporteSubTotal;
	}

	/**
	 * @return Retorna el valor del atributo importeIVA.
	 */
	public BigDecimal getImporteIVA() {
		return importeIVA;
	}

	/**
	 * @param pImporteIVA Establece el valor del atributo importeIVA.
	 */
	public void setImporteIVA(BigDecimal pImporteIVA) {
		importeIVA = pImporteIVA;
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
	 * @return Retorna el valor del atributo cobranza.
	 */
	public CobranzaDTO getCobranza() {
		return cobranza;
	}

	/**
	 * @param pCobranza Establece el valor del atributo cobranza.
	 */
	public void setCobranza(CobranzaDTO pCobranza) {
		cobranza = pCobranza;
	}

	/**
	 * @return Retorna el valor del atributo coleccionDetalleFacturas.
	 */
	public List<DetalleFacturaDTO> getColeccionDetalleFacturas() {
		return coleccionDetalleFacturas;
	}

	/**
	 * @param pColeccionDetalleFacturas Establece el valor del atributo coleccionDetalleFacturas.
	 */
	public void setColeccionDetalleFacturas(List<DetalleFacturaDTO> pColeccionDetalleFacturas) {
		coleccionDetalleFacturas = pColeccionDetalleFacturas;
	}


	/**
	 * Agrega una DetalleFacturaDTO.
	 * @param pElement DetalleFacturaDTO a agregar
	 */
	public void agregarDetalleFactura(final DetalleFacturaDTO pElement) {
		pElement.setIdFactura(this.id);
		this.coleccionDetalleFacturas.add(pElement);
	}

	/**
	 * Remueve una DetalleFacturaDTO.
	 * @param pElement DetalleFacturaDTO a remover
	 */
	public void removerDetalleFactura(final DetalleFacturaDTO pElement) {
		this.coleccionDetalleFacturas.remove(pElement);
		pElement.setIdFactura(null);
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
		if (!(pObj instanceof FacturaDTO)) {
			return false;
		}
		FacturaDTO other = (FacturaDTO) pObj;
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
		builder.append("FacturaDTO [id=");
		builder.append(this.id);

		builder.append(", fechaEmision=");
		builder.append(this.fechaEmision);
		builder.append(", condicionVenta=");
		builder.append(this.condicionVenta);
		builder.append(", descripcionCondicionVenta=");
		builder.append(this.descripcionCondicionVenta);
		builder.append(", idCliente=");
		builder.append(this.idCliente);
		builder.append(", razonSocialCliente=");
		builder.append(this.razonSocialCliente);
		builder.append(", idRemito=");
		builder.append(this.idRemito);
		builder.append(", estadoPago=");
		builder.append(this.estadoPago);
		builder.append(", descripcionEstadoPago=");
		builder.append(this.descripcionEstadoPago);

		builder.append(", trackInfo=");
		builder.append(this.trackInfo);
		builder.append(", version=");
		builder.append(this.version);
		builder.append("]");
		return builder.toString();
	}
}
