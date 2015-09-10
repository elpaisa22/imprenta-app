/**
 * application-services-api [31/05/2015 19:10:59]
 */
package org.ambar.appl.dao;

import org.ambar.appl.be.Gasto;
import org.ambar.core.dao.CrudDAO;

/**
 * <p>
 * Interfaz que implementa el DAO de Gasto.
 * </p>
 *
 * @author Sebastian
 *
 * @see org.ambar.core.dao.DataDAO
 */
public interface GastoDAO extends CrudDAO<Long, Gasto> {
}
