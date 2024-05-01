package crud;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MovimientoCRUD {

    // Lista para almacenar los movimientos excluidos
    public static List<Integer> movimientosExcluidos = new ArrayList<>();
    
  
    static {
        movimientosExcluidos.add(25); // Agregar movimiento 25 (Placaje) a la lista de excluidos
    }

    /**
     * Obtiene un movimiento aleatorio excluyendo los movimientos previamente excluidos.
     * 
     * @param excluidos Lista de movimientos excluidos adicionales
     * @return ID del movimiento obtenido aleatoriamente.
     */
    public static int obtenerMovimientoAleatorioExcluyendo(List<Integer> excluidos) {
        Random random = new Random();
        int movimientoAleatorio;
        do {
            movimientoAleatorio = random.nextInt(98) + 1; // Suponiendo que hay 98 movimientos en total
        } while (excluidos.contains(movimientoAleatorio));
        return movimientoAleatorio;
    }
}