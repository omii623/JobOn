package hu.jobon.database.model;

public class Allaskereso extends Felhasznalo{
    private int ID; //felhasznalo.id
    private String teljes_nev;
    private String szuletesi_datum;
    private String varos;
    private String cim;
    
    public Allaskereso(int id, String jelszo, String email_cim, String teljes_nev, 
                       String szuletesi_datum, String varos, String cim) {
        super(id, jelszo,email_cim,2);

        this.ID = id;
        this.teljes_nev = teljes_nev;
        this.szuletesi_datum = szuletesi_datum;
        this.varos = varos;
        this.cim = cim;
    }

    public Allaskereso(int id, String jelszo, String email_cim) {
        super(id, jelszo,email_cim,2);

        this.ID = id;
        teljes_nev = "";
        szuletesi_datum = "";
        varos = "";
        cim = "";
    }

    public Allaskereso(){
        super();
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTeljes_nev() {
        return teljes_nev;
    }

    public void setTeljes_nev(String teljes_nev) {
        this.teljes_nev = teljes_nev;
    }

    public String getSzuletesi_datum() {
        return szuletesi_datum;
    }

    public void setSzuletesi_datum(String szuletesi_datum) {
        this.szuletesi_datum = szuletesi_datum;
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
