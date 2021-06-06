package com.resturant.controller;

import com.resturant.model.Manager;
import com.resturant.model.Staff;
import com.resturant.model.StaffList;

import java.util.ArrayList;

/**
 * The type Login controller.
 * @author Adham Adel
 */
public class LoginController {
    /**
     * Validate manager boolean.
     *
     * @param inputName     the input name
     * @param inputPassword the input password
     * @return the boolean
     */
    public static boolean validateManager(String inputName, String inputPassword) {
        Manager m = Manager.getManager();
        return inputName.equals(m.getName()) && inputPassword.equals(m.getPwd());
    }

    /**
     * Validate staff boolean.
     *
     * @param id  the id
     * @param pwd the pwd
     * @return the boolean
     */
    public static boolean validateStaff(String id, String pwd) {
        StaffList staffList = StaffList.getStaffList();
        ArrayList<Staff> list = staffList.getListOfStaff();
        for (Staff member : list) {
            if (member.getAccount().getId().equals(id) && member.getAccount().getPwd().equals(pwd))
                return true;
        }
        return false;
    }
}
