/**
 * application-services-api [03/06/2014 21:42:00]
 */
package org.ambar.appl.dao;

import org.ambar.appl.be.CuentaCorriente;
import org.ambar.core.dao.CrudDAO;

/**
 * <p>
 * Interfaz que implementa el DAO de Cuenta Corriente.
 * </p>
 *
 * @author Sebastian
 *
 * @see org.ambar.core.dao.DataDAO
 */
public interface CuentaCorrienteDAO extends CrudDAO<Long, CuentaCorriente> {
}
