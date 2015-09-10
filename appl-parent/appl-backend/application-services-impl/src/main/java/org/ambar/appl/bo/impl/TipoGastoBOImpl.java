/**
 * application-services-impl [21/05/2015 18:07:08]
 */
package org.ambar.appl.bo.impl;

import org.ambar.appl.be.TipoGasto;
import org.ambar.appl.bo.TipoGastoBO;
import org.ambar.core.bo.impl.CrudBusinessObjectImpl;
import org.ambar.core.validation.configuration.Validation;
import org.ambar.core.validation.configuration.ValidationStrategy;
import org.ambar.core.validation.configuration.Validations;

/**
 * <p>
 * Implementación por default de {@link TipoGastoBO}.
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
public class TipoGastoBOImpl
       extends CrudBusinessObjectImpl<String, TipoGasto>
       implements TipoGastoBO {
}
