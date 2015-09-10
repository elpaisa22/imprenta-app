/**
 * appl-frontend-web [12/05/2012 14:43:40]
 */
package org.ambar.appl.frontend.beans.impl;

import java.io.Serializable;
import java.util.List;

import org.ambar.core.dictionary.domain.navigation.EntityInfo;
import org.ambar.core.dictionary.domain.navigation.Item;
import org.ambar.core.dictionary.domain.navigation.Module;
import org.ambar.core.dictionary.services.DictionaryServices;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

/**
 * <p>
 * Implementacion del bean encargado de crear los menues.
 * </p>
 *
 * @author Sebastian
 *
 */
public class MenuBean implements Serializable {

	private static final long serialVersionUID = 7466533500243946782L;

	private DictionaryServices dictionaryServices;

	private MenuModel model = null;

	/**
	 * @return Retorna el valor del atributo dictionaryServices.
	 */
	public DictionaryServices getDictionaryServices() {
		return dictionaryServices;
	}

	/**
	 * @param pDictionaryServices Establece el valor del atributo dictionaryServices.
	 */
	public void setDictionaryServices(DictionaryServices pDictionaryServices) {
		dictionaryServices = pDictionaryServices;
	}

	/**
	 * Inicializa el menu.
	 * */
	public void init() {
		this.model = new DefaultMenuModel();
		List<Module> menues = this.getDictionaryServices().getAllModules();
		for (Module module : menues) {
			DefaultSubMenu submenuModule = new DefaultSubMenu();
			submenuModule.setLabel(module.getText());
			submenuModule.setId("submenu_" + module.getId());
			List<Item> items = module.getItems();
			if (items != null && items.size() > 0) {
				for (Item item : items) {
                    EntityInfo entityInfo = dictionaryServices.getNavigationEntityInfoById(item.getId());

                    DefaultMenuItem menuItem = new DefaultMenuItem();

                    menuItem.setValue(item.getText());

                    if (item.getTargetState() == null || item.getTargetState().equals("")) {
                    	menuItem.setUrl(entityInfo.getCrud() + "?entity=" + item.getId()
	                             + "&from=M"
	                             + "&toState=listaState");
                    } else {
                    	menuItem.setUrl(entityInfo.getCrud() + "?entity=" + item.getId()
	                             + "&from=M"
	                             + "&toState=" + item.getTargetState());
                    }

                    EntityInfo navigationInfo = dictionaryServices.getNavigationEntityInfoById(item.getId());
                    if (navigationInfo.getSmallImage() != null && navigationInfo.getSmallImage() != "") {
                    	menuItem.setIcon(navigationInfo.getSmallImage());
                    }
                    menuItem.setId("menuitem_" + module.getId() + "_" + item.getId());

                    submenuModule.addElement(menuItem);

				}
				this.model.addElement(submenuModule);
			}
		}
	}

	/**
	 * @return Retorna el valor del atributo model.
	 */
	public MenuModel getModel() {
		return model;
	}

	/**
	 * @param pModel Establece el valor del atributo model.
	 */
	public void setModel(MenuModel pModel) {
		model = pModel;
	}


}
