package modelo;

public enum Estado {
    PARALIZADO,                 // Ordinal nos indica el orden en este caso es:   0
    QUEMADO,                    // Ordinal nos indica el orden en este caso es:   1
    ENVENENADO,                  // Ordinal nos indica el orden en este caso es:   2
    GRAVEMENTE_ENVENENADO,       // Ordinal nos indica el orden en este caso es:   3
    DORMIDO,                     // Ordinal nos indica el orden en este caso es:   4
    CONGELADO,                         // Ordinal nos indica el orden en este caso es:   5
    HELADO,                            // Ordinal nos indica el orden en este caso es:   6
    SOMNOLIENTO,                       // Ordinal nos indica el orden en este caso es:   7
    POKERUS,                   // Ordinal nos indica el orden en este caso es:   8
    DEBILITADO,                   // Ordinal nos indica el orden en este caso es:   9
    CONFUSO,                   // Ordinal nos indica el orden en este caso es:  10
    ENAMORADO,                // Ordinal nos indica el orden en este caso es:  11
    ATRAPADO,                  // Ordinal nos indica el orden en este caso es:  12
    MALDITO,                      // Ordinal nos indica el orden en este caso es:  13
    DRENADORAS,                       // Ordinal nos indica el orden en este caso es:  14
    CANTO_MORTAL,
    CENTRO_DE_ATENCION,
    AMEDRENTADO;

    public boolean esPersistente() {
        switch (this) {
            case PARALIZADO:
            case QUEMADO:
            case ENVENENADO:
            case GRAVEMENTE_ENVENENADO:
            case DORMIDO:
            case CONGELADO:
            case HELADO:
            case SOMNOLIENTO:
            case POKERUS:
            case DEBILITADO:
                return true;
            default:
                return false;
        }
    }
}