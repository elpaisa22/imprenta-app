/**
 * application-test [23/05/2012 18:31:49]
 */
package org.ambar.appl.testing.test.bo;

import java.util.List;

import org.ambar.appl.be.OrdenTrabajo;
import org.ambar.appl.be.providers.OrdenTrabajoForTestingProvider;
import org.ambar.appl.bo.impl.OrdenTrabajoBOImpl;
import org.ambar.core.testing.basetests.BusinessObjectBaseTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

/**
 * <p>
 * Test de BO de OrdenTrabajo.
 * </p>
 *
 * @author Sebastian
 *
 */
@ContextConfiguration(locations =
{ "classpath:ambar_core_context.xml", "classpath*:context.xml",
  "classpath:test_context.xml", "classpath*:test_persistence_context.xml" })
public class OrdenTrabajoBOTest extends BusinessObjectBaseTest<Long, OrdenTrabajo> {

	/**
	 * Constructor por defecto.
	 * */
	public OrdenTrabajoBOTest() {
		super();
		this.setBoClass(OrdenTrabajoBOImpl.class);
	}

	/**
	 * Setea el provider.
	 *
	 * @param pBuilder provider
	 * */
	@Autowired
	public void setBuilder(OrdenTrabajoForTestingProvider pBuilder) {
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
			                              OrdenTrabajo pEntityToValidate,
			                              List<String> pErrorMessages) {
		return false;
	}
}
