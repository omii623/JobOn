package hu.jobon.database.model;

public class Szakma {
    private String szakma;
    private int felhasznalo_ID;
    
    public Szakma(String szakma, int felhasznalo_ID) {
        this.szakma = szakma;
        this.felhasznalo_ID = felhasznalo_ID;
    }

    public Szakma() {
    }

    public String getSzakma() {
        return szakma;
    }

    public void setSzakma(String szakma) {
        this.szakma = szakma;
    }

    public int getFelhasznalo_ID() {
        return felhasznalo_ID;
    }

    public void setFelhasznalo_ID(int felhasznalo_ID) {
        this.felhasznalo_ID = felhasznalo_ID;
    }
}
