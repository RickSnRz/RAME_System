package paneles;

import Class.Add;
import Class.Del;
import Class.Mod;
import DataBase.ConexionBD;
import Visual.Modin;
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


public class pnlin extends javax.swing.JPanel {

 Mod c = new Mod();  
 Del b = new Del();   
 Add a = new Add() ;  
 
    public void alert_int() {
        ImageIcon check_gif = new ImageIcon("src/Imag/warning.gif");
        ImageIcon resizedIcon = new ImageIcon(check_gif.getImage().getScaledInstance(85, 85, Image.SCALE_DEFAULT));
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
        ImageIcon resizedIcon = new ImageIcon(check_gif.getImage().getScaledInstance(85, 85, Image.SCALE_DEFAULT));
        JOptionPane optionPane = new JOptionPane("Ingrese solo letras.", JOptionPane.PLAIN_MESSAGE, JOptionPane.DEFAULT_OPTION, resizedIcon, new Object[]{}, null);
        JDialog dialog = optionPane.createDialog("Alerta");
        ImageIcon customIcon = new ImageIcon("src/Imag/LogoTranss.png");
        Image image = customIcon.getImage();
        dialog.setIconImage(image);
        dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        dialog.setVisible(true);

    }

    public void TablaLimpia() {
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
 
    public void StringsLimpio() {
        jTextNo.setText(null);
        jTextAp.setText(null);
        jTextDNI.setText(null);
        jTextTef.setText(null);
    }

    public static String inf_in = "";
    
    public pnlin() {
        initComponents();
        mostrar("Inquilino");
        TablaLimpia();
        visor.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent Mouse_evt){
                JTable table = (JTable) Mouse_evt.getSource();
                Point point = Mouse_evt.getPoint();
                int row = table.rowAtPoint(point);
                if(Mouse_evt.getClickCount() == 1){
                    jTextId_in.setText(visor.getValueAt(visor.getSelectedRow(), 0).toString());                   
                } if(Mouse_evt.getClickCount() == 2){
                    inf_in = (String)visor.getValueAt(visor.getSelectedRow(), 1);
                    Modin mod = new Modin();
                    mod.setVisible(true);
                    mod.Cod.setText(visor.getValueAt(visor.getSelectedRow(), 0).toString()); 
                    mod.Apellido.setText(visor.getValueAt(visor.getSelectedRow(), 2).toString());
                    mod.DNI.setText(visor.getValueAt(visor.getSelectedRow(), 3).toString());
                    mod.Telefono.setText(visor.getValueAt(visor.getSelectedRow(), 4).toString());
                }
            }
        });
    }

    
    public void mostrar(String tabla){
        String sql = "select * from " + tabla;
        Statement st;
        ConexionBD con = new ConexionBD();
        Connection DBConexion = con.getConnection();  
        System.out.println(sql);
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Cod.In");
        model.addColumn("Nombre");
        model.addColumn("Apellido");
        model.addColumn("DNI");
        model.addColumn("Telefono");
        visor.setModel(model);
        
        String [] datos = new String[5];
        try{
            st = DBConexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next())
               {
                   datos[0]=rs.getString(1);
                   datos[1]=rs.getString(2);
                   datos[2]=rs.getString(3);
                   datos[3]=rs.getString(4);
                   datos[4]=rs.getString(5);
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        visor = new javax.swing.JTable();
        btnIngre = new javax.swing.JButton();
        btnEli = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextNo = new javax.swing.JTextField();
        jTextAp = new javax.swing.JTextField();
        jTextDNI = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextTef = new javax.swing.JTextField();
        jTextId_in = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        Text = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Constantia", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Inquilinos");

        visor = new javax.swing.JTable(){
            public boolean isCellEditable(int row, int col){
                return false;
            }
        };
        visor.setBackground(new java.awt.Color(255, 255, 255));
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

        btnIngre.setBackground(new java.awt.Color(0, 0, 0));
        btnIngre.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        btnIngre.setForeground(new java.awt.Color(255, 255, 255));
        btnIngre.setText("Ingresar");
        btnIngre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnIngreMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnIngreMouseExited(evt);
            }
        });
        btnIngre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngreActionPerformed(evt);
            }
        });

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

        jLabel2.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Datos del Inquilino");

        jLabel3.setFont(new java.awt.Font("Constantia", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Apellido:");

        jLabel4.setFont(new java.awt.Font("Constantia", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("DNI:");

        jTextNo.setBackground(new java.awt.Color(255, 255, 255));
        jTextNo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextNo.setForeground(new java.awt.Color(0, 0, 0));
        jTextNo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextNoKeyTyped(evt);
            }
        });

        jTextAp.setBackground(new java.awt.Color(255, 255, 255));
        jTextAp.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextAp.setForeground(new java.awt.Color(0, 0, 0));
        jTextAp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextApKeyTyped(evt);
            }
        });

        jTextDNI.setBackground(new java.awt.Color(255, 255, 255));
        jTextDNI.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextDNI.setForeground(new java.awt.Color(0, 0, 0));
        jTextDNI.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextDNIKeyTyped(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Constantia", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Telefono:");

        jTextTef.setBackground(new java.awt.Color(255, 255, 255));
        jTextTef.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextTef.setForeground(new java.awt.Color(0, 0, 0));
        jTextTef.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextTefKeyTyped(evt);
            }
        });

        jTextId_in.setEditable(false);
        jTextId_in.setBackground(new java.awt.Color(204, 204, 204));
        jTextId_in.setForeground(new java.awt.Color(204, 204, 204));
        jTextId_in.setBorder(null);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imag/arrow_refresh_15732 (2).png"))); // NOI18N
        jButton1.setToolTipText("Actualizar");
        jButton1.setBorder(null);
        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        Text.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Text.setForeground(new java.awt.Color(0, 0, 0));

        jLabel6.setFont(new java.awt.Font("Constantia", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Nombre:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 730, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(6, 6, 6)
                        .addComponent(jTextNo, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(10, 10, 10)
                        .addComponent(jTextAp, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(6, 6, 6)
                        .addComponent(jTextTef, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(190, 190, 190)
                .addComponent(jTextId_in, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(139, 139, 139)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnIngre)
                    .addComponent(btnEli)))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel4)
                .addGap(6, 6, 6)
                .addComponent(jTextDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Text, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(390, 390, 390)
                .addComponent(jButton1))
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 710, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jLabel6))
                            .addComponent(jTextNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jLabel3))
                            .addComponent(jTextAp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jLabel5))
                            .addComponent(jTextTef, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addComponent(jTextId_in, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btnIngre, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(btnEli, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel4))
                    .addComponent(jTextDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(jButton1)
                        .addGap(1, 1, 1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Text, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnIngreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngreActionPerformed
        
        if (a.add_Inq(jTextNo, jTextAp, jTextDNI, jTextTef)) {
            Text.setText("Se registro correctemente");
            mostrar("Inquilino");
            StringsLimpio();
            Timer timer = new Timer(5000, e -> {
                Text.setText("");
                ((Timer) e.getSource()).stop();
            });
            timer.start();
        } else {
            Text.setText("Error al registrar");
            Timer timer = new Timer(5000, e -> {
                Text.setText("");
                ((Timer) e.getSource()).stop();
            });
            timer.start();
        }
       

    }//GEN-LAST:event_btnIngreActionPerformed

    private void jTextDNIKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextDNIKeyTyped
       char validar=evt.getKeyChar();
       
       if(Character.isLetter(validar)){
           getToolkit().beep();
           evt.consume();
           
           alert_int();
       }
    }//GEN-LAST:event_jTextDNIKeyTyped

    private void jTextNoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextNoKeyTyped
        char validar = evt.getKeyChar();

        if (Character.isDigit(validar)) {
            getToolkit().beep();
            evt.consume();

            alert_String();
        }
    }//GEN-LAST:event_jTextNoKeyTyped

    private void jTextApKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextApKeyTyped
        char validar = evt.getKeyChar();

        if (Character.isDigit(validar)) {
            getToolkit().beep();
            evt.consume();

            alert_String();
        }
    }//GEN-LAST:event_jTextApKeyTyped

    private void btnEliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliActionPerformed
        
        if (b.delete_Inq(jTextId_in)) {
            Text.setText("Se elimino correctemente");
            mostrar("Inquilino");
            StringsLimpio();
            Timer timer = new Timer(5000, e -> {
                Text.setText("");
                ((Timer) e.getSource()).stop();
            });
            timer.start();
        } else {
            Text.setText("Error al eliminar");
            Timer timer = new Timer(5000, e -> {
                Text.setText("");
                ((Timer) e.getSource()).stop();
            });
            timer.start();
        }
       
    }//GEN-LAST:event_btnEliActionPerformed

    private void jTextTefKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextTefKeyTyped
        char validar=evt.getKeyChar();
       
       if(Character.isLetter(validar)){
           getToolkit().beep();
           evt.consume();
           
           alert_int();
       }
    }//GEN-LAST:event_jTextTefKeyTyped

    private void btnIngreMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnIngreMouseEntered
        btnIngre.setBackground(Color.BLUE);
    }//GEN-LAST:event_btnIngreMouseEntered

    private void btnIngreMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnIngreMouseExited
        btnIngre.setBackground(new Color(0, 0, 0));
    }//GEN-LAST:event_btnIngreMouseExited

    private void btnEliMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliMouseEntered
        btnEli.setBackground(Color.RED);
    }//GEN-LAST:event_btnEliMouseEntered

    private void btnEliMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliMouseExited
        btnEli.setBackground(new Color(0, 0, 0));
    }//GEN-LAST:event_btnEliMouseExited

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        mostrar("Inquilino");
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Text;
    private javax.swing.JButton btnEli;
    private javax.swing.JButton btnIngre;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextAp;
    private javax.swing.JTextField jTextDNI;
    private javax.swing.JTextField jTextId_in;
    private javax.swing.JTextField jTextNo;
    private javax.swing.JTextField jTextTef;
    private javax.swing.JTable visor;
    // End of variables declaration//GEN-END:variables
}
