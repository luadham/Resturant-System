package com.resturant.controller.managercontroller.factory;

import com.resturant.model.Account;
import com.resturant.model.Chef;
import com.resturant.model.Staff;
import com.resturant.model.Waiter;

/**
 * The type Staff factory.
 * @author Adham Adel
 */
public class StaffFactory {
    private Staff staffMember;

    /**
     * Instantiates a new Staff factory.
     *
     * @param isChef   if New Staff Member will be chef
     * @param isWaiter is New Staff Member will be waiter
     * @param name     the name
     * @param id       the id
     * @param salary   the salary
     */
    public StaffFactory(boolean isChef, boolean isWaiter , String name, String id, double salary, String pwd) {
        Account account = new Account(id, pwd);
        if (isChef)
            staffMember = new Chef(name, id, salary, account);
        else
            staffMember = new Waiter(name, id, salary, account);
    }

    /**
     * Create new staff staff.
     *
     * @return the staff
     */
    public Staff createNewStaff() {
        return staffMember;
    }
}
