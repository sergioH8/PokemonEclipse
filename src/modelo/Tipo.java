package modelo;

public enum Tipo {

    AGUA,       // Ordinal nos indica el orden en este caso es:   0
    BICHO,      // Ordinal nos indica el orden en este caso es:   1
    DRAGON,     // Ordinal nos indica el orden en este caso es:   2
    ELECTRICO,  // Ordinal nos indica el orden en este caso es:   3
    FANTASMA,   // Ordinal nos indica el orden en este caso es:   4
    FUEGO,      // Ordinal nos indica el orden en este caso es:   5
    HIELO,      // Ordinal nos indica el orden en este caso es:   6
    LUCHA,      // Ordinal nos indica el orden en este caso es:   7
    NORMAL,     // Ordinal nos indica el orden en este caso es:   8
    PLANTA,     // Ordinal nos indica el orden en este caso es:   9
    PSIQUICO,   // Ordinal nos indica el orden en este caso es:  10
    ROCA,       // Ordinal nos indica el orden en este caso es:  11
    TIERRA,     // Ordinal nos indica el orden en este caso es:  12
    VENENO,     // Ordinal nos indica el orden en este caso es:  13
    VOLADOR;    // Ordinal nos indica el orden en este caso es:  14


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

    }

