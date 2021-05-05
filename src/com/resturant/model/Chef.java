package com.resturant.model;

import java.io.Serializable;

/**
 * The type Chef.
 * @author Adham Adel
 */
public class Chef extends Staff implements Serializable {
    /**
     * Instantiates a new Chef.
     * @param name   the name
     * @param id     the id
     * @param salary the salary
     */
    public Chef(String name, String id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
        this.jopRole = "Chef";
        this.account = new Account("adham", "1234");
    }

}
