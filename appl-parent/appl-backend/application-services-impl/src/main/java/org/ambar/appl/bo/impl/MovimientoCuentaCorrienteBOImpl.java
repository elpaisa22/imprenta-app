/**
 * application-services-impl [25/08/2012 13:30:10]
 */
package org.ambar.appl.bo.impl;

import org.ambar.appl.be.MovimientoCuentaCorriente;
import org.ambar.appl.bo.MovimientoCuentaCorrienteBO;
import org.ambar.core.bo.impl.CrudBusinessObjectImpl;
import org.ambar.core.validation.configuration.Validation;
import org.ambar.core.validation.configuration.ValidationStrategy;
import org.ambar.core.validation.configuration.Validations;

/**
 * <p>
 * Implementación por default de {@link MovimientoCuentaCorrienteBO}.
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
public class MovimientoCuentaCorrienteBOImpl
       extends CrudBusinessObjectImpl<Long, MovimientoCuentaCorriente>
       implements MovimientoCuentaCorrienteBO {
}
