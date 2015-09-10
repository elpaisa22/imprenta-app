/**
 * application-services-api [23/05/2015 14:07:52]
 */
package org.ambar.appl.services;

import org.ambar.appl.be.Provincia;
import org.ambar.appl.be.ProvinciaID;
import org.ambar.appl.dto.ProvinciaDTO;
import org.ambar.core.commons.context.RequestContext;
import org.ambar.core.dto.results.ResultListDTO;
import org.ambar.core.services.CrudServices;

/**
 * <p>
 * Interfaz que implementa los servicios de la entidad Provincia.
 * </p>
 *
 * @author Sebastian
 *
 * @see org.ambar.core.services.CrudServices
 *
 */
public interface ProvinciaServices extends CrudServices<ProvinciaDTO, ProvinciaDTO, ProvinciaID, Provincia> {

	/**
	 * Retorna la lista de provincias para el pais que se recibe por parametro.
	 * @param pIdPais ID Pais
	 * @param pRequestContext RequestContext
	 * @return {@link ResultListDTO} Provincias
	 * */
	ResultListDTO<ProvinciaDTO> getByIdPais(String pIdPais, RequestContext pRequestContext);
}
