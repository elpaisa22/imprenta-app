package org.ambar.appl.components.tree;


import javax.swing.event.EventListenerList;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

/**
 *	Clase Model del JTree.
 *
 * @author Sebatian Ecclesia
 */
public class IconTreeModel implements TreeModel {

    private TreeEntry root;
    private EventListenerList listenerList = new EventListenerList();

    /**
     * Constructor por default.
     * */
	public IconTreeModel() {
        root = new TreeEntry("_ROOT_", null, null, null);
    }

	/**
     * Constructor donde se pasa la raiz por parametro.
     * @param pRoot Raiz del arbol
     * */
	public IconTreeModel(TreeEntry pRoot) {
        root = pRoot;
    }

	@Override
    public Object getRoot() {
       return root;
    }

    @Override
    public Object getChild(Object pParent, int pIndex) {
        return ((TreeEntry) pParent).get(pIndex);
    }

    @Override
    public int getChildCount(Object pParent) {
         return ((TreeEntry) pParent).count();
    }

    @Override
    public boolean isLeaf(Object pNode) {
        return ((TreeEntry) pNode).count() == 0;
    }

    @Override
    public void valueForPathChanged(TreePath pPath, Object pNewValue) {
        throw new UnsupportedOperationException("Not supported");
    }

    @Override
    public int getIndexOfChild(Object pParent, Object pChild) {
       return ((TreeEntry) pParent).indexOf(pChild);
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

