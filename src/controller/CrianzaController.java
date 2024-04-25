package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import modelo.Entrenador;
import modelo.Pokemon;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Random;

import crud.ConexionBD;
import crud.PokemonCRUD;

public class CrianzaController {
	
	private Stage stage;
    @FXML
    public Button btnAtras;
    @FXML
    public ImageView imgCrianza;
    @FXML
    public Button btnSeleccionarPokemon;
    @FXML
    public Label lblMacho;
    @FXML
    public Label lblHembra;
    @FXML
    public ImageView imgMacho;
    @FXML
    public ImageView imgHembra;
    @FXML
    public Button btnSelectMacho;
    @FXML
    public Button btnSelectHembra;
    @FXML
    public ImageView imgHuevo;
    @FXML
    public Button btnAbrirHuevo;
    @FXML
    public ImageView imgPokemonNuevo;


    @FXML
    protected void irAtras(){
        try{
            Stage nuevoEscenario = (Stage) btnAtras.getScene().getWindow();
            nuevoEscenario.close();

            FXMLLoader carga = new FXMLLoader(getClass().getResource("../../vistas/vistaMenu.fxml"));
            Parent raiz = carga.load();
            Scene escena = new Scene(raiz);
            Stage escenarioActual = new Stage();

            escenarioActual.initModality(Modality.APPLICATION_MODAL);
            escenarioActual.setScene(escena);
            escenarioActual.show();

        }catch(IOException e){
            e.printStackTrace();
        }
    }


	public void init(Entrenador entrenador, Stage stage, MenuController menuController) {
		this.stage = stage;
        try {
            ConexionBD conexionBD = new ConexionBD();
            Connection conexion = conexionBD.getConexion();
            LinkedList<Pokemon> pokedex = PokemonCRUD.obtenerPokedex(conexion); // Obtener todos los Pokémones de la Pokédex

        } catch (SQLException e) {
            e.printStackTrace(); // Manejar o registrar la excepción adecuadamente
        }
		
	}
	
    @FXML
    void salirMenu(MouseEvent event) {
    	MenuController.show();
    	stage.close();
    }
}