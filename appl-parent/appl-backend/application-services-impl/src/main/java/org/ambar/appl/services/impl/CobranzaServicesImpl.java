/**
 * application-services-impl [6/11/2014 18:55:06]
 */
package org.ambar.appl.services.impl;

import org.ambar.appl.be.Cobranza;
import org.ambar.appl.dto.CobranzaDTO;
import org.ambar.appl.services.CobranzaServices;
import org.ambar.core.services.impl.CrudServiceDefaultImpl;

/**
 * <p>
 * Implementación por default de {@link CobranzaServices}.
 * </p>
 *
 * @author Sebastian
 *
 */
public class CobranzaServicesImpl extends CrudServiceDefaultImpl<Long, CobranzaDTO, Long, Cobranza>
                                  implements CobranzaServices {

	private static final long serialVersionUID = -9175039622775061333L;
}
