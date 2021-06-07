package com.resturant.controller.managercontroller;

import com.resturant.model.Booking;
import com.resturant.model.BookingList;
import com.resturant.model.Invoice;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import java.util.ArrayList;

public class ManagerSalesController {

    @FXML
    private HBox hbox;
    private final BookingList bookingList = BookingList.getBookingList();
    private final ArrayList<Booking> bookings = bookingList.getBookingsList();
    private Invoice invoice;
    private double totPrice = 0;

    @FXML
    private void initialize() {
        for (Booking booking : bookings) {
            hbox = new HBox();
            FlowPane flowPane = new FlowPane();
            invoice = new Invoice(booking);
            totPrice += invoice.getOverallPrice();
            flowPane.getChildren().add(generateOrderCard(
                    booking.getBookId(),
                    invoice.getOverallPrice()
            ));
            Label totPriceLabel = new Label("Total Income: $" + totPrice);
            totPriceLabel.setAlignment(Pos.CENTER);
            hbox.getChildren().addAll(flowPane, totPriceLabel);
        }
    }

    private Pane generateOrderCard(int orderId, double price) {
        Pane pane = new Pane();
        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        Label orderIdLabel = new Label("Order ID: " + String.valueOf(orderId));
        Label priceLabel = new Label("Price: $" + price);
        vBox.getChildren().addAll(orderIdLabel, priceLabel);
        doLabelStyle(orderIdLabel, priceLabel);
        pane.getChildren().add(vBox);
        return pane;
    }

    private void doLabelStyle(Label... labels) {
        for (Label label : labels) {
            label.setStyle("-fx-label-padding: 4; -fx-font-size: 14");
        }
    }
}
