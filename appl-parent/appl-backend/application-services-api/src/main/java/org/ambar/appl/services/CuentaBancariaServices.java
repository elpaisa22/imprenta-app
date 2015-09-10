/**
 * application-services-api [2/7/2015 16:41:17]
 */
package org.ambar.appl.services;

import org.ambar.appl.be.CuentaBancaria;
import org.ambar.appl.dto.CuentaBancariaDTO;
import org.ambar.core.services.CrudServices;

/**
 * <p>
 * Interfaz que implementa los servicios de la entidad CuentaBancaria.
 * </p>
 *
 * @author Sebastian
 *
 * @see org.ambar.core.services.CrudServices
 */
public interface CuentaBancariaServices extends CrudServices<Long, CuentaBancariaDTO, Long, CuentaBancaria> {
}
