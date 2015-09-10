/**
 * application-services-api [23/05/2015 14:08:13]
 */
package org.ambar.appl.services;

import org.ambar.appl.be.Banco;
import org.ambar.appl.dto.BancoDTO;
import org.ambar.core.services.CrudServices;

/**
 * <p>
 * Interfaz que implementa los servicios de la entidad Banco.
 * </p>
 *
 * @author Sebastian
 *
 * @see org.ambar.core.services.CrudServices
 *
 */
public interface BancoServices extends CrudServices<String, BancoDTO, String, Banco> {
}
