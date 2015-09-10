/**
 * application-test [25/08/2012 18:45:20]
 */
package org.ambar.appl.testing.test.bo;

import java.util.List;

import org.ambar.appl.be.Remito;
import org.ambar.appl.be.providers.RemitoForTestingProvider;
import org.ambar.appl.bo.impl.RemitoBOImpl;
import org.ambar.core.testing.basetests.BusinessObjectBaseTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

/**
 * <p>
 * Test de BO del Remito.
 * </p>
 *
 * @author Sebastian
 *
 */
@ContextConfiguration(locations =
{ "classpath:ambar_core_context.xml", "classpath*:context.xml",
  "classpath:test_context.xml", "classpath*:test_persistence_context.xml" })
public class RemitoBOTest extends BusinessObjectBaseTest<Long, Remito> {

	/**
	 * Constructor por defecto.
	 * */
	public RemitoBOTest() {
		super();
		this.setBoClass(RemitoBOImpl.class);
	}

	/**
	 * Setea el provider.
	 *
	 * @param pBuilder provider
	 * */
	@Autowired
	public void setBuilder(RemitoForTestingProvider pBuilder) {
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
			                              Remito pEntityToValidate,
			                              List<String> pErrorMessages) {
		return false;
	}
}
