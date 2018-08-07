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

public class Controller {


    @FXML
    private TableView<User> table;

    @FXML
    private TableColumn<User, Integer> idColum;

    @FXML
    private TableColumn<User, String> nameColum;

    public String getTextField() {

        return textField.getText();
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
        Connection con = DBWorker.getConnection();
        addButton.setOnAction(event -> {
            String sqlInsert="insert into users (Name) value ('"+getTextField()+"')";
            try {
                Statement statement = con.createStatement();
                statement.execute(sqlInsert);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            // System.out.println(getTextField());Проверка отработавшего getTextField
        });



            String sqlSearch="select from users where Name='name'";
        ResultSet resultSet = con.createStatement().executeQuery(sqlSearch);
        while (resultSet.next()) {
            observableList.add(new User(resultSet.getString("ID"), resultSet.getString("Name")));
        }
        idColum.setCellValueFactory(new PropertyValueFactory<>("ID"));
        nameColum.setCellValueFactory(new PropertyValueFactory<>("Name"));
        table.setItems(observableList);
    }


}

