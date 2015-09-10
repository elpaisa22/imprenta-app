/**
 * appl-frontend-desktop [19/04/2012 22:47:12]
 */
package org.ambar.appl.components.accordion;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.border.Border;

import org.ambar.appl.components.tree.TreeEntry;

/**
 * Clase que representa un menu del accordion.
 *
 * @author Sebastian
 * */
public final class AccordionMenu extends JPanel {

    /**
	 *
	 */
	private static final long serialVersionUID = -430156947176171567L;

	/** Menu Root Item default minimum size.*/
    public static final int MINIMUM_SIZE = 25;
    /** Menu Root Item height.*/
    private int menusSize = MINIMUM_SIZE;

    private static final int INT_10 = 10;
    private static final int INT_30 = 30;

    /** Menu item count. */
    private int menuCount;
    /** This parameters stores the value of free vertical space that can be used to display a menu branch. */
    private int branchAvaiableSpace;
    /** This parameters counts how many rows is void in a menu branch. */
    @SuppressWarnings("unused")
	private int freeAvaiableRows;
    /** Animation time pause. Higher value -> Slower animation */
    private int timeStep = INT_10;
    /** Color of item HIGHLIGHT on <code>mouseover</code>. NULL is allowed. */
    private Color selectionColor = null;
    /** Handle to selected menu. It is the menu with the opened branch. */
    private AccordionRootItem selectedMenu;
    /** Handle to the last selected Menu Item. Used for animation. */
    private AccordionRootItem lastSelectedMenu;
    /** Handle to selected Leaf Item. */
    private AccordionLeafItem selectedLeaf;
    /** It is value of vertical size of branch that is opening.
     *  It is simply <code>(branchAvaiableSpace - hidingSize)</code>.*/
    private int showingSize;
    /** It is value of vertical size of branch that is closing.
     *  It is simply <code>(branchAvaiableSpace - showingSize)</code>. */
    private int hidingSize;
    /** A Map representig the menu tree with handle to each menu items. */
    private TreeMap<AccordionRootItem, List<AccordionLeafItem>> leafMap;

    /**
     * Default basic constructor. Creates tree map of menu. And prepares layout and events.
     */
    public AccordionMenu() {
        this.addComponentListener(getDefaultComponentAdapter());
        this.setLayout(null);
        this.leafMap = new TreeMap<AccordionRootItem, List<AccordionLeafItem>>();
    }

    /**
     * Creates a menu with a predefined structure passed by <code>String</code>.
     * The stucture for example is like:
     * <br><br>
     * <code>"Menu One,menu1:Sub Menu1,submenu1;Sub Menu2,submenu2;Sub Menu 3,
     * submenu3!Menu Two:Sub Menu1,submenu1;Sub Menu2,submenu2;Sub Menu 3,submenu3!"</code>
     * <br><br>
     * Each element is a couple <code>itemName,itemTitle</code> like (Menu One,menu1).<br>
     * <code>itemName</code> is used as handle to menu item.<br>
     * The ":" regex is used to separate Menu Root Item to its Leafs. The "," separates leafs.
     * And "!" regex is used to separate each Menu Root from others.
     * @param pMenuDescriptor String representing structure of menu.
     */
    public AccordionMenu(String pMenuDescriptor) {
        this();
        createMenusFromDescriptor(pMenuDescriptor);
    }

