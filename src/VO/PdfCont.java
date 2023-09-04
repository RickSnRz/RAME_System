package VO;

/**
 *
 * @author Rick
 */
public class PdfCont {
    int Id_Contrato;
    String Inquilino;
    String Fecha;
    byte[] ArchivoPDF;
    
    public PdfCont() {
        
    }

    public void setId_Contrato(int Id_Contrato) {
        this.Id_Contrato = Id_Contrato;
    }

    public void setInquilino(String Inquilino) {
        this.Inquilino = Inquilino;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public void setArchivoPDF(byte[] ArchivoPDF) {
        this.ArchivoPDF = ArchivoPDF;
    }

    public int getId_Contrato() {
        return Id_Contrato;
    }

    public String getInquilino() {
        return Inquilino;
    }

    public String getFecha() {
        return Fecha;
    }

    public byte[] getArchivoPDF() {
        return ArchivoPDF;
    }
}
