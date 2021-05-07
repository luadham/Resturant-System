package com.resturant.model;

import java.util.ArrayList;

/**
 * The type Rms. (Restaurant Management System)
 * @author Adham Adel
 */
public class RMS implements IRMS {

    /**
     * Instantiates a new Rms.
     */
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
