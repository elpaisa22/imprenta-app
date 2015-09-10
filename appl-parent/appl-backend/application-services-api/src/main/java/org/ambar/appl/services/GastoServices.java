/**
 * application-services-api [31/05/2015 19:19:33]
 */
package org.ambar.appl.services;

import org.ambar.appl.be.Gasto;
import org.ambar.appl.dto.GastoDTO;
import org.ambar.core.services.CrudServices;

/**
 * <p>
 * Interfaz que implementa los servicios de la entidad Gasto.
 * </p>
 *
 * @author Sebastian
 *
 * @see org.ambar.core.services.CrudServices
 */
public interface GastoServices extends CrudServices<Long, GastoDTO, Long, Gasto> {
}
