
package Class;

import DataBase.ConexionBD;
import java.awt.Image;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Rick
 */
public class AddUser {
    public void Add(String Usuario, String Contraseña, String email, String Confirmar){
        ConexionBD db = new ConexionBD();
        String sql = "insert into Usuario(Usuario, Contraseña, Correo) values ('" + Usuario +"', sha2('" +  Contraseña +"',256), '" + email +"')";
        Statement st;
        Connection conexion = db.getConnection();
        try
        {
            if(Confirmar.equals(Contraseña)){
                st = conexion.createStatement();
                int rs = st.executeUpdate(sql);
                gif_check();
            } else {
              JOptionPane.showMessageDialog(null, "Error");
            }           
        }catch(SQLException e)
        {
            System.out.println(e);
        }
    }
    
    public void gif_check() {
        ImageIcon check_gif = new ImageIcon("src/Imag/check.gif");
        ImageIcon resizedIcon = new ImageIcon(check_gif.getImage().getScaledInstance(85, 85, Image.SCALE_DEFAULT));
        JOptionPane.showMessageDialog(null, "Guardado correctamente", "Information", JOptionPane.PLAIN_MESSAGE, resizedIcon);
        
    }
    
}
