/**
 * application-services-impl [02/03/2013 14:51:19]
 */
package org.ambar.appl.services.impl;

import org.ambar.appl.be.Cheque;
import org.ambar.appl.dto.ChequeDTO;
import org.ambar.appl.services.ChequeServices;
import org.ambar.core.services.impl.CrudServiceDefaultImpl;

/**
 * <p>
 * Implementación por default de {@link ChequeServices}.
 * </p>
 *
 * @author Sebastian
 *
 */
public class ChequeServicesImpl extends CrudServiceDefaultImpl<Long, ChequeDTO, Long, Cheque>
                                implements ChequeServices {

	private static final long serialVersionUID = -4281644480070734138L;
}
