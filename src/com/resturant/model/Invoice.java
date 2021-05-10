package com.resturant.model;

import java.util.ArrayList;

public class Invoice implements IInvoice {
    private final Booking booking;

    public Invoice(Booking booking) {
        this.booking = booking;
    }

    @Override
    public double getOverallPrice() {
        ArrayList<Food> listOfOrderedFood = booking.getTable().getOrder().getOrderedFood();
        double price = 0;
        for (Food food : listOfOrderedFood) {
            price += food.getPrice();
        }
        return price;
    }

    @Override
    public String getIInvoiceDetails() {
        return "D";
    }
}
