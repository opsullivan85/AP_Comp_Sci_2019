package Inheritance_Practice.Ticket;

public class Adv extends Ticket {

    Adv(double price, String type) {
        super(price * 1, "Adv", type);
    }
}
