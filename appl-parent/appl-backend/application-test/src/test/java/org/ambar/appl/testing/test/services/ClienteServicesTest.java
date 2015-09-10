/**
 * appl-cliente-test [17/09/2011 03:00:58]
 */
package org.ambar.appl.testing.test.services;

import org.ambar.appl.be.Cliente;
import org.ambar.appl.dto.ClienteDTO;
import org.ambar.appl.dto.providers.ClienteDTOForTestingProvider;
import org.ambar.appl.mappers.ClienteMapper;
import org.ambar.appl.services.ClienteServices;
import org.ambar.core.testing.basetests.ServicesBaseTest;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * <p>
 * Test de los servicios del Cliente.
 * </p>
 *
 * @author Sebastian
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations =
{ "classpath:ambar_core_context.xml", "classpath*:context.xml",
  "classpath:test_context.xml", "classpath*:test_persistence_context.xml" })
public class ClienteServicesTest
	extends ServicesBaseTest<Long, ClienteDTO, Long, Cliente> {

	/**
	 * Setea el provider.
	 *
	 * @param pDTOBuilder provider
	 * */
	@Autowired
	public void setBuilder(ClienteDTOForTestingProvider pDTOBuilder) {
		super.setProvider(pDTOBuilder);
	}

	/**
	 * Setea el servicio.
	 *
	 * @param pClienteServices ClienteServices
	 * */
	@Autowired
	public void setServices(ClienteServices pClienteServices) {
		super.setService(pClienteServices);
	}


	/**
	 * Setea el mapper.
	 *
	 * @param pClienteMapper ClienteMapper
	 * */
	@Autowired
	public void setMapper(ClienteMapper pClienteMapper) {
		super.setMapper(pClienteMapper);
	}




	@Override
	protected boolean insertHasErrors(ClienteDTO pDTO) {
		return pDTO.getIdCuentaCorriente() == null;
	}

	@Override
	protected boolean getByIdHasErrors(ClienteDTO pDTO) {
		return false;
	}

	@Override
	public Boolean entityAndDTOAreEquals(ClienteDTO pDTO, Cliente pEntity) {
		return ((pDTO.getTipoDocumento() == pEntity.getTipoDocumento().getValor())
				&& (pDTO.getDescripcionTipoDocumento() == pEntity.getTipoDocumento().getDescripcion()));
	}

	@Override
	protected void prepareDTO(ClienteDTO pDTO) {
	}

}
