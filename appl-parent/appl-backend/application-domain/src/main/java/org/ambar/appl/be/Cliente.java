/**
 * appl-cliente-domain [22/08/2011 17:55:59]
 */
package org.ambar.appl.be;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.ambar.appl.commons.constraint.Constraints;
import org.ambar.appl.commons.enums.TipoCondicionIVAValues;
import org.ambar.appl.commons.enums.TipoDocumentoValues;
import org.ambar.core.be.Persistible;
import org.ambar.core.be.TrackInfo;
import org.ambar.core.be.Trackingable;
import org.ambar.core.be.Versionable;
import org.ambar.core.enums.converters.dozer.EnumConverter;

/**
 * <p>
 * Entidad Cliente.
 * </p>
 *
 * @author Sebastian
 *
 *
 */
@Entity
@Table(name = "AP_CLIENTE")
public class Cliente implements Persistible<Long>, Trackingable, Versionable {

	private Long id;
	private String razonSocial;
	private String nombreFantasia;
	private TipoDocumentoValues tipoDocumento;
	private String numeroDocumento;
	private TipoCondicionIVAValues condicionIVA;
	private String telefono;
	private String email;
	private String direccion;
	private String ciudad;
	private Provincia provincia;
	private Pais pais;
	private String idProvincia;

	private CuentaCorriente cuentaCorriente;

	private TrackInfo trackInfo;
	private int version;

	/**
	 * Constructor por default.
	 */
	public Cliente() {
	}


	/* (non-JSDoc)
	 * @see org.ambar.core.be.Persistible#getId()
	 */
	@Override
	@Id
    @Column(name = "IDCLIENTE")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	 * @return Retorna el valor del atributo cuentaCorriente.
	 */
	@OneToOne(cascade = CascadeType.ALL, optional = false, orphanRemoval = true, mappedBy = "cliente")
	@Basic(optional = false)
	public CuentaCorriente getCuentaCorriente() {
		return cuentaCorriente;
	}

