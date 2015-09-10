/**
 * appl-frontend-desktop [24/05/2012 18:24:16]
 */
package org.ambar.appl.components.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import org.ambar.appl.components.navigation.api.NavigationBean;

/**
 * <p>
 * Listener de eventos de los botones de Crud.
 * </p>
 *
 * @author Sebastian
 *
 */
public class AmbarCrudButtonsListener implements ActionListener {

	private NavigationBean navigationBean;

	/**
	 * @param pNavigationBean Establece el valor del atributo navigationBean.
	 */
	public void setNavigationBean(NavigationBean pNavigationBean) {
		navigationBean = pNavigationBean;
	}



	@Override
	public void actionPerformed(ActionEvent pEvent) {
		JButton source = (JButton) pEvent.getSource();

		if (source.getText() == "Eliminar") {
			navigationBean.deleteEntity();
		} else if (source.getText() == "Editar") {
			navigationBean.editEntity();
		} else if (source.getText() == "Nuevo") {
			navigationBean.newEntity();
		} else if (source.getText() == "Abrir") {
			navigationBean.openEntity();
		}

	}


}
