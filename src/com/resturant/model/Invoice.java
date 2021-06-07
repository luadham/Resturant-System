package com.resturant.model;

import java.util.ArrayList;

public class Invoice implements IInvoice {
    private final Booking booking;

    public Invoice(Booking booking) {
        this.booking = booking;
    }

    @Override
    public double getOverallPrice() {
       int quantity = booking.getTable().getOrder().getOrderQuantity();
       String foodName = booking.getTable().getOrder().getFoodName();
       double foodPrice = FoodList.getFoodList().getFoodByName(foodName).getPrice();
       return quantity * foodPrice;
    }

    @Override
    public String getIInvoiceDetails() {
        return "D";
    }
}
