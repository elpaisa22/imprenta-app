/**
 * application-services-impl [03/06/2014 21:48:57]
 */
package org.ambar.appl.services.impl;

import org.ambar.appl.be.CuentaCorriente;
import org.ambar.appl.dto.CuentaCorrienteDTO;
import org.ambar.appl.services.CuentaCorrienteServices;
import org.ambar.core.services.impl.CrudServiceDefaultImpl;

/**
 * <p>
 * Implementación por default de {@link CuentaCorrienteServices}.
 * </p>
 *
 * @author Sebastian
 *
 */
public class CuentaCorrienteServicesImpl
             extends CrudServiceDefaultImpl<Long, CuentaCorrienteDTO, Long, CuentaCorriente>
             implements CuentaCorrienteServices {

	private static final long serialVersionUID = 1557194008835290844L;

}
