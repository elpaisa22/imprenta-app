/**
 * application-test [23/05/2012 18:42:52]
 */
package org.ambar.appl.testing.test.services;

import java.util.Locale;

import javax.annotation.Resource;

import org.ambar.appl.be.OrdenTrabajo;
import org.ambar.appl.dto.ClienteDTO;
import org.ambar.appl.dto.OrdenTrabajoDTO;
import org.ambar.appl.dto.providers.ClienteDTOForTestingProvider;
import org.ambar.appl.dto.providers.OrdenTrabajoDTOForTestingProvider;
import org.ambar.appl.mappers.OrdenTrabajoMapper;
import org.ambar.appl.services.ClienteServices;
import org.ambar.appl.services.OrdenTrabajoServices;
import org.ambar.core.commons.context.RequestContext;
import org.ambar.core.testing.basetests.ServicesBaseTest;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * <p>
 * Test de los servicios de la OrdenTrabajo.
 * </p>
 *
 * @author Sebastian
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations =
{ "classpath:ambar_core_context.xml", "classpath*:context.xml",
  "classpath:test_context.xml", "classpath*:test_persistence_context.xml" })
public class OrdenTrabajoServicesTest
	extends ServicesBaseTest<Long, OrdenTrabajoDTO, Long, OrdenTrabajo> {

	@Resource(name = "clienteDTOForTestingProvider")
	private ClienteDTOForTestingProvider clienteDTOForTestingProvider;

	@Resource(name = "clienteServices")
	private ClienteServices clienteServices;

	/**
	 * Setea el provider.
	 *
	 * @param pDTOBuilder provider
	 * */
	@Autowired
	public void setBuilder(OrdenTrabajoDTOForTestingProvider pDTOBuilder) {
		super.setProvider(pDTOBuilder);
	}

	/**
	 * Setea el servicio.
	 *
	 * @param pOrdenTrabajoServices OrdenTrabajoServices
	 * */
	@Autowired
	public void setServices(OrdenTrabajoServices pOrdenTrabajoServices) {
		super.setService(pOrdenTrabajoServices);
	}


	/**
	 * Setea el mapper.
	 *
	 * @param pOrdenTrabajoMapper OrdenTrabajoMapper
	 * */
	@Autowired
	public void setServices(OrdenTrabajoMapper pOrdenTrabajoMapper) {
		super.setMapper(pOrdenTrabajoMapper);
	}

	/* (non-JSDoc)
	 * @see org.ambar.core.testing.basetests.ServicesBaseTest#insertHasErrors(org.ambar.core.dto.DTO)
	 */
	@Override
	protected boolean insertHasErrors(OrdenTrabajoDTO pDTO) {
		return false;
	}

	/* (non-JSDoc)
	 * @see org.ambar.core.testing.basetests.ServicesBaseTest#getByIdHasErrors(org.ambar.core.dto.DTO)
	 */
	@Override
	protected boolean getByIdHasErrors(OrdenTrabajoDTO pDTO) {
		return false;
	}

	/* (non-JSDoc)
	 * @see org.ambar.core.testing.basetests.ServicesBaseTest#prepareDTO(org.ambar.core.dto.DTO)
	 */
	@Override
	protected void prepareDTO(OrdenTrabajoDTO pDTO) {
		RequestContext requestContext = new RequestContext("TESTUSER", new Locale("es", "AR"), "");

		ClienteDTO clienteDTO = clienteDTOForTestingProvider.createDefaultDTO();
		clienteDTO.setRazonSocial("Pancho");

		clienteServices.insert(clienteDTO, requestContext);

		pDTO.setIdCliente(clienteDTO.getId());
		pDTO.setRazonSocialCliente(clienteDTO.getRazonSocial());
	}

	/* (non-JSDoc)
	 * @see org.ambar.core.testing.basetests.ServicesBaseTest#
	 * entityAndDTOAreEquals(org.ambar.core.dto.DTO, org.ambar.core.be.Persistible)
	 */
	@Override
	public Boolean entityAndDTOAreEquals(OrdenTrabajoDTO pDTO, OrdenTrabajo pEntity) {
		return true;
	}
}
