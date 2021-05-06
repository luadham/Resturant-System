package com.resturant.model;

import java.util.ArrayList;

public class Order {
    private int orderId;
    private int orderQuantity;
    private ArrayList<Food> orderedFood;

    public Order(int orderId, int orderQuantity, ArrayList<Food> orderedFood) {
        this.orderId = orderId;
        this.orderQuantity = orderQuantity;
        this.orderedFood = orderedFood;
    }

    public int getOrderId() {
        return orderId;
    }

    public int getOrderQuantity() {
        return orderQuantity;
    }

    public ArrayList<Food> getOrderedFood() {
        return orderedFood;
    }
}
