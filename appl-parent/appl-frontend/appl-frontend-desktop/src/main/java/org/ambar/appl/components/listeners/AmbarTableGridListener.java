/**
 * appl-frontend-desktop [27/05/2012 16:27:17]
 */
package org.ambar.appl.components.listeners;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import org.ambar.appl.components.navigation.api.NavigationBean;


/**
 * <p>
 * Listener de la grilla principal.
 * </p>
 *
 * @author Sebastian
 *
 */
public class AmbarTableGridListener extends MouseAdapter {
	private NavigationBean navigationBean;

	/**
	 * @param pNavigationBean Establece el valor del atributo navigationBean.
	 */
	public void setNavigationBean(NavigationBean pNavigationBean) {
		navigationBean = pNavigationBean;
	}

	@Override
	public void mouseClicked(MouseEvent pEvent) {
		if (pEvent.getClickCount() == 2) {
			navigationBean.openEntity();
		}
	}
}

