/**
 * appl-cliente-test [17/09/2011 02:36:38]
 */
package org.ambar.appl.be.providers;

import java.util.Date;
import java.util.Map;

import org.ambar.appl.be.Cliente;
import org.ambar.appl.commons.enums.TipoDocumentoValues;
import org.ambar.core.be.EstadoTracking;
import org.ambar.core.be.TrackInfo;
import org.ambar.core.commons.filters.QueryPredicate;
import org.ambar.core.testing.basetests.providers.BusinessEntityForTestingProvider;
import org.ambar.core.testing.commons.ValidationPair;
import org.ambar.core.testing.commons.ValidationTouple;
/**
 * <p>
 * Provider del Cliente BE.
 * </p>
 *
 * @author Sebastian
 *
 */
public class ClienteForTestingProvider extends BusinessEntityForTestingProvider<Long, Cliente> {

	@Override
	public Cliente createDefaultBussinessEntity() {
		Cliente cliente = new Cliente();
		cliente.setRazonSocial("Sebastian Ecclesia");
		cliente.setTipoDocumento(TipoDocumentoValues.DNI);
		cliente.setDireccion("Charras y Corrientes");
		cliente.setCiudad("La Plata");
		cliente.setEmail("sebastianecclesia@gmail.com");
		cliente.setNumeroDocumento("30308710");
		cliente.setTelefono("0221-155624355");
		cliente.setTrackInfo(new TrackInfo());
		cliente.getTrackInfo().setEstado(EstadoTracking.Activo);
		cliente.getTrackInfo().setUsuario("USER_TEST");
		cliente.getTrackInfo().setFechaCreacion(new Date());
		cliente.getTrackInfo().setFechaModificacion(new Date());
		return cliente;
	}

	@Override
	public Cliente modifyBussinessEntity(Cliente pBussinessEntity) {
		return pBussinessEntity;
	}

	@Override
	public Cliente[ ] createBussinessEntitiesForFilter() {
		Cliente cliente = this.createDefaultBussinessEntity();
		cliente.setRazonSocial("Marco Polo");

		Cliente[] clientes = {cliente};

		return clientes;
	}


	@Override
	public int filteredListResult() {
		return 1;
	}


	@Override
	public Map<String, ValidationPair<Cliente>[ ]> createBussinessEntitiesForValidation() {
		return null;
	}

	@Override
	public ValidationTouple[ ] createBussinessEntitiesForValidationByValidator() {
		String[] perfiles = {};
		ValidationTouple[] result = new ValidationTouple[2];
		result[0] = new ValidationTouple("applicationHibernateValidators", perfiles,
			this.createDefaultBussinessEntity(), false);

		Cliente clienteBad = this.createDefaultBussinessEntity();
		clienteBad.setRazonSocial("asdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdadsasdasdasdasdasdasd");
		clienteBad.setNumeroDocumento(null);
		result[1] = new ValidationTouple("applicationHibernateValidators", perfiles,
				clienteBad, true);
		return result;
	}

	@Override
	public QueryPredicate createQueryPredicate() {
        QueryPredicate qPredicate = new QueryPredicate();
        qPredicate.appendToWhere("razonSocial = 'Marco Polo'");

		return qPredicate;
	}


}
