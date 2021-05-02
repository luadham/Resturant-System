package sample.Controller.ManagerController;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
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
        if (verifyText()) {
            Food food = new Food(foodName.getText(), foodDescription.getText(), Double.parseDouble(foodPrice.getText()));
            FoodList.addNewFood(food, errorLabel);
            clearFields();
        }
    }

    @FXML
    private void clearLabel() {
        errorLabel.setText("");
    }

    private boolean verifyText() {
        if (foodName.getText().equals("") || foodDescription.getText().equals("")
        || foodPrice.getText().equals("")) {
            errorLabel.setText("Please Enter Food");
            return false;
        }
        try {
            Double.parseDouble(foodPrice.getText());
        } catch (NumberFormatException exception) {
            errorLabel.setText("Food Price Must Be a Number");
            return false;
        }
        return true;
    }

    private void clearFields() {
        foodName.setText("");
        foodPrice.setText("");
        foodDescription.setText("");
    }


}
