package com.resturant.model;

import java.util.ArrayList;

/**
 * The type Food list.
 *
 * @author Adham Adel
 */
public class FoodList {
    private static FoodList foodList;
    private ArrayList<Food> listOfFood = new ArrayList<>();

    private FoodList() {

    }

    public static FoodList createFoodList() {
        foodList = new FoodList();
        return foodList;
    }

    public static FoodList getFoodList() {
        return foodList;
    }

    public ArrayList<Food> getListOfFood() {
        return listOfFood;
    }

    public void setListOfFood(ArrayList<Food> listOfFood) {
        this.listOfFood = listOfFood;
    }

    private boolean isExist(Food targetFood) {
        for (Food food : listOfFood) {
            if (food.equals(targetFood))
                return true;
        }
        return false;
    }

    public boolean addNewFood(Food newFood) {
        if (!isExist(newFood)) {
            listOfFood.add(newFood);
            return true;
        }
        return false;
    }

    public Food getFoodByName(String foodName) {
        for (Food food : listOfFood) {
            if (food.getFoodName().equals(foodName))
                return food;
        }
        return null;
    }
}
