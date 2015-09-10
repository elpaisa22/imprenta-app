/**
 * appl-frontend-desktop [07/03/2012 18:58:34]
 */
package org.ambar.appl.main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import org.ambar.appl.components.accordion.AccordionMenu;
import org.ambar.appl.components.breadcrumb.AmbarBreadCrumb;
import org.ambar.appl.components.listeners.AmbarCrudButtonsListener;
import org.ambar.appl.components.listeners.AmbarTableGridListener;
import org.ambar.appl.components.listeners.AmbarTreeListener;
import org.ambar.appl.components.navigation.api.NavigationBean;
import org.ambar.appl.components.tree.TreeEntry;
import org.ambar.appl.helpers.SpringHelper;
import org.ambar.core.dictionary.domain.navigation.EntityInfo;
import org.ambar.core.dictionary.domain.navigation.Item;
import org.ambar.core.dictionary.domain.navigation.Module;
import org.ambar.core.dictionary.services.DictionaryServices;

import de.javasoft.plaf.synthetica.SyntheticaSimple2DLookAndFeel;
/**
 * <p>
 * Clase que representa la entrada a la aplicacion, la pantalla inicial.
 * </p>
 *
 * @author Sebastian
 */
public class MainView {
	private static final int INT_10 = 10;
	private static final int INT_20 = 20;
	private static final int INT_28 = 28;
	private static final int INT_55 = 55;
	private static final int INT_100 = 100;
	private static final int INT_200 = 200;
	private static final int INT_300 = 300;
	private static final int INT_450 = 450;
	private static final int INT_1102 = 1102;

	private JFrame frame;
	private JScrollPane scrollPane;
	private JSplitPane splitPanel;
	private JTextField txtBuscar;
	private AccordionMenu accordionMenu;
	private JButton btnBuscar;

	private JButton btnEliminar;
	private JButton btnAbrir;
	private JButton btnNuevo;
	private JButton btnEdicion;


	private MouseMotionListener mouseMotionListener = this.getMouseMotionListener();

	private JTable tableGrid;
	private AmbarTreeListener ambarTreeListener;
	private JPanel panelDerecho;
	private AmbarCrudButtonsListener ambarCrudButtonsListener;
	private AmbarTableGridListener ambarTableGridListener;
	private DictionaryServices dictionaryServices;
	private AmbarBreadCrumb ambarBreadCrumb;

	/**
	 * @param pDictionaryServices Establece el valor del atributo dictionaryServices.
	 */
	public void setDictionaryServices(DictionaryServices pDictionaryServices) {
		dictionaryServices = pDictionaryServices;
	}


	/**
	 * @param pBreadcrumbBar Establece el valor del atributo breadcrumbBar.
	 */
	public void setAmbarBreadCrumb(AmbarBreadCrumb pBreadcrumbBar) {
		ambarBreadCrumb = pBreadcrumbBar;
	}


	/**
	 * @return Retorna el valor del atributo breadcrumbBar.
	 */
	public AmbarBreadCrumb getAmbarBreadCrumb() {
		return ambarBreadCrumb;
	}


	/**
	 * @param pAmbarCrudButtonsListener Establece el valor del atributo ambarCrudButtonsListener.
	 */
	public void setAmbarCrudButtonsListener(AmbarCrudButtonsListener pAmbarCrudButtonsListener) {
		ambarCrudButtonsListener = pAmbarCrudButtonsListener;
	}


	/**
	 * @param pAmbarTableGridListener Establece el valor del atributo ambarTableGridListener.
	 */
	public void setAmbarTableGridListener(AmbarTableGridListener pAmbarTableGridListener) {
		ambarTableGridListener = pAmbarTableGridListener;
	}


	/**
	 * @param pTableGrid Establece el valor del atributo tableGrid.
	 */
	public void setTableGrid(JTable pTableGrid) {
		tableGrid = pTableGrid;
	}


	/**
	 * @param pAmbarTreeListener Establece el valor del atributo ambarTreeListener.
	 */
	public void setAmbarTreeListener(AmbarTreeListener pAmbarTreeListener) {
		ambarTreeListener = pAmbarTreeListener;
	}



	/**
	 * @return Retorna el valor del atributo txtBuscar.
	 */
	public JTextField getTxtBuscar() {
		return txtBuscar;
	}


	/**
	 * @param pTxtBuscar Establece el valor del atributo txtBuscar.
	 */
	public void setTxtBuscar(JTextField pTxtBuscar) {
		txtBuscar = pTxtBuscar;
	}


	/**
	 * Launch the application.
	 * @param pArgs Argumentos de la aplicación
	 */
	public static void main(final String[ ] pArgs) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		JDialog.setDefaultLookAndFeelDecorated(true);
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					UIManager.setLookAndFeel(new SyntheticaSimple2DLookAndFeel());
                    final MainView window = SpringHelper.getContext().getBean(MainView.class);

