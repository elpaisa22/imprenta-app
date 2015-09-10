/**
 * application-test [23/05/2012 17:52:51]
 */
package org.ambar.appl.testing.test;

import org.ambar.appl.testing.test.bo.ArticuloBOTest;
import org.ambar.appl.testing.test.bo.ChequeBOTest;
import org.ambar.appl.testing.test.bo.ClienteBOTest;
import org.ambar.appl.testing.test.bo.FacturaBOTest;
import org.ambar.appl.testing.test.bo.MovimientoCuentaCorrienteBOTest;
import org.ambar.appl.testing.test.bo.OrdenTrabajoBOTest;
import org.ambar.appl.testing.test.bo.RemitoBOTest;
import org.ambar.appl.testing.test.dao.ArticuloDAOTest;
import org.ambar.appl.testing.test.dao.ChequeDAOTest;
import org.ambar.appl.testing.test.dao.ClienteDAOTest;
import org.ambar.appl.testing.test.dao.FacturaDAOTest;
import org.ambar.appl.testing.test.dao.MovimientoCuentaCorrienteDAOTest;
import org.ambar.appl.testing.test.dao.OrdenTrabajoDAOTest;
import org.ambar.appl.testing.test.dao.RemitoDAOTest;
import org.ambar.appl.testing.test.services.ArticuloServicesTest;
import org.ambar.appl.testing.test.services.ChequeServicesTest;
import org.ambar.appl.testing.test.services.ClienteServicesTest;
import org.ambar.appl.testing.test.services.FacturaServicesTest;
import org.ambar.appl.testing.test.services.MovimientoCuentaCorrienteServicesTest;
import org.ambar.appl.testing.test.services.OrdenTrabajoServicesTest;
import org.ambar.appl.testing.test.services.RemitoServicesTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * <p>
 * Test Suite de application-test.
 * </p>
 *
 * @author Sebastian
 *
 */
@RunWith(Suite.class)
@Suite.SuiteClasses(
		{
			OrdenTrabajoDAOTest.class,
			OrdenTrabajoBOTest.class,
			OrdenTrabajoServicesTest.class,
			ClienteDAOTest.class,
			ClienteBOTest.class,
			ClienteServicesTest.class,
			FacturaDAOTest.class,
			FacturaBOTest.class,
			FacturaServicesTest.class,
			MovimientoCuentaCorrienteDAOTest.class,
			MovimientoCuentaCorrienteBOTest.class,
			MovimientoCuentaCorrienteServicesTest.class,
			RemitoDAOTest.class,
			RemitoBOTest.class,
			RemitoServicesTest.class,
			ChequeDAOTest.class,
			ChequeBOTest.class,
			ChequeServicesTest.class,
			ArticuloDAOTest.class,
			ArticuloBOTest.class,
			ArticuloServicesTest.class
		}
)
public class TestSuite {
}
