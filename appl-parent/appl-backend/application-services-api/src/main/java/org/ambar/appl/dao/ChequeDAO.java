/**
 * application-services-api [02/03/2013 14:20:18]
 */
package org.ambar.appl.dao;

import org.ambar.appl.be.Cheque;
import org.ambar.core.dao.CrudDAO;

/**
 * <p>
 * Interfaz que implementa el DAO de Cheque.
 * </p>
 *
 * @author Sebastian
 *
 * @see org.ambar.core.dao.DataDAO
 */
public interface ChequeDAO extends CrudDAO<Long, Cheque> {
}
