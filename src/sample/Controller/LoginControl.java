package sample.Controller;

import sample.Model.Staff;
import sample.Model.StaffList;

import java.util.ArrayList;

public class LoginControl {
    public static boolean validateManager(String inputName, String inputPassword) {
        return inputName.equals("adham") && inputPassword.equals("1234");
    }
    public static boolean validateStaff(String id, String pwd) {
        ArrayList<Staff> list = StaffList.getListOfStaff();
        for (Staff member : list) {
            if (member.getAccount().getId().equals(id) && member.getAccount().getPwd().equals(pwd))
                return true;
        }
        return false;
    }
}
