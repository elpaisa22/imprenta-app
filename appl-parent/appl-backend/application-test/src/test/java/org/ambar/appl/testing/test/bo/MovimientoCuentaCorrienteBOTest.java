/**
 * application-test [25/08/2012 18:45:32]
 */
package org.ambar.appl.testing.test.bo;

import java.util.List;

import org.ambar.appl.be.MovimientoCuentaCorriente;
import org.ambar.appl.be.providers.MovimientoCuentaCorrienteForTestingProvider;
import org.ambar.appl.bo.impl.MovimientoCuentaCorrienteBOImpl;
import org.ambar.core.testing.basetests.BusinessObjectBaseTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

/**
 * <p>
 * Test de BO del Movimiento.
 * </p>
 *
 * @author Sebastian
 *
 */
@ContextConfiguration(locations =
{ "classpath:ambar_core_context.xml", "classpath*:context.xml",
  "classpath:test_context.xml", "classpath*:test_persistence_context.xml" })
public class MovimientoCuentaCorrienteBOTest extends BusinessObjectBaseTest<Long, MovimientoCuentaCorriente> {

	/**
	 * Constructor por defecto.
	 * */
	public MovimientoCuentaCorrienteBOTest() {
		super();
		this.setBoClass(MovimientoCuentaCorrienteBOImpl.class);
	}

	/**
	 * Setea el provider.
	 *
	 * @param pBuilder provider
	 * */
	@Autowired
	public void setBuilder(MovimientoCuentaCorrienteForTestingProvider pBuilder) {
		super.setProvider(pBuilder);
	}

	/* (non-JSDoc)
	 * @see org.ambar.core.testing.basetests.BusinessObjectBaseTest#
	 * validationWithValidatorHasErrors(java.lang.String, java.lang.String[], java.lang.Object, java.util.List)
	 */
	@Override
	protected boolean validationWithValidatorHasErrors(String pValidatorName,
			String[ ] pProfiles,
			Object pEntityToValidate,
			List<String> pErrorMessages) {
		return false;
	}

	/* (non-JSDoc)
	 * @see org.ambar.core.testing.basetests.BusinessObjectBaseTest#
	 * validationHasErrors(java.lang.String, org.ambar.core.be.Persistible, java.util.List)
	 */
	@Override
	protected boolean validationHasErrors(String pTransaction,
			                              MovimientoCuentaCorriente pEntityToValidate,
			                              List<String> pErrorMessages) {
		return false;
	}
}
