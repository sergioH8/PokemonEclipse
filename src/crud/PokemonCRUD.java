package crud;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;

import modelo.Pokemon;

public class PokemonCRUD {

	public static void obtenerPokemon() {
		
		PreparedStatement ps = conexion.prepareStatement(sql);
		ps.setInt(1, entrenador.getIdEntrenador());
		ps.setInt(2, caja);
		
		ResultSet rs = ps.PokemonQuery();
		LinkedList<Pokemon> listadoPokemon = new LinkedList<Pokemon>();
		Pokemon poke;
		while(rs.next()) {
			poke = new Pokemon();
			poke.setIdPokemon(rs.getInt(1));
			poke.setNombre(rs.getString(3));
			
			listadoPokemon.add(poke);
//			entrenador.setIdEntrenador(rs.getInt(1));
//			entrenador.setPokedollares(rs.getInt(2));
			
		}
		
		if(caja==1) {
			entrenador.setEquipoPrincioal(listadoPokemon);
		}else {
			entrenador.setPokemonCaja(istadoPokemon);
		}
	}
	
	
	
}
