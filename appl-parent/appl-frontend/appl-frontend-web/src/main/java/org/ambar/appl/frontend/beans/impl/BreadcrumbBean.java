/**
 * appl-frontend-web [25/09/2012 19:34:01]
 */
package org.ambar.appl.frontend.beans.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.ambar.core.dictionary.domain.navigation.EntityInfo;
import org.ambar.core.dictionary.domain.navigation.SubEntity;
import org.ambar.core.dictionary.services.DictionaryServices;
import org.primefaces.event.MenuActionEvent;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.MenuItem;
import org.primefaces.model.menu.MenuModel;

/**
 * <p>
 * Bean que representa el breadcrumb y sus operaciones.
 * </p>
 *
 * @author Sebastian
 *
 */
public class BreadcrumbBean implements Serializable {

	private static final long serialVersionUID = -3926054110882476888L;

	private static final String LASTSELECTED = "lastSelected";
	private static final String TARGET = "target";
	private static final String ENTITYNAME = "entityName";
	private static final String FROM = "from";
	private static final String PARENT_SELECTED = "parentSelected";

	private String entitySelected;

	private DictionaryServices dictionaryServices;

	private MenuModel subentitiesModel;
	private MenuModel breadcrumbModel;

	private EntityInfo navInfo;

	private Map<String, MenuItem> itemsMap;
	private Map<String, Object> itemsMapSelected;
	private Map<String, Integer> itemsMapPos;
	private Map<Integer, String> itemsMapName;

	/**
	 * Constructor default.
	 */
	public BreadcrumbBean() {
		this.subentitiesModel = new DefaultMenuModel();
		this.breadcrumbModel = new DefaultMenuModel();

		this.itemsMap = new HashMap<String, MenuItem>();
		this.itemsMapPos = new HashMap<String, Integer>();
		this.itemsMapName = new HashMap<Integer, String>();
		this.itemsMapSelected = new HashMap<String, Object>();
	}

	/**
	 * @return Retorna el valor del atributo entitySelected.
	 */
	public String getEntitySelected() {
		return entitySelected;
	}

	/**
	 * @param pEntitySelected Establece el valor del atributo entitySelected.
	 */
	public void setEntitySelected(String pEntitySelected) {
		entitySelected = pEntitySelected;
	}

	/**
	 * @return Retorna el valor del atributo subentitiesModel.
	 */
	public MenuModel getSubentitiesModel() {
		return subentitiesModel;
	}


	/**
	 * @param pSubentitiesModel Establece el valor del atributo subentitiesModel.
	 */
	public void setSubentitiesModel(MenuModel pSubentitiesModel) {
		subentitiesModel = pSubentitiesModel;
	}


	/**
	 * @return Retorna el valor del atributo breadcrumbModel.
	 */
	public MenuModel getBreadcrumbModel() {
		return breadcrumbModel;
	}


	/**
	 * @param pBreadcrumbModel Establece el valor del atributo breadcrumbModel.
	 */
	public void setBreadcrumbModel(MenuModel pBreadcrumbModel) {
		breadcrumbModel = pBreadcrumbModel;
	}


	/**
	 * @param pDictionaryServices Establece el valor del atributo dictionaryServices.
	 */
	public void setDictionaryServices(DictionaryServices pDictionaryServices) {
		dictionaryServices = pDictionaryServices;
	}


	public void LoadFromParent(String pEntityId) {

		if (this.breadcrumbModel.getElements().size() > 0) {
			this.breadcrumbModel.getElements().clear();
		}

		if (this.itemsMap.size() > 0) {
			this.itemsMap.clear();
			this.itemsMapPos.clear();
			this.itemsMapName.clear();
			this.itemsMapSelected.clear();
		}

		loadRelations(pEntityId);

		//Carga el breadcrumb
		DefaultMenuItem menuItem = new DefaultMenuItem();

		menuItem.setUrl("mainFlow");
        menuItem.setTitle("Inicio");
        this.breadcrumbModel.addElement(menuItem);

        this.entitySelected = pEntityId;
	}

