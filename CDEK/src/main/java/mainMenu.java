import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class mainMenu extends Application {
    public static Button addUserMenu;
    public static Button searchMenu;
    Scene scene1,scene2;
    public static Button add;
    public static Label label;
    public static TextField textField;
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("CDEK test");
        addUserMenu =new Button("Добавить пользователя");
        searchMenu =new Button("Вывести список");
        HBox hBox1=new HBox(10);
        hBox1.getChildren().add(addUserMenu);
        hBox1.getChildren().add(searchMenu);
        scene1=new Scene(hBox1,400,400);
        primaryStage.setScene(scene1);
        primaryStage.show();
        addUserMenu.setOnAction(e->primaryStage.setScene(scene2));



        HBox hBox2 = new HBox(10);
        scene2=new Scene(hBox2,400,400);
        add = new Button("Добавить пользователя");
        label=new Label("Введите имя");
        textField=new TextField();
        hBox2.getChildren().addAll(textField,label,add);

    }

}
