
package Class;


import Visual.Menu;
import java.awt.Container;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JFrame;

public class Log {

    public static String L = "";
    
    public static boolean loginBD(JTextField usuarioIngresado, JPasswordField contraseñaIngresada) {

        String url = "jdbc:mysql://localhost:3306/Estela";
        String usuario = "root";
        String contraseña = "989974718@";

        try (Connection conexion = DriverManager.getConnection(url, usuario, contraseña)) {
            // Crear la consulta para obtener el registro del usuario
            String consulta = "SELECT Contraseña FROM Usuario WHERE Usuario = ?";
            PreparedStatement declaracion = conexion.prepareStatement(consulta);
            declaracion.setString(1, usuarioIngresado.getText());

            // Ejecutar la consulta y obtener el resultado
            ResultSet resultado = declaracion.executeQuery();

            if (resultado.next()) {
                // Obtener la contraseña cifrada del registro
                String contrasenaCifrada = resultado.getString("Contraseña");

                // Comparar la contraseña ingresada con la contraseña cifrada
                if (SHA256(String.valueOf(contraseñaIngresada.getPassword())).equals(contrasenaCifrada)) {

                    // Obtener la referencia al JFrame que contiene el JPanel
                    Container container = usuarioIngresado.getParent();
                    while (!(container instanceof JFrame)) {
                        container = container.getParent();
                    }
                    JFrame loginFrame = (JFrame) container;

                    // Hacer que el JFrame loginFrame sea invisible y se dispose
                    loginFrame.setVisible(false);
                    loginFrame.dispose();
                    new splashscreen.SplashScreen(null, true).setVisible(true);
                    new Menu().setVisible(true);
                    return true;
                } else {                 
                    L = "Contraseña incorrecta.";
                }
            } else {                
                L = "Usuario no encontrado.";
            }
            return false;
        } catch (SQLException ex) {
            System.err.println("Error al conectar con la base de datos: " + ex.getMessage());
        }
        return false;

    }

    // Función para cifrar la contraseña ingresada usando SHA256
    public static String SHA256(String contraseña) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(contraseña.getBytes(StandardCharsets.UTF_8));
            StringBuilder hexString = new StringBuilder();

            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }

            return hexString.toString();
        } catch (NoSuchAlgorithmException ex) {
            System.err.println("Error al cifrar la contraseña: " + ex.getMessage());
            return null;
        }
    }
}
