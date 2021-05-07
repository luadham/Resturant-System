package com.resturant.model;

/**
 * The type Booking.
 * @author Adham Adel
 */
public class Booking {
    private int bookId;
    private Customer customer;
    private Table table;

    /**
     * Instantiates a new Booking.
     *
     * @param bookId   the book id
     * @param customer the customer
     * @param table    the table
     */
    public Booking(int bookId, Customer customer, Table table) {
        this.bookId = bookId;
        this.customer = customer;
        this.table = table;
    }

    /**
     * Gets book id.
     *
     * @return the book id
     */
    public int getBookId() {
        return bookId;
    }

    /**
     * Gets customer.
     *
     * @return the customer
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * Gets table.
     *
     * @return the table
     */
    public Table getTable() {
        return table;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookId='" + bookId + '\'' +
                ", customer=" + customer +
                ", table=" + table +
                '}';
    }
}
