/**
 * appl-cliente-dto [22/08/2011 18:17:06]
 */
package org.ambar.appl.dto;

import java.math.BigDecimal;

import org.ambar.appl.commons.enums.TipoCondicionIVAValues;
import org.ambar.core.dto.DTO;
import org.ambar.core.dto.TrackInfoDTO;
import org.ambar.core.dto.TrackingableDTO;
import org.ambar.core.dto.VersionableDTO;

/**
 * <p>DTO a ser usado en las transacciones CRUD correspondiente a la
 * entidad {@link org.ambar.appl.be.Cliente}.</p>
 *
 * @author Sebastian
 *
 */
public class ClienteDTO implements DTO<Long>, TrackingableDTO, VersionableDTO {

	private static final long serialVersionUID = 765414393030865280L;

	private Long id;

	private String razonSocial;
	private String nombreFantasia;
	private String tipoDocumento;
	private String descripcionTipoDocumento;
	private String numeroDocumento;
	private String telefono;
	private String email;
	private String direccion;
	private String ciudad;
	private String idProvincia;
	private String descripcionProvincia;
	private String idPais;
	private String descripcionPais;
	private String condicionIVA;
	private String descripcionCondicionIVA;

	private Long idCuentaCorriente;
	private BigDecimal saldoCuentaCorriente;

	private TrackInfoDTO trackInfo;
	private int version;

