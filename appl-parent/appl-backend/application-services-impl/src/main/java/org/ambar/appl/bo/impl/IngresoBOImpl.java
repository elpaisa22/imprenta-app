/**
 * application-services-impl [9/6/2015 19:24:02]
 */
package org.ambar.appl.bo.impl;

import org.ambar.appl.be.Ingreso;
import org.ambar.appl.bo.IngresoBO;
import org.ambar.core.bo.impl.CrudBusinessObjectImpl;
import org.ambar.core.validation.configuration.Validation;
import org.ambar.core.validation.configuration.ValidationStrategy;
import org.ambar.core.validation.configuration.Validations;

/**
 * <p>
 * Implementación por default de {@link IngresoBO}.
 * </p>
 *
 * @author Sebastian
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
public class IngresoBOImpl extends CrudBusinessObjectImpl<Long, Ingreso> implements IngresoBO {
}
