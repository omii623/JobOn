package hu.jobon.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import hu.jobon.tables.Munkaltato;
import hu.jobon.user.User;
import oracle.jdbc.pool.OracleDataSource;

public class Database {
    ResultSet rs;
    Statement stmt;
    OracleDataSource ods;
    String user = User.userName;
    String pass = User.userPass;

    //private final String GET_MUNKALTATO = "SELECT * FROM C##SAELDC.FELHASZNALO";
    private final String GET_MUNKALTATO = "SELECT * FROM C##SAELDC.MUNKALTATO, C##SAELDC.FELHASZNALO";

    public Database(){
        try{
            ods = new OracleDataSource();
            Class.forName("oracle.jdbc.OracleDriver");
            ods.setURL("jdbc:oracle:thin:@localhost:1521:orania2");
            System.out.println("INFO: Sikeres csatlakozás");
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

    public List<Munkaltato> getMunkaltato(){
        List<Munkaltato> mList = new ArrayList<>();
        try{
            Connection conn = ods.getConnection(user,pass);
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(GET_MUNKALTATO);

            while(rs.next()){
                Munkaltato m = new Munkaltato();
                m.setEmail_cim(rs.getString("EMAIL_CIM"));
                m.setJelszo(rs.getString("JELSZO"));
                ////m.setTi(rs.getInt("TIPUS")); alapból be van állitva
                //m.setID(rs.getInt("ID"));
                //m.setCegnev(rs.getString("CEGNEV"));
                //m.setTelefonszam(rs.getString("TELEFONSZAM"));
                //m.setEmail_cim_hivatalos(rs.getString("EMAIL_CIM_HIVATALOS"));
                ////m.setMegalapitas_eve(rs.getString("MEGALAPITAS_EVE"));//nem bitos hogy jó
                //m.setVaros(rs.getString("VAROS"));
                //m.setCim(rs.getString("CIM"));

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
 
}
