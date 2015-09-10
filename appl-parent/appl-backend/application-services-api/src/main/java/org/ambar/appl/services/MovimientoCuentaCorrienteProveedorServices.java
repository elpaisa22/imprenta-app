/**
 * application-services-api [15/6/2015 17:16:16]
 */
package org.ambar.appl.services;

import org.ambar.appl.be.MovimientoCuentaCorrienteProveedor;
import org.ambar.appl.dto.MovimientoCuentaCorrienteProveedorDTO;
import org.ambar.core.services.CrudServices;

/**
 * <p>
 * Interfaz que implementa los servicios de la entidad MovimientoCuentaCorrienteProveedor.
 * </p>
 *
 * @author Sebastian
 *
 * @see org.ambar.core.services.CrudServices
 */
public interface MovimientoCuentaCorrienteProveedorServices
       extends CrudServices<Long, MovimientoCuentaCorrienteProveedorDTO, Long, MovimientoCuentaCorrienteProveedor> {
}
