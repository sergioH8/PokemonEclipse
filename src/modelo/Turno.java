package modelo;


import java.util.LinkedList;

/**
 * Class Turno
 */
public class Turno {


    private int numeroTurno;

    public Turno() {
        this.numeroTurno = 1; // Comenzamos en el primer turno
    }


    public int getNumeroTurno() {
        return numeroTurno;
    }

    public void avanzarTurno() {
        numeroTurno++;
    }

    public void realizarAccion() {

        String accion = null;
        switch (accion) {
            case "ATACAR":
                Entrenador.atacar();
                break;
            case "USAR_OBJETO":
                Entrenador.usarObjeto();
                break;
            case "CAMBIAR_POKEMON":
                Entrenador.cambiarPokemon();
                break;
            case "RETIRARSE":
                Entrenador.retirarse();
                break;
            default:
                System.out.println("Acción no válida");
                break;
        }
        avanzarTurno();
    }
    
}