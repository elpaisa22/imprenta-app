/**
 * appl-cliente-services-api [22/08/2011 20:29:17]
 */
package org.ambar.appl.dao;

import org.ambar.appl.be.Cliente;
import org.ambar.core.dao.CrudDAO;

/**
 * <p>
 * Interfaz que implementa el DAO de Cliente.
 * </p>
 *
 * @author Sebastian
 *
 * @see org.ambar.core.dao.DataDAO
 */
public interface ClienteDAO extends CrudDAO<Long, Cliente> {
}
