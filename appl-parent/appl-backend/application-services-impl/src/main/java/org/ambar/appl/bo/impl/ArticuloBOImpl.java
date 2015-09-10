/**
 * application-services-impl [16/02/2014 17:39:41]
 */
package org.ambar.appl.bo.impl;

import org.ambar.appl.be.Articulo;
import org.ambar.appl.bo.ArticuloBO;
import org.ambar.core.bo.impl.CrudBusinessObjectImpl;
import org.ambar.core.validation.configuration.Validation;
import org.ambar.core.validation.configuration.ValidationStrategy;
import org.ambar.core.validation.configuration.Validations;

/**
 * <p>
 * Implementación por default de {@link ArticuloBO}.
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
public class ArticuloBOImpl extends CrudBusinessObjectImpl<String, Articulo> implements ArticuloBO {
}
