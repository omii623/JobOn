package hu.jobon.database.servicemodel;

public class KorStat {
    private int kor;
    private int felhasznalok_szama;

    public KorStat(int kor, int felhasznalok_szama) {
        this.kor = kor;
        this.felhasznalok_szama = felhasznalok_szama;
    }

    public KorStat() {
    }

    public int getKor() {
        return kor;
    }

    public void setKor(int kor) {
        this.kor = kor;
    }

    public int getFelhasznalok_szama() {
        return felhasznalok_szama;
    }

    public void setFelhasznalok_szama(int felhasznalok_szama) {
        this.felhasznalok_szama = felhasznalok_szama;
    }
}
