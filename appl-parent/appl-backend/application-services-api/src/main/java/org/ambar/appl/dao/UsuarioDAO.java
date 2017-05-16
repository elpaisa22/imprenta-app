/**
 * application-services-api [15 de may. de 2017 4:51:47 p. m.]
 */
package org.ambar.appl.dao;

import org.ambar.appl.be.Usuario;
import org.ambar.core.dao.CrudDAO;

/**
 * <p>
 * Interfaz que implementa el DAO de Usuario.
 * </p>
 *
 * @author Sebastian
 *
 * @see org.ambar.core.dao.DataDAO
 */
public interface UsuarioDAO extends CrudDAO<String, Usuario> {
}
