package sp25_bcs_106;

public class CinemaDemo {
    public static void main(String[] args) {
        CityCinema karachi = new CityCinema("Karachi", 2);
        CityCinema lahore = new CityCinema("Lahore", 2);
        CityCinema islamabad = new CityCinema("Islamabad", 1);

        // Print city layouts
        karachi.printCityLayout();
        lahore.printCityLayout();
        islamabad.printCityLayout();

        // Book seat 3-007 in Karachi > Cinema-1 > Screen-1
        System.out.println("\n=== BOOKING VIP SEAT 3-007 IN KARACHI ===");
        boolean booked = karachi.bookSeat("Atrium Saddar", 0, 3, 7);
        System.out.println("Seat booked? " + booked);

        // Try booking again to test rejection
        booked = karachi.bookSeat("Atrium Saddar", 0, 3, 7);
        System.out.println("Booking same seat again? " + booked);

        // Cancel the booking
        System.out.println("\n=== CANCELLING THE SAME SEAT ===");
        boolean cancelled = karachi.cancelSeat("Atrium Saddar", 0, 3, 7);
        System.out.println("Seat cancelled? " + cancelled);

        // Reprint Karachi layouts
        karachi.printCityLayout();

        // Search VIP in Lahore
        System.out.println("\nFirst available VIP in Lahore:");
        System.out.println(lahore.findFirstAvailableVIP());
    }
}
