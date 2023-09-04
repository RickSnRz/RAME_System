package Class;

import DataBase.ConexionBD;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JTextField;

public class Del {

    public boolean delete_Inq(JTextField Id_in) {
        try {
            ConexionBD con = new ConexionBD();
            Connection ConexionBD = con.getConnection();
            CallableStatement proc = ConexionBD.prepareCall("CALL SP_ELEMINARIN(?)");
            proc.setString(1, Id_in.getText());
            proc.execute();

            return true;
        } catch (SQLException e) {

            System.out.println(e);

        }
        return false;
    }

    public boolean delete_Serv(String Nombre) {
        try {
            ConexionBD con = new ConexionBD();
            Connection ConexionBD = con.getConnection();
            CallableStatement proc = ConexionBD.prepareCall("CALL SP_ELEMINARSERV(?)");
            proc.setString(1, Nombre);
            proc.execute();

            return true;

        } catch (SQLException e) {

            System.out.println(e);

        }
        return false;

    }

    public boolean delete_Cuart(String ID) {
        try {
            ConexionBD con = new ConexionBD();
            Connection ConexionBD = con.getConnection();
            CallableStatement proc = ConexionBD.prepareCall("CALL SP_ELEMINARCUARTO(?)");
            proc.setString(1, ID);
            proc.execute();

            return true;

        } catch (SQLException e) {

            System.out.println(e);

        }
        return false;

    }

    public boolean delete_Al(JTextField Id_Al) {
        try {
            ConexionBD con = new ConexionBD();
            Connection ConexionBD = con.getConnection();
            CallableStatement proc = ConexionBD.prepareCall("CALL SP_ELEMINARAL(?)");
            proc.setString(1, Id_Al.getText());
            proc.execute();

            return true;

        } catch (SQLException e) {

            System.out.println(e);

        }
        return false;

    }

    public boolean delete_Mes(int Id_Pedido) {
        String sql = "CALL SP_ELEMINARMESPAGO(?)";
        Connection cn;
        PreparedStatement pst;
        try {
            ConexionBD con = new ConexionBD();
            cn = con.getConnection();
            pst = cn.prepareStatement(sql);
            pst.setInt(1, Id_Pedido);
            int i = pst.executeUpdate();
            return i != 0;

        } catch (SQLException e) {

            System.out.println("Error al eliminar registro " + e.getMessage());

            return false;
        }

    }

}
