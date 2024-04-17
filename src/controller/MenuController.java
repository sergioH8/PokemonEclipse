package controller;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import modelo.Entrenador;

public class MenuController {
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


    private static Entrenador entrenadorActual;


    public void init(){
        SingletonEntrenador entrenador = SingletonEntrenador.getInstance(null);

        entrenadorActual = entrenador.value;
        System.out.println(entrenadorActual.getNombre());
    }
}


