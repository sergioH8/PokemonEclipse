package modelo;


import java.util.LinkedList;

/**
 * Class Entrenador
 */
public class Entrenador {

    //
    // Fields
    //

    private int pokedolares;
    private LinkedList<Pokemon> equipoPokemon;  //Caja0 para metodos
    private LinkedList<Pokemon> cajaPokemon;    //Caja1 para metodos

    private int idEntrenador;
    private String nombre;
    private String pass;
    private LinkedList <Objeto> objetos;
    public Pokedex pokedexEntrenador;

    /**
     * Constructor por defecto
     */
    public Entrenador() {
        this.pokedolares = 0;
        this.equipoPokemon = null;
        this.cajaPokemon = null;
        this.idEntrenador = 0;
        this.nombre = " ";
        this.pass = " ";
        this.objetos = null;
        this.pokedexEntrenador = new Pokedex();
    }
    
    /**
     * Constructor con Nombre y Contraseña
     * @param nombre
     * @param pass
     */
    public Entrenador(String nombre, String pass) {
		this.nombre = nombre;
		this.pass = pass;
	}

    /**
     * Constructor con todos los parametros
     * @param pokedolares
     * @param equipoPokemon
     * @param cajaPokemon
     * @param idEntrenador
     * @param nombre
     * @param pass
     * @param objeto
     * @param pokedexEntrenador
     * @param objetos 
     */
    public Entrenador(int pokedolares, LinkedList<Pokemon> equipoPokemon,
                      LinkedList<Pokemon> cajaPokemon, int idEntrenador, String nombre,
                      String pass, LinkedList<Objeto> objetos, Pokedex pokedexEntrenador) {
        this.pokedolares = pokedolares;
        this.equipoPokemon = equipoPokemon;
        this.cajaPokemon = cajaPokemon;
        this.idEntrenador = idEntrenador;
        this.nombre = nombre;
        this.pass = pass;
        this.objetos = objetos;
        this.pokedexEntrenador = pokedexEntrenador;
    }

    /**
     * Constructor copia
     * @param e
     */
    public Entrenador(Entrenador e) {
        this.pokedolares = e.pokedolares;
        this.equipoPokemon = e.equipoPokemon;
        this.cajaPokemon = e.cajaPokemon;
        this.idEntrenador = e.idEntrenador;
        this.nombre = e.nombre;
        this.pass = e.pass;
        this.objetos = e.objetos;
        this.pokedexEntrenador = e.pokedexEntrenador;
    }


    public void setPokedolares(int pokedolares) {
        this.pokedolares = pokedolares;
    }

  
    public int getPokedolares() {
        return pokedolares;
    }

  
    public void setEquipoPokemon(LinkedList<Pokemon> equipoPokemon) {
        this.equipoPokemon = equipoPokemon;
    }

  
    public LinkedList<Pokemon> getEquipoPokemon() {
        return equipoPokemon;
    }

   
    public void setCajaPokemon(LinkedList<Pokemon> cajaPokemon) {
        this.cajaPokemon = cajaPokemon;
    }


    public LinkedList<Pokemon> getCajaPokemon() {
        return cajaPokemon;
    }


    public void setIdEntrenador(int idEntrenador) {
        this.idEntrenador = idEntrenador;
    }

 
    public int getIdEntrenador() {
        return idEntrenador;
    }
   
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

   
    public String getNombre() {
        return nombre;
    }


    public void setPass(String pass) {
        this.pass = pass;
    }

   
    public String getpass() {
        return pass;
    }

    public LinkedList <Objeto> getObjetos() {
		return objetos;
	}

	public void setObjetos(LinkedList <Objeto> objetos) {
		this.objetos = objetos;
	}

 
    public void setTiene(Pokedex pokedexEntrenador) {
        this.pokedexEntrenador = pokedexEntrenador;
    }


    public Pokedex getTiene() {
        return pokedexEntrenador;
    }



    /**
     * Calcula aleatoriamente la posibilidad de capturar un Pokemon, tiene 1/3 de
     * posibilidades
     *
     * @return boolean
     */
    public boolean capturarPokemon() {
        int numeroAleatorio = (int) (Math.random() * 3 + 1);
        if (numeroAleatorio == 1 || numeroAleatorio == 2) {
            return true;
        } else {
            return false;
        }
    }

	public static void atacar() {
		
		
	}

	public static void usarObjeto() {
		
		
	}

	public static void cambiarPokemon() {
		
		
	}

	public static void retirarse() {
	
		
	}



	
}