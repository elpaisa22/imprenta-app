/**
 * application-services-impl [01/06/2015 18:30:23]
 */
package org.ambar.appl.services.impl;

import org.ambar.appl.be.AsientoContable;
import org.ambar.appl.dto.AsientoContableDTO;
import org.ambar.appl.services.AsientoContableServices;
import org.ambar.core.services.impl.CrudServiceDefaultImpl;

/**
 * <p>
 * Implementación por default de {@link AsientoContableServices}.
 * </p>
 *
 * @author Sebastian
 *
 */
public class AsientoContableServicesImpl
       extends CrudServiceDefaultImpl<Long, AsientoContableDTO, Long, AsientoContable>
       implements AsientoContableServices {

	private static final long serialVersionUID = 1737471576266821625L;
}
