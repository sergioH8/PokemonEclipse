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
        
		FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/vistaLogin.fxml"));
		Parent root = loader.load();
		
        Scene scene = new Scene(root);
        primaryStage.setTitle("Hello Pokemon World!");
        primaryStage.setScene(scene);
        
		
		LoginController controller = loader.getController();
		controller.setStage(primaryStage);
		
		primaryStage.show();
		
    }

    public static void main(String[] args) {
        launch(args);
    }
}