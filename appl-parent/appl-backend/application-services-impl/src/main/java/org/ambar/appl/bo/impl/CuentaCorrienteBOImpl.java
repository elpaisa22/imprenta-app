/**
 * application-services-impl [03/06/2014 21:45:19]
 */
package org.ambar.appl.bo.impl;

import org.ambar.appl.be.CuentaCorriente;
import org.ambar.appl.bo.CuentaCorrienteBO;
import org.ambar.core.bo.impl.CrudBusinessObjectImpl;
import org.ambar.core.validation.configuration.Validation;
import org.ambar.core.validation.configuration.ValidationStrategy;
import org.ambar.core.validation.configuration.Validations;

/**
 * <p>
 * Implementación por default de {@link CuentaCorrienteBO}.
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
public class CuentaCorrienteBOImpl extends CrudBusinessObjectImpl<Long, CuentaCorriente> implements CuentaCorrienteBO {
}
