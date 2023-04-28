package hu.jobon.database.servicemodel;

public class KorStat {
    private float atlag_eletkor;
    private String szakma;

    public KorStat(int atlag_eletkor, String szakma) {
        this.atlag_eletkor = atlag_eletkor;
        this.szakma = szakma;
    }

    public KorStat() {

    }

    public float getAtlag_eletkor() {
        return atlag_eletkor;
    }

    public void setAtlag_eletkor(float atlag_eletkor) {
        this.atlag_eletkor = atlag_eletkor;
    }

    public String getSzakma() {
        return szakma;
    }

    public void setSzakma(String szakma) {
        this.szakma = szakma;
    }
}
