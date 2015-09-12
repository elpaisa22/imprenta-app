/**
 * application-domain [27/01/2015 18:33:50]
 */
package org.ambar.appl.be;

import java.math.BigDecimal;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.ambar.core.be.Persistible;

/**
 * <p>
 * Entidad Detalle Cobranza.
 * </p>
 *
 * @author Sebastian
 */
@Entity
@Table(name = "AP_DETALLECOBRANZA")
public class DetalleCobranza implements Persistible<Long> {

	private Long id;

	private Cobranza cobranza;
	private Factura factura;
	private BigDecimal montoPagado;
	private BigDecimal saldo;

	/* (non-JSDoc)
	 * @see org.ambar.core.be.Persistible#getId()
	 */
	@Override
	@Id
    @Column(name = "IDDETALLECOBRANZA")
	@GeneratedValue(strategy = GenerationType.AUTO)
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
	 * @return Retorna el valor del atributo cobranza.
	 */
	@ManyToOne
	@JoinColumn(name = "IDCOBRANZA")
	@NotNull
	public Cobranza getCobranza() {
		return cobranza;
	}

	/**
	 * @param pCobranza Establece el valor del atributo cobranza.
	 */
	public void setCobranza(Cobranza pCobranza) {
		cobranza = pCobranza;
	}

	/**
	 * @return Retorna el valor del atributo factura.
	 */
	@ManyToOne
	@Basic(optional = false)
	@JoinColumn(name = "IDFACTURA")
	@NotNull
	public Factura getFactura() {
		return factura;
	}

	/**
	 * @param pFactura Establece el valor del atributo factura.
	 */
	public void setFactura(Factura pFactura) {
		factura = pFactura;
	}

	/**
	 * @return Retorna el valor del atributo montoPagado.
	 */
	@Column(name = "MONTOPAGADO")
	public BigDecimal getMontoPagado() {
		return montoPagado;
	}

	/**
	 * @param pMontoPagado Establece el valor del atributo montoPagado.
	 */
	public void setMontoPagado(BigDecimal pMontoPagado) {
		montoPagado = pMontoPagado;
	}

	/**
	 * @return Retorna el valor del atributo saldo.
	 */
	@Column(name = "SALDO")
	public BigDecimal getSaldo() {
		return saldo;
	}

	/**
	 * @param pSaldo Establece el valor del atributo saldo.
	 */
	public void setSaldo(BigDecimal pSaldo) {
		saldo = pSaldo;
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
		if (!(pObj instanceof DetalleCobranza)) {
			return false;
		}
		DetalleCobranza other = (DetalleCobranza) pObj;
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
		builder.append("DetalleCobranza [id=");
		builder.append(this.id);

		builder.append(", montoPagado=");
		builder.append(this.montoPagado);
		builder.append(", saldo=");
		builder.append(this.saldo);

		builder.append("]");
		return builder.toString();
	}
}
