/**
 * application-dto [18/03/2014 00:21:32]
 */
package org.ambar.appl.dto;

import java.math.BigDecimal;

import org.ambar.core.dto.DTO;

/**
 * <p>DTO a ser usado en las transacciones CRUD correspondiente a la
 * entidad {@link org.ambar.appl.be.DetalleFactura}.</p>
 *
 * @author Sebastian
 *
 */
public class DetalleFacturaDTO implements DTO<Long> {

	private static final long serialVersionUID = 77891546858571741L;

	private Long id;

	private Long idFactura;

	private String idArticulo;
	private String descripcionArticulo;
	private String descripcionServicio;
	private BigDecimal precioUnitario;

	private Integer cantidad;
	private BigDecimal montoTotal;
	private BigDecimal descuento;

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
	 * @return Retorna el valor del atributo idArticulo.
	 */
	public String getIdArticulo() {
		return idArticulo;
	}

	/**
	 * @param pIdArticulo Establece el valor del atributo idArticulo.
	 */
	public void setIdArticulo(String pIdArticulo) {
		idArticulo = pIdArticulo;
	}

	/**
	 * @return Retorna el valor del atributo descripcionArticulo.
	 */
	public String getDescripcionArticulo() {
		return descripcionArticulo;
	}

	/**
	 * @param pDescripcionArticulo Establece el valor del atributo descripcionArticulo.
	 */
	public void setDescripcionArticulo(String pDescripcionArticulo) {
		descripcionArticulo = pDescripcionArticulo;
	}

	/**
	 * @return Retorna el valor del atributo descripcionServicio.
	 */
	public String getDescripcionServicio() {
		return descripcionServicio;
	}

	/**
	 * @param pDescripcionServicio Establece el valor del atributo descripcionServicio.
	 */
	public void setDescripcionServicio(String pDescripcionServicio) {
		descripcionServicio = pDescripcionServicio;
	}

	/**
	 * @return Retorna el valor del atributo precioUnitario.
	 */
	public BigDecimal getPrecioUnitario() {
		return precioUnitario;
	}

	/**
	 * @param pPrecioUnitario Establece el valor del atributo precioUnitario.
	 */
	public void setPrecioUnitario(BigDecimal pPrecioUnitario) {
		precioUnitario = pPrecioUnitario;
	}

	/**
	 * @return Retorna el valor del atributo cantidad.
	 */
	public Integer getCantidad() {
		return cantidad;
	}

	/**
	 * @param pCantidad Establece el valor del atributo cantidad.
	 */
	public void setCantidad(Integer pCantidad) {
		cantidad = pCantidad;
	}

	/**
	 * @return Retorna el valor del atributo montoTotal.
	 */
	public BigDecimal getMontoTotal() {
		return montoTotal;
	}

	/**
	 * @param pMontoTotal Establece el valor del atributo montoTotal.
	 */
	public void setMontoTotal(BigDecimal pMontoTotal) {
		montoTotal = pMontoTotal;
	}

	/**
	 * @return Retorna el valor del atributo descuento.
	 */
	public BigDecimal getDescuento() {
		return descuento;
	}

	/**
	 * @param pDescuento Establece el valor del atributo descuento.
	 */
	public void setDescuento(BigDecimal pDescuento) {
		descuento = pDescuento;
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
		if (!(pObj instanceof DetalleFacturaDTO)) {
			return false;
		}
		DetalleFacturaDTO other = (DetalleFacturaDTO) pObj;
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
		builder.append("DetalleFacturaDTO [id=");
		builder.append(this.id);

		builder.append(", idFactura=");
		builder.append(this.idFactura);
		builder.append(", idArticulo=");
		builder.append(this.idArticulo);
		builder.append(", descripcionArticulo=");
		builder.append(this.descripcionArticulo);
		builder.append(", precioUnitario=");
		builder.append(this.precioUnitario);
		builder.append(", cantidad=");
		builder.append(this.cantidad);
		builder.append(", montoTotal=");
		builder.append(this.montoTotal);
		builder.append(", descuento=");
		builder.append(this.descuento);

		builder.append("]");
		return builder.toString();
	}
}