	/**
	 * TODO Insertar descripción funcional.
	 * @param pEntityId
	 */
	private void loadRelations(String pEntityId) {
		navInfo = this.dictionaryServices.getNavigationEntityInfoById(pEntityId);

		if (this.subentitiesModel.getElements().size() > 0) {
			this.subentitiesModel.getElements().clear();
		}

		//Carga las subentidades
		List<SubEntity> subentities = navInfo.getSubentities();
		if (subentities != null) {
			for (SubEntity subEntity : subentities) {

                EntityInfo subEntityInfo = dictionaryServices.getNavigationEntityInfoById(subEntity.getId());

	            DefaultMenuItem menuItem = new DefaultMenuItem();

	            menuItem.setParam("target", subEntityInfo.getCrud());
	            menuItem.setParam("entityName", subEntity.getId());
	            menuItem.setParam("from", "S");

	            //TODO : VER SI EN ALGUN MOMENTO NO ES NECESARIO PARA EL ID
	            menuItem.setId(new Integer(subentities.indexOf(subEntity)).toString());

	            menuItem.setCommand("#{breadcrumbBean.loadParams}");
	            menuItem.setOncomplete("redirectToSubRelation()");

	            menuItem.setValue(subEntity.getText());
	            if (subEntityInfo.getSmallImage() != null && subEntityInfo.getSmallImage() != "") {
	            	menuItem.setIcon(subEntityInfo.getSmallImage());
	            }

	            this.subentitiesModel.addElement(menuItem);
			}
		}

	}

	public void loadParams(ActionEvent event) {
		 MenuItem menuItem = ((MenuActionEvent) event).getMenuItem();
		 String target = menuItem.getParams().get("target").get(0);
		 String entityName = menuItem.getParams().get("entityName").get(0);
		 String from = menuItem.getParams().get("from").get(0);

		 FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put(TARGET, target);
		 FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put(ENTITYNAME, entityName);
		 FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put(FROM, from);
	}

	/**
	 * TODO Insertar descripción funcional 
	 * @param pEntityId
	 */
	public void newEntitySelected(String pEntityId, String pId, Object pSelectedDTO) {

		addNodeToBreadcrumb(pEntityId, pId, pSelectedDTO);

		loadRelations(pEntityId);

		if (pSelectedDTO != null) {
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put(PARENT_SELECTED, pSelectedDTO);
		}

		this.entitySelected = pEntityId;
	}

	/**
	 * TODO Insertar descripción funcional 
	 * @param pEntityId
	 */
	public void newEntitySelected(String pEntityId) {

		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put(LASTSELECTED, this.itemsMapSelected.get(pEntityId));

		deleteForwardItems(pEntityId);

		loadRelations(pEntityId);

		this.entitySelected = pEntityId;
	}

	/**
	 * TODO Insertar descripción funcional 
	 * @param pEntityId
	 */
	private void deleteForwardItems(String pEntityId) {
		int index = this.itemsMapPos.get(pEntityId);
		int size = this.breadcrumbModel.getElements().size();
		for (int i = index; i < size; i++) {

			String entity = this.itemsMapName.get(i);
			this.itemsMapName.remove(i);
			this.itemsMap.remove(entity);
			this.itemsMapPos.remove(entity);
			this.itemsMapSelected.remove(entity);

			this.breadcrumbModel.getElements().remove(index);
		}
	}

	/**
	 * TODO Insertar descripción funcional 
	 * @param pEntityId
	 * @param pId
	 * @param pSelectedDTO 
	 */
	private void addNodeToBreadcrumb(String pEntityId, String pId, Object pSelectedDTO) {

		//Carga el breadcrumb
        EntityInfo entity = dictionaryServices.getNavigationEntityInfoById(this.entitySelected);

        DefaultMenuItem menuItem = new DefaultMenuItem();

        menuItem.setValue(dictionaryServices.processParametersInTitle(entity.getBrowseTitle(), pSelectedDTO));

        menuItem.setParam("target", navInfo.getCrud());
        menuItem.setParam("entityName", navInfo.getId());
        menuItem.setParam("from", "B");

        //TODO : VER SI EN ALGUN MOMENTO NO ES NECESARIO PARA EL ID
        menuItem.setId(new Integer(this.breadcrumbModel.getElements().size()).toString());

        menuItem.setCommand("#{breadcrumbBean.loadParams}");
        menuItem.setOncomplete("redirectByBreadcrumb()");

        this.breadcrumbModel.addElement(menuItem);

        this.itemsMap.put(navInfo.getId(), menuItem);
        this.itemsMapPos.put(navInfo.getId(), this.itemsMap.size());

        this.itemsMapSelected.put(navInfo.getId(), pSelectedDTO);
        this.itemsMapName.put(this.itemsMap.size(), navInfo.getId());

	}

	public boolean subentitiesEnabled() {
		return this.subentitiesModel.getElements().size() > 0;
	}
	
	public boolean breadcrumbEnabled() {
		return this.breadcrumbModel.getElements().size() > 1;
	}
}