	/**
	 * @param pCuentaCorriente Establece el valor del atributo cuentaCorriente.
	 */
	public void setCuentaCorriente(CuentaCorriente pCuentaCorriente) {
		cuentaCorriente = pCuentaCorriente;

		if (cuentaCorriente != null) {
			cuentaCorriente.setCliente(this);
		}
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
	 * @return Retorna el valor del atributo descripcion.
	 */
    @Basic(optional = false)
    @Column(name = "RAZONSOCIAL")
    @NotNull(message = "{org.ambar.appl.be.Cliente.razonSocial.NotNull}")
    @Size(max = Constraints.STRING40_SIZE_MAX, message = "{org.ambar.appl.be.Cliente.razonSocial.Size}")
	public String getRazonSocial() {
		return this.razonSocial;
	}

	/**
	 * @param pRazonSocial Establece el valor del atributo descripcion.
	 */
	public void setRazonSocial(String pRazonSocial) {
		this.razonSocial = pRazonSocial;
	}


	/**
	 * @return Retorna el valor del atributo nombreFantasia.
	 */
	@Basic(optional = true)
    @Column(name = "NOMBREFANTASIA")
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
	@Transient
	public TipoDocumentoValues getTipoDocumento() {
		return tipoDocumento;
	}


	/**
	 * @param pTipoDocumento Establece el valor del atributo tipoDocumento.
	 */
	public void setTipoDocumento(TipoDocumentoValues pTipoDocumento) {
		tipoDocumento = pTipoDocumento;
	}

	/**
	 * @param pTipoDocumentoDB Establece el valor del atributo tipoDocumento a partir
	 * de un {@link String}.
	 */
	@SuppressWarnings("unused")
	private void setTipoDocumentoPersistent(String pTipoDocumentoDB) {
		this.tipoDocumento = EnumConverter.getEnumFromString(TipoDocumentoValues.class, pTipoDocumentoDB);
	}

	/**
	 * @return Devuelve un {@link String} con el valor del atributo
	 * tipoDocumento convertido.
	 */
	@Basic(optional = false)
	@Column(name = "TIPODOCUMENTO")
	@NotNull(message = "{org.ambar.appl.be.Cliente.tipoDocumento.NotNull}")
	private String getTipoDocumentoPersistent() {
		if (this.tipoDocumento == null) {
			return null;
		} else {
			return this.tipoDocumento.getValor();
		}
	}


	/**
	 * @return Retorna el valor del atributo numeroDocumento.
	 */
	@Basic(optional = false)
    @Column(name = "NUMERODOCUMENTO")
    @NotNull(message = "{org.ambar.appl.be.Cliente.numeroDocumento.NotNull}")
    @Size(max = Constraints.STRING20_SIZE_MAX, message = "{org.ambar.appl.be.Cliente.numeroDocumento.Size}")
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
	 * @return Retorna el valor del atributo condicionIVA.
	 */
	@Transient
	public TipoCondicionIVAValues getCondicionIVA() {
		return condicionIVA;
	}


	/**
	 * @param pCondicionIVA Establece el valor del atributo condicionIVA.
	 */
	public void setCondicionIVA(TipoCondicionIVAValues pCondicionIVA) {
		condicionIVA = pCondicionIVA;
	}


	/**
	 * @param pCondicionIVADB Establece el valor del atributo condicionIVA a partir
	 * de un {@link String}.
	 */
	@SuppressWarnings("unused")
	private void setCondicionIVAPersistent(String pCondicionIVADB) {
		this.condicionIVA = EnumConverter.getEnumFromString(TipoCondicionIVAValues.class, pCondicionIVADB);
	}

	/**
	 * @return Devuelve un {@link String} con el valor del atributo
	 * condicionIVA convertido.
	 */
	@Basic(optional = true)
    @Column(name = "CONDICIONIVA")
	private String getCondicionIVAPersistent() {
		if (this.condicionIVA == null) {
			return null;
		} else {
			return this.condicionIVA.getValor();
		}
	}


	/**
	 * @return Retorna el valor del atributo telefono.
	 */
	@Basic(optional = true)
    @Column(name = "NROTELEFONO")
    @Size(max = Constraints.STRING20_SIZE_MAX, message = "{org.ambar.appl.be.Cliente.telefono.Size}")
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
	@Basic(optional = true)
    @Column(name = "EMAIL")
    @Size(max = Constraints.STRING40_SIZE_MAX, message = "{org.ambar.appl.be.Cliente.email.Size}")
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
	@Basic(optional = true)
    @Column(name = "DIRECCION")
    @Size(max = Constraints.STRING40_SIZE_MAX, message = "{org.ambar.appl.be.Cliente.direccion.Size}")
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
	@Basic(optional = true)
    @Column(name = "CIUDAD")
    @Size(max = Constraints.STRING40_SIZE_MAX, message = "{org.ambar.appl.be.Cliente.ciudad.Size}")
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
	 * @return Retorna el valor del atributo provincia.
	 */
	@ManyToOne
	@Basic(optional = true)
	@JoinColumns({
	      @JoinColumn(name = "IDPROVINCIA", insertable = false, updatable = false),
	      @JoinColumn(name = "IDPAIS", insertable = false, updatable = false)
	    })
	public Provincia getProvincia() {
		return provincia;
	}


	/**
	 * @param pProvincia Establece el valor del atributo provincia.
	 */
	public void setProvincia(final Provincia pProvincia) {
		provincia = pProvincia;
		if (pProvincia != null) {
			this.idProvincia = pProvincia.getId().getIdProvincia();
		}
	}

	/**
	 * @return Retorna el valor del atributo pais.
	 */
	@ManyToOne
	@Basic(optional = true)
	@JoinColumn(name = "IDPAIS")
	public Pais getPais() {
		return pais;
	}


	/**
	 * @param pPais Establece el valor del atributo pais.
	 */
	public void setPais(final Pais pPais) {
		pais = pPais;
	}

	/**
	 * @return Retorna el valor del atributo idProvincia.
	 */
	@Column(name = "IDPROVINCIA")
	private String getIdProvincia() {
		return idProvincia;
	}


	/**
	 * @param pIdProvincia Establece el valor del atributo idProvincia.
	 */
	@SuppressWarnings("unused")
	private void setIdProvincia(String pIdProvincia) {
		idProvincia = pIdProvincia;
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
		if (!(pObj instanceof Cliente)) {
			return false;
		}
		Cliente other = (Cliente) pObj;
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
		builder.append("Cliente [id=");
		builder.append(this.id);
		builder.append(", razonSocial=");
		builder.append(this.razonSocial);
		builder.append(", nombreFantasia=");
		builder.append(this.nombreFantasia);
		builder.append(", tipoDocumento=");
		builder.append(this.tipoDocumento);
		builder.append(", numeroDocumento=");
		builder.append(this.numeroDocumento);
		builder.append(", telefono=");
		builder.append(this.telefono);
		builder.append(", email=");
		builder.append(this.email);
		builder.append(", direccion=");
		builder.append(this.direccion);
		if (this.provincia != null) {
			builder.append(", provincia(id)=");
			builder.append(this.provincia.getId().getIdProvincia());
		}
		if (this.pais != null) {
			builder.append(", pais(id)=");
			builder.append(this.pais.getId());
		}
		builder.append(", condicionIVA=");
		builder.append(this.condicionIVA);
		builder.append(", trackInfo=");
		builder.append(this.trackInfo);
		builder.append(", version=");
		builder.append(this.version);
		builder.append("]");
		return builder.toString();
	}
}
