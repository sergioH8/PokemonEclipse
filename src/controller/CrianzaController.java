package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class CrianzaController {
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

            FXMLLoader carga = new FXMLLoader(getClass().getResource("src/main/resources/com/example/proyectopokemonlatigocepa/vistas/vistaMenu.fxml"));
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
}