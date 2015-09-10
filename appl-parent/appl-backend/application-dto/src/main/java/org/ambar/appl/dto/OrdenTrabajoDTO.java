/**
 * application-dto [22/05/2012 17:24:48]
 */
package org.ambar.appl.dto;

import java.math.BigDecimal;
import java.util.Date;

import org.ambar.core.dto.DTO;
import org.ambar.core.dto.TrackInfoDTO;
import org.ambar.core.dto.TrackingableDTO;
import org.ambar.core.dto.VersionableDTO;


/**
 * <p>DTO a ser usado en las transacciones CRUD correspondiente a la
 * entidad {@link org.ambar.appl.be.OrdenTrabajo}.</p>
 *
 * @author Sebastian
 *
 */
public class OrdenTrabajoDTO implements DTO<Long>, TrackingableDTO, VersionableDTO {

	private static final long serialVersionUID = 4904949852877012318L;

	private Long id;

	private Date fechaInicio;
	private Date fechaEntrega;
	private Date fechaPautada;
	private Long idCliente;
	private String razonSocialCliente;
	private Long idFactura;
	private Long idRemito;
	private String descripcion;
	private Integer cantidad;
	private String estadoOrden;
	private String descripcionEstadoOrden;
	private BigDecimal importeTotal;
	private Long ancho;
	private Long alto;
	private String tipoMaterial;
	private Integer coloresFrontales;
	private Integer coloresTraseros;

	private TrackInfoDTO trackInfo;
	private int version;

	/**
	 * COnstructor default.
	 * */
	public OrdenTrabajoDTO() {
		this.fechaInicio = new Date();
		this.estadoOrden = "EMITIDA";
		this.importeTotal = BigDecimal.ZERO;
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
	 * @return Retorna el valor del atributo fechaInicio.
	 */
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
	 * @return Retorna el valor del atributo idFactura.
	 */
	public Long getIdFactura() {
		return idFactura;
	}


	/**
	 * @param pIdFactura Establece el valor del atributo idFactura.
	 */
	public void setIdFactura(Long pIdFactura) {
		idFactura = pIdFactura;
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
	 * @return Retorna el valor del atributo cantidad.
	 */
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
	public String getEstadoOrden() {
		return estadoOrden;
	}

	/**
	 * @param pEstadoOrden Establece el valor del atributo estadoOrden.
	 */
	public void setEstadoOrden(String pEstadoOrden) {
		estadoOrden = pEstadoOrden;
	}

	/**
	 * @return Retorna el valor del atributo descripcionEstadoOrden.
	 */
	public String getDescripcionEstadoOrden() {
		return descripcionEstadoOrden;
	}

	/**
	 * @param pDescripcionEstadoOrden Establece el valor del atributo descripcionEstadoOrden.
	 */
	public void setDescripcionEstadoOrden(String pDescripcionEstadoOrden) {
		descripcionEstadoOrden = pDescripcionEstadoOrden;
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
	 * @return Retorna el valor del atributo ancho.
	 */
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
	public Integer getColoresTraseros() {
		return coloresTraseros;
	}


	/**
	 * @param pColoresTraseros Establece el valor del atributo coloresTraseros.
	 */
	public void setColoresTraseros(Integer pColoresTraseros) {
		coloresTraseros = pColoresTraseros;
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
		if (!(pObj instanceof OrdenTrabajoDTO)) {
			return false;
		}
		OrdenTrabajoDTO other = (OrdenTrabajoDTO) pObj;
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
		builder.append("OrdenTrabajoDTO [id=");
		builder.append(this.id);
		builder.append(", fechaInicio=");
		builder.append(this.fechaInicio);
		builder.append(", fechaEntrega=");
		builder.append(this.fechaEntrega);
		builder.append(", fechaPautada=");
		builder.append(this.fechaPautada);
		builder.append(", idCliente=");
		builder.append(this.idCliente);
		builder.append(", descripcion=");
		builder.append(this.descripcion);
		builder.append(", idFactura=");
		builder.append(this.idFactura);
		builder.append(", idRemito=");
		builder.append(this.idRemito);
		builder.append(", cantidad=");
		builder.append(this.cantidad);
		builder.append(", estadoOrden=");
		builder.append(this.estadoOrden);
		builder.append(", descripcionEstadoOrden=");
		builder.append(this.descripcionEstadoOrden);
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
		builder.append(", trackInfo=");
		builder.append(this.trackInfo);
		builder.append(", version=");
		builder.append(this.version);
		builder.append("]");
		return builder.toString();
	}
}
