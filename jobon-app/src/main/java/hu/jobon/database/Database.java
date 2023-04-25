package hu.jobon.database;

import hu.jobon.database.model.Allasajanlat;
import hu.jobon.database.model.Allaskereso;
import hu.jobon.database.model.Felhasznalo;
import hu.jobon.database.model.Munkaltato;
import hu.jobon.database.model.*;
import hu.jobon.database.servicemodel.Jelentkezeseim;
import hu.jobon.database.servicemodel.JelentkezokMunkaltatonkent;
import hu.jobon.database.servicemodel.SzakmaStat;
import hu.jobon.user.User;
import oracle.jdbc.pool.OracleDataSource;

import java.sql.*;
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

    private final String GET_MUNKALTATO = "SELECT * FROM C##SAELDC.MUNKALTATO, C##SAELDC.FELHASZNALO WHERE C##SAELDC.MUNKALTATO.ID = C##SAELDC.FELHASZNALO.ID";
    private final String GET_ALLASKERESO = "SELECT * FROM C##SAELDC.ALLASKERESO, C##SAELDC.FELHASZNALO WHERE C##SAELDC.ALLASKERESO.ID = C##SAELDC.FELHASZNALO.ID";
    private final String GET_FELHASZNALO = "SELECT * FROM C##SAELDC.FELHASZNALO";
    private final String GET_ALLASAJANLAT = "SELECT * FROM C##SAELDC.ALLASAJANLAT WHERE CURRENT_DATE-LETREHOZAS_IDEJE<30";
