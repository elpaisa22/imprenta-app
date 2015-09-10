/**
 * appl-cliente-services-impl [22/08/2011 22:23:25]
 */
package org.ambar.appl.bo.impl;

import java.util.List;

import org.ambar.appl.be.Cliente;
import org.ambar.appl.be.CuentaCorriente;
import org.ambar.appl.bo.ClienteBO;
import org.ambar.core.bo.impl.CrudBusinessObjectImpl;
import org.ambar.core.commons.context.RequestContext;
import org.ambar.core.exceptions.BusinessException;
import org.ambar.core.validation.configuration.Validation;
import org.ambar.core.validation.configuration.ValidationStrategy;
import org.ambar.core.validation.configuration.Validations;

/**
 * <p>
 * Implementación por default de {@link ClienteBO}.
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
public class ClienteBOImpl extends CrudBusinessObjectImpl<Long, Cliente> implements ClienteBO {

	@Override
	public void insert(Cliente pCliente, List<String> pWarnings, RequestContext pRequestContext)
	    throws BusinessException {

		if (pCliente.getCuentaCorriente() == null) {
			CuentaCorriente cuentaCorriente = new CuentaCorriente();
			cuentaCorriente.setTrackInfo(pCliente.getTrackInfo());
			pCliente.setCuentaCorriente(cuentaCorriente);
			cuentaCorriente.setCliente(pCliente);
			pCliente.getCuentaCorriente().setTrackInfo(pCliente.getTrackInfo());
		} else if (pCliente.getCuentaCorriente().getTrackInfo() == null) {
			pCliente.getCuentaCorriente().setTrackInfo(pCliente.getTrackInfo());
		}

		super.insert(pCliente, pWarnings, pRequestContext);
	}

	@Override
	public void update(Cliente pCliente, List<String> pWarnings, RequestContext pRequestContext)
		   throws BusinessException {
		if (pCliente.getCuentaCorriente() == null) {
			CuentaCorriente cuentaCorriente = new CuentaCorriente();
			cuentaCorriente.setTrackInfo(pCliente.getTrackInfo());
			pCliente.setCuentaCorriente(cuentaCorriente);
			cuentaCorriente.setCliente(pCliente);
			pCliente.getCuentaCorriente().setTrackInfo(pCliente.getTrackInfo());
		} else if (pCliente.getCuentaCorriente().getTrackInfo() == null) {
			pCliente.getCuentaCorriente().setTrackInfo(pCliente.getTrackInfo());
		}

		super.update(pCliente, pWarnings, pRequestContext);
	}
}
