/**
 * application-services-impl [23/05/2015 14:32:25]
 */
package org.ambar.appl.services.impl;

import org.ambar.appl.be.Banco;
import org.ambar.appl.dto.BancoDTO;
import org.ambar.appl.services.BancoServices;
import org.ambar.core.services.impl.CrudServiceDefaultImpl;

/**
 * <p>
 * Implementación por default de {@link BancoServices}.
 * </p>
 *
 * @author Sebastian
 *
 */
public class BancoServicesImpl
       extends CrudServiceDefaultImpl<String, BancoDTO, String, Banco>
       implements BancoServices {

	private static final long serialVersionUID = -9056051645663246835L;
}
