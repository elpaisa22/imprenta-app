/**
 * appl-cliente-services-api [22/08/2011 20:29:40]
 */
package org.ambar.appl.services;

import org.ambar.appl.be.Cliente;
import org.ambar.appl.dto.ClienteDTO;
import org.ambar.core.services.CrudServices;

/**
 * <p>
 * Interfaz que implementa los servicios de la entidad Cliente.
 * </p>
 *
 * @author Sebastian
 *
 * @see org.ambar.core.services.CrudServices
 */
public interface ClienteServices extends CrudServices<Long, ClienteDTO, Long, Cliente> {
}
