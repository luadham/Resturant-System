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
    @FXML Label totalSales;
    private final BookingList bookingList = BookingList.getBookingList();
    private final ArrayList<Booking> bookings = bookingList.getBookingsList();
    private double totPrice = 0;

    @FXML
    private void initialize() {
        for (Booking booking : bookings) {
            Invoice invoice = new Invoice(booking);
            totPrice += invoice.getOverallPrice();
            totalSales.setText(String.valueOf(totPrice));
        }
    }

}
