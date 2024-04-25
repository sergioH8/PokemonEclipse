package controller;

import modelo.Entrenador;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import crud.ConexionBD;
import crud.PokemonCRUD;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class MenuController {
	// Añadir atributos manualmente de Entrenador

	public static final int EQUIPOPRINCIPAL = 1;
	public static final int EQUIPOSECUNDARIO = 0;

	private Entrenador entrenador;
	private static Stage stage;
	private LoginController loginController; // Controller del Login, porque en el menú hay un boton de "salir" que
												// conecta el menu con el Login
	// De esta forma, al "salir" no cierra la aplicación, sino que va a la anterior
	// pantalla para cambiar de usuario.

	@FXML
	public ImageView imgMenu;
	@FXML
	public ButtonBar btnbarCombate;
	@FXML
	public Button btnIrCombate;
	@FXML
	public ButtonBar btnbarCrianza;
	@FXML
	public Button btnIrCrianza;
	@FXML
	public ButtonBar btnbarEnfermeria;
	@FXML
	public Button btnEnfermeria;
	@FXML
	public ButtonBar btnbarCaptura;
	@FXML
	public Button btnCaptura;
	@FXML
	public ButtonBar btnbarEntreno;
	@FXML
	public Button btnEntrenamiento;
	@FXML
	public ButtonBar btnbarEquipo;
	@FXML
	public Button btnEquipo;
	@FXML
	public Button btnTienda;
	@FXML
	public Label lblBienvenida;
	@FXML
	public Button btnCasino;
	@FXML
	public Button btnSalir;
	@FXML
	public Label lblUsuario;

	public void init(Entrenador ent, Stage stage2, LoginController loginController) throws SQLException { // Método con
																											// los
																											// parametros!!!
		lblUsuario.setText(ent.getNombre());// Aparece el nombre de usuario en el menú.
		this.loginController = loginController;
		this.stage = stage2;
		// Con estos métodos cogemos la información del usuario y la cargamos en la
		// pantalla principal para poder acceder a ella cuando se necesite.
		this.entrenador = ent;
		ConexionBD con = new ConexionBD();

		Connection conexion = con.getConexion();

//		try {
//			PokemonCRUD.obtenerPokemon(conexion, this.entrenador, EQUIPOPRINCIPAL);
//			PokemonCRUD.obtenerPokemon(conexion, this.entrenador, EQUIPOSECUNDARIO);
//			
//		}catch(Exception e) {
//			e.setStackTrace(null);
//		}

	}

	public void salir(MouseEvent event) {
		loginController.show();// Crear el metodo en el Controller
		stage.close();
	}

	public static void show() {
		stage.show();
	}

	@FXML
	void irCaptura(MouseEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/vistaCaptura.fxml"));
			Parent root = loader.load();
			CapturaController capturaController = loader.getController();
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.setScene(scene);// Cargamos la escena en el stage.
			capturaController.init(entrenador, stage, this);// Crear el método init en CapturaController y le pasamos
															// los datos
			stage.show();
			MenuController.stage.close(); // Cerrar la ventana del menú
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	void irCasino(MouseEvent event) {

	}

	@FXML
	void irCombate(MouseEvent event) {

	}

	@FXML
	void irCrianza(MouseEvent event) {

	}

	@FXML
	void irEnfermeria(MouseEvent event) {

	}

	@FXML
	void irEntrenamiento(MouseEvent event) {

	}

	@FXML
	void irEquipo(MouseEvent event) {

	}

	@FXML
	void irTienda(MouseEvent event) {

	}

}
