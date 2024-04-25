package controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Random;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import modelo.Entrenador;
import modelo.Pokemon;
import crud.ConexionBD;
import crud.PokemonCRUD;

public class CapturaController {
	
	private Stage stage;
	private Pokemon pokemonCapturado;

    @FXML
    public ImageView imgPokemon;
   
    
    @FXML
    private Button btnCapturar;

    @FXML
    private Button btnVolverMenu;

    @FXML
    private ImageView imgCaptura;

    

    @FXML
    void salirMenu(ActionEvent event) {
    
    		MenuController.show();
    		stage.close();
    }

    

    public void init(Entrenador entrenador, Stage stage, MenuController menuController) {
        this.stage = stage;
        try {
            ConexionBD conexionBD = new ConexionBD();
            Connection conexion = conexionBD.getConexion();
            LinkedList<Pokemon> pokedex = PokemonCRUD.obtenerPokedex(conexion); // Obtener todos los Pokémones de la Pokédex

            if (pokedex != null && !pokedex.isEmpty()) {
                Random random = new Random();
                int index = random.nextInt(pokedex.size());
                pokemonCapturado = pokedex.get(index);

                
                imgPokemon.setId(pokemonCapturado.getImgFrontal());
            } else {
                // Manejar el caso en que no hay Pokémones en la Pokédex
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Manejar o registrar la excepción adecuadamente
        }
    }
}