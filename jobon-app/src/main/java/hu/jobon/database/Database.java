package hu.jobon.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import hu.jobon.user.User;
import oracle.jdbc.pool.OracleDataSource;

public class Database {
    ResultSet rs;
    Statement stmt;
    OracleDataSource ods;
    String user = User.userName;
    String pass = User.userPass;

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
 
}
