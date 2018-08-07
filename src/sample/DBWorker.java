package sample;

import java.sql.*;

public class DBWorker {
    private final String sqlState;


    public DBWorker(String sqlState) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        ConData conData=new ConData();
        Connection connection=DriverManager.getConnection(conData.getURL(),conData.getUSERNAME(),conData.getPASSWORD());
        if (!connection.isClosed()) System.out.println("FUCK");
        Statement statement=connection.createStatement();
        this.sqlState=sqlState;
        ResultSet resultSet=statement.executeQuery(sqlState);

        while (resultSet.next()){//next возврщает тру если есть след элемент
            int ID=resultSet.getInt("id");
            String Name=resultSet.getString("name");
            Controller controller=new Controller();


        }


        statement.close();
        connection.close();
    }


}
