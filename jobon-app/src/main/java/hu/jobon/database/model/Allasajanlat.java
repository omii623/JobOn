package hu.jobon.database.model;

public class Allasajanlat {
    private static int last_ID = 100;
    private int ID;
    private int felhasznalo_ID;
    private int oraber;
    private String pozicio;
    private String munkakor;
    private String leiras;
    private String letrehozas_ideje;
    
    public Allasajanlat(int felhasznalo_ID, int oraber, String pozicio, String munkakor, String leiras, String letrehozas_ideje) {
        ID = last_ID;
        this.felhasznalo_ID = felhasznalo_ID;
        this.oraber = oraber;
        this.pozicio = pozicio;
        this.munkakor = munkakor;
        this.leiras = leiras;
        this.letrehozas_ideje = letrehozas_ideje;
        last_ID++;
    }
    public Allasajanlat(){

    }

    public int getID() {
        return ID;
    }

    public int getFelhasznalo_ID() {
        return felhasznalo_ID;
    }

    public void setFelhasznalo_ID(int felhasznalo_ID) {
        this.felhasznalo_ID = felhasznalo_ID;
    }

    public int getOraber() {
        return oraber;
    }

    public void setOraber(int oraber) {
        this.oraber = oraber;
    }

    public String getPozicio() {
        return pozicio;
    }

    public void setPozicio(String pozicio) {
        this.pozicio = pozicio;
    }

    public String getMunkakor() {
        return munkakor;
    }

    public void setMunkakor(String munkakor) {
        this.munkakor = munkakor;
    }

    public String getLeiras() {
        return leiras;
    }

    public void setLeiras(String leiras) {
        this.leiras = leiras;
    }

    public String getLetrehozas_ideje() {
        return letrehozas_ideje;
    }
    public void setLetrehozas_ideje(String letrehozas_ideje) {
        this.letrehozas_ideje = letrehozas_ideje;
    }
}
