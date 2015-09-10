/**
 * application-services-api [22/05/2012 17:55:33]
 */
package org.ambar.appl.services;

import org.ambar.appl.be.OrdenTrabajo;
import org.ambar.appl.dto.OrdenTrabajoDTO;
import org.ambar.core.commons.context.RequestContext;
import org.ambar.core.dto.results.ResultListDTO;
import org.ambar.core.services.CrudServices;

/**
 * <p>
 * Interfaz que implementa los servicios de la entidad OrdenTrabajo.
 * </p>
 *
 * @author Sebastian
 *
 * @see org.ambar.core.services.CrudServices
 */
public interface OrdenTrabajoServices extends CrudServices<Long, OrdenTrabajoDTO, Long, OrdenTrabajo> {

	/**
	 * Busca todas las Ordenes de Trabajo filtradas por Cliente.
	 * @param pIdCliente ID Cliente
	 * @param pRequestContext Contexto de la petición
	 * @return {@link ResultListDTO} Encapsula mensajes de la operación y la lista de DTOs
	 */
	ResultListDTO<OrdenTrabajoDTO> getOrdenesForIdCliente(Long pIdCliente, RequestContext pRequestContext);
}
