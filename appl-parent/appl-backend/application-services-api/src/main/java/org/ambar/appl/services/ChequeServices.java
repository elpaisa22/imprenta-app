/**
 * application-services-api [02/03/2013 14:24:16]
 */
package org.ambar.appl.services;

import org.ambar.appl.be.Cheque;
import org.ambar.appl.dto.ChequeDTO;
import org.ambar.core.services.CrudServices;

/**
 * <p>
 * Interfaz que implementa los servicios de la entidad Cheque.
 * </p>
 *
 * @author Sebastian
 *
 * @see org.ambar.core.services.CrudServices
 */
public interface ChequeServices extends CrudServices<Long, ChequeDTO, Long, Cheque> {
}
