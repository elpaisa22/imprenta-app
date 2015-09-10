/**
 * application-test [27/08/2012 22:05:17]
 */
package org.ambar.appl.testing.test.services;

import org.ambar.appl.be.Remito;
import org.ambar.appl.dto.RemitoDTO;
import org.ambar.appl.dto.providers.RemitoDTOForTestingProvider;
import org.ambar.appl.mappers.RemitoMapper;
import org.ambar.appl.services.RemitoServices;
import org.ambar.core.testing.basetests.ServicesBaseTest;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * <p>
 * Test de los servicios del Remito.
 * </p>
 *
 * @author Sebastian
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations =
{ "classpath:ambar_core_context.xml", "classpath*:context.xml",
  "classpath:test_context.xml", "classpath*:test_persistence_context.xml" })
public class RemitoServicesTest
	extends ServicesBaseTest<Long, RemitoDTO, Long, Remito> {

	/**
	 * Setea el provider.
	 *
	 * @param pDTOBuilder provider
	 * */
	@Autowired
	public void setBuilder(RemitoDTOForTestingProvider pDTOBuilder) {
		super.setProvider(pDTOBuilder);
	}

	/**
	 * Setea el servicio.
	 *
	 * @param pRemitoServices RemitoServices
	 * */
	@Autowired
	public void setServices(RemitoServices pRemitoServices) {
		super.setService(pRemitoServices);
	}


	/**
	 * Setea el mapper.
	 *
	 * @param pRemitoMapper RemitoMapper
	 * */
	@Autowired
	public void setMapper(RemitoMapper pRemitoMapper) {
		super.setMapper(pRemitoMapper);
	}

	/* (non-JSDoc)
	 * @see org.ambar.core.testing.basetests.ServicesBaseTest#insertHasErrors(org.ambar.core.dto.DTO)
	 */
	@Override
	protected boolean insertHasErrors(RemitoDTO pDTO) {
		return false;
	}

	/* (non-JSDoc)
	 * @see org.ambar.core.testing.basetests.ServicesBaseTest#getByIdHasErrors(org.ambar.core.dto.DTO)
	 */
	@Override
	protected boolean getByIdHasErrors(RemitoDTO pDTO) {
		return false;
	}

	/* (non-JSDoc)
	 * @see org.ambar.core.testing.basetests.ServicesBaseTest#prepareDTO(org.ambar.core.dto.DTO)
	 */
	@Override
	protected void prepareDTO(RemitoDTO pDTO) {
	}

	/* (non-JSDoc)
	 * @see org.ambar.core.testing.basetests.ServicesBaseTest#
	 * entityAndDTOAreEquals(org.ambar.core.dto.DTO, org.ambar.core.be.Persistible)
	 */
	@Override
	public Boolean entityAndDTOAreEquals(RemitoDTO pDTO, Remito pEntity) {
		return true;
	}
}
