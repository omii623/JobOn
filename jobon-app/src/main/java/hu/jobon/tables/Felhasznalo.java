package hu.jobon.tables;

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

    protected Felhasznalo(){
        
    }
}
