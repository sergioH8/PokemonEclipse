package modelo;


import java.util.LinkedList;

/**
 * Class Combate
 */
public class Combate {

    private Entrenador entrenador;
    private Entrenador entrenadorRival;
    private Pokemon pokemonEntrenador;
    private Pokemon pokemonEntrenadorRival;
    private Movimiento movimientoEntrenador;
    private Movimiento movimientoEntrenadorRival;
    private Turno turno;
    private LinkedList<Pokemon> pokemonEntrenadorKO;
    private LinkedList<Pokemon> pokemonEntrenadorRivalKO;
    private Entrenador ganador;

    /**
     * Constructor por defecto
     *
     */
    public Combate() {
        super();
        this.entrenador = new Entrenador();
        this.entrenadorRival = new Entrenador();
        this.pokemonEntrenador = null;
        this.pokemonEntrenadorRival = null;
        this.movimientoEntrenador = null;
        this.movimientoEntrenadorRival = null;
        this.turno = new Turno();
        this.pokemonEntrenadorKO = new LinkedList<Pokemon>();
        this.pokemonEntrenadorRivalKO = new LinkedList<Pokemon>();
        this.ganador = null;
    }

    /**
     * Constructor completo.
     *
     * @param entrenador
     * @param entrenadorRival
     * @param pokemonEntrenador
     * @param pokemonEntrenadorRival
     * @param movimientoEntrenador
     * @param movimientoEntrenadorRival
     * @param turno
     * @param pokemonEntrenadorKO
     * @param pokemonEntrenadorRivalKO
     * @param ganador
     */
    public Combate(Entrenador entrenador, Entrenador entrenadorRival, Pokemon pokemonEntrenador,
                   Pokemon pokemonEntrenadorRival, Movimiento movimientoEntrenador, Movimiento movimientoEntrenadorRival,
                   Turno turno, LinkedList<Pokemon> pokemonEntrenadorKO, LinkedList<Pokemon> pokemonEntrenadorRivalKO,
                   Entrenador ganador) {
        super();
        this.entrenador = entrenador;
        this.entrenadorRival = entrenadorRival;
        this.pokemonEntrenador = pokemonEntrenador;
        this.pokemonEntrenadorRival = pokemonEntrenadorRival;
        this.movimientoEntrenador = movimientoEntrenador;
        this.movimientoEntrenadorRival = movimientoEntrenadorRival;
        this.turno = turno;
        this.pokemonEntrenadorKO = pokemonEntrenadorKO;
        this.pokemonEntrenadorRivalKO = pokemonEntrenadorRivalKO;
        this.ganador = ganador;
    }

    public Entrenador getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(Entrenador entrenador) {
        this.entrenador = entrenador;
    }

    public Entrenador getEntrenadorRival() {
        return entrenadorRival;
    }

    public void setEntrenadorRival(Entrenador entrenadorRival) {
        this.entrenadorRival = entrenadorRival;
    }

    public Pokemon getPokemonEntrenador() {
        return pokemonEntrenador;
    }

    public void setPokemonEntrenador(Pokemon pokemonEntrenador) {
        this.pokemonEntrenador = pokemonEntrenador;
    }

    public Pokemon getPokemonEntrenadorRival() {
        return pokemonEntrenadorRival;
    }

    public void setPokemonEntrenadorRival(Pokemon pokemonEntrenadorRival) {
        this.pokemonEntrenadorRival = pokemonEntrenadorRival;
    }

    public Movimiento getMovimientoEntrenador() {
        return movimientoEntrenador;
    }

    public void setMovimientoEntrenador(Movimiento movimientoEntrenador) {
        this.movimientoEntrenador = movimientoEntrenador;
    }

    public Movimiento getMovimientoEntrenadorRival() {
        return movimientoEntrenadorRival;
    }

    public void setMovimientoEntrenadorRival(Movimiento movimientoEntrenadorRival) {
        this.movimientoEntrenadorRival = movimientoEntrenadorRival;
    }

    public Turno getTurno() {
        return turno;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
    }

    public LinkedList<Pokemon> getPokemonEntrenadorKO() {
        return pokemonEntrenadorKO;
    }

    public void setPokemonEntrenadorKO(LinkedList<Pokemon> pokemonEntrenadorKO) {
        this.pokemonEntrenadorKO = pokemonEntrenadorKO;
    }

    public LinkedList<Pokemon> getPokemonEntrenadorRivalKO() {
        return pokemonEntrenadorRivalKO;
    }

    public void setPokemonEntrenadorRivalKO(LinkedList<Pokemon> pokemonEntrenadorRivalKO) {
        this.pokemonEntrenadorRivalKO = pokemonEntrenadorRivalKO;
    }

    public Entrenador getGanador() {
        return ganador;
    }

    public void setGanador(Entrenador ganador) {
        this.ganador = ganador;
    }


    public boolean comprobarGanador() {
        try {
            if (ganador.equals(entrenador)) {

                return true;
            } else {

                return false;
            }
        } catch (NullPointerException e) {
            return false;
        }
    }

    /**
     * Calcula la cantidad de Pokedollars que va a ganar o perder el Entrenador en
     * relacion a quien sea el ganador del combate.
     *
     * @return int
     */
    public int calcularGananciaPerdida() {
        if (comprobarGanador()) {
            return entrenadorRival.getPokedolares() / 3;
        } else {
            return entrenador.getPokedolares() / 3;
        }
    }

