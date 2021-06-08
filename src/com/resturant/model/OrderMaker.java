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
    private ArrayList<Table> tables;
    private static int bookId;
    private Invoice invoice;
    private BookingList bookingList;
    private Customer customer;
    private Order order;
    private Table table;
    private Booking booking;
    private String foodName;
    private String address;
    private boolean delevery;

    public OrderMaker(String firstName, String lastName, String email,
                      String phoneNumber, String quantity, String tableNumber ,String foodName) {
        this.customer = new Customer(firstName,lastName, email, phoneNumber);
        this.quantity = Integer.parseInt(quantity);
        this.tableNumber = Integer.parseInt(tableNumber);
        this.foodName = foodName;
    }

    public OrderMaker(String firstName, String lastName, String email, String address,
                      String phoneNumber, String quantity, String foodName, boolean delevery) {
        this.customer = new Customer(firstName,lastName, email, phoneNumber, address);
        this.quantity = Integer.parseInt(quantity);
        this.foodName = foodName;
        this.address = address;
        this.delevery = delevery;
    }




    @Override
    public void prepareOrder() {
        bookingList = BookingList.getBookingList();
        order = new Order(orderId++, quantity, foodName);
        table = new Table(tableNumber, true, order);
        booking = new Booking(bookId++, customer, table);
        bookingList.addNewBooking(booking);
        invoice = new Invoice(booking);
        String emailMessage = "Hello Mr/s." + customer.getFirstName() + " " +
                "I hope this mail find you well<br>"
                + "Your Order Has been submitted Successfully<br>"
                + "Order: " + order.getFoodName()
                + "<br>Order is being prepared<br>"
                + "Your Total Cost is: " + getOrderPrice() + " $"
                + "<br> Thank you for choosing our service<br>";
        if (delevery)
            emailMessage += "Your Order Will be delivered to : " + this.address + "<br>";
        Thread sendMailService = new Thread(new STMP(customer, String.valueOf(getOrderPrice()), order.getFoodName(), emailMessage));
        sendMailService.start();
    }

    @Override
    public double getOrderPrice() {
        return invoice.getOverallPrice();
    }
}
