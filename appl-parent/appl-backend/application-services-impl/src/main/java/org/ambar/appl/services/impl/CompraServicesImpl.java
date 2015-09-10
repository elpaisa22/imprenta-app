/**
 * application-services-impl [01/06/2015 18:30:01]
 */
package org.ambar.appl.services.impl;

import org.ambar.appl.be.Compra;
import org.ambar.appl.dto.CompraDTO;
import org.ambar.appl.services.CompraServices;
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
 * Implementación por default de {@link CompraServices}.
 * </p>
 *
 * @author Sebastian
 *
 */
public class CompraServicesImpl
       extends CrudServiceDefaultImpl<Long, CompraDTO, Long, Compra>
       implements CompraServices {

	private static final long serialVersionUID = 3666606577593736496L;

	@Override
	public ResultListDTO<CompraDTO> getComprasPendientesPorProveedor(Long pIdProveedor,
			                                                         RequestContext pRequestContext) {

		BinaryFilter filterProveedor = Criteria.createBinary().property("idProveedor").equalTo(pIdProveedor);

		BinaryFilter filterPendiente1 = Criteria.createBinary().property("estadoPago").equalTo("PENDIENTE");
		BinaryFilter filterPendiente2 = Criteria.createBinary().property("estadoPago").equalTo("PARCIAL");
		GroupFilter filterPendiente = Criteria.createGroup().or(filterPendiente1, filterPendiente2);

		Filter filter = Criteria.createGroup().and(filterProveedor, filterPendiente);

		FilteringContext filteringContext = new FilteringContext();
		filteringContext.setFilter(filter);

		return super.getFilteredList(filteringContext, pRequestContext);
	}
}
