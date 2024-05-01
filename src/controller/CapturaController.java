package controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Random;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import modelo.Entrenador;
import modelo.Pokemon;
import crud.CapturaCRUD;
import crud.ConexionBD;
import crud.PokemonCRUD;

public class CapturaController {
	
	private LinkedList<Pokemon> pokedex;
	private Stage stage;
	private Pokemon pokemonCapturado;
	public static boolean capturado;
	
    @FXML
    public ImageView imgPokemon;
   
    @FXML
    private Button btnGenerar;

    @FXML
    private Button btnCapturar;

    @FXML
    private Button btnVolverMenu;

    @FXML
    private ImageView imgCaptura;
	private Entrenador entrenador;

    
    @FXML
    void generarPokemon(ActionEvent event) {
    	
         if (pokedex != null && !pokedex.isEmpty()) {
             Random random = new Random();
             int index = random.nextInt(pokedex.size());
             pokemonCapturado = pokedex.get(index);

             
             String imageUrl = "file:///" + pokemonCapturado.getImgFrontal();
             Image imagenPokemon = new Image(imageUrl);
             imgPokemon.setImage(imagenPokemon);
             
         } else {
             // Manejar el caso en que no hay Pokémones en la Pokédex
         }
    }
    @FXML
    void salirMenu(ActionEvent event) {
    
    		MenuController.show();
    		stage.close();
    }
    @FXML
    void capturarPokemon(ActionEvent event) throws ClassNotFoundException {
    	 boolean capturado = Entrenador.capturarPokemon();
         if (capturado) {
             mostrarAnimacionCaptura();
             CapturaCRUD.insertCapturaCaja(pokemonCapturado, entrenador);
         } else {
             // Mostrar un mensaje indicando que la captura falló
         }
   } 
         
         private void mostrarAnimacionCaptura() {
             // Aquí puedes mostrar la animación de captura utilizando un ImageView
             // y una secuencia de imágenes GIF
             // Por ejemplo:
             // 1. Cargar la secuencia de imágenes GIF en un ImageView
             // 2. Configurar una Timeline para mostrar las imágenes en secuencia
             // 3. Reproducir la animación
         }

    public void init(Entrenador entrenador, Stage stage, MenuController menuController) {
        this.stage = stage;
        this.entrenador = entrenador; // Asigna el entrenador recibido al campo del controlador
        try {
            ConexionBD conexionBD = new ConexionBD();
            Connection conexion = conexionBD.getConexion();
            pokedex = PokemonCRUD.obtenerPokedex(conexion); // Obtener todos los Pokémones de la Pokédex
        } catch (SQLException e) {
            e.printStackTrace(); // Manejar o registrar la excepción adecuadamente
        }
    }
}