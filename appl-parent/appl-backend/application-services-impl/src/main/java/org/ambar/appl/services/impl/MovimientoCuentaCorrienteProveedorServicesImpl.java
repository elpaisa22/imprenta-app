/**
 * application-services-impl [15/6/2015 17:31:11]
 */
package org.ambar.appl.services.impl;

import org.ambar.appl.be.MovimientoCuentaCorrienteProveedor;
import org.ambar.appl.dto.MovimientoCuentaCorrienteProveedorDTO;
import org.ambar.appl.services.MovimientoCuentaCorrienteProveedorServices;
import org.ambar.core.services.impl.CrudServiceDefaultImpl;

/**
 * <p>
 * Implementación por default de {@link MovimientoCuentaCorrienteProveedorServices}.
 * </p>
 *
 * @author Sebastian
 */
public class MovimientoCuentaCorrienteProveedorServicesImpl
       extends CrudServiceDefaultImpl<Long,
                                      MovimientoCuentaCorrienteProveedorDTO,
                                      Long,
                                      MovimientoCuentaCorrienteProveedor>
       implements MovimientoCuentaCorrienteProveedorServices {

	private static final long serialVersionUID = -5879838783980780729L;
}