                    window.start();
				} catch (final Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	/**
	 * Metodo que hace ejecutar la ventana principal.
	 * */
	protected void start() {
		this.tableGrid.setRowHeight(25);
		Font headerFont = new Font("Arial", Font.BOLD, 12);
		this.tableGrid.getTableHeader().setFont(headerFont);
		Font gridFont = new Font("Arial", Font.PLAIN, 11);
		this.tableGrid.setFont(gridFont);
		this.tableGrid.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.tableGrid.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		panelDerecho.add(getAmbarBreadCrumb(), BorderLayout.NORTH);

		this.scrollPane.setViewportView(this.tableGrid);

		this.splitPanel.getLeftComponent().setMinimumSize(new Dimension(200, 400));

        createSampleMenuStructure(this.accordionMenu);

		//Soluciones a problemas visuales, no mostraba el panel seleccionado
        this.frame.addMouseMotionListener(this.mouseMotionListener);
        this.tableGrid.addMouseMotionListener(this.mouseMotionListener);
        this.accordionMenu.addMouseMotionListener(this.mouseMotionListener);
        this.scrollPane.addMouseMotionListener(this.mouseMotionListener);

        //Se agrega el filtrador de la grilla
        btnBuscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent pActionEvent) {
            	NavigationBean navigationBean = SpringHelper.getContext().getBean(NavigationBean.class);
            	navigationBean.filterGridWithTextField();
            }
          });

        this.frame.setVisible(true);
	}


	/**
	 * Create the application.
	 * @param pFilterField FilterField
	 * @wbp.parser.entryPoint
	 */
	public MainView(JTextField pFilterField) {
		this.setTxtBuscar(pFilterField);
		this.frame = new JFrame();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {

		this.frame.setBounds(INT_100, INT_100, INT_450, INT_300);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.frame.setBounds(0, 0, screenSize.width - INT_100, screenSize.height - INT_100);
		this.frame.setExtendedState(Frame.MAXIMIZED_BOTH);
		this.frame.setTitle("Aplication FrontEnd con SWING");
		this.frame.setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().
				getResource("print.png")));
		final JPanel panelSuperior = new JPanel();
		this.frame.getContentPane().add(panelSuperior, BorderLayout.NORTH);
		btnBuscar = new JButton("Buscar");
		btnBuscar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnBuscar.setIcon(new ImageIcon(this.getClass().getResource("search.png")));

		btnEliminar = new JButton("Eliminar");
		btnEliminar.setIcon(new ImageIcon(this.getClass().getResource("trash_can.png")));
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 11));

		btnEdicion = new JButton("Editar");
		btnEdicion.setIcon(new ImageIcon(this.getClass().getResource("edit.png")));
		btnEdicion.setFont(new Font("Tahoma", Font.BOLD, 11));

		btnAbrir = new JButton("Abrir");
		btnAbrir.setIcon(new ImageIcon(this.getClass().getResource("folder_full.png")));
		btnAbrir.setFont(new Font("Tahoma", Font.BOLD, 11));

		btnNuevo = new JButton("Nuevo");
		btnNuevo.setIcon(new ImageIcon(this.getClass().getResource("new_page.png")));
		btnNuevo.setFont(new Font("Tahoma", Font.BOLD, 11));

		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		final GroupLayout glpanelSuperior = new GroupLayout(panelSuperior);
		glpanelSuperior.setHorizontalGroup(
			glpanelSuperior.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, glpanelSuperior.createSequentialGroup()
					.addGap(211)
					.addComponent(btnNuevo)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnAbrir)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnEdicion)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnEliminar)
					.addPreferredGap(ComponentPlacement.RELATED, 231, Short.MAX_VALUE)
					.addComponent(getTxtBuscar(), GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnBuscar, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		glpanelSuperior.setVerticalGroup(
			glpanelSuperior.createParallelGroup(Alignment.LEADING)
				.addGroup(glpanelSuperior.createSequentialGroup()
					.addGap(31)
					.addGroup(glpanelSuperior.createParallelGroup(Alignment.LEADING, false)
						.addGroup(glpanelSuperior.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnBuscar, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
							.addComponent(getTxtBuscar(), GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
						.addGroup(glpanelSuperior.createParallelGroup(Alignment.TRAILING, false)
							.addGroup(Alignment.LEADING, glpanelSuperior.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnEdicion, 0, 0, Short.MAX_VALUE)
								.addComponent(btnEliminar, GroupLayout.PREFERRED_SIZE, 25, Short.MAX_VALUE))
							.addComponent(btnAbrir, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
							.addComponent(btnNuevo, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 25, Short.MAX_VALUE)))
					.addContainerGap())
		);
		panelSuperior.setLayout(glpanelSuperior);

		final JPanel panelInferior = new JPanel();
		this.frame.getContentPane().add(panelInferior, BorderLayout.SOUTH);

		final JProgressBar progressBar = new JProgressBar();
		final GroupLayout glpanelInferior = new GroupLayout(panelInferior);
		glpanelInferior.setHorizontalGroup(
				glpanelInferior.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING,
				glpanelInferior
						.createSequentialGroup().addContainerGap(INT_1102, Short.MAX_VALUE)
						.addComponent(progressBar,
								      GroupLayout.PREFERRED_SIZE,
								      GroupLayout.DEFAULT_SIZE,
								      GroupLayout.PREFERRED_SIZE)
						.addGap(INT_28)));
		glpanelInferior.setVerticalGroup(
				glpanelInferior.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING,
				glpanelInferior
						.createSequentialGroup().addContainerGap(INT_20, Short.MAX_VALUE)
						.addComponent(progressBar,
								      GroupLayout.PREFERRED_SIZE,
								      GroupLayout.DEFAULT_SIZE,
								      GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));
		panelInferior.setLayout(glpanelInferior);

		this.splitPanel = new JSplitPane();
		this.splitPanel.addPropertyChangeListener(JSplitPane.DIVIDER_LOCATION_PROPERTY,
				                             getPropertyChangeListener());

		this.frame.getContentPane().add(this.splitPanel, BorderLayout.CENTER);

		this.accordionMenu = new AccordionMenu();
        this.accordionMenu.setMenusSize(INT_55);
        this.accordionMenu.setBackground(Color.WHITE);

		this.splitPanel.setDividerLocation(INT_200);
		this.splitPanel.setOneTouchExpandable(false);
		this.splitPanel.setLeftComponent(this.accordionMenu);

		panelDerecho = new JPanel();
		this.splitPanel.setRightComponent(panelDerecho);
		panelDerecho.setLayout(new BorderLayout(0, 0));

		this.scrollPane = new JScrollPane();
		panelDerecho.add(scrollPane, BorderLayout.CENTER);
		this.scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	}

	//Soluciones a problemas visuales, no mostraba el panel seleccionado
	/**
	 * Actualiza la pantalla principal cuando se muestra por primera vez.
	 * @return {@link MouseMotionListener} Listener
	 * */
	private MouseMotionListener getMouseMotionListener() {
		return new MouseMotionListener() {

			@Override
			public void mouseDragged(MouseEvent pEvent) {
			}

			@Override
			public void mouseMoved(MouseEvent pEvent) {
				for (int i = 0; i < 1; i++) {
					frame.validate();
					frame.update(frame.getGraphics());
				}

				frame.removeMouseMotionListener(mouseMotionListener);
				tableGrid.removeMouseMotionListener(mouseMotionListener);
				accordionMenu.removeMouseMotionListener(mouseMotionListener);
				scrollPane.removeMouseMotionListener(mouseMotionListener);

				btnEliminar.addActionListener(ambarCrudButtonsListener);
				btnEdicion.addActionListener(ambarCrudButtonsListener);
				btnNuevo.addActionListener(ambarCrudButtonsListener);
				btnAbrir.addActionListener(ambarCrudButtonsListener);

				tableGrid.addMouseListener(ambarTableGridListener);
			}
		};
	}

	//Soluciones a problemas visuales: No actualizaba el panel cuando se hacia un resize del accordion
	/**
	 * Actualiza la pantalla principal cuando se cambia el tamaño del spliter.
	 * @return {@link PropertyChangeListener} Listener
	 * */
	private PropertyChangeListener getPropertyChangeListener() {
		return new PropertyChangeListener() {

			@Override
			public void propertyChange(PropertyChangeEvent pEvent) {
				for (int i = 0; i < 1; i++) {
					frame.validate();
					frame.update(frame.getGraphics());
				}
			}
		};
	}

	/**
     * <code>Second method to create an AccordionMenu: add manually each menu with its leafs to AccordionMenu.</code>
     * It creates manually a structure like one created before with a description String. First method is better when
     * menu structure is static. Use this method instead if you want to create structure dinamically.
     * @param pTarget Target AccordionMenu to modify.
     */
	public void createSampleMenuStructure(AccordionMenu pTarget) {

		List<Module> modules = this.dictionaryServices.getAllModules();

		int i = 0;
		for (Module module : modules) {
			ImageIcon moduleIcon = new ImageIcon(this.getClass().getResource(module.getIcon()));
			String moduleName = "menu" + i;
			pTarget.addNewMenu(moduleName, module.getText(), moduleIcon);

			List<Item> items = module.getItems();
			if (items != null) {
				TreeEntry root = new TreeEntry("_ROOT_", null, null, null);
				for (Item item : items) {
                    EntityInfo entity = this.dictionaryServices.getNavigationEntityInfoById(item.getId());
                    ImageIcon icon = new ImageIcon(this.getClass().getResource(entity.getLargeImage()));
					TreeEntry treeEntry = new TreeEntry(item.getText(), icon, "", item.getId());
					root.add(treeEntry);
				}
				pTarget.addLeavesTo(moduleName, root);
			}
			pTarget.getMenu(moduleName).getBranchPanel().setTreeListener(ambarTreeListener);
			i++;
		}


        pTarget.calculateAvaiableSpace();
    }
}
