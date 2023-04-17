package hu.jobon.database;

import hu.jobon.database.model.Allasajanlat;
import hu.jobon.database.model.Allaskereso;
import hu.jobon.database.model.Felhasznalo;
import hu.jobon.database.model.Munkaltato;
import hu.jobon.database.model.*;
import hu.jobon.user.User;
import oracle.jdbc.pool.OracleDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static hu.jobon.controller.LoginController.felhasznalo;

public class Database {
    ResultSet rs;
    Statement stmt;
    OracleDataSource ods;
    String user = User.name;
    String pass = User.pass;
    Connection connection;

    private final String GET_MUNKALTATO = "SELECT * FROM C##SAELDC.MUNKALTATO, C##SAELDC.FELHASZNALO WHERE C##SAELDC.MUNKALTATO.ID = C##SAELDC.FELHASZNALO.ID";
    private final String GET_ALLASKERESO = "SELECT * FROM C##SAELDC.ALLASKERESO, C##SAELDC.FELHASZNALO WHERE C##SAELDC.ALLASKERESO.ID = C##SAELDC.FELHASZNALO.ID";
    private final String GET_FELHASZNALO = "SELECT * FROM C##SAELDC.FELHASZNALO";
    private final String GET_ALLASAJANLAT = "SELECT * FROM C##SAELDC.ALLASAJANLAT WHERE CURRENT_DATE-LETREHOZAS_IDEJE<30";
    private final String REGIST_USER = "INSERT INTO C##SAELDC.FELHASZNALO (ID,EMAIL_CIM,JELSZO,TIPUS) VALUES (";
    private final String REGIST_MUNKALTATO = "INSERT INTO C##SAELDC.MUNKALTATO (ID,CEGNEV,TELEFONSZAM,EMAIL_CIM_HIVATALOS,MEGALAPITAS_EVE,VAROS,CIM) VALUES (";
    private final String REGIST_ALLASKERESO = "INSERT INTO C##SAELDC.ALLASKERESO (ID,TELJES_NEV,SZULETESI_DATUM,VAROS,CIM,UTOLSO_BELEPES) VALUES (";
    private final String MAX_ID_FELHASZNALO = "SELECT MAX(ID) FROM C##SAELDC.FELHASZNALO";
    private final String GET_MEGFELELO_ALLASAJANLAT = "SELECT * FROM C##SAELDC.ALLASAJANLAT, C##SAELDC.MUNKALTATO, C##SAELDC.SZAKMA WHERE C##SAELDC.ALLASAJANLAT.FID=C##SAELDC.MUNKALTATO.ID AND "+felhasznalo.getID()+"=C##SAELDC.SZAKMA.FID AND MUNKAKOR=SZAKMA";
    private final String GET_STAT_SZAKMA_FELHASZNALO = "SELECT COUNT(*), SZAKMA FROM C##SAELDC.ALLASKERESO, C##SAELDC.SZAKMA WHERE ALLASKERESO.ID=SZAKMA.FID GROUP BY SZAKMA";

    public Database(){
       
    }

    public void DatabaseConnect(){
        try{
            ods = new OracleDataSource();
            Class.forName("oracle.jdbc.OracleDriver");
            ods.setURL("jdbc:oracle:thin:@localhost:1521:orania2");
            connection = ods.getConnection(user,pass);
            System.out.println("INFO: Sikeres csatlakozás -1-");
        }catch(Exception e){
            System.out.println("ERROR: Sikertelen csatlakozás. -1-");
            System.err.println(e);
        }
    }

    public void DatabaseDisconnect(){
        try{
            connection.close();
            rs.close();
            stmt.close();
            System.out.println("INFO: Sikeres kicsatlakozás.");
        }catch(Exception e){
            System.out.println("ERROR: Sikertelen kicsatlakozás.");
            System.err.print(e);
        }
    }

    public List<Felhasznalo> getFelhasznaloAll(){
        DatabaseConnect();
        List<Felhasznalo> fList = new ArrayList<>();
        try{
            stmt = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(GET_FELHASZNALO);

            while(rs.next()){
                Felhasznalo f = new Felhasznalo();
                f.setEmail_cim(rs.getString("EMAIL_CIM"));
                f.setJelszo(rs.getString("JELSZO"));
                f.setID(rs.getInt("ID"));
                f.setTipus(rs.getInt("TIPUS"));

                fList.add(f);
            }

            System.out.println("INFO: Sikeres lekérés (munkáltató)");
        }catch(SQLException e){
            System.err.print(e);
            System.out.println("INFO: Sikeres lekérés (munkáltató)");
        } catch(Exception e){
            System.out.println("ERROR: Sikertelen lekérés (felhasználó)");
            System.err.print(e);
            return null;
        }

        DatabaseDisconnect();

        return fList;
    }

