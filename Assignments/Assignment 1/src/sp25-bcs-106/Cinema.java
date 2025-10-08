package sp25_bcs_106;
public class Cinema {
    private String cinemaName;
    private Screen[] screens;
    private int screenCount;

    public Cinema(String name, int preloadCount) {
        cinemaName = name;
        screens = new Screen[preloadCount + 5];
        screenCount = 0;
        for (int i = 0; i < preloadCount; i++) {
            addScreen("Screen-" + (i + 1));
        }
    }

    public void addScreen(String name) {
        if (screenCount == screens.length) growArray();
        screens[screenCount] = new Screen(name);
        screenCount++;
    }

    private void growArray() {
        Screen[] bigger = new Screen[screens.length * 2];
        for (int i = 0; i < screens.length; i++)
            bigger[i] = screens[i];
        screens = bigger;
    }

    public Screen findScreen(String name) {
        for (int i = 0; i < screenCount; i++) {
            if (screens[i].getScreenName().equalsIgnoreCase(name))
                return screens[i];
        }
        return null;
    }

    public Screen getScreen(int index) {
        if (index < 0 || index >= screenCount) return null;
        return screens[index];
    }

    public boolean bookSeat(int screenIndex, int row, int seat) {
        Screen s = getScreen(screenIndex);
        if (s == null) return false;
        return !s.booked(row, seat);
    }

    public boolean cancelSeat(int screenIndex, int row, int seat) {
        Screen s = getScreen(screenIndex);
        if (s == null) return false;
        return s.cancel(row, seat);
    }

    public int getTotalSeats() {
        int total = 0;
        for (int i = 0; i < screenCount; i++)
            total += screens[i].gettotalseatcount();
        return total;
    }

    public int getAvailableSeats() {
        int total = 0;
        for (int i = 0; i < screenCount; i++)
            total += screens[i].getAvailableSeatCount();
        return total;
    }

    public int getAvailableByType(Seattype type) {
        int total = 0;
        for (int i = 0; i < screenCount; i++)
            total += screens[i].getavailableseattype(type);
        return total;
    }

    public void printLayout() {
        System.out.println("\n=== " + cinemaName + " ===");
        for (int i = 0; i < screenCount; i++) {
            System.out.println("\n-- " + screens[i].getScreenName() + " Layout --");
            screens[i].displaylayout();
        }
    }

    public String toString() {
        return String.format("%s [Screens: %d | Total Seats: %d | Available: %d]",
                cinemaName, screenCount, getTotalSeats(), getAvailableSeats());
    }

    public String getName() {
        return cinemaName;
    }

    public int getScreenCount() {
        return screenCount;
    }
}