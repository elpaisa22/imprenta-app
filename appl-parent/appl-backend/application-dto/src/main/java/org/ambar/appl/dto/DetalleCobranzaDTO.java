/**
 * application-dto [27/01/2015 18:44:47]
 */
package org.ambar.appl.dto;

import java.math.BigDecimal;
import java.util.Date;

import org.ambar.core.dto.DTO;

/**
 * <p>
 * DTO a ser usado en las transacciones CRUD correspondiente a la
 * entidad {@link org.ambar.appl.be.DetalleCobranza}.
 * </p>
 *
 * @author Sebastian
 */
public class DetalleCobranzaDTO implements DTO<Long> {

	private static final long serialVersionUID = -1934343486220923345L;

	private Long id;

	private Long idCobranza;
	private Long idFactura;
	private BigDecimal montoPagado;
	private BigDecimal saldo;

	private Date fechaEmisionFactura;
	private String descripcionEstadoPagoFactura;
	private BigDecimal importeFactura;
	private BigDecimal saldoFactura;

	/**
	 * Constructor default.
	 */
	public DetalleCobranzaDTO() {
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
	 * @return Retorna el valor del atributo idCobranza.
	 */
	public Long getIdCobranza() {
		return idCobranza;
	}
	/**
	 * @param pIdCobranza Establece el valor del atributo idCobranza.
	 */
	public void setIdCobranza(Long pIdCobranza) {
		idCobranza = pIdCobranza;
	}
	/**
	 * @return Retorna el valor del atributo idFactura.
	 */
	public Long getIdFactura() {
		return idFactura;
	}
	/**
	 * @param pIdFactura Establece el valor del atributo idFactura.
	 */
	public void setIdFactura(Long pIdFactura) {
		idFactura = pIdFactura;
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
	 * @return Retorna el valor del atributo fechaEmisionFactura.
	 */
	public Date getFechaEmisionFactura() {
		return fechaEmisionFactura;
	}

	/**
	 * @param pFechaEmisionFactura Establece el valor del atributo fechaEmisionFactura.
	 */
	public void setFechaEmisionFactura(Date pFechaEmisionFactura) {
		fechaEmisionFactura = pFechaEmisionFactura;
	}

	/**
	 * @return Retorna el valor del atributo descripcionEstadoPagoFactura.
	 */
	public String getDescripcionEstadoPagoFactura() {
		return descripcionEstadoPagoFactura;
	}

	/**
	 * @param pDescripcionEstadoPagoFactura Establece el valor del atributo descripcionEstadoPagoFactura.
	 */
	public void setDescripcionEstadoPagoFactura(String pDescripcionEstadoPagoFactura) {
		descripcionEstadoPagoFactura = pDescripcionEstadoPagoFactura;
	}

	/**
	 * @return Retorna el valor del atributo importeFactura.
	 */
	public BigDecimal getImporteFactura() {
		return importeFactura;
	}

	/**
	 * @param pImporteFactura Establece el valor del atributo importeFactura.
	 */
	public void setImporteFactura(BigDecimal pImporteFactura) {
		importeFactura = pImporteFactura;
	}

	/**
	 * @return Retorna el valor del atributo saldoFactura.
	 */
	public BigDecimal getSaldoFactura() {
		return saldoFactura;
	}

	/**
	 * @param pSaldoFactura Establece el valor del atributo saldoFactura.
	 */
	public void setSaldoFactura(BigDecimal pSaldoFactura) {
		saldoFactura = pSaldoFactura;
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
		if (!(pObj instanceof DetalleCobranzaDTO)) {
			return false;
		}
		DetalleCobranzaDTO other = (DetalleCobranzaDTO) pObj;
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
		builder.append("DetalleCobranzaDTO [id=");
		builder.append(this.id);

		builder.append(", idFactura=");
		builder.append(this.idFactura);
		builder.append(", idCobranza=");
		builder.append(this.idCobranza);
		builder.append(", montoPagado=");
		builder.append(this.montoPagado);
		builder.append(", saldo=");
		builder.append(this.saldo);

		builder.append("]");
		return builder.toString();
	}
}
