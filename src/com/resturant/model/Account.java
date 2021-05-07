package com.resturant.model;

import java.io.Serializable;

public class Account {
    private String id;
    private String pwd;

    public Account(String id, String pwd) {
        this.id = id;
        this.pwd = pwd;
    }

    public String getId() {
        return id;
    }

    public String getPwd() {
        return pwd;
    }

}
