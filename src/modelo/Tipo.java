package modelo;

public enum Tipo {

    AGUA("Agua"),       	 // Ordinal nos indica el orden en este caso es:   0
    BICHO("Bicho"),     	 // Ordinal nos indica el orden en este caso es:   1
    DRAGON("Dragón"),    	 // Ordinal nos indica el orden en este caso es:   2
    ELECTRICO("Eléctrico"),  // Ordinal nos indica el orden en este caso es:   3
    FANTASMA("Fantasma"),    // Ordinal nos indica el orden en este caso es:   4
    FUEGO("Fuego"),      	 // Ordinal nos indica el orden en este caso es:   5
    HIELO("Hielo"),     	 // Ordinal nos indica el orden en este caso es:   6
    LUCHA("Lucha"),     	 // Ordinal nos indica el orden en este caso es:   7
    NORMAL("Normal"),    	 // Ordinal nos indica el orden en este caso es:   8
    PLANTA("Planta"),    	 // Ordinal nos indica el orden en este caso es:   9
    PSIQUICO("Psíquico"),    // Ordinal nos indica el orden en este caso es:  10
    ROCA("Roca"),      		 // Ordinal nos indica el orden en este caso es:  11
    TIERRA("Tierra"),    	 // Ordinal nos indica el orden en este caso es:  12
    VENENO("Veneno"),    	 // Ordinal nos indica el orden en este caso es:  13
    VOLADOR("Volador");   	 // Ordinal nos indica el orden en este caso es:  14
	
	
private final String nombre;
	




        public String getNombre() {
	return nombre;
}


public static double[][] getMultiplicadores() {
	return multiplicadores;
}


		private Tipo(String nombre) {
		this.nombre = nombre;
	}


		static final double[][] multiplicadores = {
                      //AGUA    BICHO   DRAGON  ELECTRICO FANTASMA FUEGO   HIELO   LUCHA   NORMAL  PLANTA  PSIQUICO  ROCA    TIERRA  VENENO  VOLADOR
        /* AGUA*/      {0.5,    1,      0.5,    1,        1,       2,      1,      1,      1,      0.5,    1,        2,      2,      1,      1  },    // AGUA
        /* BICHO*/     {1,      1,      1,      1,        0.5,     0.5,    1,      0.5,    1,      2,      1,        1,      1,      2,      0.5},    // BICHO
        /* DRAGON*/    {1,      1,      2,      1,        1,       1,      1,      1,      1,      1,      1,        1,      1,      1,      1  },    // DRAGON
        /* ELECTRICO*/ {2,      1,      0.5,    0.5,      1,       1,      1,      1,      1,      0.5,    1,        1,      0,      1,      2  },    // ELECTRICO
        /* FANTASMA */ {1,      1,      1,      1,        2,       1,      1,      0,      0,      1,      1,        1,      1,      0.5,    1  },    // FANTASMA
        /* FUEGO */    {0.5,    2,      0.5,    1,        1,       0.5,    2,      1,      1,      2,      1,        0.5,    1,      1,      1  },    // FUEGO
        /* HIELO */    {0.5,    1,      2,      1,        1,       1,      0.5,    1,      1,      2,      1,        1,      2,      1,      2  },    // HIELO
        /* LUCHA*/     {1,      0.5,    1,      1,        0,       1,      2,      1,      2,      1,      2,        2,      1,      0.5,    0.5},    // LUCHA
        /* NORMAL*/    {1,      1,      1,      1,        0,       1,      1,      1,      1,      1,      1,        1,      1,      1,      1  },    // NORMAL
        /* PLANTA*/    {2,      0.5,    0.5,    1,        1,       0.5,    1,      1,      1,      0.5,    1,        2,      2,      0.5,    0.5},    // PLANTA
        /* PSIQUICO */ {1,      1,      1,      1,        1,       1,      1,      2,      1,      1,      0.5,      1,      1,      2,      1  },    // PSIQUICO
        /* ROCA*/      {1,      2,      1,      1,        1,       2,      2,      0.5,    1,      2,      1,        1,      0.5,    1,      2  },    // ROCA
        /* TIERRA*/    {0.5,    0.5,    1,      2,        1,       2,      1,      1,      1,      0.5,    1,        2,      1,      2,      0  },    // TIERRA
        /* VENENO*/    {1,      2,      1,      0.5,      0.5,     1,      1,      1,      1,      2,      0.5,      0.5,    0.5,    0.5,    1  },    // VENENO
        /* VOLADOR */  {1,      2,      1,      1,        1,       1,      0.5,    2,      1,      2,      1,        0.5,    2,      1,      1  }     // VOLADOR
        };

        
     // Método estático para convertir una cadena a un valor del enumerado
    	public static Tipo convertirTipoDesdeString(String tipoString){ 
    		for (Tipo tipo : Tipo.values()) { 
    			if(tipo.getNombre().toUpperCase().equalsIgnoreCase(tipoString)) { 
    				return tipo; 
    			} 
    		} 
    		return null; 
    	}
        
    }

