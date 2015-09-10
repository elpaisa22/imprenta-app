/**
 * application-test [02/03/2013 15:16:39]
 */
package org.ambar.appl.testing.test.bo;

import java.util.List;

import org.ambar.appl.be.Cheque;
import org.ambar.appl.be.providers.ChequeForTestingProvider;
import org.ambar.appl.bo.impl.ChequeBOImpl;
import org.ambar.core.testing.basetests.BusinessObjectBaseTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

/**
 * <p>
 * Test de BO de Cheque.
 * </p>
 *
 * @author Sebastian
 *
 */
@ContextConfiguration(locations =
{ "classpath:ambar_core_context.xml", "classpath*:context.xml",
  "classpath:test_context.xml", "classpath*:test_persistence_context.xml" })
public class ChequeBOTest extends BusinessObjectBaseTest<Long, Cheque> {

	/**
	 * Constructor por defecto.
	 * */
	public ChequeBOTest() {
		super();
		this.setBoClass(ChequeBOImpl.class);
	}

	/**
	 * Setea el provider.
	 *
	 * @param pBuilder provider
	 * */
	@Autowired
	public void setBuilder(ChequeForTestingProvider pBuilder) {
		super.setProvider(pBuilder);
	}

	@Override
	protected boolean validationWithValidatorHasErrors(String pValidatorName,
			String[ ] pProfiles,
			Object pEntityToValidate,
			List<String> pErrorMessages) {
		return false;
	}


	@Override
	protected boolean validationHasErrors(String pTransaction,
										  Cheque pEntityToValidate,
										  List<String> pErrorMessages) {
		return false;
	}
}
