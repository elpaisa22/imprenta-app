/**
 * application-services-api [16/02/2014 17:36:42]
 */
package org.ambar.appl.services;

import org.ambar.appl.be.Articulo;
import org.ambar.appl.dto.ArticuloDTO;
import org.ambar.core.services.CrudServices;

/**
 * <p>
 * Interfaz que implementa los servicios de la entidad Articulo.
 * </p>
 *
 * @author Sebastian
 *
 * @see org.ambar.core.services.CrudServices
 */
public interface ArticuloServices extends CrudServices<String, ArticuloDTO, String, Articulo> {
}
