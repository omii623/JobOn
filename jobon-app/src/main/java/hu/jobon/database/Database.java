package hu.jobon.database;

import hu.jobon.database.model.Allasajanlat;
import hu.jobon.database.model.Allaskereso;
import hu.jobon.database.model.Felhasznalo;
import hu.jobon.database.model.Munkaltato;
import hu.jobon.database.model.*;
import hu.jobon.database.servicemodel.*;
import hu.jobon.user.User;
import hu.jobon.database.model.*;
import hu.jobon.database.servicemodel.*;
import hu.jobon.user.User;
import oracle.jdbc.pool.OracleDataSource;

import java.sql.*;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static hu.jobon.controller.LoginController.felhasznalo;

import static hu.jobon.controller.LoginController.felhasznalo;

public class Database {
    ResultSet rs;
    Boolean rss;
    Statement stmt;
    OracleDataSource ods;
    String user = User.name;
    String pass = User.pass;
    Connection connection;

    private final String GET_MUNKALTATO = "SELECT * FROM C##SAELDC.MUNKALTATO, C##SAELDC.FELHASZNALO WHERE C##SAELDC.MUNKALTATO.ID = C##SAELDC.FELHASZNALO.ID";
    private final String GET_ALLASKERESO = "SELECT * FROM C##SAELDC.ALLASKERESO, C##SAELDC.FELHASZNALO WHERE C##SAELDC.ALLASKERESO.ID = C##SAELDC.FELHASZNALO.ID";
    private final String GET_FELHASZNALO = "SELECT * FROM C##SAELDC.FELHASZNALO";
    private final String GET_FRISS_ALLASAJANLAT = "SELECT * FROM C##SAELDC.ALLASAJANLAT WHERE CURRENT_DATE-LETREHOZAS_IDEJE<30";
    private final String GET_ALLASAJANLAT = "SELECT * FROM C##SAELDC.ALLASAJANLAT";
    private final String GET_ATLAGON_FELULI_ALLASAJANLAT = "SELECT * FROM C##SAELDC.ALLASAJANLAT, C##SAELDC.MUNKALTATO, C##SAELDC.ALLASKERESO WHERE C##SAELDC.ALLASAJANLAT.FID=C##SAELDC.MUNKALTATO.ID AND C##SAELDC.ALLASKERESO.ID="+felhasznalo.getID()+" AND ORABER> (SELECT AVG(ORABER) FROM C##SAELDC.ALLASAJANLAT) AND C##SAELDC.MUNKALTATO.VAROS=C##SAELDC.ALLASKERESO.VAROS";
    private final String GET_JELENTKEZOK = "SELECT  C##SAELDC.ALLASAJANLAT.ID, POZICIO, MUNKAKOR, LEIRAS, C##SAELDC.ALLASKERESO.TELJES_NEV FROM C##SAELDC.JELENTKEZES, C##SAELDC.ALLASAJANLAT, C##SAELDC.ALLASKERESO WHERE C##SAELDC.JELENTKEZES.FID=C##SAELDC.ALLASKERESO.ID AND C##SAELDC.ALLASAJANLAT.ID=C##SAELDC.JELENTKEZES.AID AND C##SAELDC.ALLASAJANLAT.FID= "+felhasznalo.getID()+"";
    private final String GET_JELENTKEZESEIM = "SELECT  C##SAELDC.ALLASAJANLAT.ID, ORABER, POZICIO, MUNKAKOR, LEIRAS FROM C##SAELDC.JELENTKEZES, C##SAELDC.ALLASAJANLAT, C##SAELDC.ALLASKERESO WHERE C##SAELDC.JELENTKEZES.FID=C##SAELDC.ALLASKERESO.ID AND C##SAELDC.ALLASAJANLAT.ID=C##SAELDC.JELENTKEZES.AID AND C##SAELDC.JELENTKEZES.FID= "+felhasznalo.getID()+"";
    private final String GET_MEGFELELO_ALLASAJANLAT = "SELECT * FROM C##SAELDC.ALLASAJANLAT, C##SAELDC.MUNKALTATO, C##SAELDC.SZAKMA WHERE C##SAELDC.ALLASAJANLAT.FID=C##SAELDC.MUNKALTATO.ID AND "+felhasznalo.getID()+"=C##SAELDC.SZAKMA.FID AND MUNKAKOR=SZAKMA";
    private final String GET_MEGFELELO_ALLASAJANLAT_M = "SELECT * FROM C##SAELDC.ALLASAJANLAT, C##SAELDC.MUNKALTATO WHERE C##SAELDC.ALLASAJANLAT.FID=C##SAELDC.MUNKALTATO.ID AND MUNKAKOR=";
    private final String GET_MEGFELELO_ALLASAJANLAT_V = "SELECT * FROM C##SAELDC.ALLASAJANLAT, C##SAELDC.MUNKALTATO WHERE C##SAELDC.ALLASAJANLAT.FID=C##SAELDC.MUNKALTATO.ID AND VAROS=";
    private final String GET_MEGFELELO_ALLASAJANLAT_O = "SELECT * FROM C##SAELDC.ALLASAJANLAT, C##SAELDC.MUNKALTATO WHERE C##SAELDC.ALLASAJANLAT.FID=C##SAELDC.MUNKALTATO.ID AND ORABER>";
    private final String GET_STAT_SZAKMA_FELHASZNALO = "SELECT SZAKMA FROM C##SAELDC.ALLASKERESO, C##SAELDC.SZAKMA WHERE ALLASKERESO.ID=SZAKMA.FID GROUP BY SZAKMA";
    private final String GET_STAT_KOR_FELHASZNALO = "SELECT AVG(EXTRACT(YEAR FROM CURRENT_DATE)-EXTRACT(YEAR FROM SZULETESI_DATUM)) AS atlageletkor, SZAKMA FROM C##SAELDC.ALLASKERESO, C##SAELDC.SZAKMA WHERE ALLASKERESO.ID=SZAKMA.FID GROUP BY  SZAKMA ORDER BY atlageletkor";
    private final String GET_STAT_JELENTKEZOK = "SELECT POZICIO, COUNT(*) AS jelentkezok_szama FROM C##SAELDC.ALLASAJANLAT, C##SAELDC.JELENTKEZES WHERE ALLASAJANLAT.ID=JELENTKEZES.AID AND ALLASAJANLAT.FID="+felhasznalo.getID()+" GROUP BY POZICIO ORDER BY Jelentkezok_szama";
    private final String GET_STAT_BER = "ORABER) AS ber, MUNKAKOR FROM C##SAELDC.ALLASAJANLAT, C##SAELDC.MUNKALTATO WHERE ALLASAJANLAT.FID=MUNKALTATO.ID AND MUNKAKOR=";
   private final String REGIST_USER = "INSERT INTO C##SAELDC.FELHASZNALO (ID,EMAIL_CIM,JELSZO,TIPUS) VALUES (";
    private final String NEW_ALLASAJANLAT = "INSERT INTO C##SAELDC.ALLASAJANLAT (ID,FID,ORABER,POZICIO,MUNKAKOR,LETREHOZAS_IDEJE, LEIRAS) VALUES (";
    private final String NEW_JELENTKEZES = "INSERT INTO C##SAELDC.JELENTKEZES (AID,FID) VALUES (";
   private final String REGIST_MUNKALTATO = "INSERT INTO C##SAELDC.MUNKALTATO (ID,CEGNEV,TELEFONSZAM,EMAIL_CIM_HIVATALOS,MEGALAPITAS_EVE,VAROS,CIM) VALUES (";
    private final String REGIST_ALLASKERESO = "INSERT INTO C##SAELDC.ALLASKERESO (ID,TELJES_NEV,SZULETESI_DATUM,VAROS,CIM,UTOLSO_BELEPES) VALUES (";
    private final String MAX_ID_FELHASZNALO = "SELECT MAX(ID) FROM C##SAELDC.FELHASZNALO";
    private final String MAX_ID_ALLASAJANLAT = "SELECT MAX(ID) FROM C##SAELDC.ALLASAJANLAT";
     private final String DELETE_FELHASZNALO = "DELETE FROM C##SAELDC.FELHASZNALO WHERE ID=";
    private final String DELETE_ALLASAJANLAT = "DELETE FROM C##SAELDC.ALLASAJANLAT WHERE ID=";
    private final String DELETE_JELENTKEZESEIM = "DELETE FROM C##SAELDC.JELENTKEZES WHERE AID=";


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

