package modelo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CajaPokemon {
    private LinkedList<Pokemon> equipoPokemon;
    private LinkedList<Pokemon> cajaPokemon;

    public CajaPokemon() {
        this.equipoPokemon = new LinkedList<>();
    }

    public void agregarPokemon(Pokemon pokemon) {
        this.equipoPokemon.add(pokemon);
    }

    public void eliminarPokemon(Pokemon pokemon) {
        this.equipoPokemon.remove(pokemon);
    }


    public Pokemon obtenerPokemon(int idPokedex) {
        for (Pokemon p : cajaPokemon) {
            if (p.getNumPokedex() == idPokedex) {
                return p;
            }
        }
        return null;
    }
    public void moverPokemonCaja1ACaja0(int indice) {
        // Obtener el Pokémon del equipo (caja 1)
        Pokemon pokemon =  equipoPokemon.get(indice);

        // Remover el Pokémon del equipo (caja 1)
        equipoPokemon.remove(indice);

        // Agregar el Pokémon a la caja (caja 0)
        equipoPokemon.add(pokemon);
    }

    public void moverPokemonCaja0ACaja1(int indice) {
        // Obtener el Pokémon de la caja (caja 0)
        Pokemon pokemon = cajaPokemon.get(indice);

        // Remover el Pokémon de la caja (caja 0)
        cajaPokemon.remove(indice);

        // Agregar el Pokémon al equipo (caja 1)
        equipoPokemon.add(pokemon);
    }


}
