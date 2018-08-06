package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import javax.swing.text.TabableView;
import java.sql.*;
import java.util.Observer;

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