    /**
     * The stucture for example is like:
     * <br><br>
     * <code>"Menu One,menu1:Sub Menu1,submenu1;Sub Menu2,submenu2;Sub Menu 3,
     * submenu3!Menu Two:Sub Menu1,submenu1;Sub Menu2,submenu2;Sub Menu 3,submenu3!"</code>
     * <br><br>
     * Each element is a couple <code>itemName,itemTitle</code> like (Menu One,menu1).<br>
     * <code>itemName</code> is used as handle to menu item.<br>
     * The ":" regex is used to separate Menu Root Item to its Leafs. The "," separates leafs.
     * And "!" regex is used to separate each Menu Root from others.
     *
     * @param pMenuDescriptor String representing structure of menu.
     */
    public void createMenusFromDescriptor(String pMenuDescriptor) {
        this.leafMap = new TreeMap<AccordionRootItem, List<AccordionLeafItem>>();
        String[] menus = pMenuDescriptor.split("!");
        boolean first = true;
        menuCount = 0;
        for (String menu : menus) {
            String name = menu.split(":")[0];
            AccordionRootItem menuItem = createRootItem(name.split(",")[0], name.split(",")[1]);
            menuItem.addMouseListener(getDefaultMenuMouseAdapter());

            if (first) {
                menuItem.setSelected(true);
//                lastSelectedMenu = menuItem;
                first = false;
            }
            String leafs = menu.split(":")[1];
            List<AccordionLeafItem> leafList = new ArrayList<AccordionLeafItem>();
            for (String leaf : leafs.split(";")) {
                AccordionLeafItem leafItem = createLeafItem(leaf.split(",")[0], leaf.split(",")[1]);
                menuItem.getBranchPanel().addItem(leafItem);
                leafList.add(leafItem);
            }
            menuItem.setIndex(menuCount);
            menuCount++;
            leafMap.put(menuItem, leafList);
            this.add(menuItem.getBranchPanel());
        }
        menuCount = leafMap.keySet().size();
        calculateAvaiableSpace();
    }



