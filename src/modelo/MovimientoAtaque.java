package modelo;

/**
 * Class MoviminetoAtaque
 */
public class MovimientoAtaque extends Movimiento {



    private int potencia;
    private static Tipo tipo;

    public MovimientoAtaque () { }

    @Override
    public void ejecutar(Pokemon atacante, Pokemon objetivo) {

    }

    @Override
    public boolean calcularProbabilidad() {
        return false;
    }



    public void setPotencia (int potencia) {
        this.potencia = potencia;
    }

    public int getPotencia () {
        return potencia;
    }


    public void setTipo (Tipo tipo) {
        this.tipo = tipo;
    }


    public static Tipo getTipo() {
        return tipo;
    }


    /**
     * @param        nombre
     * @param        tipoPokemonAtacante
     * @param        tipoPokemonDefensivo1
     */
    public void calculateEndDamage(MovimientoAtaque nombre, Tipo tipoPokemonAtacante, Tipo tipoPokemonDefensivo1, Tipo tipoPokemonDefensivo2) {
        // Obtener los índices correspondientes para el tipo de ataque y el tipo del Pokémon defensivo
        int indiceAtaque = tipoPokemonAtacante.ordinal();
        int indiceDefensivo1 = tipoPokemonDefensivo1.ordinal();

        // Obtener el multiplicador de daño del primer tipo defensivo
        double multiplicador1 = Tipo.multiplicadores[indiceAtaque][indiceDefensivo1];
        double danyoFinal1 = nombre.getPotencia() * multiplicador1;

        // Calcular el daño final para el primer tipo defensivo
        double danyoFinal = danyoFinal1;

        // Si hay un segundo tipo defensivo, calcular su multiplicador y daño final
        if (tipoPokemonDefensivo2 != null) {
            int indiceDefensivo2 = tipoPokemonDefensivo2.ordinal();
            double multiplicador2 = Tipo.multiplicadores[indiceAtaque][indiceDefensivo2];
            double danyoFinal2 = danyoFinal1 * multiplicador2;

            // Actualizar el daño final
            danyoFinal = danyoFinal2;
        }

        // Si el ataque es del mismo tipo que el Pokémon atacante, incrementar el daño final
        if (tipoPokemonAtacante == tipoPokemonDefensivo1 || tipoPokemonAtacante == tipoPokemonDefensivo2) {
            danyoFinal *= 1.5;
        }
        
    }



}
