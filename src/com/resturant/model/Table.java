package com.resturant.model;

/**
 * The type Table.
 * @author Adham Adel
 */
public class Table {
    private int tableNumber;
    private boolean isOccupied;
    private Order order;

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
    }

    /**
     * Gets table number.
     *
     * @return the table number
     */
    public int getTableNumber() {
        return tableNumber;
    }

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
