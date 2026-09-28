class TicketBooking {

    private int tickets = 5;

    // Synchronized method prevents two users
    // from booking the same ticket
    synchronized void bookTicket(String user, int number) {

        System.out.println(user + " is trying to book "
                           + number + " ticket(s)...");

        if (tickets >= number) {
            tickets = tickets - number;

            System.out.println(user + " successfully booked "
                               + number + " ticket(s).");

            System.out.println("Tickets remaining: " + tickets);
        } else {
            System.out.println(user + " could not book "
                               + number + " ticket(s).");

            System.out.println("Only " + tickets
                               + " ticket(s) available.");
        }

        System.out.println();
    }

    void displayTickets() {
        System.out.println("Final tickets available: " + tickets);
    }
}


// Using Thread class
class UserThread extends Thread {

    TicketBooking booking;
    String user;
    int tickets;

    UserThread(TicketBooking booking, String user, int tickets) {
        this.booking = booking;
        this.user = user;
        this.tickets = tickets;
    }

    public void run() {
        booking.bookTicket(user, tickets);
    }
}


// Using Runnable interface
class UserRunnable implements Runnable {

    TicketBooking booking;
    String user;
    int tickets;

    UserRunnable(TicketBooking booking, String user, int tickets) {
        this.booking = booking;
        this.user = user;
        this.tickets = tickets;
    }

    public void run() {
        booking.bookTicket(user, tickets);
    }
}


public class Main {

    public static void main(String[] args) {

        TicketBooking booking = new TicketBooking();

        System.out.println("===== TICKET BOOKING SYSTEM =====");
        System.out.println("Total tickets available: 5\n");

        // Thread class
        UserThread user1 =
            new UserThread(booking, "User 1", 2);

        UserThread user2 =
            new UserThread(booking, "User 2", 2);

        // Runnable interface
        Thread user3 =
            new Thread(new UserRunnable(booking, "User 3", 2));

        // Start all threads
        user1.start();
        user2.start();
        user3.start();

        // Wait for all threads to finish
        try {
            user1.join();
            user2.join();
            user3.join();
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted.");
        }

        System.out.println("===== BOOKING COMPLETED =====");
        booking.displayTickets();
    }
}
