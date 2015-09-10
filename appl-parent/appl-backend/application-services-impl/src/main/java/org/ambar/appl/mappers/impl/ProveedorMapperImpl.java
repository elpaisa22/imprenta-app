/**
 * application-services-impl [23/05/2015 14:24:21]
 */
package org.ambar.appl.mappers.impl;

import org.ambar.appl.be.Proveedor;
import org.ambar.appl.be.Provincia;
import org.ambar.appl.be.ProvinciaID;
import org.ambar.appl.dao.ProvinciaDAO;
import org.ambar.appl.dto.ProveedorDTO;
import org.ambar.appl.mappers.ProveedorMapper;
import org.ambar.core.mappers.EntityMapperImpl;

/**
 * <p>
 * Implementación por default de {@link ProveedorMapper}.
 * </p>
 *
 * @author Sebastian
 *
 */
public class ProveedorMapperImpl
       extends EntityMapperImpl<Proveedor, ProveedorDTO>
       implements ProveedorMapper {

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
	public Proveedor mapFromB(ProveedorDTO pObject) {
		Proveedor aux = super.mapFromB(pObject);

		this.mapProvincia(aux, pObject.getIdProvincia());

		return aux;
	}

	/* (non-JSDoc)
	 * @see org.ambar.core.mappers.EntityMapperImpl#mapFromB(java.lang.Object, java.lang.Object)
	 */
	@Override
	public void mapFromB(ProveedorDTO pSourceObject, Proveedor pDestinationObject) {
		super.mapFromB(pSourceObject, pDestinationObject);

		this.mapProvincia(pDestinationObject, pSourceObject.getIdProvincia());
	}

	/**
	 * Mapea la provincia de Proveedor DTO a Proveedor BE.
	 * @param pAux Proveedor BE
	 * @param pIdProvincia ID de la provincia
	 */
	private void mapProvincia(Proveedor pAux, String pIdProvincia) {
		if (pAux != null && pAux.getPais() != null && pIdProvincia != null) {
			ProvinciaID provinciaID = new ProvinciaID(pIdProvincia, pAux.getPais());
			Provincia result = this.provinciaDAO.getById(provinciaID);
			pAux.setProvincia(result);
		}
	}

}
