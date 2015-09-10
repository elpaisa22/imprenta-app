/**
 * application-services-impl [25/08/2012 17:17:41]
 */
package org.ambar.appl.services.impl;

import org.ambar.appl.be.MovimientoCuentaCorriente;
import org.ambar.appl.dto.MovimientoCuentaCorrienteDTO;
import org.ambar.appl.services.MovimientoCuentaCorrienteServices;
import org.ambar.core.services.impl.CrudServiceDefaultImpl;

/**
 * <p>
 * Implementación por default de {@link MovimientoCuentaCorrienteServices}.
 * </p>
 *
 * @author Sebastian
 *
 */
public class MovimientoCuentaCorrienteServicesImpl
	extends CrudServiceDefaultImpl<Long, MovimientoCuentaCorrienteDTO, Long, MovimientoCuentaCorriente>
	implements MovimientoCuentaCorrienteServices {

	private static final long serialVersionUID = -191076515236799686L;
}
