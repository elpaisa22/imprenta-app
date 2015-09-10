/**
 * application-services-api [03/06/2014 21:43:55]
 */
package org.ambar.appl.services;

import org.ambar.appl.be.CuentaCorriente;
import org.ambar.appl.dto.CuentaCorrienteDTO;
import org.ambar.core.services.CrudServices;

/**
 * <p>
 * Interfaz que implementa los servicios de la entidad CuentaCorriente.
 * </p>
 *
 * @author Sebastian
 *
 * @see org.ambar.core.services.CrudServices
 */
public interface CuentaCorrienteServices extends CrudServices<Long, CuentaCorrienteDTO, Long, CuentaCorriente> {
}
