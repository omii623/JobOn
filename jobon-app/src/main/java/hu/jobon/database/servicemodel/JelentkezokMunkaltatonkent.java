package hu.jobon.database.servicemodel;

public class JelentkezokMunkaltatonkent {
    private int MID;
    private String pozicio;
    private String munkakor;
    private String leiras;
    private String allaskereso_teljes_nev;

    public JelentkezokMunkaltatonkent(int MID, String pozicio, String munkakor, String leiras, String allaskereso_teljes_nev) {
        this.MID = MID;
        this.pozicio = pozicio;
        this.munkakor = munkakor;
        this.leiras = leiras;
        this.allaskereso_teljes_nev = allaskereso_teljes_nev;
    }

    public JelentkezokMunkaltatonkent() {

    }

    public int getMID() {
        return MID;
    }

    public void setMID(int MID) {
        this.MID = MID;
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

    public String getAllaskereso_teljes_nev() {
        return allaskereso_teljes_nev;
    }

    public void setAllaskereso_teljes_nev(String allaskereso_teljes_nev) {
        this.allaskereso_teljes_nev = allaskereso_teljes_nev;
    }
}
