package sample;

import java.sql.*;

//Связь с БД
public class DBWorker {

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        ConData conData = new ConData();//Экземпялр Модели хранения данных для подключения к БД

        // Коннектор соеденящий программу и базу
        Connection connection = DriverManager.getConnection(conData.getURL(),
                conData.getUSERNAME(), conData.getPASSWORD());

        if (!connection.isClosed()) System.out.println("It's alive");//Проверка установки соединения

        return connection;
    }

}
