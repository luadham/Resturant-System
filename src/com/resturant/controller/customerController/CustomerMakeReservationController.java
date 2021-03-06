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
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.util.ArrayList;

/**
 * The type Customer make reservation controller.
 * @author Mahmoud El Telt
 */
public class CustomerMakeReservationController {
    @FXML private TextField firstNameText;
    @FXML private TextField lastNameText;
    @FXML private TextField emailText;
    @FXML private TextField phoneNumberText;
    @FXML private ComboBox<String> tableNumber;
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
        setTableNumber();
    }

    private void setTableNumber() {
        tableNumber.getItems().clear();
        for (int i = 1; i <= 10; i++) {
            if (!BookingList.isExist(i)) {
                tableNumber.getItems().add(i + "");
            }
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
        if (InputValidationController.verifyTextField(firstNameText, lastNameText, emailText, phoneNumberText)
                && InputValidationController.verifyComboBox(foodListMenu, tableNumber) && !quantityLabel.getText().equals("0")
                && InputValidationController.verifyIntNumber(phoneNumberText)) {
            orderMaker = new OrderMaker(
                    firstNameText.getText(),
                    lastNameText.getText(),
                    emailText.getText(),
                    phoneNumberText.getText(),
                    quantityLabel.getText(),
                    tableNumber.getValue(),
                    foodListMenu.getValue()
            );
            orderMaker.prepareOrder();
            totalPrice.setText(String.valueOf(orderMaker.getOrderPrice()) + " $");
            setTableNumber();
            InputValidationController.clearFields(firstNameText, lastNameText, phoneNumberText);
        } else {
            InputValidationController.setErrorMessage(errorLabel, "There is Wrong Data");
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

