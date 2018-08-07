package sample;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;



    @FXML
    private TableColumn<User, Integer> idColum;

    @FXML
    private TableColumn<User,String> nameColum;

    @FXML
    private TextField textField;

    @FXML
    private Button addButton;

    @FXML
    private Button searchButton;


    ObservableList<User> observableList=FXCollections.observableArrayList();
    @FXML
    void initialize() {
        idColum.setCellValueFactory(new PropertyValueFactory<>("ID"));
        nameColum.setCellValueFactory(new PropertyValueFactory<>("Name"));

    }



}

