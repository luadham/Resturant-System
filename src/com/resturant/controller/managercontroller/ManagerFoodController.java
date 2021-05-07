package com.resturant.controller.managercontroller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import com.resturant.controller.InputValidationController;
import com.resturant.model.Food;
import com.resturant.model.FoodList;

/**
 * The type Manager food controller.
 * @author Adham Adel
 */
public class ManagerFoodController {
    @FXML private TextField foodName;
    @FXML private TextField foodPrice;
    @FXML private TextArea foodDescription;
    @FXML private Label errorLabel;
    private final FoodList foodList = FoodList.getFoodList();

    @FXML
    private void saveFoodButton() {
        boolean isAddSuccessfuly = false;
        if (InputValidationController.verifyTextField(foodName, foodDescription,foodPrice)
                && InputValidationController.verifyDoubleNumber(foodPrice)) {
            Food food = new Food(foodName.getText().trim(), foodDescription.getText().trim(), Double.parseDouble(foodPrice.getText()));
            isAddSuccessfuly = foodList.addNewFood(food);
            InputValidationController.clearFields(foodName, foodDescription,foodPrice);
        } else {
            InputValidationController.setErrorMessage(errorLabel, "Please Enter Correct Data");
            return;
        }
        if (!isAddSuccessfuly) InputValidationController.setErrorMessage(errorLabel, "Food Is Already Exist");
    }

    @FXML
    private void clearLabel() {
        InputValidationController.clearErrorMessage(errorLabel);
    }


}
