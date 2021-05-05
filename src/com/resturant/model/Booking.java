package com.resturant.model;

public class Booking {
    private String bookId;
    private Customer customer;
    private Table table;

    public Booking(String bookId, Customer customer, Table table) {
        this.bookId = bookId;
        this.customer = customer;
        this.table = table;
    }

    public String getBookId() {
        return bookId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Table getTable() {
        return table;
    }
}
