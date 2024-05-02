package crud;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MovimientoCRUD {

    // Lista para almacenar los movimientos excluidos
    public static List<Integer> movimientosExcluidos = new ArrayList<>();
    
  
  
  
   
    public static int obtenerMovimientoAleatorioExcluyendo(List<Integer> excluidos) {
    	 movimientosExcluidos.add(25);// Agregar movimiento 25 (Placaje) a la lista de excluidos
        Random random = new Random();
        int movimientoAleatorio;
        do {
            movimientoAleatorio = random.nextInt(98) + 1;  // Tengo 98 ataques creados
        } while (excluidos.contains(movimientoAleatorio)); // Generamos un numero que se repite si esta en la lista
        return movimientoAleatorio;						   // para buscar un numero que no este
    }
}