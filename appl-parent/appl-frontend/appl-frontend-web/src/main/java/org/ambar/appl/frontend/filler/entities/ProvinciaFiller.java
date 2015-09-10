/**
 * appl-frontend-web [23/05/2015 19:17:02]
 */
package org.ambar.appl.frontend.filler.entities;

import org.ambar.appl.dto.PaisDTO;
import org.ambar.appl.frontend.filler.EntityFiller;
import org.apache.commons.beanutils.PropertyUtils;

/**
 * <p>
 * Filler de Valor Provincia.
 * </p>
 *
 * @author Sebastian
 *
 */
public class ProvinciaFiller extends EntityFiller {


	@Override
	protected void mapFromParent(Object pObjectDest, Object pObjectSource) {

		if (pObjectSource != null) {

			super.mapFromParent(pObjectDest, pObjectSource);

			try {

				if (pObjectSource instanceof PaisDTO) {
					Object sourceValue = PropertyUtils.getProperty(pObjectSource, "id");
		            if (sourceValue != null) {
		            	PropertyUtils.setProperty(pObjectDest, "idPais", sourceValue);
		            }

		            sourceValue = PropertyUtils.getProperty(pObjectSource, "descripcion");
		            if (sourceValue != null) {
		            	PropertyUtils.setProperty(pObjectDest, "descripcionPais", sourceValue);
		            }
				}

			} catch (Exception e) {
			}
		}
	}
}
