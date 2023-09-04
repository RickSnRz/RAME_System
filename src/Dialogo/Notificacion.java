package Dialogo;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;


public class Notificacion extends javax.swing.JDialog {

    public String Nombres = "";
    
    

    public Notificacion(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);

        initComponents();

        JScrollBar sb = scroll.getVerticalScrollBar();
        sb.setOpaque(false);
        sb.setForeground(new Color(33, 140, 206));
        sb.setPreferredSize(new Dimension(8, 8));
        sb.setUI(new ModernScrollBarUI());
        scroll.getViewport().setOpaque(false);
        scroll.setViewportBorder(null);
        this.setLocationRelativeTo(null);
        mostrarNotificaciones();
    }  

    
    private void mostrarNotificaciones() {
    // Configura los detalles de la conexión
    String url = "jdbc:mysql://localhost:3306/Estela";
    String user = "root";
    String password = "989974718@";

    try {
        // Establece la conexión
        Connection conn = DriverManager.getConnection(url, user, password);

        // Realiza la consulta SQL para obtener las últimas 5 personas con estado 'pendiente'
        String query = "SELECT * FROM accion WHERE Estado = 'pendiente' ORDER BY id DESC LIMIT 6";
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        int panelIndex = 0;
        boolean foundNotifications = false; // Variable para saber si se encontraron notificaciones

        // Recorre los paneles del panel principal
        for (Component component : panel.getComponents()) {
            if (component instanceof JPanel) {
                JPanel individualPanel = (JPanel) component;

                // Verifica si el panel individual tiene componentes
                if (individualPanel.getComponentCount() > 0) {
                    Component[] components = individualPanel.getComponents();
                    for (Component innerComponent : components) {
                        if (innerComponent instanceof JLabel) {
                            JLabel label = (JLabel) innerComponent;

                            // Realiza la consulta SQL para obtener los datos de la notificación
                            if (resultSet.next()) {
                                String precio = resultSet.getString("Precio");
                                String nombre = resultSet.getString("accion");
                                // Otros campos que puedas tener en tu tabla...

                                label.setText("<html><div style='width: 210px;'> El inquilino " + nombre + " tiene un pago pendiente de " + precio + " soles.</div></html>");
                                label.putClientProperty("nombre", nombre);
                                // Configura el estilo del label si lo deseas...
                                label.setForeground(Color.BLACK);
                                label.setFont(new Font("Nirmala UI", Font.PLAIN, 12));
                                foundNotifications = true; // Se encontraron notificaciones
                            } else {
                                break; // No hay más notificaciones, salimos del bucle
                            }
                        }
                    }
                }

                panelIndex++;
                if (panelIndex >= 6) {
                    break; // Ya hemos recorrido los primeros 6 paneles, salimos del bucle
                }
            }
        }

        // Si no se encontraron notificaciones, muestra el mensaje en el primer panel individual
        if (!foundNotifications) {
            for (Component component : panel.getComponents()) {
                if (component instanceof JPanel) {
                    JPanel individualPanel = (JPanel) component;
                    if (individualPanel.getComponentCount() > 0) {
                        Component[] components = individualPanel.getComponents();
                        for (Component innerComponent : components) {
                            if (innerComponent instanceof JLabel) {
                                JLabel label = (JLabel) innerComponent;
                                label.setText("<html><div style='text-align: center; width: 200px;'> No hay noticaciones.</div></html>");
                                // Configura el estilo del label si lo deseas...
                                label.setForeground(Color.BLACK);
                                label.setFont(new Font("Nirmala UI", Font.PLAIN, 14));

                                lbVer.setText(" ");

                                for (MouseListener listener : label.getMouseListeners()) {
                                    label.removeMouseListener(listener);
                                }

                                break; // Salimos del bucle una vez encontrado el label
                            }
                        }
                        break; // Salimos del bucle una vez encontrado el primer panel individual
                    }
                }
            }

            for (Component component : panel.getComponents()) {
                if (component instanceof JPanel) {
                    JPanel individualPanel = (JPanel) component;
                    if (individualPanel.getComponentCount() > 0) {
                        Component[] components = individualPanel.getComponents();
                        for (Component innerComponent : components) {
                            if (innerComponent instanceof JLabel) {
                                JLabel label = (JLabel) innerComponent;
                                // Eliminar los listeners de eventos del label (MouseEntered y MouseExited)
                                for (MouseListener listener : label.getMouseListeners()) {
                                    label.removeMouseListener(listener);
                                }
                            }
                        }
                    }
                }
            }
            scroll.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        }

        // Cierra los recursos
        resultSet.close();
        statement.close();
        conn.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PnlPrincipal = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lbVer = new javax.swing.JLabel();
        scroll = new javax.swing.JScrollPane();
        panel = new javax.swing.JPanel();
        P1 = new javax.swing.JPanel();
        L1 = new javax.swing.JLabel();
        P2 = new javax.swing.JPanel();
        L2 = new javax.swing.JLabel();
        P3 = new javax.swing.JPanel();
        L3 = new javax.swing.JLabel();
        P4 = new javax.swing.JPanel();
        L4 = new javax.swing.JLabel();
        P5 = new javax.swing.JPanel();
        L5 = new javax.swing.JLabel();
        P6 = new javax.swing.JPanel();
        L6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        PnlPrincipal.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 102));
        jLabel1.setText("NOTIFICACIONES:");

        lbVer.setForeground(new java.awt.Color(0, 0, 255));
        lbVer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbVer.setText("Ver más");

        scroll.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        panel.setBackground(new java.awt.Color(204, 204, 204));

        P1.setBackground(new java.awt.Color(204, 204, 204));

        L1.setForeground(new java.awt.Color(255, 255, 255));
        L1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                L1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                L1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                L1MouseExited(evt);
            }
        });

        javax.swing.GroupLayout P1Layout = new javax.swing.GroupLayout(P1);
        P1.setLayout(P1Layout);
        P1Layout.setHorizontalGroup(
            P1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(P1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(L1, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
                .addContainerGap())
        );
        P1Layout.setVerticalGroup(
            P1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, P1Layout.createSequentialGroup()
                .addGap(0, 2, Short.MAX_VALUE)
                .addComponent(L1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        P2.setBackground(new java.awt.Color(204, 204, 204));

        L2.setForeground(new java.awt.Color(255, 255, 255));
        L2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                L2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                L2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                L2MouseExited(evt);
            }
        });

        javax.swing.GroupLayout P2Layout = new javax.swing.GroupLayout(P2);
        P2.setLayout(P2Layout);
        P2Layout.setHorizontalGroup(
            P2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(P2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(L2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        P2Layout.setVerticalGroup(
            P2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, P2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(L2, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        P3.setBackground(new java.awt.Color(204, 204, 204));

        L3.setForeground(new java.awt.Color(255, 255, 255));
        L3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                L3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                L3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                L3MouseExited(evt);
            }
        });

        javax.swing.GroupLayout P3Layout = new javax.swing.GroupLayout(P3);
        P3.setLayout(P3Layout);
        P3Layout.setHorizontalGroup(
            P3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(P3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(L3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        P3Layout.setVerticalGroup(
            P3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, P3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(L3, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        P4.setBackground(new java.awt.Color(204, 204, 204));

        L4.setForeground(new java.awt.Color(255, 255, 255));
        L4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                L4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                L4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                L4MouseExited(evt);
            }
        });

        javax.swing.GroupLayout P4Layout = new javax.swing.GroupLayout(P4);
        P4.setLayout(P4Layout);
        P4Layout.setHorizontalGroup(
            P4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(P4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(L4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        P4Layout.setVerticalGroup(
            P4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, P4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(L4, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        P5.setBackground(new java.awt.Color(204, 204, 204));

        L5.setForeground(new java.awt.Color(255, 255, 255));
        L5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                L5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                L5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                L5MouseExited(evt);
            }
        });

        javax.swing.GroupLayout P5Layout = new javax.swing.GroupLayout(P5);
        P5.setLayout(P5Layout);
        P5Layout.setHorizontalGroup(
            P5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(P5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(L5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        P5Layout.setVerticalGroup(
            P5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, P5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(L5, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        P6.setBackground(new java.awt.Color(204, 204, 204));

        L6.setForeground(new java.awt.Color(255, 255, 255));
        L6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                L6MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                L6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                L6MouseExited(evt);
            }
        });

        javax.swing.GroupLayout P6Layout = new javax.swing.GroupLayout(P6);
        P6.setLayout(P6Layout);
        P6Layout.setHorizontalGroup(
            P6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(P6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(L6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        P6Layout.setVerticalGroup(
            P6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, P6Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(L6, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(P1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(P2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(P3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(P4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(P5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(P6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(P1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(P2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(P3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(P4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(P5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(8, 8, 8)
                .addComponent(P6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        scroll.setViewportView(panel);

        javax.swing.GroupLayout PnlPrincipalLayout = new javax.swing.GroupLayout(PnlPrincipal);
        PnlPrincipal.setLayout(PnlPrincipalLayout);
        PnlPrincipalLayout.setHorizontalGroup(
            PnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbVer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(PnlPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PnlPrincipalLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 140, Short.MAX_VALUE))
                    .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        PnlPrincipalLayout.setVerticalGroup(
            PnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlPrincipalLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbVer)
                .addGap(8, 8, 8))
        );

        scroll.setBorder(null);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PnlPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PnlPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void L1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_L1MouseEntered
        P1.setBackground(new Color(204,255,255));
    }//GEN-LAST:event_L1MouseEntered

    private void L1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_L1MouseExited
        P1.setBackground(new Color(204, 204, 204));
    }//GEN-LAST:event_L1MouseExited

    private void L2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_L2MouseEntered
        P2.setBackground(new Color(204,255,255));
    }//GEN-LAST:event_L2MouseEntered

    private void L2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_L2MouseExited
        P2.setBackground(new Color(204, 204, 204));
    }//GEN-LAST:event_L2MouseExited

    private void L3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_L3MouseEntered
        P3.setBackground(new Color(204,255,255));
    }//GEN-LAST:event_L3MouseEntered

    private void L3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_L3MouseExited
        P3.setBackground(new Color(204, 204, 204));
    }//GEN-LAST:event_L3MouseExited

    private void L4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_L4MouseEntered
        P4.setBackground(new Color(204,255,255));
    }//GEN-LAST:event_L4MouseEntered

    private void L4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_L4MouseExited
        P4.setBackground(new Color(204, 204, 204));
    }//GEN-LAST:event_L4MouseExited

    private void L5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_L5MouseEntered
        P5.setBackground(new Color(204,255,255));
    }//GEN-LAST:event_L5MouseEntered

    private void L5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_L5MouseExited
        P5.setBackground(new Color(204, 204, 204));
    }//GEN-LAST:event_L5MouseExited

    private void L6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_L6MouseEntered
        P6.setBackground(new Color(204,255,255));
    }//GEN-LAST:event_L6MouseEntered

    private void L6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_L6MouseExited
        P6.setBackground(new Color(204, 204, 204));
    }//GEN-LAST:event_L6MouseExited

    private void L1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_L1MouseClicked
        JLabel clickedLabel = (JLabel) evt.getSource();
        String nombre = (String) clickedLabel.getClientProperty("nombre"); // Recupera el nombre almacenado en la propiedad de cliente

        // Ahora, puedes asignar el nombre a la variable 'Nombres' y hacer lo que necesites con ella
        Nombres = nombre;
        // Por ejemplo, puedes imprimirlo en la consola o usarlo en otra parte del código.
        System.out.println("Nombre del inquilino 1 seleccionado: " + Nombres);
        
        Estadistica est = new Estadistica(null, false);
        est.Inq.setText(Nombres);
        est.mostrar("accion", Nombres);
        est.DNIS(Nombres);
        est.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_L1MouseClicked

    private void L2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_L2MouseClicked
        JLabel clickedLabel = (JLabel) evt.getSource();
        String nombre = (String) clickedLabel.getClientProperty("nombre"); // Recupera el nombre almacenado en la propiedad de cliente

        // Ahora, puedes asignar el nombre a la variable 'Nombres' y hacer lo que necesites con ella
        Nombres = nombre;
        // Por ejemplo, puedes imprimirlo en la consola o usarlo en otra parte del código.
        System.out.println("Nombre del inquilino 2 seleccionado: " + Nombres);
        
        Estadistica est = new Estadistica(null, false);
        est.Inq.setText(Nombres);
        est.mostrar("accion", Nombres);
        est.DNIS(Nombres);
        est.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_L2MouseClicked

    private void L3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_L3MouseClicked
        JLabel clickedLabel = (JLabel) evt.getSource();
        String nombre = (String) clickedLabel.getClientProperty("nombre"); // Recupera el nombre almacenado en la propiedad de cliente

        // Ahora, puedes asignar el nombre a la variable 'Nombres' y hacer lo que necesites con ella
        Nombres = nombre;
        // Por ejemplo, puedes imprimirlo en la consola o usarlo en otra parte del código.
        System.out.println("Nombre del inquilino 3 seleccionado: " + Nombres);
        
        Estadistica est = new Estadistica(null, false);
        est.Inq.setText(Nombres);
        est.mostrar("accion", Nombres);
        est.DNIS(Nombres);
        est.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_L3MouseClicked

    private void L4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_L4MouseClicked
        JLabel clickedLabel = (JLabel) evt.getSource();
        String nombre = (String) clickedLabel.getClientProperty("nombre"); // Recupera el nombre almacenado en la propiedad de cliente

        // Ahora, puedes asignar el nombre a la variable 'Nombres' y hacer lo que necesites con ella
        Nombres = nombre;
        // Por ejemplo, puedes imprimirlo en la consola o usarlo en otra parte del código.
        System.out.println("Nombre del inquilino 4 seleccionado: " + Nombres);
        
        Estadistica est = new Estadistica(null, false);
        est.Inq.setText(Nombres);
        est.mostrar("accion", Nombres);
        est.DNIS(Nombres);
        est.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_L4MouseClicked

    private void L5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_L5MouseClicked
        JLabel clickedLabel = (JLabel) evt.getSource();
        String nombre = (String) clickedLabel.getClientProperty("nombre"); // Recupera el nombre almacenado en la propiedad de cliente

        // Ahora, puedes asignar el nombre a la variable 'Nombres' y hacer lo que necesites con ella
        Nombres = nombre;
        // Por ejemplo, puedes imprimirlo en la consola o usarlo en otra parte del código.
        System.out.println("Nombre del inquilino 5 seleccionado: " + Nombres);
        
        Estadistica est = new Estadistica(null, false);
        est.Inq.setText(Nombres);
        est.mostrar("accion", Nombres);
        est.DNIS(Nombres);
        est.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_L5MouseClicked

    private void L6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_L6MouseClicked
        JLabel clickedLabel = (JLabel) evt.getSource();
        String nombre = (String) clickedLabel.getClientProperty("nombre"); // Recupera el nombre almacenado en la propiedad de cliente

        // Ahora, puedes asignar el nombre a la variable 'Nombres' y hacer lo que necesites con ella
        Nombres = nombre;
        // Por ejemplo, puedes imprimirlo en la consola o usarlo en otra parte del código.
        System.out.println("Nombre del inquilino 6 seleccionado: " + Nombres);
        
        Estadistica est = new Estadistica(null, false);
        est.Inq.setText(Nombres);
        est.mostrar("accion", Nombres);
        est.DNIS(Nombres);
        est.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_L6MouseClicked

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
            java.util.logging.Logger.getLogger(Notificacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Notificacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Notificacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Notificacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Notificacion dialog = new Notificacion(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel L1;
    private javax.swing.JLabel L2;
    private javax.swing.JLabel L3;
    private javax.swing.JLabel L4;
    private javax.swing.JLabel L5;
    private javax.swing.JLabel L6;
    private javax.swing.JPanel P1;
    private javax.swing.JPanel P2;
    private javax.swing.JPanel P3;
    private javax.swing.JPanel P4;
    private javax.swing.JPanel P5;
    private javax.swing.JPanel P6;
    private javax.swing.JPanel PnlPrincipal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lbVer;
    private javax.swing.JPanel panel;
    private javax.swing.JScrollPane scroll;
    // End of variables declaration//GEN-END:variables

}
