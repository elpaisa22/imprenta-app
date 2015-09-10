/**
 * application-test [27/08/2012 22:04:51]
 */
package org.ambar.appl.testing.test.services;

import java.util.Locale;

import org.ambar.appl.be.Factura;
import org.ambar.appl.dto.ClienteDTO;
import org.ambar.appl.dto.FacturaDTO;
import org.ambar.appl.dto.providers.ClienteDTOForTestingProvider;
import org.ambar.appl.dto.providers.FacturaDTOForTestingProvider;
import org.ambar.appl.mappers.FacturaMapper;
import org.ambar.appl.services.ClienteServices;
import org.ambar.appl.services.FacturaServices;
import org.ambar.core.commons.context.RequestContext;
import org.ambar.core.testing.basetests.ServicesBaseTest;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * <p>
 * Test de los servicios del Factura.
 * </p>
 *
 * @author Sebastian
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations =
{ "classpath:ambar_core_context.xml", "classpath*:context.xml",
  "classpath:test_context.xml", "classpath*:test_persistence_context.xml" })
public class FacturaServicesTest extends ServicesBaseTest<Long, FacturaDTO, Long, Factura> {

	@Autowired
	private ClienteServices clienteServices;

	@Autowired
	private ClienteDTOForTestingProvider clienteProvider;

	/**
	 * @param pClienteServices Establece el valor del atributo clienteServices.
	 */
	public void setClienteServices(ClienteServices pClienteServices) {
		clienteServices = pClienteServices;
	}

	/**
	 * @param pClienteProvider Establece el valor del atributo clienteProvider.
	 */
	public void setClienteProvider(ClienteDTOForTestingProvider pClienteProvider) {
		clienteProvider = pClienteProvider;
	}

	/**
	 * Setea el provider.
	 *
	 * @param pDTOBuilder provider
	 * */
	@Autowired
	public void setBuilder(FacturaDTOForTestingProvider pDTOBuilder) {
		super.setProvider(pDTOBuilder);
	}

	/**
	 * Setea el servicio.
	 *
	 * @param pFacturaServices FacturaServices
	 * */
	@Autowired
	public void setServices(FacturaServices pFacturaServices) {
		super.setService(pFacturaServices);
	}


	/**
	 * Setea el mapper.
	 *
	 * @param pFacturaMapper FacturaMapper
	 * */
	@Autowired
	public void setMapper(FacturaMapper pFacturaMapper) {
		super.setMapper(pFacturaMapper);
	}

	/* (non-JSDoc)
	 * @see org.ambar.core.testing.basetests.ServicesBaseTest#insertHasErrors(org.ambar.core.dto.DTO)
	 */
	@Override
	protected boolean insertHasErrors(FacturaDTO pDTO) {
		return false;
	}

	/* (non-JSDoc)
	 * @see org.ambar.core.testing.basetests.ServicesBaseTest#getByIdHasErrors(org.ambar.core.dto.DTO)
	 */
	@Override
	protected boolean getByIdHasErrors(FacturaDTO pDTO) {
		return false;
	}

	/* (non-JSDoc)
	 * @see org.ambar.core.testing.basetests.ServicesBaseTest#prepareDTO(org.ambar.core.dto.DTO)
	 */
	@Override
	protected void prepareDTO(FacturaDTO pDTO) {

		ClienteDTO cliente = this.clienteProvider.createDefaultDTO();
		RequestContext requestContext = new RequestContext("TEST", new Locale("es", "AR"), null);
		clienteServices.insert(cliente, requestContext);

		pDTO.setIdCliente(cliente.getId());
	}

	/* (non-JSDoc)
	 * @see org.ambar.core.testing.basetests.ServicesBaseTest#
	 * entityAndDTOAreEquals(org.ambar.core.dto.DTO, org.ambar.core.be.Persistible)
	 */
	@Override
	public Boolean entityAndDTOAreEquals(FacturaDTO pDTO, Factura pEntity) {
		return true;
	}
}
