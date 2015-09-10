/**
 * appl-cliente-test [17/09/2011 02:43:30]
 */
package org.ambar.appl.dto.providers;

import java.math.BigDecimal;
import java.util.Date;

import org.ambar.appl.commons.enums.TipoDocumentoValues;
import org.ambar.appl.dto.ClienteDTO;
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
 * Provider del ClienteDTO.
 * </p>
 *
 * @author Sebastian
 *
 */
public class ClienteDTOForTestingProvider extends DTOForTestingProvider<Long, ClienteDTO> {


	@Override
	public ClienteDTO createDefaultDTO() {
		ClienteDTO clienteDTO = new ClienteDTO();
		clienteDTO.setRazonSocial("Sebastian Ecclesia");
		clienteDTO.setNombreFantasia("El Seba Ecclesia");
		clienteDTO.setTipoDocumento(TipoDocumentoValues.DNI.toString());
		clienteDTO.setDescripcionTipoDocumento("DNI");
		clienteDTO.setDireccion("Charras y Corrientes");
		clienteDTO.setCiudad("Salto");
		clienteDTO.setEmail("sebastianecclesia@gmail.com");
		clienteDTO.setNumeroDocumento("30308710");
		clienteDTO.setTelefono("0221-155624355");
		clienteDTO.setIdPais("ARG");
		clienteDTO.setIdProvincia("BUE");
		clienteDTO.setCondicionIVA("RESPONSABLE_INSCRIPTO");
		clienteDTO.setDescripcionCondicionIVA("DESC");
		clienteDTO.setSaldoCuentaCorriente(BigDecimal.TEN);
		clienteDTO.setTrackInfo(new TrackInfoDTO());
		clienteDTO.getTrackInfo().setEstado(EstadoTracking.Activo.getValue());
		clienteDTO.getTrackInfo().setFechaModificacion(new Date());

		return clienteDTO;
	}

	@Override
	public FilteringContext createFilterContext() {
		Filter filter = Criteria.createBinary().property("razonSocial").like("Carlo Magno");
        Pager pager = new Pager();
        pager.addOrder(new Order("id", "ASC"));
        FilteringContext filteringContext = new FilteringContext(filter, pager);
		return filteringContext;
	}

	@Override
	public ClienteDTO[ ] createDTOsForFilter() {
		ClienteDTO clDto1 = this.createDefaultDTO();
		ClienteDTO clDto2 = this.createDefaultDTO();
		ClienteDTO clDto3 = this.createDefaultDTO();

		clDto1.setRazonSocial("Carlo Magno");
		clDto2.setRazonSocial("Carlo Magno");
		clDto3.setRazonSocial("Carlo Magno");

		ClienteDTO[ ] array = {clDto1, clDto2, clDto3};

		return array;
	}

	@Override
	public int filteredListResult() {
		return 3;
	}
}
