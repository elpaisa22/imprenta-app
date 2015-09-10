/**
 * application-services-impl [9/6/2015 19:33:25]
 */
package org.ambar.appl.services.impl;

import org.ambar.appl.be.Ingreso;
import org.ambar.appl.dto.IngresoDTO;
import org.ambar.appl.services.IngresoServices;
import org.ambar.core.services.impl.CrudServiceDefaultImpl;

/**
 * <p>
 * Implementación por default de {@link IngresoServices}.
 * </p>
 *
 * @author Sebastian
 *
 */
public class IngresoServicesImpl
       extends CrudServiceDefaultImpl<Long, IngresoDTO, Long, Ingreso>
       implements IngresoServices {

	private static final long serialVersionUID = -6180736093200439930L;
}
