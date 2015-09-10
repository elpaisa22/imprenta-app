/**
 * application-services-impl [2/7/2015 19:31:37]
 */
package org.ambar.appl.bo.impl;

import org.ambar.appl.be.CuentaBancaria;
import org.ambar.appl.bo.CuentaBancariaBO;
import org.ambar.core.bo.impl.CrudBusinessObjectImpl;
import org.ambar.core.validation.configuration.Validation;
import org.ambar.core.validation.configuration.ValidationStrategy;
import org.ambar.core.validation.configuration.Validations;

/**
 * <p>
 * Implementación por default de {@link CuentaBancariaBO}.
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
public class CuentaBancariaBOImpl extends CrudBusinessObjectImpl<Long, CuentaBancaria>
                                  implements CuentaBancariaBO {
}
