/**
 * application-test [25/08/2012 18:19:10]
 */
package org.ambar.appl.be.providers;

import java.util.Date;
import java.util.Map;

import org.ambar.appl.be.Factura;
import org.ambar.appl.commons.enums.CondicionVentaValues;
import org.ambar.appl.commons.enums.EstadoPagoFacturaValues;
import org.ambar.core.commons.filters.QueryPredicate;
import org.ambar.core.testing.basetests.providers.BusinessEntityForTestingProvider;
import org.ambar.core.testing.commons.ValidationPair;
import org.ambar.core.testing.commons.ValidationTouple;

/**
 * <p>
 * Provider de la Factura BE.
 * </p>
 *
 * @author Sebastian
 *
 */
public class FacturaForTestingProvider extends BusinessEntityForTestingProvider<Long, Factura> {

	/* (non-JSDoc)
	 * @see org.ambar.core.testing.basetests.providers.BusinessEntityForTestingProvider#
	 * createDefaultBussinessEntity()
	 */
	@Override
	public Factura createDefaultBussinessEntity() {

		Factura factura = new Factura();
		factura.setEstadoPago(EstadoPagoFacturaValues.PENDIENTE);
		factura.setFechaEmision(new Date());
		factura.setCondicionVenta(CondicionVentaValues.CONTADO);

		return factura;
	}

	/* (non-JSDoc)
	 * @see org.ambar.core.testing.basetests.providers.BusinessEntityForTestingProvider#
	 * modifyBussinessEntity(org.ambar.core.be.Persistible)
	 */
	@Override
	public Factura modifyBussinessEntity(Factura pBussinessEntity) {
		return pBussinessEntity;
	}

	/* (non-JSDoc)
	 * @see org.ambar.core.testing.basetests.providers.BusinessEntityForTestingProvider#
	 * createBussinessEntitiesForFilter()
	 */
	@Override
	public Factura[ ] createBussinessEntitiesForFilter() {
		Factura factura = this.createDefaultBussinessEntity();
		factura.setEstadoPago(EstadoPagoFacturaValues.PAGADA);
		Factura factura2 = this.createDefaultBussinessEntity();
		factura2.setEstadoPago(EstadoPagoFacturaValues.PAGADA);

		Factura[] result = {factura, factura2};

		return result;
	}

	/* (non-JSDoc)
	 * @see org.ambar.core.testing.basetests.providers.BusinessEntityForTestingProvider#createQueryPredicate()
	 */
	@Override
	public QueryPredicate createQueryPredicate() {
		QueryPredicate qPredicate = new QueryPredicate();
        qPredicate.appendToWhere("estadoPago = '" + EstadoPagoFacturaValues.PAGADA + "'");

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
	public Map<String, ValidationPair<Factura>[ ]> createBussinessEntitiesForValidation() {
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
