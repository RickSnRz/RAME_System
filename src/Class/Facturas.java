/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

import Visual.Login;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.WindowConstants;
import model.ConnectionPool;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import paneles.pnlFac;

/**
 *
 * @author Rick
 */
public class Facturas {
    public Facturas(){
        try {
            JasperReport report;
            JasperPrint jprint;
            Map<String, Object> parametros = new HashMap<>();
            parametros.put("Id_Al", Integer.parseInt(pnlFac.Id_Al));
            parametros.put("N_Fac", pnlFac.N_Fac);
            parametros.put("Mes_Año", pnlFac.Mes);
            report = (JasperReport) JRLoader.loadObject(getClass().getResource("/Reports/Factura.jasper"));
            jprint = JasperFillManager.fillReport(report, parametros, ConnectionPool.getInstance().getConnection());
            JasperViewer view = new JasperViewer(jprint, false);
            view.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            view.setTitle("Vista Previa");
            view.setIconImage(getIconImage());
            view.setVisible(true);
        }catch (HeadlessException | NumberFormatException | JRException ex){
            System.out.print(ex.getMessage());
        } catch (SQLException ex) {
            Logger.getLogger(Report_Historial.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static Image getIconImage(){
        
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Imag/LogoIco.png"));
        return retValue;
    }
}
