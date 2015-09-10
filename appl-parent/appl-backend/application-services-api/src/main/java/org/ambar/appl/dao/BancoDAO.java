/**
 * application-services-api [23/05/2015 11:50:01]
 */
package org.ambar.appl.dao;

import org.ambar.appl.be.Banco;
import org.ambar.core.dao.CrudDAO;

/**
 * <p>
 * Interfaz que implementa el DAO de Banco.
 * </p>
 *
 * @author Sebastian
 *
 * @see org.ambar.core.dao.DataDAO
 */
public interface BancoDAO extends CrudDAO<String, Banco> {
}
