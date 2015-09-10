/**
 * application-test [23/05/2012 21:31:04]
 */
package org.ambar.appl.dto.providers;

import java.math.BigDecimal;
import java.util.Date;

import org.ambar.appl.commons.enums.EstadoOrdenTrabajoValues;
import org.ambar.appl.dto.OrdenTrabajoDTO;
import org.ambar.core.be.EstadoTracking;
import org.ambar.core.commons.filters.Filter;
import org.ambar.core.commons.filters.FilteringContext;
import org.ambar.core.commons.filters.Pager;
import org.ambar.core.commons.filters.criteria.Criteria;
import org.ambar.core.commons.order.Order;
import org.ambar.core.dto.TrackInfoDTO;
import org.ambar.core.testing.basetests.providers.DTOForTestingProvider;

/**
 * <p>
 * Provider del OrdenTrabajoDTO.
 * </p>
 *
 * @author Sebastian
 *
 */
public class OrdenTrabajoDTOForTestingProvider extends DTOForTestingProvider<Long, OrdenTrabajoDTO> {

	/* (non-JSDoc)
	 * @see org.ambar.core.testing.basetests.providers.DTOForTestingProvider#createDefaultDTO()
	 */
	@Override
	public OrdenTrabajoDTO createDefaultDTO() {
		OrdenTrabajoDTO ordenTrabajoDTO = new OrdenTrabajoDTO();

		ordenTrabajoDTO.setFechaInicio(new Date());
		ordenTrabajoDTO.setFechaEntrega(new Date());
		ordenTrabajoDTO.setFechaPautada(new Date());

		ordenTrabajoDTO.setRazonSocialCliente("RAZONSOCIAL");

		ordenTrabajoDTO.setDescripcion("ORDEN TEST");
		ordenTrabajoDTO.setCantidad(Integer.MAX_VALUE);
		ordenTrabajoDTO.setEstadoOrden(EstadoOrdenTrabajoValues.EMITIDA.getValor());
		ordenTrabajoDTO.setDescripcionEstadoOrden("");
		ordenTrabajoDTO.setImporteTotal(BigDecimal.ZERO);

		ordenTrabajoDTO.setAncho(0L);
		ordenTrabajoDTO.setAlto(0L);
		ordenTrabajoDTO.setTipoMaterial("papel foto");
		ordenTrabajoDTO.setColoresFrontales(2);
		ordenTrabajoDTO.setColoresTraseros(0);

		ordenTrabajoDTO.setTrackInfo(new TrackInfoDTO());
		ordenTrabajoDTO.getTrackInfo().setEstado(EstadoTracking.Activo.getValue());
		ordenTrabajoDTO.getTrackInfo().setFechaCreacion(new Date());
		ordenTrabajoDTO.getTrackInfo().setFechaModificacion(new Date());

		return ordenTrabajoDTO;
	}

	/* (non-JSDoc)
	 * @see org.ambar.core.testing.basetests.providers.DTOForTestingProvider#createFilterContext()
	 */
	@Override
	public FilteringContext createFilterContext() {
		Filter filter = Criteria.createBinary().property("razonSocialCliente").like("Pancho");
        Pager pager = new Pager();
        pager.addOrder(new Order("id", "ASC"));
        FilteringContext filteringContext = new FilteringContext(filter, pager);
		return filteringContext;
	}

	/* (non-JSDoc)
	 * @see org.ambar.core.testing.basetests.providers.DTOForTestingProvider#createDTOsForFilter()
	 */
	@Override
	public OrdenTrabajoDTO[ ] createDTOsForFilter() {
		OrdenTrabajoDTO opDto1 = this.createDefaultDTO();
		OrdenTrabajoDTO opDto2 = this.createDefaultDTO();
		OrdenTrabajoDTO opDto3 = this.createDefaultDTO();

		OrdenTrabajoDTO[ ] array = {opDto1, opDto2, opDto3};

		return array;
	}

	/* (non-JSDoc)
	 * @see org.ambar.core.testing.basetests.providers.DTOForTestingProvider#filteredListResult()
	 */
	@Override
	public int filteredListResult() {
		return 3;
	}
}
