/**
 * application-test [27/08/2012 22:05:02]
 */
package org.ambar.appl.testing.test.services;

import java.util.Locale;

import org.ambar.appl.be.MovimientoCuentaCorriente;
import org.ambar.appl.dto.ClienteDTO;
import org.ambar.appl.dto.MovimientoCuentaCorrienteDTO;
import org.ambar.appl.dto.providers.ClienteDTOForTestingProvider;
import org.ambar.appl.dto.providers.MovimientoCuentaCorrienteDTOForTestingProvider;
import org.ambar.appl.mappers.MovimientoCuentaCorrienteMapper;
import org.ambar.appl.services.ClienteServices;
import org.ambar.appl.services.CuentaCorrienteServices;
import org.ambar.appl.services.MovimientoCuentaCorrienteServices;
import org.ambar.core.commons.context.RequestContext;
import org.ambar.core.testing.basetests.ServicesBaseTest;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * <p>
 * Test de los servicios del Movimiento.
 * </p>
 *
 * @author Sebastian
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations =
{ "classpath:ambar_core_context.xml", "classpath*:context.xml",
  "classpath:test_context.xml", "classpath*:test_persistence_context.xml" })
public class MovimientoCuentaCorrienteServicesTest
       extends ServicesBaseTest<Long, MovimientoCuentaCorrienteDTO, Long, MovimientoCuentaCorriente> {

	@Autowired
	private CuentaCorrienteServices cuentaCorrienteServices;

	@Autowired
	private ClienteDTOForTestingProvider clienteDTOForTestingProvider;

	@Autowired
	private ClienteServices clienteServices;

	/**
	 * @return Retorna el valor del atributo cuentaCorrienteServices.
	 */
	public CuentaCorrienteServices getCuentaCorrienteServices() {
		return cuentaCorrienteServices;
	}

	/**
	 * @param pCuentaCorrienteServices Establece el valor del atributo cuentaCorrienteServices.
	 */
	public void setCuentaCorrienteServices(CuentaCorrienteServices pCuentaCorrienteServices) {
		cuentaCorrienteServices = pCuentaCorrienteServices;
	}

	/**
	 * @param pClienteDTOForTestingProvider Establece el valor del atributo clienteDTOForTestingProvider.
	 */
	public void setClienteDTOForTestingProvider(ClienteDTOForTestingProvider pClienteDTOForTestingProvider) {
		clienteDTOForTestingProvider = pClienteDTOForTestingProvider;
	}

	/**
	 * @param pClienteServices Establece el valor del atributo clienteServices.
	 */
	public void setClienteServices(ClienteServices pClienteServices) {
		clienteServices = pClienteServices;
	}

	/**
	 * @return Retorna el valor del atributo clienteDTOForTestingProvider.
	 */
	public ClienteDTOForTestingProvider getClienteDTOForTestingProvider() {
		return clienteDTOForTestingProvider;
	}

	/**
	 * @return Retorna el valor del atributo clienteServices.
	 */
	public ClienteServices getClienteServices() {
		return clienteServices;
	}

	/**
	 * Setea el provider.
	 *
	 * @param pDTOBuilder provider
	 * */
	@Autowired
	public void setBuilder(MovimientoCuentaCorrienteDTOForTestingProvider pDTOBuilder) {
		super.setProvider(pDTOBuilder);
	}

	/**
	 * Setea el servicio.
	 *
	 * @param pMovimientoServices MovimientoServices
	 * */
	@Autowired
	public void setServices(MovimientoCuentaCorrienteServices pMovimientoServices) {
		super.setService(pMovimientoServices);
	}


	/**
	 * Setea el mapper.
	 *
	 * @param pMovimientoMapper MovimientoMapper
	 * */
	@Autowired
	public void setMapper(MovimientoCuentaCorrienteMapper pMovimientoMapper) {
		super.setMapper(pMovimientoMapper);
	}

	/* (non-JSDoc)
	 * @see org.ambar.core.testing.basetests.ServicesBaseTest#insertHasErrors(org.ambar.core.dto.DTO)
	 */
	@Override
	protected boolean insertHasErrors(MovimientoCuentaCorrienteDTO pDTO) {
		return false;
	}

	/* (non-JSDoc)
	 * @see org.ambar.core.testing.basetests.ServicesBaseTest#getByIdHasErrors(org.ambar.core.dto.DTO)
	 */
	@Override
	protected boolean getByIdHasErrors(MovimientoCuentaCorrienteDTO pDTO) {
		return pDTO.getIdCuentaCorriente() == null;
	}

	/* (non-JSDoc)
	 * @see org.ambar.core.testing.basetests.ServicesBaseTest#prepareDTO(org.ambar.core.dto.DTO)
	 */
	@Override
	protected void prepareDTO(MovimientoCuentaCorrienteDTO pDTO) {
		RequestContext requestContext = new RequestContext("TEST", new Locale("es", "AR"), null);

        ClienteDTO clienteDTO = this.getClienteDTOForTestingProvider().createDefaultDTO();
        this.getClienteServices().insert(clienteDTO, requestContext);

        clienteDTO = this.getClienteServices().getById(clienteDTO.getId(), requestContext).getResult();

		pDTO.setIdCuentaCorriente(clienteDTO.getIdCuentaCorriente());
	}

	/* (non-JSDoc)
	 * @see org.ambar.core.testing.basetests.ServicesBaseTest#
	 * entityAndDTOAreEquals(org.ambar.core.dto.DTO, org.ambar.core.be.Persistible)
	 */
	@Override
	public Boolean entityAndDTOAreEquals(MovimientoCuentaCorrienteDTO pDTO, MovimientoCuentaCorriente pEntity) {
		return true;
	}
}
