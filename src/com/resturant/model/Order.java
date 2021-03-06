package com.resturant.model;

import java.util.ArrayList;

/**
 * The type Order.
 * @author Adham Adel
 */
public class Order {
    private int orderId;
    private int orderQuantity;
    private ArrayList<Food> orderedFood;
    private String foodName;
    private  boolean isDone;
    private boolean isDelivered;

    /**
     * Instantiates a new Order.
     *
     * @param orderId       the order id
     * @param orderQuantity the order quantity
     * @param orderedFood   the ordered food
     */
    public Order(int orderId, int orderQuantity, ArrayList<Food> orderedFood) {
        this.orderId = orderId;
        this.orderQuantity = orderQuantity;
        this.orderedFood = orderedFood;
        this.isDone = false;
    }

    public Order(int orderId, int orderQuantity, String foodName) {
        this.orderId = orderId;
        this.orderQuantity = orderQuantity;
        this.foodName = foodName;
    }

    /**
     * Gets order id.
     *
     * @return the order id
     */
    public int getOrderId() {
        return orderId;
    }

    /**
     * Gets order quantity.
     *
     * @return the order quantity
     */
    public int getOrderQuantity() {
        return orderQuantity;
    }

    /**
     * Gets ordered food.
     *
     * @return the ordered food
     */
    public ArrayList<Food> getOrderedFood() {
        return orderedFood;
    }

    public String getFoodName() {
        return foodName;
    }

    public void orderCompleted()
    {
        this.isDone = true;
    }
    public void orderDelivered(){this.isDelivered = true;}
}
