/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dialogo;

import DataBase.ConexionBD;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Rick
 */
public class Estadistica extends javax.swing.JDialog {

    Notificacion No = new Notificacion(null, false);

    private void TablaLimpia(){
        visor.getColumnModel().getColumn(0).setResizable(false);
        visor.getColumnModel().getColumn(1).setResizable(false);
        visor.getColumnModel().getColumn(2).setResizable(false);
        visor.getColumnModel().getColumn(0).setPreferredWidth(50);
        visor.getColumnModel().getColumn(1).setPreferredWidth(50);
        visor.getColumnModel().getColumn(2).setPreferredWidth(50);
        visor.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        visor.getTableHeader().setOpaque(false);
        visor.getTableHeader().setBackground(new Color(0, 51, 51));
        visor.getTableHeader().setForeground(Color.WHITE);
        JScrollBar sb = scroll.getVerticalScrollBar();
        sb.setOpaque(false);
        sb.setForeground(new Color(33, 140, 206));
        sb.setPreferredSize(new Dimension(8, 8));
        sb.setUI(new ModernScrollBarUI());
        scroll.getViewport().setOpaque(false);
        scroll.setViewportBorder(null);
    }
    
    
    
    public Estadistica(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        
        initComponents();
        
        this.setLocationRelativeTo(null);
        TablaLimpia();
    }

