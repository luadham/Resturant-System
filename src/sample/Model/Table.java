package sample.Model;

public class Table {
    private String tabelNumber;
    private int numberOfSeats;
    private boolean isOccupied;
    private Order order;

    public Table(String tabelNumber, int numberOfSeats, boolean isOccupied, Order order) {
        this.tabelNumber = tabelNumber;
        this.numberOfSeats = numberOfSeats;
        this.isOccupied = isOccupied;
        this.order = order;
    }

    public String getTabelNumber() {
        return tabelNumber;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public Order getOrder() {
        return order;
    }
}
