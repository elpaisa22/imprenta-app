/**
 * application-services-api [16/02/2014 17:34:20]
 */
package org.ambar.appl.dao;

import org.ambar.appl.be.Articulo;
import org.ambar.core.dao.CrudDAO;

/**
 * <p>
 * Interfaz que implementa el DAO de Articulo.
 * </p>
 *
 * @author Sebastian
 *
 * @see org.ambar.core.dao.DataDAO
 */
public interface ArticuloDAO extends CrudDAO<String, Articulo> {
}
