package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
    private static Connection connection;

    public static Connection getConnection(){
        if(connection == null){
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/curdweb","root","i2coheCLo");

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return connection;
    }
}
