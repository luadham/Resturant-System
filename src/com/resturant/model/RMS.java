package com.resturant.model;

import java.util.ArrayList;

public class RMS implements IRMS {

    public RMS() {
    }
    @Override
    public void createSystem() {
        Manager manager = Manager.createManager("adham" , "1234");
        FoodList foodList = FoodList.createFoodList();
        StaffList staffList = StaffList.createStaffList();
        BookingList bookingList = BookingList.createBookingList();
    }
}
