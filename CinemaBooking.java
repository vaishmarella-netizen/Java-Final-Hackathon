import java.util.Scanner;

class CinemaBooking {
    String movieName;
    double ticketPrice;
    int tickets;
    String customerName;

    
    CinemaBooking(String movieName, double ticketPrice) {
        this.movieName = movieName;
        this.ticketPrice = ticketPrice;
        this.tickets = 0;
        this.customerName = "Unknown";
    }

    
    CinemaBooking(String movieName, double ticketPrice,
                  int tickets, String customerName) {
        this.movieName = movieName;
        this.ticketPrice = ticketPrice;
        this.tickets = tickets;
        this.customerName = customerName;
    }

    
    void bookTickets(int tickets) {
        this.tickets = tickets;
    }

    
    void bookTickets(int tickets, String customerName) {
        this.tickets = tickets;
        this.customerName = customerName;
    }

    void displayBooking() {
        if (tickets <= 0) {
            System.out.println("Invalid number of tickets.");
            return;
        }

        double total = ticketPrice * tickets;
        double discount = 0;

        if (tickets >= 5) {
            discount = total * 0.10;
        }

        double finalAmount = total - discount;

        System.out.println("\n--- Booking Summary ---");
        System.out.println("Movie: " + movieName.toUpperCase());
        System.out.println("Customer: " + customerName.toUpperCase());
        System.out.println("Tickets: " + tickets);
        System.out.println("Ticket Price: Rs. " + ticketPrice);
        System.out.println("Total Amount: Rs. " + total);
        System.out.println("Discount: Rs. " + discount);
        System.out.println("Final Amount: Rs. " + finalAmount);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter movie name: ");
        String movie = sc.nextLine();

        System.out.print("Enter ticket price: ");
        double price = sc.nextDouble();

        System.out.print("Enter number of tickets: ");
        int count = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter customer name: ");
        String customer = sc.nextLine();

     
        CinemaBooking booking =
            new CinemaBooking(movie, price, count, customer);

        booking.displayBooking();

       
        System.out.print("\nEnter customer name to verify: ");
        String verifyName = sc.nextLine();

        if (booking.customerName.equalsIgnoreCase(verifyName)) {
            System.out.println("Customer name verified.");
        } else {
            System.out.println("Customer name does not match.");
        }

        sc.close();
    }
}