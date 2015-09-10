/**
 * application-test [17/02/2014 17:23:36]
 */
package org.ambar.appl.be.providers;

import java.math.BigDecimal;
import java.util.Map;

import org.ambar.appl.be.Articulo;
import org.ambar.core.commons.filters.QueryPredicate;
import org.ambar.core.testing.basetests.providers.BusinessEntityForTestingProvider;
import org.ambar.core.testing.commons.ValidationPair;
import org.ambar.core.testing.commons.ValidationTouple;

/**
 * <p>
 * Provider del Articulo BE.
 * </p>
 *
 * @author Sebastian
 *
 */
public class ArticuloForTestingProvider extends BusinessEntityForTestingProvider<String, Articulo> {



	@Override
	public Articulo createDefaultBussinessEntity() {
		Articulo articulo = new Articulo();

		articulo.setId("32233323");

		articulo.setDescripcion("Articulo de prueba");
		articulo.setCosto(BigDecimal.TEN);
		articulo.setPorcGanancia(BigDecimal.ONE);
		articulo.setPorcIva(new BigDecimal("21"));
		articulo.setStock(20);
		articulo.setStockMinimo(10);
		articulo.setCostoEnDolares(false);

		return articulo;
	}

	@Override
	public Articulo modifyBussinessEntity(Articulo pBussinessEntity) {
		return pBussinessEntity;
	}

	@Override
	public Articulo[ ] createBussinessEntitiesForFilter() {
		Articulo articulo = this.createDefaultBussinessEntity();
		articulo.setCosto(new BigDecimal("299.99"));

		Articulo[] articulos = {articulo};

		return articulos;
	}

	@Override
	public QueryPredicate createQueryPredicate() {
		QueryPredicate qPredicate = new QueryPredicate();
        qPredicate.appendToWhere("costo = 299.99");

		return qPredicate;
	}

	@Override
	public int filteredListResult() {
		return 1;
	}

	@Override
	public Map<String, ValidationPair<Articulo>[ ]> createBussinessEntitiesForValidation() {
		return null;
	}

	@Override
	public ValidationTouple[ ] createBussinessEntitiesForValidationByValidator() {
		return null;
	}
}
