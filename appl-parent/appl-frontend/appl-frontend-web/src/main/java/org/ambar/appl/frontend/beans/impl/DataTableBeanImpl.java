/**
 * appl-frontend-web [12/05/2012 17:33:41]
 */
package org.ambar.appl.frontend.beans.impl;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ambar.appl.frontend.beans.api.ColumnModel;
import org.ambar.appl.frontend.beans.api.DataTableBean;
import org.ambar.core.be.Persistible;
import org.ambar.core.commons.filters.Filter;
import org.ambar.core.commons.servicelocator.ServiceLocator;
import org.ambar.core.dictionary.domain.entities.Attribute;
import org.ambar.core.dictionary.domain.entities.DataType;
import org.ambar.core.dictionary.domain.entities.Entity;
import org.ambar.core.dictionary.domain.navigation.SubEntity;
import org.ambar.core.dictionary.services.DictionaryServices;
import org.ambar.core.dto.DTO;
import org.ambar.core.faces.converters.CustomDateTimeConverter;
import org.ambar.core.faces.converters.CustomIDFacturaConverter;
import org.ambar.core.faces.converters.CustomMoneyConverter;
import org.ambar.core.services.DataServices;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.primefaces.component.datatable.DataTable;

/**
 * <p>
 * Bean de manejo de datos desde los servicios con la grilla.
 * </p>
 * @author Sebastian
 *
 */
public class DataTableBeanImpl implements DataTableBean, Serializable {

	private static final long serialVersionUID = -3277899267769495627L;

	private ServiceLocator serviceLocator;

	private DictionaryServices dictionaryServices;

	private List<ColumnModel> columns;

	private String entityName;

	private String entityText;

	private Object selectedItem;

	private Map<String, DataTableContext> tableContextMap;

	private GenericLazyDataModel lazyDataModel;
	
	private DataTable dataTable;

	/**
	 * @return Retorna el valor del atributo lazyDataModel.
	 */
	public GenericLazyDataModel getLazyDataModel() {
		return lazyDataModel;
	}

	/**
	 * @param pLazyDataModel Establece el valor del atributo lazyDataModel.
	 */
	public void setLazyDataModel(GenericLazyDataModel pLazyDataModel) {
		lazyDataModel = pLazyDataModel;
	}

	/**
	 * Constructor por default.
	 * */
	public DataTableBeanImpl() {
		this.columns = new ArrayList<ColumnModel>();
		this.setSelectedItem(null);
		this.entityName = "";
		this.tableContextMap = new HashMap<String, DataTableContext>();
	}

	/**
	 * @param pServiceLocator Establece el valor del atributo serviceLocator.
	 */
	public void setServiceLocator(ServiceLocator pServiceLocator) {
		serviceLocator = pServiceLocator;
	}
	/**
	 * @param pDictionaryServices Establece el valor del atributo dictionaryServices.
	 */
	public void setDictionaryServices(DictionaryServices pDictionaryServices) {
		dictionaryServices = pDictionaryServices;
	}
	
	/**
	 * @return Retorna el valor del atributo selectedItem.
	 */
	public Object getSelectedItem() {
		return selectedItem;
	}

	/**
	 * @param pSelectedItem Establece el valor del atributo selectedItem.
	 */
	public void setSelectedItem(Object pSelectedItem) {
		this.selectedItem = pSelectedItem;
	}

	@Override
	public void loadData(String pEntity) {
		if (pEntity != null && pEntity != "" && !pEntity.equals(this.entityName)) {
			
			if (this.tableContextMap.containsKey(pEntity)) {
				DataTableContext dataTableContext = this.tableContextMap.get(pEntity);
				this.dataTable = dataTableContext.getDataTable();
				this.lazyDataModel.setFilter(dataTableContext.getPreviousFilter());
				this.lazyDataModel.setTextoBuscar(dataTableContext.getSearchText());
			} else {
				this.dataTable = new DataTable();
				this.lazyDataModel.setTextoBuscar("");
			}

			@SuppressWarnings("unchecked")
			DataServices<Object, DTO<Object>, Object, Persistible<Object>> service =
	             (DataServices<Object, DTO<Object>, Object, Persistible<Object>>)
	             					serviceLocator.getService(pEntity + "Services");
			Entity metadata = dictionaryServices.getEntityMetaDataById(pEntity);

			this.lazyDataModel.startWithEntity(metadata, service);

			this.setSelectedItem(null);
			this.entityName = pEntity;
		}
	}


	/**
	 * @return Retorna el valor del atributo data.
	 */
	@Override
	public List<DTO<Object>> getData() {
		return null;
	}

	@Override
	public List<ColumnModel> getColumns(String pEntity) {
		if (pEntity != null && pEntity != "") {
			Entity metadata = dictionaryServices.getEntityMetaDataById(pEntity);

			createColumnsFromMetaData(metadata);
		}
		return columns;
	}

