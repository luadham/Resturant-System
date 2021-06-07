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
        // For Development Only
        staffList.addNewStaffMember(new Waiter(
                "adham",
                "adham",
                12,
                new Account("adham", "1234")
        ));
        staffList.addNewStaffMember(new Chef(
                "adham",
                "adham",
                12,
                new Account("adham", "1234")
        ));
        foodList.addNewFood(new Food("Pizza" , "Delicious", 12));
        foodList.addNewFood(new Food("Chicken Burger" , "Delicious", 13));
        foodList.addNewFood(new Food("Beef Burger" , "Delicious", 14));
        foodList.addNewFood(new Food("Sushi" , "Delicious", 15));

    }
}
