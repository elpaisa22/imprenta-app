/**
 * application-services-impl [21/05/2015 18:18:41]
 */
package org.ambar.appl.dao.impl;

import org.ambar.appl.be.Marca;
import org.ambar.appl.dao.MarcaDAO;
import org.ambar.core.dao.impl.CrudDAOImpl;

/**
 * <p>
 * Implementación de {@link MarcaDAO}.
 * </p>
 *
 * @author Sebastian
 *
 */
public class MarcaDAOImpl
       extends CrudDAOImpl<String, Marca>
       implements MarcaDAO {
}
