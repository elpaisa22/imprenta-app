/**
 * application-services-impl [25/08/2012 17:11:49]
 */
package org.ambar.appl.dao.impl;

import org.ambar.appl.be.OrdenTrabajo;
import org.ambar.appl.be.Remito;
import org.ambar.appl.dao.RemitoDAO;
import org.ambar.core.dao.impl.CrudDAOImpl;

/**
 * <p>
 * Implementación de {@link RemitoDAO}.
 * </p>
 *
 * @author Sebastian
 *
 */
public class RemitoDAOImpl extends CrudDAOImpl<Long, Remito> implements RemitoDAO {

	/* (non-JSDoc)
	 * @see org.ambar.core.dao.impl.CrudDAOImpl#insert(org.ambar.core.be.Persistible)
	 */
	@Override
	public void insert(Remito pEntity) {
		super.insert(pEntity);
		for (OrdenTrabajo ordenTrabajo : pEntity.getColeccionOrdenesTrabajo()) {
			this.getEntityManager().merge(ordenTrabajo);
		}
	}


	/* (non-JSDoc)
	 * @see org.ambar.core.dao.impl.CrudDAOImpl#update(org.ambar.core.be.Persistible)
	 */
	@Override
	public void update(Remito pEntity) {
		super.update(pEntity);
		for (OrdenTrabajo ordenTrabajo : pEntity.getColeccionOrdenesTrabajo()) {
			this.getEntityManager().merge(ordenTrabajo);
		}
	}
}
