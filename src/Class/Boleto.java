/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.HashMap;
import java.util.Map;
import javax.swing.WindowConstants;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import paneles.pnlBol;

/**
 *
 * @author Rick
 */
public class Boleto {
    public Boleto(){
        try {
            JasperReport report;
            JasperPrint jprint;
            Map<String, Object> parametros = new HashMap<>();
            parametros.put("Inquilino", pnlBol.inq);
            parametros.put("Cantidad", pnlBol.Cant);
            parametros.put("Motivo", pnlBol.Mot);
            parametros.put("Dia", pnlBol.Dia);
            parametros.put("Mes", pnlBol.Mes);
            parametros.put("Año", pnlBol.Año);
            parametros.put("N_Recibo", Integer.parseInt(pnlBol.Nre));
            report = (JasperReport) JRLoader.loadObject(getClass().getResource("/Reports/Boletas_Estela.jasper"));
            jprint = JasperFillManager.fillReport(report, parametros, new JREmptyDataSource());
            JasperViewer view = new JasperViewer(jprint, false);
            view.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            view.setTitle("Vista Previa");
            view.setIconImage(getIconImage());
            view.setVisible(true);
        }catch (HeadlessException | NumberFormatException | JRException ex){
            System.out.print(ex.getMessage());
        }
    }
    
    public Image getIconImage(){
        
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Imag/LogoIco.png"));
        return retValue;
    }
}
