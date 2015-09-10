/**
 * appl-frontend-web [07/03/2014 19:36:12]
 */
package org.ambar.appl.frontend.filler;

import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

/**
 * <p>
 * Clase encargada de mapear las propiedades desde un DTO padre.
 * </p>
 *
 * @author Sebastian
 *
 */
public class EntityFiller {

	/**
	 * Mapea las propiedades del objeto pObjectSource al objeto pObjectDest.
	 * @param pObjectDest Destino
	 * @param pObjectSource Fuente
	 * */
	protected void mapFromParent(Object pObjectDest, Object pObjectSource) {

		if (pObjectDest != null && pObjectSource != null) {


			try {
				@SuppressWarnings("unchecked")
				Map<String, Object> properties = BeanUtils.describe(pObjectDest);

				Iterator<String> iterator = properties.keySet().iterator();
				while (iterator.hasNext()) {

					String propertyName = iterator.next();

					if (!propertyName.equalsIgnoreCase("trackInfo")
							&& !propertyName.equalsIgnoreCase("id")
							&& !propertyName.equalsIgnoreCase("descripcion")
							&& !propertyName.equalsIgnoreCase("version")
							&& !propertyName.equalsIgnoreCase("serialVersionUID")) {

						try {

                            String sourceValue = BeanUtils.getProperty(pObjectSource, propertyName);
                            if (sourceValue != null) {
                            	String destValue = BeanUtils.getProperty(pObjectDest, propertyName);
                            	if (destValue == null) {
                            		BeanUtils.setProperty(pObjectDest, propertyName, sourceValue);
                            	}

                            }

						} catch (IllegalAccessException e) {

						} catch (InvocationTargetException e) {

						} catch (NoSuchMethodException e) {

						}


					}
				}


			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			} catch (InvocationTargetException e1) {
				e1.printStackTrace();
			} catch (NoSuchMethodException e1) {
				e1.printStackTrace();
			}

		}

	}

	/**
	 * Mapea las propiedades del objeto pObjectSource al objeto pObjectDest.
	 * @param pObjectDest Destino
	 * @param pObjectSource Fuente
	 * @return {@link Object} Retorna el objeto con las propiedades cargadas
	 * */
	public Object fillEntityFromParent(Object pObjectDest, Object pObjectSource) {

		this.mapFromParent(pObjectDest, pObjectSource);

		return pObjectDest;
	}
}
