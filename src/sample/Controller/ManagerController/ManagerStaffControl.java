package sample.Controller.ManagerController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import sample.Controller.InputControl;
import sample.Model.Staff;
import sample.Model.StaffList;

public class ManagerStaffControl {
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
    @FXML
    private void saveStaffButton(ActionEvent event) {
        Staff newStaffMember;
        boolean isAddedSuccessfuly = false;
        //System.out.println(InputControl.verifyTextField(idTextField, nameTextField, salaryTextField));
        if (InputControl.verifyTextField(idTextField, nameTextField, salaryTextField)
            && (InputControl.isChecked(waiterRadioButton) || InputControl.isChecked(chefRadioButton))
            && InputControl.verifyDoubleNumber(salaryTextField)) {
            StaffFactory staffFactory = new StaffFactory(
                    chefRadioButton.isSelected(),
                    waiterRadioButton.isSelected(),
                    nameTextField.getText(),
                    idTextField.getText(),
                    Double.parseDouble(salaryTextField.getText())
            );
            isAddedSuccessfuly = StaffList.addNewEmployee(staffFactory.createNewStaff());
            InputControl.clearFields(idTextField, nameTextField, salaryTextField);
            waiterRadioButton.setSelected(false);
            chefRadioButton.setSelected(false);
        } else {
            InputControl.setErrorMessage(errorLabel, "Please Enter Correct Data");
            return;
        }
        if (!isAddedSuccessfuly) {
            System.out.println("From Here");
            InputControl.setErrorMessage(errorLabel, "Member is Already Exist!");
        }
    }
}
