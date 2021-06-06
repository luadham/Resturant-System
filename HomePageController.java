package com.resturant.controller;

import com.resturant.controller.factory.StageFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.stage.Stage;

import java.io.IOException;

public class HomePageController {
    @FXML
    private void handleButtonAction(ActionEvent event) {
        Button clickedButton = (Button) event.getSource();
        try {
            StageFactory stageFactory = new StageFactory(clickedButton);
            stageFactory.getView();
        } catch (IOException e) {
            ErrorPage errorPage = new ErrorPage();
            errorPage.showErrorPage();
        }
    }
    @FXML
    private void handleHyperLinkAction (ActionEvent event){
        Hyperlink link = (Hyperlink) event.getSource();
        try{
            StageFactory stageFactory = new StageFactory(link);
            stageFactory.getView();
        } catch (IOException e) {
            ErrorPage errorPage = new ErrorPage();
            errorPage.showErrorPage();
        }
    }
}
