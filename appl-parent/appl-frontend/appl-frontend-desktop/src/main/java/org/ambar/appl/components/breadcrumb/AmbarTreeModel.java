/**
 * appl-frontend-desktop [09/06/2012 15:17:28]
 */
package org.ambar.appl.components.breadcrumb;

import javax.swing.event.EventListenerList;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;


/**
 * <p>
 * Insertar descripción funcional.
 * </p>
 *
 * @author Sebastian
 *
 *
 */
public class AmbarTreeModel implements TreeModel {
	private AmbarTreeEntry root;
    private EventListenerList listenerList = new EventListenerList();

	/**
     * Constructor donde se pasa la raiz por parametro.
     * @param pRoot Raiz del arbol
     * */
	public AmbarTreeModel(AmbarTreeEntry pRoot) {
        root = pRoot;
    }

	@Override
    public Object getRoot() {
       return root;
    }

    @Override
    public Object getChild(Object pParent, int pIndex) {
        return ((AmbarTreeEntry) pParent).get(pIndex);
    }

    @Override
    public int getChildCount(Object pParent) {
         return ((AmbarTreeEntry) pParent).count();
    }

    @Override
    public boolean isLeaf(Object pNode) {
        return ((AmbarTreeEntry) pNode).count() == 0;
    }

    @Override
    public void valueForPathChanged(TreePath pPath, Object pNewValue) {
        throw new UnsupportedOperationException("Not supported");
    }

    @Override
    public int getIndexOfChild(Object pParent, Object pChild) {
       return ((AmbarTreeEntry) pParent).indexOf(pChild);
    }

    @Override
    public void addTreeModelListener(TreeModelListener pTreeModelListener) {
       listenerList.add(TreeModelListener.class, pTreeModelListener);
    }

    @Override
    public void removeTreeModelListener(TreeModelListener pTreeModelListener) {
       listenerList.remove(TreeModelListener.class, pTreeModelListener);
    }


}


