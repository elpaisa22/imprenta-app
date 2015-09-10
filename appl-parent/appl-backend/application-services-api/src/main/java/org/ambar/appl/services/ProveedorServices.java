/**
 * application-services-api [23/05/2015 14:08:35]
 */
package org.ambar.appl.services;

import org.ambar.appl.be.Proveedor;
import org.ambar.appl.dto.ProveedorDTO;
import org.ambar.core.services.CrudServices;

/**
 * <p>
 * Interfaz que implementa los servicios de la entidad Proveedor.
 * </p>
 *
 * @author Sebastian
 *
 * @see org.ambar.core.services.CrudServices
 *
 */
public interface ProveedorServices extends CrudServices<Long, ProveedorDTO, Long, Proveedor> {
}
