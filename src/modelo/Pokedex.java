package modelo;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase Pokedex
 */
public class Pokedex {


    private List<Pokemon> listaPokemon;

    private int numPokemon;

    private int numPokemonCapturados;

    // Constructor
    public Pokedex() {
        this.listaPokemon = new ArrayList<>();
        this.numPokemon = 0;
        this.numPokemonCapturados = 0;
    }


    public List<Pokemon> getListaPokemon() {
        return listaPokemon;
    }

    public void setListaPokemon(List<Pokemon> listaPokemon) {
        this.listaPokemon = listaPokemon;
    }

    public int getNumPokemon() {
        return numPokemon;
    }

    public void setNumPokemon(int numPokemon) {
        this.numPokemon = numPokemon;
    }

    public int getNumPokemonCapturados() {
        return numPokemonCapturados;
    }

    public void setNumPokemonCapturados(int numPokemonCapturados) {
        this.numPokemonCapturados = numPokemonCapturados;
    }

    // Método para agregar un Pokémon a la Pokédex
    public void agregarPokemon(Pokemon pokemon) {
        listaPokemon.add(pokemon);
        numPokemonCapturados++;
    }

    // Método para obtener la lista de Pokémon capturados
    public List<Pokemon> obtenerPokemonCapturados() {
        return listaPokemon;
    }

    // Método para mostrar información de un Pokémon
    public void mostrarPokemon(Pokemon pokemon) {
        System.out.println("Nombre: " + pokemon.getNombre());
        System.out.println("Tipo1: " + pokemon.getTipoPrimario());
        System.out.println("Tipo2: " + pokemon.getTipoSecundario());

    }
}
