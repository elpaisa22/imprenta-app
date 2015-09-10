/**
 * application-test [02/03/2013 15:21:30]
 */
package org.ambar.appl.testing.test.services;

import java.util.Locale;

import javax.annotation.Resource;

import org.ambar.appl.be.Cheque;
import org.ambar.appl.dto.ChequeDTO;
import org.ambar.appl.dto.ClienteDTO;
import org.ambar.appl.dto.providers.ChequeDTOForTestingProvider;
import org.ambar.appl.dto.providers.ClienteDTOForTestingProvider;
import org.ambar.appl.mappers.ChequeMapper;
import org.ambar.appl.services.ChequeServices;
import org.ambar.appl.services.ClienteServices;
import org.ambar.core.commons.context.RequestContext;
import org.ambar.core.testing.basetests.ServicesBaseTest;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * <p>
 * Test de los servicios del Cheque.
 * </p>
 *
 * @author Sebastian
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations =
{ "classpath:ambar_core_context.xml", "classpath*:context.xml",
  "classpath:test_context.xml", "classpath*:test_persistence_context.xml" })
public class ChequeServicesTest
	extends ServicesBaseTest<Long, ChequeDTO, Long, Cheque> {

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
	public void setBuilder(ChequeDTOForTestingProvider pDTOBuilder) {
		super.setProvider(pDTOBuilder);
	}

	/**
	 * Setea el servicio.
	 *
	 * @param pChequeServices ChequeServices
	 * */
	@Autowired
	public void setServices(ChequeServices pChequeServices) {
		super.setService(pChequeServices);
	}


	/**
	 * Setea el mapper.
	 *
	 * @param pChequeMapper ChequeMapper
	 * */
	@Autowired
	public void setMapper(ChequeMapper pChequeMapper) {
		super.setMapper(pChequeMapper);
	}




	@Override
	protected boolean insertHasErrors(ChequeDTO pDTO) {
		return false;
	}

	@Override
	protected boolean getByIdHasErrors(ChequeDTO pDTO) {
		return false;
	}

	@Override
	public Boolean entityAndDTOAreEquals(ChequeDTO pDTO, Cheque pEntity) {
		return ((pDTO.getMonto() == pEntity.getMonto()));
	}

	@Override
	protected void prepareDTO(ChequeDTO pDTO) {
		RequestContext requestContext = new RequestContext("TESTUSER", new Locale("es", "AR"), "");

		ClienteDTO clienteDTO = clienteDTOForTestingProvider.createDefaultDTO();
		clienteDTO.setRazonSocial("Pancho");

		clienteServices.insert(clienteDTO, requestContext);

		pDTO.setIdCliente(clienteDTO.getId());
		pDTO.setRazonSocialCliente(clienteDTO.getRazonSocial());
	}

}
