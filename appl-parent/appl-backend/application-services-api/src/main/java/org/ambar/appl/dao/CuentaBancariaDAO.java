/**
 * application-services-api [2/7/2015 16:36:36]
 */
package org.ambar.appl.dao;

import org.ambar.appl.be.CuentaBancaria;
import org.ambar.core.dao.CrudDAO;

/**
 * <p>
 * Interfaz que implementa el DAO de CuentaBancaria.
 * </p>
 *
 * @author Sebastian
 *
 * @see org.ambar.core.dao.DataDAO
 */
public interface CuentaBancariaDAO extends CrudDAO<Long, CuentaBancaria> {
}
