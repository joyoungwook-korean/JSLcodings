package project_A_0805.DB_Connection.db.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySqlDBManager implements DBManager{
    @Override
    public Connection getConnection() {
        Connection connection = null;
        String myDriver="com.mysql.jdbc.Driver";
        String myUrl="jdbc:mysql://localhost:3306/track2_4";
        String myId="track2_4";
        String myPassword="1234";
        try{
            Class.forName(myDriver);
            connection = DriverManager.getConnection(myUrl,myId,myPassword);
        }catch (Exception e){
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public Connection getConnection(String db, String id, String pw) {
        Connection connection = null;
        String myDriver="com.mysql.jdbc.Driver";
        String myUrl="jdbc:mysql://localhost:3306/"+db;
        String myId=id;
        String myPassword=pw;
        try{
            Class.forName(myDriver);
            connection = DriverManager.getConnection(myUrl,myId,myPassword);
        }catch (Exception e){
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public Connection getConnection(String id, String pw) {
        Connection connection = null;
        String myDriver="com.mysql.jdbc.Driver";
        String myUrl="jdbc:mysql://localhost:3306/track2_4";
        String myId=id;
        String myPassword=pw;
        try{
            Class.forName(myDriver);
            connection = DriverManager.getConnection(myUrl,myId,myPassword);
        }catch (Exception e){
            e.printStackTrace();
        }
        return connection;
    }
}
