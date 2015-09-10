/**
 * application-services-api [25/08/2012 13:23:37]
 */
package org.ambar.appl.services;

import org.ambar.appl.be.Factura;
import org.ambar.appl.dto.FacturaDTO;
import org.ambar.core.commons.context.RequestContext;
import org.ambar.core.dto.results.ResultListDTO;
import org.ambar.core.services.CrudServices;

/**
 * <p>
 * Interfaz que implementa los servicios de la entidad Factura.
 * </p>
 *
 * @author Sebastian
 *
 * @see org.ambar.core.services.CrudServices
 */
public interface FacturaServices extends CrudServices<Long, FacturaDTO, Long, Factura> {

	/**
	 * Obtiene las facturas pendientes de pago para el Cliente especificado.
	 * @param pIdCliente ID Cliente
	 * @param pRequestContext Request Context
	 * @return {@link ResultListDTO} Resultado
	 * */
    ResultListDTO<FacturaDTO> getFacturasPendientesPorCliente(Long pIdCliente, RequestContext pRequestContext);
}
