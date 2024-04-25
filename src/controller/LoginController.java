package controller;


import java.io.File;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import crud.ConexionBD;
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
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Modality;
import javafx.stage.Stage;
import modelo.Entrenador;

public class LoginController {
	
	private Stage stage;
	private MediaPlayer mediaPlayer;
	
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




	
    /*
	METODO DE LOGIN DE LUISRE
	*/
    public void loguearme(ActionEvent event) throws SQLException{
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

            String sql = "SELECT PASS" +
                    " FROM ENTRENADOR" +
                    " WHERE NOMBRE = ?";
			
			ConexionBD con = new ConexionBD();
			
			Connection conexion = con.getConexion();
			
			try{
				PreparedStatement pst = conexion.prepareStatement(sql);
				pst.setString(1, usuario);
				
				
				ResultSet rs = pst.executeQuery(); //En el Statement si se necesita st.executeQuery(sql), pero el pst no necesita pasar la SQL, solo executeQuery
				if(!rs.isBeforeFirst()){
					lblError.setText("Usuario no registrado.");
						lblError.setVisible(true);
				}else{
					while(rs.next()){
						if(rs.getString(1).equals(pass)){
							System.out.println("Usuario encontrado");
							//Cambiamos de ventana
							try{
								FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/vistaMenu.fxml"));
								Parent root = loader.load();
								MenuController menuController = loader.getController(); 
								Scene scene = new Scene(root);
								Stage stage = new Stage();
								stage.setScene(scene);//Cargamos la escena en el stage.
								Entrenador entrenador = new Entrenador();
								menuController.init(entrenador, stage, this);//Crear el método init en MenuController y le pasamos los datos
								stage.show();
								this.stage.close();
								
							}catch(IOException e){
								e.printStackTrace();
							}
							
						}else{
							lblError.setText("Contraseña incorrecta");
							lblError.setVisible(true);
						}
					}
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
        }
    }

     
	 
	 

    /**
     * Metodo para registrarse en la base de datos cuando los datos no existen ya en esta
     * @param event
     */
    @FXML
    public void registrarme(ActionEvent event) {
      
    }
	
	public void show() {
		stage.show();
		lblError.setVisible(false);
		txtFUser.setText("");//Al salir del menu al Login, se borra el usuario y la contraseña
		txtPassword.setText("");
	}
	
	public void setStage(Stage primaryStage) {
		stage = primaryStage;
		
	}
	
	//Se puede poner un boton para quitar el sonido o ponerlo en la pantalla de inicio
//	public void activarDesactivarSonido(MouseEvent event) {
//		
//	}
	
//	public void initialize() { //Metodo para poner el sonido en la pantalla de Login
//        String sonido = "../../inicio.wav";
//               
//        Media sound = new Media(new File(sonido).toURI().toString());
//        mediaPlayer = new MediaPlayer(sound);
//        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);//Cuando acabe el audio volvera a empezar
//        mediaPlayer.play();
//	}
}





