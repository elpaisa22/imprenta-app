/**
 * application-services-api [21/05/2015 18:02:53]
 */
package org.ambar.appl.services;

import org.ambar.appl.be.Rubro;
import org.ambar.appl.dto.RubroDTO;
import org.ambar.core.services.CrudServices;

/**
 * <p>
 * Interfaz que implementa los servicios de la entidad Rubro.
 * </p>
 *
 * @author Sebastian
 *
 * @see org.ambar.core.services.CrudServices
 *
 */
public interface RubroServices
       extends CrudServices<String, RubroDTO, String, Rubro> {
}
