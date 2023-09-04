
package DAO;

import DataBase.ConexionBD;
import VO.PdfCont;
import VO.PdfDNI;
import VO.PdfVO;
import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



public class PdfDAO {
    
    /*Metodo listar*/
    public ArrayList<PdfVO> Listar_PdfVO() {
        ArrayList<PdfVO> list = new ArrayList<PdfVO>();
        ConexionBD conec = new ConexionBD();
        String sql = "SELECT * FROM PDF;";
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            ps = conec.getConnection().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                PdfVO vo = new PdfVO();
                vo.setId_Pdf(rs.getInt(1));
                vo.setInquilino(rs.getString(2));
                vo.setTipoPDF(rs.getString(3));
                vo.setArchivoPDF(rs.getBytes(4));
                list.add(vo);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                ps.close();
                rs.close();               
            } catch (Exception ex) {
            }
        }
        return list;
    }
    
    public ArrayList<PdfDNI> Listar_DNI() {
        ArrayList<PdfDNI> list = new ArrayList<PdfDNI>();
        ConexionBD conec = new ConexionBD();
        String sql = "SELECT * FROM DNI;";
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            ps = conec.getConnection().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                PdfDNI vo = new PdfDNI();
                vo.setId_DNI(rs.getInt(1));
                vo.setInquilino(rs.getString(2));
                vo.setN_DNI(rs.getInt(3));
                vo.setArchivoPDF(rs.getBytes(4));
                list.add(vo);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                ps.close();
                rs.close();               
            } catch (Exception ex) {
            }
        }
        return list;
    }
    
    public ArrayList<PdfCont> Listar_Cont() {
        ArrayList<PdfCont> list = new ArrayList<PdfCont>();
        ConexionBD conec = new ConexionBD();
        String sql = "SELECT * FROM Contrato;";
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            ps = conec.getConnection().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                PdfCont vo = new PdfCont();
                vo.setId_Contrato(rs.getInt(1));
                vo.setInquilino(rs.getString(2));
                vo.setFecha(rs.getString(3));
                vo.setArchivoPDF(rs.getBytes(4));
                list.add(vo);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                ps.close();
                rs.close();               
            } catch (Exception ex) {
            }
        }
        return list;
    }
    
    public ArrayList<PdfVO> Listar_PdfVO2() {
        ArrayList<PdfVO> list = new ArrayList<PdfVO>();
        ConexionBD conec = new ConexionBD();
        String sql = "SELECT * FROM PDF WHERE TipoPDF = 'Factura';";
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            ps = conec.getConnection().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                PdfVO vo = new PdfVO();
                vo.setId_Pdf(rs.getInt(1));
                vo.setInquilino(rs.getString(2));
                vo.setTipoPDF(rs.getString(3));
                vo.setArchivoPDF(rs.getBytes(4));
                list.add(vo);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                ps.close();
                rs.close();               
            } catch (Exception ex) {
            }
        }
        return list;
    }
    
    public ArrayList<PdfVO> Listar_PdfVO3() {
        ArrayList<PdfVO> list = new ArrayList<PdfVO>();
        ConexionBD conec = new ConexionBD();
        String sql = "SELECT * FROM PDF WHERE TipoPDF = 'Recibo';";
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            ps = conec.getConnection().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                PdfVO vo = new PdfVO();
                vo.setId_Pdf(rs.getInt(1));
                vo.setInquilino(rs.getString(2));
                vo.setTipoPDF(rs.getString(3));
                vo.setArchivoPDF(rs.getBytes(4));
                list.add(vo);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                ps.close();
                rs.close();               
            } catch (Exception ex) {
            }
        }
        return list;
    }
    
    public ArrayList<PdfVO> Listar_PdfVO4() {
        ArrayList<PdfVO> list = new ArrayList<PdfVO>();
        ConexionBD conec = new ConexionBD();
        String sql = "SELECT * FROM PDF WHERE TipoPDF = 'Garantia';";
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            ps = conec.getConnection().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                PdfVO vo = new PdfVO();
                vo.setId_Pdf(rs.getInt(1));
                vo.setInquilino(rs.getString(2));
                vo.setTipoPDF(rs.getString(3));
                vo.setArchivoPDF(rs.getBytes(4));
                list.add(vo);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                ps.close();
                rs.close();               
            } catch (Exception ex) {
            }
        }
        return list;
    }
    
    /*Metodo agregar*/
    public void Agregar_PdfVO(PdfVO vo) {
        ConexionBD conec = new ConexionBD();
        String sql = "INSERT INTO PDF (Inquilino, TipoPDF, ArchivoPDF) VALUES(?, ?, ?);";
        PreparedStatement ps = null;
        try {
            ps = conec.getConnection().prepareStatement(sql);
            ps.setString(1, vo.getInquilino());
            ps.setString(2, vo.getTipoPDF());
            ps.setBytes(3, vo.getArchivopdf());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                ps.close();
            } catch (Exception ex) {
            }
        }
    }
    
    public void Agregar_DNI(PdfDNI vo) {
        ConexionBD conec = new ConexionBD();
        String sql = "INSERT INTO DNI (Inquilino, N_DNI, ArchivoPDF) VALUES(?, ?, ?);";
        PreparedStatement ps = null;
        try {
            ps = conec.getConnection().prepareStatement(sql);
            ps.setString(1, vo.getInquilino());
            ps.setInt(2, vo.getN_DNI());
            ps.setBytes(3, vo.getArchivopdf());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                ps.close();
            } catch (Exception ex) {
            }
        }
    }
    
    public void Agregar_Cont(PdfCont vo) {
        ConexionBD conec = new ConexionBD();
        String sql = "INSERT INTO Contrato (Inquilino, Fecha, ArchivoPDF) VALUES(?, ?, ?);";
        PreparedStatement ps = null;
        try {
            ps = conec.getConnection().prepareStatement(sql);
            ps.setString(1, vo.getInquilino());
            ps.setString(2, vo.getFecha());
            ps.setBytes(3, vo.getArchivoPDF());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                ps.close();
            } catch (Exception ex) {
            }
        }
    }
    
    public void Modificar_PdfVO(PdfVO vo) {
        ConexionBD conec = new ConexionBD();
        String sql = "UPDATE PDF SET Inquilino = ?, TipoPDF = ?, ArchivoPDF = ? WHERE Id_Pdf = ?;";
        PreparedStatement ps = null;
        try {
            ps = conec.getConnection().prepareStatement(sql);
            ps.setString(1, vo.getInquilino());
            ps.setString(2, vo.getTipoPDF());
            ps.setBytes(3, vo.getArchivopdf());
            ps.setInt(4, vo.getId_Pdf());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                ps.close();
            } catch (Exception ex) {
            }
        }
    }
    
    public void Modificar_PdfDNI(PdfDNI vo) {
        ConexionBD conec = new ConexionBD();
        String sql = "UPDATE DNI SET Inquilino = ?, N_DNI = ?, ArchivoPDF = ? WHERE Id_DNI = ?;";
        PreparedStatement ps = null;
        try {
            ps = conec.getConnection().prepareStatement(sql);
            ps.setString(1, vo.getInquilino());
            ps.setInt(2, vo.getN_DNI());
            ps.setBytes(3, vo.getArchivopdf());
            ps.setInt(4, vo.getId_DNI());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                ps.close();
            } catch (Exception ex) {
            }
        }
    }
    
    public void Modificar_PdfCont(PdfCont vo) {
        ConexionBD conec = new ConexionBD();
        String sql = "UPDATE Contrato SET Inquilino = ?, Fecha = ?, ArchivoPDF = ? WHERE Id_Contrato = ?;";
        PreparedStatement ps = null;
        try {
            ps = conec.getConnection().prepareStatement(sql);
            ps.setString(1, vo.getInquilino());
            ps.setString(2, vo.getFecha());
            ps.setBytes(3, vo.getArchivoPDF());
            ps.setInt(4, vo.getId_Contrato());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                ps.close();
            } catch (Exception ex) {
            }
        }
    }
    
    //Permite mostrar PDF contenido en la base de datos
    public void ejecutar_archivoPDF(int id) {

        ConexionBD cn = new ConexionBD();
        PreparedStatement ps = null;
        ResultSet rs = null;
        byte[] b = null;

        try {
            ps = cn.getConnection().prepareStatement("SELECT ArchivoPDF FROM pdf WHERE Id_Pdf = ?;");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                b = rs.getBytes(1);
            }
            InputStream bos = new ByteArrayInputStream(b);

            int tamanoInput = bos.available();
            byte[] datosPDF = new byte[tamanoInput];
            bos.read(datosPDF, 0, tamanoInput);

            OutputStream out = new FileOutputStream("new.pdf");
            out.write(datosPDF);

            //abrir archivo
            out.close();
            bos.close();
            ps.close();
            rs.close();

        } catch (IOException | NumberFormatException | SQLException ex) {
            System.out.println("Error al abrir archivo PDF " + ex.getMessage());
        }
    }
    
    public void ejecutar_archivoDNI(int id) {

        ConexionBD cn = new ConexionBD();
        PreparedStatement ps = null;
        ResultSet rs = null;
        byte[] b = null;

        try {
            ps = cn.getConnection().prepareStatement("SELECT ArchivoPDF FROM DNI WHERE Id_DNI = ?;");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                b = rs.getBytes(1);
            }
            InputStream bos = new ByteArrayInputStream(b);

            int tamanoInput = bos.available();
            byte[] datosPDF = new byte[tamanoInput];
            bos.read(datosPDF, 0, tamanoInput);

            OutputStream out = new FileOutputStream("new.pdf");
            out.write(datosPDF);

            //abrir archivo
            out.close();
            bos.close();
            ps.close();
            rs.close();

        } catch (IOException | NumberFormatException | SQLException ex) {
            System.out.println("Error al abrir archivo PDF " + ex.getMessage());
        }
    }
    
    public void ejecutar_archivoCont(int id) {

        ConexionBD cn = new ConexionBD();
        PreparedStatement ps = null;
        ResultSet rs = null;
        byte[] b = null;

        try {
            ps = cn.getConnection().prepareStatement("SELECT ArchivoPDF FROM Contrato WHERE Id_Contrato = ?;");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                b = rs.getBytes(1);
            }
            InputStream bos = new ByteArrayInputStream(b);

            int tamanoInput = bos.available();
            byte[] datosPDF = new byte[tamanoInput];
            bos.read(datosPDF, 0, tamanoInput);

            OutputStream out = new FileOutputStream("new.pdf");
            out.write(datosPDF);

            //abrir archivo
            out.close();
            bos.close();
            ps.close();
            rs.close();

        } catch (IOException | NumberFormatException | SQLException ex) {
            System.out.println("Error al abrir archivo PDF " + ex.getMessage());
        }
    }
}
