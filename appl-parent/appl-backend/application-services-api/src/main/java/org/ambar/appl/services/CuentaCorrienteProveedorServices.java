/**
 * application-services-api [15/6/2015 17:16:38]
 */
package org.ambar.appl.services;

import org.ambar.appl.be.CuentaCorrienteProveedor;
import org.ambar.appl.dto.CuentaCorrienteProveedorDTO;
import org.ambar.core.services.CrudServices;

/**
 * <p>
 * Interfaz que implementa los servicios de la entidad CuentaCorrienteProveedor.
 * </p>
 *
 * @author Sebastian
 *
 * @see org.ambar.core.services.CrudServices
 */
public interface CuentaCorrienteProveedorServices
       extends CrudServices<Long, CuentaCorrienteProveedorDTO, Long, CuentaCorrienteProveedor> {
}
