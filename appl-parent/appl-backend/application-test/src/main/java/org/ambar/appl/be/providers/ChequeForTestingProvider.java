/**
 * application-test [02/03/2013 14:59:31]
 */
package org.ambar.appl.be.providers;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

import org.ambar.appl.be.Cheque;
import org.ambar.core.be.EstadoTracking;
import org.ambar.core.be.TrackInfo;
import org.ambar.core.commons.filters.QueryPredicate;
import org.ambar.core.testing.basetests.providers.BusinessEntityForTestingProvider;
import org.ambar.core.testing.commons.ValidationPair;
import org.ambar.core.testing.commons.ValidationTouple;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>
 * Provider del Cheque BE.
 * </p>
 *
 * @author Sebastian
 *
 */
public class ChequeForTestingProvider extends BusinessEntityForTestingProvider<Long, Cheque> {

	@Autowired
	private ClienteForTestingProvider clienteProvider;

	/**
	 * @return Retorna el valor del atributo clienteProvider.
	 */
	public ClienteForTestingProvider getClienteProvider() {
		return clienteProvider;
	}

	/**
	 * @param pClienteProvider Establece el valor del atributo clienteProvider.
	 */
	public void setClienteProvider(ClienteForTestingProvider pClienteProvider) {
		clienteProvider = pClienteProvider;
	}

	@Override
	public Cheque createDefaultBussinessEntity() {
		Cheque cheque = new Cheque();

		cheque.setId(Long.valueOf("32233323"));
		cheque.setFecha(new Date());
		cheque.setMonto(BigDecimal.ONE);
		cheque.setCuenta("ARCOR SRL");
		cheque.setSucursal("SALTO");

		cheque.setTrackInfo(new TrackInfo());
		cheque.getTrackInfo().setEstado(EstadoTracking.Activo);
		cheque.getTrackInfo().setUsuario("USER_TEST");
		cheque.getTrackInfo().setFechaCreacion(new Date());
		cheque.getTrackInfo().setFechaModificacion(new Date());
		return cheque;
	}

	@Override
	public Cheque modifyBussinessEntity(Cheque pBussinessEntity) {
		return pBussinessEntity;
	}

	@Override
	public Cheque[ ] createBussinessEntitiesForFilter() {
		Cheque cheque = this.createDefaultBussinessEntity();
		cheque.setMonto(new BigDecimal("299.99"));

		Cheque[] cheques = {cheque};

		return cheques;
	}

	@Override
	public QueryPredicate createQueryPredicate() {
		QueryPredicate qPredicate = new QueryPredicate();
        qPredicate.appendToWhere("monto = 299.99");

		return qPredicate;
	}

	@Override
	public int filteredListResult() {
		return 1;
	}

	@Override
	public Map<String, ValidationPair<Cheque>[ ]> createBussinessEntitiesForValidation() {
		return null;
	}

	@Override
	public ValidationTouple[ ] createBussinessEntitiesForValidationByValidator() {
		return null;
	}
}
