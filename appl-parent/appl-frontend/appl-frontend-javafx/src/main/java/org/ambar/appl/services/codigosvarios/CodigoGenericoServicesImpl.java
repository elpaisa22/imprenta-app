/**
 * appl-frontend-javafx [06/05/2014 19:28:51]
 */
package org.ambar.appl.services.codigosvarios;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Set;

import org.ambar.appl.dto.ValorCodigosVariosDTO;
import org.ambar.appl.services.impl.ValorCodigosVariosServicesImpl;
import org.ambar.core.commons.context.RequestContext;
import org.ambar.core.commons.filters.Filter;
import org.ambar.core.commons.filters.FilteringContext;
import org.ambar.core.commons.filters.criteria.Criteria;
import org.ambar.core.commons.filters.helpers.FilterExpressionBuilderEx;
import org.ambar.core.commons.mapping.configuration.FieldMapping;
import org.ambar.core.dto.results.ResultListDTO;
import org.ambar.core.dto.results.ResultObjectDTO;

/**
 * <p>Insertar descripción funcional.</p>
 * @author Sebastian
 * @see <<Insertar clases relacionadas>>
 */
public class CodigoGenericoServicesImpl
    extends ValorCodigosVariosServicesImpl {

	private static final long serialVersionUID = -3870067917034561878L;

	private String tipoCodigo;

	/**
	 * @return Retorna el valor del atributo tipoCodigo.
	 */
	public String getTipoCodigo() {
		return tipoCodigo;
	}

	/**
	 * @param pTipoCodigo Establece el valor del atributo tipoCodigo.
	 */
	public void setTipoCodigo(String pTipoCodigo) {
		tipoCodigo = pTipoCodigo;
	}

	@Override
	public ResultObjectDTO<ValorCodigosVariosDTO> getById(ValorCodigosVariosDTO pId,
			                                              RequestContext pRequestContext) {

		if (pId == null) {
			pId = new ValorCodigosVariosDTO();
		}

		pId.setIdTipoCodigo(tipoCodigo);

		return super.getById(pId, pRequestContext);
	}

	@Override
	public ResultListDTO<ValorCodigosVariosDTO> getFilteredList(FilteringContext pFilteringContext,
			                                                    RequestContext pRequestContext) {

		Filter filter = Criteria.createBinary().property("idTipoCodigo").equalTo(this.tipoCodigo);

		if (pFilteringContext.getFilter() != null) {
			filter = Criteria.createGroup().and(filter, pFilteringContext.getFilter());
		}

		pFilteringContext.setFilter(filter);

		return super.getFilteredList(pFilteringContext, pRequestContext);
	}

	/**
     * Método que se usará para obtener el helper que resuelve las expresiones
     * de filtros dinámicos.
     * @return {@link FilterExpressionBuilderEx}
     */
	@Override
    protected FilterExpressionBuilderEx createFilterExpressionBuilder() {
        final Type aRawType = ((ParameterizedType)
                super.getClass().getSuperclass().getGenericSuperclass()).getActualTypeArguments()[1];
        Class<?> dtoClass = (Class<?>) aRawType;

        final Type bRawType = ((ParameterizedType)
                super.getClass().getSuperclass().getGenericSuperclass()).getActualTypeArguments()[3];
        Class<?> beClass = (Class<?>) bRawType;

        FilterExpressionBuilderEx expressionBuilder =
                (FilterExpressionBuilderEx) this.getServiceLocator().getService(this.getExpressionBuilderBeanName());

        Set<FieldMapping> fields = this.getMappingConfiguration().fieldsFromClassMapping(
                beClass.getName(),
                dtoClass.getName());
        configureFieldsMappings(fields);
        expressionBuilder.setMappings(fields);

        return expressionBuilder;
    }


}
