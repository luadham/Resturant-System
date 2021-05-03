package sample.Model;

import sample.Controller.InputControl;

import java.util.ArrayList;

/**
 * The type Staff list.
 * @author Adham Adel
 */
public class StaffList {
    private static ArrayList<Staff> listOfStaff;

    /**
     * Add new employee if dosen't Exist.
     *
     * @param newMember the new member
     * @return the boolean
     */
    public static boolean addNewEmployee(Staff newMember) {
        if (!isExistMember(newMember.id)) {
            if (newMember.jopRole.equals("Chef")) {
                listOfStaff.add(new Chef(newMember.name, newMember.id, newMember.salary));
            } else if (newMember.jopRole.equals("Waiter")){
                listOfStaff.add(new Chef(newMember.name, newMember.id, newMember.salary));
            }
            return true;
        }
        return false;
    }

    private static boolean isExistMember(String id) {
        for (Staff mem : listOfStaff) {
            if (mem.id.equals(id))
                return true;
        }
        return false;
    }


}
