package sample.Model;

import javafx.scene.control.Label;

import java.util.ArrayList;

/**
 * The type Food list.
 * @author Adham Adel
 */
public class FoodList {
    private static final ArrayList<Food> listOfFood = new ArrayList<>();

    private static boolean isExist(String foodName) {
        for (Food food : listOfFood) {
            if (food.getFoodName().equals(foodName))
                return true;
        }
        return false;
    }
    /**
     * Add new food.
     * @modifies Add new Food to listOfFood
     * @param newFood the new food
     */
    public static void addNewFood(Food newFood, Label errorLabel) {
        if (isExist(newFood.getFoodName())) {
            errorLabel.setText("Food Is Already Exist!");
        } else {
            listOfFood.add(newFood);
        }
    }
}
