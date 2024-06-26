package modelo;

import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class CrianzaPokemon {
    private CajaPokemon cajaPokemon;


    public CrianzaPokemon(CajaPokemon cajaPokemon) {
        this.cajaPokemon = cajaPokemon;
    }

    public Pokemon criarPokemon(Pokemon p, Pokemon m) {
        Pokemon hijo = new Pokemon();
        Pokemon padre = cajaPokemon.obtenerPokemon(p.getNumPokedex());
        Pokemon madre = cajaPokemon.obtenerPokemon(m.getNumPokedex());

        hijo.setNumPokedex(m.getNumPokedex());
        hijo.setNombre(m.getNombre());
        hijo.setImgFrontal(m.getImgFrontal());
        hijo.setImgTrasera(m.getImgTrasera());
        hijo.setTipoPrimario(Pokemon.getTipoPrimario());
        hijo.setTipoSecundario(Pokemon.getTipoSecundario());

        hijo.setMote(crearMote(p, m));
        hijo.setMovimientos(crearMovimiento(p, m));
        hijo.setAtaque(crearAtaque(p, m));
        hijo.setAtaqueEspecial(crearAtaqueEspecial(p, m));
        hijo.setDefensa(crearDefensa(p, m));
        hijo.setDefensaEspecial(crearDefensaEspecial(p, m));
        hijo.setVelocidad(crearVelocidad(p, m));
        hijo.setVitalidad(crearVitalidad(p, m));
        hijo.setFertilidad(5);
        hijo.setSexo(crearSexo());
        hijo.setNivel(1);

        // restamos 1 a la fertilidad de cada padre
        p.setFertilidad(p.getFertilidad() - 1);
        m.setFertilidad(m.getFertilidad() - 1);

        return hijo;
    }

    private String crearMote(Pokemon p, Pokemon a) {

        Scanner sc = new Scanner(System.in);
        System.out.println("¿Qué mote quieres para el Pokémon?");
        return sc.nextLine(); // Leer la entrada del usuario y retornarla como el mote

    }

    // Creamos lista de moviminetos con los dos primeros del padre y lso dos primeros de la madre
    private LinkedList<Movimiento> crearMovimiento(Pokemon p, Pokemon a) {
		LinkedList<Movimiento> hijo = new LinkedList<Movimiento>();
		try {
			hijo.add(Pokemon.getMovimientos().get(0));
		} catch (IndexOutOfBoundsException e) {
		}
		try {
			hijo.add(Pokemon.getMovimientos().get(1));
		} catch (IndexOutOfBoundsException e) {

		}
		try {
			hijo.add(Pokemon.getMovimientos().get(2));
		} catch (IndexOutOfBoundsException e) {

		}
		try {
			hijo.add(Pokemon.getMovimientos().get(3));
		} catch (IndexOutOfBoundsException e) {

		}

		return hijo;
	}



    private int crearAtaque(Pokemon p, Pokemon a) {
        int ataque = Math.max(p.getAtaque(), a.getAtaque());
        return ataque;
    }


    private int crearAtaqueEspecial(Pokemon p, Pokemon a) {
        return Math.max(p.getAtaqueEspecial(), a.getAtaqueEspecial());
    }

    private int crearDefensa(Pokemon p, Pokemon a) {
        return Math.max(p.getDefensa(), a.getDefensa());
    }

    private int crearDefensaEspecial(Pokemon p, Pokemon a) {
        return Math.max(p.getDefensaEspecial(), a.getDefensaEspecial());
    }

    private int crearVelocidad(Pokemon p, Pokemon a) {
        return Math.max(p.getVelocidad(), a.getVelocidad());
    }



    private int crearVitalidad(Pokemon p, Pokemon a) {
        return Math.max(p.getVitalidad(), a.getVitalidad());

    }


    /**
     * Crea aleatoriamente sexo M o H
     *
     * @return char
     */

    private boolean crearSexo() {
        Random random = new Random();
        return random.nextBoolean(); // Devuelve true para macho y false para hembra de manera aleatoria
    }
}