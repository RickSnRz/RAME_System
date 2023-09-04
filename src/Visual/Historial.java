package Visual;

import Class.Report_Historial;
import DataBase.ConexionBD;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import org.apache.log4j.PropertyConfigurator;


public class Historial extends javax.swing.JFrame {

    private void TablaLimpia(){
        visor.getColumnModel().getColumn(0).setResizable(false);
        visor.getColumnModel().getColumn(1).setResizable(false);
        visor.getColumnModel().getColumn(2).setResizable(false);
        visor.getColumnModel().getColumn(3).setResizable(false);
        visor.getColumnModel().getColumn(4).setResizable(false);
        visor.getColumnModel().getColumn(5).setResizable(false);
        visor.getColumnModel().getColumn(5).setResizable(false);
        visor.getColumnModel().getColumn(6).setResizable(false);
        visor.getColumnModel().getColumn(8).setResizable(false);
        visor.getColumnModel().getColumn(9).setResizable(false);
        visor.getColumnModel().getColumn(10).setResizable(false);
        visor.getColumnModel().getColumn(11).setResizable(false);
        visor.getColumnModel().getColumn(12).setResizable(false);
        visor.getColumnModel().getColumn(13).setResizable(false);
        visor.getColumnModel().getColumn(0).setPreferredWidth(40);
        visor.getColumnModel().getColumn(1).setPreferredWidth(70);
        visor.getColumnModel().getColumn(2).setPreferredWidth(35);
        visor.getColumnModel().getColumn(3).setPreferredWidth(50);
        visor.getColumnModel().getColumn(6).setPreferredWidth(40);
        visor.getColumnModel().getColumn(7).setPreferredWidth(20);
        visor.getColumnModel().getColumn(8).setPreferredWidth(15);
        visor.getColumnModel().getColumn(9).setPreferredWidth(55);
        visor.getColumnModel().getColumn(10).setPreferredWidth(45);
        visor.getColumnModel().getColumn(11).setPreferredWidth(65);
        visor.getColumnModel().getColumn(12).setPreferredWidth(100);
        visor.getColumnModel().getColumn(13).setPreferredWidth(30);
        visor.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        visor.getTableHeader().setOpaque(false);
        visor.getTableHeader().setBackground(new Color(0, 51, 51));
        visor.getTableHeader().setForeground(Color.WHITE);
        visor.setRowHeight(25);
    }
    
    int xMouse, yMouse;
    public static String Text = "";
    
     public Historial() {
        initComponents();
        this.setTitle("Historial de Alquileres");
        this.setLocationRelativeTo(null);
        mostrar("Alquiler");
        TablaLimpia();
        setIconImage(getIconImage());
        
    }

    @Override
    public Image getIconImage() {

        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Imag/LogoTranss.png"));
        return retValue;
    }


