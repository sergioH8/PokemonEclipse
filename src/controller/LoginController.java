package controller;



import crud.LoginCRUD;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import modelo.Entrenador;

public class LoginController {
    @FXML
    public ImageView imgLogin;
    @FXML
    public TextField txtFUser;
    @FXML
    public Label lblError;
    @FXML
    private PasswordField txtPassword;
    @FXML
    public Button btnIniciarSesion;
    @FXML
    public Button btnCerrar;
    @FXML
    public Button btnRegistrar;
    @FXML
    public ImageView imgLogo;

    /**
     * Metodo para salir del programa por medio del System.exit;
     */
    @FXML
    public void cerrarApp(ActionEvent event) {
        Stage stage = (Stage) btnCerrar.getScene().getWindow();
        stage.close();
        //Otra opción para cerrar la ventana: System.exit(0);
    }


    @FXML
    private void eventKey(KeyEvent event){
        Object evt = event.getSource();

        if(event.getCharacter().equals(" ")){
            event.consume();
        }
        /*
        if(evt.equals(txtFUser)){
            if(event.getCharacter().equals(" ")){
                event.consume();
            }
        }else if(evt.equals(txtPassword)){
            if(event.getCharacter().equals(" ")){
                event.consume();
            }
        }
         */

    }


    /**
     * Metodo para iniciar sesion
     */

        @FXML
    public void loguearme(ActionEvent event) {
        LoginCRUD.inicioSesion(txtFUser.getText(), txtPassword.getText());
        if(txtFUser != null && txtPassword != null){
            try{
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("src/main/java/com/e/vistas/vistaMenu.fxml"));
                Parent root = fxmlLoader.load();
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                Stage stageActual = (Stage) btnIniciarSesion.getScene().getWindow();
                stageActual.close();

                MenuController menuController = fxmlLoader.getController();
                Entrenador entrenador = new Entrenador();

                entrenador.setNombre(txtFUser.getText());
                entrenador.setPass(txtPassword.getText());

                SingletonEntrenador.getInstance(entrenador);

                menuController.init();

                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setScene(scene);
                stage.showAndWait();

            }catch (Exception e){
                e.printStackTrace();
            }
        }else{
            System.out.println("Usuario y/o contraseña no válidos.");
        }
    }

    /*
    public void loguearme(ActionEvent event) {
        Object evt = event.getSource();

        if(txtFUser.getText().isEmpty()){
            lblError.setText("Error: Inserta el usuario");
            lblError.setVisible(true);
        }else if(txtPassword.getText().isEmpty()) {
            lblError.setText("Error: Inserta la contraseña");
            lblError.setVisible(true);
        }else{
            String usuario = txtFUser.getText();
            String pass = txtPassword.getText();

            String sql = "SELECT COUNT(*)" +
                    " FROM ENTRENADOR" +
                    " WHERE NOMBRE = ?" +
                    " AND PASS = ?";
        }
    }

     */

    /**
     * Metodo para registrarse en la base de datos cuando los datos no existen ya en esta
     * @param event
     */
    @FXML
    public void registrarme(ActionEvent event) {
        LoginCRUD.registroSesion(txtFUser.getText(), txtPassword.getText());
        if(txtFUser == null && txtPassword == null){
            try{
                FXMLLoader fxmlLoader2 = new FXMLLoader(getClass().getResource("../vistas/vistaMenu.fxml"));
                Parent root = fxmlLoader2.load();
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                Stage stageActual = (Stage) btnRegistrar.getScene().getWindow();
                stageActual.close();

                MenuController menuController = fxmlLoader2.getController();
                Entrenador entrenador = new Entrenador();
                entrenador.setNombre(txtFUser.getText());
                entrenador.setPass(txtPassword.getText());


                menuController.init();

                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setScene(scene);
                stage.showAndWait();

            }catch (Exception e){
                e.printStackTrace();
            }
        }else{
            System.out.println("Registro incorrecto.");
        }
    }



}




