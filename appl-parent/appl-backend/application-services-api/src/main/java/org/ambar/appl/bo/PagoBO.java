/**
 * application-services-api [8/6/2015 21:08:33]
 */
package org.ambar.appl.bo;

import java.util.List;

import org.ambar.appl.be.Compra;
import org.ambar.appl.be.Pago;
import org.ambar.core.bo.CrudBusinessObject;
import org.ambar.core.commons.context.RequestContext;
import org.ambar.core.exceptions.BusinessException;

/**
 * <p>
 * Interfaz que implementa el BO de Pago.
 * </p>
 *
 * @author Sebastian
 *
 * @see org.ambar.core.bo.CrudBusinessObject
 */
public interface PagoBO extends CrudBusinessObject<Long, Pago> {

	/**
	 * <p>
	 * Guarda un Pago al Contado de una Compra.
	 * </p>
	 * @param pPago				Pago
	 * @param pCompra 			Compra
	 * @param pWarnings			Mensajes con de tipo "advertencia" devueltos por los validadores
	 * @param pRequestContext	Contexto de la petición
	 * @throws BusinessException Ante reglas de negocio no cumplidas o fallos en validaciones
	 */
	void guardarCobroContado(Pago pPago, Compra pCompra, List<String> pWarnings, RequestContext pRequestContext)
	throws BusinessException;
}
