/**
 * application-test [17/02/2014 17:30:02]
 */
package org.ambar.appl.dto.providers;

import java.math.BigDecimal;
import java.util.Date;

import org.ambar.appl.dto.ArticuloDTO;
import org.ambar.core.be.EstadoTracking;
import org.ambar.core.commons.filters.Filter;
import org.ambar.core.commons.filters.FilteringContext;
import org.ambar.core.commons.filters.Pager;
import org.ambar.core.commons.filters.criteria.Criteria;
import org.ambar.core.commons.order.Order;
import org.ambar.core.dto.TrackInfoDTO;
import org.ambar.core.testing.basetests.providers.DTOForTestingProvider;

/**
 * <p>Insertar descripción funcional.</p>
 * @author Sebastian
 * @see <<Insertar clases relacionadas>>
 */
public class ArticuloDTOForTestingProvider extends DTOForTestingProvider<String, ArticuloDTO> {

	@Override
	public ArticuloDTO createDefaultDTO() {
		ArticuloDTO articuloDTO = new ArticuloDTO();

		articuloDTO.setId("32233323");

		articuloDTO.setDescripcion("Articulo de prueba");
		articuloDTO.setIdMarca("COLOMBRARO");
		articuloDTO.setDescripcionMarca("DESC COLOMBRARO");
		articuloDTO.setCosto(BigDecimal.TEN);
		articuloDTO.setPorcGanancia(BigDecimal.ONE);
		articuloDTO.setPorcIva(new BigDecimal("21"));
		articuloDTO.setIdRubro("HOGAR");
		articuloDTO.setDescripcionRubro("DESC HOGAR");
		articuloDTO.setStock(20);
		articuloDTO.setStockMinimo(10);
		articuloDTO.setCostoEnDolares(false);
		articuloDTO.setPrecioNeto(BigDecimal.TEN);
		articuloDTO.setPrecioBruto(BigDecimal.TEN);

		articuloDTO.setTrackInfo(new TrackInfoDTO());
		articuloDTO.getTrackInfo().setEstado(EstadoTracking.Activo.getValue());
		articuloDTO.getTrackInfo().setFechaModificacion(new Date());
		return articuloDTO;
	}

	@Override
	public FilteringContext createFilterContext() {
		Filter filter = Criteria.createBinary().property("costo").equalTo(new BigDecimal("499.99"));
        Pager pager = new Pager();
        pager.addOrder(new Order("id", "ASC"));
        FilteringContext filteringContext = new FilteringContext(filter, pager);
		return filteringContext;
	}

	@Override
	public ArticuloDTO[ ] createDTOsForFilter() {
		ArticuloDTO artDTO = this.createDefaultDTO();
		artDTO.setId("32311221");

		artDTO.setCosto(new BigDecimal("499.99"));

		ArticuloDTO[ ] array = {artDTO};

		return array;
	}

	@Override
	public int filteredListResult() {
		return 1;
	}
}
