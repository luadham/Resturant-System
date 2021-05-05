package com.resturant.model;

import java.util.ArrayList;

/**
 * The type Food list.
 *
 * @author Adham Adel
 */
public class FoodList {
    private static final ArrayList<Food> listOfFood = new ArrayList<>();

    /**
     * Add new food if not exist
     *
     * @param newFood the new food
     * @return the boolean
     * @modifies Add new Food to listOfFood
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

    /**
     * Gets list of food.
     *
     * @return the list of food
     */
    public static ArrayList<Food> getListOfFood() {
        return listOfFood;
    }

    public static Food getFoodByName(String foodName) {
        for (Food food : listOfFood) {
            if (food.getFoodName().equals(foodName))
                return food;
        }
        return null;
    }
}
