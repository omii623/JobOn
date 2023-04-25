package hu.jobon.database.servicemodel;

public class Jelentkezeseim {
    private int AID;
    private Integer oraber;
    private String pozicio;
    private String munkakor;
    private String leiras;

    public Jelentkezeseim(int AID, int oraber, String pozicio, String munkakor, String leiras) {
        this.AID = AID;
        this.oraber = oraber;
        this.pozicio = pozicio;
        this.munkakor = munkakor;
        this.leiras = leiras;
    }

    public Jelentkezeseim() {

    }

    public Integer getOraber() {
        return oraber;
    }

    public void setOraber(Integer oraber) {
        this.oraber = oraber;
    }

    public int getAID() {
        return AID;
    }

    public void setAID(int AID) {
        this.AID = AID;
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
}
