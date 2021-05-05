package com.resturant.controller.managercontroller.factory;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

import java.io.IOException;

/**
 * The type Bane factory.
 * @author Adham Adel
 */
public class PaneFactory implements IPane {
    private Pane pane;

    /**
     * Instantiates a new Bane factory.
     *
     * @param viewName the view name
     * @throws IOException the io exception
     * @modifies pane
     */
    public PaneFactory(String viewName) throws IOException {
        switch (viewName) {
            case "viewSalesButton":
                pane = FXMLLoader.load(getClass().getResource("../../../view/managerview/SalesView.fxml"));
                break;
            case "manageFoodButton":
                pane = FXMLLoader.load(getClass().getResource("../../../view/managerview/ManagerFoodView.fxml"));
                break;
            case "manageStaffButton":
                pane = FXMLLoader.load(getClass().getResource("../../../view/managerview/ManagerStaffView.fxml"));
                break;
            default:
                System.out.println("View Cannot Found!");
                break;
        }
    }

    @Override
    public void getManagerPane(Pane pane) {
        pane.getChildren().clear();
        pane.getChildren().addAll(this.pane);
    }
}
