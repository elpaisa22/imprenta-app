/**
 * application-services-impl [21/05/2015 18:27:25]
 */
package org.ambar.appl.services.impl;

import org.ambar.appl.be.Marca;
import org.ambar.appl.dto.MarcaDTO;
import org.ambar.appl.services.MarcaServices;
import org.ambar.core.services.impl.CrudServiceDefaultImpl;

/**
 * <p>
 * Implementación por default de {@link MarcaServices}.
 * </p>
 *
 * @author Sebastian
 *
 */
public class MarcaServicesImpl
       extends CrudServiceDefaultImpl<String, MarcaDTO, String, Marca>
       implements MarcaServices {

	private static final long serialVersionUID = -1558924009047990361L;
}