    /**
     *
     * @return {@link MouseAdapter} object with implementation of events of mouse on Root Menu Items.
     */
    private MouseAdapter getDefaultMenuMouseAdapter() {
        return new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent pEvent) {
                AccordionRootItem item = (AccordionRootItem) pEvent.getSource();
                for (AccordionRootItem menu : getMenus()) {
                    if (menu.isSelected()) {
                        lastSelectedMenu = menu;
                        menu.setSelected(false);
                    }
                }
                item.setSelected(true);
                if (lastSelectedMenu == item) {
                    return;
                } else {
                	selectedMenu = item;
                }
                startAnimation();
                validate();
                repaint();

            }

        };
    }

    /**
     * Begin animation of Closing/Opening of new menu branch. It divides the <code>branchAvaiableSpace</code>
     * in two parts <code>showingSize</code> and <code>hidingSize</code>, the first one grow up and the second one
     * goes to zero with a certain time step. Pixel step is fixed to 30 but is not a charge.
     */
    private void startAnimation() {
        Thread thread = new Thread(new Runnable() {

            public void run() {
                showingSize = 0;
                hidingSize = branchAvaiableSpace;
                int step = INT_30;
                while (hidingSize > 0) {
                    showingSize += step;
                    hidingSize -= step;
                    validate();
                    repaint();
                    try {
                        Thread.sleep(timeStep);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(AccordionMenu.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                showingSize = branchAvaiableSpace;
                hidingSize = 0;
                validate();
                repaint();
            }
        });
        thread.setPriority(Thread.MAX_PRIORITY);
        thread.start();
    }


    /**
     * Updates UI of each menu leaf. Used to fix some visual problems.
     */
    public void updateLeafs() {
        for (AccordionLeafItem leaf : getAllLeafs()) {
        	leaf.validate();
            leaf.repaint();
        }
    }

    /**
     * The core dispplay engine is in this function. The algorithm is very simple:
     * each Menu Root Item is displayed with 100% width and one behind others,
     * with fixed menuSize height. In case that Menu is selected,
     * it starts to displays the menuBranch of selected menu and
     * it starts to hide the menuBranch of previous selected menu.
     * This function ignores the animation function; it just displays, with some parameters,
     * the current and previous selected menues.
     * So the animation function changes parameters at runtime to give an animation effect.
     * @param pGraphics  Graphics object of this component.
     */
    @Override
    protected void paintComponent(Graphics pGraphics) {
        super.paintComponent(pGraphics);
        int currentY = 0;
        for (AccordionRootItem menu : getMenus()) {
            menu.setSize(this.getWidth(), this.menusSize);
            menu.setLocation(0, currentY);

            if (menu == lastSelectedMenu && !menu.isSelected()) {
                currentY += this.menusSize;
                menu.getBranchPanel().setSize(this.getWidth(), this.hidingSize);
                menu.getBranchPanel().setLocation(0, currentY);
                currentY += this.hidingSize;
            }
            if (menu.isSelected()) {
                currentY += this.menusSize;
                menu.getBranchPanel().setSize(this.getWidth(), this.showingSize);
                menu.getBranchPanel().setLocation(0, currentY);
                currentY += this.showingSize;
            } else if (!menu.isSelected() && menu != lastSelectedMenu) {
                menu.getBranchPanel().setSize(0, 0);
                currentY += this.menusSize;
            }
        }
    }

    /**
     * @return List of {@link AccordionRootItem}, handles to Menu Root Items.
     */
    public List<AccordionRootItem> getMenus() {
        return new ArrayList<AccordionRootItem>(leafMap.keySet());
    }

    /**
     *
     * @param pName Name of target menu.
     * @return {@link AccordionRootItem} object with selected name if any.
     */
    public AccordionRootItem getMenu(String pName) {
        for (AccordionRootItem menu : leafMap.keySet()) {
            if (menu.getName().equals(pName)) {
                return menu;
            }
        }
        return null;
    }

    /**
     *
     * @return List of {@link AccordionLeafItem}, handles to Menu Leaf Items of all menu.
     */
    public List<AccordionLeafItem> getAllLeafs() {
        List<AccordionLeafItem> leafs = new ArrayList<AccordionLeafItem>();
        for (AccordionRootItem menu : leafMap.keySet()) {
            leafs.addAll(leafMap.get(menu));
        }
        return leafs;
    }

    /**
     *
     * @param pMenuName Target menu name.
     * @return List of {@link AccordionLeafItem} of choosen menu if any.
     */
    public List<AccordionLeafItem> getLeafsOf(String pMenuName) {
        List<AccordionLeafItem> leafs = new ArrayList<AccordionLeafItem>();
        for (AccordionRootItem menu : leafMap.keySet()) {
            if (menu.getName().equals(pMenuName)) {
                leafs.addAll(leafMap.get(menu));
            }
        }
        return leafs;
    }

    /**
     *
     * @param pName Target leaf name.
     * @return {@link AccordionLeafItem} object with selected name if any.
     */
    public AccordionLeafItem getLeaf(String pName) {
        for (AccordionLeafItem leaf : getAllLeafs()) {
            if (leaf.getName().equals(pName)) {
                return leaf;
            }
        }
        return null;
    }

    /**
     *
     * @return {@link ComponentAdapter} object that implements resizing event.
     */
    public ComponentAdapter getDefaultComponentAdapter() {
        return new ComponentAdapter() {

            @Override
            public void componentResized(ComponentEvent pEvent) {
                calculateAvaiableSpace();
            }
        };
    }

    /**
     * Calculates some parameters. Usally called after a resize event because it calculate
     * some parameters depending of Size of this component.
     */
    public void calculateAvaiableSpace() {
        int height = getHeight();
        double scale = menusSize / INT_10;
        branchAvaiableSpace = height - (menuCount * menusSize);
        freeAvaiableRows = (int) (Math.ceil(height / (menusSize)) * scale) - menuCount;
        showingSize = branchAvaiableSpace;
        hidingSize = 0;
    }

    /**
     * Creates a Root Menu Item of accordion menu with selected title and name.
     * It creates <code>AccordionRootItem</code> and add it to container.
     *
     * @param pTitle Displayed title.
     * @param pName Binding name.
     * @return <code>AccordionRootItem</code> object created.
     */
    private AccordionRootItem createRootItem(String pTitle, String pName) {
        AccordionRootItem menu = new AccordionRootItem(pTitle);
        menu.setName(pName);
        add(menu);
        return menu;
    }

    /**
     * Creates a Leaf Menu Item of accordion menu with selected title and name.
     * It creates <code>AccordionLeafItem</code>.
     *
     * @param pTitle Displayed title.
     * @param pName Binding name.
     * @return <code>AccordionLeafItem</code> object created.
     */
    private AccordionLeafItem createLeafItem(String pTitle, String pName) {
        AccordionLeafItem leaf = new AccordionLeafItem(pTitle, null, "", "");
        leaf.setName(pName);
        //add(leaf);
        return leaf;
    }

    /**
     * Add a new Leaf to selected Menu.
     *
     * @param pMenuName Father menu of new leaf.
     * @param pLeafTitle Displayed title.
     * @param pLeafName Binding name.
     */
    public void addNewLeafTo(String pMenuName, String pLeafName, String pLeafTitle) {
        for (AccordionRootItem menu : getMenus()) {
            if (menu.getName().equals(pMenuName)) {
                AccordionLeafItem item = createLeafItem(pLeafTitle, pLeafName);
                this.leafMap.get(menu).add(item);
                menu.getBranchPanel().addItem(item);
                return;
            }
        }
    }

    /**
     * Add a new Leaf to selected Menu.
     *
     * @param pMenuName Father menu of new leaf.
     * @param pLeafTitle Displayed title.
     * @param pLeafName Binding name.
     * @param pIcon Icon {@link ImageIcon}.
     */
    public void addNewLeafTo(String pMenuName, String pLeafName, String pLeafTitle, ImageIcon pIcon) {
        for (AccordionRootItem menu : getMenus()) {
            if (menu.getName().equals(pMenuName)) {
                AccordionLeafItem item = createLeafItem(pLeafTitle, pLeafName);
                if (pIcon != null) {
                	item.setIcon(pIcon);
                }
                this.leafMap.get(menu).add(item);
                menu.getBranchPanel().addItem(item);
                return;
            }
        }
    }

    /**
     * Add a new Leaf to selected Menu.
     *
     * @param pMenuName Father menu of new leaf.
     * @param pTreeEntry Root Entry
     */
    public void addLeavesTo(String pMenuName, TreeEntry pTreeEntry) {
        for (AccordionRootItem menu : getMenus()) {
            if (menu.getName().equals(pMenuName)) {
                menu.getBranchPanel().addRootItem(pTreeEntry);
                menu.getBranchPanel().getFooItems().addMouseListener(new MouseAdapter() {
                    public void mouseClicked(MouseEvent pMouseEvent) {
                    	restartSelected();
                      }
                    });
                return;
            }
        }
    }

    /**
     * Add a new Root menu.
     *
     * @param pMenuName Displayed name.
     * @param pMenuTitle Binding name.
     */
    public void addNewMenu(String pMenuName, String pMenuTitle) {
        List<AccordionLeafItem> leafs = new ArrayList<AccordionLeafItem>();
        AccordionRootItem menu = createRootItem(pMenuTitle, pMenuName);
        menu.addMouseListener(getDefaultMenuMouseAdapter());
        menu.setIndex(menuCount);
        if (menuCount == 0) {
            menu.setSelected(true);
//            lastSelectedMenu = menu;
        }
        menuCount++;
        this.leafMap.put(menu, leafs);
        this.add(menu.getBranchPanel());
    }

    /**
     * Add a new Root menu.
     *
     * @param pMenuName Displayed name.
     * @param pMenuTitle Binding name.
     * @param pIcon Icon {@link ImageIcon}.
     */
    public void addNewMenu(String pMenuName, String pMenuTitle, ImageIcon pIcon) {
        List<AccordionLeafItem> leafs = new ArrayList<AccordionLeafItem>();
        AccordionRootItem menu = createRootItem(pMenuTitle, pMenuName);
        menu.addMouseListener(getDefaultMenuMouseAdapter());
        menu.setIndex(menuCount);
        if (pIcon != null) {
        	menu.setNormalIcon(pIcon);
        	menu.setSelectedIcon(pIcon);
        }
        if (menuCount == 0) {
            menu.setSelected(true);
//            lastSelectedMenu = menu;
        }
        menuCount++;
        this.leafMap.put(menu, leafs);
        this.add(menu.getBranchPanel());
    }

    /**
     * Changes background <code>Color</code> of each item of menu.
     * @param pBack Selected <code>Color</code>.
     */
    @Override
    public void setBackground(Color pBack) {
        if (this.leafMap == null) {
            return;
        }
        for (AccordionRootItem menu : leafMap.keySet()) {
            menu.setBackground(pBack);
            menu.getBranchPanel().setBackground(pBack);
            if (selectionColor == null) {
                for (AccordionLeafItem leaf : leafMap.get(menu)) {
                    leaf.setBackground(pBack);
                }
            }
        }
    }


    /**
     * Sets border to all Menu Root Items.
     * @param pBorder {@link Border} object.
     */
    public void setMenuBorders(Border pBorder) {
        for (AccordionRootItem menu : getMenus()) {
            menu.setBorder(pBorder);
        }
    }

    /**
     * Sets alignment for Menu Root Items.
     * @param pAlignment Alignment value. es. use <code>AccordionItem.CENTER</code>.
     */
    public void setMenuHorizontalAlignment(int pAlignment) {
        if (this.leafMap == null) {
            return;
        }
        for (AccordionRootItem menu : leafMap.keySet()) {
            menu.setHorizontalAlignment(pAlignment);
        }
    }

    /**
     *
     * @return Color of HIGHLIGHT on mouseover event on items.
     */
    public Color getSelectionColor() {
        return selectionColor;
    }

    /**
     * Sets Color of HIGHLIGHT on mouseover event on items of menu.
     * @param pSelectionColor Selected Color. Allow NULL.
     */
    public void setSelectionColor(Color pSelectionColor) {
        this.selectionColor = pSelectionColor;
        for (AccordionRootItem menu : leafMap.keySet()) {
            for (AccordionLeafItem leaf : leafMap.get(menu)) {
                leaf.setBackground(pSelectionColor);
            }
        }
    }

    /**
     * Changes Font to each menu item.
     * @param pFont Selected Font.
     */
    public void setFont(Font pFont) {
        if (this.leafMap == null) {
            return;
        }
        for (AccordionRootItem menu : getMenus()) {
            menu.setFont(pFont);
            for (AccordionLeafItem leaf : getLeafsOf(menu.getName())) {
                leaf.setFont(pFont);
            }
        }
    }

    /**
     * Sets Foreground Color to each menu item.
     * @param pForeground Selected Color.
     */
    @Override
    public void setForeground(Color pForeground) {
        if (this.leafMap == null) {
            return;
        }
        for (AccordionRootItem menu : getMenus()) {
            menu.setForeground(pForeground);
            for (AccordionLeafItem leaf : getLeafsOf(menu.getName())) {
                leaf.setForeground(pForeground);
            }
        }
    }

    /**
     *
     * @return Number of Root Menu Items.
     */
    public int getMenuCount() {
        return menuCount;
    }

    /**
     *
     * @return Value of height size of Root Menu Items.
     */
    public int getMenusSize() {
        return menusSize;
    }

    /**
     * Sets Value of height size of Root Menu Items. Tests show that 30 is minimum for a better view
     * @param pMenusSize Menus Size
     */
    public void setMenusSize(int pMenusSize) {
        if (menusSize < MINIMUM_SIZE) {
            setMenusSize(MINIMUM_SIZE);
        }
        this.menusSize = pMenusSize;
        calculateAvaiableSpace();
        validate();
        repaint();
    }

    /**
     *
     * @return Time step value of animations.
     */
    public int getTimeStep() {
        return timeStep;
    }

    /**
     * Sets value for animation steps. Higher values -> slower animations.
     * @param pTimeStep Selected value.
     */
    public void setTimeStep(int pTimeStep) {
        this.timeStep = pTimeStep;
    }

    /**
     *
     * @return {@link AccordionLeafItem} handle to selected Leaf Item.
     */
    public AccordionLeafItem getSelectedLeaf() {
        return selectedLeaf;
    }

    /**
     *
     * @return {@link AccordionLeafItem} handle to selected Menu Item.
     */
    public AccordionRootItem getSelectedMenu() {
    	if (selectedMenu == null) {
    		AccordionRootItem elem;
    		Set<AccordionRootItem> keys = leafMap.keySet();
    		Iterator<AccordionRootItem> iterator = keys.iterator();
    		while (iterator.hasNext()) {
    			elem = iterator.next();
    			if (elem.getIndex() == 0) {
    				selectedMenu = elem;
    				break;
    			}
    		}
    	}
        return selectedMenu;
    }

    /**
     *
     * */
    public void restartSelected() {
    	AccordionRootItem selected = this.getSelectedMenu();
    	int index = selected.getIndex();

    	List<AccordionRootItem> menues = this.getMenus();
    	for (AccordionRootItem accordionRootItem : menues) {
			if (accordionRootItem.getIndex() != index) {
				accordionRootItem.getBranchPanel().getFooItems().clearSelection();
			}
		}
    }

}

