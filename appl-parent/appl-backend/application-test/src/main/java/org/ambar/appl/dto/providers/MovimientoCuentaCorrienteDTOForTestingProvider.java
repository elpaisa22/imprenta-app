/**
 * application-test [27/08/2012 21:49:27]
 */
package org.ambar.appl.dto.providers;

import java.math.BigDecimal;
import java.util.Date;

import org.ambar.appl.dto.MovimientoCuentaCorrienteDTO;
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
 * Provider del MovimientoDTO.
 * </p>
 *
 * @author Sebastian
 *
 */
public class MovimientoCuentaCorrienteDTOForTestingProvider
       extends DTOForTestingProvider<Long, MovimientoCuentaCorrienteDTO> {

	/* (non-JSDoc)
	 * @see org.ambar.core.testing.basetests.providers.DTOForTestingProvider#createDefaultDTO()
	 */
	@Override
	public MovimientoCuentaCorrienteDTO createDefaultDTO() {
		MovimientoCuentaCorrienteDTO movimientoDTO = new MovimientoCuentaCorrienteDTO();
		movimientoDTO.setImporteMovimiento(BigDecimal.ONE);
		movimientoDTO.setSaldo(BigDecimal.ZERO);
		movimientoDTO.setDescripcion("Una descripcion");

		movimientoDTO.setRazonSocialCliente("ALGO");
		movimientoDTO.setFecha(new Date());

		movimientoDTO.setTrackInfo(new TrackInfoDTO());
		movimientoDTO.getTrackInfo().setEstado(EstadoTracking.Activo.getValue());
		movimientoDTO.getTrackInfo().setFechaModificacion(new Date());

		return movimientoDTO;
	}

	/* (non-JSDoc)
	 * @see org.ambar.core.testing.basetests.providers.DTOForTestingProvider#createFilterContext()
	 */
	@Override
	public FilteringContext createFilterContext() {
        Filter filter = Criteria.createBinary().property("saldo").equalTo("10");
        Pager pager = new Pager();
        pager.addOrder(new Order("id", "ASC"));
        FilteringContext filteringContext = new FilteringContext(filter, pager);
		return filteringContext;
	}

	/* (non-JSDoc)
	 * @see org.ambar.core.testing.basetests.providers.DTOForTestingProvider#createDTOsForFilter()
	 */
	@Override
	public MovimientoCuentaCorrienteDTO[ ] createDTOsForFilter() {
		MovimientoCuentaCorrienteDTO pagoDto1 = this.createDefaultDTO();
		MovimientoCuentaCorrienteDTO pagoDto2 = this.createDefaultDTO();
		MovimientoCuentaCorrienteDTO pagoDto3 = this.createDefaultDTO();

		pagoDto1.setSaldo(BigDecimal.TEN);
		pagoDto2.setSaldo(BigDecimal.TEN);
		pagoDto3.setSaldo(BigDecimal.TEN);

		MovimientoCuentaCorrienteDTO[ ] array = {pagoDto1, pagoDto2, pagoDto3};

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
