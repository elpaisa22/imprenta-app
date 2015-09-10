/**
 * appl-frontend-desktop [24/05/2012 16:51:24]
 */
package org.ambar.appl.components.navigation.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import org.ambar.appl.components.abm.view.api.AbstractABM;
import org.ambar.appl.components.abm.view.api.States;
import org.ambar.appl.components.breadcrumb.AmbarBreadCrumb;
import org.ambar.appl.components.breadcrumb.AmbarTreeEntry;
import org.ambar.appl.components.breadcrumb.BreadCrumbNavigationItem;
import org.ambar.appl.components.navigation.api.NavigationBean;
import org.ambar.appl.components.table.AmbarTableColumnModel;
import org.ambar.appl.components.table.AmbarTableModel;
import org.ambar.appl.helpers.SpringHelper;
import org.ambar.core.be.Persistible;
import org.ambar.core.commons.context.RequestContext;
import org.ambar.core.commons.filters.Filter;
import org.ambar.core.commons.filters.FilteringContext;
import org.ambar.core.dictionary.domain.entities.Attribute;
import org.ambar.core.dictionary.domain.entities.Entity;
import org.ambar.core.dictionary.domain.navigation.EntityInfo;
import org.ambar.core.dictionary.services.DictionaryServices;
import org.ambar.core.dto.DTO;
import org.ambar.core.dto.results.ResultListDTO;
import org.ambar.core.services.CrudServices;
import org.ambar.core.services.DataServices;

/**
 * <p>
 * Clase encargada de la navegacion de la aplicacion.
 * </p>
 *
 * @author Sebastian
 *
 */
public class NavigationBeanImpl implements NavigationBean {

	private JTable table;
	private AmbarTableModel tableModel;
	private AmbarTableColumnModel tableColumnModel;
	private DictionaryServices dictionaryServices;
	private AmbarBreadCrumb ambarBreadCrumb;
	private RequestContext requestContext;

	private EntityInfo entityInfo = null;
	private DataServices<Object, DTO<Object>, Object, Persistible<Object>> activeServices;

	private DTO<Object> selectedDTO;
	private String rootTitle;

	private Integer lastBreadCrumbIndex;
	private Filter lastFilter;
	private String lastEntityId;
	private Map<Integer, BreadCrumbNavigationItem> navigationItems;

	private TableRowSorter<TableModel> sorter;
	private JTextField txtBuscar;

	/**
	 * Inicializa el Navigation Manager.
	 * */
	public void initialize() {
		sorter = new TableRowSorter<TableModel>(this.table.getModel());
        this.table.setRowSorter(sorter);
	}

	/**
	 * @param pTable Establece el valor del atributo table.
	 */
	public void setTable(JTable pTable) {
		table = pTable;
	}


	/**
	 * @param pTableModel Establece el valor del atributo tableModel.
	 */
	public void setTableModel(AmbarTableModel pTableModel) {
		tableModel = pTableModel;
	}


	/**
	 * @param pTableColumnModel Establece el valor del atributo tableColumnModel.
	 */
	public void setTableColumnModel(AmbarTableColumnModel pTableColumnModel) {
		tableColumnModel = pTableColumnModel;
	}


	/**
	 * @param pDictionaryServices Establece el valor del atributo dictionaryServices.
	 */
	public void setDictionaryServices(DictionaryServices pDictionaryServices) {
		dictionaryServices = pDictionaryServices;
	}


	/**
	 * @param pAmbarBreadCrumb Establece el valor del atributo ambarBreadCrumb.
	 */
	public void setAmbarBreadCrumb(AmbarBreadCrumb pAmbarBreadCrumb) {
		ambarBreadCrumb = pAmbarBreadCrumb;
	}


	/**
	 * @param pRequestContext Establece el valor del atributo requestContext.
	 */
	public void setRequestContext(RequestContext pRequestContext) {
		requestContext = pRequestContext;
	}


	/**
	 * @return Retorna el valor del atributo txtBuscar.
	 */
	public JTextField getTxtBuscar() {
		return txtBuscar;
	}

