/**
 * application-services-api [8/6/2015 21:21:40]
 */
package org.ambar.appl.services;

import org.ambar.appl.be.Pago;
import org.ambar.appl.dto.PagoDTO;
import org.ambar.core.services.CrudServices;

/**
 * <p>
 * Interfaz que implementa los servicios de la entidad Pago.
 * </p>
 *
 * @author Sebastian
 *
 * @see org.ambar.core.services.CrudServices
 */
public interface PagoServices extends CrudServices<Long, PagoDTO, Long, Pago> {
}
