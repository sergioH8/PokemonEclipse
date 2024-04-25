package modelo;

import java.util.LinkedList;
import java.util.Random;

import javafx.scene.image.Image;

public class Pokemon {

    public final int EXPERIENCIA_SUBIR_NIVEL = 10;
	public static final int EQUIPOPRINCIPAL = 1;
	public static final int EQUIPOSECUNDARIO = 0;
	
    private int idPokemon;
    private int numPokedex;
    private String nombre;
    private String mote;
    private int nivel;
    private int experienciaObtenida;
    private int vitalidad;
    private int vitalidadActual;
    private int ataque;
    private int ataqueEspecial;
    private int defensa;
    private int defensaEspecial;
    private int velocidad;
    private int fertilidad;
    private boolean sexo;
    static Movimiento[] movimientos = new Movimiento[4];
    static Tipo tipo1;
    static Tipo tipo2;
    private int nivelEvolucion;
    private String estado;
    private Objeto objeto;
    private String imgFrontal;
    private String imgTrasera;

    /**
     * Constructor por defecto.
     *
     */
    public Pokemon() {
        super();
        this.idPokemon = 0;
        this.numPokedex = 0;
        this.nombre = "";
        this.mote = "";
        this.nivel = 1;
        this.experienciaObtenida = 0;
        this.vitalidad = 1;
        this.vitalidadActual = 1;
        this.ataque = 1;
        this.ataqueEspecial = 1;
        this.defensa = 1;
        this.defensaEspecial = 1;
        this.velocidad = 1;
        this.fertilidad = 5;
        this.sexo = true;    // asumimos que true es macho
        this.movimientos = null;
        this.tipo1 = null;
        this.tipo2 = null;
        this.nivelEvolucion = 0;
        this.estado = "";
        this.objeto = null;
        this.imgFrontal = "";
        this.imgTrasera = "";
    }

    /**
     * Constructor Pokédex
     *
     * @param numPokedex
     * @param nombre
     * @param tipo1
     * @param tipo2
     * @param nivelEvolucion
     * @param imgFrontal
     * @param imgTrasera
     */
    public Pokemon(int numPokedex, String nombre, Tipo tipo1, Tipo tipo2,
                   int nivelEvolucion, String imgFrontal, String imgTrasera) {
        this.numPokedex = numPokedex;
        this.nombre = nombre;
        this.tipo1 = tipo1;
        this.tipo2 = tipo2;
        this.nivelEvolucion = nivelEvolucion;
        this.imgFrontal = imgFrontal;
        this.imgTrasera = imgTrasera;
    }
    /**
     * Constructor copia
     *
     * @param p
     */
    public Pokemon(Pokemon p) {
        this.idPokemon = p.idPokemon;
        this.numPokedex = p.numPokedex;
        this.nombre = p.nombre;
        this.mote = p.mote;
        this.nivel = p.nivel;
        this.experienciaObtenida = p.experienciaObtenida;
        this.vitalidad = p.vitalidad;
        this.vitalidadActual = p.vitalidadActual;
        this.ataque = p.ataque;
        this.ataqueEspecial = p.ataqueEspecial;
        this.defensa = p.defensa;
        this.defensaEspecial = p.defensaEspecial;
        this.velocidad = p.velocidad;
        this.fertilidad = p.fertilidad;
        this.sexo = p.sexo;
        this.movimientos = p.movimientos;
        this.tipo1 = p.tipo1;
        this.tipo2 = p.tipo2;
        this.nivelEvolucion = p.nivelEvolucion;
        this.estado = p.estado;
        this.objeto = p.objeto;
        this.imgFrontal = p.imgFrontal;
        this.imgTrasera = p.imgTrasera;
    }

