/**
 * application-test [23/05/2012 21:30:46]
 */
package org.ambar.appl.be.providers;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

import org.ambar.appl.be.Cliente;
import org.ambar.appl.be.OrdenTrabajo;
import org.ambar.appl.commons.enums.EstadoOrdenTrabajoValues;
import org.ambar.core.be.EstadoTracking;
import org.ambar.core.be.TrackInfo;
import org.ambar.core.commons.filters.QueryPredicate;
import org.ambar.core.testing.basetests.providers.BusinessEntityForTestingProvider;
import org.ambar.core.testing.commons.ValidationPair;
import org.ambar.core.testing.commons.ValidationTouple;

/**
 * <p>
 * Provider de la OrdenTrabajo BE.
 * </p>
 *
 * @author Sebastian
 *
 */
public class OrdenTrabajoForTestingProvider extends BusinessEntityForTestingProvider<Long, OrdenTrabajo> {

	/* (non-JSDoc)
	 * @see org.ambar.core.testing.basetests.providers.BusinessEntityForTestingProvider#
	 * createDefaultBussinessEntity()
	 */
	@Override
	public OrdenTrabajo createDefaultBussinessEntity() {
		OrdenTrabajo ordenTrabajo = new OrdenTrabajo();
		ordenTrabajo.setFechaInicio(new Date());
		ordenTrabajo.setFechaEntrega(new Date());
		ordenTrabajo.setFechaPautada(new Date());

		ordenTrabajo.setCliente(new Cliente());

		ordenTrabajo.setDescripcion("ORDEN TEST");
		ordenTrabajo.setCantidad(Integer.MAX_VALUE);
		ordenTrabajo.setEstadoOrden(EstadoOrdenTrabajoValues.EMITIDA);
		ordenTrabajo.setImporteTotal(BigDecimal.TEN);

		ordenTrabajo.setTrackInfo(new TrackInfo());
		ordenTrabajo.getTrackInfo().setUsuario("USERTEST");
		ordenTrabajo.getTrackInfo().setEstado(EstadoTracking.Activo);
		ordenTrabajo.getTrackInfo().setFechaCreacion(new Date());
		ordenTrabajo.getTrackInfo().setFechaModificacion(new Date());

		return ordenTrabajo;
	}

	/* (non-JSDoc)
	 * @see org.ambar.core.testing.basetests.providers.BusinessEntityForTestingProvider#
	 * modifyBussinessEntity(org.ambar.core.be.Persistible)
	 */
	@Override
	public OrdenTrabajo modifyBussinessEntity(OrdenTrabajo pBussinessEntity) {
		return pBussinessEntity;
	}

	/* (non-JSDoc)
	 * @see org.ambar.core.testing.basetests.providers.BusinessEntityForTestingProvider#
	 * createBussinessEntitiesForFilter()
	 */
	@Override
	public OrdenTrabajo[ ] createBussinessEntitiesForFilter() {
		OrdenTrabajo ordenTrabajo = this.createDefaultBussinessEntity();

		OrdenTrabajo[] result = {ordenTrabajo};

		return result;
	}

	/* (non-JSDoc)
	 * @see org.ambar.core.testing.basetests.providers.BusinessEntityForTestingProvider#createQueryPredicate()
	 */
	@Override
	public QueryPredicate createQueryPredicate() {
		QueryPredicate qPredicate = new QueryPredicate();
        qPredicate.appendToWhere("cliente.razonSocial = 'Pancho'");

		return qPredicate;
	}

	/* (non-JSDoc)
	 * @see org.ambar.core.testing.basetests.providers.BusinessEntityForTestingProvider#filteredListResult()
	 */
	@Override
	public int filteredListResult() {
		return 1;
	}

	/* (non-JSDoc)
	 * @see org.ambar.core.testing.basetests.providers.BusinessEntityForTestingProvider#
	 * createBussinessEntitiesForValidation()
	 */
	@Override
	public Map<String, ValidationPair<OrdenTrabajo>[ ]> createBussinessEntitiesForValidation() {
		return null;
	}

	/* (non-JSDoc)
	 * @see org.ambar.core.testing.basetests.providers.BusinessEntityForTestingProvider#
	 * createBussinessEntitiesForValidationByValidator()
	 */
	@Override
	public ValidationTouple[ ] createBussinessEntitiesForValidationByValidator() {
		String[] perfiles = {};
		ValidationTouple[] result = new ValidationTouple[2];
		result[0] = new ValidationTouple("applicationHibernateValidators", perfiles,
			this.createDefaultBussinessEntity(), false);

		OrdenTrabajo ordenTrabajoBad = this.createDefaultBussinessEntity();
		ordenTrabajoBad.setCliente(null);
		result[1] = new ValidationTouple("applicationHibernateValidators", perfiles,
				ordenTrabajoBad, true);
		return result;
	}
}
