/**
 * application-services-impl [15/6/2015 17:30:54]
 */
package org.ambar.appl.services.impl;

import org.ambar.appl.be.CuentaCorrienteProveedor;
import org.ambar.appl.dto.CuentaCorrienteProveedorDTO;
import org.ambar.appl.services.CuentaCorrienteProveedorServices;
import org.ambar.core.services.impl.CrudServiceDefaultImpl;

/**
 * <p>
 * Implementación por default de {@link CuentaCorrienteProveedorServices}.
 * </p>
 *
 * @author Sebastian
 */
public class CuentaCorrienteProveedorServicesImpl
       extends CrudServiceDefaultImpl<Long, CuentaCorrienteProveedorDTO, Long, CuentaCorrienteProveedor>
       implements CuentaCorrienteProveedorServices {

	private static final long serialVersionUID = 2444025969838925904L;
}
