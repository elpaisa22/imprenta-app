/**
 * application-services-impl [9/6/2015 19:32:50]
 */
package org.ambar.appl.services.impl;

import org.ambar.appl.be.Pago;
import org.ambar.appl.dto.PagoDTO;
import org.ambar.appl.services.PagoServices;
import org.ambar.core.services.impl.CrudServiceDefaultImpl;

/**
 * <p>
 * Implementación por default de {@link PagoServices}.
 * </p>
 *
 * @author Sebastian
 *
 */
public class PagoServicesImpl
       extends CrudServiceDefaultImpl<Long, PagoDTO, Long, Pago>
       implements PagoServices {

	private static final long serialVersionUID = 2926314881284316465L;
}
