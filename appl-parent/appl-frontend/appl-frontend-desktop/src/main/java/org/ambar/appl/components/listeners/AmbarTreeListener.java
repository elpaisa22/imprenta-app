/**
 * appl-frontend-desktop [24/04/2012 18:09:58]
 */
package org.ambar.appl.components.listeners;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JTree;
import javax.swing.tree.TreePath;

import org.ambar.appl.components.navigation.api.NavigationBean;
import org.ambar.appl.components.tree.TreeEntry;

/**
 * <p>
 * Listener del Tree que se genera dentro del accordion.
 * </p>
 * @author Sebastian
 *
 */
public class AmbarTreeListener implements MouseListener {

	private NavigationBean navigationBean;

	/**
	 * @param pNavigationBean Establece el valor del atributo navigationBean.
	 */
	public void setNavigationBean(NavigationBean pNavigationBean) {
		navigationBean = pNavigationBean;
	}

	@Override
	public void mouseClicked(MouseEvent pE) {
	}

	@Override
	public void mousePressed(MouseEvent pEvent) {

		try {
			JTree tree = (JTree) pEvent.getSource();

			TreePath path = tree.getSelectionPaths()[0];
			Object[] nodes = path.getPath();

			TreeEntry node = (TreeEntry) nodes[nodes.length - 1];

			navigationBean.openEntity(node.getEntity(), node.getTitle());

		} catch (Exception e) {

		}
	}

	@Override
	public void mouseReleased(MouseEvent pE) {
	}

	@Override
	public void mouseEntered(MouseEvent pE) {
	}

	@Override
	public void mouseExited(MouseEvent pE) {
	}

}
