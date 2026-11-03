public class CinemaShow {

    private String title;
    private int seatsAvailable;
    private final int capacity;

    private static int totalBooked = 0;

    CinemaShow(String title, int capacity) {
        this.title = title;
        this.capacity = capacity;
        this.seatsAvailable = capacity;
    }

    CinemaShow(String title) {
        this(title, 100);
    }

    boolean book(int n) {
        if (n < 0 || n > seatsAvailable) {
            return false;
        }

        seatsAvailable -= n;
        totalBooked += n;

        return true;
    }

    void cancel(int n) {
        if (n > 0) {
            seatsAvailable = Math.min(capacity, seatsAvailable + n);
        }
    }

    int getSeatsAvailable() {
        return seatsAvailable;
    }

    static int getTotalBooked() {
        return totalBooked;
    }

    public static void main(String[] args) {

        CinemaShow show = new CinemaShow("Java Movie", 50);

        System.out.println("Book 20: " + show.book(20)
                + ", seats: " + show.getSeatsAvailable());

        System.out.println("Book 40: " + show.book(40)
                + ", seats: " + show.getSeatsAvailable());

        System.out.println("Book 10: " + show.book(10)
                + ", seats: " + show.getSeatsAvailable());

        show.cancel(5);

        System.out.println("After cancellation, seats: "
                + show.getSeatsAvailable());

        System.out.println("Total booked: " + getTotalBooked());
    }
}