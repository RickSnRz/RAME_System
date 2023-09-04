package Class;

import DataBase.ConexionBD;
import java.awt.Image;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Mod {

    public boolean mod_Inq(JTextField Id_in, JTextField Nombre, JTextField Apelldio, JTextField DNI, JTextField Telefono) {
        try {
            ConexionBD con = new ConexionBD();
            Connection ConexionBD = con.getConnection();
            CallableStatement proc = ConexionBD.prepareCall("CALL SP_MODIFICARINQUILINO(?,?,?,?,?)");
            proc.setString(1, Id_in.getText());
            proc.setString(2, Nombre.getText());
            proc.setString(3, Apelldio.getText());
            proc.setString(4, DNI.getText());
            proc.setString(5, Telefono.getText());
            proc.execute();
            gif_check();

            return true;

        } catch (SQLException e) {

            System.out.println(e);

        }
        return false;

    }

    public boolean mod_Serv(String ID, JTextField Nombre, JTextField Precio) {
        try {
            ConexionBD con = new ConexionBD();
            Connection ConexionBD = con.getConnection();
            CallableStatement proc = ConexionBD.prepareCall("CALL SP_MODIFICARSERV(?,?,?)");
            proc.setString(1, ID);
            proc.setString(2, Nombre.getText());
            proc.setString(3, Precio.getText());
            proc.execute();

            return true;

        } catch (SQLException e) {

            System.out.println(e);

        }
        return false;

    }

    public boolean mod_Cuart(String ID, JTextField NCuarto, JTextField NPiso, JTextField PrecioCuart) {
        try {
            ConexionBD con = new ConexionBD();
            Connection ConexionBD = con.getConnection();
            CallableStatement proc = ConexionBD.prepareCall("CALL SP_MODIFICARCUARTO(?,?,?,?)");
            proc.setString(1, ID);
            proc.setString(2, NCuarto.getText());
            proc.setString(3, NPiso.getText());
            proc.setString(4, PrecioCuart.getText());
            proc.execute();

            return true;

        } catch (SQLException e) {

            System.out.println(e);

        }
        return false;

    }

    public void mod_Al(JTextField Id_Al, JTextField Id_In, JTextField Id_Arre, JTextField Id_Serv, JTextField Id_Cuar, JComboBox Estado) {
        try {
            ConexionBD con = new ConexionBD();
            Connection ConexionBD = con.getConnection();
            CallableStatement proc = ConexionBD.prepareCall("CALL SP_MODIFICARAL(?,?,?,?,?,?)");
            proc.setString(1, Id_Al.getText());
            proc.setString(2, Id_In.getText());
            proc.setString(3, Id_Arre.getText());
            proc.setString(4, Id_Serv.getText());
            proc.setString(5, Id_Cuar.getText());
            proc.setString(6, Estado.getSelectedItem().toString());
            proc.execute();
            gif_check();

        } catch (SQLException e) {

            System.out.println(e);

        }

    }

    public void gif_check() {
        ImageIcon check_gif = new ImageIcon("src/Imag/check.gif");
        ImageIcon resizedIcon = new ImageIcon(check_gif.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT));
        JOptionPane optionPane = new JOptionPane("Se modifico correctamente.", JOptionPane.PLAIN_MESSAGE, JOptionPane.DEFAULT_OPTION, resizedIcon, new Object[]{}, null);
        JDialog dialog = optionPane.createDialog("Information");
        ImageIcon customIcon = new ImageIcon("src/Imag/LogoTranss.png");
        Image image = customIcon.getImage();
        dialog.setIconImage(image);
        dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        dialog.setVisible(true);

    }
}
