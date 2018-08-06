package sample;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    public void setIdColum(TableColumn<?, ?> idColum) {
        this.idColum = idColum;
    }

    public void setNameColum(TableColumn<?, ?> nameColum) {
        this.nameColum = nameColum;
    }

    @FXML
    private TableColumn<?, ?> idColum;

    @FXML
    private TableColumn<?, ?> nameColum;

    @FXML
    private TextField textField;

    @FXML
    private Button addButton;

    @FXML
    private Button searchButton;

    @FXML
    void initialize() {
        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                data.add(new User(
                        idColum.getText(),
                        nameColum.getText(),


            }
        });

    }

    public void setIdColum(int i, int id) {
    }

    public void setNameColum(int id, String name) {
    }

}

