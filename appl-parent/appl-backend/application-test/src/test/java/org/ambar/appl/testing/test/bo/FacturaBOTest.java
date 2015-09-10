/**
 * application-test [25/08/2012 18:45:07]
 */
package org.ambar.appl.testing.test.bo;

import java.util.List;

import org.ambar.appl.be.Factura;
import org.ambar.appl.be.providers.FacturaForTestingProvider;
import org.ambar.appl.bo.impl.FacturaBOImpl;
import org.ambar.core.testing.basetests.BusinessObjectBaseTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

/**
 * <p>
 * Test de BO de la Factura.
 * </p>
 *
 * @author Sebastian
 *
 */
@ContextConfiguration(locations =
{ "classpath:ambar_core_context.xml", "classpath*:context.xml",
  "classpath:test_context.xml", "classpath*:test_persistence_context.xml" })
public class FacturaBOTest extends BusinessObjectBaseTest<Long, Factura> {

	/**
	 * Constructor por defecto.
	 * */
	public FacturaBOTest() {
		super();
		this.setBoClass(FacturaBOImpl.class);
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
			                              Factura pEntityToValidate,
			                              List<String> pErrorMessages) {
		return false;
	}
}
