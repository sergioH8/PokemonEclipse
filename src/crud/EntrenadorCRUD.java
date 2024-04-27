package crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import modelo.Entrenador;

public class EntrenadorCRUD {

	public static void crearEntNuevo(Connection con, Entrenador entrenador) throws SQLException {
		
		entrenador.setIdEntrenador(generarIdEntrenador(con));
		entrenador.setPokedolares(generarPokedollar());
		
		String insert = "INSERT INTO ENTRENADOR (id_entrenador, nombre, pokedollar, pass)"
        		+ " VALUES (?, ?, ?, ?);";
		
		PreparedStatement pst = con.prepareStatement(insert);

		pst.setInt(1, entrenador.getIdEntrenador());
		pst.setString(2, entrenador.getNombre());
		pst.setInt(3, entrenador.getPokedolares());
		pst.setString(4, entrenador.getPass());;
		pst.executeUpdate();
		
	}
	
	public static void obtenerIdPokedolar(Connection conection, Entrenador entrenador) throws SQLException {
		
		String select = "SELECT ID_ENTRENADOR, POKEDOLLAR\r\n"
				+ "FROM ENTRENADOR\r\n"
				+ "WHERE NOMBRE = ? AND PASS = ?";
		
		PreparedStatement pst = conection.prepareStatement(select);
		pst.setString(1, entrenador.getNombre());
		pst.setString(2, entrenador.getPass());
		
		ResultSet rs = pst.executeQuery();
		
		while(rs.next()) {
			entrenador.setIdEntrenador(rs.getInt(1));
			entrenador.setPokedolares(rs.getInt(2));
		}
	}
	
	public static int generarIdEntrenador(Connection conection) throws SQLException {
		int idEntrenador = 0;
		
		String selectId = "SELECT MAX(ID_ENTRENADOR)+1\r\n"
				+ "FROM ENTRENADOR";
		
		Statement st = conection.createStatement();
		ResultSet rs = st.executeQuery(selectId);
		
		while(rs.next()) {
			idEntrenador = rs.getInt(1);
		}
		
		return idEntrenador;
	}
	
	public static int generarPokedollar() {
		Random rd = new Random();
		return rd.nextInt(501) + 1000;
	}
}
