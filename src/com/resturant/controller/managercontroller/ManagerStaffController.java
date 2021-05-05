package com.resturant.controller.managercontroller;

import com.resturant.controller.managercontroller.factory.StaffFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import com.resturant.controller.InputValidationController;
import com.resturant.model.Staff;
import com.resturant.model.StaffList;

public class ManagerStaffController {
    @FXML
    private TextField idTextField;
    @FXML
    private TextField nameTextField;
    @FXML
    private TextField salaryTextField;
    @FXML
    private RadioButton waiterRadioButton;
    @FXML
    private RadioButton chefRadioButton;
    @FXML
    private Label errorLabel;

    @FXML
    private void waiterRadioAction(ActionEvent event) {
        if (chefRadioButton.isSelected())
            chefRadioButton.setSelected(false);
    }

    @FXML
    private void chefRadioAction(ActionEvent event) {
        if (waiterRadioButton.isSelected())
            waiterRadioButton.setSelected(false);
    }
    /*
        TODO: Add some check that user enter username is string type
     */
    @FXML
    private void saveStaff(ActionEvent event) {
        Staff newStaffMember;
        boolean isAddedSuccessfuly = false;
        //System.out.println(InputControl.verifyTextField(idTextField, nameTextField, salaryTextField));
        if (InputValidationController.verifyTextField(idTextField, nameTextField, salaryTextField)
            && (InputValidationController.isChecked(waiterRadioButton) || InputValidationController.isChecked(chefRadioButton))
            && InputValidationController.verifyDoubleNumber(salaryTextField)) {
            StaffFactory staffFactory = new StaffFactory(
                    chefRadioButton.isSelected(),
                    waiterRadioButton.isSelected(),
                    nameTextField.getText(),
                    idTextField.getText(),
                    Double.parseDouble(salaryTextField.getText())
            );
            isAddedSuccessfuly = StaffList.addNewEmployee(staffFactory.createNewStaff());
            InputValidationController.clearFields(idTextField, nameTextField, salaryTextField);
            waiterRadioButton.setSelected(false);
            chefRadioButton.setSelected(false);
        } else {
            InputValidationController.setErrorMessage(errorLabel, "Please Enter Correct Data");
            return;
        }
        if (!isAddedSuccessfuly) {
            System.out.println("From Here");
            InputValidationController.setErrorMessage(errorLabel, "Member is Already Exist!");
        }
    }
}
