package com.resturant.model;

import java.util.ArrayList;

/**
 * The type Table.
 * @author Adham Adel
 */
public class Table {
    private int tableNumber;
    private boolean isOccupied;
    private Order order;
    private final ArrayList<Integer> tablenum = new ArrayList<Integer>(10);


    /**
     * Instantiates a new Table.
     *
     * @param tableNumber the table number
     * @param isOccupied  the is occupied
     * @param order       the order
     */
    public Table(int tableNumber,  boolean isOccupied, Order order) {
        this.tableNumber = tableNumber;
        this.isOccupied = isOccupied;
        this.order = order;
        tablenum.add(tableNumber);
    }

    public boolean addwhenavailable(int tablenumb){
        if(tablenum.contains(tablenumb))
            return false;
        else
        {
            return true;
        }
    }

    /**
     * Gets table number.
     *
     * @return the table number
     */
    public int getTableNumber() {
        return tableNumber;
    }

    public final ArrayList<Integer> gettables(){return tablenum;}
    /**
     * Is occupied boolean.
     *
     * @return the boolean
     */
    public boolean isOccupied() {
        return isOccupied;
    }

    /**
     * Gets order.
     *
     * @return the order
     */
    public Order getOrder() {
        return order;
    }
}
