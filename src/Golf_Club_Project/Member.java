package Golf_Club_Project;

public class Member {
    private Name name;
    private double average;

    public Member(String first_name, String last_name, double average) {
        this.name = new Name(first_name, last_name);
        this.average = average;
    }

    //Compare to another Golfer
    public int compareTo(Member o) {
        if (!(name.get_last_name().compareTo(o.name.get_last_name()) == 0)) {
            return name.get_last_name().compareTo(o.name.get_last_name());
        } else if (!(name.get_first_name().compareTo(o.name.get_last_name()) == 0)) {
            return name.get_first_name().compareTo(o.name.get_first_name());
        } else {
            return Double.compare(average, o.average);
        }
    }

    @Override
    public String toString() {
        return name.toString() + "\n" +
                "   Average: " + average;
    }

    //Compare with a name
    public int compareTo(Name o) {
        return this.name.compareTo(o);
    }

    public String get_first_name() {
        return name.get_first_name();
    }

    public String get_last_name() {
        return name.get_last_name();
    }

    public String get_full_name() {
        return name.get_first_name() + " " + name.get_last_name();
    }

    public double get_average() {
        return average;
    }
}
