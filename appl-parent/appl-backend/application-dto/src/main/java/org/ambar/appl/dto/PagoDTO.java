/**
 * application-dto [8/6/2015 18:15:30]
 */
package org.ambar.appl.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.ambar.core.dto.DTO;
import org.ambar.core.dto.TrackInfoDTO;
import org.ambar.core.dto.TrackingableDTO;
import org.ambar.core.dto.VersionableDTO;

/**
 * <p>
 * DTO a ser usado en las transacciones CRUD correspondiente a la
 * entidad {@link org.ambar.appl.be.Pago}.
 * </p>
 *
 * @author Sebastian
 *
 */
public class PagoDTO implements DTO<Long>, TrackingableDTO, VersionableDTO {

	private static final long serialVersionUID = -1872196822324005897L;

	private Long id;

	private Long idProveedor;
	private String razonSocialProveedor;

	private BigDecimal montoEfectivo;

	private BigDecimal montoTarjetaCredito;
	private String numeroTarjetaCredito;
	private String marcaTarjetaCredito;
	private String idBancoTarjetaCredito;
	private String descripcionBancoTarjetaCredito;

	private BigDecimal montoTarjetaDebito;
	private String numeroTarjetaDebito;
	private String marcaTarjetaDebito;
	private String idBancoTarjetaDebito;
	private String descripcionBancoTarjetaDebito;

	private BigDecimal importeTotal;

	private Date fecha;

	private List<ChequeDTO> coleccionCheques;
	private List<DetallePagoDTO> coleccionDetallePago;

	private TrackInfoDTO trackInfo;
	private int version;

	/**
	 * Constructor default.
	 */
	public PagoDTO() {
		this.fecha = new Date();

		this.montoEfectivo = BigDecimal.ZERO;
		this.montoTarjetaCredito = BigDecimal.ZERO;
		this.montoTarjetaDebito = BigDecimal.ZERO;
		this.importeTotal = BigDecimal.ZERO;

		this.coleccionCheques = new ArrayList<ChequeDTO>();
		this.coleccionDetallePago = new ArrayList<DetallePagoDTO>();
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
	 * @return Retorna el valor del atributo montoEfectivo.
	 */
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
	 * @return Retorna el valor del atributo idBancoTarjetaCredito.
	 */
	public String getIdBancoTarjetaCredito() {
		return idBancoTarjetaCredito;
	}

	/**
	 * @param pIdBancoTarjetaCredito Establece el valor del atributo idBancoTarjetaCredito.
	 */
	public void setIdBancoTarjetaCredito(String pIdBancoTarjetaCredito) {
		idBancoTarjetaCredito = pIdBancoTarjetaCredito;
	}

	/**
	 * @return Retorna el valor del atributo descripcionBancoTarjetaCredito.
	 */
	public String getDescripcionBancoTarjetaCredito() {
		return descripcionBancoTarjetaCredito;
	}

	/**
	 * @param pDescripcionBancoTarjetaCredito Establece el valor del atributo descripcionBancoTarjetaCredito.
	 */
	public void setDescripcionBancoTarjetaCredito(String pDescripcionBancoTarjetaCredito) {
		descripcionBancoTarjetaCredito = pDescripcionBancoTarjetaCredito;
	}

	/**
	 * @return Retorna el valor del atributo montoTarjetaDebito.
	 */
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
	 * @return Retorna el valor del atributo idBancoTarjetaDebito.
	 */
	public String getIdBancoTarjetaDebito() {
		return idBancoTarjetaDebito;
	}

	/**
	 * @param pIdBancoTarjetaDebito Establece el valor del atributo idBancoTarjetaDebito.
	 */
	public void setIdBancoTarjetaDebito(String pIdBancoTarjetaDebito) {
		idBancoTarjetaDebito = pIdBancoTarjetaDebito;
	}

	/**
	 * @return Retorna el valor del atributo descripcionBancoTarjetaDebito.
	 */
	public String getDescripcionBancoTarjetaDebito() {
		return descripcionBancoTarjetaDebito;
	}

	/**
	 * @param pDescripcionBancoTarjetaDebito Establece el valor del atributo descripcionBancoTarjetaDebito.
	 */
	public void setDescripcionBancoTarjetaDebito(String pDescripcionBancoTarjetaDebito) {
		descripcionBancoTarjetaDebito = pDescripcionBancoTarjetaDebito;
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
	 * @return Retorna el valor del atributo coleccionCheques.
	 */
	public List<ChequeDTO> getColeccionCheques() {
		return coleccionCheques;
	}

	/**
	 * @param pColeccionCheques Establece el valor del atributo coleccionCheques.
	 */
	public void setColeccionCheques(List<ChequeDTO> pColeccionCheques) {
		coleccionCheques = pColeccionCheques;
	}

	/**
	 * Agrega una Cheque.
	 * @param pElement Cheque a agregar
	 */
	public void agregarCheque(final ChequeDTO pElement) {
		if (this.coleccionCheques.contains(pElement)) {
			this.coleccionCheques.remove(pElement);
		}
		this.coleccionCheques.add(pElement);
		pElement.setIdPago(this.id);
		pElement.setTrackInfo(trackInfo);
	}

	/**
	 * Remueve una Cheque.
	 * @param pElement Cheque a remover
	 */
	public void removerCheque(final ChequeDTO pElement) {
		this.coleccionCheques.remove(pElement);
		pElement.setIdPago(null);
	}

	/**
	 * @return Retorna el valor del atributo coleccionDetallePago.
	 */
	public List<DetallePagoDTO> getColeccionDetallePago() {
		return coleccionDetallePago;
	}

	/**
	 * @param pColeccionDetallePago Establece el valor del atributo coleccionDetallePago.
	 */
	public void setColeccionDetallePago(List<DetallePagoDTO> pColeccionDetallePago) {
		coleccionDetallePago = pColeccionDetallePago;
	}


	/**
	 * Agrega una DetallePagoDTO.
	 * @param pElement DetallePagoDTO a agregar
	 */
	public void agregarDetallePago(final DetallePagoDTO pElement) {
		pElement.setIdPago(this.id);
		this.coleccionDetallePago.add(pElement);
	}

	/**
	 * Remueve una DetallePagoDTO.
	 * @param pElement DetallePagoDTO a remover
	 */
	public void removerDetallePago(final DetallePagoDTO pElement) {
		this.coleccionDetallePago.remove(pElement);
		pElement.setIdPago(null);
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
		if (!(pObj instanceof PagoDTO)) {
			return false;
		}
		PagoDTO other = (PagoDTO) pObj;
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
		builder.append("PagoDTO [id=");
		builder.append(this.id);

		builder.append(", montoEfectivo=");
		builder.append(this.montoEfectivo);
		builder.append(", idProveedor=");
		builder.append(this.idProveedor);
		builder.append(", razonSocialProveedor=");
		builder.append(this.razonSocialProveedor);
		builder.append(", fecha=");
		builder.append(this.fecha);


		builder.append(", trackInfo=");
		builder.append(this.trackInfo);
		builder.append(", version=");
		builder.append(this.version);
		builder.append("]");
		return builder.toString();
	}
}
