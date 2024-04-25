package crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import modelo.Entrenador;
import modelo.Pokemon;
import modelo.Tipo;

public class PokemonCRUD {

	public static void obtenerPokemon(Connection conexion, Entrenador entrenador, int caja) throws SQLException {
		String sql = "SELECT 	PK.ID_POKEMON,\r\n"
				+ "		PX.NUM_POKEDEX,\r\n"
				+ "		PX.NOM_POKEMON,\r\n"
				+ "		PX.TIPO1,\r\n"
				+ "		PX.TIPO2,\r\n"
				+ "		PX.IMAGEN,\r\n"
				+ "		PX.SONIDO,\r\n"
				+ "		PX.NIVEL_EVOLUCION,\r\n"
				+ "		PX.NUM_POKEDEX_EVO,\r\n"
				+ "		PK.ATAQUE,\r\n"
				+ "		PK.ATA_ESPECIAL,\r\n"
				+ "		PK.DEFENSA,\r\n"
				+ "		PK.MOTE,\r\n"
				+ "		PK.NIVEL\r\n"
				+ "FROM POKEMON PK\r\n"
				+ "INNER JOIN POKEDEX PX\r\n"
				+ "	ON PX.NUM_POKEDEX = PK.NUM_POKEDEX\r\n"
				+ "WHERE PK.ID_ENTRENADOR =?\r\n"
				+ "AND PK.CAJA =?";	
		
		PreparedStatement ps = conexion.prepareStatement(sql);
		ps.setInt(1, entrenador.getIdEntrenador());
		ps.setInt(2, caja);
		
		ResultSet rs = ps.executeQuery();
		LinkedList<Pokemon> listadoPokemon = new LinkedList<Pokemon>();
		Pokemon poke;
		while (rs.next()) {
			poke = new Pokemon();
			poke.setIdPokemon(rs.getInt(1));
			poke.setNumPokedex(rs.getInt(2));
			poke.setNombre(rs.getString(3));
			poke.setTipoPrimario(Tipo.convertirTipoDesdeString(rs.getString(4)));
			poke.setTipoSecundario(Tipo.convertirTipoDesdeString(rs.getString(5)));
			poke.setImgFrontal(rs.getString(6));
			poke.setNivelEvolucion(rs.getInt(8));
			poke.setAtaque(rs.getInt(10));
			poke.setAtaqueEspecial(rs.getInt(11));
			poke.setDefensa(rs.getInt(12));
			poke.setMote(rs.getString(13));
			poke.setNivel(rs.getInt(14));
			//poke.setMovimientos(obtenerMovimientos(conexion, poke.getIdPokemon()));
			//poke.setObjeto(obtenerObjeto(conexion, poke.getIdPokemon()));
			listadoPokemon.add(poke);
		}
		
		if(caja ==1) {
			entrenador.setEquipoPokemon(listadoPokemon);
		}else {
			entrenador.setCajaPokemon(listadoPokemon);
		}
		
	}

	public static LinkedList<Pokemon> obtenerPokedex(Connection conexion) throws SQLException {
        LinkedList<Pokemon> pokedex = new LinkedList<>();

        String sql = "SELECT NUM_POKEDEX, NOM_POKEMON, TIPO1, TIPO2, IMAGEN FROM POKEDEX";
        PreparedStatement ps = conexion.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Pokemon pokemon = new Pokemon();
            pokemon.setNumPokedex(rs.getInt("NUM_POKEDEX"));
            pokemon.setNombre(rs.getString("NOMBRE"));
            pokemon.setTipoPrimario(Tipo.convertirTipoDesdeString(rs.getString("TIPO1")));
            pokemon.setTipoSecundario(Tipo.convertirTipoDesdeString(rs.getString("TIPO2")));          
            pokemon.setImgFrontal(rs.getString("img_front"));
            pokedex.add(pokemon);
        }

        return pokedex;
    }
}