	/**
	 * @param pTxtBuscar Establece el valor del atributo txtBuscar.
	 */
	public void setTxtBuscar(JTextField pTxtBuscar) {
		txtBuscar = pTxtBuscar;
	}

	@Override
	public void openEntity(String pEntityId, String pTitle) {
		clearFilterGridWithTextField();
		rootTitle = pTitle;

		ambarBreadCrumb.loadBreadCrumbFromEntity(pEntityId, rootTitle);

		navigationItems = new HashMap<Integer, BreadCrumbNavigationItem>();
		lastBreadCrumbIndex = -1;

		selectedDTO = null;

		if (tableModel.getData() != null) {
			tableModel.getData().clear();
		}

		loadDataGrid(pEntityId, null);

		lastBreadCrumbIndex = 0;
		lastEntityId = pEntityId;
	}


	/**
	 * Carga la grilla.
	 * @param pEntityId Entity ID
	 * @param pFilter Filter
	 * */
	@SuppressWarnings("unchecked")
	private void loadDataGrid(String pEntityId, Filter pFilter) {

		entityInfo = this.dictionaryServices.getNavigationEntityInfoById(pEntityId);

		activeServices =
		(DataServices<Object, DTO<Object>, Object, Persistible<Object>>)
		SpringHelper.getContext().getBean(entityInfo.getService());

		FilteringContext filteringContext = null;
		if (pFilter != null) {
			filteringContext = new FilteringContext(pFilter, null);
			lastFilter = filteringContext.getFilter();
		} else {
			lastFilter = null;
		}
		lastEntityId = pEntityId;

		ResultListDTO<DTO<Object>> result =
                activeServices.getFilteredList(filteringContext, requestContext);


        List<Attribute> attributes = dictionaryServices.getEntityMetaDataById(pEntityId).getAttributes();
        tableColumnModel.setAttributes(attributes);
        Entity metadata = this.dictionaryServices.getEntityMetaDataById(pEntityId);

        tableModel.setData(result.getResultList(), metadata);

        if (table.getModel().getRowCount() > 0) {
			ListSelectionModel selectionModel = table.getSelectionModel();
			selectionModel.setSelectionInterval(0, 0);
		}

		table.doLayout();
	}


	@SuppressWarnings("unchecked")
	@Override
	public void editEntity() {
		if (updateSelected()) {
			AbstractABM<Object, DTO<Object>, Object, Persistible<Object>> view =
					(AbstractABM<Object, DTO<Object>, Object, Persistible<Object>>)
						SpringHelper.getContext().getBean(entityInfo.getCrud());
			view.open(selectedDTO, States.EDIT);
		}
	}


	@SuppressWarnings("unchecked")
	@Override
	public void newEntity() {
		if (updateNewSelected()) {
			AbstractABM<Object, DTO<Object>, Object, Persistible<Object>> view =
					(AbstractABM<Object, DTO<Object>, Object, Persistible<Object>>)
						SpringHelper.getContext().getBean(entityInfo.getCrud());
			view.open(selectedDTO, States.NEW);
		}
	}

