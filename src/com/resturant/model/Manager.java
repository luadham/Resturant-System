package com.resturant.model;

/**
 * The type Manager.
 * @author Adham Adel
 */
public class Manager {
    private static Manager manager;
    private String name;
    private String pwd;
    private Manager(String name, String pwd) {
        this.name = name;
        this.pwd = pwd;
    }
    public static Manager createManager(String name, String pwd) {
        manager = new Manager(name, pwd);
        return manager;
    }

    public static Manager getManager() {
        return manager;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