    private void mostrar(String tabla){
        String sql = "select Id_Al, Nombre_In, DNI, Nombre_Arre, RUC, NombreServ, PrecioServ, N_Cuarto, N_Piso, Precio_Cuart, Precio_Total, Fecha_Entrada, Fecha_Salida, Estado from " + tabla;
        Statement st;
        ConexionBD con = new ConexionBD();
        Connection DBConexion = con.getConnection();  
        System.out.println(sql);
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Cod.Alquiler");
        model.addColumn("Inquilino");
        model.addColumn("DNI");
        model.addColumn("Dueño");
        model.addColumn("RUC");
        model.addColumn("Servicios");
        model.addColumn("Precio_Serv");
        model.addColumn("N°Cuarto");
        model.addColumn("N°Piso");
        model.addColumn("Precio_Cuarto");
        model.addColumn("Precio_Total");
        model.addColumn("Fecha_Entrada");
        model.addColumn("Fecha_Salida");
        model.addColumn("Estado");
        visor.setModel(model);
        
        String [] datos = new String[14];
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
                   datos[5]=rs.getString(6);
                   datos[6]=rs.getString(7);
                   datos[7]=rs.getString(8);
                   datos[8]=rs.getString(9);
                   datos[9]=rs.getString(10);
                   datos[10]=rs.getString(11);
                   datos[11]=rs.getString(12);
                   datos[12]=rs.getString(13);
                   datos[13]=rs.getString(14);
                   model.addRow(datos);
               } 
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "ERROR" + e.toString());
            
        }
    }
    
    public void mostrar2(String Estado){
        String sql = "select Id_Al, Nombre_In, DNI, Nombre_Arre, RUC, NombreServ, PrecioServ, N_Cuarto, N_Piso, Precio_Cuart, Precio_Total, Fecha_Entrada, Fecha_Salida, Estado from Alquiler where Estado = '" + Estado + "'";
        Statement st;
        ConexionBD con = new ConexionBD();
        Connection DBConexion = con.getConnection();  
        System.out.println(sql);
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Cod.Alquiler");
        model.addColumn("Inquilino");
        model.addColumn("DNI");
        model.addColumn("Dueño");
        model.addColumn("RUC");
        model.addColumn("Servicios");
        model.addColumn("Precio_Serv");
        model.addColumn("N°Cuarto");
        model.addColumn("N°Piso");
        model.addColumn("Precio_Cuarto");
        model.addColumn("Precio_Total");
        model.addColumn("Fecha_Entrada");
        model.addColumn("Fecha_Salida");
        model.addColumn("Estado");
        visor.setModel(model);
        
        String [] datos = new String[14];
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
                   datos[5]=rs.getString(6);
                   datos[6]=rs.getString(7);
                   datos[7]=rs.getString(8);
                   datos[8]=rs.getString(9);
                   datos[9]=rs.getString(10);
                   datos[10]=rs.getString(11);
                   datos[11]=rs.getString(12);
                   datos[12]=rs.getString(13);
                   datos[13]=rs.getString(14);
                   model.addRow(datos);
               } 
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "ERROR" + e.toString());
            
        }
    }
      
    public void mostrar3(JTextField Nombre){
        String sql = "select Id_Al, Nombre_In, DNI, Nombre_Arre, RUC, NombreServ, PrecioServ, N_Cuarto, N_Piso, Precio_Cuart, Precio_Total, Fecha_Entrada, Fecha_Salida, Estado from Alquiler where Nombre_In like " + "'%" + Nombre.getText() + "%';";
        Statement st;
        ConexionBD con = new ConexionBD();
        Connection DBConexion = con.getConnection();  
        System.out.println(sql);
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Cod.Alquiler");
        model.addColumn("Inquilino");
        model.addColumn("DNI");
        model.addColumn("Dueño");
        model.addColumn("RUC");
        model.addColumn("Servicios");
        model.addColumn("Precio_Serv");
        model.addColumn("N°Cuarto");
        model.addColumn("N°Piso");
        model.addColumn("Precio_Cuarto");
        model.addColumn("Precio_Total");
        model.addColumn("Fecha_Entrada");
        model.addColumn("Fecha_Salida");
        model.addColumn("Estado");
        visor.setModel(model);
        
        String [] datos = new String[14];
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
                   datos[5]=rs.getString(6);
                   datos[6]=rs.getString(7);
                   datos[7]=rs.getString(8);
                   datos[8]=rs.getString(9);
                   datos[9]=rs.getString(10);
                   datos[10]=rs.getString(11);
                   datos[11]=rs.getString(12);
                   datos[12]=rs.getString(13);
                   datos[13]=rs.getString(14);
                   model.addRow(datos);
               } 
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "ERROR" + e.toString());
            
        }
    }
    
    
    public void gif() {
        ImageIcon check_gif = new ImageIcon("src/Imag/carga.gif");
        ImageIcon resizedIcon = new ImageIcon(check_gif.getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT));
        JOptionPane optionPane = new JOptionPane("Entrado a vista previa.", JOptionPane.PLAIN_MESSAGE, JOptionPane.DEFAULT_OPTION, resizedIcon, new Object[]{}, null);
        JDialog dialog = optionPane.createDialog("Information");
        ImageIcon customIcon = new ImageIcon("src/Imag/LogoTranss.png");
        Image image = customIcon.getImage();
        dialog.setIconImage(image);
        dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        dialog.setVisible(true);
        
    }
    
    public void gif_check() {
        Text = jTextNombre.getText();
        ImageIcon check_gif = new ImageIcon("src/Imag/check.gif");
        ImageIcon resizedIcon = new ImageIcon(check_gif.getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT));
        JOptionPane optionPane = new JOptionPane("Se encontro historial de " + Text + ".", JOptionPane.PLAIN_MESSAGE, JOptionPane.DEFAULT_OPTION, resizedIcon, new Object[]{}, null);
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

        Body = new javax.swing.JPanel();
        Header = new javax.swing.JPanel();
        pnlCerrar = new javax.swing.JPanel();
        Cerrar = new javax.swing.JLabel();
        pnlCerrar1 = new javax.swing.JPanel();
        btnPdf = new javax.swing.JButton();
        pnlCerrar2 = new javax.swing.JPanel();
        Cerrar1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        visor = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextNombre = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnActivo = new javax.swing.JButton();
        btnInactivo = new javax.swing.JButton();
        btnRefrescar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setUndecorated(true);
        setResizable(false);

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
            .addGroup(pnlCerrarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Cerrar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlCerrarLayout.setVerticalGroup(
            pnlCerrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCerrarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Cerrar, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlCerrar1.setBackground(new java.awt.Color(0, 51, 51));

        btnPdf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imag/Oficina_PDF_35460 (1).png"))); // NOI18N
        btnPdf.setToolTipText("Visualizar PDF");
        btnPdf.setBorder(null);
        btnPdf.setContentAreaFilled(false);
        btnPdf.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnPdf.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnPdfMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnPdfMouseExited(evt);
            }
        });
        btnPdf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPdfActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlCerrar1Layout = new javax.swing.GroupLayout(pnlCerrar1);
        pnlCerrar1.setLayout(pnlCerrar1Layout);
        pnlCerrar1Layout.setHorizontalGroup(
            pnlCerrar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCerrar1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnPdf, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE))
        );
        pnlCerrar1Layout.setVerticalGroup(
            pnlCerrar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCerrar1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnPdf, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlCerrar2.setBackground(new java.awt.Color(0, 51, 51));

        Cerrar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imag/min.png"))); // NOI18N
        Cerrar1.setToolTipText("Minimizar");
        Cerrar1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Cerrar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Cerrar1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Cerrar1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Cerrar1MouseExited(evt);
            }
        });

        javax.swing.GroupLayout pnlCerrar2Layout = new javax.swing.GroupLayout(pnlCerrar2);
        pnlCerrar2.setLayout(pnlCerrar2Layout);
        pnlCerrar2Layout.setHorizontalGroup(
            pnlCerrar2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCerrar2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Cerrar1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlCerrar2Layout.setVerticalGroup(
            pnlCerrar2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCerrar2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Cerrar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout HeaderLayout = new javax.swing.GroupLayout(Header);
        Header.setLayout(HeaderLayout);
        HeaderLayout.setHorizontalGroup(
            HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HeaderLayout.createSequentialGroup()
                .addComponent(pnlCerrar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnlCerrar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        HeaderLayout.setVerticalGroup(
            HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlCerrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlCerrar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlCerrar2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("HISTORIAL DE ALQUILERES DETALLADOS");

        visor = new javax.swing.JTable(){
            public boolean isCellEditable(int row, int col){
                return false;
            }
        };
        visor.setBackground(new java.awt.Color(255, 255, 255));
        visor.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        visor.setForeground(new java.awt.Color(0, 0, 0));
        visor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Cod.Alquiler", "Inquilino", "DNI", "Dueño", "RUC", "Servicios", "Precio_Serv", "N°Cuarto", "N°Piso", "Precio_Cuarto", "Precio_Total", "Fecha_Entrada", "Fecha_Salida", "Estado"
            }
        ));
        visor.setFocusable(false);
        visor.setIntercellSpacing(new java.awt.Dimension(0, 0));
        visor.setRowHeight(25);
        visor.setSelectionBackground(new java.awt.Color(0, 0, 51));
        visor.setSelectionForeground(new java.awt.Color(255, 255, 255));
        visor.setShowVerticalLines(false);
        visor.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(visor);

        jLabel2.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Buscar por Nombre de Inquilino:");

        jLabel3.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Busca rapida:");

        jTextNombre.setBackground(new java.awt.Color(255, 255, 255));
        jTextNombre.setForeground(new java.awt.Color(0, 0, 0));

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imag/find_search_card_user_16713.png"))); // NOI18N
        btnBuscar.setToolTipText("Buscar");
        btnBuscar.setBorder(null);
        btnBuscar.setContentAreaFilled(false);
        btnBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnActivo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imag/1486504361-check-interface-ui-mark-ok-user-web_81311.png"))); // NOI18N
        btnActivo.setToolTipText("Inquilinos Activos");
        btnActivo.setBorder(null);
        btnActivo.setContentAreaFilled(false);
        btnActivo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnActivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActivoActionPerformed(evt);
            }
        });

        btnInactivo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imag/1486504346-cancel-close-delete-exit-remove-x_81304.png"))); // NOI18N
        btnInactivo.setToolTipText("Inquilinos Inactivos");
        btnInactivo.setBorder(null);
        btnInactivo.setContentAreaFilled(false);
        btnInactivo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnInactivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInactivoActionPerformed(evt);
            }
        });

        btnRefrescar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imag/arrow_refresh_15732 (2).png"))); // NOI18N
        btnRefrescar.setToolTipText("Refrescar");
        btnRefrescar.setBorder(null);
        btnRefrescar.setContentAreaFilled(false);
        btnRefrescar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnRefrescar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefrescarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout BodyLayout = new javax.swing.GroupLayout(Body);
        Body.setLayout(BodyLayout);
        BodyLayout.setHorizontalGroup(
            BodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1362, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(BodyLayout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jTextNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(BodyLayout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnActivo)
                .addGap(12, 12, 12)
                .addComponent(btnInactivo)
                .addGap(952, 952, 952)
                .addComponent(btnRefrescar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(BodyLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1350, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        BodyLayout.setVerticalGroup(
            BodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BodyLayout.createSequentialGroup()
                .addComponent(Header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addGroup(BodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BodyLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(BodyLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jTextNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(BodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BodyLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(BodyLayout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(btnActivo))
                    .addGroup(BodyLayout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(btnInactivo))
                    .addComponent(btnRefrescar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Body, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Body, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void btnPdfMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPdfMouseEntered
       pnlCerrar1.setBackground(Color.BLUE);
    }//GEN-LAST:event_btnPdfMouseEntered

    private void btnPdfMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPdfMouseExited
       pnlCerrar1.setBackground(new Color(0,51,51));
    }//GEN-LAST:event_btnPdfMouseExited

    private void btnActivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActivoActionPerformed
        mostrar2("Activo");
        TablaLimpia();
    }//GEN-LAST:event_btnActivoActionPerformed

    private void btnInactivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInactivoActionPerformed
        mostrar2("Inactivo");
        TablaLimpia();
    }//GEN-LAST:event_btnInactivoActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed

        if (jTextNombre.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Espacio vacio escribir el nombre del inquilino a buscar.");
            mostrar("Alquiler");
            TablaLimpia();
        } else {
            gif_check();
            mostrar3(jTextNombre);
            TablaLimpia();
            jTextNombre.setText(null);
        }


    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnRefrescarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefrescarActionPerformed
        mostrar("Alquiler");
        TablaLimpia();
    }//GEN-LAST:event_btnRefrescarActionPerformed

    private void HeaderMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HeaderMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_HeaderMousePressed

    private void HeaderMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HeaderMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_HeaderMouseDragged

    private void btnPdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPdfActionPerformed
        gif();
        PropertyConfigurator.configure("src/model/log4j.properties");
        Report_Historial rep = new Report_Historial();       
    }//GEN-LAST:event_btnPdfActionPerformed

    private void Cerrar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Cerrar1MouseClicked
        this.setExtendedState(ICONIFIED);
    }//GEN-LAST:event_Cerrar1MouseClicked

    private void Cerrar1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Cerrar1MouseEntered
        pnlCerrar2.setBackground(new Color(0,153,153));
    }//GEN-LAST:event_Cerrar1MouseEntered

    private void Cerrar1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Cerrar1MouseExited
        pnlCerrar2.setBackground(new Color(0,51,51));
    }//GEN-LAST:event_Cerrar1MouseExited

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
            java.util.logging.Logger.getLogger(Historial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Historial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Historial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Historial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Historial().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Body;
    private javax.swing.JLabel Cerrar;
    private javax.swing.JLabel Cerrar1;
    private javax.swing.JPanel Header;
    private javax.swing.JButton btnActivo;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnInactivo;
    private javax.swing.JButton btnPdf;
    private javax.swing.JButton btnRefrescar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextNombre;
    private javax.swing.JPanel pnlCerrar;
    private javax.swing.JPanel pnlCerrar1;
    private javax.swing.JPanel pnlCerrar2;
    private javax.swing.JTable visor;
    // End of variables declaration//GEN-END:variables
}
