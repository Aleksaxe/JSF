package sample;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
// контроллер связующий GUI
public class Controller {

    public  String sqlAllSearch = "select * from users";
    Connection con = DBWorker.getConnection();//Коннект к БД
    Statement statement = con.createStatement();
    // Инициализация кнопок интервейса
    @FXML
    private TableView<User> table;

    @FXML
    private TableColumn<User, Integer> idColum;

    @FXML
    private TableColumn<User, String> nameColum;

    public Controller() throws SQLException, ClassNotFoundException {
    }

    public String getTextField() {
        String s = (String) textField.getText();
        return s;
    }

    @FXML
    private TextField textField;

    @FXML
    private Button addButton;

    @FXML
    private Button searchButton;


    ObservableList<User> observableList = FXCollections.observableArrayList();


    @FXML
    void initialize() throws SQLException, ClassNotFoundException {
        search(sqlAllSearch);
        idColum.setCellValueFactory(new PropertyValueFactory<>("ID"));
        nameColum.setCellValueFactory(new PropertyValueFactory<>("Name"));
        table.setItems(observableList);

        addButton.setOnAction(event -> {
            String sqlInsert = "insert into users (Name) value ('" + getTextField() + "')";
            try {
                refreshAndAdd(sqlInsert);
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        });

        searchButton.setOnAction(event -> {
            String sqlSearch = "select * from users where Name='" + getTextField() + "'";
            try {
                search(sqlSearch);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
    }
//Метод обновляющий tableView при любом действии \старте программы
    void refreshAndAdd(String s) throws SQLException, ClassNotFoundException {
    observableList.clear();
        String someSql=s;
        try {

            statement.execute(someSql);
            con.createStatement().executeQuery(sqlAllSearch);
            observableList.clear();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        search(sqlAllSearch);
    }
    void search(String s) throws SQLException {
        observableList.clear();
        String someSql=s;
        ResultSet[] resultSet = {con.createStatement().executeQuery(someSql)};
        while (resultSet[0].next()) {
            observableList.add(new User(resultSet[0].getString("ID"),
                    resultSet[0].getString("Name")));
        }
    }


}

