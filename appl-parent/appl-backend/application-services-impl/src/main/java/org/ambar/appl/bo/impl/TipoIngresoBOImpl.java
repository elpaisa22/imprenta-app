/**
 * application-services-impl [9/6/2015 19:24:26]
 */
package org.ambar.appl.bo.impl;

import org.ambar.appl.be.TipoIngreso;
import org.ambar.appl.bo.TipoIngresoBO;
import org.ambar.core.bo.impl.CrudBusinessObjectImpl;
import org.ambar.core.validation.configuration.Validation;
import org.ambar.core.validation.configuration.ValidationStrategy;
import org.ambar.core.validation.configuration.Validations;

/**
 * <p>
 * Implementación por default de {@link TipoIngresoBO}.
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
public class TipoIngresoBOImpl extends CrudBusinessObjectImpl<String, TipoIngreso> implements TipoIngresoBO {
}
