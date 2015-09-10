/**
 * appl-frontend-desktop [25/05/2012 21:47:18]
 */
package org.ambar.appl.components.abm.view.api;

import org.ambar.core.be.Persistible;
import org.ambar.core.dto.DTO;

/**
 * <p>
 * Interfaz base de los ABM.
 * </p>
 *
 * @param <K> ID del DTO
 * @param <D> DTO
 * @param <T> ID de la BE
 * @param <E> BE
 *
 *
 * @author Sebastian
 *
 */
public interface AbstractABM<K, D extends DTO<K>, T, E extends Persistible<T>> {

	/**
	 * Carga el DTO en la vista y abre el ABM.
	 * @param pDTO DTO
	 * @param pStateMode Modo de ABM
	 * */
	void open(DTO<K> pDTO, States pStateMode);

}
