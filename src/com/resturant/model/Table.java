package com.resturant.model;

public class Table {
    private int tableNumber;
    private boolean isOccupied;
    private Order order;

    public Table(int tableNumber,  boolean isOccupied, Order order) {
        this.tableNumber = tableNumber;
        this.isOccupied = isOccupied;
        this.order = order;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public Order getOrder() {
        return order;
    }
}
