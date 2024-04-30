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

public class TiendaController {

	private Stage stage;

    @FXML
    private Button btnComprar;

    @FXML
    private Button btnSalir;

    @FXML
    private ImageView imgFlechaDcha;

    @FXML
    private ImageView imgFlechaIzq;

    @FXML
    private ImageView imgObjeto;

    @FXML
    private ImageView imgTienda;

    @FXML
    void flechaDcha(MouseEvent event) {

    }

    @FXML
    void flechaIzq(MouseEvent event) {

    }

    @FXML
    void salirMenu(MouseEvent event) {
    	MenuController.show();
    	stage.close();
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

}

