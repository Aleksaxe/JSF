package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.sql.SQLException;
import java.sql.Statement;

public class Main extends Application {

    public static TableView<User> table = new TableView<User>();
    private final ObservableList<User> data =
            FXCollections.observableArrayList(
                    new User(1, "Smith")

            );

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        launch(args);
        String query="select * from users ;";
        DBWorker dbWorker=new DBWorker(query);


    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("CDEK");
        primaryStage.setScene(new Scene(root, 351, 426));
        primaryStage.show();
        //table.setEditable(true);
        TableColumn idColumn=new TableColumn("ID");
        idColumn.setCellFactory(new PropertyValueFactory<User,String>("ID"));

        TableColumn nameColumn=new TableColumn("Name");
        nameColumn.setCellFactory(new PropertyValueFactory<User,String>("Name"));
        table.setItems(data);


    }



}
