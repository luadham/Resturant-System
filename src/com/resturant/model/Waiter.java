package com.resturant.model;

/**
 * The type Waiter.
 * @author Adham Adel
 */
public class Waiter extends Staff {
    /**
     * Instantiates a new Waiter.
     *
     * @param name   the name
     * @param id     the id
     * @param salary the salary
     */
    public Waiter(String name, String id, double salary, Account account) {
        this.name = name;
        this.id = id;
        this.salary = salary;
        this.jopRole = "Waiter";
        this.account = account;
    }
}