	/**
	 * Constructor.
	 */
	public ClienteDTO() {
		this.condicionIVA = TipoCondicionIVAValues.CONSUMIDOR_FINAL.getValor();
		this.descripcionCondicionIVA = TipoCondicionIVAValues.CONSUMIDOR_FINAL.getDescripcion();
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
	 * @return Retorna el valor del atributo razonSocial.
	 */
	public String getRazonSocial() {
		return this.razonSocial;
	}

	/**
	 * @param pRazonSocial Establece el valor del atributo razonSocial.
	 */
	public void setRazonSocial(String pRazonSocial) {
		this.razonSocial = pRazonSocial;
	}

	/**
	 * @return Retorna el valor del atributo nombreFantasia.
	 */
	public String getNombreFantasia() {
		return nombreFantasia;
	}

	/**
	 * @param pNombreFantasia Establece el valor del atributo nombreFantasia.
	 */
	public void setNombreFantasia(String pNombreFantasia) {
		nombreFantasia = pNombreFantasia;
	}

	/**
	 * @return Retorna el valor del atributo tipoDocumento.
	 */
	public String getTipoDocumento() {
		return tipoDocumento;
	}

	/**
	 * @param pTipoDocumento Establece el valor del atributo tipoDocumento.
	 */
	public void setTipoDocumento(String pTipoDocumento) {
		tipoDocumento = pTipoDocumento;
	}

	/**
	 * @return Retorna el valor del atributo descripcionTipoDocumento.
	 */
	public String getDescripcionTipoDocumento() {
		return descripcionTipoDocumento;
	}

	/**
	 * @param pDescripcionTipoDocumento Establece el valor del atributo descripcionTipoDocumento.
	 */
	public void setDescripcionTipoDocumento(String pDescripcionTipoDocumento) {
		descripcionTipoDocumento = pDescripcionTipoDocumento;
	}

	/**
	 * @return Retorna el valor del atributo numeroDocumento.
	 */
	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	/**
	 * @param pNumeroDocumento Establece el valor del atributo numeroDocumento.
	 */
	public void setNumeroDocumento(String pNumeroDocumento) {
		numeroDocumento = pNumeroDocumento;
	}

	/**
	 * @return Retorna el valor del atributo telefono.
	 */
	public String getTelefono() {
		return telefono;
	}

	/**
	 * @param pTelefono Establece el valor del atributo telefono.
	 */
	public void setTelefono(String pTelefono) {
		telefono = pTelefono;
	}

	/**
	 * @return Retorna el valor del atributo email.
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param pEmail Establece el valor del atributo email.
	 */
	public void setEmail(String pEmail) {
		email = pEmail;
	}

	/**
	 * @return Retorna el valor del atributo direccion.
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * @param pDireccion Establece el valor del atributo direccion.
	 */
	public void setDireccion(String pDireccion) {
		direccion = pDireccion;
	}

	/**
	 * @return Retorna el valor del atributo ciudad.
	 */
	public String getCiudad() {
		return ciudad;
	}

	/**
	 * @param pCiudad Establece el valor del atributo ciudad.
	 */
	public void setCiudad(String pCiudad) {
		ciudad = pCiudad;
	}

	/**
	 * @return Retorna el valor del atributo idProvincia.
	 */
	public String getIdProvincia() {
		return idProvincia;
	}

	/**
	 * @param pIdProvincia Establece el valor del atributo idProvincia.
	 */
	public void setIdProvincia(String pIdProvincia) {
		idProvincia = pIdProvincia;
	}

	/**
	 * @return Retorna el valor del atributo descripcionProvincia.
	 */
	public String getDescripcionProvincia() {
		return descripcionProvincia;
	}

	/**
	 * @param pDescripcionProvincia Establece el valor del atributo descripcionProvincia.
	 */
	public void setDescripcionProvincia(String pDescripcionProvincia) {
		descripcionProvincia = pDescripcionProvincia;
	}

	/**
	 * @return Retorna el valor del atributo idPais.
	 */
	public String getIdPais() {
		return idPais;
	}

	/**
	 * @param pIdPais Establece el valor del atributo idPais.
	 */
	public void setIdPais(String pIdPais) {
		idPais = pIdPais;
	}

	/**
	 * @return Retorna el valor del atributo descripcionPais.
	 */
	public String getDescripcionPais() {
		return descripcionPais;
	}

	/**
	 * @param pDescripcionPais Establece el valor del atributo descripcionPais.
	 */
	public void setDescripcionPais(String pDescripcionPais) {
		descripcionPais = pDescripcionPais;
	}

	/**
	 * @return Retorna el valor del atributo condicionIVA.
	 */
	public String getCondicionIVA() {
		return condicionIVA;
	}

	/**
	 * @param pCondicionIVA Establece el valor del atributo condicionIVA.
	 */
	public void setCondicionIVA(String pCondicionIVA) {
		condicionIVA = pCondicionIVA;
	}

	/**
	 * @return Retorna el valor del atributo descripcionCondicionIVA.
	 */
	public String getDescripcionCondicionIVA() {
		return descripcionCondicionIVA;
	}

	/**
	 * @param pDescripcionCondicionIVA Establece el valor del atributo descripcionCondicionIVA.
	 */
	public void setDescripcionCondicionIVA(String pDescripcionCondicionIVA) {
		descripcionCondicionIVA = pDescripcionCondicionIVA;
	}

	/**
	 * @return Retorna el valor del atributo idCuentaCorriente.
	 */
	public Long getIdCuentaCorriente() {
		return idCuentaCorriente;
	}

	/**
	 * @param pIdCuentaCorriente Establece el valor del atributo idCuentaCorriente.
	 */
	public void setIdCuentaCorriente(Long pIdCuentaCorriente) {
		idCuentaCorriente = pIdCuentaCorriente;
	}

	/**
	 * @return Retorna el valor del atributo saldoCuentaCorriente.
	 */
	public BigDecimal getSaldoCuentaCorriente() {
		return saldoCuentaCorriente;
	}

	/**
	 * @param pSaldoCuentaCorriente Establece el valor del atributo saldoCuentaCorriente.
	 */
	public void setSaldoCuentaCorriente(BigDecimal pSaldoCuentaCorriente) {
		saldoCuentaCorriente = pSaldoCuentaCorriente;
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
		if (!(pObj instanceof ClienteDTO)) {
			return false;
		}
		ClienteDTO other = (ClienteDTO) pObj;
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
		builder.append("ClienteDTO [id=");
		builder.append(this.id);
		builder.append(", razonSocial=");
		builder.append(this.razonSocial);
		builder.append(", nombreFantasia=");
		builder.append(this.nombreFantasia);
		builder.append(", tipoDocumento=");
		builder.append(this.tipoDocumento);
		builder.append(", descripcionTipoDocumento=");
		builder.append(this.descripcionTipoDocumento);
		builder.append(", numeroDocumento=");
		builder.append(this.numeroDocumento);
		builder.append(", telefono=");
		builder.append(this.telefono);
		builder.append(", email=");
		builder.append(this.email);
		builder.append(", direccion=");
		builder.append(this.direccion);
		builder.append(", idProvincia=");
		builder.append(this.idProvincia);
		builder.append(", idPais=");
		builder.append(this.idPais);
		builder.append(", condicionIVA=");
		builder.append(this.condicionIVA);
		builder.append(", descripcionCondicionIVA=");
		builder.append(this.descripcionCondicionIVA);
		builder.append(", idCuentaCorriente=");
		builder.append(this.idCuentaCorriente);
		builder.append(", saldoCuentaCorriente=");
		builder.append(this.saldoCuentaCorriente);
		builder.append(", trackInfo=");
		builder.append(this.trackInfo);
		builder.append(", version=");
		builder.append(this.version);
		builder.append("]");
		return builder.toString();
	}
}
