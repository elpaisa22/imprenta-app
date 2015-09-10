/**
 * appl-frontend-web [19/03/2014 20:52:06]
 */
package org.ambar.appl.frontend.viewbeans;

import java.io.Serializable;
import java.math.BigDecimal;

import org.ambar.appl.dto.ArticuloDTO;

/**
 * <p>
 * Bean utilizado en el ABM de Articulo.
 * </p>
 *
 * @author Sebastian
 *
 */
public class ABMArticuloBean implements Serializable {

	private static final long serialVersionUID = -7709498371973671587L;

	/**
	 * Actualiza el precio del articulo, de acuerdo a los montos.
	 *	@param pArticuloDTO Articulo
	 * */
	public void actualizarPrecio(ArticuloDTO pArticuloDTO) {
		pArticuloDTO.setPrecioNeto(pArticuloDTO.getCosto());

		BigDecimal ganancia =
				pArticuloDTO.getPrecioNeto()
                            .multiply(pArticuloDTO.getPorcGanancia().divide(new BigDecimal("100")));
		pArticuloDTO.setPrecioNeto(pArticuloDTO.getCosto().add(ganancia));

		BigDecimal iva =
				pArticuloDTO.getPrecioNeto()
				            .multiply(pArticuloDTO.getPorcIva().divide(new BigDecimal("100")));

		pArticuloDTO.setPrecioBruto(pArticuloDTO.getPrecioNeto().add(iva));

	}
}
