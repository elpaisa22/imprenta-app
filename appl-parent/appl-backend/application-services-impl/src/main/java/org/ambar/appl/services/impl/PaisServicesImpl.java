/**
 * application-services-impl [23/05/2015 14:33:45]
 */
package org.ambar.appl.services.impl;

import org.ambar.appl.be.Pais;
import org.ambar.appl.dto.PaisDTO;
import org.ambar.appl.services.PaisServices;
import org.ambar.core.services.impl.CrudServiceDefaultImpl;

/**
 * <p>
 * Implementación por default de {@link PaisServices}.
 * </p>
 *
 * @author Sebastian
 *
 */
public class PaisServicesImpl
       extends CrudServiceDefaultImpl<String, PaisDTO, String, Pais>
       implements PaisServices {

	private static final long serialVersionUID = 8079411728058197843L;
}
