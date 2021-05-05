package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.Controller.StageFactory;
import sample.Model.*;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        StageFactory stageFactory = new StageFactory("mainPage");
        stageFactory.changeView();
        StaffList.addNewEmployee(new Chef("adham", "adham", 1234));
        StaffList.addNewEmployee(new Waiter("adham", "adham", 1234));
        FoodList.addNewFood(new Food("Burger", "Meat", 12));
        FoodList.addNewFood(new Food("Pizza", "Italy pizza", 14));
        FoodList.addNewFood(new Food("Fried Chekein", "Cook", 16));
    }


    public static void main(String[] args) {
        launch(args);
    }
}
