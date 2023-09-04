
package Tabla;

import DAO.PdfDAO;
import VO.PdfCont;
import VO.PdfDNI;
import VO.PdfVO;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class Tabla_PdfVO {
     PdfDAO dao = null;

    public void visualizar_PdfVO(JTable tabla) {
        tabla.setDefaultRenderer(Object.class, new imgTabla());
        DefaultTableModel dt = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        dt.addColumn("Cod.PDF");
        dt.addColumn("Inquilino");
        dt.addColumn("TipoPDF");
        dt.addColumn("ArchivoPDF");

        ImageIcon icono = null;
        if (get_Image("/Imag/32pdf.png") != null) {
            icono = new ImageIcon(get_Image("/Imag/32pdf.png"));
        }

        dao = new PdfDAO();
        PdfVO vo = new PdfVO();
        ArrayList<PdfVO> list = dao.Listar_PdfVO();

        if (list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                Object fila[] = new Object[4];
                vo = list.get(i);
                fila[0] = vo.getId_Pdf();
                fila[1] = vo.getInquilino();
                fila[2] = vo.getTipoPDF();
                if (vo.getArchivopdf() != null) {
                    fila[3] = new JButton(icono);
                } else {
                    fila[3] = new JButton("Vacio");
                }

                dt.addRow(fila);
            }
            tabla.setModel(dt);
            tabla.setRowHeight(38);
            tabla.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
            tabla.getTableHeader().setOpaque(true);
            tabla.getTableHeader().setBackground(new Color(0,51,51));
            tabla.getTableHeader().setForeground(Color.WHITE);
            tabla.getColumnModel().getColumn(0).setResizable(false);
            tabla.getColumnModel().getColumn(1).setResizable(false);
            tabla.getColumnModel().getColumn(2).setResizable(false);
            tabla.getColumnModel().getColumn(3).setResizable(false);
            tabla.getColumnModel().getColumn(0).setPreferredWidth(20);
            tabla.getColumnModel().getColumn(1).setPreferredWidth(300);
        }
    }
    
    public void visualizar_PdfDNI(JTable tabla) {
        tabla.setDefaultRenderer(Object.class, new imgTabla());
        DefaultTableModel dt = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        dt.addColumn("Cod.DNI");
        dt.addColumn("Inquilino");
        dt.addColumn("N°DNI");
        dt.addColumn("ArchivoPDF");

        ImageIcon icono = null;
        if (get_Image("/Imag/32pdf.png") != null) {
            icono = new ImageIcon(get_Image("/Imag/32pdf.png"));
        }

        dao = new PdfDAO();
        PdfDNI vo = new PdfDNI();
        ArrayList<PdfDNI> list = dao.Listar_DNI();

        if (list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                Object fila[] = new Object[4];
                vo = list.get(i);
                fila[0] = vo.getId_DNI();
                fila[1] = vo.getInquilino();
                fila[2] = vo.getN_DNI();
                if (vo.getArchivopdf() != null) {
                    fila[3] = new JButton(icono);
                } else {
                    fila[3] = new JButton("Vacio");
                }

                dt.addRow(fila);
            }
            tabla.setModel(dt);
            tabla.setRowHeight(38);
            tabla.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
            tabla.getTableHeader().setOpaque(true);
            tabla.getTableHeader().setBackground(new Color(0,51,51));
            tabla.getTableHeader().setForeground(Color.WHITE);
            tabla.getColumnModel().getColumn(0).setResizable(false);
            tabla.getColumnModel().getColumn(1).setResizable(false);
            tabla.getColumnModel().getColumn(2).setResizable(false);
            tabla.getColumnModel().getColumn(3).setResizable(false);
            tabla.getColumnModel().getColumn(0).setPreferredWidth(20);
            tabla.getColumnModel().getColumn(1).setPreferredWidth(300);
        }
    }
    
    public void visualizar_PdfCont(JTable tabla) {
        tabla.setDefaultRenderer(Object.class, new imgTabla());
        DefaultTableModel dt = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        dt.addColumn("N°Contrato");
        dt.addColumn("Inquilino");
        dt.addColumn("Fecha");
        dt.addColumn("ArchivoPDF");

        ImageIcon icono = null;
        if (get_Image("/Imag/32pdf.png") != null) {
            icono = new ImageIcon(get_Image("/Imag/32pdf.png"));
        }

        dao = new PdfDAO();
        PdfCont vo = new PdfCont();
        ArrayList<PdfCont> list = dao.Listar_Cont();

        if (list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                Object fila[] = new Object[4];
                vo = list.get(i);
                fila[0] = vo.getId_Contrato();
                fila[1] = vo.getInquilino();
                fila[2] = vo.getFecha();
                if (vo.getArchivoPDF() != null) {
                    fila[3] = new JButton(icono);
                } else {
                    fila[3] = new JButton("Vacio");
                }

                dt.addRow(fila);
            }
            tabla.setModel(dt);
            tabla.setRowHeight(38);
            tabla.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
            tabla.getTableHeader().setOpaque(true);
            tabla.getTableHeader().setBackground(new Color(0,51,51));
            tabla.getTableHeader().setForeground(Color.WHITE);
            tabla.getColumnModel().getColumn(0).setResizable(false);
            tabla.getColumnModel().getColumn(1).setResizable(false);
            tabla.getColumnModel().getColumn(2).setResizable(false);
            tabla.getColumnModel().getColumn(3).setResizable(false);
            tabla.getColumnModel().getColumn(0).setPreferredWidth(20);
            tabla.getColumnModel().getColumn(1).setPreferredWidth(300);
        }
    }
    
    public void visualizar_PdfVO2(JTable tabla) {
        tabla.setDefaultRenderer(Object.class, new imgTabla());
        DefaultTableModel dt = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        dt.addColumn("Cod.PDF");
        dt.addColumn("Inquilino");
        dt.addColumn("TipoPDF");
        dt.addColumn("ArchivoPDF");

        ImageIcon icono = null;
        if (get_Image("/Imag/32pdf.png") != null) {
            icono = new ImageIcon(get_Image("/Imag/32pdf.png"));
        }

        dao = new PdfDAO();
        PdfVO vo = new PdfVO();
        ArrayList<PdfVO> list = dao.Listar_PdfVO2();

        if (list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                Object fila[] = new Object[4];
                vo = list.get(i);
                fila[0] = vo.getId_Pdf();
                fila[1] = vo.getInquilino();
                fila[2] = vo.getTipoPDF();
                if (vo.getArchivopdf() != null) {
                    fila[3] = new JButton(icono);
                } else {
                    fila[3] = new JButton("Vacio");
                }

                dt.addRow(fila);
            }
            tabla.setModel(dt);
            tabla.setRowHeight(38);
            tabla.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
            tabla.getTableHeader().setOpaque(false);
            tabla.getTableHeader().setBackground(new Color(0,51,51));
            tabla.getTableHeader().setForeground(Color.WHITE);
            tabla.getColumnModel().getColumn(0).setResizable(false);
            tabla.getColumnModel().getColumn(1).setResizable(false);
            tabla.getColumnModel().getColumn(2).setResizable(false);
            tabla.getColumnModel().getColumn(3).setResizable(false);
            tabla.getColumnModel().getColumn(0).setPreferredWidth(20);
            tabla.getColumnModel().getColumn(1).setPreferredWidth(300);
        }
    }
    
    public void visualizar_PdfVO3(JTable tabla) {
        tabla.setDefaultRenderer(Object.class, new imgTabla());
        DefaultTableModel dt = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        dt.addColumn("Cod.PDF");
        dt.addColumn("Inquilino");
        dt.addColumn("TipoPDF");
        dt.addColumn("ArchivoPDF");

        ImageIcon icono = null;
        if (get_Image("/Imag/32pdf.png") != null) {
            icono = new ImageIcon(get_Image("/Imag/32pdf.png"));
        }

        dao = new PdfDAO();
        PdfVO vo = new PdfVO();
        ArrayList<PdfVO> list = dao.Listar_PdfVO3();

        if (list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                Object fila[] = new Object[4];
                vo = list.get(i);
                fila[0] = vo.getId_Pdf();
                fila[1] = vo.getInquilino();
                fila[2] = vo.getTipoPDF();
                if (vo.getArchivopdf() != null) {
                    fila[3] = new JButton(icono);
                } else {
                    fila[3] = new JButton("Vacio");
                }

                dt.addRow(fila);
            }
            tabla.setModel(dt);
            tabla.setRowHeight(38);
            tabla.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
            tabla.getTableHeader().setOpaque(false);
            tabla.getTableHeader().setBackground(new Color(0,51,51));
            tabla.getTableHeader().setForeground(Color.WHITE);
            tabla.getColumnModel().getColumn(0).setResizable(false);
            tabla.getColumnModel().getColumn(1).setResizable(false);
            tabla.getColumnModel().getColumn(2).setResizable(false);
            tabla.getColumnModel().getColumn(3).setResizable(false);
            tabla.getColumnModel().getColumn(0).setPreferredWidth(20);
            tabla.getColumnModel().getColumn(1).setPreferredWidth(300);
        }
    }
    
    public void visualizar_PdfVO4(JTable tabla) {
        tabla.setDefaultRenderer(Object.class, new imgTabla());
        DefaultTableModel dt = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        dt.addColumn("Cod.PDF");
        dt.addColumn("Inquilino");
        dt.addColumn("TipoPDF");
        dt.addColumn("ArchivoPDF");

        ImageIcon icono = null;
        if (get_Image("/Imag/32pdf.png") != null) {
            icono = new ImageIcon(get_Image("/Imag/32pdf.png"));
        }

        dao = new PdfDAO();
        PdfVO vo = new PdfVO();
        ArrayList<PdfVO> list = dao.Listar_PdfVO4();

        if (list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                Object fila[] = new Object[4];
                vo = list.get(i);
                fila[0] = vo.getId_Pdf();
                fila[1] = vo.getInquilino();
                fila[2] = vo.getTipoPDF();
                if (vo.getArchivopdf() != null) {
                    fila[3] = new JButton(icono);
                } else {
                    fila[3] = new JButton("Vacio");
                }

                dt.addRow(fila);
            }
            tabla.setModel(dt);
            tabla.setRowHeight(38);
            tabla.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
            tabla.getTableHeader().setOpaque(false);
            tabla.getTableHeader().setBackground(new Color(0,51,51));
            tabla.getTableHeader().setForeground(Color.WHITE);
            tabla.getColumnModel().getColumn(0).setResizable(false);
            tabla.getColumnModel().getColumn(1).setResizable(false);
            tabla.getColumnModel().getColumn(2).setResizable(false);
            tabla.getColumnModel().getColumn(3).setResizable(false);
            tabla.getColumnModel().getColumn(0).setPreferredWidth(20);
            tabla.getColumnModel().getColumn(1).setPreferredWidth(300);
        }
    }

    public Image get_Image(String ruta) {
        try {
            ImageIcon imageIcon = new ImageIcon(getClass().getResource(ruta));
            Image mainIcon = imageIcon.getImage();
            return mainIcon;
        } catch (Exception e) {
        }
        return null;
    }
}
