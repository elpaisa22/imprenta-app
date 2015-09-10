/**
 * application-services-impl [25/08/2012 17:17:52]
 */
package org.ambar.appl.services.impl;

import org.ambar.appl.be.Remito;
import org.ambar.appl.dto.RemitoDTO;
import org.ambar.appl.services.RemitoServices;
import org.ambar.core.services.impl.CrudServiceDefaultImpl;

/**
 * <p>
 * Implementación por default de {@link RemitoServices}.
 * </p>
 *
 * @author Sebastian
 *
 */
public class RemitoServicesImpl
	extends CrudServiceDefaultImpl<Long, RemitoDTO, Long, Remito>
	implements RemitoServices {

	private static final long serialVersionUID = 6289692790561042542L;

}
