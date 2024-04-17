package modelo;

public class ObjetoFactory {

    public static Objeto crearPesa() {
        Objeto pesa = new Objeto();
        pesa.setNombre("pesa");
        pesa.setAumento(20);
        pesa.setDisminucion(20);
        pesa.setPrecio(0);
        pesa.setDescripcion("Aumenta el ataque y la defensa un 20%, pero disminuye su velocidad un 20%.");
        return pesa;
    }

    public static Objeto crearPluma() {
        Objeto pluma = new Objeto();
        pluma.setNombre("pluma");
        pluma.setAumento(30);
        pluma.setDisminucion(20);
        pluma.setPrecio(0);
        pluma.setDescripcion("Aumenta la velocidad un 30%, pero disminuye la defensa y la defensa especial en un 20%.");
        return pluma;
    }

    public static Objeto crearChaleco() {
        Objeto chaleco = new Objeto();
        chaleco.setNombre("chaleco");
        chaleco.setAumento(20);
        chaleco.setDisminucion(15);
        chaleco.setPrecio(0);
        chaleco.setDescripcion("Aumenta la defensa y la defensa especial un 20%, pero disminuye la velocidad y el ataque un 15%.");
        return chaleco;
    }


    public static Objeto crearEter() {
        Objeto eter = new Objeto();
        eter.setNombre("Eter");

        return eter;
    }

    public static Objeto crearAnilloUnico() {
        Objeto anilloUnico = new Objeto();
        anilloUnico.setNombre("Anillo único");

        return anilloUnico;
    }

    public static Objeto crearPokeball() {
        Objeto pokeball = new Objeto();
        pokeball.setNombre("Pokeball");
        pokeball.setPrecio(50);

        return pokeball;
    }
}
