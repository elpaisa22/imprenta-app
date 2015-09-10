/**
 * application-test [27/08/2012 21:48:56]
 */
package org.ambar.appl.dto.providers;

import java.math.BigDecimal;
import java.util.Date;

import org.ambar.appl.commons.enums.CondicionVentaValues;
import org.ambar.appl.commons.enums.EstadoPagoFacturaValues;
import org.ambar.appl.dto.FacturaDTO;
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
 * Provider del FacturaDTO.
 * </p>
 *
 * @author Sebastian
 *
 */
public class FacturaDTOForTestingProvider extends DTOForTestingProvider<Long, FacturaDTO> {

	/* (non-JSDoc)
	 * @see org.ambar.core.testing.basetests.providers.DTOForTestingProvider#createDefaultDTO()
	 */
	@Override
	public FacturaDTO createDefaultDTO() {
		FacturaDTO facturaDTO = new FacturaDTO();
		facturaDTO.setEstadoPago(EstadoPagoFacturaValues.PENDIENTE.getValor());
		facturaDTO.setFechaEmision(new Date());
		facturaDTO.setCondicionVenta(CondicionVentaValues.CONTADO.getValor());
		facturaDTO.setRazonSocialCliente("ALALA");
		facturaDTO.setDescripcionEstadoPago("ALGO");
		facturaDTO.setDescripcionCondicionVenta("ALGO");
		facturaDTO.setImporteTotal(BigDecimal.TEN);
		facturaDTO.setTipoDocumentoCliente("ALGO");
		facturaDTO.setNumeroDocumentoCliente("23423");
		facturaDTO.setDireccionCliente("Aasdad");
		facturaDTO.setSaldo(BigDecimal.ZERO);

		facturaDTO.setTrackInfo(new TrackInfoDTO());
		facturaDTO.getTrackInfo().setUsuario("AMBAR_TEST");
		facturaDTO.getTrackInfo().setEstado(EstadoTracking.Activo.getValue());
		facturaDTO.getTrackInfo().setFechaModificacion(new Date());
		facturaDTO.getTrackInfo().setFechaCreacion(new Date());


		return facturaDTO;
	}

	/* (non-JSDoc)
	 * @see org.ambar.core.testing.basetests.providers.DTOForTestingProvider#createFilterContext()
	 */
	@Override
	public FilteringContext createFilterContext() {
		Filter filter = Criteria.createBinary().property("estadoPagoPersistent").like("PAGADA");
        Pager pager = new Pager();
        pager.addOrder(new Order("id", "ASC"));
        FilteringContext filteringContext = new FilteringContext(filter, pager);
		return filteringContext;
	}

	/* (non-JSDoc)
	 * @see org.ambar.core.testing.basetests.providers.DTOForTestingProvider#createDTOsForFilter()
	 */
	@Override
	public FacturaDTO[ ] createDTOsForFilter() {
		FacturaDTO facDto1 = this.createDefaultDTO();
		FacturaDTO facDto2 = this.createDefaultDTO();
		FacturaDTO facDto3 = this.createDefaultDTO();

		facDto1.setEstadoPago(EstadoPagoFacturaValues.PAGADA.getValor());
		facDto2.setEstadoPago(EstadoPagoFacturaValues.PAGADA.getValor());
		facDto3.setEstadoPago(EstadoPagoFacturaValues.PAGADA.getValor());

		FacturaDTO[ ] array = {facDto1, facDto2, facDto3};

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
