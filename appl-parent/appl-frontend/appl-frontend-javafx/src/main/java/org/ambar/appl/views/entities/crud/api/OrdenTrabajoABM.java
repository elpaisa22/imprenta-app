/**
 * 
 */
package org.ambar.appl.views.entities.crud.api;

import org.ambar.core.be.Persistible;
import org.ambar.core.dto.DTO;
import org.ambar.core.views.crud.api.AbstractABM;

/**
 * @author Sebastian
 *
 */
public interface OrdenTrabajoABM<K, D extends DTO<K>, T, E extends Persistible<T>> extends AbstractABM<K, D, T, E> {

}
