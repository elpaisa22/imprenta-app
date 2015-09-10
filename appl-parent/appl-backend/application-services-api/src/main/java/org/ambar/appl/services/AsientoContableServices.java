/**
 * application-services-api [31/05/2015 19:19:48]
 */
package org.ambar.appl.services;

import org.ambar.appl.be.AsientoContable;
import org.ambar.appl.dto.AsientoContableDTO;
import org.ambar.core.services.CrudServices;

/**
 * <p>
 * Interfaz que implementa los servicios de la entidad AsientoContable.
 * </p>
 *
 * @author Sebastian
 *
 * @see org.ambar.core.services.CrudServices
 */
public interface AsientoContableServices extends CrudServices<Long, AsientoContableDTO, Long, AsientoContable> {
}
