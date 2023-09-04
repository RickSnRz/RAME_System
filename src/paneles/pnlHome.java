package paneles;

import DataBase.ConexionBD;
import Dialogo.Notificacion;
import Visual.Login;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Locale;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.Point;

public class pnlHome extends javax.swing.JPanel {

     private Notificacion dialogo;
     private boolean Notis=false;
     private Connection conn;
    
    Calendar calendar = Calendar.getInstance();
    int month = calendar.get(Calendar.MONTH);
    String monthName = calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault());
    int year = calendar.get(Calendar.YEAR);
 
    String dateTime = DateTimeFormatter.ofPattern("MMM dd yyyy, hh:mm:ss a")
                    .format(LocalDateTime.now());
    
    public pnlHome() {
        initComponents();
        TextHora.setText("Hora de Ingreso: " + dateTime);
        TextBienvenida.setText("Bienvenido " + Login.texto);
        ConexionBD con = new ConexionBD();
        conn = con.getConnection();
        Balance();
        Total();
        setIcon(new Color(255,255,102));
        con.closeConnection();
    }
    
    private void setIcon(Color bgColor){
        ImageIcon icon = new ImageIcon(getClass().getResource("/Imag/noti.png"));
        ImageIcon ico = changeIconColor(icon, bgColor);
        lbNotifi.setIcon(ico);
        repaint();
    }

    private void Balance() {
    try {
        double balance = getBalance(conn, monthName, year);

        fondo.setText("S/" + balance);
        fondo.setForeground(new Color(255, 153, 51));
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
    
    private void Total() {
    try {
        double total = getTotal(conn, year);

        fondo1.setText("S/" + total);
        fondo1.setForeground(new Color(255, 153, 51));
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
  
    private double getBalance(Connection conn, String monthName, int year) throws SQLException {
    double balance = 0.0;
    Statement stmt = null;
    ResultSet rs = null;

    try {
        stmt = conn.createStatement();
        String query = "SELECT COALESCE(SUM(Precio), 0) AS total FROM accion WHERE Estado = 'pagado' AND Mes = '" + monthName + " " + year + "'";
        rs = stmt.executeQuery(query);

        if (rs.next()) {
            balance = rs.getDouble("total");
        }
    } finally {
        // Cerrar los recursos utilizados (no cerramos la conexión aquí)
        try {
            if (rs != null)
                rs.close();
            if (stmt != null)
                stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    return balance;
}
    
    
    private double getTotal(Connection conn, int year) throws SQLException {
    double total = 0.0;
    Statement stmt = null;
    ResultSet rs = null;

    try {
        stmt = conn.createStatement();
        String query = "SELECT COALESCE(SUM(Precio), 0) AS total FROM accion WHERE Estado = 'pagado' AND Mes LIKE '%" + year + "%'";
        rs = stmt.executeQuery(query);

        if (rs.next()) {
            total = rs.getDouble("total");
        }
    } finally {
        // Cerrar los recursos utilizados (no cerramos la conexión aquí)
        try {
            if (rs != null)
                rs.close();
            if (stmt != null)
                stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    return total;
}
    
    private void mostrarNotificacion() {
        // Si el JDialog está abierto, lo cerramos
        if (dialogo != null && dialogo.isVisible()) {
            dialogo.dispose(); // Cierra el JDialog
            dialogo = null; // Reinicializa la variable
        } else { // Si el JDialog está cerrado, lo abrimos justo debajo del botón
            // Obtener la posición del JLabel lbNotifi en la pantalla
            Point labelLocation = lbNotifi.getLocationOnScreen();

            // Calcular la posición Y del diálogo debajo del JLabel con un desplazamiento
            int y = labelLocation.y + lbNotifi.getHeight() + 10; // Puedes ajustar el valor del desplazamiento según tus necesidades

            dialogo = new Notificacion(null, false); // Pasamos null como primer argumento y false como segundo argumento
            dialogo.setLocation(labelLocation.x, y);
            dialogo.setVisible(true);
        }
    }

    private ImageIcon changeIconColor(ImageIcon icon, Color newColor) {
        // Obtener la imagen del icono original
        Image image = icon.getImage();

        // Crear una imagen en blanco con el mismo tamaño que el icono
        BufferedImage bufferedImage = new BufferedImage(
                image.getWidth(null),
                image.getHeight(null),
                BufferedImage.TYPE_INT_ARGB
        );

        // Obtener el contexto gráfico de la imagen en blanco
        Graphics2D graphics = bufferedImage.createGraphics();

        // Dibujar la imagen del icono en la imagen en blanco
        graphics.drawImage(image, 0, 0, null);

        // Cambiar el color de los píxeles de la imagen en blanco al nuevo color
        graphics.setColor(newColor);
        graphics.setComposite(AlphaComposite.SrcAtop);
        graphics.fillRect(0, 0, bufferedImage.getWidth(), bufferedImage.getHeight());

        // Crear un nuevo icono con la imagen modificada
        ImageIcon newIcon = new ImageIcon(bufferedImage);

        // Devolver el nuevo icono
        return newIcon;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TextBienvenida = new javax.swing.JLabel();
        TextHora = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new RoundedPanel(50, new Color(0, 51, 51));
        jLabel2 = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();
        jPanel2 = new RoundedPanel(50, new Color(0, 51, 51));
        jLabel3 = new javax.swing.JLabel();
        fondo1 = new javax.swing.JLabel();
        pnlNotifis = new RoundedPanel(100, new Color(0, 51, 51));
        lbNotifi = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 204, 204));
        setPreferredSize(new java.awt.Dimension(732, 512));

        TextBienvenida.setFont(new java.awt.Font("Constantia", 1, 48)); // NOI18N
        TextBienvenida.setForeground(new java.awt.Color(0, 0, 0));
        TextBienvenida.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        TextHora.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        TextHora.setForeground(new java.awt.Color(0, 0, 0));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imag/LogoTranss.png"))); // NOI18N

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 102));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Total del Mes:");

        fondo.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        fondo.setForeground(new java.awt.Color(255, 255, 255));
        fondo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fondo, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fondo, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 102));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Total del Año:");

        fondo1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        fondo1.setForeground(new java.awt.Color(255, 255, 255));
        fondo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fondo1, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(11, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fondo1, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlNotifis.setBackground(new java.awt.Color(204, 204, 204));

        lbNotifi.setForeground(new java.awt.Color(255, 255, 255));
        lbNotifi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imag/noti.png"))); // NOI18N
        lbNotifi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbNotifi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbNotifiMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlNotifisLayout = new javax.swing.GroupLayout(pnlNotifis);
        pnlNotifis.setLayout(pnlNotifisLayout);
        pnlNotifisLayout.setHorizontalGroup(
            pnlNotifisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlNotifisLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbNotifi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlNotifisLayout.setVerticalGroup(
            pnlNotifisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlNotifisLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbNotifi)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TextBienvenida, javax.swing.GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlNotifis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(TextHora, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TextBienvenida, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(TextHora, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(jLabel1))
                    .addComponent(pnlNotifis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void lbNotifiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbNotifiMouseClicked

        mostrarNotificacion();


        if (Notis == false) {
            setIcon(Color.WHITE);

            Notis = true;
        } else {
            setIcon(new Color(255,255,102));
            
            Notis = false;
        }

    }//GEN-LAST:event_lbNotifiMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel TextBienvenida;
    private javax.swing.JLabel TextHora;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel fondo1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbNotifi;
    private javax.swing.JPanel pnlNotifis;
    // End of variables declaration//GEN-END:variables


    class RoundedPanel extends JPanel
    {
        private Color backgroundColor;
        private int cornerRadius = 15;
        public RoundedPanel(LayoutManager layout, int radius) {
            super(layout);
            cornerRadius = radius;
        }
        public RoundedPanel(LayoutManager layout, int radius, Color bgColor) {
            super(layout);
            cornerRadius = radius;
            backgroundColor = bgColor;
        }
        public RoundedPanel(int radius) {
            super();
            cornerRadius = radius;
            
        }
        public RoundedPanel(int radius, Color bgColor) {
            super();
            cornerRadius = radius;
            backgroundColor = bgColor;
        }

        public void setBackgroundColor(Color bgColor) {
            backgroundColor = bgColor;
            repaint(); // Vuelve a pintar el componente con el nuevo color de fondo
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Dimension arcs = new Dimension(cornerRadius, cornerRadius);
            int width = getWidth();
            int height = getHeight();
            Graphics2D graphics = (Graphics2D) g;
            graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            //Draws the rounded panel with borders.
            if (backgroundColor != null) {
                graphics.setColor(backgroundColor);
            } else {
                graphics.setColor(getBackground());
            }
            graphics.fillRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height); //paint background
            graphics.setColor(getForeground());
//            graphics.drawRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height); //paint border
//             
        }
        
    }
    
}
