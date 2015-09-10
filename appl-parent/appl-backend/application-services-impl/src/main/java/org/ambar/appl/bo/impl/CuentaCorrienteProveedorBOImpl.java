/**
 * application-services-impl [15/6/2015 17:20:06]
 */
package org.ambar.appl.bo.impl;

import org.ambar.appl.be.CuentaCorrienteProveedor;
import org.ambar.appl.bo.CuentaCorrienteProveedorBO;
import org.ambar.core.bo.impl.CrudBusinessObjectImpl;
import org.ambar.core.validation.configuration.Validation;
import org.ambar.core.validation.configuration.ValidationStrategy;
import org.ambar.core.validation.configuration.Validations;

/**
 * <p>
 * Implementación por default de {@link CuentaCorrienteProveedorBO}.
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
public class CuentaCorrienteProveedorBOImpl extends CrudBusinessObjectImpl<Long, CuentaCorrienteProveedor>
                                            implements CuentaCorrienteProveedorBO {
}
