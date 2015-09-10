/**
 * appl-frontend-desktop [19/04/2012 22:48:57]
 */
package org.ambar.appl.components.accordion;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.GradientPaint;
import java.awt.Paint;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;

/**
 * Clase que representa un elemento raiz del accordion.
 *
 * @author Sebastian
 * */
public class AccordionRootItem extends AccordionItem {

    /**
	 *
	 */
	private static final long serialVersionUID = -5668725290182790249L;

	private AccordionBranch branchPanel;

    /**
     * Simple constructor. Create a void JPanel, it will contains menu leafs.
     * @param pText Title of menu.
     */
    public AccordionRootItem(String pText) {
        super(pText);
        this.branchPanel = new AccordionBranch();
    }

    /**
     * Sets default mouse events. Show <code>HAND_CURSOR</code> when mouse is over.
     * @return {@link MouseAdapter} object.
     */
    @Override
    public MouseAdapter getDefaultMouseActions() {
        return new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent pEvent) {
                setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }
        };
    }

    /**
     * Creates a {@link GradientPaint} surface for background; 3D effect for menu item.
     * @return {@link Paint} Paint
     */
    @Override
    public Paint getDefaultBackgroundPaint() {
        Color c1, c2;
        if (isSelected()) {
            c2 = getBackground();
            c1 = c2.darker();
        } else {
            c1 = getBackground();
            c2 = c1.darker();
        }
        return new GradientPaint(0, 0, c1, 0, getHeight(), c2);
    }

    /**
     *
     * @return JPanel object that is leaf containter. It is used as an handle to
     * relative panel, rather than create it externally and bind them togheter.
     */
    public AccordionBranch getBranchPanel() {
        return branchPanel;
    }

	@Override
	public ImageIcon getDefaultNormalIcon() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ImageIcon getDefaultSelectedIcon() {
		// TODO Auto-generated method stub
		return null;
	}
}
