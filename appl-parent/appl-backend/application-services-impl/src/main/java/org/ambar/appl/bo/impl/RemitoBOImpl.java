/**
 * application-services-impl [25/08/2012 13:30:00]
 */
package org.ambar.appl.bo.impl;

import org.ambar.appl.be.Remito;
import org.ambar.appl.bo.RemitoBO;
import org.ambar.core.bo.impl.CrudBusinessObjectImpl;
import org.ambar.core.validation.configuration.Validation;
import org.ambar.core.validation.configuration.ValidationStrategy;
import org.ambar.core.validation.configuration.Validations;

/**
 * <p>
 * Implementación por default de {@link RemitoBO}.
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
public class RemitoBOImpl extends CrudBusinessObjectImpl<Long, Remito> implements RemitoBO {
}
