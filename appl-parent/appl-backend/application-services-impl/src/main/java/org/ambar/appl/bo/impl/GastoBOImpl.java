/**
 * application-services-impl [01/06/2015 18:15:51]
 */
package org.ambar.appl.bo.impl;

import org.ambar.appl.be.Gasto;
import org.ambar.appl.bo.GastoBO;
import org.ambar.core.bo.impl.CrudBusinessObjectImpl;
import org.ambar.core.validation.configuration.Validation;
import org.ambar.core.validation.configuration.ValidationStrategy;
import org.ambar.core.validation.configuration.Validations;

/**
 * <p>
 * Implementación por default de {@link GastoBO}.
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
public class GastoBOImpl extends CrudBusinessObjectImpl<Long, Gasto> implements GastoBO {
}
