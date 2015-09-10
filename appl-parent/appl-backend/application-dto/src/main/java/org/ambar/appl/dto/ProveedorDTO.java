/**
 * application-dto [23/05/2015 11:36:46]
 */
package org.ambar.appl.dto;

import java.math.BigDecimal;

import org.ambar.appl.commons.enums.TipoCondicionIVAValues;
import org.ambar.core.dto.DTO;
import org.ambar.core.dto.TrackInfoDTO;
import org.ambar.core.dto.TrackingableDTO;
import org.ambar.core.dto.VersionableDTO;

/**
 * <p>
 * DTO a ser usado en las transacciones CRUD correspondiente a la
 * entidad {@link org.ambar.appl.be.Proveedor}.
 * </p>
 *
 * @author Sebastian
 *
 */
public class ProveedorDTO implements DTO<Long>, TrackingableDTO, VersionableDTO {

	private static final long serialVersionUID = -1315604307312733979L;

	private Long id;

	private String razonSocial;
	private String contacto;
	private String cuit;
	private String telefono;
	private String celular;
	private String email;
	private String direccion;
	private String ciudad;
	private String idProvincia;
	private String idPais;
	private String descripcionProvincia;
	private String descripcionPais;
	private String condicionIVA;
	private String descripcionCondicionIVA;
	private String codigoPostal;

	private Long idCuentaCorriente;
	private BigDecimal saldoCuentaCorriente;

	private TrackInfoDTO trackInfo;
	private int version;

	/**
	 *
	 */
	public ProveedorDTO() {
		this.condicionIVA = TipoCondicionIVAValues.RESPONSABLE_INSCRIPTO.getValor();
		this.descripcionCondicionIVA = TipoCondicionIVAValues.RESPONSABLE_INSCRIPTO.getDescripcion();
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
	 * @return Retorna el valor del atributo contacto.
	 */
	public String getContacto() {
		return contacto;
	}

	/**
	 * @param pContacto Establece el valor del atributo contacto.
	 */
	public void setContacto(String pContacto) {
		contacto = pContacto;
	}

	/**
	 * @return Retorna el valor del atributo cuit.
	 */
	public String getCuit() {
		return cuit;
	}

	/**
	 * @param pCuit Establece el valor del atributo cuit.
	 */
	public void setCuit(String pCuit) {
		cuit = pCuit;
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
	 * @return Retorna el valor del atributo celular.
	 */
	public String getCelular() {
		return celular;
	}

	/**
	 * @param pCelular Establece el valor del atributo celular.
	 */
	public void setCelular(String pCelular) {
		celular = pCelular;
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
	 * @return Retorna el valor del atributo codigoPostal.
	 */
	public String getCodigoPostal() {
		return codigoPostal;
	}

	/**
	 * @param pCodigoPostal Establece el valor del atributo codigoPostal.
	 */
	public void setCodigoPostal(String pCodigoPostal) {
		codigoPostal = pCodigoPostal;
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
		if (!(pObj instanceof ProveedorDTO)) {
			return false;
		}
		ProveedorDTO other = (ProveedorDTO) pObj;
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
		builder.append("ProveedorDTO [id=");
		builder.append(this.id);
		builder.append(", razonSocial=");
		builder.append(this.razonSocial);
		builder.append(", contacto=");
		builder.append(this.contacto);
		builder.append(", cuit=");
		builder.append(this.cuit);
		builder.append(", telefono=");
		builder.append(this.telefono);
		builder.append(", celular=");
		builder.append(this.celular);
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
		builder.append(", codigoPostal=");
		builder.append(this.codigoPostal);
		builder.append(", trackInfo=");
		builder.append(this.trackInfo);
		builder.append(", version=");
		builder.append(this.version);
		builder.append("]");
		return builder.toString();
	}
}
