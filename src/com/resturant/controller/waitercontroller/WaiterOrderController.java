package com.resturant.controller.waitercontroller;

import com.resturant.controller.ErrorPage;
import com.resturant.controller.InputValidationController;
import com.resturant.controller.factory.StageFactory;
import com.resturant.model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;
import java.util.ArrayList;

/**
 * The type Waiter order controller.
 * @author Adham Adel
 */
public class WaiterOrderController {
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
    private final ArrayList<Booking> listOfBooking = BookingList.getBookingsList();

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
            tableNumber.setValue("Choose Table");
            setTableNumber();
        } else {
            InputValidationController.setErrorMessage(errorLabel , "There is Wrong Data");
        }
        if (orderMaker != null) {
            Customer customer = new Customer(
                    firstNameText.getText(),
                    lastNameText.getText(),
                    emailText.getText(),
                    phoneNumberText.getText()
            );
            String orderPrice = String.valueOf(orderMaker.getOrderPrice());
            Thread sendMailService = new Thread(new STMP(customer, orderPrice));
            sendMailService.start();
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