package VO;

/**
 *
 * @author Rick
 */
public class PdfDNI {
    int Id_DNI;
    String Inquilino;
    int N_DNI;
    byte[] ArchivoPDF;
    
    public PdfDNI() {
        
    }
    
    public int getId_DNI() {
        return Id_DNI;
    }
    
    public String getInquilino() {
        return Inquilino;
    }
    
    public int getN_DNI() {
        return N_DNI;
    }
    
    public byte[] getArchivopdf() {
        return ArchivoPDF;
    }
    
    public void setId_DNI(int Id_Pdf) {
        this.Id_DNI = Id_Pdf;
    }
    
    public void setInquilino(String Inquilino) {
        this.Inquilino = Inquilino;
    }
    
    public void setN_DNI(int N_DNI) {
        this.N_DNI = N_DNI;
    }
    
    public void setArchivoPDF(byte[] ArchivoPDF) {
        this.ArchivoPDF = ArchivoPDF;
    }
}
