package sp25_bcs_106;
public class ScreenDemo {
    public static void main(String[] args) {
        // Create a Screen
        Screen screen1 = new Screen("Screen 1");

        System.out.println("=== INITIAL SCREEN LAYOUT ===");
        screen1.displaylayout();

        // Get total and available seat count
        System.out.println("\nTotal Seats: " + screen1.gettotalseatcount());
        System.out.println("Available Seats: " + screen1.getAvailableSeatCount());

        // Book a few seats
        System.out.println("\n=== BOOKING SOME SEATS ===");
        screen1.booked(1, 1);  // Book row 1 seat 1
        screen1.booked(1, 2);  // Book row 1 seat 2 (if exists)
        screen1.booked(2, 1);  // Book another seat
        screen1.displaylayout();

        // Show available count again
        System.out.println("\nAvailable Seats after booking: " + screen1.getAvailableSeatCount());

        // Cancel a booking
        System.out.println("\n=== CANCELLING A SEAT ===");
        boolean cancelled = screen1.cancel(1, 1);
        System.out.println("Seat R1-001 cancelled? " + cancelled);
        screen1.displaylayout();

        // Get first available PREMIUM seat
        System.out.println("\n=== FIRST AVAILABLE PREMIUM SEAT ===");
        Seat firstPremium = screen1.getFirstAvailableSeat(Seattype.PREMIUM);
        if (firstPremium != null)
            System.out.println("First available PREMIUM: " + firstPremium.getseatID());
        else
            System.out.println("No PREMIUM seat available.");

        // Count available REGULAR seats
        System.out.println("\nAvailable REGULAR seats: " + screen1.getavailableseattype(Seattype.REGULAR));

        // Change the row type
        System.out.println("\n=== CHANGING ROW TYPE ===");
        screen1.setRowType(1, Seattype.VIP, 1200);
        screen1.displaylayout();

        // Get a specific seat and show details
        System.out.println("\n=== GETTING A SPECIFIC SEAT ===");
        Seat mySeat = screen1.getseat(2, 1);
        System.out.println(mySeat.toString());

        // Show row length
        System.out.println("\nRow 1 length: " + screen1.getRowLength(1));
        System.out.println("Total rows: " + screen1.getRowcount());

        // Get list of available seats of a specific type
        System.out.println("\n=== AVAILABLE VIP SEATS ===");
        Seat[] vipSeats = screen1.getListAvailableSeat(Seattype.VIP);
        for (Seat s : vipSeats) {
            System.out.println(s.getseatID() + " - " + s.gettype());
        }

        System.out.println("\n=== FINAL SCREEN STATE ===");
        System.out.println(screen1);
    }
}
