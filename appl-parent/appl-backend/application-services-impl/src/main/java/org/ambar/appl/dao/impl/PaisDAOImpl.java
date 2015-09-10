/**
 * application-services-impl [23/05/2015 14:18:48]
 */
package org.ambar.appl.dao.impl;

import org.ambar.appl.be.Pais;
import org.ambar.appl.dao.PaisDAO;
import org.ambar.core.dao.impl.CrudDAOImpl;

/**
 * <p>
 * Implementación de {@link PaisDAO}.
 * </p>
 *
 * @author Sebastian
 *
 */
public class PaisDAOImpl
       extends CrudDAOImpl<String, Pais>
       implements PaisDAO {
}
