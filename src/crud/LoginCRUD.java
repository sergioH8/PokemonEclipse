package crud;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginCRUD {

    //Metodo para comprobar si un nombre de entrenador está en uso

    public static boolean inicioSesion(String nombreEntrenador, String pass){
        String sqlVerify = "SELECT COUNT(*)" +
                            " FROM ENTRENADOR" +
                            " WHERE NOMBRE = ?" +
                            " AND PASS = ?";
        ResultSet rst = null;
        try {
            PreparedStatement pst = ConexionBD.getConexion().prepareStatement(sqlVerify);
            pst.setString(1, nombreEntrenador);
            pst.setString(2, pass);
            rst = pst.executeQuery();
            return rst.next();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public static boolean registroSesion(String nombreEntrenador, String pass){
        String sqlVerify = "INSERT INTO ENTRENADOR(nombre, pass)" +
                " VALUES(?,?)";
        ResultSet rst = null;
        try {
            PreparedStatement pst = ConexionBD.getConexion().prepareStatement(sqlVerify);
            pst.setString(1, nombreEntrenador);
            pst.setString(2, pass);
            rst = pst.executeQuery();
            return rst.next();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
