/**
 * appl-frontend-web [13/05/2012 16:02:13]
 */
package org.ambar.appl.frontend.beans.api;

import java.util.List;

import org.ambar.core.dto.DTO;

/**
 * <p>
 * Interfaz que define las operaciones del bean que maneja los datos de la grilla.
 * </p>
 *
 * @author Sebastian
 *
 */
public interface DataTableBean {

	/**
	 * Inicia el TableBean.
	 * */
	void initSession();

	/**
	 * Carga los datos de la grilla.
	 *
	 * @param pEntity Entidad
	 */
	void loadData(String pEntity);

	/**
	 * Retorna los datos de la grilla.
	 *
	 * @return {@link List}<DTO<Object>> Datos.
	 */
	List<DTO<Object>> getData();

	/**
	 * Retorna las columnas de la grilla.
	 *
	 * @param pEntity Entidad
	 * @return {@link List}<ColumnModel> Columnas.
	 */
	List<ColumnModel> getColumns(String pEntity);

	/**
	 * Ir a una subentidad.
	 * @param pObject Objeto DTO
	 * @param pEntity Entidad relacionada
	 * */
	void goToRelation(DTO<Object> pObject, String pEntity);
}
