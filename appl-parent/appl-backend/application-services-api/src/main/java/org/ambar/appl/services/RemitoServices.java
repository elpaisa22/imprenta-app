/**
 * application-services-api [25/08/2012 13:23:53]
 */
package org.ambar.appl.services;

import org.ambar.appl.be.Remito;
import org.ambar.appl.dto.RemitoDTO;
import org.ambar.core.services.CrudServices;

/**
 * <p>
 * Interfaz que implementa los servicios de la entidad Remito.
 * </p>
 *
 * @author Sebastian
 *
 * @see org.ambar.core.services.CrudServices
 */
public interface RemitoServices extends CrudServices<Long, RemitoDTO, Long, Remito> {
}