    /**
     * Modifica los Pokedollar en relacion a quien haya sido el ganador del combate.
     *
     * @param e
     */
    public void entregarPokedollars(Entrenador e) {
        if (comprobarGanador()) {
            System.out.println(e.getNombre() + " obtuvo: " + calcularGananciaPerdida() + " pokedollars.");
            System.out.println(ganador.getNombre() + " es el ganador del combate.");

            // Actualizar Pokedollars para el ganador
            ganador.setPokedolares(ganador.getPokedolares() + calcularGananciaPerdida());

            // Actualizar Pokedollars para el perdedor
            e.setPokedolares((e.getPokedolares() * 2) / 3);
        } else {
            System.out.println(e.getNombre() + " perdió: " + calcularGananciaPerdida() + " pokedollars.");
            System.out.println(ganador.getNombre() + " (Rival) es el ganador del combate.");

            // Actualizar Pokedollars para el ganador (rival)
            ganador.setPokedolares(ganador.getPokedolares() + calcularGananciaPerdida());

            // Actualizar Pokedollars para el perdedor
            e.setPokedolares((e.getPokedolares() * 2) / 3);
        }
    }


    /**
     * Concede la victoria al entrenador rival.
     *
     */
    public void abandonarCombate() {
        System.out.println(("El jugador se retiró del combate."));
        ganador = entrenadorRival;

    }

    /**
     * Comprueba si el pokemon del entrenador rival ha quedado KO y lo agrega a su
     * lista de pokemons debilitados. Devuelve true si la vitalidad actual del
     * Pokemon es menor o igual a 0. En caso contrario devuelve false.
     *
     * @return boolean
     */
    public boolean pokemonRivalKO() {

        if (pokemonEntrenadorRival.getVitalidadActual() <= 0) {
            pokemonEntrenadorRivalKO.add(pokemonEntrenadorRival);
            System.out.println(("El pokemon: " + pokemonEntrenadorRival.getNombre() + " del rival, fué debilitado"));
            return true;
        }
        return false;
    }

    /**
     * Cambia el Pokemon del entrenador rival al siguiente de su lista.
     *
     */
    public void pokemonRivalCambio() {

        if (entrenadorRival.getEquipoPokemon().size() > pokemonEntrenadorRivalKO.size()) {
            pokemonEntrenadorRival = entrenadorRival.getEquipoPokemon().get(pokemonEntrenadorRivalKO.size());
            System.out.println(("El rival sacó a: " + pokemonEntrenadorRival.getNombre()));
        }
    }

    /**
     * Comprueba si el pokemon del entrenador ha quedado KO y lo agrega a su lista
     * de pokemons debilitados. Devuelve true si la vitalidad actual del Pokemon es
     * menor o igual a 0. En caso contrario devuelve false.
     *
     * @return boolean
     */
    public boolean pokemonPropioKO() {

        if (pokemonEntrenador.getVitalidadActual() <= 0) {
            pokemonEntrenadorKO.add(pokemonEntrenador);
            System.out.println(("El pokemon: " + pokemonEntrenador.getNombre() + " del jugador, fué debilitado."));
            return true;

        } else {
            return false;
        }

    }

    /**
     * Comprueba si todos los pokemons de alguno de los entrenadores han sido
     * debilitados. En cuyo caso, modifica el valor del ganador y concede la
     * victoria al entrenador contrario. Devuelve true en caso de que alguno de los
     * 2 entrenadores haya perdido a todos sus Pokemon. En caso contrario devuelve
     * false.
     *
     * @return boolean
     */
    public boolean comprobarKO() {

        if (pokemonEntrenadorKO.size() >= entrenador.getEquipoPokemon().size()) {
            ganador = entrenadorRival;
            return true;
        } else if (pokemonEntrenadorRivalKO.size() >= entrenadorRival.getEquipoPokemon().size()) {
            ganador = entrenador;
            return true;
        } else {
            return false;
        }

    }



    public void ataqueRival() {
   
        int indiceMovimientoAleatorio = (int) (Math.random() * Pokemon.getMovimientos().length);

        
        Movimiento movimientoSeleccionado = Pokemon.getMovimientos()[indiceMovimientoAleatorio];

   
        movimientoSeleccionado.ejecutar(pokemonEntrenadorRival, pokemonEntrenador);

       
        System.out.println("El Pokémon rival " + pokemonEntrenadorRival.getNombre() + " ha usado " + movimientoSeleccionado.getNombre());
    }

    public void ataquePropio(int indiceMovimiento) {
      
        if (indiceMovimiento < 0 || indiceMovimiento >= Pokemon.getMovimientos().length) {
            System.out.println("Índice de movimiento no válido.");
            return;
        }

       
        Movimiento movimientoSeleccionado = Pokemon.getMovimientos()[indiceMovimiento];

      
        movimientoSeleccionado.ejecutar(pokemonEntrenador, pokemonEntrenadorRival);

     
        System.out.println("El Pokémon " + pokemonEntrenador.getNombre() + " ha usado " + movimientoSeleccionado.getNombre());
    }


    /**
     * Comprueba la velocidad de ambos Pokemon en combate. Devuelve true si el valor
     * de velocidad del Pokemon del Entrenador es mayor o igual a la del Rival. En
     * caso contrario devuelve false.
     *
     * @return boolean
     */
    public boolean comprobarVelocidad() {
        if (pokemonEntrenador.getVelocidad() >= pokemonEntrenadorRival.getVelocidad()) {
            System.out.println(("El pokemon  es mas rapido y ataca primero."));
            return true;
        } else {
            System.out.println(("El pokemon  es mas lento y ataca en segundo lugar."));
            return false;
        }
    }

    /**
     * Finaliza el turno. Modifica los valores de los movimientos utilizados en
     * dicho turno a null y comprueba si alguno de los entrenadores ha perdido todos
     * sus Pokemon.
     *
     * @return boolean
     */
    public boolean finalTurno() {
        System.out.println(("Final del turno: " + turno.getNumeroTurno()));
        movimientoEntrenador = null;
        movimientoEntrenadorRival = null;

        return comprobarKO();
    }

}