    /**
     * Constructor completo.
     *
     * @param idPokemon
     * @param numPokedex
     * @param nombre
     * @param mote
     * @param nivel
     * @param experienciaObtenida
     * @param vitalidad
     * @param vitalidadActual
     * @param ataque
     * @param ataqueEspecial
     * @param defensa
     * @param defensaEspecial
     * @param velocidad
     * @param fertilidad
     * @param sexo
     * @param movimientos
     * @param tipo1
     * @param tipo2
     * @param nivelEvolucion
     * @param estado
     * @param objeto
     * @param imgFrontal
     * @param imgTrasera
     */
    public Pokemon(int idPokemon, int numPokedex, String nombre, String mote, int nivel, int experienciaObtenida,
                   int vitalidad, int vitalidadActual, int ataque, int ataqueEspecial, int defensa, int defensaEspecial,
                   int velocidad, int estamina, int estaminaActual, int fertilidad, boolean sexo,
                   Movimiento[] movimientos , Tipo tipo1, Tipo tipo2, int nivelEvolucion,
                   String estado, Objeto objeto, String imgFrontal, String imgTrasera) {
        super();
        this.idPokemon = idPokemon;
        this.numPokedex = numPokedex;
        this.nombre = nombre;
        this.mote = mote;
        this.nivel = nivel;
        this.experienciaObtenida = experienciaObtenida;
        this.vitalidad = vitalidad;
        this.vitalidadActual = vitalidadActual;
        this.ataque = ataque;
        this.ataqueEspecial = ataqueEspecial;
        this.defensa = defensa;
        this.defensaEspecial = defensaEspecial;
        this.velocidad = velocidad;
        this.fertilidad = fertilidad;
        this.sexo = sexo;
        this.movimientos = movimientos;
        this.tipo1 = tipo1;
        this.tipo2 = tipo2;
        this.nivelEvolucion = nivelEvolucion;
        this.estado = estado;
        this.objeto = objeto;
        this.imgFrontal = imgFrontal;
        this.imgTrasera = imgTrasera;
    }


    public int getIdPokemon() {
        return idPokemon;
    }

