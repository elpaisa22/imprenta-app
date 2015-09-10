/**
 * application-services-impl [28/04/2015 19:24:41]
 */
package org.ambar.appl.bo.impl;

import javax.transaction.Transactional;

import org.ambar.appl.be.NumeradorComprobante;
import org.ambar.appl.bo.NumeradorComprobanteBO;
import org.ambar.appl.commons.enums.TipoComprobanteValues;
import org.ambar.core.bo.impl.CrudBusinessObjectImpl;
import org.ambar.core.validation.configuration.Validation;
import org.ambar.core.validation.configuration.ValidationStrategy;
import org.ambar.core.validation.configuration.Validations;
import org.apache.commons.lang3.StringUtils;

/**
 * <p>Insertar descripción funcional.</p>
 * @author Sebastian
 * @see <<Insertar clases relacionadas>>
 */
@Validations(
		validations = {
				@Validation(
						transactionNames = { "insert" },
						validators = { "applicationHibernateValidators",
								       "numeradorComprobanteUniqueIdValidator"}
						),
				@Validation(
						transactionNames = { "update" },
						validators = { "applicationHibernateValidators" })
		},
		strategy = ValidationStrategy.CONTINUE
)
public class NumeradorComprobanteBOImpl
	   extends CrudBusinessObjectImpl<Long, NumeradorComprobante>
	   implements NumeradorComprobanteBO {

	private static final Long NUMEROFACTURAMAX = 99999999L;
	private static final int LONG_PREFIJO = 4;
	private static final int LONG_NUMERO = 8;

	@Override
	@Transactional
	public Long getNextNumber(TipoComprobanteValues pTipoComprobante) {
		Long id = Long.parseLong(pTipoComprobante.getValor());

		NumeradorComprobante elem = this.getById(id);
		if (elem == null) {
			NumeradorComprobante numeradorComprobante = new NumeradorComprobante();
			numeradorComprobante.setId(id);
			numeradorComprobante.setPrefijo(0L);
			numeradorComprobante.setNumero(1L);
			this.getDao().insert(numeradorComprobante);
            return this.calculateInvoiceNumber(numeradorComprobante.getPrefijo(), numeradorComprobante.getNumero());
		} else {
			Long number = elem.getNumero();
			if (number.equals(NUMEROFACTURAMAX)) {
				elem.setNumero(0L);
				elem.setPrefijo(elem.getPrefijo() + 1);
			} else {
				elem.setNumero(elem.getNumero() + 1);
			}

			this.getDao().update(elem);
			return this.calculateInvoiceNumber(elem.getPrefijo(), number);
		}
	}

	/**
	 * Calcula el numero de factura para el tipo de factura.
	 * @param pPrefix Prefijo Factura.
	 * @param pNumber Numero de Factura.
	 * @return {@link Long} Numero calculado
	 * */
	private Long calculateInvoiceNumber(Long pPrefix, Long pNumber) {
		String prefix = pPrefix.toString();
		String number = pNumber.toString();

		prefix = StringUtils.leftPad(prefix, LONG_PREFIJO, "0");
		number = StringUtils.leftPad(number, LONG_NUMERO, "0");

		String completeNumber = prefix + number;
		return Long.parseLong(completeNumber);
	}
}
