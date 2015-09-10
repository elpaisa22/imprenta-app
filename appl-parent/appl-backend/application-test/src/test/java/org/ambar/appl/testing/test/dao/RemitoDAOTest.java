/**
 * application-test [25/08/2012 18:46:16]
 */
package org.ambar.appl.testing.test.dao;

import org.ambar.appl.be.Remito;
import org.ambar.appl.be.providers.RemitoForTestingProvider;
import org.ambar.appl.dao.RemitoDAO;
import org.ambar.core.testing.basetests.DAOBaseTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

/**
 * <p>
 * Test del DAO del Remito.
 * </p>
 *
 * @author Sebastian
 *
 */
@ContextConfiguration(locations =
{ "classpath:ambar_core_context.xml", "classpath*:context.xml",
  "classpath:test_context.xml", "classpath*:test_persistence_context.xml" })
public class RemitoDAOTest extends DAOBaseTest<Long, Remito> {

	/**
	 * Setea el provider.
	 *
	 * @param pBuilder provider
	 * */
	@Autowired
	public void setBuilder(RemitoForTestingProvider pBuilder) {
		super.setProvider(pBuilder);
	}

	/**
	 * Setea el DAO.
	 *
	 * @param pRemitoDAO RemitoDAO
	 * */
	@Autowired
	public void setDataAccessObject(RemitoDAO pRemitoDAO) {
		super.setDao(pRemitoDAO);
	}

	/* (non-JSDoc)
	 * @see org.ambar.core.testing.basetests.DAOBaseTest#prepareBussinessEntity(org.ambar.core.be.Persistible)
	 */
	@Override
	protected void prepareBussinessEntity(Remito pBussinessEntity) {
	}

	/* (non-JSDoc)
	 * @see org.ambar.core.testing.basetests.DAOBaseTest#showGettedBussinessEntity(org.ambar.core.be.Persistible)
	 */
	@Override
	protected void showGettedBussinessEntity(Remito pBussinessEntity) {
	}

	/* (non-JSDoc)
	 * @see org.ambar.core.testing.basetests.DAOBaseTest#insertHasErrors(org.ambar.core.be.Persistible)
	 */
	@Override
	protected boolean insertHasErrors(Remito pBussinessEntity) {
		return false;
	}

	/* (non-JSDoc)
	 * @see org.ambar.core.testing.basetests.DAOBaseTest#updateHasErrors(org.ambar.core.be.Persistible)
	 */
	@Override
	protected boolean updateHasErrors(Remito pBussinessEntity) {
		return false;
	}
}
