package modelo;

/**
 * Class MovimientoEstado
 */
public class MovimientoEstado extends Movimiento {


    private int longevidad;
    private Estado estado;

    //
    // Constructors
    //
    public MovimientoEstado () { }

    @Override
    public void ejecutar(Pokemon atacante, Pokemon objetivo) {

    }

   



    public void setLongevidad (int longevidad) {

        this.longevidad = longevidad;
    }


    public int getLongevidad () {

        return longevidad;
    }


    public void setEstado (Estado estado) {

        this.estado = estado;
    }


    public Estado getEstado () {

        return estado;
    }


    public void aplicarEstado(Movimiento nombre) {
        switch (estado) {
            case PARALIZADO:
                // Código para aplicar los efectos de estar paralizado
                break;
            case QUEMADO:
                // Código para aplicar los efectos de estar quemado
                break;
            case ENVENENADO:
                // Código para aplicar los efectos de estar envenenado
                break;
            case GRAVEMENTE_ENVENENADO:
                // Código para aplicar los efectos de estar gravemente envenenado
                break;
            case DORMIDO:
                // Código para aplicar los efectos de estar dormido
                break;
            case CONGELADO:
                // Código para aplicar los efectos de estar congelado
                break;
            case HELADO:
                // Código para aplicar los efectos de estar helado
                break;
            case SOMNOLIENTO:
                // Código para aplicar los efectos de estar somnoliento
                break;
            case POKERUS:
                // Código para aplicar los efectos del estado pokerus
                break;
            case DEBILITADO:
                // Código para aplicar los efectos del estado debilitado
                break;
            case CONFUSO:
                // Código para aplicar los efectos de estar confuso
                break;
            case ENAMORADO:
                // Código para aplicar los efectos de estar enamorado
                break;
            case ATRAPADO:
                // Código para aplicar los efectos de estar atrapado
                break;
            case MALDITO:
                // Código para aplicar los efectos del estado maldito
                break;
            case DRENADORAS:
                // Código para aplicar los efectos del estado drenadoras
                break;
            case CANTO_MORTAL:
                // Código para aplicar los efectos del estado canto mortal
                break;
            case CENTRO_DE_ATENCION:
                // Código para aplicar los efectos del estado centro de atención
                break;
            case AMEDRENTADO:
                // Código para aplicar los efectos del estado amedrentado
                break;
            default:
                // Manejo por defecto si el estado no coincide con ninguno de los casos anteriores
                break;
        }
    }
    public void quitaEstado(Movimiento nombre) {
        estado = null;
    }


}