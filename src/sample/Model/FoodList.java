package sample.Model;

import javafx.scene.control.Label;
import sample.Controller.InputControl;

import java.util.ArrayList;

/**
 * The type Food list.
 * @author Adham Adel
 */
public class FoodList {
    private static final ArrayList<Food> listOfFood = new ArrayList<>();

    /**
     * Add new food if not exist
     * @modifies Add new Food to listOfFood
     * @param newFood the new food
     */
    public static boolean addNewFood(Food newFood) {
        if (isExist(newFood.getFoodName())) {
            return false;
        }
        listOfFood.add(newFood);
        return true;
    }

    /**
     * Check if food is already Exist or not
     * @param foodName
     */
    private static boolean isExist(String foodName) {
        for (Food food : listOfFood) {
            if (food.getFoodName().equals(foodName))
                return true;
        }
        return false;
    }
}
