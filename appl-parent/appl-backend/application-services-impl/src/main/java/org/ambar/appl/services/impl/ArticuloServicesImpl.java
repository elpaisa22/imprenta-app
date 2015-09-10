/**
 * application-services-impl [16/02/2014 17:42:51]
 */
package org.ambar.appl.services.impl;

import org.ambar.appl.be.Articulo;
import org.ambar.appl.dto.ArticuloDTO;
import org.ambar.appl.services.ArticuloServices;
import org.ambar.core.services.impl.CrudServiceDefaultImpl;

/**
 * <p>
 * Implementación por default de {@link ArticuloServices}.
 * </p>
 *
 * @author Sebastian
 *
 */
public class ArticuloServicesImpl extends CrudServiceDefaultImpl<String, ArticuloDTO, String, Articulo>
								  implements ArticuloServices {

	private static final long serialVersionUID = 6113953367435824823L;
}
