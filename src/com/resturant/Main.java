package com.resturant;

import com.resturant.model.*;
import javafx.application.Application;
import javafx.stage.Stage;
import com.resturant.controller.factory.StageFactory;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        StageFactory stageFactory = new StageFactory("mainPage");
        stageFactory.getView();
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
