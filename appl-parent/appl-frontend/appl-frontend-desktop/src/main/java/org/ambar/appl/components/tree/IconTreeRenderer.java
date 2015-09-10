package org.ambar.appl.components.tree;
import java.awt.Component;

import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellRenderer;

/**
*
* @author Sebatian Ecclesia
*/
public class IconTreeRenderer extends DefaultTreeCellRenderer {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

    @Override
	public Component getTreeCellRendererComponent(JTree pTree,
    		                                      Object pValue,
    		                                      boolean pSel,
    		                                      boolean pExpanded,
    		                                      boolean pLeaf,
    		                                      int pRow,
    		                                      boolean pHasFocus) {

    	super.getTreeCellRendererComponent(pTree, pValue, pSel, pExpanded, pLeaf, pRow, pHasFocus);
    	TreeEntry treeEntry = (TreeEntry) pValue;

        this.setText(treeEntry.getTitle());
        this.setIcon(treeEntry.getIcon());

        return this;
    }
}
