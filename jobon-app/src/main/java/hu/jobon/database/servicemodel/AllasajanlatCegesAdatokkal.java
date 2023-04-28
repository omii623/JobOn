package hu.jobon.database.servicemodel;

public class AllasajanlatCegesAdatokkal {
    private int ID;
    private String cegnev;
    private String varos;
    private String cim;
    private int oraber;
    private String pozicio;
    private String munkakor;
    private String leiras;

    public AllasajanlatCegesAdatokkal(int ID, String cegnev, String varos, String cim, int oraber, String pozicio, String munkakor, String leiras) {
        this.ID=ID;
        this.cegnev = cegnev;
        this.varos = varos;
        this.cim = cim;
        this.oraber = oraber;
        this.pozicio = pozicio;
        this.munkakor = munkakor;
        this.leiras = leiras;
    }

    public AllasajanlatCegesAdatokkal() {

    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getCegnev() {
        return cegnev;
    }

    public void setCegnev(String cegnev) {
        this.cegnev = cegnev;
    }

    public String getVaros() {
        return varos;
    }

    public void setVaros(String varos) {
        this.varos = varos;
    }

    public String getCim() {
        return cim;
    }

    public void setCim(String cim) {
        this.cim = cim;
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
}
