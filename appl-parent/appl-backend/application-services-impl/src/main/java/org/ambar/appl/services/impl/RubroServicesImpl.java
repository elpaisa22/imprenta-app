/**
 * application-services-impl [21/05/2015 18:27:01]
 */
package org.ambar.appl.services.impl;

import org.ambar.appl.be.Rubro;
import org.ambar.appl.dto.RubroDTO;
import org.ambar.appl.services.RubroServices;
import org.ambar.core.services.impl.CrudServiceDefaultImpl;

/**
 * <p>
 * Implementación por default de {@link RubroServices}.
 * </p>
 *
 * @author Sebastian
 *
 */
public class RubroServicesImpl
       extends CrudServiceDefaultImpl<String, RubroDTO, String, Rubro>
       implements RubroServices {

	private static final long serialVersionUID = -569439086451478643L;
}
