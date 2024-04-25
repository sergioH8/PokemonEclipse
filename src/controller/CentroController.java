package controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.LinkedList;

import crud.ConexionBD;
import crud.PokemonCRUD;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import modelo.Entrenador;
import modelo.Pokemon;

public class CentroController {
	
	private Stage stage;
    @FXML
    public ImageView imgCentroPokemon;
    @FXML
    public Button btnSalirEnfermeria;
    @FXML
    public ImageView imgPokemon;
    @FXML
    public Button btnRecuperar;
	
    
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
