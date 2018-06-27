/**
 * appl-frontend-web [22/08/2014 17:42:12]
 */
package org.ambar.appl.frontend.beans.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.ambar.core.be.Persistible;
import org.ambar.core.commons.context.RequestContext;
import org.ambar.core.commons.filters.Filter;
import org.ambar.core.commons.filters.FilteringContext;
import org.ambar.core.commons.filters.Pager;
import org.ambar.core.commons.filters.criteria.Criteria;
import org.ambar.core.commons.order.Order;
import org.ambar.core.commons.order.OrderType;
import org.ambar.core.dictionary.domain.entities.Entity;
import org.ambar.core.dictionary.services.DictionaryServices;
import org.ambar.core.dto.DTO;
import org.ambar.core.dto.results.ResultListDTO;
import org.ambar.core.services.DataServices;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

/**
 * <p>
 * Lazy Data Model.
 * </p>
 *
 * @author Sebastian
 *
 */
public class GenericLazyDataModel extends LazyDataModel<DTO<Object>> {

	private static final long serialVersionUID = 5536626997343046194L;

	private DictionaryServices dictionaryServices;

	private List<DTO<Object>> datasource;
	private Entity entity;
	private DataServices<Object, DTO<Object>, Object, Persistible<Object>> service;
	private Filter filter;

	private String textoBuscar;

	private RequestContext requestContext;

	/**
	 * @return Retorna el valor del atributo requestContext.
	 */
	public RequestContext getRequestContext() {
		return requestContext;
	}

	/**
	 * @param pRequestContext Establece el valor del atributo requestContext.
	 */
	public void setRequestContext(RequestContext pRequestContext) {
		requestContext = pRequestContext;
	}

	/**
	 * @param pDictionaryServices Establece el valor del atributo dictionaryServices.
	 */
	public void setDictionaryServices(DictionaryServices pDictionaryServices) {
		dictionaryServices = pDictionaryServices;
	}

	/**
	 * @return Retorna el valor del atributo filter.
	 */
	public Filter getFilter() {
		return filter;
	}

	/**
	 * @param pFilter Establece el valor del atributo filter.
	 */
	public void setFilter(Filter pFilter) {
		filter = pFilter;
	}

	/**
	 * @return Retorna el valor del atributo textoBuscar.
	 */
	public String getTextoBuscar() {
		return textoBuscar;
	}

	/**
	 * @param pTextoBuscar Establece el valor del atributo textoBuscar.
	 */
	public void setTextoBuscar(String pTextoBuscar) {
		textoBuscar = pTextoBuscar;
	}

	/**
	 * Se dispara cuando va a comenzar la navegacion con una entidad.
	 * @param pMetadata Entidad
	 * @param pService Servicio
	 * */
	public void startWithEntity(Entity pMetadata,
                                DataServices<Object, DTO<Object>, Object, Persistible<Object>> pService) {
		this.entity = pMetadata;
		this.service = pService;
	}

	@Override
    public DTO<Object> getRowData(String pRowKey) {
		if (datasource != null && datasource.size() > 0) {
			for (DTO<Object> dto : datasource) {
	            if (dto.getId().toString().equals(pRowKey)) {
	            	return dto;
	            }
	        }
		}

        return null;
    }

    @Override
    public Object getRowKey(DTO<Object> pDto) {
        return pDto.getId();
    }

    @Override
    public List<DTO<Object>> load(int pFirst,
    		                      int pPageSize,
    		                      String pSortField,
    		                      SortOrder pSortOrder,
    		                      Map<String, Object> pFilters) {

        FilteringContext filteringContext = new FilteringContext();
        Pager pager = new Pager();

        //filter
        if (pFilters.isEmpty() && this.textoBuscar != null && !"".equals(this.textoBuscar)) {
        	Filter globalFilter = this.dictionaryServices.getGlobalFilter(this.entity.getId(), this.textoBuscar);
        	if (this.filter != null) {
        		globalFilter = Criteria.createGroup().and(this.filter, globalFilter);
        	}
        	filteringContext.setFilter(globalFilter);
        } else if (pFilters.containsKey("globalFilter")) {
        	Filter globalFilter = this.dictionaryServices.getGlobalFilter(this.entity.getId(),
        			                                                      pFilters.get("globalFilter"));
        	if (this.filter != null) {
        		globalFilter = Criteria.createGroup().and(this.filter, globalFilter);
        	}
        	filteringContext.setFilter(globalFilter);
        } else if (this.filter != null) {
        	filteringContext.setFilter(filter);
        }

        //sort
        if (pSortField != null) {
        	String orderType = SortOrder.ASCENDING.equals(pSortOrder)
        			              ? OrderType.Asc.toString()
        			              : OrderType.Desc.toString();
        	Order order = new Order(pSortField, orderType);
        	pager.getOrderList().add(order);
        }

        //paginate
        pager.setPageSize(pPageSize);
        pager.setPage((pFirst / pPageSize) + 1);
        filteringContext.setPager(pager);

        ResultListDTO<DTO<Object>> result = this.service.getFilteredList(filteringContext, this.requestContext);

        //rowCount
        this.setRowCount(result.getCompleteListSize());


        this.datasource = result.getResultList();
        return this.datasource;
    }

    @Override
    public List<DTO<Object>> getWrappedData() {
    	if (this.datasource == null) {
    		return new ArrayList<DTO<Object>>();
    	}
       	return this.datasource;
    }

}
