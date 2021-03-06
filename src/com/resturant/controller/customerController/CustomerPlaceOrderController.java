package com.resturant.controller.customerController;

import com.resturant.controller.ErrorPage;
import com.resturant.controller.InputValidationController;
import com.resturant.controller.factory.StageFactory;
import com.resturant.model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.ArrayList;

/**
 * The type Customer place order controller.
 * @author Mahmoud El Telt
 */
public class CustomerPlaceOrderController {
    @FXML private TextField firstNameText;
    @FXML private TextField lastNameText;
    @FXML private TextField emailText;
    @FXML private TextField phoneNumberText;
    @FXML private TextField address;
    @FXML private Button homePageButton;
    @FXML private ComboBox<String> foodListMenu;
    @FXML private Label quantityLabel;
    @FXML private Label errorLabel;
    @FXML private Label totalPrice;
    private final FoodList foodList = FoodList.getFoodList();
    private final ArrayList<Food> listOfOrderedFood = new ArrayList<>();


    @FXML
    private void initialize() {

        for (Food food : foodList.getListOfFood()) {
            foodListMenu.getItems().add(food.getFoodName());
        }
    }

    @FXML
    private void changeQuantity(ActionEvent event) {
        Button btn = (Button) event.getSource();
        String btnName = btn.getId();
        int currentQuantityValue = Integer.parseInt(quantityLabel.getText());
        if (InputValidationController.verifyComboBox(foodListMenu)) {
            switch (btnName) {
                case "incrementButton":
                    quantityLabel.setText(String.valueOf(++currentQuantityValue));
                    listOfOrderedFood.add(foodList.getFoodByName(foodListMenu.getValue()));
                    break;
                case "decrementButton":
                    if (currentQuantityValue > 0) {
                        quantityLabel.setText(String.valueOf(--currentQuantityValue));
                        listOfOrderedFood.remove(foodList.getFoodByName(foodListMenu.getValue()));
                    }
                    break;
                default:
                    break;
            }
        }

    }

    @FXML
    private void changeFood(ActionEvent event) {
        quantityLabel.setText("0");
    }

    @FXML
    private void doOrder(ActionEvent event) {
        OrderMaker orderMaker = null;
        if (InputValidationController.verifyTextField(firstNameText, lastNameText, emailText, phoneNumberText, address)
                && InputValidationController.verifyComboBox(foodListMenu) && !quantityLabel.getText().equals("0")
                && InputValidationController.verifyIntNumber(phoneNumberText)) {
            orderMaker = new OrderMaker(
                    firstNameText.getText(),
                    lastNameText.getText(),
                    emailText.getText(),
                    address.getText(),
                    phoneNumberText.getText(),
                    quantityLabel.getText(),
                    foodListMenu.getValue(),
                    true
            );
            orderMaker.prepareOrder();
            totalPrice.setText(String.valueOf(orderMaker.getOrderPrice()) + " $");
            InputValidationController.clearFields(firstNameText, lastNameText, phoneNumberText);
        } else {
            InputValidationController.setErrorMessage(errorLabel , "There is Wrong Data");
        }
    }

    @FXML
    private void goHomePage(ActionEvent event) {
        StageFactory stageFactory = null;
        try {
            stageFactory = new StageFactory("mainPage");
            stageFactory.getView();
            homePageButton.getScene().getWindow().hide();
        } catch (IOException e) {
            ErrorPage errorPage = new ErrorPage();
            errorPage.showErrorPage();
        }
    }
}
