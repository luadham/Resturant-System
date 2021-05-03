package sample.Model;

import sample.Controller.InputControl;

import java.util.ArrayList;

/**
 * The type Staff list.
 * @author Adham Adel
 */
public class StaffList {
    private static final ArrayList<Staff> listOfStaff = new ArrayList<>();

    /**
     * Add new employee if dosen't Exist.
     *
     * @param newMember the new member
     * @return the boolean
     */
    public static boolean addNewEmployee(Staff newMember) {
        if (!isExistMember(newMember.getId())) {
            if (newMember.getJopRole().equals("Chef")) {
                listOfStaff.add(new Chef(newMember.name, newMember.id, newMember.salary));
            } else if (newMember.getJopRole().equals("Waiter")){
                listOfStaff.add(new Waiter(newMember.name, newMember.id, newMember.salary));
            }
            for (Staff s : listOfStaff) {
                System.out.println(s.getJopRole());
            }
            return true;
        }
        return false;
    }

    private static boolean isExistMember(String id) {
        for (Staff mem : listOfStaff) {
            if (mem.getId().equals(id))
                return true;
        }
        return false;
    }


}
