/**
 * application-services-api [23/05/2015 11:49:47]
 */
package org.ambar.appl.dao;

import java.util.List;

import org.ambar.appl.be.Provincia;
import org.ambar.appl.be.ProvinciaID;
import org.ambar.core.dao.CrudDAO;

/**
 * <p>
 * Interfaz que implementa el DAO de Provincia.
 * </p>
 *
 * @author Sebastian
 *
 * @see org.ambar.core.dao.DataDAO
 */
public interface ProvinciaDAO extends CrudDAO<ProvinciaID, Provincia> {

	/**
	 * Retorna la lista de provincias para el pais que se recibe por parametro.
	 * @param pIdPais ID Pais
	 * @return {@link List} Provincias
	 * */
	List<Provincia> getByIdPais(String pIdPais);
}
