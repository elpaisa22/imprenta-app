/**
 * appl-cliente-services-impl [22/08/2011 22:39:19]
 */
package org.ambar.appl.services.impl;

import org.ambar.appl.be.Cliente;
import org.ambar.appl.dto.ClienteDTO;
import org.ambar.appl.services.ClienteServices;
import org.ambar.core.services.impl.CrudServiceDefaultImpl;


/**
 * <p>
 * Implementación por default de {@link ClienteServices}.
 * </p>
 *
 * @author Sebastian
 *
 */
public class ClienteServicesImpl extends CrudServiceDefaultImpl<Long, ClienteDTO, Long, Cliente>
								implements ClienteServices {

	private static final long serialVersionUID = -352126055185847076L;
}
