/**
 * application-services-api [25/08/2012 13:16:08]
 */
package org.ambar.appl.dao;

import org.ambar.appl.be.Factura;
import org.ambar.core.dao.CrudDAO;

/**
 * <p>
 * Interfaz que implementa el DAO de Factura.
 * </p>
 *
 * @author Sebastian
 *
 * @see org.ambar.core.dao.DataDAO
 */
public interface FacturaDAO extends CrudDAO<Long, Factura> {
}
