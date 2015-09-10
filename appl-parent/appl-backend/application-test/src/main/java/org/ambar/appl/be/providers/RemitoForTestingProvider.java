/**
 * application-test [25/08/2012 18:19:53]
 */
package org.ambar.appl.be.providers;

import java.util.Date;
import java.util.Map;

import org.ambar.appl.be.Remito;
import org.ambar.core.commons.filters.QueryPredicate;
import org.ambar.core.testing.basetests.providers.BusinessEntityForTestingProvider;
import org.ambar.core.testing.commons.ValidationPair;
import org.ambar.core.testing.commons.ValidationTouple;

/**
 * <p>
 * Provider del Remito BE.
 * </p>
 *
 * @author Sebastian
 *
 */
public class RemitoForTestingProvider extends BusinessEntityForTestingProvider<Long, Remito> {

	/* (non-JSDoc)
	 * @see org.ambar.core.testing.basetests.providers.BusinessEntityForTestingProvider#
	 * createDefaultBussinessEntity()
	 */
	@Override
	public Remito createDefaultBussinessEntity() {
		Remito remito = new Remito();
		remito.setFechaEmision(new Date());

		return remito;
	}

	/* (non-JSDoc)
	 * @see org.ambar.core.testing.basetests.providers.BusinessEntityForTestingProvider#
	 * modifyBussinessEntity(org.ambar.core.be.Persistible)
	 */
	@Override
	public Remito modifyBussinessEntity(Remito pBussinessEntity) {
		return pBussinessEntity;
	}

	/* (non-JSDoc)
	 * @see org.ambar.core.testing.basetests.providers.BusinessEntityForTestingProvider#
	 * createBussinessEntitiesForFilter()
	 */
	@Override
	public Remito[ ] createBussinessEntitiesForFilter() {
		Remito remito = this.createDefaultBussinessEntity();
		Remito remito2 = this.createDefaultBussinessEntity();

		Remito[] result = {remito, remito2};
		return result;
	}

	/* (non-JSDoc)
	 * @see org.ambar.core.testing.basetests.providers.BusinessEntityForTestingProvider#createQueryPredicate()
	 */
	@Override
	public QueryPredicate createQueryPredicate() {
		return null;
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
	public Map<String, ValidationPair<Remito>[ ]> createBussinessEntitiesForValidation() {
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
