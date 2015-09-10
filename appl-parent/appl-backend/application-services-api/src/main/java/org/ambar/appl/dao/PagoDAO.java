/**
 * application-services-api [8/6/2015 21:15:23]
 */
package org.ambar.appl.dao;

import org.ambar.appl.be.Pago;
import org.ambar.core.dao.CrudDAO;

/**
 * <p>
 * Interfaz que implementa el DAO de Pago.
 * </p>
 *
 * @author Sebastian
 *
 * @see org.ambar.core.dao.DataDAO
 */
public interface PagoDAO extends CrudDAO<Long, Pago> {
}
