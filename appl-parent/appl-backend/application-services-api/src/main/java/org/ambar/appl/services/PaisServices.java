/**
 * application-services-api [23/05/2015 14:08:03]
 */
package org.ambar.appl.services;

import org.ambar.appl.be.Pais;
import org.ambar.appl.dto.PaisDTO;
import org.ambar.core.services.CrudServices;

/**
 * <p>
 * Interfaz que implementa los servicios de la entidad Pais.
 * </p>
 *
 * @author Sebastian
 *
 * @see org.ambar.core.services.CrudServices
 *
 */
public interface PaisServices extends CrudServices<String, PaisDTO, String, Pais> {
}
