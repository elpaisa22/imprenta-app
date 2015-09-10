/**
 * application-services-api [23/05/2015 11:50:48]
 */
package org.ambar.appl.dao;

import org.ambar.appl.be.Proveedor;
import org.ambar.core.dao.CrudDAO;

/**
 * <p>
 * Interfaz que implementa el DAO de Proveedor.
 * </p>
 *
 * @author Sebastian
 *
 * @see org.ambar.core.dao.DataDAO
 */
public interface ProveedorDAO extends CrudDAO<Long, Proveedor> {
}
