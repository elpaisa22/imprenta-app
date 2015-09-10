/**
 * application-services-impl [23/05/2015 14:19:35]
 */
package org.ambar.appl.dao.impl;

import org.ambar.appl.be.Proveedor;
import org.ambar.appl.dao.ProveedorDAO;
import org.ambar.core.dao.impl.CrudDAOImpl;

/**
 * <p>
 * Implementación de {@link ProveedorDAO}.
 * </p>
 *
 * @author Sebastian
 *
 */
public class ProveedorDAOImpl
       extends CrudDAOImpl<Long, Proveedor>
       implements ProveedorDAO {
}
