package com.resturant.model;

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

    public static ArrayList<Staff> getListOfStaff() {
        return listOfStaff;
    }
}
