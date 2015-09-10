/**
 * application-test [17/02/2014 17:38:01]
 */
package org.ambar.appl.testing.test.bo;

import java.util.List;

import org.ambar.appl.be.Articulo;
import org.ambar.appl.be.providers.ArticuloForTestingProvider;
import org.ambar.appl.bo.impl.ArticuloBOImpl;
import org.ambar.core.testing.basetests.BusinessObjectBaseTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

/**
 * <p>
 * Test de BO de Articulo.
 * </p>
 *
 * @author Sebastian
 *
 */
@ContextConfiguration(locations =
{ "classpath:ambar_core_context.xml", "classpath*:context.xml",
  "classpath:test_context.xml", "classpath*:test_persistence_context.xml" })
public class ArticuloBOTest extends BusinessObjectBaseTest<String, Articulo> {

	/**
	 * Constructor por defecto.
	 * */
	public ArticuloBOTest() {
		super();
		this.setBoClass(ArticuloBOImpl.class);
	}

	/**
	 * Setea el provider.
	 *
	 * @param pBuilder provider
	 * */
	@Autowired
	public void setBuilder(ArticuloForTestingProvider pBuilder) {
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
										  Articulo pEntityToValidate,
										  List<String> pErrorMessages) {
		return false;
	}
}