	/**
	 * Verifica si hay una entidad seleccionada.
	 * @return Boolean True si todo esta bien
	 * */
	private boolean updateNewSelected() {
		if (entityInfo == null) {
            JOptionPane.showMessageDialog(null,
            		                      "Debe seleccionar una entidad.",
            		                      "Atención", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		return true;
	}


	@SuppressWarnings("unchecked")
	@Override
	public void deleteEntity() {
		if (updateSelected()) {
			if (JOptionPane.showConfirmDialog(null,
					"Realmente desea eliminar el registro?",
                    "Eliminar",
                    JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				CrudServices<Object, DTO<Object>, Object, Persistible<Object>> service =
						(CrudServices<Object, DTO<Object>, Object, Persistible<Object>>)
							SpringHelper.getContext().getBean(entityInfo.getService());
				service.remove(selectedDTO, requestContext);
			}
		}
	}


	@SuppressWarnings("unchecked")
	@Override
	public void openEntity() {
		if (updateSelected()) {
			AbstractABM<Object, DTO<Object>, Object, Persistible<Object>> view =
					(AbstractABM<Object, DTO<Object>, Object, Persistible<Object>>)
						SpringHelper.getContext().getBean(entityInfo.getCrud());
			view.open(selectedDTO, States.CONSULTANT);
		}
	}

	/**
	 * Actualiza el DTO seleccionado.
	 * @return Boolean True si todo esta bien
	 * */
	private boolean updateSelected() {
		if (entityInfo == null) {
            JOptionPane.showMessageDialog(null,
            		                      "Debe seleccionar una entidad.",
            		                      "Atención", JOptionPane.WARNING_MESSAGE);
			return false;
		} else {
			int rowIndex = table.getSelectedRow();
			if (rowIndex >= 0) {
				selectedDTO =
                      (DTO<Object>) tableModel.getData().get(table.convertRowIndexToModel(table.getSelectedRow()));
			} else {
                JOptionPane.showMessageDialog(null,
                		                      "Debe seleccionar un registro.",
                		                      "Atención", JOptionPane.WARNING_MESSAGE);
				return false;
			}
		}
		return true;
	}


	@Override
	public void reloadGrid() {
		int rowIndex = table.getSelectedRow();
		loadDataGrid(entityInfo.getId(), lastFilter);
		ListSelectionModel selectionModel =
				  table.getSelectionModel();
		selectionModel.setSelectionInterval(rowIndex, rowIndex);
	}


	@Override
	public void navigateToSubEntity(AmbarTreeEntry pAmbarTreeEntry, int pItemIndex) {
		if (lastBreadCrumbIndex != null
				&& lastBreadCrumbIndex != -1
				&& pItemIndex >= lastBreadCrumbIndex
				&& !lastEntityId.equals(pAmbarTreeEntry.getEntity())) {

			clearFilterGridWithTextField();

			guardarInfoNavegacion();

			if (updateSelected()) {
                Filter filter = dictionaryServices.expressionToFilter(pAmbarTreeEntry.getFiltro(), selectedDTO);
				loadDataGrid(pAmbarTreeEntry.getEntity(), filter);
				lastBreadCrumbIndex = pItemIndex;
			}
		} else if (lastBreadCrumbIndex != null
				&& lastBreadCrumbIndex != -1
				&& pItemIndex < lastBreadCrumbIndex
				&& !lastEntityId.equals(pAmbarTreeEntry.getEntity())) {

			clearFilterGridWithTextField();

			BreadCrumbNavigationItem breadCrumbNavigationItem = navigationItems.get(pItemIndex);
            loadDataGrid(breadCrumbNavigationItem.getIdEntity(), breadCrumbNavigationItem.getFilterCondition());
			ListSelectionModel selectionModel = table.getSelectionModel();

			selectionModel.setSelectionInterval(breadCrumbNavigationItem.getSelectedIndex(),
					                            breadCrumbNavigationItem.getSelectedIndex());
			lastBreadCrumbIndex = pItemIndex;
		}
	}

	/**
	 * Guarda informacion de la navegacion.
	 * */
	private void guardarInfoNavegacion() {
		BreadCrumbNavigationItem breadCrumbNavigationItem = new BreadCrumbNavigationItem();
		breadCrumbNavigationItem.setFilterCondition(lastFilter);
		breadCrumbNavigationItem.setIdEntity(entityInfo.getId());
		breadCrumbNavigationItem.setSelectedIndex(table.getSelectedRow());
		if (navigationItems.containsKey(lastBreadCrumbIndex)) {
			navigationItems.remove(lastBreadCrumbIndex);
		}
		navigationItems.put(lastBreadCrumbIndex, breadCrumbNavigationItem);
	}


	@Override
	public void filterGridWithTextField() {
		String text = txtBuscar.getText();
        if (text.length() == 0) {
          sorter.setRowFilter(null);
        } else {
          sorter.setRowFilter(RowFilter.regexFilter(text));
        }
	}

	@Override
	public void clearFilterGridWithTextField() {
		sorter.setRowFilter(null);
		txtBuscar.setText("");
	}


}
