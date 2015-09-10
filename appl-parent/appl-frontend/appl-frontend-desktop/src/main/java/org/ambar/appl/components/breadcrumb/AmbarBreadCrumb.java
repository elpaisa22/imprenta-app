/**
 * appl-frontend-desktop [09/06/2012 14:35:13]
 */
package org.ambar.appl.components.breadcrumb;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import org.ambar.appl.components.navigation.api.NavigationBean;
import org.ambar.appl.main.MainView;
import org.ambar.core.dictionary.domain.navigation.EntityInfo;
import org.ambar.core.dictionary.domain.navigation.SubEntity;
import org.ambar.core.dictionary.services.DictionaryServices;
import org.pushingpixels.flamingo.api.bcb.BreadcrumbBarModel;
import org.pushingpixels.flamingo.api.bcb.BreadcrumbItem;
import org.pushingpixels.flamingo.api.bcb.BreadcrumbPathEvent;
import org.pushingpixels.flamingo.api.bcb.BreadcrumbPathListener;
import org.pushingpixels.flamingo.api.bcb.core.BreadcrumbTreeAdapterSelector;

/**
 * <p>
 * BreadCrumb Ambar.
 * </p>
 *
 *
 * @author Sebastian
 *
 */
public class AmbarBreadCrumb extends JPanel {

	private static final long serialVersionUID = 4152642463139861000L;

	private BreadcrumbTreeAdapterSelector bar;

	private DictionaryServices dictionaryServices;

	private NavigationBean navigationBean;

	private Boolean nuevo = true;


	/**
	 * @param pDictionaryServices Establece el valor del atributo dictionaryServices.
	 */
	public void setDictionaryServices(DictionaryServices pDictionaryServices) {
		dictionaryServices = pDictionaryServices;
	}


	/**
	 * @param pNavigationBean Establece el valor del atributo navigationBean.
	 */
	public void setNavigationBean(NavigationBean pNavigationBean) {
		navigationBean = pNavigationBean;
	}


	/**
	 * @return Retorna el valor del atributo nuevo.
	 */
	public Boolean getNuevo() {
		return nuevo;
	}


	/**
	 * @param pNuevo Establece el valor del atributo nuevo.
	 */
	public void setNuevo(Boolean pNuevo) {
		nuevo = pNuevo;
	}


	/**
	 * Carga el BreadCrumb a partir de una Entidad.
	 * @param pEntityId Entity Id
	 * @param pText Titulo
	 * */
	public void loadBreadCrumbFromEntity(String pEntityId, String pText) {

		AmbarTreeEntry treeRoot = loadTreeFromRoot(pEntityId, pText);

		if (this.bar != null) {
			this.remove(this.bar);
		}

		this.bar = new BreadcrumbTreeAdapterSelector(new AmbarTreeModel(
				treeRoot), new BreadcrumbTreeAdapterSelector.TreeAdapter() {
			@Override
			public String toString(Object pNode) {
				AmbarTreeEntry n = (AmbarTreeEntry) pNode;
				return n.getTitle();
			}

			@Override
			public Icon getIcon(Object pNode) {
				AmbarTreeEntry n = (AmbarTreeEntry) pNode;
				return n.getIcon();
			}
		}, true);

		setNuevo(true);

		this.bar.getModel().addPathListener(new BreadcrumbPathListener() {
			@Override
			public void breadcrumbPathEvent(BreadcrumbPathEvent pEvent) {
				if (!getNuevo()) {
					@SuppressWarnings("unchecked")
                    BreadcrumbBarModel<Object> model = (BreadcrumbBarModel<Object>) pEvent.getSource();
					BreadcrumbItem<Object> item =  model.getItem(model.getItemCount() - 1);
					AmbarTreeEntry ambarTreeEntry = (AmbarTreeEntry) item.getData();
					navigationBean.navigateToSubEntity(ambarTreeEntry, model.getItemCount() - 1);
					System.out.println("Item seleccionado: " + ambarTreeEntry.getTitle());
				}
			}
		});


		BreadcrumbItem<Object> item = new BreadcrumbItem<Object>(treeRoot.getTitle(), treeRoot);
		item.setIcon(treeRoot.getIcon());
		List<BreadcrumbItem<Object>> items = new ArrayList<BreadcrumbItem<Object>>();
		items.add(item);
		this.bar.setPath(items);

		this.setLayout(new BorderLayout());
		this.add(bar, BorderLayout.NORTH);

		setNuevo(false);
	}

	private AmbarTreeEntry loadTreeFromRoot(String pEntityId, String pText) {
		EntityInfo entityInfo = dictionaryServices.getNavigationEntityInfoById(pEntityId);
		AmbarTreeEntry baseEntry = loadRoot(entityInfo, pText);
		List<SubEntity> subentities = entityInfo.getSubentities();
		if (subentities != null && subentities.size() > 0) {
			for (SubEntity subEntity : subentities) {
				loadSubEntities(baseEntry, subEntity);
			}
		}
		return baseEntry;
	}


	private void loadSubEntities(AmbarTreeEntry pBaseEntry, SubEntity pSubEntity) {

		EntityInfo entityInfo = dictionaryServices.getNavigationEntityInfoById(pSubEntity.getId());
		ImageIcon icon = new ImageIcon(MainView.class.getResource(entityInfo.getSmallImage()));

		AmbarTreeEntry newEntry =
				new AmbarTreeEntry(pSubEntity.getText(),
						           icon,
						           pSubEntity.getFilterCondition(),
						           pSubEntity.getId(),
						           pBaseEntry);

		List<SubEntity> subentities = entityInfo.getSubentities();
		if (subentities != null && subentities.size() > 0) {
			for (SubEntity subEntity : subentities) {
				loadSubEntities(newEntry, subEntity);
			}
		} else {
			newEntry.add(new AmbarTreeEntry()); //Entry dummy solo para que muestre al parent
		}
		pBaseEntry.add(newEntry);
	}


	private AmbarTreeEntry loadRoot(EntityInfo pEntityInfo, String pText) {
		ImageIcon icon = new ImageIcon(MainView.class.getResource(pEntityInfo.getSmallImage()));
		return new AmbarTreeEntry(pText, icon, null, pEntityInfo.getId(), null);
	}
}
