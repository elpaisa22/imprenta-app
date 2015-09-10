/**
 * application-services-api [8/6/2015 21:20:48]
 */
package org.ambar.appl.services;

import org.ambar.appl.be.TipoIngreso;
import org.ambar.appl.dto.TipoIngresoDTO;
import org.ambar.core.services.CrudServices;

/**
 * <p>
 * Interfaz que implementa los servicios de la entidad TipoIngreso.
 * </p>
 *
 * @author Sebastian
 *
 * @see org.ambar.core.services.CrudServices
 */
public interface TipoIngresoServices extends CrudServices<String, TipoIngresoDTO, String, TipoIngreso> {
}
