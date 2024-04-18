package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import controller.LoginController;

public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {
        //Parent root = FXMLLoader.load(getClass().getResource("vistas/vistaLogin.fxml"));
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("../view(vistaLogin.fxml"));
		Parent root = loader.load();
		
        Scene scene = new Scene(loader.load());
        primaryStage.setTitle("Hello Pokemon World!");
        primaryStage.setScene(scene);
        
		
		LoginController controller = loader.getController();
		controller.setStage(primaryStage);
		
		primaryStage.show();
		
    }//HelloApplication correcto

    public static void main(String[] args) {
        launch(args);
    }
}