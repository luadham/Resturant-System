package com.resturant.controller.managercontroller;

import com.resturant.model.Booking;
import com.resturant.model.BookingList;
import com.resturant.model.Invoice;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.util.ArrayList;

public class ManagerSalesController {
    @FXML Label totalSales;
    private final BookingList bookingList = BookingList.getBookingList();
    private final ArrayList<Booking> bookings = bookingList.getBookingsList();
    private double totalPrice = 0;

    @FXML
    private void initialize() {
        for (Booking booking : bookings) {
            Invoice invoice = new Invoice(booking);
            totalPrice += invoice.getOverallPrice();
        }
        totalSales.setText("Total Income: " + String.valueOf(totalPrice) + " $");
    }

}
