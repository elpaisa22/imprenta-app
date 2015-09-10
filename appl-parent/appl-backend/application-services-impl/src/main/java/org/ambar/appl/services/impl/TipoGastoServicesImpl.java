/**
 * application-services-impl [21/05/2015 18:27:15]
 */
package org.ambar.appl.services.impl;

import org.ambar.appl.be.TipoGasto;
import org.ambar.appl.dto.TipoGastoDTO;
import org.ambar.appl.services.TipoGastoServices;
import org.ambar.core.services.impl.CrudServiceDefaultImpl;

/**
 * <p>
 * Implementación por default de {@link TipoGastoServices}.
 * </p>
 *
 * @author Sebastian
 *
 */
public class TipoGastoServicesImpl
       extends CrudServiceDefaultImpl<String, TipoGastoDTO, String, TipoGasto>
       implements TipoGastoServices {

	private static final long serialVersionUID = -2031561987259864223L;
}
