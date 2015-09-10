/**
 * application-test [25/08/2012 18:46:05]
 */
package org.ambar.appl.testing.test.dao;

import org.ambar.appl.be.Articulo;
import org.ambar.appl.be.Cliente;
import org.ambar.appl.be.DetalleFactura;
import org.ambar.appl.be.Factura;
import org.ambar.appl.be.providers.ArticuloForTestingProvider;
import org.ambar.appl.be.providers.ClienteForTestingProvider;
import org.ambar.appl.be.providers.FacturaForTestingProvider;
import org.ambar.appl.dao.ArticuloDAO;
import org.ambar.appl.dao.ClienteDAO;
import org.ambar.appl.dao.FacturaDAO;
import org.ambar.core.testing.basetests.DAOBaseTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

/**
 * <p>
 * Test del DAO de la Factura.
 * </p>
 *
 * @author Sebastian
 *
 */
@ContextConfiguration(locations =
{ "classpath:ambar_core_context.xml", "classpath*:context.xml",
  "classpath:test_context.xml", "classpath*:test_persistence_context.xml" })
public class FacturaDAOTest extends DAOBaseTest<Long, Factura> {

	@Autowired
	private ArticuloForTestingProvider articuloProvider;

	@Autowired
	private ArticuloDAO articuloDAO;

	@Autowired
	private ClienteForTestingProvider clienteProvider;

	@Autowired
	private ClienteDAO clienteDAO;

	private Integer artID = 1;

	/**
	 * @param pArticuloProvider Establece el valor del atributo articuloProvider.
	 */
	public void setArticuloProvider(ArticuloForTestingProvider pArticuloProvider) {
		articuloProvider = pArticuloProvider;
	}

	/**
	 * @param pArticuloDAO Establece el valor del atributo articuloDAO.
	 */
	public void setArticuloDAO(ArticuloDAO pArticuloDAO) {
		articuloDAO = pArticuloDAO;
	}

	/**
	 * @param pClienteProvider Establece el valor del atributo clienteProvider.
	 */
	public void setClienteProvider(ClienteForTestingProvider pClienteProvider) {
		clienteProvider = pClienteProvider;
	}

	/**
	 * @param pClienteDAO Establece el valor del atributo clienteDAO.
	 */
	public void setClienteDAO(ClienteDAO pClienteDAO) {
		clienteDAO = pClienteDAO;
	}

	/**
	 * Setea el provider.
	 *
	 * @param pBuilder provider
	 * */
	@Autowired
	public void setBuilder(FacturaForTestingProvider pBuilder) {
		super.setProvider(pBuilder);
	}

	/**
	 * Setea el DAO.
	 *
	 * @param pFacturaDAO FacturaDAO
	 * */
	@Autowired
	public void setDataAccessObject(FacturaDAO pFacturaDAO) {
		super.setDao(pFacturaDAO);
	}

	/* (non-JSDoc)
	 * @see org.ambar.core.testing.basetests.DAOBaseTest#prepareBussinessEntity(org.ambar.core.be.Persistible)
	 */
	@Override
	protected void prepareBussinessEntity(Factura pBussinessEntity) {
		Cliente cliente = this.clienteProvider.createDefaultBussinessEntity();
		this.clienteDAO.insert(cliente);

		Articulo articulo1 = this.articuloProvider.createDefaultBussinessEntity();
		articulo1.setId("TESTDESDEFAC_" + this.artID++);
		Articulo articulo2 = this.articuloProvider.createDefaultBussinessEntity();
		articulo2.setId("TESTDESDEFAC_" + this.artID++);
		Articulo articulo3 = this.articuloProvider.createDefaultBussinessEntity();
		articulo3.setId("TESTDESDEFAC_" + this.artID++);

		this.articuloDAO.insert(articulo1);
		this.articuloDAO.insert(articulo2);
		this.articuloDAO.insert(articulo3);

		DetalleFactura detalleFactura1 = new DetalleFactura();
		detalleFactura1.setArticulo(articulo1);
		detalleFactura1.setCantidad(1);

		DetalleFactura detalleFactura2 = new DetalleFactura();
		detalleFactura2.setArticulo(articulo2);
		detalleFactura2.setCantidad(2);

		DetalleFactura detalleFactura3 = new DetalleFactura();
		detalleFactura3.setArticulo(articulo3);
		detalleFactura3.setCantidad(3);

		pBussinessEntity.agregarDetalleFactura(detalleFactura1);
		pBussinessEntity.agregarDetalleFactura(detalleFactura2);
		pBussinessEntity.agregarDetalleFactura(detalleFactura3);
	}

	/* (non-JSDoc)
	 * @see org.ambar.core.testing.basetests.DAOBaseTest#showGettedBussinessEntity(org.ambar.core.be.Persistible)
	 */
	@Override
	protected void showGettedBussinessEntity(Factura pBussinessEntity) {
	}

	/* (non-JSDoc)
	 * @see org.ambar.core.testing.basetests.DAOBaseTest#insertHasErrors(org.ambar.core.be.Persistible)
	 */
	@Override
	protected boolean insertHasErrors(Factura pBussinessEntity) {
		return pBussinessEntity.getColeccionDetalleFacturas().size() != 3;
	}

	/* (non-JSDoc)
	 * @see org.ambar.core.testing.basetests.DAOBaseTest#updateHasErrors(org.ambar.core.be.Persistible)
	 */
	@Override
	protected boolean updateHasErrors(Factura pBussinessEntity) {
		return pBussinessEntity.getColeccionDetalleFacturas().size() != 3;
	}
}
