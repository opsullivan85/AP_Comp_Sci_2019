package Inheritance.Ticket;

public class TicketDriver {
    public static void main(String[] args) {
        for (int i = 10; i > 0; i--) {
            StudentWalk ticket = new StudentWalk();
            System.out.println(ticket.toString());
        }
    }
}
