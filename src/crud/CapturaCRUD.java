package crud;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import modelo.Entrenador;
import modelo.Pokemon;

public class CapturaCRUD {
    private static List<Integer> movimientosExcluidos;

	public static void insertCapturaCaja(Pokemon p, Entrenador entrenador) throws ClassNotFoundException {
	
		
        String insertCaja = "INSERT INTO pokemon ("
        		+ " id_pokemon,"
        		+ " num_pokedex,"
        		+ " id_caja,"
        		+ " id_entrenador,"
        		+ " mote,"
        		+ " sexo,"
        		+ " nivel,"
                + " vitalidad,"
                + " ataque,"
                + " ataque_especial,"
                + " defensa,"
                + " defensa_especial,"
                + " velocidad,"
                + " movimiento1) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        try (Connection connection = ConexionBD.getConexion();
             PreparedStatement ps = connection.prepareStatement(insertCaja)) {
            
        	Random random = new Random();
        	ps.setInt(1, p.getIdPokemon());
        	ps.setInt(2, p.getNumPokedex());
        	ps.setInt(3, 0);  // 0 hace referencia a la lista 0 del entrenador lo cual es la caja 
        	ps.setInt(4, entrenador.getIdEntrenador());
        	ps.setString(5, p.getMote());
        	ps.setBoolean(6, p.generarSexo()); 
        	ps.setInt(7, 1); //  Inicializamos el nivel del Pokemon capturado a 1

        	// Asignar y establecer cada atributo restante
        	p.setVitalidad(random.nextInt(11) + 15);
        	ps.setInt(8, p.getVitalidad());

        	p.setAtaque(random.nextInt(10) + 1);
        	ps.setInt(9, p.getAtaque());

        	p.setAtaqueEspecial(random.nextInt(10) + 1);
        	ps.setInt(10, p.getAtaqueEspecial());

        	p.setDefensa(random.nextInt(10) + 1);
        	ps.setInt(11, p.getDefensa());

        	p.setDefensaEspecial(random.nextInt(10) + 1);
        	ps.setInt(12, p.getDefensaEspecial());

        	p.setVelocidad(random.nextInt(10) + 1);
        	ps.setInt(13, p.getVelocidad());

        	ps.setInt(14, 25); 
            
            
            
         
            
            ps.executeUpdate();
            System.out.println("¡Pokemon capturado e insertado en la caja del entrenador correctamente!");
            
           
        } catch (SQLException e) {
            e.printStackTrace();
            // También puedes manejar las excepciones de manera más específica aquí
        }
    }
}
