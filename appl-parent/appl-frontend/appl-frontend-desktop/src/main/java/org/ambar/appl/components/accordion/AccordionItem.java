/**
 * appl-frontend-desktop [19/04/2012 22:44:23]
 */
package org.ambar.appl.components.accordion;

import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.event.MouseAdapter;

import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * <p>
 * Clase que representa un Accordion Item.
 * </p>
 *
 * @author Sebastian
 *
 * */
public abstract class AccordionItem extends JButton implements Comparable<Object> {

    /**
	 *
	 */
	private static final long serialVersionUID = 7100164275970996113L;

	/** Boolean parameter binds state of element. SELECTED or NOT. */
	private boolean selected = false;
    /** <code>IconImage</code> used when item is not selected. */
    private ImageIcon normalIcon;
    /** <code>IconImage</code> used when item is selected. */
    private ImageIcon selectedIcon;
    /** Index value for ordering items in menu tree .*/
    private int index;

    /**
     * Default Constructor with defualt Title string.
     *
     * @param pText Title String displayed.
     */
    public AccordionItem(String pText) {
        super(pText);
        setOpaque(false);
        addMouseListener(getDefaultMouseActions());
        setNormalIcon(getDefaultNormalIcon());
        setSelectedIcon(getDefaultSelectedIcon());
        setSelected(false);
    }

    /**
     * Derived classes must implement Mouse events.
     * @return {@link MouseAdapter} with only used events.
     */
    public abstract MouseAdapter getDefaultMouseActions();

    /**
     * Derived classes have to create {@link ImageIcon} displayed when item is not selected.
     * @return <code>ImageIcon</code> object.
     */
    public abstract ImageIcon getDefaultNormalIcon();

    /**
     * Derived classes have to create {@link ImageIcon} displayed when item is selected.
     * @return <code>ImageIcon</code> object.
     */
    public abstract ImageIcon getDefaultSelectedIcon();

    /**
     * Derived classes have to create a {@link Paint} object drawn in background. Like {@link GradientPaint}.
     * @return <code>Paint</code> object.
     */
    public abstract Paint getDefaultBackgroundPaint();

    /**
     * Simple switch of state. TRUE to FALSE, FALSE to TRUE.
     */
    public final void switchState() {
        setSelected(!isSelected());
    }

    /**
     *
     * @return <code>TRUE</code> if item is selected; <code>FALSE</code> otherwise.
     */
    public boolean isSelected() {
        return selected;
    }

    /**
     * Changes state of object. If <code>TRUE</code> sets the appropriate image and BOLD font. The same thing otherwise.
     * @param pSelected Boolean state of object.
     */
    public void setSelected(boolean pSelected) {
        this.selected = pSelected;
        if (selected) {
            setIcon(selectedIcon);
            setFont(getFont().deriveFont(Font.BOLD));
        } else {
            setIcon(normalIcon);
            setFont(getFont().deriveFont(Font.PLAIN));
        }
    }

    /**
     * Draws {@link Paint} object on background if any.
     * @param pGraphics <code>Graphics</code> object of JComponent.
     */
    @Override
    protected void paintComponent(Graphics pGraphics) {
        if (getDefaultBackgroundPaint() != null) {
            Graphics2D g2d = (Graphics2D) pGraphics;
            g2d.setPaint(getDefaultBackgroundPaint());
            g2d.fillRect(0, 0, getWidth(), getHeight());
        }
        super.paintComponent(pGraphics);
    }

    /**
     * @return <code>ImageIcon</code> object of Unselected image status.
     */
    public ImageIcon getNormalIcon() {
        return normalIcon;
    }

    /**
     * Sets <code>ImageIcon</code> object for Unselected status.
     * @param pNormalIcon Normal icon
     */
    public void setNormalIcon(ImageIcon pNormalIcon) {
        this.normalIcon = pNormalIcon;
        setSelected(selected);
    }

    /**
     * @return <code>ImageIcon</code> object of Selected image status.
     */
    public ImageIcon getSelectedIcon() {
        return selectedIcon;
    }

    /**
     * Sets <code>ImageIcon</code> object for Selected status.
     * @param pSelectedIcon Selected
     */
    public void setSelectedIcon(ImageIcon pSelectedIcon) {
        this.selectedIcon = pSelectedIcon;
         setSelected(selected);
    }

    /**
     *
     * @return Position in menu tree.
     */
    public int getIndex() {
        return index;
    }

    /**
     * Sets position in menu tree.
     * @param pIndex Indice
     */
    public void setIndex(int pIndex) {
        this.index = pIndex;
    }

    /**
     * Implements <code>Comparable</code> interface. Items are ordered by their index value.
     * @param pObject Target AccordionItem to compare.
     * @return See {@link Comparable} usage.
     */
    public int compareTo(Object pObject) {
        AccordionItem target = (AccordionItem) pObject;
        if (getIndex() == target.getIndex()) {
            return 0;
        } else if (getIndex() > target.getIndex()) {
            return 1;
        } else {
            return -1;
        }
    }
}
