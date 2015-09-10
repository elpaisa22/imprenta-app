/**
 * appl-frontend-desktop [24/05/2012 16:56:05]
 */
package org.ambar.appl.components.navigation.api;

import org.ambar.appl.components.breadcrumb.AmbarTreeEntry;

/**
 * <p>
 * Define la interfaz de la clase encargada de administrar la navegacion de la aplicacion.
 * </p>
 *
 * @author Sebastian
 *
 */
public interface NavigationBean {

	/**
	 * Metodo que se dispara cuando una entidad es seleccionada desde el menu.
	 * @param pEntityId Entidad
	 * @param pTitle Titulo
	 * */
	void openEntity(String pEntityId, String pTitle);

	/**
	 * Editar la entidad.
	 * */
	void editEntity();

	/**
	 * Nueva entidad.
	 * */
	void newEntity();

	/**
	 * Eliminar entidad.
	 * */
	void deleteEntity();

	/**
	 * Abrir entidad.
	 * */
	void openEntity();

	/**
	 * Recarga la grilla.
	 * */
	void reloadGrid();

	/**
	 * Filtra la grilla con el campo de texto de busqueda.
	 * */
	void filterGridWithTextField();

	/**
	 * Limpia el filtro de busqueda.
	 * */
	void clearFilterGridWithTextField();

	/**
	 * Navega hacia una subentidad de la entidad actual.
	 * @param pAmbarTreeEntry Tree entry
	 * @param pIndex Indice del elemento del breadcrumb
	 * */
	void navigateToSubEntity(AmbarTreeEntry pAmbarTreeEntry, int pIndex);


}
