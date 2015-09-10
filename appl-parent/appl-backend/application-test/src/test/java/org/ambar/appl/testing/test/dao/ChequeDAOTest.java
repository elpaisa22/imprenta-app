/**
 * application-test [02/03/2013 15:19:17]
 */
package org.ambar.appl.testing.test.dao;

import org.ambar.appl.be.Cheque;
import org.ambar.appl.be.providers.ChequeForTestingProvider;
import org.ambar.appl.dao.ChequeDAO;
import org.ambar.core.testing.basetests.DAOBaseTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

/**
 * <p>
 * Test del DAO del Cheque.
 * </p>
 *
 * @author Sebastian
 *
 */
@ContextConfiguration(locations =
{ "classpath:ambar_core_context.xml", "classpath*:context.xml",
  "classpath:test_context.xml", "classpath*:test_persistence_context.xml" })
public class ChequeDAOTest extends DAOBaseTest<Long, Cheque> {

	/**
	 * Setea el provider.
	 *
	 * @param pBuilder provider
	 * */
	@Autowired
	public void setBuilder(ChequeForTestingProvider pBuilder) {
		super.setProvider(pBuilder);
	}

	/**
	 * Setea el DAO.
	 *
	 * @param pChequeDAO ChequeDAO
	 * */
	@Autowired
	public void setDataAccessObject(ChequeDAO pChequeDAO) {
		super.setDao(pChequeDAO);
	}


	@Override
	protected void prepareBussinessEntity(Cheque pBussinessEntity) {
	}

	@Override
	protected void showGettedBussinessEntity(Cheque pBussinessEntity) {
	}

	@Override
	protected boolean insertHasErrors(Cheque pBussinessEntity) {
		return false;
	}

	@Override
	protected boolean updateHasErrors(Cheque pBussinessEntity) {
		return false;
	}

}
