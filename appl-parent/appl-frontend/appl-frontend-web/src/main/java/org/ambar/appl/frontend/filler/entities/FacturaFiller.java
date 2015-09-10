/**
 * appl-frontend-web [07/03/2014 20:17:59]
 */
package org.ambar.appl.frontend.filler.entities;

import org.ambar.appl.dto.ClienteDTO;
import org.ambar.appl.dto.FacturaDTO;
import org.ambar.appl.frontend.filler.EntityFiller;
import org.apache.commons.beanutils.PropertyUtils;

/**
 * <p>
 * Filler de Valor Factura.
 * </p>
 *
 * @author Sebastian
 *
 */
public class FacturaFiller extends EntityFiller {


	@Override
	protected void mapFromParent(Object pObjectDest, Object pObjectSource) {
		if (pObjectSource != null && !(pObjectSource instanceof FacturaDTO)) {

			super.mapFromParent(pObjectDest, pObjectSource);

			try {

				if (pObjectSource instanceof ClienteDTO) {
					Object sourceValue = PropertyUtils.getProperty(pObjectSource, "id");
		            if (sourceValue != null) {
		            	PropertyUtils.setProperty(pObjectDest, "idCliente", sourceValue);
		            }

		            sourceValue = PropertyUtils.getProperty(pObjectSource, "razonSocial");
		            if (sourceValue != null) {
		            	PropertyUtils.setProperty(pObjectDest, "razonSocialCliente", sourceValue);
		            }
				}

			} catch (Exception e) {
			}
		}
	}
}
