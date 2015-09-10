/**
 * application-dto [07/01/2014 18:04:25]
 */
package org.ambar.appl.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.ambar.core.dto.DTO;
import org.ambar.core.dto.TrackInfoDTO;
import org.ambar.core.dto.TrackingableDTO;
import org.ambar.core.dto.VersionableDTO;

/**
 * <p>DTO a ser usado en las transacciones CRUD correspondiente a la
 * entidad {@link org.ambar.appl.be.CuentaCorriente}.</p>
 *
 * @author Sebastian
 *
 */
public class CuentaCorrienteDTO implements DTO<Long>, TrackingableDTO, VersionableDTO {

	private static final long serialVersionUID = 5564418263619739287L;

	private Long id;
	private Long idCliente;
	private String razonSocialCliente;
	private String nombreFantasiaCliente;
	private String tipoDocumentoCliente;
	private String numeroDocumentoCliente;
	private String descripcionCondicionIVACliente;

	private BigDecimal saldo;

	private List<MovimientoCuentaCorrienteDTO> coleccionMovimientos;

	private TrackInfoDTO trackInfo;
	private int version;

	/**
	 * Constructor default.
	 * */
	public CuentaCorrienteDTO() {
		this.coleccionMovimientos = new ArrayList<MovimientoCuentaCorrienteDTO>();
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
	 * @return Retorna el valor del atributo nombreFantasiaCliente.
	 */
	public String getNombreFantasiaCliente() {
		return nombreFantasiaCliente;
	}

	/**
	 * @param pNombreFantasiaCliente Establece el valor del atributo nombreFantasiaCliente.
	 */
	public void setNombreFantasiaCliente(String pNombreFantasiaCliente) {
		nombreFantasiaCliente = pNombreFantasiaCliente;
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
	 * @return Retorna el valor del atributo descripcionCondicionIVACliente.
	 */
	public String getDescripcionCondicionIVACliente() {
		return descripcionCondicionIVACliente;
	}

	/**
	 * @param pDescripcionCondicionIVACliente Establece el valor del atributo descripcionCondicionIVACliente.
	 */
	public void setDescripcionCondicionIVACliente(String pDescripcionCondicionIVACliente) {
		descripcionCondicionIVACliente = pDescripcionCondicionIVACliente;
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
	 * @return Retorna el valor del atributo coleccionMovimientos.
	 */
	public List<MovimientoCuentaCorrienteDTO> getColeccionMovimientos() {
		return coleccionMovimientos;
	}

	/**
	 * @param pColeccionMovimientos Establece el valor del atributo coleccionMovimientos.
	 */
	public void setColeccionMovimientos(List<MovimientoCuentaCorrienteDTO> pColeccionMovimientos) {
		coleccionMovimientos = pColeccionMovimientos;
	}

	/**
	 * Agrega una Movimiento.
	 * @param pElement Movimiento a agregar
	 */
	public void agregarMovimiento(final MovimientoCuentaCorrienteDTO pElement) {
		this.coleccionMovimientos.add(pElement);
		pElement.setIdCuentaCorriente(this.getId());
	}

	/**
	 * Remueve una Movimiento.
	 * @param pElement Movimiento a remover
	 */
	public void removerMovimiento(final MovimientoCuentaCorrienteDTO pElement) {
		this.coleccionMovimientos.remove(pElement);
		pElement.setIdCuentaCorriente(null);
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
		result = prime * result + ((this.idCliente == null) ? 0 : this.idCliente.hashCode());
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
		if (!(pObj instanceof CuentaCorrienteDTO)) {
			return false;
		}
		CuentaCorrienteDTO other = (CuentaCorrienteDTO) pObj;
		if (this.idCliente == null) {
			if (other.idCliente != null) {
				return false;
			}
		} else if (!this.idCliente.equals(other.idCliente)) {
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
		builder.append("CuentaCorrienteDTO [id=");
		builder.append(this.id);
		builder.append(", idCliente=");
		builder.append(this.idCliente);
		builder.append(", razonSocialCliente=");
		builder.append(this.razonSocialCliente);

		builder.append(", saldo=");
		builder.append(this.saldo);
		builder.append(", trackInfo=");
		builder.append(this.trackInfo);
		builder.append(", version=");
		builder.append(this.version);
		builder.append("]");
		return builder.toString();
	}
}
