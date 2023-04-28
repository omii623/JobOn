package hu.jobon.database.servicemodel;

public class JelentkezokStat {
    private String pozicio;
    private int jelentkezok_szama;

    public JelentkezokStat(String pozicio, int jelentkezok_szama) {
        this.pozicio = pozicio;
        this.jelentkezok_szama = jelentkezok_szama;
    }

    public JelentkezokStat() {

    }

    public String getPozicio() {
        return pozicio;
    }

    public void setPozicio(String pozicio) {
        this.pozicio = pozicio;
    }

    public int getJelentkezok_szama() {
        return jelentkezok_szama;
    }

    public void setJelentkezok_szama(int jelentkezok_szama) {
        this.jelentkezok_szama = jelentkezok_szama;
    }
}
