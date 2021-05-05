package com.resturant.model;

public class ResturantManageSystem implements IRMS {
    private Booking booking;
    public ResturantManageSystem(Booking booking) {
        this.booking = booking;
    }

    @Override
    public void addBooking() {
        BookingList.addNewBook(this.booking);
    }
}
