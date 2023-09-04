package Class;

import Visual.Login;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import model.ConnectionPool;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.view.JasperViewer;

public class Report_Historial {

    public Report_Historial() {
        try {
            JasperReport report;
            JasperPrint jprint;
            Map<String, Object> parametros = new HashMap<>();
            parametros.put("user", Login.texto);
            report = (JasperReport) JRLoader.loadObject(getClass().getResource("/Reports/Roporte_Historial.jasper"));
            jprint = JasperFillManager.fillReport(report, parametros, ConnectionPool.getInstance().getConnection());
            JasperViewer view = new JasperViewer(jprint, false);
            view.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            view.setTitle("Vista Previa");
            view.setIconImage(getIconImage());
            view.setVisible(true); 
            
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            fileChooser.setDialogTitle("Guardar Informe");
            fileChooser.setSelectedFile(new File("Informe_Historial.pdf"));
            
             int userSelection = fileChooser.showSaveDialog(view);

            if (userSelection == JFileChooser.APPROVE_OPTION) {
                
                File fileToSave = fileChooser.getSelectedFile();
                String filePath = fileToSave.getAbsolutePath();

                
                JRPdfExporter pdfExporter = new JRPdfExporter();
                pdfExporter.setExporterInput(new SimpleExporterInput(jprint));
                pdfExporter.setExporterOutput(new SimpleOutputStreamExporterOutput(filePath));
                pdfExporter.exportReport();

                
                JOptionPane.showMessageDialog(view, "Guardado exitosamente en " + filePath, "Éxito", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (HeadlessException | NumberFormatException | JRException ex) {
            System.out.print(ex.getMessage());
        } catch (SQLException ex) {
            Logger.getLogger(Report_Historial.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Image getIconImage() {

        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Imag/LogoIco.png"));
        return retValue;
    }
}
