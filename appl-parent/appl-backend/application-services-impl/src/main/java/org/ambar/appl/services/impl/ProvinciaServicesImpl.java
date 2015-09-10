/**
 * application-services-impl [23/05/2015 14:33:34]
 */
package org.ambar.appl.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.ambar.appl.be.Provincia;
import org.ambar.appl.be.ProvinciaID;
import org.ambar.appl.bo.ProvinciaBO;
import org.ambar.appl.dto.ProvinciaDTO;
import org.ambar.appl.mappers.ProvinciaIDMapper;
import org.ambar.appl.services.ProvinciaServices;
import org.ambar.core.commons.context.RequestContext;
import org.ambar.core.commons.mapping.configuration.FieldMapping;
import org.ambar.core.dto.results.MessageKind;
import org.ambar.core.dto.results.MessageResult;
import org.ambar.core.dto.results.ResultListDTO;
import org.ambar.core.exceptions.InvalidMappingForFilterException;
import org.ambar.core.exceptions.SystemException;
import org.ambar.core.services.impl.CrudServiceDefaultImpl;
import org.dozer.MappingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>
 * Implementación por default de {@link ProvinciaServices}.
 * </p>
 *
 * @author Sebastian
 *
 */
public class ProvinciaServicesImpl
       extends CrudServiceDefaultImpl<ProvinciaDTO, ProvinciaDTO, ProvinciaID, Provincia>
       implements ProvinciaServices {

	private static final long serialVersionUID = -6098410115738967902L;

	private static final Logger LOG = LoggerFactory.getLogger(ProvinciaServicesImpl.class);

    private ProvinciaIDMapper provinciaIDMapper;

    /**
     * @param pProvinciaIDMapper Establece el valor del atributo provinciaIDMapper.
     */
    public void setProvinciaIDMapper(final ProvinciaIDMapper pProvinciaIDMapper) {
        provinciaIDMapper = pProvinciaIDMapper;
    }

	/*
	 * (non-JSDoc)
	 * @see com.inworx.foundation.services.impl.DataServicesDefaultImpl#getBussinessEntityId( java.lang.Object )
	 */
    @Override
    protected ProvinciaID getBussinessEntityId(final ProvinciaDTO pDTOId) {
        return this.provinciaIDMapper.mapFromB(pDTOId);
    }

    /* (non-JSDoc)
     * @see org.ambar.core.services.impl.DataServiceDefaultImpl#configureFieldsMappings(java.util.Set)
     */
    @Override
    protected void configureFieldsMappings(Set<FieldMapping> pFieldsMapping) {
    	FieldMapping fieldMapping;

		fieldMapping = new FieldMapping();
		fieldMapping.setFieldA("id.idProvincia");
		fieldMapping.setFieldB("idProvincia");
		fieldMapping.setQueryAlias("id.idProvincia");
		pFieldsMapping.add(fieldMapping);

		fieldMapping = new FieldMapping();
		fieldMapping.setFieldA("id.pais.id");
		fieldMapping.setFieldB("idPais");
		fieldMapping.setQueryAlias("id.pais.id");
		pFieldsMapping.add(fieldMapping);

		fieldMapping = new FieldMapping();
		fieldMapping.setFieldA("id.pais.descripcion");
		fieldMapping.setFieldB("descripcionPais");
		fieldMapping.setQueryAlias("id.pais.descripcion");
		pFieldsMapping.add(fieldMapping);

		super.configureFieldsMappings(pFieldsMapping);
    }

	/* (non-JSDoc)
	 * @see org.ambar.appl.services.ProvinciaServices#
	 * getByIdPais(java.lang.String, org.ambar.core.commons.context.RequestContext)
	 */
	@Override
	public ResultListDTO<ProvinciaDTO> getByIdPais(String pIdPais, RequestContext pRequestContext) {
		LOG.info("Ingreso a \"getByIdPais\"");
		LOG.debug("Parámetro pIdPais: {}", pIdPais);
		LOG.debug("Parámetro pRequestContext: {}", pRequestContext);

		List<MessageResult> messages = new ArrayList<MessageResult>();
		ResultListDTO<ProvinciaDTO> resultListDTO = new ResultListDTO<ProvinciaDTO>();
		MessageResult message = new MessageResult();
		message.setKind(MessageKind.Info);
		try {
			List<ProvinciaDTO> listDTOs = new ArrayList<ProvinciaDTO>();
			List<Provincia> listBEs;
			try {
				listBEs = ((ProvinciaBO) this.getBusinessObject()).getByIdPais(pIdPais);
			} catch (Exception e) {
				String errorMessage = this.getMessageService().getMessage(
						"org.ambar.core.be.entidad.getFilteredList.error.mapping",
						new Object[] {e.getMessage()},
						pRequestContext.getLocaleData());
				LOG.error(errorMessage, e);
				throw new InvalidMappingForFilterException(errorMessage, e);
			}

			if (listBEs != null && listBEs.size() > 0) {
				for (Provincia be : listBEs) {
					ProvinciaDTO dto = this.getEntityMapper().mapFromA(be);
					assertMapping(dto);
					assertInfoAuditoriaNotEmpty(dto);
					listDTOs.add(dto);
				}
				resultListDTO.setResultList(listDTOs);
				resultListDTO.setCompleteListSize(listDTOs.size());
				message.setMessage(this.getMessageService().getMessage(
						"org.ambar.core.be.entidad.getFilteredList.ok",
						null,
						pRequestContext.getLocaleData()));
			} else {
				message.setMessage(this.getMessageService().getMessage(
						"org.ambar.core.be.entidad.getFilteredList.noResults",
						null,
						pRequestContext.getLocaleData()));
			}

			messages.add(message);

		} catch (SystemException e) {
			LOG.warn("Excepciones controladas por el sistema: {}", e);
			MessageResult mr = new MessageResult(e.getMessage());
			mr.setKind(MessageKind.Error);
			messages.add(mr);
		} catch (MappingException e) {
			LOG.warn("Error en el mapeo de datos: {}", e);
			MessageResult mr = new MessageResult(e.getMessage());
			mr.setKind(MessageKind.Error);
			messages.add(mr);
		} catch (Exception e) {
			LOG.warn("Excepción no controlada: {}", e);
			MessageResult mr = new MessageResult(e.getMessage());
			mr.setKind(MessageKind.Error);
			messages.add(mr);
		}

		resultListDTO.setMessages(messages);

		LOG.debug("Valor de retorno: " + resultListDTO);
		LOG.info("Fin de \"getFilteredList\"");

		return resultListDTO;

	}
}
