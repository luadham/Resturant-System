package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("View/LoginPortalView.fxml"));
        primaryStage.setTitle("Resturant System");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        Stage stage = new Stage();
        Parent toor = FXMLLoader.load(getClass().getResource("View/ManagerView/ManagerHomeView.fxml"));
        stage.setScene(new Scene(toor));
        stage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
