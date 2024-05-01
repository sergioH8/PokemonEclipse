package crud;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import modelo.Entrenador;
import modelo.Pokemon;

public class CapturaCRUD {
    private static List<Integer> movimientosExcluidos;

	public static void insertCapturaCaja(Pokemon p, Entrenador entrenador) throws ClassNotFoundException {
        String insertCaja = "INSERT INTO pokemon (num_pokedex, id_caja, id_entrenador, mote, sexo, nivel, "
                + "vitalidad, ataque, ataque_especial, defensa, defensa_especial, velocidad, fertilidad,  "
                + "movimiento1, movimiento2, movimiento3, movimiento4) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        try (Connection connection = ConexionBD.getConexion();
             PreparedStatement ps = connection.prepareStatement(insertCaja)) {
            
            ps.setInt(1, p.getNumPokedex());
            ps.setInt(2, 0);  // 0 hace referencia a la lista 0 del entrenador lo cual es la caja 
            ps.setInt(3, entrenador.getIdEntrenador());
            ps.setString(4, p.getMote());
            ps.setBoolean(5, p.getSexo());
            ps.setInt(6, 1); // Establece el nivel del Pokémon capturado como 1
            ps.setInt(7, p.getVitalidad());
            ps.setInt(8, p.getAtaque());
            ps.setInt(9, p.getAtaqueEspecial());
            ps.setInt(10, p.getDefensa());
            ps.setInt(11, p.getDefensaEspecial());
            ps.setInt(12, p.getVelocidad());
            ps.setInt(13, p.getFertilidad());
            ps.setInt(14, 25);
         // Obtener movimientos aleatorios excluyendo el movimiento de Placaje (ID 25)
            int movimiento2 = MovimientoCRUD.obtenerMovimientoAleatorioExcluyendo(movimientosExcluidos);
          
            int movimiento3 = MovimientoCRUD.obtenerMovimientoAleatorioExcluyendo(movimientosExcluidos);
          
            int movimiento4 = MovimientoCRUD.obtenerMovimientoAleatorioExcluyendo(movimientosExcluidos);
            
            ps.setInt(15, movimiento2);
            ps.setInt(16, movimiento3);
            ps.setInt(17, movimiento4);
            
            ps.executeUpdate();
            System.out.println("¡Pokemon capturado e insertado en la caja del entrenador correctamente!");
            
           
        } catch (SQLException e) {
            e.printStackTrace();
            // También puedes manejar las excepciones de manera más específica aquí
        }
    }
}
