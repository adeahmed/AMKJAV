package Week6.TicketReservationSystem;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ReservationSystem {
    private static final int maxTicketCount = 10;
    private static int ticketCount = 0;

    public static void main(String[] args) {
        int numCustomers = 15;
        ExecutorService executorService = Executors.newFixedThreadPool(numCustomers);

        for (int i = 0; i < numCustomers; i++) {
            int ticketsToBuy = (int) (Math.random() * 5) + 1;
            Reservation reservation = new Reservation(ticketsToBuy);
            executorService.submit(reservation);
        }

        executorService.shutdown();

        try {
            executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Done.");
        System.out.println("Ticket count: " + ticketCount);
    }

    public static synchronized boolean hasTicketLeft(int amount) {
        return ticketCount + amount <= maxTicketCount;
    }

    public static synchronized void addTicketCount(int amount) {
        ticketCount += amount;
    }
}
