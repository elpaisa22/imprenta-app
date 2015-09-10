/**
 * application-services-impl [9/6/2015 19:33:12]
 */
package org.ambar.appl.services.impl;

import org.ambar.appl.be.TipoIngreso;
import org.ambar.appl.dto.TipoIngresoDTO;
import org.ambar.appl.services.TipoIngresoServices;
import org.ambar.core.services.impl.CrudServiceDefaultImpl;

/**
 * <p>
 * Implementación por default de {@link TipoIngresoServices}.
 * </p>
 *
 * @author Sebastian
 *
 */
public class TipoIngresoServicesImpl
       extends CrudServiceDefaultImpl<String, TipoIngresoDTO, String, TipoIngreso>
       implements TipoIngresoServices {

	private static final long serialVersionUID = -8554876785072125330L;
}
