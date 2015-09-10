/**
 * application-services-impl [2/7/2015 19:44:24]
 */
package org.ambar.appl.services.impl;

import org.ambar.appl.be.CuentaBancaria;
import org.ambar.appl.dto.CuentaBancariaDTO;
import org.ambar.appl.services.CuentaBancariaServices;
import org.ambar.core.services.impl.CrudServiceDefaultImpl;

/**
 * <p>
 * Implementación por default de {@link CuentaBancariaServices}.
 * </p>
 *
 * @author Sebastian
 */
public class CuentaBancariaServicesImpl
       extends CrudServiceDefaultImpl<Long, CuentaBancariaDTO, Long, CuentaBancaria>
       implements CuentaBancariaServices {

	private static final long serialVersionUID = 5732329155037115083L;
}
