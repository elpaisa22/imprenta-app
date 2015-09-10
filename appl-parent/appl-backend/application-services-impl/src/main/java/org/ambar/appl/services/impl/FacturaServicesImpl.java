/**
 * application-services-impl [25/08/2012 17:17:34]
 */
package org.ambar.appl.services.impl;

import org.ambar.appl.be.Factura;
import org.ambar.appl.dto.FacturaDTO;
import org.ambar.appl.services.FacturaServices;
import org.ambar.core.commons.context.RequestContext;
import org.ambar.core.commons.filters.BinaryFilter;
import org.ambar.core.commons.filters.Filter;
import org.ambar.core.commons.filters.FilteringContext;
import org.ambar.core.commons.filters.GroupFilter;
import org.ambar.core.commons.filters.criteria.Criteria;
import org.ambar.core.dto.results.ResultListDTO;
import org.ambar.core.services.impl.CrudServiceDefaultImpl;

/**
 * <p>
 * Implementación por default de {@link FacturaServices}.
 * </p>
 *
 * @author Sebastian
 *
 */
public class FacturaServicesImpl
	extends CrudServiceDefaultImpl<Long, FacturaDTO, Long, Factura>
	implements FacturaServices {

	private static final long serialVersionUID = -5301096381923536177L;

	@Override
	public ResultListDTO<FacturaDTO> getFacturasPendientesPorCliente(Long pIdCliente,
			                                                         RequestContext pRequestContext) {

		BinaryFilter filterCliente = Criteria.createBinary().property("idCliente").equalTo(pIdCliente);

		BinaryFilter filterPendiente1 = Criteria.createBinary().property("estadoPago").equalTo("PENDIENTE");
		BinaryFilter filterPendiente2 = Criteria.createBinary().property("estadoPago").equalTo("PARCIAL");
		GroupFilter filterPendiente = Criteria.createGroup().or(filterPendiente1, filterPendiente2);

		Filter filter = Criteria.createGroup().and(filterCliente, filterPendiente);

		FilteringContext filteringContext = new FilteringContext();
		filteringContext.setFilter(filter);

		return super.getFilteredList(filteringContext, pRequestContext);
	}

}
