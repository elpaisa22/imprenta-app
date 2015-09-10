/**
 * appl-frontend-web [18/03/2014 19:18:53]
 */
package org.ambar.appl.frontend.viewbeans;

import java.io.Serializable;
import java.math.BigDecimal;

import org.ambar.appl.commons.enums.TipoCondicionIVAValues;
import org.ambar.appl.commons.enums.TipoFacturaValues;
import org.ambar.appl.dto.ArticuloDTO;
import org.ambar.appl.dto.ClienteDTO;
import org.ambar.appl.dto.DetalleFacturaDTO;
import org.ambar.appl.dto.FacturaDTO;

/**
 * <p>
 * Bean utilizado en el ABM de Factura.
 * </p>
 *
 * @author Sebastian
 *
 */
public class ABMFacturaBean implements Serializable {

	private static final long serialVersionUID = -4377310542506924784L;

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
	 * @param pFacturaDTO Factura
	 * @param pArticulo Articulo
	 * */
	public void agregarDetalle(FacturaDTO pFacturaDTO, ArticuloDTO pArticulo) {


		if (pArticulo != null) {
			DetalleFacturaDTO detalleFacturaDTO = new DetalleFacturaDTO();
			detalleFacturaDTO.setIdArticulo(pArticulo.getId());
			detalleFacturaDTO.setCantidad(1);
			detalleFacturaDTO.setPrecioUnitario(pArticulo.getPrecioBruto());
			detalleFacturaDTO.setMontoTotal(pArticulo.getPrecioBruto());
			detalleFacturaDTO.setDescripcionArticulo(pArticulo.getDescripcion());

			pFacturaDTO.agregarDetalleFactura(detalleFacturaDTO);

			this.actualizarImportes(pFacturaDTO);
		}
	}

	/**
	 * Agrega un detalle al DTO de la factura.
	 * @param pFacturaDTO Factura
	 * @param pDescripcion Descripcion
	 * */
	public void agregarDetalle(FacturaDTO pFacturaDTO, String pDescripcion) {
		if (pDescripcion != null) {
			DetalleFacturaDTO detalleFacturaDTO = new DetalleFacturaDTO();
			detalleFacturaDTO.setDescripcionServicio(pDescripcion);
			detalleFacturaDTO.setCantidad(1);
			detalleFacturaDTO.setPrecioUnitario(BigDecimal.ZERO);
			detalleFacturaDTO.setMontoTotal(BigDecimal.ZERO);

			pFacturaDTO.agregarDetalleFactura(detalleFacturaDTO);

			this.actualizarImportes(pFacturaDTO);
			this.descripcionServicio = "";
		}
	}

	/**
	 * Elimina un detalle al DTO de la factura.
	 * @param pFacturaDTO Factura
	 * @param pDetalleFacturaDTO Detalle de la factura
	 * */
	public void eliminarDetalle(FacturaDTO pFacturaDTO, DetalleFacturaDTO pDetalleFacturaDTO) {
		int index = pFacturaDTO.getColeccionDetalleFacturas().indexOf(pDetalleFacturaDTO);
		pFacturaDTO.getColeccionDetalleFacturas().remove(index);

		this.actualizarImportes(pFacturaDTO);
	}

	/**
	 * Actualiza el detalle, de acuerdo a los montos.
	 *	@param pFactura Factura
	 * */
	public void actualizarImportes(FacturaDTO pFactura) {

		BigDecimal importeTotal = BigDecimal.ZERO;
		for (DetalleFacturaDTO detalle : pFactura.getColeccionDetalleFacturas()) {
			BigDecimal precio = detalle.getPrecioUnitario().multiply(new BigDecimal(detalle.getCantidad()));
			detalle.setMontoTotal(precio);

			importeTotal = importeTotal.add(precio);
		}

		pFactura.setImporteTotal(importeTotal);

		//Calculos de IVA
		pFactura.setImporteIVA(this.getImporteIVA(pFactura));
		pFactura.setImporteSubTotal(importeTotal.subtract(pFactura.getImporteIVA()));
	}

	/**
	 * Retorna el importe del IVA.
	 * @param pFactura Factura
	 * @return {@link BigDecimal} Importe IVA
	 * */
	private BigDecimal getImporteIVA(FacturaDTO pFactura) {
		BigDecimal iva = new BigDecimal("21");
		BigDecimal total = new BigDecimal("100");
		return iva.multiply(pFactura.getImporteTotal()).divide(total);
	}

	/**
	 * Se dispara cuando ha cambiado el Cliente.
	 * @param pFactura Factura
	 * @param pCliente Cliente
	 * */
	public void clienteChanged(FacturaDTO pFactura, ClienteDTO pCliente) {
	    if (pCliente != null) {
	    	if (pCliente.getCondicionIVA().compareTo(TipoCondicionIVAValues.RESPONSABLE_INSCRIPTO.getValor()) == 0
	    			|| pCliente.getCondicionIVA()
	    			           .compareTo(TipoCondicionIVAValues.RESPONSABLE_NOINSCRIPTO.getValor()) == 0) {
	    		pFactura.setTipoFactura(TipoFacturaValues.A.getValor());
	    		pFactura.setDescripcionTipoFactura(TipoFacturaValues.A.getDescripcion());
	    	} else {
	    		pFactura.setTipoFactura(TipoFacturaValues.B.getValor());
	    		pFactura.setDescripcionTipoFactura(TipoFacturaValues.B.getDescripcion());
	    	}
	    } else {
	    	pFactura.setTipoFactura(null);
    		pFactura.setDescripcionTipoFactura(null);
	    }
	}

}