//    private final String GET_JELENTKEZOK = "SELECT C##SAELDC.ALLASKERESO.TELJES_NEV, C##SAELDC.ALLASAJANLAT.ID FROM C##SAELDC.JELENTKEZES, C##SAELDC.ALLASAJANLAT, C##SAELDC.ALLASKERESO WHERE C##SAELDC.JELENTKEZES.FID=C##SAELDC.ALLASKERESO.ID AND C##SAELDC.ALLASAJANLAT.ID=C##SAELDC.JELENTKEZES.AID AND C##SAELDC.ALLASAJANLAT.FID= "+felhasznalo.getID()+"";
    private final String GET_JELENTKEZOK = "SELECT  C##SAELDC.ALLASAJANLAT.ID, POZICIO, MUNKAKOR, LEIRAS, C##SAELDC.ALLASKERESO.TELJES_NEV FROM C##SAELDC.JELENTKEZES, C##SAELDC.ALLASAJANLAT, C##SAELDC.ALLASKERESO WHERE C##SAELDC.JELENTKEZES.FID=C##SAELDC.ALLASKERESO.ID AND C##SAELDC.ALLASAJANLAT.ID=C##SAELDC.JELENTKEZES.AID AND C##SAELDC.ALLASAJANLAT.FID= "+felhasznalo.getID()+"";
    private final String GET_JELENTKEZESEIM = "SELECT  C##SAELDC.ALLASAJANLAT.ID, ORABER, POZICIO, MUNKAKOR, LEIRAS FROM C##SAELDC.JELENTKEZES, C##SAELDC.ALLASAJANLAT, C##SAELDC.ALLASKERESO WHERE C##SAELDC.JELENTKEZES.FID=C##SAELDC.ALLASKERESO.ID AND C##SAELDC.ALLASAJANLAT.ID=C##SAELDC.JELENTKEZES.AID AND C##SAELDC.JELENTKEZES.FID= "+felhasznalo.getID()+"";
    private final String REGIST_USER = "INSERT INTO C##SAELDC.FELHASZNALO (ID,EMAIL_CIM,JELSZO,TIPUS) VALUES (";
    private final String NEW_ALLASAJANLAT = "INSERT INTO C##SAELDC.ALLASAJANLAT (ID,FID,ORABER,POZICIO,MUNKAKOR,LETREHOZAS_IDEJE, LEIRAS) VALUES (";
    private final String NEW_JELENTKEZES = "INSERT INTO C##SAELDC.JELENTKEZES (AID,FID) VALUES (";
    private final String REGIST_MUNKALTATO = "INSERT INTO C##SAELDC.MUNKALTATO (ID,CEGNEV,TELEFONSZAM,EMAIL_CIM_HIVATALOS,MEGALAPITAS_EVE,VAROS,CIM) VALUES (";
    private final String REGIST_ALLASKERESO = "INSERT INTO C##SAELDC.ALLASKERESO (ID,TELJES_NEV,SZULETESI_DATUM,VAROS,CIM,UTOLSO_BELEPES) VALUES (";
    private final String MAX_ID_FELHASZNALO = "SELECT MAX(ID) FROM C##SAELDC.FELHASZNALO";
    private final String MAX_ID_ALLASAJANLAT = "SELECT MAX(ID) FROM C##SAELDC.ALLASAJANLAT";
    private final String GET_MEGFELELO_ALLASAJANLAT = "SELECT * FROM C##SAELDC.ALLASAJANLAT, C##SAELDC.MUNKALTATO, C##SAELDC.SZAKMA WHERE C##SAELDC.ALLASAJANLAT.FID=C##SAELDC.MUNKALTATO.ID AND "+felhasznalo.getID()+"=C##SAELDC.SZAKMA.FID AND MUNKAKOR=SZAKMA";
    private final String GET_STAT_SZAKMA_FELHASZNALO = "SELECT SZAKMA FROM C##SAELDC.ALLASKERESO, C##SAELDC.SZAKMA WHERE ALLASKERESO.ID=SZAKMA.FID GROUP BY SZAKMA";
    private final String DELETE_FELHASZNALO = "DELETE FROM C##SAELDC.FELHASZNALO, C##SAELDC.ALLASKERESO, C##SAELDC.MUNKALTATO WHERE C##SAELDC.MUNKALTATO.ID = C##SAELDC.FELHASZNALO.ID AND C##SAELDC.ALLASKERESO.ID = C##SAELDC.FELHASZNALO.ID AND ID="; //itt a baj
    private final String DELETE_ALLASAJANLAT = "DELETE FROM C##SAELDC.ALLASAJANLAT WHERE ID=";
    private final String DELETE_JELENTKEZESEIM = "DELETE FROM C##SAELDC.JELENTKEZES WHERE AID=";


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

            System.out.println("INFO: Sikeres lekérés (munkáltató)");
        }catch(SQLException e){
            System.err.print(e);
            System.out.println("INFO: Sikeres lekérés (munkáltató)");
        } catch(Exception e){
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

    public void deleteFelhasznalo(Felhasznalo f) {
           try(
           Connection c = ods.getConnection(user,pass);
           PreparedStatement stmt = c.prepareStatement(DELETE_FELHASZNALO+f.getID());
        ) {
//            stmt.setInt(1, felhasznalo.getID());
            stmt.executeUpdate();

               System.out.println("INFO: Sikeres delete (allasajanlat)"+f.getID());
        } catch (SQLException throwables) {
               System.out.println("ERROR: Sikertelen delete (allasajanlat)"+f.getID());
            throwables.printStackTrace();
        }
    }

    public List<Allasajanlat> getAllasajanlataim(String GET_ALLASAJANLATAIM) {
        List<Allasajanlat> aList = new ArrayList<>();
        try {
            Connection conn = ods.getConnection(user, pass);
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
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
            return null;
        }
        return aList;
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

    public List<Allasajanlat> getMAllasajanlatAll() {
        List<Allasajanlat> aList = new ArrayList<>();
        try{
            Connection conn = ods.getConnection(user,pass);
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(GET_MEGFELELO_ALLASAJANLAT);

            while (rs.next()) {
                Allasajanlat a = new Allasajanlat();
                a.setID((rs.getInt("ID")));
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

    public List<SzakmaStat> getStatSzakmaFelhasznalo() {
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

            System.out.println("INFO: Sikeres lekérés (állásajánlat)");
        }catch(Exception e){
            System.out.println("ERROR: Sikertelen lekérés (állásajánlat)");
            System.err.print(e);
            return null;
        }
        return szList;
    }

    public void newAllasajanlat(Allasajanlat a) {
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

    }

    public void deleteAllasajanlat(int ID) {
        try(
                Connection c = ods.getConnection(user,pass);
                PreparedStatement stmt = c.prepareStatement(DELETE_ALLASAJANLAT+ID);
        ) {
//            stmt.setInt(1, felhasznalo.getID());
            stmt.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public List<JelentkezokMunkaltatonkent> getJelentkezok() {
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
            return null;
        }
        return jList;
    }


    public void applyAllasajanlat(int aid, int fid) {
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
    }

    public List<Jelentkezeseim> getJelentkezeseim() {
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
            return null;
        }
        return jList;
    }

    public void deleteJelentkezeseim(int AID) {
        try(
                Connection c = ods.getConnection(user,pass);
                PreparedStatement stmt = c.prepareStatement(DELETE_JELENTKEZESEIM+AID+"AND FID="+felhasznalo.getID());
        ) {
//            stmt.setInt(1, felhasznalo.getID());
            stmt.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
