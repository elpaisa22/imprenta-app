/**
 * application-services-impl [23/05/2015 14:12:33]
 */
package org.ambar.appl.bo.impl;

import java.util.List;

import org.ambar.appl.be.Provincia;
import org.ambar.appl.be.ProvinciaID;
import org.ambar.appl.bo.ProvinciaBO;
import org.ambar.appl.dao.ProvinciaDAO;
import org.ambar.core.bo.impl.CrudBusinessObjectImpl;
import org.ambar.core.validation.configuration.Validation;
import org.ambar.core.validation.configuration.ValidationStrategy;
import org.ambar.core.validation.configuration.Validations;

/**
 * <p>
 * Implementación por default de {@link ProvinciaBO}.
 * </p>
 *
 * @author Sebastian
 *
 *
 */
@Validations(
		validations = {
				@Validation(
						transactionNames = { "insert" },
						validators = { "applicationHibernateValidators" }
						),
				@Validation(
						transactionNames = { "update" },
						validators = { "applicationHibernateValidators" })
		},
		strategy = ValidationStrategy.CONTINUE
)
public class ProvinciaBOImpl
       extends CrudBusinessObjectImpl<ProvinciaID, Provincia>
       implements ProvinciaBO {

	/* (non-JSDoc)
	 * @see org.ambar.appl.bo.ProvinciaBO#getByIdPais(java.lang.String)
	 */
	@Override
	public List<Provincia> getByIdPais(String pIdPais) {
		return ((ProvinciaDAO) this.getDao()).getByIdPais(pIdPais);
	}
}
