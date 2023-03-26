package hu.jobon.database.model;

public class Felhasznalo {
    protected int ID;
    protected String jelszo;
    protected String email_cim;
    protected int tipus;

    protected Felhasznalo(int ID, String jelszo, String email_cim, int tipus) {
        this.ID = ID;
        this.jelszo = jelszo;
        this.email_cim = email_cim;
        this.tipus = tipus;
    }

    public Felhasznalo(){

    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getJelszo() {
        return jelszo;
    }

    public void setJelszo(String jelszo) {
        this.jelszo = jelszo;
    }

    public String getEmail_cim() {
        return email_cim;
    }

    public void setEmail_cim(String email_cim) {
        this.email_cim = email_cim;
    }

    public int getTipus() {
        return tipus;
    }

    public void setTipus(int tipus) {
        this.tipus = tipus;
    }
}
