package sample.Controller.ManagerController;

import sample.Model.Chef;
import sample.Model.Staff;
import sample.Model.Waiter;

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
    public StaffFactory(boolean isChef, boolean isWaiter , String name, String id, double salary) {
        if (isChef)
            staffMember = new Chef(name, id, salary);
        else
            staffMember = new Waiter(name, id, salary);
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
