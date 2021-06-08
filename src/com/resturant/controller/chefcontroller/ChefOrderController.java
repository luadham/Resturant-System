package com.resturant.controller.chefcontroller;

import com.resturant.controller.ErrorPage;
import com.resturant.controller.factory.StageFactory;
import com.resturant.model.Booking;
import com.resturant.model.BookingList;
import com.resturant.model.Table;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.text.Font;

import javax.imageio.IIOException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;


public class ChefOrderController {
    @FXML private FlowPane flowPane;
    @FXML private Button homePageButton;
    private final BookingList bookingList = BookingList.getBookingList();
    private final ArrayList<Booking> bookings = bookingList.getBookingsList();
    private static int buttonNumber;
    private ArrayList<Pane> paneArrayList = new ArrayList<>();

    @FXML
    private void initialize() {
        for (Booking booking : bookings) {
            Pane orderCard = generateOrderCard(
                    booking.getBookId(),
                    booking.getTable().getTableNumber(),
                    booking.getTable().getOrder().getFoodName(),
                    booking.getTable().getOrder().getOrderQuantity()
            );
            paneArrayList.add(orderCard);
            flowPane.getChildren().add(orderCard);
        }
    }

    @FXML
    private void goHomePage() {
        try {
            StageFactory stageFactory = new StageFactory(homePageButton);
            stageFactory.getView();
        } catch (IOException ex) {
            ErrorPage errorPage = new ErrorPage();
            errorPage.showErrorPage();
        }
    }
    private Pane generateOrderCard(int orderId, int tableNumberid, String foodName, int qunatity) {
        Pane pane = new Pane();
        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        Label orderIdLabel = new Label("Order ID: " + String.valueOf(orderId));
        Label tableNumberLabel = new Label("Table Number: " + String.valueOf(tableNumberid));
        Label foodNameLabel = new Label("Order: " + foodName);
        Label quantityLabel = new Label("Quantity: " + String.valueOf(qunatity));
        Button doneButton = new Button("Done");
        doneButton.setId(buttonNumber++ + "");
        doneButton.setStyle("-fx-background-color: #ed4d4f; -fx-text-fill: #fff; -fx-font-size: 18");
        vBox.getChildren().addAll(orderIdLabel, tableNumberLabel, foodNameLabel, quantityLabel, doneButton);
        doLabelStyle(orderIdLabel, tableNumberLabel, foodNameLabel, quantityLabel);
        pane.getChildren().add(vBox);
        doneButton.setOnAction(e -> {
            flowPane.getChildren().remove(paneArrayList.get(Integer.parseInt(doneButton.getId())));
        });
        return pane;
    }
    private void doLabelStyle(Label... labels) {
        for (Label label : labels) {
            label.setStyle("-fx-label-padding: 4; -fx-font-size: 14");
        }
    }


    private boolean haveOrders() {
        return !bookings.isEmpty();
    }

}
