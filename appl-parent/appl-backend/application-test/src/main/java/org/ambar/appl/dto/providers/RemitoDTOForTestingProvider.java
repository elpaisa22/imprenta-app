/**
 * application-test [27/08/2012 21:49:43]
 */
package org.ambar.appl.dto.providers;

import java.util.Date;

import org.ambar.appl.dto.RemitoDTO;
import org.ambar.core.be.EstadoTracking;
import org.ambar.core.commons.filters.FilteringContext;
import org.ambar.core.dto.TrackInfoDTO;
import org.ambar.core.testing.basetests.providers.DTOForTestingProvider;

/**
 * <p>
 * Provider del RemitoDTO.
 * </p>
 *
 * @author Sebastian
 *
 */
public class RemitoDTOForTestingProvider extends DTOForTestingProvider<Long, RemitoDTO> {

	/* (non-JSDoc)
	 * @see org.ambar.core.testing.basetests.providers.DTOForTestingProvider#createDefaultDTO()
	 */
	@Override
	public RemitoDTO createDefaultDTO() {
		RemitoDTO remitoDTO = new RemitoDTO();
		remitoDTO.setFechaEmision(new Date());
		remitoDTO.setRazonSocialCliente("ALGO");
		remitoDTO.setTrackInfo(new TrackInfoDTO());
		remitoDTO.getTrackInfo().setEstado(EstadoTracking.Activo.getValue());
		remitoDTO.getTrackInfo().setFechaModificacion(new Date());
		return remitoDTO;
	}

	/* (non-JSDoc)
	 * @see org.ambar.core.testing.basetests.providers.DTOForTestingProvider#createFilterContext()
	 */
	@Override
	public FilteringContext createFilterContext() {
		return null;
	}

	/* (non-JSDoc)
	 * @see org.ambar.core.testing.basetests.providers.DTOForTestingProvider#createDTOsForFilter()
	 */
	@Override
	public RemitoDTO[ ] createDTOsForFilter() {
		RemitoDTO rmDto1 = this.createDefaultDTO();
		RemitoDTO rmDto2 = this.createDefaultDTO();
		RemitoDTO rmDto3 = this.createDefaultDTO();

		RemitoDTO[ ] array = {rmDto1, rmDto2, rmDto3};

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
