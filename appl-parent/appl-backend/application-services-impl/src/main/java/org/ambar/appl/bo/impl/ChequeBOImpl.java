/**
 * application-services-impl [02/03/2013 14:26:02]
 */
package org.ambar.appl.bo.impl;

import org.ambar.appl.be.Cheque;
import org.ambar.appl.bo.ChequeBO;
import org.ambar.core.bo.impl.CrudBusinessObjectImpl;
import org.ambar.core.validation.configuration.Validation;
import org.ambar.core.validation.configuration.ValidationStrategy;
import org.ambar.core.validation.configuration.Validations;

/**
 * <p>
 * Implementación por default de {@link ChequeBO}.
 * </p>
 *
 * @author Sebastian
 *
 *
 */
@Validations(
		validations = {
				@Validation(
						transactionNames = { "insert" },
						validators = { "applicationHibernateValidators" }
						),
				@Validation(
						transactionNames = { "update" },
						validators = { "applicationHibernateValidators" })
		},
		strategy = ValidationStrategy.CONTINUE
)
public class ChequeBOImpl extends CrudBusinessObjectImpl<Long, Cheque> implements ChequeBO {
}
