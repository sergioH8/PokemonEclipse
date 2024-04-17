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
    private Objeto objeto;
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
        this.objeto = new Objeto();
        this.pokedexEntrenador = new Pokedex();
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
     */
    public Entrenador(int pokedolares, LinkedList<Pokemon> equipoPokemon,
                      LinkedList<Pokemon> cajaPokemon, int idEntrenador, String nombre,
                      String pass, Objeto objeto, Pokedex pokedexEntrenador) {
        this.pokedolares = pokedolares;
        this.equipoPokemon = equipoPokemon;
        this.cajaPokemon = cajaPokemon;
        this.idEntrenador = idEntrenador;
        this.nombre = nombre;
        this.pass = pass;
        this.objeto = objeto;
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
        this.objeto = e.objeto;
        this.pokedexEntrenador = e.pokedexEntrenador;
    }

    ;

    //
    // Methods
    //


    //
    // Accessor methods: GETTER Y SETTER
    //

    /**
     * Set the value of pokedolares
     *
     * @param pokedolares the new value of pokedolares
     */
    public void setPokedolares(int pokedolares) {
        this.pokedolares = pokedolares;
    }

    /**
     * Get the value of pokedolares
     *
     * @return the value of pokedolares
     */
    public int getPokedolares() {
        return pokedolares;
    }

    /**
     * Set the value of equipoPokemon
     *
     * @param equipoPokemon the new value of equipoPokemon
     */
    public void setEquipoPokemon(LinkedList<Pokemon> equipoPokemon) {
        this.equipoPokemon = equipoPokemon;
    }

    /**
     * Get the value of equipoPokemon
     *
     * @return the value of equipoPokemon
     */
    public LinkedList<Pokemon> getEquipoPokemon() {
        return equipoPokemon;
    }

    /**
     * Set the value of cajaPokemon
     *
     * @param cajaPokemon the new value of cajaPokemon
     */
    public void setCajaPokemon(LinkedList<Pokemon> cajaPokemon) {
        this.cajaPokemon = cajaPokemon;
    }

    /**
     * Get the value of cajaPokemon
     *
     * @return the value of cajaPokemon
     */
    public LinkedList<Pokemon> getCajaPokemon() {
        return cajaPokemon;
    }

    /**
     * Set the value of idEntrenador
     *
     * @param idEntrenador the new value of nombre
     */
    public void setIdEntrenador(int idEntrenador) {
        this.idEntrenador = idEntrenador;
    }

    /**
     * Get the value of idEntrenador
     *
     * @return the value of idEntrenador
     */
    public int getIdEntrenador() {
        return idEntrenador;
    }
    /**
     * Set the value of nombre
     *
     * @param nombre the new value of nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Get the value of nombre
     *
     * @return the value of nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Set the value of pass
     *
     * @param pass the new value of pass
     */
    public void setPass(String pass) {
        this.pass = pass;
    }

    /**
     * Get the value of pass
     *
     * @return the value of pass
     */
    public String getpass() {
        return pass;
    }
    /**
     * Set the value of objeto
     *
     * @param objeto the new value of objeto
     */
    public void setObjeto(Objeto objeto) {
        this.objeto = objeto;
    }

    /**
     * Get the value of objeto
     *
     * @return the value of objeto
     */
    public Objeto getObjeto() {
        return objeto;
    }

    /**
     * Set the value of m_tiene
     *
     * @param pokedexEntrenador the new value of m_tiene
     */
    public void setTiene(Pokedex pokedexEntrenador) {
        this.pokedexEntrenador = pokedexEntrenador;
    }

    /**
     * Get the value of m_tiene
     *
     * @return the value of m_tiene
     */
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
        if (numeroAleatorio == 1) {
            return true;
        } else {
            return false;
        }
    }


    public static void atacar() {

    }

    public static void usarObjeto() {

    }

    public static void retirarse() {

    }


    public static void cambiarPokemon() {

    }

}