    public void setIdPokemon(int idPokemon) {
        this.idPokemon = idPokemon;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMote() {
        return mote;
    }

    public void setMote(String mote) {
        this.mote = mote;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getVitalidad() {
        return vitalidad;
    }

    public void setVitalidad(int vitalidad) {
        this.vitalidad = vitalidad;
    }

    public int getVitalidadActual() {
        return vitalidadActual;
    }

    public void setVitalidadActual(int vitalidadActual) {
        this.vitalidadActual = vitalidadActual;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getAtaqueEspecial() {
        return ataqueEspecial;
    }

    public void setAtaqueEspecial(int ataqueEspecial) {
        this.ataqueEspecial = ataqueEspecial;
    }

    public int getDefensa() {
        return defensa;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    public int getDefensaEspecial() {
        return defensaEspecial;
    }

    public void setDefensaEspecial(int defensaEspecial) {
        this.defensaEspecial = defensaEspecial;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }


    public int getFertilidad() {
        return fertilidad;
    }

    public void setFertilidad(int fertilidad) {
        this.fertilidad = fertilidad;
    }

    public boolean getSexo() {
        return sexo;
    }

    public void setSexo(boolean sexo) {
        this.sexo = sexo;
    }


    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public static Movimiento[] getMovimientos() {
        return movimientos;
    }
    public void setMovimientos(Movimiento[] movimientos) {
        this.movimientos = movimientos;
    }


    public Objeto getObjeto() {
        return objeto;
    }

    public void setObjeto(Objeto objeto) {
        this.objeto = objeto;
    }

    public static Tipo getTipoPrimario() {
        return tipo1;
    }

    public void setTipoPrimario(Tipo tipo1) {
        Pokemon.tipo1 = tipo1;
    }

    public static  Tipo getTipoSecundario() {
        return tipo2;
    }

    public void setTipoSecundario(Tipo tipo2) {
        Pokemon.tipo2 = tipo2;
    }

    public int getNumPokedex() {
        return numPokedex;
    }

    public void setNumPokedex(int numPokedex) {
        this.numPokedex = numPokedex;
    }

    public  String getImgFrontal() {
        return imgFrontal;
    }

    public void setImgFrontal(String imgFrontal) {
        this.imgFrontal = imgFrontal;
    }

    public String getImgTrasera() {
        return imgTrasera;
    }

    public void setImgTrasera(String imgTrasera) {
        this.imgTrasera = imgTrasera;
    }

    public int getExperienciaObtenida() {
        return experienciaObtenida;
    }

    public void setExperienciaObtenida(int experienciaObtenida) {
        this.experienciaObtenida = experienciaObtenida;
    }

    public int getNivelEvolucion() {
        return nivelEvolucion;
    }

    public void setNivelEvolucion(int nivelEvolucion) {
        this.nivelEvolucion = nivelEvolucion;
    }

    /**
     * Comprueba si un Pokemon tiene la experiencia necesaria para subir de nivel.
     * Si puede, aumenta su nivel, resta la experiencia usada para ello y aumenta
     * sus estadisticas de forma aleatoria. Devuelve true si sube de nivel y false
     * en el caso contrario.
     *
     * @return boolean
     */
    public boolean subirNivel() {
        Random random = new Random();
        while (this.experienciaObtenida >= (this.EXPERIENCIA_SUBIR_NIVEL * nivel)) {
            this.experienciaObtenida -= (this.EXPERIENCIA_SUBIR_NIVEL * nivel);
            this.nivel++;
            this.ataque += random.nextInt(4) + 1;
            this.ataqueEspecial += random.nextInt(4) + 1;
            this.defensa += random.nextInt(4) + 1;
            this.defensaEspecial += random.nextInt(4) + 1;
            this.velocidad += random.nextInt(4) + 1;
            this.vitalidad += this.velocidad += random.nextInt(4) + 1; // Genera un número aleatorio entre 1 y 4

            return true;
        }
        return false;
    }

    /**
     * Le da a un Pokemon las estadisticas que no forman parte de la Pokedex de
     * forma aleatoria. Nivel. Vitalidad. Vitalidad actual. Ataque. Ataque especial.
     * Defensa. Defensa especial. Velocidad. Estamina. Estamina actual. Fertilidad.
     * Sexo.
     *
     */
    public  static Pokemon randomPokemon(LinkedList<Pokemon> pokedex) {
        Random random = new Random();
        int randomIndex = random.nextInt(151) + 1; // Genera un número aleatorio entre 1 y 151, sumo +1 por que el ultimo valor se excluye
        Pokemon pkmnRandom = pokedex.get(randomIndex);

        pkmnRandom.setNivel(1);
        pkmnRandom.setVitalidad(random.nextInt(11) + 15); //Genera un número aleatorio entre 0 y 10, y luego se suma 15 para asegurarse de que la vitalidad esté en el rango de 15 a 25
        pkmnRandom.setAtaque(random.nextInt(10) + 1);
        pkmnRandom.setAtaqueEspecial(random.nextInt(10) + 1);
        pkmnRandom.setDefensa(random.nextInt(10) + 1);
        pkmnRandom.setDefensaEspecial(random.nextInt(10) + 1);
        pkmnRandom.setVelocidad(random.nextInt(10) + 1);
        pkmnRandom.setVitalidadActual(pkmnRandom.getVitalidad());
        pkmnRandom.setFertilidad(5);

        // Genera un número aleatorio entre 1 y 3, si es 2, el Pokémon es hembra, de lo contrario, es macho
        pkmnRandom.sexo = random.nextInt(3) == 2;

        return pkmnRandom;
    }

    /**
     * Comprueba si el nivel de un Pokemon es igual al nivel necesario para
     * evolucionar. Si lo esta, devuelve true, si no, devuelve false.
     *
     * @return boolean
     */
    public boolean evolucionar() {
        if (this.nivel == this.nivelEvolucion) {

            return true;
        }
        return false;
    }

	


}
