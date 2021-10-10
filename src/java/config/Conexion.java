
package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLDataException;
import java.sql.SQLException;

/**
 *
 * @author Nelson Diaz
 */
public class Conexion {
    public Connection getConexion() throws ClassNotFoundException{
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/mintic", "root", "");
            return conexion;
        } catch (SQLException e) {
            System.out.println(e.toString());
            System.out.println("conexión fallida");
            return null;
        }
    }    
}