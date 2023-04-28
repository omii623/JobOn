package hu.jobon.database.servicemodel;

public class BerStat {
    private int ber;
    private String munkakor;

    public BerStat(int ber, String munkakor) {
        this.ber = ber;
        this.munkakor = munkakor;
    }

    public BerStat() {

    }

    public int getBer() {
        return ber;
    }

    public void setBer(int ber) {
        this.ber = ber;
    }

    public String getMunkakor() {
        return munkakor;
    }

    public void setMunkakor(String munkakor) {
        this.munkakor = munkakor;
    }
}
