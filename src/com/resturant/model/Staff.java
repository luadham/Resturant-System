package com.resturant.model;

import java.io.Serializable;

/**
 * The type Staff.
 * @author Adham Adel
 */
public abstract class Staff implements Serializable {
    protected String name;
    protected String id;
    protected String jopRole;
    protected double salary;
    protected Account account;

    public Account getAccount() {
        return account;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getJopRole() {
        return jopRole;
    }

    public double getSalary() {
        return salary;
    }
}
