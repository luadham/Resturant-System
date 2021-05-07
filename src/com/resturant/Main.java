package com.resturant;

import com.resturant.model.*;
import javafx.application.Application;
import javafx.stage.Stage;
import com.resturant.controller.factory.StageFactory;

import java.util.ArrayList;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        StageFactory stageFactory = new StageFactory("mainPage");
        stageFactory.getView();
    }


    public static void main(String[] args) {
        RMS rms = new RMS();
        rms.createSystem();

        launch(args);
    }
}
