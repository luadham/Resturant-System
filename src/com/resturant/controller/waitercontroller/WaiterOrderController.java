package com.resturant.controller.waitercontroller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import com.resturant.model.Food;
import com.resturant.model.FoodList;

/**
 * The type Waiter order controller.
 * @author Adham Adel
 */
public class WaiterOrderController {
    @FXML
    private TextField firstNameText;
    @FXML
    private TextField lastNameText;
    @FXML
    private TextField emailText;
    @FXML
    private TextField phoneNumberText;
    @FXML
    private ComboBox<String> foodList;
    @FXML
    private Label quantityLabel;
    @FXML
    private Label orderPrice;

    @FXML
    private void initialize() {
        for (Food food : FoodList.getListOfFood()) {
            foodList.getItems().add(food.getFoodName());
        }
    }
    @FXML
    private void changeQuantity(ActionEvent event) {
        Button btn = (Button) event.getSource();
        String btnName = btn.getId();
        int currentQuantityValue = Integer.parseInt(quantityLabel.getText());
        int totalPriceValue = 0;
        Food food = FoodList.getFoodByName(foodList.getValue());
        switch (btnName) {
            case "incrementButton":
                quantityLabel.setText(String.valueOf(++currentQuantityValue));
                totalPriceValue += currentQuantityValue * food.getPrice();
                orderPrice.setText(String.valueOf(totalPriceValue + " $"));
                break;
            case "decrementButton":
                if (currentQuantityValue > 0)
                    quantityLabel.setText(String.valueOf(--currentQuantityValue));
                totalPriceValue += currentQuantityValue * food.getPrice();
                orderPrice.setText(String.valueOf(totalPriceValue + " $"));
                break;
            default:
                break;
        }
    }
}