	/**
	 * @return Retorna el valor del atributo columns.
	 */
	public List<ColumnModel> getColumns() {
		return columns;
	}


	/**
	 * @return Retorna el valor del atributo entityName.
	 */
	public String getEntityName() {
		return entityName;
	}

	/**
	 * @param pName Establece el valor del atributo entityName.
	 */
	public void setEntityName(String pName) {
		entityName = pName;
	}


	/**
	 * @return Retorna el valor del atributo entityText.
	 */
	public String getEntityText() {
		return entityText;
	}

	/**
	 * @param pEntityText Establece el valor del atributo entityText.
	 */
	public void setEntityText(String pEntityText) {
		entityText = pEntityText;
	}

	/**
	 * @return Retorna el valor del atributo dataTable.
	 */
	public DataTable getDataTable() {
		return dataTable;
	}

	/**
	 * @param pDataTable Establece el valor del atributo dataTable.
	 */
	public void setDataTable(DataTable pDataTable) {
		dataTable = pDataTable;
	}

	/**
	 * Crea las columnas a partir de la metadata de una entidad.
	 * @param pMetadata Metadata de la entidad
	 * */
	private void createColumnsFromMetaData(Entity pMetadata) {
		this.columns.clear();

		CustomMoneyConverter currencyConverter = new CustomMoneyConverter("$ ###,###,##0.00");
		CustomDateTimeConverter dateTimeConverter = new CustomDateTimeConverter();
		CustomIDFacturaConverter idFacturaConverter = new CustomIDFacturaConverter();

		List<Attribute> attributes = pMetadata.getAttributes();
		for (Attribute attribute : attributes) {
			if (attribute.getGridVisible() == null || attribute.getGridVisible()) {
				ColumnModel column = new ColumnModel(attribute.getVisibleName(), attribute.getId());
				if (attribute.getDataType().equals(DataType.DateTime)) {
					column.setConverter(dateTimeConverter);
				} else if (attribute.getDataType().equals(DataType.Money)) {
					column.setConverter(currencyConverter);
				} else if (!StringUtils.isEmpty(attribute.getConverter())) {
					if (attribute.getConverter().equals("idFacturaConverter")) {
						column.setConverter(idFacturaConverter);
					}
				}
				this.columns.add(column);
			}
		}
	}
	/**
	 * Obtiene el valor de una propiedad para un objecto.
	 * @param pObject Object
	 * @param pProp Propiedad
	 * @return {@link Object} Valor
	 * */
	public Object columnProperty(Object pObject, String pProp) {
    	try {
			return BeanUtils.getProperty(pObject, pProp);
		} catch (IllegalAccessException e) {
			return null;
		} catch (InvocationTargetException e) {
			return null;
		} catch (NoSuchMethodException e) {
			return null;
		}
    }

	/* (non-JSDoc)
	 * @see org.ambar.appl.frontend.beans.api.DataTableBean#goToRelation(org.ambar.core.dto.DTO, java.lang.String)
	 */
	@Override
	public void goToRelation(DTO<Object> pObject, String pEntity) {
		List<SubEntity> subentities = dictionaryServices.getSubEntitiesForEntity(entityName);
		String stringFilter = null;
		for (SubEntity subEntity : subentities) {
			if (subEntity.getId().equals(pEntity)) {
				stringFilter = subEntity.getFilterCondition();
				break;
			}
		}

		DataTableContext dataTableContext = new DataTableContext();
		dataTableContext.setDataTable(this.dataTable);
		dataTableContext.setPreviousFilter(this.lazyDataModel.getFilter());
		dataTableContext.setSearchText(this.lazyDataModel.getTextoBuscar());
		this.tableContextMap.put(this.entityName, dataTableContext);

		@SuppressWarnings("unchecked")
		DataServices<Object, DTO<Object>, Object, Persistible<Object>> service =
             (DataServices<Object, DTO<Object>, Object, Persistible<Object>>)
             					serviceLocator.getService(pEntity + "Services");
		Entity metadata = dictionaryServices.getEntityMetaDataById(pEntity);

		this.lazyDataModel.startWithEntity(metadata, service);

		Filter filtro = dictionaryServices.expressionToFilter(stringFilter, pObject);
		this.lazyDataModel.setFilter(filtro);
		this.lazyDataModel.setTextoBuscar("");
		this.dataTable = new DataTable();
	}

	/* (non-JSDoc)
	 * @see org.ambar.appl.frontend.beans.api.DataTableBean#initSession()
	 */
	@Override
	public void initSession() {
		this.tableContextMap.clear();
		this.lazyDataModel.setTextoBuscar("");
		this.lazyDataModel.setFilter(null);
		this.dataTable = new DataTable();
	}

}
