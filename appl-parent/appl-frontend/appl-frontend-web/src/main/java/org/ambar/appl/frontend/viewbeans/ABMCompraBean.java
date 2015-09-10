/**
 * appl-frontend-web [2/6/2015 20:28:59]
 */
package org.ambar.appl.frontend.viewbeans;

import java.io.Serializable;
import java.math.BigDecimal;

import org.ambar.appl.dto.ArticuloDTO;
import org.ambar.appl.dto.CompraDTO;
import org.ambar.appl.dto.DetalleCompraDTO;

/**
 * <p>
 * Bean utilizado en el ABM de Compra.
 * </p>
 *
 * @author Sebastian
 *
 */
public class ABMCompraBean implements Serializable {

	private static final long serialVersionUID = -116992657508064516L;

	private String descripcionServicio;

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
	 * Inicializa el Bean.
	 * */
	public void inicializar() {
		this.descripcionServicio = "";
	}

	/**
	 * Agrega un detalle al DTO de la factura.
	 * @param pCompraDTO Compra
	 * @param pArticulo Articulo
	 * */
	public void agregarDetalle(CompraDTO pCompraDTO, ArticuloDTO pArticulo) {


		if (pArticulo != null) {
			DetalleCompraDTO detalleCompraDTO = new DetalleCompraDTO();
			detalleCompraDTO.setIdArticulo(pArticulo.getId());
			detalleCompraDTO.setCantidad(1);
			detalleCompraDTO.setPrecioUnitario(pArticulo.getPrecioBruto());
			detalleCompraDTO.setMontoTotal(pArticulo.getPrecioBruto());
			detalleCompraDTO.setDescripcionArticulo(pArticulo.getDescripcion());

			pCompraDTO.agregarDetalleCompra(detalleCompraDTO);

			this.actualizarImportes(pCompraDTO);
		}
	}

	/**
	 * Agrega un detalle al DTO de la factura.
	 * @param pCompraDTO Compra
	 * @param pDescripcion Descripcion
	 * */
	public void agregarDetalle(CompraDTO pCompraDTO, String pDescripcion) {
		if (pDescripcion != null) {
			DetalleCompraDTO detalleCompraDTO = new DetalleCompraDTO();
			detalleCompraDTO.setDescripcion(pDescripcion);
			detalleCompraDTO.setCantidad(1);
			detalleCompraDTO.setPrecioUnitario(BigDecimal.ZERO);
			detalleCompraDTO.setMontoTotal(BigDecimal.ZERO);

			pCompraDTO.agregarDetalleCompra(detalleCompraDTO);

			this.actualizarImportes(pCompraDTO);
			this.descripcionServicio = "";
		}
	}

	/**
	 * Elimina un detalle al DTO de la factura.
	 * @param pCompraDTO Compra
	 * @param pDetalleCompraDTO Detalle de la factura
	 * */
	public void eliminarDetalle(CompraDTO pCompraDTO, DetalleCompraDTO pDetalleCompraDTO) {
		int index = pCompraDTO.getColeccionDetalleCompra().indexOf(pDetalleCompraDTO);
		pCompraDTO.getColeccionDetalleCompra().remove(index);

		this.actualizarImportes(pCompraDTO);
	}

	/**
	 * Actualiza el detalle, de acuerdo a los montos.
	 *	@param pCompra Compra
	 * */
	public void actualizarImportes(CompraDTO pCompra) {

		BigDecimal importeTotal = BigDecimal.ZERO;
		for (DetalleCompraDTO detalle : pCompra.getColeccionDetalleCompra()) {
			BigDecimal precio = detalle.getPrecioUnitario().multiply(new BigDecimal(detalle.getCantidad()));
			detalle.setMontoTotal(precio);

			importeTotal = importeTotal.add(precio);
		}

		pCompra.setImporteTotal(importeTotal);
	}

}
