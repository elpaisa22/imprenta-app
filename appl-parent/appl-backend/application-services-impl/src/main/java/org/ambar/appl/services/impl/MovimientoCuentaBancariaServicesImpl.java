/**
 * application-services-impl [2/7/2015 19:44:35]
 */
package org.ambar.appl.services.impl;

import org.ambar.appl.be.MovimientoCuentaBancaria;
import org.ambar.appl.dto.MovimientoCuentaBancariaDTO;
import org.ambar.appl.services.MovimientoCuentaBancariaServices;
import org.ambar.core.services.impl.CrudServiceDefaultImpl;

/**
 * <p>
 * Implementación por default de {@link MovimientoCuentaBancariaServices}.
 * </p>
 *
 * @author Sebastian
 */
public class MovimientoCuentaBancariaServicesImpl
       extends CrudServiceDefaultImpl<Long, MovimientoCuentaBancariaDTO, Long, MovimientoCuentaBancaria>
       implements MovimientoCuentaBancariaServices {

	private static final long serialVersionUID = -2503354936544073903L;
}
