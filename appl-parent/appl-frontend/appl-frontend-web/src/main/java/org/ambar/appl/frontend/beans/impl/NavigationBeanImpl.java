/**
 * appl-frontend-web [7/4/2015 23:05:38]
 */
package org.ambar.appl.frontend.beans.impl;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.ambar.core.commons.filters.FilteringContext;
import org.ambar.core.commons.filters.Pager;

/**
 * <p>
 * Bean que ayuda en la navegacion de la aplicación.
 * </p>
 *
 * @author Sebastian
 *
 */
@ManagedBean (name="navigationBean")
@ViewScoped
public class NavigationBeanImpl implements Serializable {
	
	private static final long serialVersionUID = -6673029494848115455L;

	private static final String FILTERING_CONTEXT = "filteringContext";
	private static final String RELOAD = "reload";
	private static final String ACTUAL_PAGE="actualPage";
	
	public String pagerHandler(Integer page, Integer pageSize){
		
		Pager pager = new Pager();
		pager.setPage(page);
		pager.setPageSize(pageSize);
		
		FilteringContext filteringContext = (FilteringContext)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get(FILTERING_CONTEXT);
		
		if(null == filteringContext){
			filteringContext = new FilteringContext();
		}
		
		filteringContext.setPager(pager);
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put(FILTERING_CONTEXT, filteringContext);
		
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put(ACTUAL_PAGE, page);

		
		return RELOAD;
	}
}
