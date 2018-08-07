package sample;

import java.sql.*;

public class DBWorker {
   // private final String sqlState;

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        ConData conData = new ConData();
        Connection connection = DriverManager.getConnection(conData.getURL(), conData.getUSERNAME(), conData.getPASSWORD());
        if (!connection.isClosed()) System.out.println("FUCK");

        return connection;
    }
/*
    public DBWorker(String sqlState) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");

    }
*/

}
