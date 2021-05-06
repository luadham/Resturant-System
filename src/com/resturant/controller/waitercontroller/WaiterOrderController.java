package com.resturant.controller.waitercontroller;

import com.resturant.controller.ErrorPage;
import com.resturant.controller.InputValidationController;
import com.resturant.controller.factory.StageFactory;
import com.resturant.model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import javax.xml.soap.Text;
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
    @FXML private TextField tableNumber;
    @FXML private Button homePageButton;
    @FXML private ComboBox<String> foodList;
    @FXML private Label quantityLabel;
    @FXML private Label errorLabel;
    @FXML private Label totalPrice;

    private ArrayList<Food> listOfOrderedFood = new ArrayList<>();

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
        if (InputValidationController.verifyComboBox(foodList)) {
            switch (btnName) {
                case "incrementButton":
                    quantityLabel.setText(String.valueOf(++currentQuantityValue));
                    listOfOrderedFood.add(FoodList.getFoodByName(foodList.getValue()));
                    break;
                case "decrementButton":
                    if (currentQuantityValue > 0) {
                        quantityLabel.setText(String.valueOf(--currentQuantityValue));
                        listOfOrderedFood.remove(FoodList.getFoodByName(foodList.getValue()));
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
        if (InputValidationController.verifyTextField(firstNameText, lastNameText, emailText, phoneNumberText , tableNumber)
            && InputValidationController.verifyComboBox(foodList) && !quantityLabel.getText().equals("0")
            && InputValidationController.verifyIntNumber(phoneNumberText, tableNumber)) {
            Customer customer = new Customer(
                    firstNameText.getText(),
                    lastNameText.getText(),
                    emailText.getText(),
                    phoneNumberText.getText()
            );
            Order order = new Order(
                    123,
                    Integer.parseInt(quantityLabel.getText()),
                    listOfOrderedFood
            );
            Table table = new Table(
              Integer.parseInt(tableNumber.getText()),
              true,
              order
            );
            Booking booking = new Booking("123", customer, table);
            Invoice invoice = new Invoice(booking);
            totalPrice.setText(String.valueOf(invoice.getOverallPrice()) + " $");
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
