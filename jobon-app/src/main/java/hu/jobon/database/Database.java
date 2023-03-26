package hu.jobon.database;

import hu.jobon.database.model.Munkaltato;
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

    public List<Munkaltato> getMunkaltatoAll(){
        List<Munkaltato> mList = new ArrayList<>();
        try{
            Connection conn = ods.getConnection(user,pass);
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(GET_MUNKALTATO);

            while(rs.next()){
                Munkaltato m = new Munkaltato();
                m.setEmail_cim(rs.getString("EMAIL_CIM"));
                m.setJelszo(rs.getString("JELSZO"));
                m.setID(rs.getInt("ID"));
                m.setCegnev(rs.getString("CEGNEV"));
                m.setTelefonszam(rs.getString("TELEFONSZAM"));
                //m.setEmail_cim_hivatalos(rs.getString("EMAIL_CIM_HIVATALOS"));
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
}
