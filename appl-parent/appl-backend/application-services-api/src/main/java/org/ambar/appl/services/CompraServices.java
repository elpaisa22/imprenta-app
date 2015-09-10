/**
 * application-services-api [31/05/2015 19:20:03]
 */
package org.ambar.appl.services;

import org.ambar.appl.be.Compra;
import org.ambar.appl.dto.CompraDTO;
import org.ambar.core.commons.context.RequestContext;
import org.ambar.core.dto.results.ResultListDTO;
import org.ambar.core.services.CrudServices;

/**
 * <p>
 * Interfaz que implementa los servicios de la entidad Compra.
 * </p>
 *
 * @author Sebastian
 *
 * @see org.ambar.core.services.CrudServices
 */
public interface CompraServices extends CrudServices<Long, CompraDTO, Long, Compra> {

	/**
	 * Obtiene las compras pendientes de pago para el Proveedor especificado.
	 * @param pIdProveedor ID Proveedor
	 * @param pRequestContext Request Context
	 * @return {@link ResultListDTO} Resultado
	 * */
    ResultListDTO<CompraDTO> getComprasPendientesPorProveedor(Long pIdProveedor, RequestContext pRequestContext);
}
