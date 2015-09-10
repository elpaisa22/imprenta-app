/**
 * appl-frontend-javafx [14/01/2014 19:49:15]
 */
package org.ambar.appl.views.entities.crud.api;

import org.ambar.core.be.Persistible;
import org.ambar.core.dto.DTO;
import org.ambar.core.views.crud.api.AbstractABM;

/**
 * <p>
 * Insertar descripción funcional.
 * </p>
 *
 * @author Sebastian
 *
 */
public interface ClienteABM<K, D extends DTO<K>, T, E extends Persistible<T>> extends AbstractABM<K, D, T, E> {
}
