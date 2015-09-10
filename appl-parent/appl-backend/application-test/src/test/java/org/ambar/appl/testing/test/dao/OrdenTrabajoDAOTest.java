/**
 * application-test [23/05/2012 18:34:36]
 */
package org.ambar.appl.testing.test.dao;

import javax.annotation.Resource;

import org.ambar.appl.be.Cliente;
import org.ambar.appl.be.OrdenTrabajo;
import org.ambar.appl.be.providers.ClienteForTestingProvider;
import org.ambar.appl.be.providers.OrdenTrabajoForTestingProvider;
import org.ambar.appl.dao.ClienteDAO;
import org.ambar.appl.dao.OrdenTrabajoDAO;
import org.ambar.core.testing.basetests.DAOBaseTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

/**
 * <p>
 * Test del DAO de la OrdenTrabajo.
 * </p>
 *
 * @author Sebastian
 *
 */
@ContextConfiguration(locations =
{ "classpath:ambar_core_context.xml", "classpath*:context.xml",
  "classpath:test_context.xml", "classpath*:test_persistence_context.xml" })
public class OrdenTrabajoDAOTest extends DAOBaseTest<Long, OrdenTrabajo> {

	@Resource (name = "clienteForTestingProvider")
	private ClienteForTestingProvider clienteForTestingProvider;

	@Resource (name = "clienteDAO")
	private ClienteDAO clienteDAO;

	/**
	 * Setea el provider.
	 *
	 * @param pBuilder provider
	 * */
	@Autowired
	public void setBuilder(OrdenTrabajoForTestingProvider pBuilder) {
		super.setProvider(pBuilder);
	}

	/**
	 * Setea el DAO.
	 *
	 * @param pOrdenTrabajoDAO OrdenTrabajoDAO
	 * */
	@Autowired
	public void setDataAccessObject(OrdenTrabajoDAO pOrdenTrabajoDAO) {
		super.setDao(pOrdenTrabajoDAO);
	}

	/* (non-JSDoc)
	 * @see org.ambar.core.testing.basetests.DAOBaseTest#prepareBussinessEntity(org.ambar.core.be.Persistible)
	 */
	@Override
	protected void prepareBussinessEntity(OrdenTrabajo pBussinessEntity) {
		Cliente cliente = clienteForTestingProvider.createDefaultBussinessEntity();
		cliente.setRazonSocial("Pancho");

		clienteDAO.insert(cliente);
		pBussinessEntity.setCliente(cliente);
	}

	/* (non-JSDoc)
	 * @see org.ambar.core.testing.basetests.DAOBaseTest#showGettedBussinessEntity(org.ambar.core.be.Persistible)
	 */
	@Override
	protected void showGettedBussinessEntity(OrdenTrabajo pBussinessEntity) {
	}

	/* (non-JSDoc)
	 * @see org.ambar.core.testing.basetests.DAOBaseTest#insertHasErrors(org.ambar.core.be.Persistible)
	 */
	@Override
	protected boolean insertHasErrors(OrdenTrabajo pBussinessEntity) {
		return false;
	}

	/* (non-JSDoc)
	 * @see org.ambar.core.testing.basetests.DAOBaseTest#updateHasErrors(org.ambar.core.be.Persistible)
	 */
	@Override
	protected boolean updateHasErrors(OrdenTrabajo pBussinessEntity) {
		return false;
	}
}
