package sample.Controller.ManagerController;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import sample.Controller.InputControl;
import sample.Model.Food;
import sample.Model.FoodList;

/**
 * The type Manager food controller.
 * @author Adham Adel
 */
public class ManagerFoodController {
    @FXML
    private TextField foodName;
    @FXML
    private TextField foodPrice;
    @FXML
    private TextArea foodDescription;
    @FXML
    private Label errorLabel;

    @FXML
    private void saveFoodButton() {
        boolean isAddSuccessfuly = false;
        if (InputControl.verifyTextField(foodName, foodDescription,foodPrice)
                && InputControl.verifyDoubleNumber(foodPrice)) {
            Food food = new Food(foodName.getText().trim(), foodDescription.getText().trim(), Double.parseDouble(foodPrice.getText()));
            isAddSuccessfuly = FoodList.addNewFood(food);
            InputControl.clearFields(foodName, foodDescription,foodPrice);
        } else {
            InputControl.setErrorMessage(errorLabel, "Please Enter Correct Data");
            return;
        }
        if (!isAddSuccessfuly) InputControl.setErrorMessage(errorLabel, "Food Is Already Exist");
    }

    @FXML
    private void clearLabel() {
        InputControl.removeErrorMessage(errorLabel);
    }


}
