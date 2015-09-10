/**
 * application-services-api [25/08/2012 13:23:45]
 */
package org.ambar.appl.services;

import org.ambar.appl.be.MovimientoCuentaCorriente;
import org.ambar.appl.dto.MovimientoCuentaCorrienteDTO;
import org.ambar.core.services.CrudServices;

/**
 * <p>
 * Interfaz que implementa los servicios de la entidad Movimiento.
 * </p>
 *
 * @author Sebastian
 *
 * @see org.ambar.core.services.CrudServices
 */
public interface MovimientoCuentaCorrienteServices
       extends CrudServices<Long, MovimientoCuentaCorrienteDTO, Long, MovimientoCuentaCorriente> {
}
