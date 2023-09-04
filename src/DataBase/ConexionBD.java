
package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Rick
 */
public class ConexionBD {

    private static String DRIVER = "com.mysql.jdbc.Driver";
    private static String USUARIO = "YOU_USER";
    private static String PASSWORD = "YOU_PASSWORD@";
    private static String URL = "jdbc:mysql://localhost:3306/YOU_DATABASE";
    private Connection connection;
    
    static {
        try {
            Class.forName(DRIVER);

        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "ERROR EN EL DRIVER:  " + e);
        }
    }

    public Connection getConnection() {
        try {
            connection = DriverManager.getConnection(URL, USUARIO, PASSWORD);
            System.out.println("Conexion Exitosa");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR EN LA CONEXION:  " + e);
        }
        return connection;

    }
    
    public void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
                System.out.println("Conexion cerrada.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

 public static void main(String[] args){
        ConexionBD db = new ConexionBD();
        db.getConnection();
        
        db.closeConnection();
    }
 
}
