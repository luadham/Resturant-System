package sample.Model;

import javafx.scene.control.Tab;

import java.util.ArrayList;

public class BookingList {
    private static ArrayList<Booking> bookingsList = new ArrayList<>();

    public static void addNewBook(Booking booking) {
        if (!isAvailable(booking.getTable())) {
            bookingsList.add(booking);
        }
    }

    private static boolean isAvailable(Table table) {
        return table.isOccupied();
    }
}
