package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class CapturaController {
	
	private Stage stage;
	private MenuController menuController;

    @FXML
    public ImageView imgPokemon;
    @FXML
    public Button btnCapturar;
    @FXML
    public Button btnVolverMenu;
    @FXML
    public ImageView imgCaptura;

    @FXML
    void salirMenu(ActionEvent event) {
    	MenuController.show();//Crear el metodo en el Controller
		stage.close();
    }

}

