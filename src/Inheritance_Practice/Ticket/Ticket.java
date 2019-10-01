package Inheritance_Practice.Ticket;

public abstract class Ticket {
    static int num = 1;
    private String time;
    private String type;
    private int id;

    Ticket(double price, String time, String type) {
        this.time = time;
        this.type = type;
        this.id = num;
        num++;
    }

    public String toString() {
        return "Ticket{" +
                "time='" + time + '\'' +
                ", type='" + type + '\'' +
                ", id=" + id +
                '}';
    }

}
