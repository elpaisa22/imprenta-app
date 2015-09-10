/**
 * application-test [17/02/2014 17:40:24]
 */
package org.ambar.appl.testing.test.dao;

import org.ambar.appl.be.Articulo;
import org.ambar.appl.be.providers.ArticuloForTestingProvider;
import org.ambar.appl.dao.ArticuloDAO;
import org.ambar.core.testing.basetests.DAOBaseTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

/**
 * <p>
 * Test del DAO del Articulo.
 * </p>
 *
 * @author Sebastian
 *
 */
@ContextConfiguration(locations =
{ "classpath:ambar_core_context.xml", "classpath*:context.xml",
  "classpath:test_context.xml", "classpath*:test_persistence_context.xml" })
public class ArticuloDAOTest extends DAOBaseTest<String, Articulo> {

	/**
	 * Setea el provider.
	 *
	 * @param pBuilder provider
	 * */
	@Autowired
	public void setBuilder(ArticuloForTestingProvider pBuilder) {
		super.setProvider(pBuilder);
	}

	/**
	 * Setea el DAO.
	 *
	 * @param pArticuloDAO ArticuloDAO
	 * */
	@Autowired
	public void setDataAccessObject(ArticuloDAO pArticuloDAO) {
		super.setDao(pArticuloDAO);
	}


	@Override
	protected void prepareBussinessEntity(Articulo pBussinessEntity) {
	}

	@Override
	protected void showGettedBussinessEntity(Articulo pBussinessEntity) {
	}

	@Override
	protected boolean insertHasErrors(Articulo pBussinessEntity) {
		return false;
	}

	@Override
	protected boolean updateHasErrors(Articulo pBussinessEntity) {
		return false;
	}

}
