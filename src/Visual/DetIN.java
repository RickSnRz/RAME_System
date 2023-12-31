package Visual;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.UIManager;
import paneles.CambiaPanel;
import paneles.pnlAldia;
import paneles.pnlCobrar;
import paneles.pnlRep;


public class DetIN extends javax.swing.JFrame {

    
    int xMouse, yMouse;
    
    public void BotonLimpio(){
        btnCobrar.setBorderPainted(false);
        btnCobrar.setContentAreaFilled(false);
        btnCobrar.setOpaque(false);
        btnSinDeudas.setBorderPainted(false);
        btnSinDeudas.setContentAreaFilled(false);
        btnSinDeudas.setOpaque(false);
        btnRepro.setBorderPainted(false);
        btnRepro.setContentAreaFilled(false);
        btnRepro.setOpaque(false);
    }
    
    
    
    
    public DetIN() {
        initComponents();
        this.setTitle("Detalle de Alquileres");
        CambiaPanel Rep = new CambiaPanel(pnlPrincipal, new pnlRep());
        BotonLimpio();
        this.setLocationRelativeTo(null);
        setIconImage(getIconImage());
    }

    @Override
    public Image getIconImage (){
        
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Imag/LogoTranss.png"));
        return retValue;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Body = new javax.swing.JPanel();
        Header = new javax.swing.JPanel();
        pnlCerrar = new javax.swing.JPanel();
        Cerrar = new javax.swing.JLabel();
        PnlMin = new javax.swing.JPanel();
        Min = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        pnlPrincipal = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        btnRepro = new javax.swing.JButton();
        btnSinDeudas = new javax.swing.JButton();
        btnCobrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        Body.setBackground(new java.awt.Color(204, 204, 204));

        Header.setBackground(new java.awt.Color(0, 51, 51));
        Header.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                HeaderMouseDragged(evt);
            }
        });
        Header.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                HeaderMousePressed(evt);
            }
        });

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

        PnlMin.setBackground(new java.awt.Color(0, 51, 51));
        PnlMin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Min.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imag/min.png"))); // NOI18N
        Min.setToolTipText("Minimizar");
        Min.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Min.setPreferredSize(new java.awt.Dimension(47, 47));
        Min.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MinMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MinMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MinMouseExited(evt);
            }
        });
        PnlMin.add(Min, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 6, 30, -1));

        javax.swing.GroupLayout HeaderLayout = new javax.swing.GroupLayout(Header);
        Header.setLayout(HeaderLayout);
        HeaderLayout.setHorizontalGroup(
            HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HeaderLayout.createSequentialGroup()
                .addGap(830, 830, 830)
                .addComponent(PnlMin, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(HeaderLayout.createSequentialGroup()
                .addGap(878, 878, 878)
                .addComponent(pnlCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        HeaderLayout.setVerticalGroup(
            HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PnlMin, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(pnlCerrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Constantia", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Detalles de Alquileres");

        pnlPrincipal.setBackground(new java.awt.Color(204, 204, 204));
        pnlPrincipal.setLayout(new javax.swing.BoxLayout(pnlPrincipal, javax.swing.BoxLayout.LINE_AXIS));

        jPanel1.setBackground(new java.awt.Color(0, 0, 102));
        jPanel1.setForeground(new java.awt.Color(153, 153, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnRepro.setBackground(new java.awt.Color(0, 0, 102));
        btnRepro.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        btnRepro.setForeground(new java.awt.Color(204, 255, 255));
        btnRepro.setText("Reprogramar pagos");
        btnRepro.setBorder(null);
        btnRepro.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnRepro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnReproMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnReproMouseExited(evt);
            }
        });
        btnRepro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReproActionPerformed(evt);
            }
        });
        jPanel1.add(btnRepro, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 0, 160, 47));

        btnSinDeudas.setBackground(new java.awt.Color(0, 0, 102));
        btnSinDeudas.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        btnSinDeudas.setForeground(new java.awt.Color(204, 255, 255));
        btnSinDeudas.setText("Estado de pagos");
        btnSinDeudas.setBorder(null);
        btnSinDeudas.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnSinDeudas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSinDeudasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSinDeudasMouseExited(evt);
            }
        });
        btnSinDeudas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSinDeudasActionPerformed(evt);
            }
        });
        jPanel1.add(btnSinDeudas, new org.netbeans.lib.awtextra.AbsoluteConstraints(144, 0, 140, 47));

        btnCobrar.setBackground(new java.awt.Color(0, 0, 102));
        btnCobrar.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        btnCobrar.setForeground(new java.awt.Color(204, 255, 255));
        btnCobrar.setText("Cobranza del Mes");
        btnCobrar.setBorder(null);
        btnCobrar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnCobrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCobrarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCobrarMouseExited(evt);
            }
        });
        btnCobrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCobrarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCobrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(-4, 0, 150, 47));

        javax.swing.GroupLayout BodyLayout = new javax.swing.GroupLayout(Body);
        Body.setLayout(BodyLayout);
        BodyLayout.setHorizontalGroup(
            BodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        BodyLayout.setVerticalGroup(
            BodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BodyLayout.createSequentialGroup()
                .addComponent(Header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnlPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Body, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Body, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCobrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCobrarActionPerformed
        CambiaPanel Cob = new CambiaPanel(pnlPrincipal, new pnlCobrar());
    }//GEN-LAST:event_btnCobrarActionPerformed

    private void btnSinDeudasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSinDeudasActionPerformed
        CambiaPanel ald = new CambiaPanel(pnlPrincipal, new pnlAldia());
    }//GEN-LAST:event_btnSinDeudasActionPerformed

    private void btnReproActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReproActionPerformed
        CambiaPanel Rep = new CambiaPanel(pnlPrincipal, new pnlRep());
    }//GEN-LAST:event_btnReproActionPerformed

    private void btnCobrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCobrarMouseEntered
        btnCobrar.setBorderPainted(false);
        btnCobrar.setBackground(new Color(102,255,255));
        btnCobrar.setOpaque(false);
        btnCobrar.setForeground(Color.BLACK);
        btnCobrar.setContentAreaFilled(true);
    }//GEN-LAST:event_btnCobrarMouseEntered

    private void btnCobrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCobrarMouseExited
        btnCobrar.setBackground(new Color(0,0,102));
        btnCobrar.setForeground(new Color(204,255,255));
        BotonLimpio();
    }//GEN-LAST:event_btnCobrarMouseExited

    private void btnSinDeudasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSinDeudasMouseEntered
        btnSinDeudas.setBorderPainted(false);
        btnSinDeudas.setBackground(new Color(102,255,255));
        btnSinDeudas.setOpaque(false);
        btnSinDeudas.setForeground(Color.BLACK);
        btnSinDeudas.setContentAreaFilled(true);
    }//GEN-LAST:event_btnSinDeudasMouseEntered

    private void btnSinDeudasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSinDeudasMouseExited
        btnSinDeudas.setBackground(new Color(0,0,102));
        btnSinDeudas.setForeground(new Color(204,255,255));
        BotonLimpio();
    }//GEN-LAST:event_btnSinDeudasMouseExited

    private void btnReproMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReproMouseEntered
        btnRepro.setBorderPainted(false);
        btnRepro.setBackground(new Color(102,255,255));
        btnRepro.setOpaque(false);
        btnRepro.setForeground(Color.BLACK);
        btnRepro.setContentAreaFilled(true);
    }//GEN-LAST:event_btnReproMouseEntered

    private void btnReproMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReproMouseExited
        btnRepro.setBackground(new Color(0,0,102));
        btnRepro.setForeground(new Color(204,255,255));
        BotonLimpio();
    }//GEN-LAST:event_btnReproMouseExited

    private void CerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CerrarMouseClicked
        this.dispose();
    }//GEN-LAST:event_CerrarMouseClicked

    private void CerrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CerrarMouseEntered
        pnlCerrar.setBackground(Color.RED);
    }//GEN-LAST:event_CerrarMouseEntered

    private void CerrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CerrarMouseExited
        pnlCerrar.setBackground(new Color(0,51,51));
    }//GEN-LAST:event_CerrarMouseExited

    private void HeaderMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HeaderMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_HeaderMousePressed

    private void HeaderMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HeaderMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_HeaderMouseDragged

    private void MinMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MinMouseClicked
        this.setExtendedState(ICONIFIED);
    }//GEN-LAST:event_MinMouseClicked

    private void MinMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MinMouseEntered
        PnlMin.setBackground(new Color(0,153,153));
    }//GEN-LAST:event_MinMouseEntered

    private void MinMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MinMouseExited
        PnlMin.setBackground(new Color(0,51,51));
    }//GEN-LAST:event_MinMouseExited

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
                    UIManager.put("nimbusBlueGrey", new Color(0,51,51));
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DetIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DetIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DetIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DetIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DetIN().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Body;
    private javax.swing.JLabel Cerrar;
    private javax.swing.JPanel Header;
    private javax.swing.JLabel Min;
    private javax.swing.JPanel PnlMin;
    private javax.swing.JButton btnCobrar;
    private javax.swing.JButton btnRepro;
    private javax.swing.JButton btnSinDeudas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel pnlCerrar;
    private javax.swing.JPanel pnlPrincipal;
    // End of variables declaration//GEN-END:variables
}
