/**
 * application-services-impl [01/06/2015 18:17:31]
 */
package org.ambar.appl.bo.impl;

import org.ambar.appl.be.AsientoContable;
import org.ambar.appl.bo.AsientoContableBO;
import org.ambar.core.bo.impl.CrudBusinessObjectImpl;
import org.ambar.core.validation.configuration.Validation;
import org.ambar.core.validation.configuration.ValidationStrategy;
import org.ambar.core.validation.configuration.Validations;

/**
 * <p>
 * Implementación por default de {@link AsientoContableBO}.
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
public class AsientoContableBOImpl extends CrudBusinessObjectImpl<Long, AsientoContable> implements AsientoContableBO {
}
