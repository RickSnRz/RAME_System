package Visual;

import DAO.PdfDAO;
import Tabla.Tabla_PdfVO;
import VO.PdfDNI;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;


public class ModDNI extends javax.swing.JFrame {

    Tabla_PdfVO tpdf = new Tabla_PdfVO();
    
    String ruta_archivo = "";
    
    public boolean estado = true;
    
    
    public ModDNI() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("MOD DNI");
        setIconImage(getIconImage());
    }
    
    @Override
    public Image getIconImage (){
        
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Imag/LogoTranss.png"));
        return retValue;
    }
    
    public void seleccionar_pdf() {
        JFileChooser j = new JFileChooser();
        FileNameExtensionFilter fi = new FileNameExtensionFilter("pdf", "pdf");
        j.setFileFilter(fi);
        int se = j.showOpenDialog(this);
        if (se == 0) {
            this.btnseleccionar.setText("" + j.getSelectedFile().getName());
            ruta_archivo = j.getSelectedFile().getAbsolutePath();

        } else {
        }
    }
    
    public void modificar_pdf(int Id_DNI, String Inquilino, int N_DNI, File ruta) {
        PdfDAO pa = new PdfDAO();
        PdfDNI po = new PdfDNI();
        po.setId_DNI(Id_DNI);
        po.setInquilino(Inquilino);
        po.setN_DNI(N_DNI);
        try {
            byte[] pdf = new byte[(int) ruta.length()];
            InputStream input = new FileInputStream(ruta);
            input.read(pdf);
            po.setArchivoPDF(pdf);
        } catch (IOException ex) {
            po.setArchivoPDF(null);
            //System.out.println("Error al agregar archivo pdf "+ex.getMessage());
        }
        pa.Modificar_PdfDNI(po);
    }
    
    public void gif_check() {
        ImageIcon check_gif = new ImageIcon("src/Imag/check.gif");
        ImageIcon resizedIcon = new ImageIcon(check_gif.getImage().getScaledInstance(85, 85, Image.SCALE_DEFAULT));
        JOptionPane optionPane = new JOptionPane("Se guardos los cambios correctamente.\n Porfavor refrescar ventana.", JOptionPane.PLAIN_MESSAGE, JOptionPane.DEFAULT_OPTION, resizedIcon, new Object[]{}, null);
        JDialog dialog = optionPane.createDialog("Information");
        ImageIcon customIcon = new ImageIcon("src/Imag/LogoTranss.png");
        Image image = customIcon.getImage();
        dialog.setIconImage(image);
        dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        dialog.setVisible(true);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        pnlCerrar = new javax.swing.JPanel();
        Cerrar = new javax.swing.JLabel();
        Id_DNI = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        DNI = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btnseleccionar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jPanel2.setBackground(new java.awt.Color(0, 51, 51));

        pnlCerrar.setBackground(new java.awt.Color(0, 51, 51));

        Cerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imag/Imagen17.png"))); // NOI18N
        Cerrar.setToolTipText("Atras");
        Cerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Cerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CerrarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CerrarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                CerrarMouseExited(evt);
            }
        });

        javax.swing.GroupLayout pnlCerrarLayout = new javax.swing.GroupLayout(pnlCerrar);
        pnlCerrar.setLayout(pnlCerrarLayout);
        pnlCerrarLayout.setHorizontalGroup(
            pnlCerrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCerrarLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Cerrar)
                .addGap(19, 19, 19))
        );
        pnlCerrarLayout.setVerticalGroup(
            pnlCerrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCerrarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Cerrar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Id_DNI.setEditable(false);
        Id_DNI.setBackground(new java.awt.Color(0, 51, 51));
        Id_DNI.setForeground(new java.awt.Color(0, 51, 51));
        Id_DNI.setToolTipText("");
        Id_DNI.setBorder(null);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Id_DNI, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnlCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlCerrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Id_DNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Constantia", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Modificar DNI de inquilino");

        jLabel2.setFont(new java.awt.Font("Constantia", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Nombre y apellido:");

        name.setEditable(false);
        name.setBackground(new java.awt.Color(0, 51, 51));
        name.setForeground(new java.awt.Color(255, 255, 255));
        name.setToolTipText("");

        jLabel3.setFont(new java.awt.Font("Constantia", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("N°DNI:");

        DNI.setEditable(false);
        DNI.setBackground(new java.awt.Color(0, 51, 51));
        DNI.setForeground(new java.awt.Color(255, 255, 255));
        DNI.setToolTipText("");

        jLabel4.setFont(new java.awt.Font("Constantia", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Elija el PDF del DNI:");

        btnseleccionar.setBackground(new java.awt.Color(0, 51, 51));
        btnseleccionar.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        btnseleccionar.setForeground(new java.awt.Color(255, 255, 255));
        btnseleccionar.setText("Seleccionar......");
        btnseleccionar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnseleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnseleccionarActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("MODIFICAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 614, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel2)
                .addGap(6, 6, 6)
                .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel3)
                .addGap(6, 6, 6)
                .addComponent(DNI, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel4))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(btnseleccionar, javax.swing.GroupLayout.PREFERRED_SIZE, 588, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(214, 214, 214)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel2))
                    .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel3))
                    .addComponent(DNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addComponent(jLabel4)
                .addGap(11, 11, 11)
                .addComponent(btnseleccionar)
                .addGap(34, 34, 34)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CerrarMouseClicked
        this.dispose();
    }//GEN-LAST:event_CerrarMouseClicked

    private void CerrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CerrarMouseEntered
        pnlCerrar.setBackground(Color.RED);
    }//GEN-LAST:event_CerrarMouseEntered

    private void CerrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CerrarMouseExited
        pnlCerrar.setBackground(new Color(0,51,51));
    }//GEN-LAST:event_CerrarMouseExited

    private void btnseleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnseleccionarActionPerformed
        seleccionar_pdf();
    }//GEN-LAST:event_btnseleccionarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        if (estado) {
            name.setEditable(true);
            DNI.setEditable(true);

            name.setBackground(Color.WHITE);
            name.setForeground(Color.BLACK);
            DNI.setBackground(Color.WHITE);
            DNI.setForeground(Color.BLACK);
            
            jButton1.setText("Guardar");
            jButton1.setForeground(Color.BLACK);
            jButton1.setBackground(Color.CYAN);
            
            estado = false;
            
        } else {

            String Inquilino = name.getText();
            int N = Integer.parseInt(DNI.getText());
            int id = Integer.parseInt(Id_DNI.getText());
            File ruta = new File(ruta_archivo);
            modificar_pdf(id, Inquilino, N, ruta);
            gif_check();

            name.setEditable(false);
            DNI.setEditable(false);

            name.setBackground(new Color(0, 51, 51));
            name.setForeground(Color.WHITE);
            DNI.setBackground(new Color(0, 51, 51));
            DNI.setForeground(Color.WHITE);
            
            btnseleccionar.setText("MODIFICAR");
            jButton1.setForeground(Color.WHITE);
            jButton1.setBackground(Color.BLACK);

            estado = true;

        }
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ModDNI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModDNI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModDNI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModDNI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModDNI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Cerrar;
    public javax.swing.JTextField DNI;
    public javax.swing.JTextField Id_DNI;
    public javax.swing.JButton btnseleccionar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public javax.swing.JTextField name;
    private javax.swing.JPanel pnlCerrar;
    // End of variables declaration//GEN-END:variables
}