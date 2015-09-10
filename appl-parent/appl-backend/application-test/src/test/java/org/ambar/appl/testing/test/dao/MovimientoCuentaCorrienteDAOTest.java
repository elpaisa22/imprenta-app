/**
 * application-test [25/08/2012 18:46:28]
 */
package org.ambar.appl.testing.test.dao;

import org.ambar.appl.be.Cliente;
import org.ambar.appl.be.CuentaCorriente;
import org.ambar.appl.be.MovimientoCuentaCorriente;
import org.ambar.appl.be.providers.ClienteForTestingProvider;
import org.ambar.appl.be.providers.MovimientoCuentaCorrienteForTestingProvider;
import org.ambar.appl.dao.ClienteDAO;
import org.ambar.appl.dao.CuentaCorrienteDAO;
import org.ambar.appl.dao.MovimientoCuentaCorrienteDAO;
import org.ambar.core.testing.basetests.DAOBaseTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

/**
 * <p>
 * Test del DAO del Movimiento.
 * </p>
 *
 * @author Sebastian
 *
 */
@ContextConfiguration(locations =
{ "classpath:ambar_core_context.xml", "classpath*:context.xml",
  "classpath:test_context.xml", "classpath*:test_persistence_context.xml" })
public class MovimientoCuentaCorrienteDAOTest extends DAOBaseTest<Long, MovimientoCuentaCorriente> {

	@Autowired
	private CuentaCorrienteDAO cuentaCorrienteDAO;

	@Autowired
	private ClienteForTestingProvider clienteProvider;
	@Autowired
	private ClienteDAO clienteDAO;

	/**
	 * Setea el provider.
	 *
	 * @param pBuilder provider
	 * */
	@Autowired
	public void setBuilder(MovimientoCuentaCorrienteForTestingProvider pBuilder) {
		super.setProvider(pBuilder);
	}

	/**
	 * Setea el DAO.
	 *
	 * @param pMovimientoDAO MovimientoDAO
	 * */
	@Autowired
	public void setDataAccessObject(MovimientoCuentaCorrienteDAO pMovimientoDAO) {
		super.setDao(pMovimientoDAO);
	}

	/**
	 * @return Retorna el valor del atributo cuentaCorrienteDAO.
	 */
	public CuentaCorrienteDAO getCuentaCorrienteDAO() {
		return cuentaCorrienteDAO;
	}

	/**
	 * @param pCuentaCorrienteDAO Establece el valor del atributo cuentaCorrienteDAO.
	 */
	public void setCuentaCorrienteDAO(CuentaCorrienteDAO pCuentaCorrienteDAO) {
		cuentaCorrienteDAO = pCuentaCorrienteDAO;
	}

	/**
	 * @return Retorna el valor del atributo clienteProvider.
	 */
	public ClienteForTestingProvider getClienteProvider() {
		return clienteProvider;
	}

	/**
	 * @param pClienteProvider Establece el valor del atributo clienteProvider.
	 */
	public void setClienteProvider(ClienteForTestingProvider pClienteProvider) {
		clienteProvider = pClienteProvider;
	}

	/**
	 * @return Retorna el valor del atributo clienteDAO.
	 */
	public ClienteDAO getClienteDAO() {
		return clienteDAO;
	}

	/**
	 * @param pClienteDAO Establece el valor del atributo clienteDAO.
	 */
	public void setClienteDAO(ClienteDAO pClienteDAO) {
		clienteDAO = pClienteDAO;
	}

	/* (non-JSDoc)
	 * @see org.ambar.core.testing.basetests.DAOBaseTest#prepareBussinessEntity(org.ambar.core.be.Persistible)
	 */
	@Override
	protected void prepareBussinessEntity(MovimientoCuentaCorriente pBussinessEntity) {
		Cliente cliente = this.getClienteProvider().createDefaultBussinessEntity();
		
		CuentaCorriente cuentaCorriente = new CuentaCorriente();
		cuentaCorriente.setTrackInfo(cliente.getTrackInfo());
		cliente.setCuentaCorriente(cuentaCorriente);
		cuentaCorriente.setCliente(cliente);
		cliente.getCuentaCorriente().setTrackInfo(cliente.getTrackInfo());
		
		this.clienteDAO.insert(cliente);
		pBussinessEntity.setCuentaCorriente(cliente.getCuentaCorriente());
	}

	/* (non-JSDoc)
	 * @see org.ambar.core.testing.basetests.DAOBaseTest#showGettedBussinessEntity(org.ambar.core.be.Persistible)
	 */
	@Override
	protected void showGettedBussinessEntity(MovimientoCuentaCorriente pBussinessEntity) {
	}

	/* (non-JSDoc)
	 * @see org.ambar.core.testing.basetests.DAOBaseTest#insertHasErrors(org.ambar.core.be.Persistible)
	 */
	@Override
	protected boolean insertHasErrors(MovimientoCuentaCorriente pBussinessEntity) {
		return false;
	}

	/* (non-JSDoc)
	 * @see org.ambar.core.testing.basetests.DAOBaseTest#updateHasErrors(org.ambar.core.be.Persistible)
	 */
	@Override
	protected boolean updateHasErrors(MovimientoCuentaCorriente pBussinessEntity) {
		return false;
	}
}
