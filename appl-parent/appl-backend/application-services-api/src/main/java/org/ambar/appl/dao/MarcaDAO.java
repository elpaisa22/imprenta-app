/**
 * application-services-api [21/05/2015 17:56:06]
 */
package org.ambar.appl.dao;

import org.ambar.appl.be.Marca;
import org.ambar.core.dao.CrudDAO;

/**
 * <p>
 * Interfaz que implementa el DAO de Marca.
 * </p>
 *
 * @author Sebastian
 *
 * @see org.ambar.core.dao.DataDAO
 */
public interface MarcaDAO extends CrudDAO<String, Marca> {
}
