/**
 * appl-cliente-test [17/09/2011 02:38:14]
 */
package org.ambar.appl.testing.test.bo;

import java.util.List;

import org.ambar.appl.be.Cliente;
import org.ambar.appl.be.providers.ClienteForTestingProvider;
import org.ambar.appl.bo.impl.ClienteBOImpl;
import org.ambar.core.testing.basetests.BusinessObjectBaseTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

/**
 * <p>
 * Test de BO de Cliente.
 * </p>
 *
 * @author Sebastian
 *
 *
 */
@ContextConfiguration(locations =
{ "classpath:ambar_core_context.xml", "classpath*:context.xml",
  "classpath:test_context.xml", "classpath*:test_persistence_context.xml" })
public class ClienteBOTest extends BusinessObjectBaseTest<Long, Cliente> {

	/**
	 * Constructor por defecto.
	 * */
	public ClienteBOTest() {
		super();
		this.setBoClass(ClienteBOImpl.class);
	}

	/**
	 * Setea el provider.
	 *
	 * @param pBuilder provider
	 * */
	@Autowired
	public void setBuilder(ClienteForTestingProvider pBuilder) {
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
										  Cliente pEntityToValidate,
										  List<String> pErrorMessages) {
		return false;
	}
}
