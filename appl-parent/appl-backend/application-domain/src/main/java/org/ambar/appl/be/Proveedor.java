/**
 * application-domain [23/05/2015 11:01:16]
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
import org.ambar.core.be.Persistible;
import org.ambar.core.be.TrackInfo;
import org.ambar.core.be.Trackingable;
import org.ambar.core.be.Versionable;
import org.ambar.core.enums.converters.dozer.EnumConverter;

/**
 * <p>
 * Entidad Proveedor.
 * </p>
 *
 * @author Sebastian
 *
 *
 */
@Entity
@Table(name = "AP_PROVEEDOR")
public class Proveedor implements Persistible<Long>, Trackingable, Versionable {

	private Long id;

	private String razonSocial;
	private String contacto;
	private TipoCondicionIVAValues condicionIVA;
	private String cuit;
	private String telefono;
	private String celular;
	private String email;
	private String direccion;
	private String ciudad;
	private String codigoPostal;
	private Provincia provincia;
	private Pais pais;
	private String idProvincia;

	private CuentaCorrienteProveedor cuentaCorriente;

	private TrackInfo trackInfo;
	private int version;

	/* (non-JSDoc)
	 * @see org.ambar.core.be.Persistible#getId()
	 */
	@Override
	@Id
    @Column(name = "IDPROVEEDOR")
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

	/* (non-JSDoc)
	 * @see org.ambar.core.be.Versionable#getVersion()
	 */
	@Override
	@Version
	@Column(name = "VERSION", nullable = false)
	public int getVersion() {
		return this.version;
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
	 * @return Retorna el valor del atributo contacto.
	 */
	@Basic(optional = true)
    @Column(name = "CONTACTO")
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

	/**
	 * @return Retorna el valor del atributo cuit.
	 */
	@Basic(optional = true)
    @Column(name = "CUIT")
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
	 * @return Retorna el valor del atributo celular.
	 */
	@Basic(optional = true)
    @Column(name = "CELULAR")
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
	 * @return Retorna el valor del atributo codigoPostal.
	 */
	@Basic(optional = true)
    @Column(name = "CODIGOPOSTAL")
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
	 * @return Retorna el valor del atributo cuentaCorriente.
	 */
	@OneToOne(cascade = CascadeType.ALL, optional = false, orphanRemoval = true, mappedBy = "proveedor")
	@Basic(optional = false)
	public CuentaCorrienteProveedor getCuentaCorriente() {
		return cuentaCorriente;
	}

	/**
	 * @param pCuentaCorriente Establece el valor del atributo cuentaCorriente.
	 */
	public void setCuentaCorriente(CuentaCorrienteProveedor pCuentaCorriente) {
		cuentaCorriente = pCuentaCorriente;
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
		if (!(pObj instanceof Proveedor)) {
			return false;
		}
		Proveedor other = (Proveedor) pObj;
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
		builder.append("Proveedor [id=");
		builder.append(this.id);

		builder.append(", razonSocial=");
		builder.append(this.razonSocial);
		builder.append(", contacto=");
		builder.append(this.contacto);
		builder.append(", telefono=");
		builder.append(this.telefono);
		builder.append(", email=");
		builder.append(this.email);
		builder.append(", direccion=");
		builder.append(this.direccion);
		builder.append(", provincia=");
		builder.append(this.provincia);
		builder.append(", pais=");
		builder.append(this.pais);
		builder.append(", condicionIVA=");
		builder.append(this.condicionIVA);
		builder.append(", cuit=");
		builder.append(this.cuit);
		builder.append(", celular=");
		builder.append(this.celular);
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
