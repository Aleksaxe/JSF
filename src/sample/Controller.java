package sample;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

// контроллер связующий GUI
public class Controller {

    public String sqlAllSearch = "select * from users";
    Connection con = DBWorker.getConnection();//Коннект к БД
    Statement statement = con.createStatement();//опеределяем контейнер для sql выражений
    //Коллекция для хранения данных из БД
    ObservableList<User> observableList = FXCollections.observableArrayList();//специальная javaFX коллекция

    // Инициализация кнопок интервейса
    @FXML
    private TableView<User> table;

    @FXML
    private TableColumn<User, Integer> idColum;

    @FXML
    private TableColumn<User, String> nameColum;

    @FXML
    //Поле для добавления и поиска данных
    private TextField textField;

    @FXML
    private Button addButton;

    @FXML
    private Button searchButton;

    public Controller() throws SQLException, ClassNotFoundException {
    }

    public String getTextField() {//метод забирающий строку поля ввода TextField
        String s = (String) textField.getText();
        return s;
    }
    public void setTextField() {
        textField.setText("");
    }

    @FXML
    void initialize() throws SQLException, ClassNotFoundException {
        search(sqlAllSearch);//Вывести все данные
        //Способ отображения данных в ячейках таблицы
        idColum.setCellValueFactory(new PropertyValueFactory<>("ID"));
        nameColum.setCellValueFactory(new PropertyValueFactory<>("Name"));
        //передать экземпляр в таблицу
        table.setItems(observableList);

        addButton.setOnAction(event -> {
            if(getTextField().equals("")) {

            }else {
                String sqlInsert = "insert into users (Name) value ('" + getTextField() + "')";
                try {
                    refreshAndAdd(sqlInsert);
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
            setTextField();//очистка TextField После каждого ввода


        });

        searchButton.setOnAction(event -> {
            if (getTextField().equals("")){
                try {
                    search(sqlAllSearch);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            else {
                String sqlSearch = "select * from users where Name='" + getTextField() + "'";
                try {
                    search(sqlSearch);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
    }


    void refreshAndAdd(String s) throws SQLException, ClassNotFoundException {
        String someSql = s;
        try {

            statement.execute(someSql);//sql запрос на добавление
            con.createStatement().executeQuery(sqlAllSearch);//запрос на вывод таблицы

        } catch (SQLException e) {
            e.printStackTrace();
        }

        search(sqlAllSearch);// вывод обновленной таблицы
    }

    void search(String s) throws SQLException {
        observableList.clear();//очистка таблицы перед выводом обновленной таблицы
        String someSql = s;
        ResultSet[] resultSet = {con.createStatement().executeQuery(someSql)};

        while (resultSet[0].next()) {
            observableList.add(new User(resultSet[0].getString("ID"),
                    resultSet[0].getString("Name")));
        }
    }


}

