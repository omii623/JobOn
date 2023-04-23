package hu.jobon.database.model;

public class Jelentkezes {
    private int allasajanlat_ID;
    private int felhasznalo_ID;
    
    public Jelentkezes(int allasajanlat_ID, int felhasznalo_ID) {
        this.allasajanlat_ID = allasajanlat_ID;
        this.felhasznalo_ID = felhasznalo_ID;
    }

    public Jelentkezes() {

    }

    public int getAllasajanlat_ID() {
        return allasajanlat_ID;
    }

    public void setAllasajanlat_ID(int allasajanlat_ID) {
        this.allasajanlat_ID = allasajanlat_ID;
    }

    public int getFelhasznalo_ID() {
        return felhasznalo_ID;
    }

    public void setFelhasznalo_ID(int felhasznalo_ID) {
        this.felhasznalo_ID = felhasznalo_ID;
    }
}
