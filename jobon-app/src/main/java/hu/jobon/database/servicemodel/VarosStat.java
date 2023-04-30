package hu.jobon.database.servicemodel;

public class VarosStat {
    private int allaskeresok_szama;
    private String varos;

    public VarosStat(int allaskeresok_szama, String varos) {
        this.allaskeresok_szama = allaskeresok_szama;
        this.varos = varos;
    }

    public VarosStat() {
    }

    public int getAllaskeresok_szama() {
        return allaskeresok_szama;
    }

    public void setAllaskeresok_szama(int allaskeresok_szama) {
        this.allaskeresok_szama = allaskeresok_szama;
    }

    public String getVaros() {
        return varos;
    }

    public void setVaros(String varos) {
        this.varos = varos;
    }
}