     public void mostrar(String tabla, String Inquilino){
        String sql = "select Mes, Precio, Estado from " + tabla + " where accion = '" + Inquilino + "';";
        Statement st;
        ConexionBD con = new ConexionBD();
        Connection DBConexion = con.getConnection();  
        System.out.println(sql);
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Mes/Año");
        model.addColumn("Precio S/.");
        model.addColumn("Estado");
        visor.setModel(model);
        
        String [] datos = new String[3];
        try{
            st = DBConexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next())
               {
                   datos[0]=rs.getString(1);
                   datos[1]=rs.getString(2);
                   datos[2]=rs.getString(3);
                   model.addRow(datos);
               } 
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "ERROR" + e.toString());
            
        }
    }
     
    public void pagado(String tabla, String Inquilino){
        String sql = "select Mes, Precio, Estado from " + tabla + " where accion = '" + Inquilino +
                "' and Estado = 'pagado';";
        Statement st;
        ConexionBD con = new ConexionBD();
        Connection DBConexion = con.getConnection();  
        System.out.println(sql);
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Mes/Año");
        model.addColumn("Precio S/.");
        model.addColumn("Estado");
        visor.setModel(model);
        
        String [] datos = new String[3];
        try{
            st = DBConexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next())
               {
                   datos[0]=rs.getString(1);
                   datos[1]=rs.getString(2);
                   datos[2]=rs.getString(3);
                   model.addRow(datos);
               } 
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "ERROR" + e.toString());
            
        }
    }
    
    public void pendiente(String tabla, String Inquilino){
        String sql = "select Mes, Precio, Estado from " + tabla + " where accion = '" + Inquilino + 
                "' and Estado = 'pendiente';";
        Statement st;
        ConexionBD con = new ConexionBD();
        Connection DBConexion = con.getConnection();  
        System.out.println(sql);
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Mes/Año");
        model.addColumn("Precio S/.");
        model.addColumn("Estado");
        visor.setModel(model);
        
        String [] datos = new String[3];
        try {
            st = DBConexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                model.addRow(datos);
            }

            if (model.getRowCount() == 0) {
                // Si no hay pagos pendientes, agregamos una fila con el mensaje "Sin pagos pendientes"
                model.addRow(new String[]{"Sin pagos pendientes", "", ""});
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR" + e.toString());

        }
    }

    public void DNIS(String nombreInquilino) {
        // Configura los detalles de la conexión
        String url = "jdbc:mysql://localhost:3306/Estela";
        String user = "root";
        String password = "989974718@";

        try {
            // Establece la conexión
            Connection conn = DriverManager.getConnection(url, user, password);

            // Realiza la consulta SQL para obtener el DNI del inquilino
            String query = "SELECT DNI FROM DNIS WHERE NombreCompleto = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, nombreInquilino);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String dni = resultSet.getString("DNI");
                DNI.setText("DNI: " + dni);
            } else {
                DNI.setText("No encontrado");
            }

            // Cierra los recursos
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            DNI.setText("Error Nombre");
        }
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
        Inq = new javax.swing.JLabel();
        DNI = new javax.swing.JLabel();
        pnlCerrar = new javax.swing.JPanel();
        Cerrar = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        scroll = new javax.swing.JScrollPane();
        visor = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.setBackground(new java.awt.Color(0, 51, 51));
        jPanel2.setPreferredSize(new java.awt.Dimension(568, 60));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Inq.setFont(new java.awt.Font("Constantia", 1, 14)); // NOI18N
        Inq.setForeground(new java.awt.Color(204, 204, 204));
        jPanel2.add(Inq, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 212, 21));

        DNI.setFont(new java.awt.Font("Constantia", 1, 14)); // NOI18N
        DNI.setForeground(new java.awt.Color(204, 204, 204));
        jPanel2.add(DNI, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 30, 153, 21));

        pnlCerrar.setBackground(new java.awt.Color(0, 51, 51));

        Cerrar.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        Cerrar.setForeground(new java.awt.Color(0, 0, 0));
        Cerrar.setText("X");
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
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(Cerrar)
                .addGap(16, 16, 16))
        );
        pnlCerrarLayout.setVerticalGroup(
            pnlCerrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCerrarLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Cerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        jPanel2.add(pnlCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(563, 0, -1, -1));

        jPanel1.add(jPanel2, java.awt.BorderLayout.PAGE_START);

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        visor = new javax.swing.JTable(){
            public boolean isCellEditable(int row, int col){
                return false;
            }
        };
        visor.setForeground(new java.awt.Color(0, 0, 0));
        visor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Mes/Año", "Precio", "Estado"
            }
        ));
        visor.setFocusable(false);
        visor.setRowHeight(25);
        visor.setSelectionBackground(new java.awt.Color(0, 0, 102));
        visor.setSelectionForeground(new java.awt.Color(255, 255, 102));
        visor.getTableHeader().setReorderingAllowed(false);
        scroll.setViewportView(visor);

        jPanel3.add(scroll, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 71, 488, 281));

        jLabel3.setFont(new java.awt.Font("Constantia", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 102));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Historial de Pagos");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 6, 629, -1));

        jButton1.setFont(new java.awt.Font("Constantia", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Pendientes");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(512, 66, 103, 50));

        jButton2.setFont(new java.awt.Font("Constantia", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Pagados");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(512, 122, 103, 49));

        jButton3.setFont(new java.awt.Font("Constantia", 1, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Actualizar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(512, 177, 103, 49));

        jPanel1.add(jPanel3, java.awt.BorderLayout.CENTER);

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

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String nombre = Inq.getText();
        mostrar("accion", nombre);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String nombre = Inq.getText();
        pagado("accion", nombre);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String nombre = Inq.getText();
        pendiente("accion", nombre);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void CerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CerrarMouseClicked
        this.dispose();
    }//GEN-LAST:event_CerrarMouseClicked

    private void CerrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CerrarMouseEntered
        pnlCerrar.setBackground(Color.RED);
    }//GEN-LAST:event_CerrarMouseEntered

    private void CerrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CerrarMouseExited
        pnlCerrar.setBackground(new Color(0,51,51));
    }//GEN-LAST:event_CerrarMouseExited

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
            java.util.logging.Logger.getLogger(Estadistica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Estadistica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Estadistica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Estadistica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Estadistica dialog = new Estadistica(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Cerrar;
    private javax.swing.JLabel DNI;
    public javax.swing.JLabel Inq;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel pnlCerrar;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JTable visor;
    // End of variables declaration//GEN-END:variables
}
