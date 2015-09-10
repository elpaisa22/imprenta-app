/**
 * application-services-api [21/05/2015 18:02:34]
 */
package org.ambar.appl.services;

import org.ambar.appl.be.Marca;
import org.ambar.appl.dto.MarcaDTO;
import org.ambar.core.services.CrudServices;

/**
 * <p>
 * Interfaz que implementa los servicios de la entidad Marca.
 * </p>
 *
 * @author Sebastian
 *
 * @see org.ambar.core.services.CrudServices
 *
 */
public interface MarcaServices
       extends CrudServices<String, MarcaDTO, String, Marca> {
}
