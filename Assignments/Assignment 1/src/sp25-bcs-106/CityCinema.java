package sp25_bcs_106;
public class CityCinema {
    private String cityName;
    private Cinema[] cinemas;
    private int cinemaCount;

    public CityCinema(String name, int preloadCount) {
        cityName = name;
        cinemas = new Cinema[preloadCount + 5];
        cinemaCount = 0;

        // Preload with demo data
        preloadCity(name);
    }

    // ===== Manual grow ===== //
    private void growArray() {
        Cinema[] bigger = new Cinema[cinemas.length * 2];
        for (int i = 0; i < cinemas.length; i++)
            bigger[i] = cinemas[i];
        cinemas = bigger;
    }

    // ===== Add Cinema ===== //
    public void addCinema(Cinema c) {
        if (cinemaCount == cinemas.length) growArray();
        cinemas[cinemaCount++] = c;
    }

    // ===== Find Cinema by name ===== //
    public Cinema findCinema(String name) {
        for (int i = 0; i < cinemaCount; i++) {
            if (cinemas[i].getName().equalsIgnoreCase(name))
                return cinemas[i];
        }
        return null;
    }

    // ===== Booking/Cancellation forwarding ===== //
    public boolean bookSeat(String cinemaName, int screenIndex, int row, int seat) {
        Cinema c = findCinema(cinemaName);
        if (c == null) return false;
        return c.bookSeat(screenIndex, row, seat);
    }

    public boolean cancelSeat(String cinemaName, int screenIndex, int row, int seat) {
        Cinema c = findCinema(cinemaName);
        if (c == null) return false;
        return c.cancelSeat(screenIndex, row, seat);
    }

    // ===== City-wide totals ===== //
    public int getTotalSeats() {
        int total = 0;
        for (int i = 0; i < cinemaCount; i++)
            total += cinemas[i].getTotalSeats();
        return total;
    }

    public int getAvailableSeats() {
        int total = 0;
        for (int i = 0; i < cinemaCount; i++)
            total += cinemas[i].getAvailableSeats();
        return total;
    }

    // ===== Find first available VIP seat ===== //
    public String findFirstAvailableVIP() {
        for (int i = 0; i < cinemaCount; i++) {
            Cinema c = cinemas[i];
            for (int s = 0; s < c.getScreenCount(); s++) {
                Seat vip = c.getScreen(s).getFirstAvailableSeat(Seattype.VIP);
                if (vip != null) {
                    return String.format("%s > %s > %s (VIP, %.2f PKR)",
                            c.getName(),
                            c.getScreen(s).getScreenName(),
                            vip.getseatID(),
                            vip.getprice());
                }
            }
        }
        return "No VIP seats available in " + cityName;
    }

    // ===== Print report ===== //
    public void printCityLayout() {
        System.out.println("\n*********** " + cityName.toUpperCase() + " CINEMAS ***********");
        for (int i = 0; i < cinemaCount; i++) {
            cinemas[i].printLayout();
        }
    }

    public String toString() {
        return String.format("%s [Cinemas: %d | Total: %d | Available: %d]",
                cityName, cinemaCount, getTotalSeats(), getAvailableSeats());
    }

    // ===== Preload city with realistic names ===== //
    private void preloadCity(String name) {
        if (name.equalsIgnoreCase("Karachi")) {
            addCinema(new Cinema("Atrium Saddar", 2));
            addCinema(new Cinema("Nueplex DHA", 2));
        } else if (name.equalsIgnoreCase("Lahore")) {
            addCinema(new Cinema("CineStar Township", 2));
            addCinema(new Cinema("CineStar Gulberg", 2));
        } else if (name.equalsIgnoreCase("Islamabad")) {
            addCinema(new Cinema("Centaurus Megaplex", 2));
        }
    }
}
