/**
 * application-services-api [28/04/2015 19:21:02]
 */
package org.ambar.appl.services;

import org.ambar.appl.be.NumeradorComprobante;
import org.ambar.appl.dto.NumeradorComprobanteDTO;
import org.ambar.core.services.CrudServices;

/**
 * <p>
 * Interfaz que implementa los servicios de la entidad Numerador Comprobante.
 * </p>
 *
 * @author Sebastian
 *
 * @see org.ambar.core.services.CrudServices
 */
public interface NumeradorComprobanteServices
       extends CrudServices<Long, NumeradorComprobanteDTO, Long, NumeradorComprobante> {
}
