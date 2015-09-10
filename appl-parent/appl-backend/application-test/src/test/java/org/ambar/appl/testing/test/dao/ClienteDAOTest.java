/**
 * appl-cliente-test [17/09/2011 02:36:59]
 */
package org.ambar.appl.testing.test.dao;

import org.ambar.appl.be.Cliente;
import org.ambar.appl.be.providers.ClienteForTestingProvider;
import org.ambar.appl.dao.ClienteDAO;
import org.ambar.core.testing.basetests.DAOBaseTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

/**
 * <p>
 * Test del DAO del Cliente.
 * </p>
 *
 * @author Sebastian
 *
 */
@ContextConfiguration(locations =
{ "classpath:ambar_core_context.xml", "classpath*:context.xml",
  "classpath:test_context.xml", "classpath*:test_persistence_context.xml" })
public class ClienteDAOTest extends DAOBaseTest<Long, Cliente> {

	/**
	 * Setea el provider.
	 *
	 * @param pBuilder provider
	 * */
	@Autowired
	public void setBuilder(ClienteForTestingProvider pBuilder) {
		super.setProvider(pBuilder);
	}

	/**
	 * Setea el DAO.
	 *
	 * @param pClienteDAO ClienteDAO
	 * */
	@Autowired
	public void setDataAccessObject(ClienteDAO pClienteDAO) {
		super.setDao(pClienteDAO);
	}




	@Override
	protected void prepareBussinessEntity(Cliente pBussinessEntity) {
	}

	@Override
	protected void showGettedBussinessEntity(Cliente pBussinessEntity) {
	}

	@Override
	protected boolean insertHasErrors(Cliente pBussinessEntity) {
		return false;
	}

	@Override
	protected boolean updateHasErrors(Cliente pBussinessEntity) {
		return false;
	}

	}
