package Week6.TicketReservationSystem;
public class Reservation implements Runnable {
    private int ticketsToBuy;

    public Reservation(int ticketsToBuy) {
        this.ticketsToBuy = ticketsToBuy;
    }

    @Override
    public void run() {
        if (ReservationSystem.hasTicketLeft(ticketsToBuy)) {
            ReservationSystem.addTicketCount(ticketsToBuy);
            System.out.printf("Customer reserved %d tickets.\n", ticketsToBuy);
        } else {
            System.out.printf("Customer could not reserve %d tickets.\n", ticketsToBuy);
        }
    }
}
