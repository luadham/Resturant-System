package com.resturant.model;

import java.util.ArrayList;

/**
 * The type Booking list.
 * Singletone Pattern
 *
 * @author Adham Adel
 */
public class BookingList {
    private final ArrayList<Booking> bookingsList = new ArrayList<>();
    private static BookingList bookingList;
    private BookingList() {}

    /**
     * Create booking list booking list.
     *
     * @return the booking list
     */
    public static BookingList createBookingList() {
        bookingList = new BookingList();
        return bookingList;
    }

    /**
     * Gets bookings list.
     *
     * @return the bookings list
     */
    public ArrayList<Booking> getBookingsList() {
        return bookingsList;
    }

    /**
     * Gets booking list.
     *
     * @return the booking list
     */
    public static BookingList getBookingList() {
        return bookingList;
    }

    private boolean isExist(Booking targetBooking) {
        for (Booking booking : bookingsList) {
            if (booking.equals(targetBooking))
                return true;
        }
        return false;
    }

    /**
     * Add new booking boolean.
     *
     * @param booking the booking
     * @return the boolean
     */
    public boolean addNewBooking(Booking booking) {
        if (!isExist(booking)) {
            bookingsList.add(booking);
            return true;
        }
        return false;
    }

    /**
     * Search for booking booking.
     *
     * @param email the email
     * @return the booking
     */
    public Booking searchForBooking(String email) {
        for (Booking booking : bookingsList) {
            if (booking.getCustomer().getEmail().equals(email))
                return booking;
        }
        return null;
    }


    /**
     * Search for booking booking.
     *
     * @param firstName the first name
     * @param lastName  the last name
     * @return the booking
     */
    public Booking searchForBooking(String firstName, String lastName) {
        for (Booking booking : bookingsList) {
            if (booking.getCustomer().getFirstName().equals(firstName) && booking.getCustomer().getLastName().equals(lastName))
                return booking;
        }
        return null;
    }
}
