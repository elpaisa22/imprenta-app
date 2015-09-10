/**
 * appl-frontend-javafx [11/01/2014 20:24:27]
 */
package org.ambar.appl.login;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * <p>
 * Login de la aplicacion.
 * </p>
 *
 * @author Sebastian
 *
 */
public class LoginForm extends Stage {

	private String usuario = "demo";
	private String password = "demo";
	private String checkUser, checkPw;

	private Boolean loggedIn = false;

	//Implementing Nodes for GridPane
	private Label lblUserName = new Label("Usuario");
	private  TextField txtUserName = new TextField("demo");
	private  Label lblPassword = new Label("Contrasena");
	private  PasswordField passwordField = new PasswordField();
	private  Button btnLogin = new Button("Entrar");
	private  Label lblMessage = new Label();


	/**
	 * Contructor default.
	 * */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public LoginForm() {

		BorderPane bp = new BorderPane();
		bp.setPadding(new Insets(10,50,50,50));

		// set icon
        this.getIcons().add(new Image("/images/artwork.png"));

		//Adding HBox
		HBox hb = new HBox();
		hb.setPadding(new Insets(20,20,20,30));

		//Adding GridPane
		GridPane gridPane = new GridPane();
		gridPane.setPadding(new Insets(20,20,20,20));
		gridPane.setHgap(5);
		gridPane.setVgap(5);


		//Adding Nodes to GridPane layout
		gridPane.add(lblUserName, 0, 0);
		gridPane.add(txtUserName, 1, 0);
		gridPane.add(lblPassword, 0, 1);
		passwordField.setText("demo");
		gridPane.add(passwordField, 1, 1);
		gridPane.add(btnLogin, 2, 1);
		gridPane.add(lblMessage, 1, 2);

		//DropShadow effect
		DropShadow dropShadow = new DropShadow();
		dropShadow.setOffsetX(5);
		dropShadow.setOffsetY(5);

		//Adding text and DropShadow effect to it
		Text text = new Text("Ingresar al sistema");
		text.setFont(Font.font("Arial", FontWeight.BOLD, 20));
		//text.setEffect(dropShadow);

		//Adding text to HBox
		hb.getChildren().add(text);

		//Add ID's to Nodes
		bp.setId("bp");
		gridPane.setId("root");
		btnLogin.setId("btnLogin");
		text.setId("text");

		//Action for btnLogin
		btnLogin.setOnAction(new EventHandler() {
			public void handle(Event pEvent) {
				checkUser();
			}
		});

		//Add HBox and GridPane layout to BorderPane Layout
		bp.setTop(hb);
		bp.setCenter(gridPane);

		//Adding BorderPane to the scene and loading CSS
		Scene scene = new Scene(bp);

		this.setScene(scene);
		this.setTitle("Login");

	}

	/**
	 * Ejecuta el login.
	 * @return {@link Boolean} True si se pudo loguear
	 * */
	public Boolean login() {
		this.showAndWait();
		return this.loggedIn;
	}

	/**
	 * Cheackea si el usuario y la pass son correctas.
	 * */
	private void checkUser() {
		checkUser = txtUserName.getText().toString();
		checkPw = passwordField.getText().toString();
		if (checkUser.equals(usuario) && checkPw.equals(password)) {
			loggedIn = true;
			this.close();
		} else {
			lblMessage.setText("Error");
			lblMessage.setTextFill(Color.RED);
		}
	}

}
