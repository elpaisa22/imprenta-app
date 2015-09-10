/**
 * application-services-api [8/6/2015 21:21:03]
 */
package org.ambar.appl.services;

import org.ambar.appl.be.Ingreso;
import org.ambar.appl.dto.IngresoDTO;
import org.ambar.core.services.CrudServices;

/**
 * <p>
 * Interfaz que implementa los servicios de la entidad Ingreso.
 * </p>
 *
 * @author Sebastian
 *
 * @see org.ambar.core.services.CrudServices
 */
public interface IngresoServices extends CrudServices<Long, IngresoDTO, Long, Ingreso> {
}
