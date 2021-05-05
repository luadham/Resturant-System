package com.resturant.model;

public class Table {
    private String tabelId;
    private int numberOfSeats;
    private boolean isOccupied;
    private Order order;

    public Table(String tabelId, int numberOfSeats, boolean isOccupied, Order order) {
        this.tabelId = tabelId;
        this.numberOfSeats = numberOfSeats;
        this.isOccupied = isOccupied;
        this.order = order;
    }

    public String getTabelId() {
        return tabelId;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public Order getOrder() {
        return order;
    }
}
