/**
 * application-services-api [21/05/2015 18:02:23]
 */
package org.ambar.appl.services;

import org.ambar.appl.be.TipoGasto;
import org.ambar.appl.dto.TipoGastoDTO;
import org.ambar.core.services.CrudServices;

/**
 * <p>
 * Interfaz que implementa los servicios de la entidad Tipo Gasto.
 * </p>
 *
 * @author Sebastian
 *
 * @see org.ambar.core.services.CrudServices
 *
 */
public interface TipoGastoServices
       extends CrudServices<String, TipoGastoDTO, String, TipoGasto> {
}
