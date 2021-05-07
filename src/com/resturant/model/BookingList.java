package com.resturant.model;

import java.util.ArrayList;

/**
 * The type Booking list.
 * @author Adham Adel
 */
public class BookingList {
    private final ArrayList<Booking> bookingsList = new ArrayList<>();
    private static BookingList bookingList;
    private BookingList() {}
    public static BookingList createBookingList() {
        bookingList = new BookingList();
        return bookingList;
    }

    public ArrayList<Booking> getBookingsList() {
        return bookingsList;
    }

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
    public boolean addNewBooking(Booking booking) {
        if (!isExist(booking)) {
            bookingsList.add(booking);
            return true;
        }
        return false;
    }
}