    public List<Allaskereso> getAllaskeresoAll(){
        DatabaseConnect();
        List<Allaskereso> aList = new ArrayList<>();
        try{
            stmt = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
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

        DatabaseDisconnect();

        return aList;
    }

    public List<Munkaltato> getMunkaltatoAll(){
        DatabaseConnect();
        List<Munkaltato> mList = new ArrayList<>();
        try{
            stmt = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
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

        DatabaseDisconnect();

        return mList;
    }

    public List<Allasajanlat> getAllasajanlatAll(){
        DatabaseConnect();
        List<Allasajanlat> aList = new ArrayList<>();
        try{
            stmt = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
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

        DatabaseDisconnect();

        return aList;
    }

    public void updateFelhasznalo(String sql){
        DatabaseConnect();
        try{
            stmt = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);

            System.out.println("INFO: Sikeres update (felhasználó)");
        }catch(Exception e){
            System.out.println("ERROR: Sikertelen update (felhasználó)");
            System.err.print(e);
        }
        DatabaseDisconnect();
    }

    public List<Allasajanlat> getAllasajanlataim(String GET_ALLASAJANLATAIM) {
        DatabaseConnect();
        List<Allasajanlat> aList = new ArrayList<>();
        try{
            stmt = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(GET_ALLASAJANLATAIM);

            while (rs.next()) {
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
        } catch (Exception e) {
            System.out.println("ERROR: Sikertelen lekérés (állásajánlat)");
            System.err.print(e);
            return null;
        }

        DatabaseDisconnect();

        return aList;
    }

    public boolean registFelhasznalo(Munkaltato f){
        DatabaseConnect();
        int id = 0;
        try {
            stmt = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(MAX_ID_FELHASZNALO);
            if (rs.next()) {
                id = rs.getInt(1);
                System.out.println("Max ID: " + id);
            }
            String str = String.valueOf(++id);
            rs = stmt.executeQuery(REGIST_USER+str+",'"+f.getEmail_cim()+"','"+f.getJelszo()+"',"+f.getTipus()+")");

            rs = stmt.executeQuery(REGIST_MUNKALTATO+str+",'"+f.getCegnev()+"','"+f.getTelefonszam()+"','"+f.getEmail_cim_hivatalos()+"',TO_DATE('"+
                    f.getMegalapitas_eve()+"','YYYY-MM-DD'),'"+f.getVaros()+"','"+f.getCim()+"')");
        }catch (SQLException sql){
            sql.printStackTrace();
        }

        DatabaseDisconnect();

        return false;
    }

    public boolean registFelhasznalo(Allaskereso f){
        DatabaseConnect();
        int id = 0;
        try {
            stmt = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(MAX_ID_FELHASZNALO);
            if (rs.next()) {
                id = rs.getInt(1);
                System.out.println("Max ID: " + id);
            }
            String str = String.valueOf(++id);
            rs = stmt.executeQuery(REGIST_USER+str+",'"+f.getEmail_cim()+"','"+f.getJelszo()+"',"+f.getTipus()+")");

            LocalDate currentDate = LocalDate.now();
            rs = stmt.executeQuery(REGIST_ALLASKERESO+str+",'"+f.getTeljes_nev()+"',TO_DATE('"+f.getSzuletesi_datum()+"','YYYY-MM-DD'),'"+f.getVaros()+"','"+
                    f.getCim()+"',TO_DATE('"+currentDate.toString()+"','YYYY-MM-DD'))");

        }catch (SQLException sql){
            sql.printStackTrace();
        }

        DatabaseDisconnect();

        return false;
    }

    public List<Allasajanlat> getMAllasajanlatAll() {
        List<Allasajanlat> aList = new ArrayList<>();
        try{
            Connection conn = ods.getConnection(user,pass);
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(GET_MEGFELELO_ALLASAJANLAT);

            while (rs.next()) {
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
        } catch (Exception e) {
            System.out.println("ERROR: Sikertelen lekérés (állásajánlat)");
            System.err.print(e);
            return null;
        }
        return aList;
    }

    public List<Szakma> getStatSzakmaFelhasznalo() {
        List<Szakma> szList = new ArrayList<>();
        try{
            Connection conn = ods.getConnection(user,pass);
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(GET_STAT_SZAKMA_FELHASZNALO);

//            while(rs.next()){
//                Szakma sz = new Szakma();
//                sz.setSzakma(rs.getString("SZAKMA"));
//                sz.setSzakma(rs.getString("COUNT(*)"));
//
//                szList.add(sz);
//            }

            System.out.println("INFO: Sikeres lekérés (állásajánlat)");
        }catch(Exception e){
            System.out.println("ERROR: Sikertelen lekérés (állásajánlat)");
            System.err.print(e);
            return null;
        }
        return szList;
    }
    public boolean registFelhasznalo(Munkaltato f){
        int id = 0;
        try {
            Connection conn = ods.getConnection(user,pass);
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(MAX_ID_FELHASZNALO);
            if (rs.next()) {
                id = rs.getInt(1);
                System.out.println("Max ID: " + id);
            }
            String str = String.valueOf(++id);
            rs = stmt.executeQuery(REGIST_USER+str+",'"+f.getEmail_cim()+"','"+f.getJelszo()+"',"+f.getTipus()+")");

            rs = stmt.executeQuery(REGIST_MUNKALTATO+str+",'"+f.getCegnev()+"','"+f.getTelefonszam()+"','"+f.getEmail_cim_hivatalos()+"',TO_DATE('"+
                    f.getMegalapitas_eve()+"','YYYY-MM-DD'),'"+f.getVaros()+"','"+f.getCim()+"')");
        }catch (SQLException sql){
            sql.printStackTrace();
        }
        return false;
    }

    public boolean registFelhasznalo(Allaskereso f){
        int id = 0;
        try {
            Connection conn = ods.getConnection(user,pass);
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(MAX_ID_FELHASZNALO);
            if (rs.next()) {
                id = rs.getInt(1);
                System.out.println("Max ID: " + id);
            }
            String str = String.valueOf(++id);
            rs = stmt.executeQuery(REGIST_USER+str+",'"+f.getEmail_cim()+"','"+f.getJelszo()+"',"+f.getTipus()+")");

            LocalDate currentDate = LocalDate.now();
            rs = stmt.executeQuery(REGIST_ALLASKERESO+str+",'"+f.getTeljes_nev()+"',TO_DATE('"+f.getSzuletesi_datum()+"','YYYY-MM-DD'),'"+f.getVaros()+"','"+
                    f.getCim()+"',TO_DATE('"+currentDate.toString()+"','YYYY-MM-DD'))");

        }catch (SQLException sql){
            sql.printStackTrace();
        }
        return false;
    }
}
