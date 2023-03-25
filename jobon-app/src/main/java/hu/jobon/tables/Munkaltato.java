package hu.jobon.tables;

public class Munkaltato extends Felhasznalo{
    private int ID;
    private String cegnev;
    private String telefonszam;
    private String email_cim;
    private String megalapitas_eve;
    private String varos;
    private String cim;

    public Munkaltato(int id, String jelszo, String email_cim, int tipus, String cegnev, String telefonszam,
                      String email_cim_hivatalos, String megalapitas_eve, String varos, String cim){
        super(id, jelszo, email_cim, 3);
        
        this.ID = id;
        this.cegnev = cegnev;
        this.telefonszam = telefonszam;
        this.email_cim = email_cim_hivatalos;
        this.megalapitas_eve = megalapitas_eve;
        this.varos = varos;
        this.cim = cim;
    }

    public Munkaltato(int id, String jelszo, String email_cim){
        super(id, jelszo, email_cim, 3);
        
        this.ID = id;
        this.cegnev = "";
        this.telefonszam = "";
        this.email_cim = "";
        this.megalapitas_eve = "";
        this.varos = "";
        this.cim = "";
    }

    public Munkaltato(){
        super();
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getCegnev() {
        return cegnev;
    }

    public void setCegnev(String cegnev) {
        this.cegnev = cegnev;
    }

    public String getTelefonszam() {
        return telefonszam;
    }

    public void setTelefonszam(String telefonszam) {
        this.telefonszam = telefonszam;
    }

    public String getEmail_cim_hivatalos() {
        return email_cim;
    }

    public void setEmail_cim_hivatalos(String email_cim) {
        this.email_cim = email_cim;
    }

    public String getMegalapitas_eve() {
        return megalapitas_eve;
    }

    public void setMegalapitas_eve(String megalapitas_eve) {
        this.megalapitas_eve = megalapitas_eve;
    }

    public String getVaros() {
        return varos;
    }

    public void setVaros(String varos) {
        this.varos = varos;
    }

    public String getCim() {
        return cim;
    }

    public void setCim(String cim) {
        this.cim = cim;
    }
    
    public String getJelszo(){
        return super.jelszo;
    }

    public void setJelszo(String jelszo){
        super.jelszo = jelszo;
    }

    public String getEmail_cim(){
        return super.email_cim;
    }

    public void setEmail_cim(String email_cim){
        super.email_cim = email_cim;
    }

    public int getTipus(){
        return super.tipus; 
    }
    
}
