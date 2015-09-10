/**
 *
 */
package org.ambar.appl.main;


import java.util.Optional;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import org.ambar.core.spring.SpringHelper;
import org.ambar.core.views.main.components.menu.MenuLoader;
import org.ambar.core.views.main.components.tree.RelationItemTreeListener;
import org.ambar.core.views.main.navigation.NavigationManager;
import org.springframework.context.ApplicationContext;

/**
 * @author Sebastian
 *
 * <p>
 * 	Aplicacion principal.
 * </p>
 *
 * @author Sebastian
 *
 */
public class MainApp extends Application {
	private SplitPane splitPane;
	private Pane headerPane;
	private BorderPane tableContentPane;
	private Pane tableHeaderPane;
	private Pane bottomPane;
	private TableView<Object> tableView;
	private Accordion accordion;
	private TreeView<Object> treeView;

	private Label entityTitle;

	private Stage stage;

	private ApplicationContext applicationContext;

	@Override
    public void start(Stage pStage) throws Exception {
		this.stage = pStage;

		this.applicationContext = SpringHelper.getContext();

		this.stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
		      public void handle(final WindowEvent pWindowsEvent) {
		    	 pWindowsEvent.consume();
		         askExit();
		      }
		 });

		initialize();
    }

	/**
	 * Pregunta si quiere salir de la aplicacion.
	 * */
	protected void askExit() {

		Alert alert = new Alert(AlertType.CONFIRMATION);

		alert.setTitle("Salir");
		alert.setHeaderText("Salir de la aplicación");
		alert.setContentText("¿Está seguro que desea salir de la aplicación?");

		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == ButtonType.OK) {
			Platform.exit();
		}
	}

	/**
	 * inicializa los componentes.
	 * */
	private void initialize() {
		BorderPane root = new BorderPane();
        Scene scene = new Scene(root);

        //Agrega un Skin
        String cssURL = getClass().getResource("/styles/theme.css").toExternalForm();
        scene.getStylesheets().add(cssURL);

        cssURL = getClass().getResource("/styles/style.css").toExternalForm();
        scene.getStylesheets().add(cssURL);

        root.setTop(getHeaderPane());
        root.setCenter(getSplitPane());
        root.setBottom(getBottomPane());

        this.stage.setTitle("Pantalla principal");
        // set icon
        this.stage.getIcons().add(new Image("/images/artwork.png"));
        this.stage.setScene(scene);

        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();

        //Setea el tamaño de la ventana
        this.stage.setWidth(bounds.getWidth() / 1.3);
        this.stage.setHeight(bounds.getHeight() / 1.3);

        this.stage.show();
	}

	/**
	 * Retorna el panel central de la aplicacion.
	 * @return {@link Pane} Panel
	 * */
	private Pane getTableContentPane() {
    	if (this.tableContentPane == null) {
    		this.tableContentPane = new BorderPane();
    		this.tableContentPane.setTop(this.getTableHeaderPane());
    		this.tableContentPane.setCenter(this.getTableView());
    	}
		return this.tableContentPane;
	}

	private Pane getTableHeaderPane() {
		if (this.tableHeaderPane == null) {
			this.tableHeaderPane = new Pane();
			this.tableHeaderPane.setPrefHeight(50);
			this.tableHeaderPane.getChildren().add(this.getEntityTitle());
		}
		return this.tableHeaderPane;
	}

	private Pane getHeaderPane() {
    	if (this.headerPane == null) {
    		this.headerPane = new Pane();
    	}
		return this.headerPane;
	}

	private Label getEntityTitle() {
		if (this.entityTitle == null) {
			this.entityTitle = new Label();
			this.entityTitle.setId("IDTituloEntidad");
			this.entityTitle.getStyleClass().add("entityTitle");
		}

		return this.entityTitle;
	}

	private Node getBottomPane() {
    	if (this.bottomPane == null) {
    		this.bottomPane = new Pane();

    	}
		return this.bottomPane;
	}
 
    private Node getSplitPane() {
    	if (this.splitPane == null) {
    		this.splitPane = new SplitPane();

    		this.splitPane.getItems().addAll(getAccordion(), getTreeView(), getTableContentPane());
	        SplitPane.setResizableWithParent(getAccordion(), Boolean.FALSE);
	        SplitPane.setResizableWithParent(getTreeView(), Boolean.FALSE);
	        this.splitPane.setDividerPositions(0.25f, 0.50f);
    	}
		return this.splitPane;
	}

	private Accordion getAccordion() {
		if (this.accordion == null) {
			this.accordion = new Accordion();

			MenuLoader menuLoader = this.applicationContext.getBean(MenuLoader.class);
			menuLoader.loadAccordionMenu(this.accordion);
		}
		return this.accordion;
	}

	private TableView<Object> getTableView() {
		if (this.tableView == null) {
			this.tableView = new TableView<Object>();

			this.tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

			NavigationManager navigationManager = this.applicationContext.getBean(NavigationManager.class);
			navigationManager.setTableView(this.tableView);
			navigationManager.setTableHeaderPane(getTableContentPane());
		}
		return this.tableView;
	}

	private TreeView<Object> getTreeView() {
		if (this.treeView == null) {
			this.treeView = new TreeView<Object>();

			NavigationManager navigationManager = this.applicationContext.getBean(NavigationManager.class);
			navigationManager.setTreeView(this.treeView);

			//Carga el Listener del TreeView
			RelationItemTreeListener treeListener =
					          this.applicationContext.getBean(RelationItemTreeListener.class);
			treeListener.setNavigationManager(navigationManager);
			treeListener.setTreeView(this.getTreeView());

			this.treeView.getSelectionModel().selectedItemProperty().addListener(treeListener);
		}
		return this.treeView;
	}

	/**
	 * Metodo Main.
	 * @param pArguments Argumentos de la aplicacion
	 * */
	public static void main(String[] pArguments) {
        Application.launch(pArguments);
    }
}
