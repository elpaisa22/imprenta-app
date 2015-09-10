/**
 * application-dto [02/06/2015 18:44:42]
 */
package org.ambar.appl.dto;

import java.math.BigDecimal;

import org.ambar.core.dto.DTO;

/**
 * <p>
 * DTO a ser usado en las transacciones CRUD correspondiente a la
 * entidad {@link org.ambar.appl.be.DetalleCompra}.
 * </p>
 *
 * @author Sebastian
 *
 */
public class DetalleCompraDTO implements DTO<Long> {

	private static final long serialVersionUID = 2115734954371387884L;

	private Long id;

	private Long idCompra;
	private String idArticulo;
	private String descripcionArticulo;
	private String descripcion;
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
	 * @return Retorna el valor del atributo descripcion.
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param pDescripcion Establece el valor del atributo descripcion.
	 */
	public void setDescripcion(String pDescripcion) {
		descripcion = pDescripcion;
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
		if (!(pObj instanceof DetalleCompraDTO)) {
			return false;
		}
		DetalleCompraDTO other = (DetalleCompraDTO) pObj;
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
		builder.append("DetalleCompraDTO [id=");
		builder.append(this.id);

		builder.append(", idCompra=");
		builder.append(this.idCompra);
		builder.append(", idArticulo=");
		builder.append(this.idArticulo);
		builder.append(", descripcion=");
		builder.append(this.descripcion);
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
