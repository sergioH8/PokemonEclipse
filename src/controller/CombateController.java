package controller;

import java.sql.Connection;
import java.util.LinkedList;

import crud.ConexionBD;
import crud.PokemonCRUD;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.RadioButton;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import modelo.Entrenador;
import modelo.Pokemon;

public class CombateController {
	

	private Stage stage;
	
    @FXML
    public ImageView imgCombate;
    @FXML
    public ImageView imgPokemon;
    @FXML
    public ImageView imgRival;
    @FXML
    public ProgressBar pbarPokemon;
    @FXML
    public ProgressBar pbarRival;
    @FXML
    public RadioButton rbtnPokemon;
    @FXML
    public MenuBar mbarMenu;
    @FXML
    public Menu mnAtaques;
    @FXML
    public Menu mnEquipo;
    @FXML
    public Menu mnMochila;
    @FXML
    public Menu mnRetirada;
    @FXML
    public RadioButton rbtnRival;
    
    @FXML
    public Button btnSalirMenu;
	
    
    public void init(Entrenador entrenador, Stage stage, MenuController menuController) {
        this.stage = stage;
        try {
            ConexionBD conexionBD = new ConexionBD();
            Connection conexion = conexionBD.getConexion();
            LinkedList<Pokemon> pokedex = PokemonCRUD.obtenerPokedex(conexion);
        }catch(Exception e) {
        	e.printStackTrace();
        }
	}
    
    @FXML
    void salirMenu(MouseEvent event) {
		MenuController.show();
		stage.close();
    }
}
