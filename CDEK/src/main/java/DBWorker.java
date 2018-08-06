import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBWorker {

    public DBWorker(){

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        ConData conData=new ConData();
        // Driver driver=DriverManager.getDriver(conData.getCLASSFORNAME());
        //Connection connection= null;
        try (Connection connection =
                     DriverManager.getConnection(conData.getURL(),conData.getUSERNAME(),conData.getPASSWORD());
             Statement statement=connection.createStatement()
        ){
            if (!connection.isClosed()) System.out.println("success");
            statement.execute("insert into users (name, age, email) values ('Tes', 12, 't12@yandex.ru');");
           // statement.executeUpdate("UPDATE users set name='valenok' where id=2");
            //statement.execute("select * from users");


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
