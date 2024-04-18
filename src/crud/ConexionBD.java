package crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

    public static Connection conexion;

    public Connection getConexion() throws SQLException {

        String dbName = "bdpokemonlc";
        String url = "jdbc:mysql://localhost:3306/bdpokemonlc";
        String login = "root";
        String password = "";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(url, login, password);

            System.out.println("Conexión establecida");

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return conexion;

    }
}