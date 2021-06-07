package com.resturant.model;

import java.util.ArrayList;

/**
 * The type Order maker.
 * facade Design Pattern
 * @author Adham Adel
 */
public class OrderMaker implements IOrderMaker {

    private int tableNumber;
    private int quantity;
    private static int orderId;
    private ArrayList<Food> orderdFood;
    private static int bookId;
    private Invoice invoice;
    private BookingList bookingList;
    private Customer customer;
    private Order order;
    private Table table;
    private Booking booking;

    /**
     * Instantiates a new Order maker.
     *
     * @param firstName        the first name
     * @param lastName         the last name
     * @param email            the email
     * @param phoneNumber      the phone number
     * @param quantity         the quantity
     * @param tableNumber      the table number
     * @param listOfOrderdFood the list of orderd food
     */
    public OrderMaker(String firstName, String lastName, String email,
                      String phoneNumber, String quantity, String tableNumber, ArrayList<Food> listOfOrderdFood) {
        this.customer.setFirstName(firstName);
        this.customer.setLastName(lastName);
        this.customer.setEmail(email);
        this.customer.setPhoneNumber(phoneNumber);
        this.quantity = Integer.parseInt(quantity);
        this.tableNumber = Integer.parseInt(tableNumber);
        this.orderdFood = listOfOrderdFood;
    }
    @Override
    public void prepareOrder() {
        bookingList = BookingList.getBookingList();
        order = new Order(orderId++, quantity, orderdFood);
        table = new Table(tableNumber, true, order);
        booking = new Booking(bookId++, customer, table);
        bookingList.addNewBooking(booking);
        invoice = new Invoice(booking);
    }

    @Override
    public double getOrderPrice() {
        return invoice.getOverallPrice();
    }
}
