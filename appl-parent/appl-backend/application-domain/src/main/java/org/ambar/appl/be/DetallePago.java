/**
 * application-domain [8/6/2015 17:51:25]
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
 * Entidad de Detalle de un Pago.
 * </p>
 *
 * @author Sebastian
 *
 */
@Entity
@Table(name = "AP_DETALLEPAGO")
public class DetallePago implements Persistible<Long> {

	private Long id;

	private Pago pago;
	private Compra compra;
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
	 * @return Retorna el valor del atributo pago.
	 */
	@ManyToOne
	@JoinColumn(name = "IDCOBRANZA")
	@NotNull
	public Pago getPago() {
		return pago;
	}

	/**
	 * @param pPago Establece el valor del atributo pago.
	 */
	public void setPago(Pago pPago) {
		pago = pPago;
	}

	/**
	 * @return Retorna el valor del atributo compra.
	 */
	@ManyToOne
	@JoinColumn(name = "IDFACTURA")
	@NotNull
	public Compra getCompra() {
		return compra;
	}

	/**
	 * @param pCompra Establece el valor del atributo compra.
	 */
	public void setCompra(Compra pCompra) {
		compra = pCompra;
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
		if (!(pObj instanceof DetallePago)) {
			return false;
		}
		DetallePago other = (DetallePago) pObj;
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
		builder.append("DetallePago [id=");
		builder.append(this.id);

		builder.append(", montoPagado=");
		builder.append(this.montoPagado);
		builder.append(", saldo=");
		builder.append(this.saldo);

		builder.append("]");
		return builder.toString();
	}
}
