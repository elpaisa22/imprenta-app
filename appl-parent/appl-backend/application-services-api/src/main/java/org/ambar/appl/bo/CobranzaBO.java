/**
 * application-services-api [6/11/2014 18:48:05]
 */
package org.ambar.appl.bo;

import java.util.List;

import org.ambar.appl.be.Cobranza;
import org.ambar.appl.be.Factura;
import org.ambar.core.bo.CrudBusinessObject;
import org.ambar.core.commons.context.RequestContext;
import org.ambar.core.exceptions.BusinessException;

/**
 * <p>
 * Interfaz que implementa el BO de Cobranza.
 * </p>
 *
 * @author Sebastian
 *
 */
public interface CobranzaBO extends CrudBusinessObject<Long, Cobranza> {

	/**
	 * <p>
	 * Guarda un Cobro al Contado.
	 * </p>
	 * @param pCobranza			Cobranza
	 * @param pFactura 			Factura
	 * @param pWarnings			Mensajes con de tipo "advertencia" devueltos por los validadores
	 * @param pRequestContext	Contexto de la petición
	 * @throws BusinessException Ante reglas de negocio no cumplidas o fallos en validaciones
	 */
	void guardarCobroContado(Cobranza pCobranza,
							 Factura pFactura,
			                 List<String> pWarnings,
			                 RequestContext pRequestContext) throws BusinessException;

}
