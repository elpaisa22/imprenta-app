/**
 * application-services-impl [23/05/2015 14:33:14]
 */
package org.ambar.appl.services.impl;

import org.ambar.appl.be.Proveedor;
import org.ambar.appl.dto.ProveedorDTO;
import org.ambar.appl.services.ProveedorServices;
import org.ambar.core.services.impl.CrudServiceDefaultImpl;

/**
 * <p>
 * Implementación por default de {@link ProveedorServices}.
 * </p>
 *
 * @author Sebastian
 *
 */
public class ProveedorServicesImpl
       extends CrudServiceDefaultImpl<Long, ProveedorDTO, Long, Proveedor>
       implements ProveedorServices {

	private static final long serialVersionUID = -585975895960072057L;
}
