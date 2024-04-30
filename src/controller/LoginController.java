package controller;


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import crud.ConexionBD;
import crud.EntrenadorCRUD;
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
import javafx.scene.input.MouseEvent;
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
    @FXML
    public ImageView imgSonido;
    @FXML
    public ImageView imgSinSonido;

    /**
     * Metodo para salir del programa por medio del System.exit;
     */
    @FXML
    public void cerrarApp(ActionEvent event) {
        Stage stage = (Stage) btnCerrar.getScene().getWindow();
        stage.close();
    }

    
    @FXML
    private void eventKey(KeyEvent event){
        Object evt = event.getSource();

        if(event.getCharacter().equals(" ")){
            event.consume();
        }
    }

	
    /**
     * Metodo para el boton "Iniciar sesion"
     * Mediante un If else controlo las diferentes opciones, poniendo mensajes de error en caso de que se inserten mal los datos o no se inserten
     * @param event
     * @throws SQLException
     */
    public void loguearme(ActionEvent event) throws SQLException{
        
        if(txtFUser.getText().isEmpty()){
            lblError.setText("Error: Inserta el usuario");
            lblError.setVisible(true);
        }else if(txtPassword.getText().isEmpty()) {
            lblError.setText("Error: Inserta la contraseña");
            lblError.setVisible(true);
        }else{ //Cuando están los dos campos escritos, recupero la informacion y realizo la consulta sql, estableciendo la conexion
            String nombre = txtFUser.getText();
            String pass = txtPassword.getText();

            String sql = "SELECT PASS" +
                    " FROM ENTRENADOR" +
                    " WHERE NOMBRE = ?";
			
			ConexionBD con = new ConexionBD();
			
			Connection conexion = con.getConexion();
			
			try{
				PreparedStatement pst = conexion.prepareStatement(sql);
				pst.setString(1, nombre);		
				ResultSet rs = pst.executeQuery();
				//Con la información de la base de datos, compruebo si el usuario está ya registrado o no, por medio de un if
				if(!rs.isBeforeFirst()){
					lblError.setText("Usuario no registrado.");
						lblError.setVisible(true);//Muestro el mensaje de error en la pantalla
				}else{
					while(rs.next()){//En principio solo va a haber un usuario
						if(rs.getString(1).equals(pass)){
							System.out.println("Usuario encontrado");
							Entrenador entrenador = new Entrenador(nombre, pass);
							//Cambiamos de ventana,entrando en la de menú
							try{
								FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/vistaMenu.fxml"));
								Parent root = loader.load();
								MenuController menuController = loader.getController(); 
								Scene scene = new Scene(root);
								Stage stage = new Stage();
								stage.setScene(scene);//Cargamos la escena en el stage.
								menuController.init(entrenador, stage, this);//Crear el método init en MenuController y le pasamos los datos
								stage.show();
								this.stage.close();
								
							}catch(IOException e){
								e.printStackTrace();
							}
							
						}else{
							lblError.setText("Contraseña incorrecta");
							lblError.setVisible(true);//Muestro el mensaje de error en caso de que la contraseña no coincida con la de la base de datos
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
    public void registrarme(ActionEvent event) throws SQLException{

            if(txtFUser.getText().isEmpty()){
                lblError.setText("Error: Inserta el usuario");
                lblError.setVisible(true);
            }else if(txtPassword.getText().isEmpty()) {
                lblError.setText("Error: Inserta la contraseña");
                lblError.setVisible(true);
            }else{
            	//Cuando están los dos campos escritos, recupero la informacion y realizo la consulta sql, estableciendo la conexion
                String nombre = txtFUser.getText();
                String pass = txtPassword.getText();

                String sql = "SELECT PASS" +
                        " FROM ENTRENADOR" +
                        " WHERE NOMBRE = ?";
    			
    			ConexionBD con = new ConexionBD();
    			
    			Connection conexion = con.getConexion();
    			
    			try{
    				PreparedStatement pst = conexion.prepareStatement(sql);
    				pst.setString(1, nombre);
    				
    				ResultSet rs = pst.executeQuery();
    				
    				Entrenador entrenador = new Entrenador(nombre, pass);
    				
    				if(!rs.isBeforeFirst()){//Si no hay un usuario conectado con el mismo nombre y contraseña, llama al metodo para crear uno nuevo
    					EntrenadorCRUD.crearEntNuevo(conexion, entrenador);
    					//Pasamos a la siguiente pantalla, la de menu
    					try{
							FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/vistaMenu.fxml"));
							Parent root = loader.load();
							MenuController menuController = loader.getController(); 
							Scene scene = new Scene(root);
							Stage stage = new Stage();
							stage.setScene(scene);//Cargamos la escena en el stage.
							menuController.init(entrenador, stage, this);//Crear el método init en MenuController y le pasamos los datos
							stage.show();
							this.stage.close();
							
						}catch(IOException e){
							e.printStackTrace();
						}
    				}else{
    					//Si el usuario que se quiere registrar se encuentra ya en la base de datos, no deja registrarse y muestra un mensaje de error
    					while(rs.next()){
    							lblError.setText("El usuario ya existe. Inicie sesión");
    							lblError.setVisible(true);
    						}
    					
    				}
    			}catch(SQLException e) {
    				e.printStackTrace();
    			}
            }
        }

	
	public void show() {
		stage.show();
		lblError.setVisible(false);//Oculto el mensaje de error en caso de que apareciera 
		txtFUser.setText("");//Al salir del menu al Login, se borra el usuario y la contraseña
		txtPassword.setText("");
	}
	
	public void setStage(Stage primaryStage) {
		stage = primaryStage;
		
	}
	
	

	
//	public void initialize() { //Metodo para poner el sonido en la pantalla de Login
//        String sonido = "../../inicio.wav";
//               
//        Media sound = new Media(new File(sonido).toURI().toString());
//        mediaPlayer = new MediaPlayer(sound);
//        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);//Cuando acabe el audio volvera a empezar
//        mediaPlayer.play();
//	}
	
	/**
	 * 
	 * @param event
	 */
    @FXML
    public void silenciar(MouseEvent event) {
    	imgSinSonido.setVisible(true);
    }
    
    @FXML
    void ponerSonido(MouseEvent event) {
    	imgSinSonido.setVisible(false);
    }
    
    
}





