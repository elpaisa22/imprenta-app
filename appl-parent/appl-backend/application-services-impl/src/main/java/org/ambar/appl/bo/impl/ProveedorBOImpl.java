/**
 * application-services-impl [23/05/2015 14:15:00]
 */
package org.ambar.appl.bo.impl;

import java.util.List;

import org.ambar.appl.be.CuentaCorrienteProveedor;
import org.ambar.appl.be.Proveedor;
import org.ambar.appl.bo.ProveedorBO;
import org.ambar.core.bo.impl.CrudBusinessObjectImpl;
import org.ambar.core.commons.context.RequestContext;
import org.ambar.core.exceptions.BusinessException;
import org.ambar.core.validation.configuration.Validation;
import org.ambar.core.validation.configuration.ValidationStrategy;
import org.ambar.core.validation.configuration.Validations;

/**
 * <p>
 * Implementación por default de {@link ProveedorBO}.
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
public class ProveedorBOImpl
       extends CrudBusinessObjectImpl<Long, Proveedor>
       implements ProveedorBO {

	@Override
	public void insert(Proveedor pProveedor, List<String> pWarnings, RequestContext pRequestContext)
	    throws BusinessException {

		if (pProveedor.getCuentaCorriente() == null) {
			CuentaCorrienteProveedor cuentaCorriente = new CuentaCorrienteProveedor();
			cuentaCorriente.setTrackInfo(pProveedor.getTrackInfo());
			pProveedor.setCuentaCorriente(cuentaCorriente);
			cuentaCorriente.setProveedor(pProveedor);
			pProveedor.getCuentaCorriente().setTrackInfo(pProveedor.getTrackInfo());
		} else if (pProveedor.getCuentaCorriente().getTrackInfo() == null) {
			pProveedor.getCuentaCorriente().setTrackInfo(pProveedor.getTrackInfo());
		}

		super.insert(pProveedor, pWarnings, pRequestContext);
	}

	@Override
	public void update(Proveedor pProveedor, List<String> pWarnings, RequestContext pRequestContext)
		   throws BusinessException {
		if (pProveedor.getCuentaCorriente() == null) {
			CuentaCorrienteProveedor cuentaCorriente = new CuentaCorrienteProveedor();
			cuentaCorriente.setTrackInfo(pProveedor.getTrackInfo());
			pProveedor.setCuentaCorriente(cuentaCorriente);
			cuentaCorriente.setProveedor(pProveedor);
			pProveedor.getCuentaCorriente().setTrackInfo(pProveedor.getTrackInfo());
		} else if (pProveedor.getCuentaCorriente().getTrackInfo() == null) {
			pProveedor.getCuentaCorriente().setTrackInfo(pProveedor.getTrackInfo());
		}

		super.update(pProveedor, pWarnings, pRequestContext);
	}
}
