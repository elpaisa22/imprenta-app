/**
 * application-domain [02/06/2015 17:41:37]
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
 * Entidad Detalle Compra.
 * </p>
 *
 * @author Sebastian
 *
 */
@Entity
@Table(name = "AP_DETALLECOMPRA")
public class DetalleCompra implements Persistible<Long> {

	private Long id;

	private Compra compra;
	private Articulo articulo;
	private String descripcion;
	private BigDecimal precioUnitario;
	private Integer cantidad;
	private BigDecimal montoTotal;
	private BigDecimal descuento;

	/* (non-JSDoc)
	 * @see org.ambar.core.be.Persistible#getId()
	 */
	@Override
	@Id
    @Column(name = "IDDETALLECOMPRA")
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
	 * @return Retorna el valor del atributo compra.
	 */
	@ManyToOne
	@Basic(optional = false)
	@JoinColumn(name = "IDCOMPRA")
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
	 * @return Retorna el valor del atributo articulo.
	 */
	@ManyToOne
	@Basic(optional = true)
	@JoinColumn(name = "IDARTICULO")
	public Articulo getArticulo() {
		return articulo;
	}

	/**
	 * @param pArticulo Establece el valor del atributo articulo.
	 */
	public void setArticulo(Articulo pArticulo) {
		articulo = pArticulo;
	}

	/**
	 * @return Retorna el valor del atributo descripcion.
	 */
	@Column(name = "DESCRIPCION")
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
	@Column(name = "PRECIOUNITARIO")
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
	@Column(name = "CANTIDAD")
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
	@Column(name = "MONTO")
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
	@Column(name = "DESCUENTO")
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
		if (!(pObj instanceof DetalleCompra)) {
			return false;
		}
		DetalleCompra other = (DetalleCompra) pObj;
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
		builder.append("DetalleCompra [id=");
		builder.append(this.id);

		if (this.articulo != null) {
			builder.append(", articulo(id)=");
			builder.append(this.articulo.getId());
		}

		builder.append(", montoTotal=");
		builder.append(this.montoTotal);
		builder.append(", cantidad=");
		builder.append(this.cantidad);
		builder.append(", descuento=");
		builder.append(this.descuento);

		builder.append("]");
		return builder.toString();
	}
}
