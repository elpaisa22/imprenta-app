/**
 * application-domain [23/05/2015 13:53:41]
 */
package org.ambar.appl.be;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

/**
 * <p>
 * Entidad que representa un ID de Provincia.
 * </p>
 *
 * @author Sebastian
 */
@Embeddable
public class ProvinciaID implements Serializable {

	private static final long serialVersionUID = -4787736404865175382L;

	private String idProvincia;
	private Pais pais;

	/**
	 * Constructor por default.
	 */
	public ProvinciaID() {
		super();
	}

	/**
	 * Constructor con parámetros.
	 * @param pIDProvincia ID Provincia
	 * @param pPais ID Pais
	 * */
    public ProvinciaID(final String pIDProvincia, final Pais pPais) {
        this();
        this.idProvincia = pIDProvincia;
        this.pais = pPais;
    }

	/**
	 * @return Retorna el valor del atributo idProvincia.
	 */
    @Basic(optional = false)
    @Column(name = "IDPROVINCIA")
	public String getIdProvincia() {
		return this.idProvincia;
	}

	/**
	 * @param pIdProvincia Establece el valor del atributo idProvincia.
	 */
	public void setIdProvincia(String pIdProvincia) {
		this.idProvincia = pIdProvincia;
	}

	/**
	 * @return Retorna el valor del atributo pais.
	 */
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "IDPAIS", referencedColumnName = "IDPAIS", nullable = false)
	@NotNull(message = "{org.ambar.appl.be.Pais.id.NotNull}")
	public Pais getPais() {
		return this.pais;
	}

	/**
	 * @param pPais Establece el valor del atributo pais.
	 */
	public void setPais(Pais pPais) {
		this.pais = pPais;
	}

	/* (non-JSDoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.idProvincia == null) ? 0 : this.idProvincia.hashCode());
		result = prime * result + ((this.pais == null) ? 0 : this.pais.hashCode());
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
		if (!(pObj instanceof ProvinciaID)) {
			return false;
		}
		ProvinciaID other = (ProvinciaID) pObj;
		if (this.idProvincia == null) {
			if (other.idProvincia != null) {
				return false;
			}
		} else if (!this.idProvincia.equals(other.idProvincia)) {
			return false;
		}
		if (this.pais == null) {
			if (other.pais != null) {
				return false;
			}
		} else if (!this.pais.equals(other.pais)) {
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
		builder.append("ProvinciaID [idProvincia=");
		builder.append(this.idProvincia);
		builder.append(", pais=");
		builder.append(this.pais);
		builder.append("]");
		return builder.toString();
	}
}
