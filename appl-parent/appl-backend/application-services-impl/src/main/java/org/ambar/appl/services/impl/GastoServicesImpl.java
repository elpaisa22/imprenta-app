/**
 * application-services-impl [01/06/2015 18:29:38]
 */
package org.ambar.appl.services.impl;

import org.ambar.appl.be.Gasto;
import org.ambar.appl.dto.GastoDTO;
import org.ambar.appl.services.GastoServices;
import org.ambar.core.services.impl.CrudServiceDefaultImpl;

/**
 * <p>
 * Implementación por default de {@link GastoServices}.
 * </p>
 *
 * @author Sebastian
 *
 */
public class GastoServicesImpl
       extends CrudServiceDefaultImpl<Long, GastoDTO, Long, Gasto>
       implements GastoServices {

	private static final long serialVersionUID = 2269940630476202618L;
}
