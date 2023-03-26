package hu.jobon.database.model;

public class Cv {
    private int felhasznalo_ID;
    private String oneletrajz;
    
    public Cv(int felhasznalo_ID, String oneletrajz) {
        this.felhasznalo_ID = felhasznalo_ID;
        this.oneletrajz = oneletrajz;
    }

    public int getFelhasznalo_ID() {
        return felhasznalo_ID;
    }

    public void setFelhasznalo_ID(int felhasznalo_ID) {
        this.felhasznalo_ID = felhasznalo_ID;
    }

    public String getOneletrajz() {
        return oneletrajz;
    }

    public void setOneletrajz(String oneletrajz) {
        this.oneletrajz = oneletrajz;
    }
}
