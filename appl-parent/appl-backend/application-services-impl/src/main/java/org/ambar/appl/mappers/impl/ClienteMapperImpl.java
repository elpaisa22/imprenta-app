/**
 * appl-cliente-services-impl [22/08/2011 22:35:58]
 */
package org.ambar.appl.mappers.impl;

import org.ambar.appl.be.Cliente;
import org.ambar.appl.be.Provincia;
import org.ambar.appl.be.ProvinciaID;
import org.ambar.appl.dao.ProvinciaDAO;
import org.ambar.appl.dto.ClienteDTO;
import org.ambar.appl.mappers.ClienteMapper;
import org.ambar.core.mappers.EntityMapperImpl;

/**
 * <p>
 * Implementación por default de {@link ClienteMapper}.
 * </p>
 *
 * @author Sebastian
 *
 */
public class ClienteMapperImpl extends EntityMapperImpl<Cliente, ClienteDTO> implements ClienteMapper {

	private ProvinciaDAO provinciaDAO;

	/**
	 * @param pProvinciaDAO Establece el valor del atributo provinciaDAO.
	 */
	public void setProvinciaDAO(ProvinciaDAO pProvinciaDAO) {
		provinciaDAO = pProvinciaDAO;
	}

	/* (non-JSDoc)
	 * @see org.ambar.core.mappers.EntityMapperImpl#mapFromB(java.lang.Object)
	 */
	@Override
	public Cliente mapFromB(ClienteDTO pObject) {
		Cliente aux = super.mapFromB(pObject);

		this.mapProvincia(aux, pObject.getIdProvincia());

		return aux;
	}

	/* (non-JSDoc)
	 * @see org.ambar.core.mappers.EntityMapperImpl#mapFromB(java.lang.Object, java.lang.Object)
	 */
	@Override
	public void mapFromB(ClienteDTO pSourceObject, Cliente pDestinationObject) {
		super.mapFromB(pSourceObject, pDestinationObject);

		this.mapProvincia(pDestinationObject, pSourceObject.getIdProvincia());
	}

	/**
	 * Mapea la provincia de Cliente DTO a Cliente BE.
	 * @param pAux Cliente BE
	 * @param pIdProvincia ID de la provincia
	 */
	private void mapProvincia(Cliente pAux, String pIdProvincia) {
		if (pAux != null && pAux.getPais() != null && pIdProvincia != null) {
			ProvinciaID provinciaID = new ProvinciaID(pIdProvincia, pAux.getPais());
			Provincia result = this.provinciaDAO.getById(provinciaID);
			pAux.setProvincia(result);
		}
	}

}
