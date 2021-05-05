package com.resturant.model;


import java.io.Serializable;

/**
 * The type Waiter.
 * @author Adham Adel
 */
public class Waiter extends Staff implements Serializable {
    /**
     * Instantiates a new Waiter.
     *
     * @param name   the name
     * @param id     the id
     * @param salary the salary
     */
    public Waiter(String name, String id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
        this.jopRole = "Waiter";
    }
}
