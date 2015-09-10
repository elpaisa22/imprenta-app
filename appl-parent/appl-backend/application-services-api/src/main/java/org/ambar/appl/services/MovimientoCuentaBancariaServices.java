/**
 * application-services-api [2/7/2015 16:41:00]
 */
package org.ambar.appl.services;

import org.ambar.appl.be.MovimientoCuentaBancaria;
import org.ambar.appl.dto.MovimientoCuentaBancariaDTO;
import org.ambar.core.services.CrudServices;

/**
 * <p>
 * Interfaz que implementa los servicios de la entidad MovimientoCuentaBancaria.
 * </p>
 *
 * @author Sebastian
 *
 * @see org.ambar.core.services.CrudServices
 */
public interface MovimientoCuentaBancariaServices
       extends CrudServices<Long, MovimientoCuentaBancariaDTO, Long, MovimientoCuentaBancaria> {
}
