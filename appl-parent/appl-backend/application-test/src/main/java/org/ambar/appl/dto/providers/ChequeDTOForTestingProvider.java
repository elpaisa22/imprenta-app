/**
 * application-test [02/03/2013 15:09:41]
 */
package org.ambar.appl.dto.providers;

import java.math.BigDecimal;
import java.util.Date;

import org.ambar.appl.dto.ChequeDTO;
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
 * Provider del ChequeDTO.
 * </p>
 *
 * @author Sebastian
 *
 */
public class ChequeDTOForTestingProvider extends DTOForTestingProvider<Long, ChequeDTO> {

	@Override
	public ChequeDTO createDefaultDTO() {
		ChequeDTO chequeDTO = new ChequeDTO();

		chequeDTO.setId(Long.valueOf("32233323"));
		chequeDTO.setMonto(BigDecimal.ZERO);
		chequeDTO.setFecha(new Date());
		chequeDTO.setIdBanco("SANTANDER");
		chequeDTO.setCuenta("ARCOR SRL");
		chequeDTO.setSucursal("SALTO");
		chequeDTO.setRazonSocialCliente("CARLITOS");
		chequeDTO.setEmisor("CARLITOS");
		chequeDTO.setCuit("321546546");
		chequeDTO.setFechaVencimiento(new Date());

		chequeDTO.setTrackInfo(new TrackInfoDTO());
		chequeDTO.getTrackInfo().setEstado(EstadoTracking.Activo.getValue());
		chequeDTO.getTrackInfo().setFechaModificacion(new Date());
		return chequeDTO;
	}

	@Override
	public FilteringContext createFilterContext() {
		Filter filter = Criteria.createBinary().property("monto").equalTo(new BigDecimal("499.99"));
        Pager pager = new Pager();
        pager.addOrder(new Order("id", "ASC"));
        FilteringContext filteringContext = new FilteringContext(filter, pager);
		return filteringContext;
	}

	@Override
	public ChequeDTO[ ] createDTOsForFilter() {
		ChequeDTO chDto = this.createDefaultDTO();
		chDto.setId(Long.valueOf("32311221"));

		chDto.setMonto(new BigDecimal("499.99"));

		ChequeDTO[ ] array = {chDto};

		return array;
	}

	@Override
	public int filteredListResult() {
		return 1;
	}
}
