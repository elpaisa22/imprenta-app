/**
 * application-services-api [23/05/2015 11:45:04]
 */
package org.ambar.appl.bo;

import java.util.List;

import org.ambar.appl.be.Provincia;
import org.ambar.appl.be.ProvinciaID;
import org.ambar.core.bo.CrudBusinessObject;

/**
 * <p>
 * Interfaz que implementa el BO de Provincia.
 * </p>
 *
 * @see org.ambar.core.bo.CrudBusinessObject
 *
 * @author Sebastian
 *
 */
public interface ProvinciaBO extends CrudBusinessObject<ProvinciaID, Provincia> {

	/**
	 * Retorna la lista de provincias para el pais que se recibe por parametro.
	 * @param pIdPais ID Pais
	 * @return {@link List} Provincias
	 * */
	List<Provincia> getByIdPais(String pIdPais);
}
