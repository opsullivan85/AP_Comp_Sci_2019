package Inheritance_Practice.Ticket;

public class Walk extends Ticket {

    Walk(double price, String type) {
        super(price * 1.5, "Walk", type);
    }
}
