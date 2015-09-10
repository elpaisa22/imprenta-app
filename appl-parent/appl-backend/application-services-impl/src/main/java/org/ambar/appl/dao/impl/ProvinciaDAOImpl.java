/**
 * application-services-impl [23/05/2015 14:18:22]
 */
package org.ambar.appl.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.ambar.appl.be.Provincia;
import org.ambar.appl.be.ProvinciaID;
import org.ambar.appl.dao.ProvinciaDAO;
import org.ambar.core.dao.impl.CrudDAOImpl;

/**
 * <p>
 * Implementación de {@link ProvinciaDAO}.
 * </p>
 *
 * @author Sebastian
 *
 */
public class ProvinciaDAOImpl
       extends CrudDAOImpl<ProvinciaID, Provincia>
       implements ProvinciaDAO {

	/* (non-JSDoc)
	 * @see org.ambar.appl.dao.ProvinciaDAO#getByIdPais(java.lang.String)
	 */
	@Override
	public List<Provincia> getByIdPais(String pIdPais) {

		assert (pIdPais != null) : "Parámetro inválido";

		StringBuilder bldQuery = new StringBuilder();
		bldQuery.append("select p from Provincia p where ");
		bldQuery.append("p.id.pais.id = :idPais");

		Query query = this.getEntityManager().createQuery(bldQuery.toString());
		query.setParameter("idPais", pIdPais);
		query.setHint("org.hibernate.cacheable", true);

		@SuppressWarnings("unchecked")
		List<Provincia> resultList = (List<Provincia>) query.getResultList();
		if (resultList.isEmpty()) {
			return null;
		} else {
			return resultList;
		}
	}
}
