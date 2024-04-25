package controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.LinkedList;

import crud.ConexionBD;
import crud.PokemonCRUD;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import modelo.Entrenador;
import modelo.Pokemon;

public class EquipoController {
	
	private Stage stage;
	
    @FXML
    public ImageView imgEquipo;
    @FXML
    public Label lblEquipo;
    @FXML
    public ImageView imgPokemon1;
    @FXML
    public ImageView imgPokemon2;
    @FXML
    public ImageView imgPokemon3;
    @FXML
    public ImageView imgPokemon4;
    @FXML
    public ImageView imgPokemon5;
    @FXML
    public ImageView imgPokemon6;
    @FXML
    public TableView tblView;
    @FXML
    public TableColumn tblEquipo;
    @FXML
    public TableColumn tblCaja;
    @FXML
    public Button btnMoverACaja;
    @FXML
    public Button btnMoverAEquipo;
    @FXML
    public Button btnAtras;
	
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
