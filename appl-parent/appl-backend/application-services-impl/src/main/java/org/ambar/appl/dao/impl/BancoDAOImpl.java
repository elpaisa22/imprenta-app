/**
 * application-services-impl [23/05/2015 14:19:46]
 */
package org.ambar.appl.dao.impl;

import org.ambar.appl.be.Banco;
import org.ambar.appl.dao.BancoDAO;
import org.ambar.core.dao.impl.CrudDAOImpl;

/**
 * <p>
 * Implementación de {@link BancoDAO}.
 * </p>
 *
 * @author Sebastian
 *
 */
public class BancoDAOImpl
       extends CrudDAOImpl<String, Banco>
       implements BancoDAO {
}
