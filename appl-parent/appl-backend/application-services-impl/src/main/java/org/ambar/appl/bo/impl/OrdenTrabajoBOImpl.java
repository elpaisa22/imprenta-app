/**
 * application-services-impl [22/05/2012 18:01:49]
 */
package org.ambar.appl.bo.impl;

import org.ambar.appl.be.OrdenTrabajo;
import org.ambar.appl.bo.OrdenTrabajoBO;
import org.ambar.core.bo.impl.CrudBusinessObjectImpl;
import org.ambar.core.validation.configuration.Validation;
import org.ambar.core.validation.configuration.ValidationStrategy;
import org.ambar.core.validation.configuration.Validations;


/**
 * <p>
 * Implementación por default de {@link OrdenTrabajoBO}.
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
public class OrdenTrabajoBOImpl extends CrudBusinessObjectImpl<Long, OrdenTrabajo> implements OrdenTrabajoBO {
}
