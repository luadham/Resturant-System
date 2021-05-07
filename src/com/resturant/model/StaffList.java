package com.resturant.model;

import java.util.ArrayList;

/**
 * The type Staff list.
 * @author Adham Adel
 */
public class StaffList {
    private ArrayList<Staff> listOfStaff = new ArrayList<>();
    private static StaffList staffList;
    private StaffList() {

    }
    public static StaffList createStaffList() {
        staffList = new StaffList();
        return staffList;
    }

    public void setListOfStaff(ArrayList<Staff> listOfStaff) {
        this.listOfStaff = listOfStaff;
    }

    public static void setStaffList(StaffList staffList) {
        StaffList.staffList = staffList;
    }

    public ArrayList<Staff> getListOfStaff() {
        return listOfStaff;
    }

    public static StaffList getStaffList() {
        return staffList;
    }

    private boolean isExist(Staff staffTarget) {
        for (Staff staff : listOfStaff) {
            if (staff.equals(staffTarget)) {
                return true;
            }
        }
        return false;
    }

    public boolean addNewStaffMember(Staff staffMember) {
        if (!isExist(staffMember)) {
            listOfStaff.add(staffMember);
            return true;
        }
        return false;
    }

    public Staff getStaffByName(String name) {
        for (Staff staff : listOfStaff) {
            if (staff.getName().equals(name))
                return staff;
        }
        return null;
    }
}