    public void DatabaseDisconnect2(){
        try{
            connection.close();
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

            System.out.println("INFO: Sikeres lekérés (felhasználó)");

        } catch(Exception e){
            System.out.println("ERROR: Sikertelen lekérés (felhasználó)");
            System.err.print(e);
            DatabaseDisconnect();
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
            DatabaseDisconnect();
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
            DatabaseDisconnect();
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
            DatabaseDisconnect();
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

    public void insertSzakma(String sql){
        DatabaseConnect();
        try{
            stmt = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            rss = stmt.execute(sql);
            System.out.println("INFO: Sikeres inser szakma");
        }catch(Exception e){
            System.out.println("ERROR: Sikertelen insert szakma");
            System.err.print(e);
        }
        DatabaseDisconnect2();
    }

    public void deleteFelhasznalo(Felhasznalo f) {
        DatabaseConnect();
        try(
                Connection c = ods.getConnection(user,pass);
                PreparedStatement stmt = c.prepareStatement(DELETE_FELHASZNALO+f.getID());
        ) {
//            stmt.setInt(1, felhasznalo.getID());
            stmt.executeUpdate();

            System.out.println("INFO: Sikeres delete (felhasznalo)"+f.getID());
        } catch (SQLException throwables) {
            System.out.println("ERROR: Sikertelen delete (felhasznalo)"+f.getID());
            throwables.printStackTrace();
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
                a.setID(rs.getInt("ID"));
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
            DatabaseDisconnect();
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


    public List<Allasajanlat> getFrissAllasajanlatAll(){
        DatabaseConnect();
        List<Allasajanlat> aList = new ArrayList<>();
        try{
            Connection conn = ods.getConnection(user,pass);
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(GET_FRISS_ALLASAJANLAT);

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
            DatabaseDisconnect();
            return null;
        }
        DatabaseDisconnect();
        return aList;
    }


    public List<AllasajanlatCegesAdatokkal> getMAllasajanlat(String text, int i) {
        DatabaseConnect();
        List<AllasajanlatCegesAdatokkal> aList = new ArrayList<>();
        try{
            Connection conn = ods.getConnection(user,pass);
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            if(i==1) {
                rs = stmt.executeQuery(GET_MEGFELELO_ALLASAJANLAT_M + "'" + text + "'"); //gyűjtőtábla a megfelelőkből és ott szűrés
            }
            if(i==2) {
                rs = stmt.executeQuery(GET_MEGFELELO_ALLASAJANLAT_V + "'" + text + "'");
            }
            if(i==3) {
                rs = stmt.executeQuery(GET_MEGFELELO_ALLASAJANLAT_O + text );
            }

            while (rs.next()) {
                AllasajanlatCegesAdatokkal a = new AllasajanlatCegesAdatokkal();
                a.setID(rs.getInt("ID"));
                a.setCegnev(rs.getString("CEGNEV"));
                a.setVaros(rs.getString("VAROS"));
                a.setCim(rs.getString("CIM"));
                a.setOraber(rs.getInt("ORABER"));
                a.setPozicio(rs.getString("POZICIO"));
                a.setMunkakor(rs.getString("MUNKAKOR"));
                a.setLeiras(rs.getString("LEIRAS"));
                aList.add(a);

            }

            System.out.println("INFO: Sikeres lekérés (állásajánlat)");
        } catch (Exception e) {
            System.out.println("ERROR: Sikertelen lekérés (állásajánlat)");
            System.err.print(e);
            DatabaseDisconnect();
            return null;
        }
        DatabaseDisconnect();
        return aList;
    }


    public List<AllasajanlatCegesAdatokkal> getMAllasajanlatAll() {
        DatabaseConnect();
        List<AllasajanlatCegesAdatokkal> aList = new ArrayList<>();
        try{
            Connection conn = ods.getConnection(user,pass);
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(GET_MEGFELELO_ALLASAJANLAT);

            while (rs.next()) {
                AllasajanlatCegesAdatokkal a = new AllasajanlatCegesAdatokkal();
                a.setID(rs.getInt("ID"));
                a.setCegnev(rs.getString("CEGNEV"));
                a.setVaros(rs.getString("VAROS"));
                a.setCim(rs.getString("CIM"));
                a.setOraber(rs.getInt("ORABER"));
                a.setPozicio(rs.getString("POZICIO"));
                a.setMunkakor(rs.getString("MUNKAKOR"));
                a.setLeiras(rs.getString("LEIRAS"));

                aList.add(a);

            }

            System.out.println("INFO: Sikeres lekérés (állásajánlat)");
        } catch (Exception e) {
            System.out.println("ERROR: Sikertelen lekérés (állásajánlat)");
            System.err.print(e);
            DatabaseDisconnect();
            return null;
        }
        DatabaseDisconnect();
        return aList;
    }




    public void newAllasajanlat(Allasajanlat a) {
        DatabaseConnect();
        int id = 0;
        try {
            Connection conn = ods.getConnection(user,pass);
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(MAX_ID_ALLASAJANLAT);
            if (rs.next()) {
                id = rs.getInt(1);
                System.out.println("Max ID: " + id);
            }
            String str = String.valueOf(++id);
            rs = stmt.executeQuery(NEW_ALLASAJANLAT+str+","+a.getFelhasznalo_ID()+","+a.getOraber()+",'"+a.getPozicio()+"','"+a.getMunkakor()+"', DATE '"+a.getLetrehozas_ideje().toString()+"','"+a.getLeiras()+"')");
            System.out.println("INFO: Sikeres hozzáadás (állásajánlat)");
        }catch (SQLException sql){
            sql.printStackTrace();
            System.out.println("ERROR: Sikertelen hozzáadás (állásajánlat)");
        }
        DatabaseDisconnect();
    }

    public void deleteAllasajanlat(int ID) {
        DatabaseConnect();
        try(
                Connection c = ods.getConnection(user,pass);
                PreparedStatement stmt = c.prepareStatement(DELETE_ALLASAJANLAT+ID);
        ) {
//            stmt.setInt(1, felhasznalo.getID());
            stmt.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        DatabaseDisconnect();
    }

    public void applyAllasajanlat(int aid, int fid) {
        DatabaseConnect();
        int id = 0;
        try {
            Connection conn = ods.getConnection(user,pass);
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
//            rs = stmt.executeQuery(MAX_ID_ALLASAJANLAT);
//            if (rs.next()) {
//                id = rs.getInt(1);
//                System.out.println("Max ID: " + id);
//            }
//            String str = String.valueOf(++id);
            rs = stmt.executeQuery(NEW_JELENTKEZES+aid+","+fid+")");
            System.out.println("INFO: Sikeres hozzáadás (jelentkezes)");
        }catch (SQLException sql){
            sql.printStackTrace();
            System.out.println("ERROR: Sikertelen hozzáadás (jelentkezes)");
        }
        DatabaseDisconnect();
    }


    public List<JelentkezokMunkaltatonkent> getJelentkezok() {
        DatabaseConnect();
        List<JelentkezokMunkaltatonkent> jList = new ArrayList<>();
        try{
            Connection conn = ods.getConnection(user,pass);
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(GET_JELENTKEZOK);

            while (rs.next()) {
                JelentkezokMunkaltatonkent j = new JelentkezokMunkaltatonkent();
                j.setMID(felhasznalo.getID());
                j.setPozicio(rs.getString("POZICIO"));
                j.setMunkakor(rs.getString("MUNKAKOR"));
                j.setLeiras(rs.getString("LEIRAS"));
                j.setAllaskereso_teljes_nev(rs.getString("TELJES_NEV"));

                jList.add(j);
            }

            System.out.println("INFO: Sikeres lekérés (jelentkezes)");
        } catch (Exception e) {
            System.out.println("ERROR: Sikertelen lekérés (jelentkezes)");
            System.err.print(e);
            DatabaseDisconnect();
            return null;
        }
        DatabaseDisconnect();
        return jList;
    }


    public List<Jelentkezeseim> getJelentkezeseim() {
        DatabaseConnect();
        List<Jelentkezeseim> jList = new ArrayList<>();
        try{
            Connection conn = ods.getConnection(user,pass);
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(GET_JELENTKEZESEIM);

            while (rs.next()) {
                Jelentkezeseim j = new Jelentkezeseim();
                j.setAID(rs.getInt("ID"));
                j.setOraber(rs.getInt("ORABER"));
                j.setPozicio(rs.getString("POZICIO"));
                j.setMunkakor(rs.getString("MUNKAKOR"));
                j.setLeiras(rs.getString("LEIRAS"));


                jList.add(j);
            }

            System.out.println("INFO: Sikeres lekérés (jelentkezes)");
        } catch (Exception e) {
            System.out.println("ERROR: Sikertelen lekérés (jelentkezes)");
            System.err.print(e);
            DatabaseDisconnect();
            return null;
        }
        DatabaseDisconnect();
        return jList;
    }

    public void deleteJelentkezeseim(int AID) {
        DatabaseConnect();
        try(
                Connection c = ods.getConnection(user,pass);
                PreparedStatement stmt = c.prepareStatement(DELETE_JELENTKEZESEIM+AID+"AND FID="+felhasznalo.getID());
        ) {
//            stmt.setInt(1, felhasznalo.getID());
            stmt.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        DatabaseDisconnect();
    }

    public List<SzakmaStat> getStatSzakmaFelhasznalo() {
        DatabaseConnect();
        List<SzakmaStat> szList = new ArrayList<>();
        try{
            Connection conn = ods.getConnection(user,pass);
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(GET_STAT_SZAKMA_FELHASZNALO);

            CallableStatement cstmt = conn.prepareCall("begin ? := C##BH8ERI.szakmabeliekszama(?); end;");

            int szam=0;

            while(rs.next()){
                SzakmaStat sz = new SzakmaStat();
                sz.setSzakma(rs.getString("SZAKMA"));
                cstmt.registerOutParameter(1, Types.INTEGER);
                cstmt.setString(2, sz.getSzakma());
                cstmt.executeUpdate();
                szam = cstmt.getInt(1);
//                System.out.println("INFO: fv:"+ szam);
                sz.setFelhasznalok_szama(szam);
                szList.add(sz);
            }

            System.out.println("INFO: Sikeres lekérés (statszakma)");
        }catch(Exception e){
            System.out.println("ERROR: Sikertelen lekérés (statszakma)");
            System.err.print(e);
            DatabaseDisconnect();
            return null;
        }
        DatabaseDisconnect();
        return szList;
    }

    public List<KorStat> getStatKorFelhasznalo() {
        DatabaseConnect();
        List<KorStat> kList = new ArrayList<>();
        try{
            Connection conn = ods.getConnection(user,pass);
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(GET_STAT_KOR_FELHASZNALO);

            while(rs.next()){
                KorStat k = new KorStat();
                k.setAtlag_eletkor(rs.getFloat("atlageletkor"));
                k.setSzakma(rs.getString("SZAKMA"));
                kList.add(k);
            }

            System.out.println("INFO: Sikeres lekérés (statkor)");
        }catch(Exception e){
            System.out.println("ERROR: Sikertelen lekérés (statkor)");
            System.err.print(e);
            DatabaseDisconnect();
            return null;
        }
        DatabaseDisconnect();
        return kList;
    }


    public List<BerStat> getStatMinBer(String min) {
        DatabaseConnect();
        List<BerStat> bList = new ArrayList<>();
        try{
            Connection conn = ods.getConnection(user,pass);
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery("SELECT MIN("+GET_STAT_BER+"'"+min+"'"+"GROUP BY MUNKAKOR");

            while(rs.next()){
                BerStat b = new BerStat();
                b.setBer(rs.getInt("ber"));
                b.setMunkakor(rs.getString("MUNKAKOR"));
                bList.add(b);
            }

            System.out.println("INFO: Sikeres lekérés (statber)");
        }catch(Exception e){
            System.out.println("ERROR: Sikertelen lekérés (statber)");
            System.err.print(e);
            DatabaseDisconnect();
            return null;
        }
        DatabaseDisconnect();
        return bList;
    }

    public List<BerStat> getStatMaxBer(String max) {
        DatabaseConnect();
        List<BerStat> bList = new ArrayList<>();
        try{
            Connection conn = ods.getConnection(user,pass);
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery("SELECT MAX("+GET_STAT_BER+"'"+max+"'"+"GROUP BY MUNKAKOR");

            while(rs.next()){
                BerStat b = new BerStat();
                b.setBer(rs.getInt("ber"));
                b.setMunkakor(rs.getString("MUNKAKOR"));
                bList.add(b);
            }

            System.out.println("INFO: Sikeres lekérés (statber)");
        }catch(Exception e){
            System.out.println("ERROR: Sikertelen lekérés (statber)");
            System.err.print(e);
            DatabaseDisconnect();
            return null;
        }
        DatabaseDisconnect();
        return bList;
    }

    public List<JelentkezokStat> getJelentkezokStat() {
        DatabaseConnect();
        List<JelentkezokStat> jList = new ArrayList<>();
        try{
            Connection conn = ods.getConnection(user,pass);
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(GET_STAT_JELENTKEZOK);

            while(rs.next()){
                JelentkezokStat j = new JelentkezokStat();
                j.setPozicio(rs.getString("POZICIO"));
                j.setJelentkezok_szama(rs.getInt("jelentkezok_szama"));
                jList.add(j);
            }

            System.out.println("INFO: Sikeres lekérés (statber)");
        }catch(Exception e){
            System.out.println("ERROR: Sikertelen lekérés (statber)");
            System.err.print(e);
            DatabaseDisconnect();
            return null;
        }
        DatabaseDisconnect();
        return jList;
    }

    public List<AllasajanlatCegesAdatokkal> getAtlagonFeluliAllasajanlat() {
        DatabaseConnect();
        List<AllasajanlatCegesAdatokkal> aList = new ArrayList<>();
        try{
            Connection conn = ods.getConnection(user,pass);
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(GET_ATLAGON_FELULI_ALLASAJANLAT);

            while (rs.next()) {
                AllasajanlatCegesAdatokkal a = new AllasajanlatCegesAdatokkal();
                a.setID(rs.getInt("ID"));
                a.setCegnev(rs.getString("CEGNEV"));
                a.setVaros(rs.getString("VAROS"));
                a.setCim(rs.getString("CIM"));
                a.setOraber(rs.getInt("ORABER"));
                a.setPozicio(rs.getString("POZICIO"));
                a.setMunkakor(rs.getString("MUNKAKOR"));
                a.setLeiras(rs.getString("LEIRAS"));

                aList.add(a);

            }

            System.out.println("INFO: Sikeres lekérés (állásajánlat)");
        } catch (Exception e) {
            System.out.println("ERROR: Sikertelen lekérés (állásajánlat)");
            System.err.print(e);
            DatabaseDisconnect();
            return null;
        }
        DatabaseDisconnect();
        return aList;
    }
    
}
