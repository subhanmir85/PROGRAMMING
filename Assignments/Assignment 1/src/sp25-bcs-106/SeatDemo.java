package sp25_bcs_106;
public class SeatDemo {
    public static void main(String[] args) {
        System.out.println("=== SINGLE SEAT DEMO ===");

        Seat seat1 = new Seat("R1-001", Seattype.VIP, true, 1200);

  System.out.println("\n--- Initial State ---");      
	System.out.println(seat1);

//===BOOKING===//
        	System.out.println("\nBooking the seat...");
        	seat1.bookSeat();
        		System.out.println(seat1);

        
   System.out.println("\nTrying to book again...")  ;
  seat1.bookSeat();
  System.out.println(seat1);

//====CANCEL===//
        System.out.println("\nCancelling the booking...");
        seat1.cancelBooking();
        System.out.println(seat1);

 //====== Change seat type and price===////

        System.out.println("\nUpdating seat type and price...");
        seat1.setSeatType(Seattype.RECLINER);
        seat1.setPrice(1500);
        System.out.println(seat1);

        
    }
}
