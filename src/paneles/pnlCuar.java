package paneles;

import Class.Add;
import Class.Del;
import Class.Mod;
import DataBase.ConexionBD;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;


public class pnlCuar extends javax.swing.JPanel {

    
    public void alert_int() {
        ImageIcon check_gif = new ImageIcon("src/Imag/warning.gif");
        ImageIcon resizedIcon = new ImageIcon(check_gif.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT));
        JOptionPane optionPane = new JOptionPane("Ingrese solo números.", JOptionPane.PLAIN_MESSAGE, JOptionPane.DEFAULT_OPTION, resizedIcon, new Object[]{}, null);
        JDialog dialog = optionPane.createDialog("Alerta");
        ImageIcon customIcon = new ImageIcon("src/Imag/LogoTranss.png");
        Image image = customIcon.getImage();
        dialog.setIconImage(image);
        dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        dialog.setVisible(true);

    }
    
    public void alert_String() {
        ImageIcon check_gif = new ImageIcon("src/Imag/warning.gif");
        ImageIcon resizedIcon = new ImageIcon(check_gif.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT));
        JOptionPane optionPane = new JOptionPane("Ingrese solo letras.", JOptionPane.PLAIN_MESSAGE, JOptionPane.DEFAULT_OPTION, resizedIcon, new Object[]{}, null);
        JDialog dialog = optionPane.createDialog("Alerta");
        ImageIcon customIcon = new ImageIcon("src/Imag/LogoTranss.png");
        Image image = customIcon.getImage();
        dialog.setIconImage(image);
        dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        dialog.setVisible(true);

    }
    
    public void TablaLimpia(){
        visor.getColumnModel().getColumn(0).setResizable(false);
        visor.getColumnModel().getColumn(1).setResizable(false);
        visor.getColumnModel().getColumn(2).setResizable(false);
        visor.getColumnModel().getColumn(3).setResizable(false);
        visor.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        visor.getTableHeader().setOpaque(false);
        visor.getTableHeader().setBackground(new Color(0, 51, 51));
        visor.getTableHeader().setForeground(Color.WHITE);
        visor.setRowHeight(25);
    }
    
    public void Limpio(){
        jTextNCuar.setText(null);
        jTextNPi.setText(null);
        jTextPre.setText(null);
    }
    
    public static String ID = "";
    
    public pnlCuar() {
        initComponents();
        mostrar3("Cuarto");
        TablaLimpia();
        visor.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent Mouse_evt){
                JTable table = (JTable) Mouse_evt.getSource();
                Point point = Mouse_evt.getPoint();
                int row = table.rowAtPoint(point);
                if(Mouse_evt.getClickCount() == 2){
                    
                    jTextNCuar.setText(visor.getValueAt(visor.getSelectedRow(), 1).toString()); 
                    jTextNPi.setText(visor.getValueAt(visor.getSelectedRow(), 2).toString());
                    jTextPre.setText(visor.getValueAt(visor.getSelectedRow(), 3).toString());
                } if(Mouse_evt.getClickCount() == 1){
                    ID = (String)visor.getValueAt(visor.getSelectedRow(), 0);                   
                }
            }
        });
    }

    public void mostrar3(String tabla){
        String sql = "select * from " + tabla;
        Statement st;
        ConexionBD con = new ConexionBD();
        Connection DBConexion = con.getConnection();  
        System.out.println(sql);
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Cod.Cuarto");
        model.addColumn("N°.Cuarto");
        model.addColumn("N°.Piso");
        model.addColumn("Precio");
        visor.setModel(model);
        
        String [] datos = new String[4];
        try{
            st = DBConexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next())
               {
                   datos[0]=rs.getString(1);
                   datos[1]=rs.getString(2);
                   datos[2]=rs.getString(3);
                   datos[3]=rs.getString(4);
                   model.addRow(datos);
               } 
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "ERROR" + e.toString());
            
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

        jTextNCuar = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextNPi = new javax.swing.JTextField();
        jTextPre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btnEli = new javax.swing.JButton();
        btnMod = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        visor = new javax.swing.JTable();
        btnIn = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        Text = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 204, 204));
        setPreferredSize(new java.awt.Dimension(732, 512));

        jTextNCuar.setBackground(new java.awt.Color(255, 255, 255));
        jTextNCuar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextNCuar.setForeground(new java.awt.Color(0, 0, 0));
        jTextNCuar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextNCuarKeyTyped(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Datos del Cuarto");

        jLabel3.setFont(new java.awt.Font("Constantia", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("N°Piso:");

        jTextNPi.setBackground(new java.awt.Color(255, 255, 255));
        jTextNPi.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextNPi.setForeground(new java.awt.Color(0, 0, 0));
        jTextNPi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextNPiKeyTyped(evt);
            }
        });

        jTextPre.setBackground(new java.awt.Color(255, 255, 255));
        jTextPre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextPre.setForeground(new java.awt.Color(0, 0, 0));
        jTextPre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextPreKeyTyped(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Constantia", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Precio:");

        btnEli.setBackground(new java.awt.Color(0, 0, 0));
        btnEli.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        btnEli.setForeground(new java.awt.Color(255, 255, 255));
        btnEli.setText("Eliminar");
        btnEli.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEliMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEliMouseExited(evt);
            }
        });
        btnEli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliActionPerformed(evt);
            }
        });

        btnMod.setBackground(new java.awt.Color(0, 0, 0));
        btnMod.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        btnMod.setForeground(new java.awt.Color(255, 255, 255));
        btnMod.setText("Modificar");
        btnMod.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnModMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnModMouseExited(evt);
            }
        });
        btnMod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModActionPerformed(evt);
            }
        });

        visor = new javax.swing.JTable(){
            public boolean isCellEditable(int row, int col){
                return false;
            }
        };
        visor.setBackground(new java.awt.Color(255, 255, 255));
        visor.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        visor.setForeground(new java.awt.Color(0, 0, 0));
        visor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        visor.setFocusable(false);
        visor.setIntercellSpacing(new java.awt.Dimension(0, 0));
        visor.setRowHeight(25);
        visor.setSelectionBackground(new java.awt.Color(0, 0, 51));
        visor.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(visor);

        btnIn.setBackground(new java.awt.Color(0, 0, 0));
        btnIn.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        btnIn.setForeground(new java.awt.Color(255, 255, 255));
        btnIn.setText("Ingresar");
        btnIn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnInMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnInMouseExited(evt);
            }
        });
        btnIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Constantia", 1, 48)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Cuartos de Alquiler");

        Text.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Text.setForeground(new java.awt.Color(0, 0, 0));

        jLabel6.setFont(new java.awt.Font("Constantia", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("N°Cuarto:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jTextNPi, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel6)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jTextNCuar, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(370, 370, 370)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnIn, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEli, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(jTextPre, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 811, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel4)
                .addGap(522, 522, 522)
                .addComponent(btnMod))
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 710, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Text, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(btnIn)
                        .addGap(2, 2, 2)
                        .addComponent(btnEli))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(jTextNCuar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTextNPi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(jTextPre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnMod))
                .addGap(75, 75, 75)
                .addComponent(Text, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTextNCuarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextNCuarKeyTyped
        char validar = evt.getKeyChar();

        if (Character.isLetter(validar)) {
            getToolkit().beep();
            evt.consume();
        
            alert_int();
        }
    }//GEN-LAST:event_jTextNCuarKeyTyped

    private void jTextNPiKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextNPiKeyTyped
        char validar = evt.getKeyChar();

        if (Character.isLetter(validar)) {
            getToolkit().beep();
            evt.consume();

            alert_int();
        }
    }//GEN-LAST:event_jTextNPiKeyTyped

    private void jTextPreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextPreKeyTyped
        char validar=evt.getKeyChar();

        if(Character.isLetter(validar)){
            getToolkit().beep();
            evt.consume();

            alert_int();
        }
    }//GEN-LAST:event_jTextPreKeyTyped

    private void btnInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInActionPerformed
        Add a = new Add();
        if(a.add_Cuart(jTextNCuar, jTextNPi, jTextPre)){
            Text.setText("Se registro correctamente.");
            mostrar3("Cuarto");
            Limpio();
            Timer timer = new Timer(5000, e -> {
                Text.setText("");
                ((Timer) e.getSource()).stop();
            });
            timer.start();
        } else {
            Text.setText("Error verificar los campos.");
        }

    }//GEN-LAST:event_btnInActionPerformed

    private void btnEliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliActionPerformed
        Del d = new Del();
        if(d.delete_Cuart(ID)){
            Text.setText("Se elimino correctamente.");
            mostrar3("Cuarto");
            Limpio();
            Timer timer = new Timer(5000, e -> {
                Text.setText("");
                ((Timer) e.getSource()).stop();
            });
            timer.start();
        } else {
            Text.setText("Error verificar los campos.");
        }

    }//GEN-LAST:event_btnEliActionPerformed

    private void btnModActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModActionPerformed
        Mod m = new Mod();
        if(m.mod_Cuart(ID, jTextNCuar, jTextNPi, jTextPre)){
            Text.setText("Se modifico correctamente.");
            mostrar3("Cuarto");
            Limpio();
            Timer timer = new Timer(5000, e -> {
                Text.setText("");
                ((Timer) e.getSource()).stop();
            });
            timer.start();
        } else {
            Text.setText("Error verificar los campos.");
        }

    }//GEN-LAST:event_btnModActionPerformed

    private void btnInMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInMouseEntered
        btnIn.setBackground(Color.BLUE);
    }//GEN-LAST:event_btnInMouseEntered

    private void btnInMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInMouseExited
        btnIn.setBackground(new Color(0, 0, 0));
    }//GEN-LAST:event_btnInMouseExited

    private void btnEliMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliMouseEntered
        btnEli.setBackground(Color.RED);
    }//GEN-LAST:event_btnEliMouseEntered

    private void btnEliMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliMouseExited
        btnEli.setBackground(new Color(0, 0, 0));
    }//GEN-LAST:event_btnEliMouseExited

    private void btnModMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModMouseEntered
        btnMod.setBackground(Color.CYAN);
    }//GEN-LAST:event_btnModMouseEntered

    private void btnModMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModMouseExited
        btnMod.setBackground(new Color(0, 0, 0));
    }//GEN-LAST:event_btnModMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Text;
    private javax.swing.JButton btnEli;
    private javax.swing.JButton btnIn;
    private javax.swing.JButton btnMod;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextNCuar;
    private javax.swing.JTextField jTextNPi;
    private javax.swing.JTextField jTextPre;
    private javax.swing.JTable visor;
    // End of variables declaration//GEN-END:variables
}
