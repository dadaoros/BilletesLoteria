package Models;
        import java.io.Serializable;
        import java.util.Date;
/**
 * Created by root on 5/10/14.
 */
public class Ticket implements Serializable {
    private String loteria;
    private String numero, serie;
    //private Date fecha;
    private String fecha;
    public Ticket(String loteria,String numero,String serie,String fecha) {
        this.loteria = loteria;
        this.numero=numero;
        this.serie=serie;
        this.fecha= fecha;
    }
    //<editor-fold desc="Getters n Setters">
    public String getLoteria() {
        return loteria;
    }
    public void setLoteria(String loteria) {
        this.loteria = loteria;
    }
    public String getNumero() {
        return numero;
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }
    public String getSerie() {
        return serie;
    }
    public void setSerie(String serie) {
        this.serie = serie;
    }
    public String getFecha() {
        return fecha;
    }
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
//</editor-fold>
}