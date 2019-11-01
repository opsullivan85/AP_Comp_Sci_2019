package Interface_Practice.Problem_3;

public class AdvanceStudent implements Ticket {

    private final static String type = "Student";
    private final static String time = "Advance";
    private int ID;
    private static int totalTickets = 1;

    public AdvanceStudent(int ID) {
        this.ID = totalTickets++;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public String getTime() {
        return time;
    }

    @Override
    public int getID() {
        return ID;
    }
}
