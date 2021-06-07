package com.resturant.model;

/**
 * The type Food.
 * @author Adham Adel
 */
public class Food {
    private String foodName;
    private String description;
    private double price;

    public Food(String foodName, String description, double price) {
        this.foodName = foodName;
        this.description = description;
        this.price = price;
    }

    public String getFoodName() {
        return foodName;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }


    @Override
    public String toString() {
        return "Food{" +
                "foodName='" + foodName + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }
}
