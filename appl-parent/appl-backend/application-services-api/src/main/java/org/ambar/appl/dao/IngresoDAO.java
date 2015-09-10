/**
 * application-services-api [8/6/2015 21:15:10]
 */
package org.ambar.appl.dao;

import org.ambar.appl.be.Ingreso;
import org.ambar.core.dao.CrudDAO;

/**
 * <p>
 * Interfaz que implementa el DAO de Ingreso.
 * </p>
 *
 * @author Sebastian
 *
 * @see org.ambar.core.dao.DataDAO
 */
public interface IngresoDAO extends CrudDAO<Long, Ingreso> {
}
