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

public class Add {

    public boolean add_Inq(JTextField Nombre, JTextField Apelldio, JTextField DNI, JTextField Telefono) {
        try {
            ConexionBD con = new ConexionBD();
            Connection ConexionBD = con.getConnection();
            CallableStatement proc = ConexionBD.prepareCall("CALL SP_INGRESARINQUILINO(?,?,?,?)");
            proc.setString(1, Nombre.getText());
            proc.setString(2, Apelldio.getText());
            proc.setString(3, DNI.getText());
            proc.setString(4, Telefono.getText());
            proc.execute();

            return true;

        } catch (SQLException e) {

            System.out.println(e);

        }
        return false;
    }

    public boolean add_Serv(JTextField Nombre, JTextField Precio) {
        try {
            ConexionBD con = new ConexionBD();
            Connection ConexionBD = con.getConnection();
            CallableStatement proc = ConexionBD.prepareCall("CALL SP_INGRESARSERVICIO(?,?)");
            proc.setString(1, Nombre.getText());
            proc.setString(2, Precio.getText());
            proc.execute();

            return true;

        } catch (SQLException e) {

            System.out.println(e);

        }
        return false;

    }

    public boolean add_Cuart(JTextField NCuarto, JTextField NPiso, JTextField PrecioCuart) {
        try {
            ConexionBD con = new ConexionBD();
            Connection ConexionBD = con.getConnection();
            CallableStatement proc = ConexionBD.prepareCall("CALL SP_INGRESARCUARTO(?,?,?)");
            proc.setString(1, NCuarto.getText());
            proc.setString(2, NPiso.getText());
            proc.setString(3, PrecioCuart.getText());
            proc.execute();

            return true;

        } catch (SQLException e) {

            System.out.println(e);

        }
        return false;

    }

    public void add_Al(JTextField Id_In, JTextField Id_Arre, JTextField Id_Serv, JTextField Id_Cuar, String Fecha, JComboBox Estado) {
        try {
            ConexionBD con = new ConexionBD();
            Connection ConexionBD = con.getConnection();
            CallableStatement proc = ConexionBD.prepareCall("CALL SP_INSERTARALQUILER(?,?,?,?,?,?)");
            proc.setString(1, Id_In.getText());
            proc.setString(2, Id_Arre.getText());
            proc.setString(3, Id_Serv.getText());
            proc.setString(4, Id_Cuar.getText());
            proc.setString(5, Fecha);
            proc.setString(6, Estado.getSelectedItem().toString());
            proc.execute();
            gif_check();

        } catch (SQLException e) {

            System.out.println(e);

        }

    }

    public boolean add_Re(JTextField Nombre, JTextField Apelldio, JTextField Precio, String Fecha) {
        try {
            ConexionBD con = new ConexionBD();
            Connection ConexionBD = con.getConnection();
            CallableStatement proc = ConexionBD.prepareCall("CALL SP_INGRESARDATOS(?,?,?,?)");
            proc.setString(1, Nombre.getText());
            proc.setString(2, Apelldio.getText());
            proc.setString(3, Precio.getText());
            proc.setString(4, Fecha);
            proc.execute();

            return true;

        } catch (SQLException e) {

            System.out.println(e);

        }
        return false;

    }

    public void add_Recibo(String N_Recibo, String Inquilino, String Cantidad, String Motivo, String Dia, String Mes, String Año) {
        try {
            ConexionBD con = new ConexionBD();
            Connection ConexionBD = con.getConnection();
            CallableStatement proc = ConexionBD.prepareCall("CALL SP_INGRESARRESIVO(?,?,?,?,?,?,?)");
            proc.setString(1, N_Recibo);
            proc.setString(2, Inquilino);
            proc.setString(3, Cantidad);
            proc.setString(4, Motivo);
            proc.setString(5, Dia);
            proc.setString(6, Mes);
            proc.setString(7, Año);
            proc.execute();

        } catch (SQLException e) {

            System.out.println(e);

        }

    }

    public void add_Fact(JTextField Id_Al, JTextField Nro, JTextField Mes) {
        try {
            ConexionBD con = new ConexionBD();
            Connection ConexionBD = con.getConnection();
            CallableStatement proc = ConexionBD.prepareCall("CALL SP_INGRESARFAC(?,?,?)");
            proc.setString(1, Id_Al.getText());
            proc.setString(2, Nro.getText());
            proc.setString(3, Mes.getText());
            proc.execute();

        } catch (SQLException e) {

            System.out.println(e);

        }

    }

    public void gif_check() {
        ImageIcon check_gif2 = new ImageIcon("src/Imag/check.gif");
        ImageIcon resizedIcon = new ImageIcon(check_gif2.getImage().getScaledInstance(85, 85, Image.SCALE_DEFAULT));
        JOptionPane optionPane = new JOptionPane("Se registro correctamente.", JOptionPane.PLAIN_MESSAGE, JOptionPane.DEFAULT_OPTION, resizedIcon, new Object[]{}, null);
        JDialog dialog = optionPane.createDialog("Alerta");
        ImageIcon customIcon = new ImageIcon("src/Imag/LogoTranss.png");
        Image image = customIcon.getImage();
        dialog.setIconImage(image);
        dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        dialog.setVisible(true);

    }

}

