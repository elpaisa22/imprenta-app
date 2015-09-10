/**
 * application-services-impl [28/04/2015 19:31:18]
 */
package org.ambar.appl.services.impl;

import org.ambar.appl.be.NumeradorComprobante;
import org.ambar.appl.dto.NumeradorComprobanteDTO;
import org.ambar.appl.services.NumeradorComprobanteServices;
import org.ambar.core.services.impl.CrudServiceDefaultImpl;

/**
 * <p>
 * Implementación por default de {@link NumeradorComprobanteServices}.
 * </p>
 *
 * @author Sebastian
 *
 */
public class NumeradorComprobanteServicesImpl
       extends CrudServiceDefaultImpl<Long, NumeradorComprobanteDTO, Long, NumeradorComprobante>
       implements NumeradorComprobanteServices {

	private static final long serialVersionUID = 2402712795336012081L;
}
