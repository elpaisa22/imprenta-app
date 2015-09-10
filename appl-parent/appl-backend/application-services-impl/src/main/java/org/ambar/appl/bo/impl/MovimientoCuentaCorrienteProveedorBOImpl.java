/**
 * application-services-impl [15/6/2015 17:19:43]
 */
package org.ambar.appl.bo.impl;

import org.ambar.appl.be.MovimientoCuentaCorrienteProveedor;
import org.ambar.appl.bo.MovimientoCuentaCorrienteProveedorBO;
import org.ambar.core.bo.impl.CrudBusinessObjectImpl;
import org.ambar.core.validation.configuration.Validation;
import org.ambar.core.validation.configuration.ValidationStrategy;
import org.ambar.core.validation.configuration.Validations;

/**
 * <p>
 * Implementación por default de {@link MovimientoCuentaCorrienteProveedorBO}.
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
public class MovimientoCuentaCorrienteProveedorBOImpl
       extends CrudBusinessObjectImpl<Long, MovimientoCuentaCorrienteProveedor>
       implements MovimientoCuentaCorrienteProveedorBO {
}
