package controller;

import modelo.Entrenador;
import crud.PokemonCRUD;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class MenuController {
	//Añadir atributos manualmente de Entrenador
	
	public static final int EQUIPOPRINCIPAL = 1;
	public static final int EQUIPOSECUNDARIO = 0;
	
	private Entrenador entrenador;
	private static Stage stage;
	private LoginController loginController; //Controller del Login, porque en el menú hay un boton de "salir" que conecta el menu con el Login
	//De esta forma, al "salir" no cierra la aplicación, sino que va a la anterior pantalla para cambiar de usuario.
	
	
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
	@FXML
    public Label lblUsuario;
    


    


    public void init(Entrenador ent, Stage stage2, LoginController loginController){ //Método con los parametros!!!
        lblUsuario.setText(ent.getNombre());//Aparece el nombre de usuario en el menú.
		this.loginController = loginController;
		this.stage = stage2;
		//Con estos métodos cogemos la información del usuario y la cargamos en la pantalla principal para poder acceder a ella cuando se necesite.
		this.entrenador = ent;
		DataBaseConnection con = new DataBaseCOnnection();
		
		Connection conexion = con.getConnection();
		
		try {
			PokemonCRUD.obtenerPokemon();
			
		}
		//cargarEquipo(EQUIPOPRINCIPAL);//Equipo principal, por medio de un método.
		//cargarEquipo(EQUIPOSECUNDARIO);//Equipo secundario
		//cargarMochilaEntrenador();//Metodo para cargar los objetos del entrenador
		
    }
	
	public void salir(MouseEvent event) {
		loginController.show();//Crear el metodo en el Controller
		stage.close();
    }

	public static void show() {
		stage.show();
	}
}
