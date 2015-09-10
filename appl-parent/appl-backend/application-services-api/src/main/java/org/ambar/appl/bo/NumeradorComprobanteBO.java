/**
 * application-services-api [28/04/2015 19:11:55]
 */
package org.ambar.appl.bo;

import org.ambar.appl.be.NumeradorComprobante;
import org.ambar.appl.commons.enums.TipoComprobanteValues;
import org.ambar.core.bo.CrudBusinessObject;

/**
 * <p>
 * Interfaz que implementa el BO de Numerador Comprobante.
 * </p>
 *
 * @author Sebastian
 *
 */
public interface NumeradorComprobanteBO extends CrudBusinessObject<Long, NumeradorComprobante> {

	/**
	 * Obtiene el siguiente numero para el comprobante y lo almacena.
	 * @param pTipoComprobante Tipo del Comprobante
	 * @return {@link Long} ID del Comprobante
	 * */
	Long getNextNumber(TipoComprobanteValues pTipoComprobante);
}
