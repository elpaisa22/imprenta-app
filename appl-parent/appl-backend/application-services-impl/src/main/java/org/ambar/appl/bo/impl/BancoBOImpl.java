/**
 * application-services-impl [23/05/2015 14:12:15]
 */
package org.ambar.appl.bo.impl;

import org.ambar.appl.be.Banco;
import org.ambar.appl.bo.BancoBO;
import org.ambar.core.bo.impl.CrudBusinessObjectImpl;
import org.ambar.core.validation.configuration.Validation;
import org.ambar.core.validation.configuration.ValidationStrategy;
import org.ambar.core.validation.configuration.Validations;

/**
 * <p>
 * Implementación por default de {@link BancoBO}.
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
public class BancoBOImpl
       extends CrudBusinessObjectImpl<String, Banco>
       implements BancoBO {
}
