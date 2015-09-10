/**
 * application-services-impl [19/6/2015 20:29:20]
 */
package org.ambar.appl.dao.impl;

import org.ambar.appl.be.Cheque;
import org.ambar.appl.dao.ChequeDAO;
import org.ambar.core.be.FilteredList;
import org.ambar.core.commons.filters.QueryPredicate;
import org.ambar.core.dao.impl.CrudDAOImpl;

/**
 * <p>
 * Implementación de {@link ChequeDAO} que retorna los cheques propios emitidos.
 * </p>
 *
 * @author Sebastian
 *
 */
public class ChequePropioDAOImpl extends CrudDAOImpl<Long, Cheque> implements ChequeDAO {

	@Override
	public Cheque getById(Long pId) {
		QueryPredicate qp = new QueryPredicate();
		qp.appendToWhere("e.id = :id AND");
		qp.addParam("id", pId);
		FilteredList<Cheque> result = this.getFilteredList(qp);
		if (result.getRowCount() > 0) {
			return result.getFilteredList().get(0);
		} else {
			return null;
		}
	}

	@Override
	protected String getCustomWhereClause() {
		return "e.cobranza IS NULL";
	}
}
