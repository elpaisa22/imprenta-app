/**
 * application-services-impl [21/05/2015 18:06:48]
 */
package org.ambar.appl.bo.impl;

import org.ambar.appl.be.Rubro;
import org.ambar.appl.bo.RubroBO;
import org.ambar.core.bo.impl.CrudBusinessObjectImpl;
import org.ambar.core.validation.configuration.Validation;
import org.ambar.core.validation.configuration.ValidationStrategy;
import org.ambar.core.validation.configuration.Validations;

/**
 * <p>
 * Implementación por default de {@link RubroBO}.
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
public class RubroBOImpl
       extends CrudBusinessObjectImpl<String, Rubro>
       implements RubroBO {
}
