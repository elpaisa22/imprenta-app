/**
 * application-dto [8/6/2015 18:15:40]
 */
package org.ambar.appl.dto;

import java.math.BigDecimal;
import java.util.Date;

import org.ambar.core.dto.DTO;

/**
 * <p>
 * DTO a ser usado en las transacciones CRUD correspondiente a la
 * entidad {@link org.ambar.appl.be.DetallePago}.
 * </p>
 *
 * @author Sebastian
 *
 */
public class DetallePagoDTO implements DTO<Long> {

	private static final long serialVersionUID = -5974187318344596368L;

	private Long id;

	private Long idPago;
	private Long idCompra;
	private BigDecimal montoPagado;
	private BigDecimal saldo;

	private Date fechaCompra;
	private String descripcionEstadoPagoCompra;
	private BigDecimal importeCompra;
	private BigDecimal saldoCompra;

	/**
	 * Constructor default.
	 */
	public DetallePagoDTO() {
		this.montoPagado = BigDecimal.ZERO;
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
	 * @return Retorna el valor del atributo idPago.
	 */
	public Long getIdPago() {
		return idPago;
	}
	/**
	 * @param pIdPago Establece el valor del atributo idPago.
	 */
	public void setIdPago(Long pIdPago) {
		idPago = pIdPago;
	}
	/**
	 * @return Retorna el valor del atributo idCompra.
	 */
	public Long getIdCompra() {
		return idCompra;
	}
	/**
	 * @param pIdCompra Establece el valor del atributo idCompra.
	 */
	public void setIdCompra(Long pIdCompra) {
		idCompra = pIdCompra;
	}
	/**
	 * @return Retorna el valor del atributo montoPagado.
	 */
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
	 * @return Retorna el valor del atributo fechaCompra.
	 */
	public Date getFechaCompra() {
		return fechaCompra;
	}

	/**
	 * @param pFechaCompra Establece el valor del atributo fechaCompra.
	 */
	public void setFechaCompra(Date pFechaCompra) {
		fechaCompra = pFechaCompra;
	}

	/**
	 * @return Retorna el valor del atributo descripcionEstadoPagoCompra.
	 */
	public String getDescripcionEstadoPagoCompra() {
		return descripcionEstadoPagoCompra;
	}

	/**
	 * @param pDescripcionEstadoPagoCompra Establece el valor del atributo descripcionEstadoPagoCompra.
	 */
	public void setDescripcionEstadoPagoCompra(String pDescripcionEstadoPagoCompra) {
		descripcionEstadoPagoCompra = pDescripcionEstadoPagoCompra;
	}

	/**
	 * @return Retorna el valor del atributo importeCompra.
	 */
	public BigDecimal getImporteCompra() {
		return importeCompra;
	}

	/**
	 * @param pImporteCompra Establece el valor del atributo importeCompra.
	 */
	public void setImporteCompra(BigDecimal pImporteCompra) {
		importeCompra = pImporteCompra;
	}

	/**
	 * @return Retorna el valor del atributo saldoCompra.
	 */
	public BigDecimal getSaldoCompra() {
		return saldoCompra;
	}

	/**
	 * @param pSaldoCompra Establece el valor del atributo saldoCompra.
	 */
	public void setSaldoCompra(BigDecimal pSaldoCompra) {
		saldoCompra = pSaldoCompra;
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
		if (!(pObj instanceof DetallePagoDTO)) {
			return false;
		}
		DetallePagoDTO other = (DetallePagoDTO) pObj;
		if (this.id == null) {
			if (other.id != null) {
				return false;
			}
		} else {
			return this.id.equals(other.id);
		}

		return false;
	}

	/* (non-JSDoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DetallePagoDTO [id=");
		builder.append(this.id);

		builder.append(", idCompra=");
		builder.append(this.idCompra);
		builder.append(", idPago=");
		builder.append(this.idPago);
		builder.append(", montoPagado=");
		builder.append(this.montoPagado);
		builder.append(", saldo=");
		builder.append(this.saldo);

		builder.append("]");
		return builder.toString();
	}
}
