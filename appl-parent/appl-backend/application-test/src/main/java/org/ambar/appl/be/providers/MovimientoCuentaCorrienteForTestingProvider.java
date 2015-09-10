/**
 * application-test [25/08/2012 18:19:31]
 */
package org.ambar.appl.be.providers;

import java.math.BigDecimal;
import java.util.Map;

import org.ambar.appl.be.MovimientoCuentaCorriente;
import org.ambar.appl.dto.providers.ClienteDTOForTestingProvider;
import org.ambar.core.commons.filters.QueryPredicate;
import org.ambar.core.testing.basetests.providers.BusinessEntityForTestingProvider;
import org.ambar.core.testing.commons.ValidationPair;
import org.ambar.core.testing.commons.ValidationTouple;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>
 * Provider del Movimiento BE.
 * </p>
 *
 * @author Sebastian
 *
 */
public class MovimientoCuentaCorrienteForTestingProvider
       extends BusinessEntityForTestingProvider<Long, MovimientoCuentaCorriente> {

	@Autowired
	private ClienteDTOForTestingProvider clienteDTOForTestingProvider;


	/* (non-JSDoc)
	 * @see org.ambar.core.testing.basetests.providers.BusinessEntityForTestingProvider#
	 * createDefaultBussinessEntity()
	 */
	/**
	 * @return Retorna el valor del atributo clienteDTOForTestingProvider.
	 */
	public ClienteDTOForTestingProvider getCuentaCorrienteProvider() {
		return clienteDTOForTestingProvider;
	}

	/**
	 * @param pCuentaCorrienteProvider Establece el valor del atributo clienteDTOForTestingProvider.
	 */
	public void setCuentaCorrienteProvider(ClienteDTOForTestingProvider pCuentaCorrienteProvider) {
		clienteDTOForTestingProvider = pCuentaCorrienteProvider;
	}

	@Override
	public MovimientoCuentaCorriente createDefaultBussinessEntity() {
		MovimientoCuentaCorriente movimiento = new MovimientoCuentaCorriente();

		return movimiento;
	}

	/* (non-JSDoc)
	 * @see org.ambar.core.testing.basetests.providers.BusinessEntityForTestingProvider#
	 * modifyBussinessEntity(org.ambar.core.be.Persistible)
	 */
	@Override
	public MovimientoCuentaCorriente modifyBussinessEntity(MovimientoCuentaCorriente pBussinessEntity) {
		return pBussinessEntity;
	}

	/* (non-JSDoc)
	 * @see org.ambar.core.testing.basetests.providers.BusinessEntityForTestingProvider#
	 * createBussinessEntitiesForFilter()
	 */
	@Override
	public MovimientoCuentaCorriente[ ] createBussinessEntitiesForFilter() {
		MovimientoCuentaCorriente movimiento = this.createDefaultBussinessEntity();
		movimiento.setSaldo(BigDecimal.TEN);
		MovimientoCuentaCorriente movimiento2 = this.createDefaultBussinessEntity();
		movimiento2.setSaldo(BigDecimal.TEN);

		MovimientoCuentaCorriente[] result = {movimiento, movimiento2};

		return result;
	}

	/* (non-JSDoc)
	 * @see org.ambar.core.testing.basetests.providers.BusinessEntityForTestingProvider#createQueryPredicate()
	 */
	@Override
	public QueryPredicate createQueryPredicate() {
		QueryPredicate qPredicate = new QueryPredicate();
        qPredicate.appendToWhere("saldo = " + BigDecimal.TEN);

		return qPredicate;
	}

	/* (non-JSDoc)
	 * @see org.ambar.core.testing.basetests.providers.BusinessEntityForTestingProvider#filteredListResult()
	 */
	@Override
	public int filteredListResult() {
		return 2;
	}

	/* (non-JSDoc)
	 * @see org.ambar.core.testing.basetests.providers.BusinessEntityForTestingProvider#
	 * createBussinessEntitiesForValidation()
	 */
	@Override
	public Map<String, ValidationPair<MovimientoCuentaCorriente>[ ]> createBussinessEntitiesForValidation() {
		return null;
	}

	/* (non-JSDoc)
	 * @see org.ambar.core.testing.basetests.providers.BusinessEntityForTestingProvider#
	 * createBussinessEntitiesForValidationByValidator()
	 */
	@Override
	public ValidationTouple[ ] createBussinessEntitiesForValidationByValidator() {
		return null;
	}
}
