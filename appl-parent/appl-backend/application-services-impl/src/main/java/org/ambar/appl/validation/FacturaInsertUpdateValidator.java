/**
 * application-services-impl [26/1/2015 17:34:52]
 */
package org.ambar.appl.validation;

import java.math.BigDecimal;
import java.util.Locale;

import org.ambar.appl.be.Factura;
import org.ambar.appl.commons.enums.CondicionVentaValues;
import org.ambar.core.commons.messages.MessageService;
import org.ambar.core.exceptions.EntityCastException;
import org.ambar.core.validation.Validator;
import org.ambar.core.validation.results.ValidationResults;

/**
 * <p>
 * Validaciones para el Insert/Update de la factura.
 * </p>
 *
 * @author Sebastian
 *
 */
public class FacturaInsertUpdateValidator implements Validator {

	private MessageService messageService;

	/**
	 * @return Retorna el valor del atributo messageService.
	 */
	public MessageService getMessageService() {
		return messageService;
	}

	/**
	 * @param pMessageService Establece el valor del atributo messageService.
	 */
	public void setMessageService(final MessageService pMessageService) {
		messageService = pMessageService;
	}

	@Override
	public ValidationResults validate(Object pEntity, String[ ] pProfiles, Locale pLocale) {
		final ValidationResults validationResults = new ValidationResults();

		if (pEntity instanceof Factura) {
			final Factura factura = (Factura) pEntity;

			if (BigDecimal.ZERO.compareTo(factura.getImporteTotal()) >= 0) {
				validationResults.addErrorMessage(this.messageService.getMessage(
						"org.ambar.appl.Factura.ErrorImporteFactura",
						null,
						pLocale));
			} else if (factura.getCondicionVenta().equals(CondicionVentaValues.CONTADO)
					&& factura.getCobranza() == null) {
				validationResults.addErrorMessage(this.messageService.getMessage(
						"org.ambar.appl.Factura.ErrorFacturaContadoSinCobranza",
						null,
						pLocale));
			}

		} else {
			throw new EntityCastException(this.messageService.getMessage(
					"org.ambar.appl.Factura.ErrorCast",
					null,
					pLocale));
		}

		return validationResults;
	}
}
