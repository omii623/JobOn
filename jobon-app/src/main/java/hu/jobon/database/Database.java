package hu.jobon.database;

import hu.jobon.database.model.Allasajanlat;
import hu.jobon.database.model.Allaskereso;
import hu.jobon.database.model.Felhasznalo;
import hu.jobon.database.model.Munkaltato;
import hu.jobon.user.User;
import oracle.jdbc.pool.OracleDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Database {
    ResultSet rs;
    Statement stmt;
    OracleDataSource ods;
    String user = User.name;
    String pass = User.pass;

    private final String GET_MUNKALTATO = "SELECT * FROM C##SAELDC.MUNKALTATO, C##SAELDC.FELHASZNALO WHERE C##SAELDC.MUNKALTATO.ID = C##SAELDC.FELHASZNALO.ID";
    private final String GET_ALLASKERESO = "SELECT * FROM C##SAELDC.ALLASKERESO, C##SAELDC.FELHASZNALO WHERE C##SAELDC.ALLASKERESO.ID = C##SAELDC.FELHASZNALO.ID";
    private final String GET_FELHASZNALO = "SELECT * FROM C##SAELDC.FELHASZNALO";
    private final String GET_ALLASAJANLAT = "SELECT * FROM C##SAELDC.ALLASAJANLAT";


    public Database(){
        try{
            ods = new OracleDataSource();
            Class.forName("oracle.jdbc.OracleDriver");
            ods.setURL("jdbc:oracle:thin:@localhost:1521:orania2");
            System.out.println("INFO: Sikeres csatlakozás -1-");
        }catch(Exception e){
            System.out.println("ERROR: Sikertelen csatlakozás. -1- ");
            System.err.print(e);
        }
    }

    public void connect(){
        try{
            Connection conn = ods.getConnection(user,pass);
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            System.out.println("INFO: Sikeres próba lekérés");
        }catch(Exception e){
            System.out.println("ERROR: Sikertelen próba lekérés. -2- ");
            System.err.print(e);
        }
    }

    public List<Felhasznalo> getFelhasznaloAll(){
        List<Felhasznalo> fList = new ArrayList<>();
        try{
            Connection conn = ods.getConnection(user,pass);
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(GET_FELHASZNALO);

            while(rs.next()){
                Felhasznalo f = new Felhasznalo();
                f.setEmail_cim(rs.getString("EMAIL_CIM"));
                f.setJelszo(rs.getString("JELSZO"));
                f.setID(rs.getInt("ID"));
                f.setTipus(rs.getInt("TIPUS"));

                fList.add(f);
            }

            System.out.println("INFO: Sikeres lekérés (felhasználó)");
        }catch(Exception e){
            System.out.println("ERROR: Sikertelen lekérés (felhasználó)");
            System.err.print(e);
            return null;
        }

        return fList;
    }

    public List<Allaskereso> getAllaskeresoAll(){
        List<Allaskereso> aList = new ArrayList<>();
        try{
            Connection conn = ods.getConnection(user,pass);
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(GET_ALLASKERESO);

            while(rs.next()){
                Allaskereso a = new Allaskereso();
                a.setID(rs.getInt("ID"));
                a.setTeljes_nev(rs.getString("TELJES_NEV"));
                a.setSzuletesi_datum(rs.getString("SZULETESI_DATUM"));
                a.setVaros(rs.getString("VAROS"));
                a.setCim(rs.getString("CIM"));

                aList.add(a);
            }

            System.out.println("INFO: Sikeres lekérés (álláskereső)");
        }catch(Exception e){
            System.out.println("ERROR: Sikertelen lekérés (álláskereső)");
            System.err.print(e);
            return null;
        }

        return aList;
    }

    public List<Munkaltato> getMunkaltatoAll(){
        List<Munkaltato> mList = new ArrayList<>();
        try{
            Connection conn = ods.getConnection(user,pass);
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(GET_MUNKALTATO);

            while(rs.next()){
                Munkaltato m = new Munkaltato();
//                m.setEmail_cim(rs.getString("EMAIL_CIM"));
//                m.setJelszo(rs.getString("JELSZO"));
                m.setID(rs.getInt("ID"));
                m.setCegnev(rs.getString("CEGNEV"));
                m.setTelefonszam(rs.getString("TELEFONSZAM"));
                m.setEmail_cim_hivatalos(rs.getString("EMAIL_CIM_HIVATALOS"));
                m.setVaros(rs.getString("VAROS"));
                m.setCim(rs.getString("CIM"));

                m.setMegalapitas_eve(rs.getString("MEGALAPITAS_EVE"));//nem bitos hogy jó

                mList.add(m);
            }

            System.out.println("INFO: Sikeres lekérés (munkáltató)");
        }catch(Exception e){
            System.out.println("ERROR: Sikertelen lekérés (munkáltató)");
            System.err.print(e);
            return null;
        }

        return mList;
    }

    public List<Allasajanlat> getAllasajanlatAll(){
        List<Allasajanlat> aList = new ArrayList<>();
        try{
            Connection conn = ods.getConnection(user,pass);
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(GET_ALLASAJANLAT);

            while(rs.next()){
                Allasajanlat a = new Allasajanlat();
                a.setFelhasznalo_ID(rs.getInt("FID"));
                a.setOraber(rs.getInt("ORABER"));
                a.setPozicio(rs.getString("POZICIO"));
                a.setMunkakor(rs.getString("MUNKAKOR"));
                a.setLeiras(rs.getString("LEIRAS"));
                a.setLetrehozas_ideje(rs.getString("LETREHOZAS_IDEJE"));
                aList.add(a);
            }

            System.out.println("INFO: Sikeres lekérés (állásajánlat)");
        }catch(Exception e){
            System.out.println("ERROR: Sikertelen lekérés (állásajánlat)");
            System.err.print(e);
            return null;
        }
        return aList;
    }


    public void updateFelhasznalo(String sql){
        try{
            Connection conn = ods.getConnection(user,pass);
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);

            System.out.println("INFO: Sikeres update (felhasználó)");
        }catch(Exception e){
            System.out.println("ERROR: Sikertelen update (felhasználó)");
            System.err.print(e);
        }
    }

    public List<Allasajanlat> getAllasajanlataim(String GET_ALLASAJANLATAIM) {
        List<Allasajanlat> aList = new ArrayList<>();
        try{
            Connection conn = ods.getConnection(user,pass);
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(GET_ALLASAJANLATAIM);

            while(rs.next()){
                Allasajanlat a = new Allasajanlat();
                a.setFelhasznalo_ID(rs.getInt("FID"));
                a.setOraber(rs.getInt("ORABER"));
                a.setPozicio(rs.getString("POZICIO"));
                a.setMunkakor(rs.getString("MUNKAKOR"));
                a.setLeiras(rs.getString("LEIRAS"));
                a.setLetrehozas_ideje(rs.getString("LETREHOZAS_IDEJE"));
                aList.add(a);
            }

            System.out.println("INFO: Sikeres lekérés (állásajánlat)");
        }catch(Exception e){
            System.out.println("ERROR: Sikertelen lekérés (állásajánlat)");
            System.err.print(e);
            return null;
        }
        return aList;
    }
}
