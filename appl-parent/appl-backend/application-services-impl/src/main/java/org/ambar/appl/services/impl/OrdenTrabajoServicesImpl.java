/**
 * application-services-impl [22/05/2012 18:31:35]
 */
package org.ambar.appl.services.impl;

import org.ambar.appl.be.OrdenTrabajo;
import org.ambar.appl.dto.OrdenTrabajoDTO;
import org.ambar.appl.services.OrdenTrabajoServices;
import org.ambar.core.commons.context.RequestContext;
import org.ambar.core.commons.filters.Filter;
import org.ambar.core.commons.filters.FilteringContext;
import org.ambar.core.commons.filters.Pager;
import org.ambar.core.commons.filters.criteria.Criteria;
import org.ambar.core.commons.order.Order;
import org.ambar.core.dto.results.ResultListDTO;
import org.ambar.core.services.impl.CrudServiceDefaultImpl;

/**
 * <p>
 * Implementación por default de {@link OrdenTrabajoServices}.
 * </p>
 *
 * @author Sebastian
 *
 */
public class OrdenTrabajoServicesImpl
    extends CrudServiceDefaultImpl<Long, OrdenTrabajoDTO, Long, OrdenTrabajo>
	implements OrdenTrabajoServices {

	private static final long serialVersionUID = -1692235000368979854L;

	/* (non-JSDoc)
	 * @see org.ambar.appl.services.OrdenTrabajoServices#
	 * getOrdenesForIdCliente(java.lang.Long, org.ambar.core.commons.context.RequestContext)
	 */
	@Override
	public ResultListDTO<OrdenTrabajoDTO> getOrdenesForIdCliente(Long pIdCliente, RequestContext pRequestContext) {
		Filter filter1 = Criteria.createBinary().property("idCliente").equalTo(pIdCliente);
		Filter filter2 = Criteria.createUnary().property("idFactura").isNull();

		Filter filter = Criteria.createGroup().and(filter1, filter2);

		Pager pager = new Pager();
        pager.addOrder(new Order("id", "ASC"));
        FilteringContext filteringContext = new FilteringContext(filter, pager);

		return super.getFilteredList(filteringContext, pRequestContext);
	}
}
