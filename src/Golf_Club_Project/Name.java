package Golf_Club_Project;

public class Name implements Comparable<Name> {
    private String first_name;
    private String last_name;

    public Name(String first_name, String last_name) {
        this.first_name = first_name;
        this.last_name = last_name;
    }

    @Override
    public int compareTo(Name o) {
        if (0 == last_name.compareTo(o.last_name)) {
            return last_name.compareTo(o.last_name);
        } else {
            return first_name.compareTo(o.first_name);
        }
    }

    @Override
    public String toString() {
        return first_name + " " + last_name;
    }

    public String get_first_name() {
        return first_name;
    }

    public String get_last_name() {
        return last_name;
    }

    public String get_full_name() {
        return first_name + " " + last_name;
    }
}
