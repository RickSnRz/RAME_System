
package VO;


public class PdfVO {
    /*Todo los atributos*/
    int Id_Pdf;
    String Inquilino;
    String TipoPDF;
    byte[] ArchivoPDF;

    public PdfVO() {
    }

    /*Todo los codigos get*/
    public int getId_Pdf() {
        return Id_Pdf;
    }

    public String getInquilino() {
        return Inquilino;
    }
    
    public String getTipoPDF() {
        return TipoPDF;
    }

    public byte[] getArchivopdf() {
        return ArchivoPDF;
    }


    /*Todo los codigos set*/
    public void setId_Pdf(int Id_Pdf) {
        this.Id_Pdf = Id_Pdf;
    }

    public void setInquilino(String Inquilino) {
        this.Inquilino = Inquilino;
    }
    
    public void setTipoPDF(String TipoPDF) {
        this.TipoPDF = TipoPDF;
    }

    public void setArchivoPDF(byte[] ArchivoPDF) {
        this.ArchivoPDF = ArchivoPDF;
    }
}
