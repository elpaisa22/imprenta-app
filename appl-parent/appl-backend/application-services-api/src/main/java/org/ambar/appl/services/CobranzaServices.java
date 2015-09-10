/**
 * application-services-api [6/11/2014 18:50:39]
 */
package org.ambar.appl.services;

import org.ambar.appl.be.Cobranza;
import org.ambar.appl.dto.CobranzaDTO;
import org.ambar.core.services.CrudServices;

/**
 * <p>
 * Interfaz que implementa los servicios de la entidad Cobranza.
 * </p>
 *
 * @author Sebastian
 *
 * @see org.ambar.core.services.CrudServices
 */
public interface CobranzaServices extends CrudServices<Long, CobranzaDTO, Long, Cobranza> {
}
