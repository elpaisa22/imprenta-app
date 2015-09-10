/**
 * application-test [17/02/2014 17:42:17]
 */
package org.ambar.appl.testing.test.services;

import org.ambar.appl.be.Articulo;
import org.ambar.appl.dto.ArticuloDTO;
import org.ambar.appl.dto.providers.ArticuloDTOForTestingProvider;
import org.ambar.appl.mappers.ArticuloMapper;
import org.ambar.appl.services.ArticuloServices;
import org.ambar.core.testing.basetests.ServicesBaseTest;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * <p>
 * Test de los servicios del Articulo.
 * </p>
 *
 * @author Sebastian
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations =
{ "classpath:ambar_core_context.xml", "classpath*:context.xml",
  "classpath:test_context.xml", "classpath*:test_persistence_context.xml" })
public class ArticuloServicesTest extends ServicesBaseTest<String, ArticuloDTO, String, Articulo> {



	/**
	 * Setea el provider.
	 *
	 * @param pDTOBuilder provider
	 * */
	@Autowired
	public void setBuilder(ArticuloDTOForTestingProvider pDTOBuilder) {
		super.setProvider(pDTOBuilder);
	}

	/**
	 * Setea el servicio.
	 *
	 * @param pArticuloServices ArticuloServices
	 * */
	@Autowired
	public void setServices(ArticuloServices pArticuloServices) {
		super.setService(pArticuloServices);
	}


	/**
	 * Setea el mapper.
	 *
	 * @param pArticuloMapper ArticuloMapper
	 * */
	@Autowired
	public void setMapper(ArticuloMapper pArticuloMapper) {
		super.setMapper(pArticuloMapper);
	}




	@Override
	protected boolean insertHasErrors(ArticuloDTO pDTO) {
		return false;
	}

	@Override
	protected boolean getByIdHasErrors(ArticuloDTO pDTO) {
		return false;
	}

	@Override
	public Boolean entityAndDTOAreEquals(ArticuloDTO pDTO, Articulo pEntity) {
		return ((pDTO.getCosto().compareTo(pEntity.getCosto()) == 0));
	}

	@Override
	protected void prepareDTO(ArticuloDTO pDTO) {
	}

}
