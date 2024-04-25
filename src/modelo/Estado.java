package modelo;

public enum Estado {
	
	
	PARALIZADO("Paralizado"),                		 // Ordinal nos indica el orden en este caso es:   0
    QUEMADO("Quemado"),                    			 // Ordinal nos indica el orden en este caso es:   1
    ENVENENADO("Envenenado"),                  		 // Ordinal nos indica el orden en este caso es:   2
    GRAVEMENTE_ENVENENADO("Gravemente_envenenado"),  // Ordinal nos indica el orden en este caso es:   3
    DORMIDO("Dormido"),                     		 // Ordinal nos indica el orden en este caso es:   4
    CONGELADO("Congelado"),                          // Ordinal nos indica el orden en este caso es:   5
    HELADO("Helado"),                            	 // Ordinal nos indica el orden en este caso es:   6
    SOMNOLIENTO("Somnoliento"),                      // Ordinal nos indica el orden en este caso es:   7
    POKERUS("Pokerus"),                   			 // Ordinal nos indica el orden en este caso es:   8
    DEBILITADO("Debilitado"),                   	 // Ordinal nos indica el orden en este caso es:   9
    CONFUSO("Confuso"),                   			 // Ordinal nos indica el orden en este caso es:  10
    ENAMORADO("Enamorado"),                			 // Ordinal nos indica el orden en este caso es:  11
    ATRAPADO("Atrapado"),                            // Ordinal nos indica el orden en este caso es:  12
    MALDITO("Maldito"),                      		 // Ordinal nos indica el orden en este caso es:  13
    DRENADORAS("Drenadoras"),                        // Ordinal nos indica el orden en este caso es:  14
    CANTO_MORTAL("Canto_mortal"),
    CENTRO_DE_ATENCION("Crentro_de_atencion"),
    AMEDRENTADO("Amedrentado");

    private final String nombre;

    Estado(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

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