package hu.jobon.database.servicemodel;

public class SzakmaStat {
    private String szakma;
    private int felhasznalok_szama;

    public SzakmaStat(String szakma, int felhasznalok_szama) {
        this.szakma = szakma;
        this.felhasznalok_szama = felhasznalok_szama;
    }

    public SzakmaStat() {
    }

    public String getSzakma() { return szakma; }

    public void setSzakma(String szakma) { this.szakma = szakma; }

    public int getFelhasznalok_szama() { return felhasznalok_szama; }

    public void setFelhasznalok_szama(int felhasznalok_szama) { this.felhasznalok_szama = felhasznalok_szama; }
}
