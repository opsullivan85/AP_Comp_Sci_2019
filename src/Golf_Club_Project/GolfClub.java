package Golf_Club_Project;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GolfClub {
    private ArrayList<Member> members = new ArrayList<>();

    public GolfClub() {
        boolean run = true;
        String input;
        Member member;

        Scanner c = new Scanner(System.in);

        System.out.println("Welcome to the Golf Club database");

        while (run) {
            System.out.println("+---------------------------------------+");
            System.out.println("Type the action you want to take:");
            System.out.println("   [view]    View the entire database");
            System.out.println("   [add]     Add a member to the database");
            System.out.println("   [delete]  Delete a member");
            System.out.println("   [search]  Search the database");
            System.out.println("   [quit]    Quit this program");
            System.out.print(">>> ");

            input = c.next().toLowerCase().trim();

            System.out.println("+---------------------------------------+");

            switch (input) {
                case "view":
                    this.view();
                    break;

                case "add":
                    this.add(c);
                    break;

                case "delete":
                    member = this.search(c);
                    if (member == null) {
                        System.out.println("+---------------------------------------+");
                        System.out.println("That member was not found.");
                    } else {
                        members.remove(this.search(c));
                        System.out.println("+---------------------------------------+");
                        System.out.println("Member deleted successfully.");
                    }
                    break;

                case "search":
                    member = this.search(c);
                    System.out.println("+---------------------------------------+");
                    if (member == null) {
                        System.out.println("That member was not found.");
                    } else {
                        System.out.println(member);
                    }
                    break;

                case "quit":
                    run = false;
                    break;

                default:
                    System.out.println("That command was not recognised. Please try again.");
            }

        }
    }

    public void view() {
        if (members.isEmpty()) {
            System.out.println("There are currently no members");
        } else {
            for (Member g : members) {
                System.out.println(g);
            }
        }
    }

    public void add(Scanner c) {
        String first_name;
        String last_name;
        double average;

        System.out.print("First Name: ");
        first_name = c.next();

        System.out.print("Last Name: ");
        last_name = c.next();

        System.out.print("Average: ");
        average = c.nextDouble();

        members.add(new Member(first_name, last_name, average));

        this.recursive_merge_sort();
    }

    public Member search(Scanner c) {
        String first_name;
        String last_name;

        System.out.print("First Name: ");
        first_name = c.next();

        System.out.print("Last Name: ");
        last_name = c.next();

        Name name = new Name(first_name, last_name);

        return recursive_binary_search(name);
    }

    private Member recursive_binary_search(Name name) {
        if (!members.isEmpty() && 0 >= members.get(0).compareTo(name) && (0 <= members.get(members.size() - 1).compareTo(name))) {
            return recursive_binary_search(members, name).get(0);
        } else {
            return null;
        }
    }

    private ArrayList<Member> recursive_binary_search(ArrayList<Member> members, Name name) {
        if (1 == members.size()) {
            return members;
        } else {
            //Compare the golfers with the name
            if (0 < members.get(members.size() / 2).compareTo(name)) {
                return recursive_binary_search((ArrayList<Member>) members.subList(members.size() / 2 + 1, members.size()), name);
            } else {
                return recursive_binary_search((ArrayList<Member>) members.subList(0, members.size() / 2 - 1), name);
            }
        }
    }

    private void recursive_merge_sort() {
        this.members = recursive_merge_sort(this.members);
    }

    private ArrayList<Member> recursive_merge_sort(ArrayList<Member> members) {

        ArrayList<Member> sorted = new ArrayList<Member>();

        //If there are more than one golfers
        if (members.size() > 1) {
            ArrayList<Member> sublist1 = recursive_merge_sort(new ArrayList<Member>(members.subList(0, members.size() / 2)));
            ArrayList<Member> sublist2 = recursive_merge_sort(new ArrayList<Member>(members.subList(members.size() / 2, members.size())));


            //Put the lowest of the first indices from each sublist into the sorted array until one is empty
            while (!sublist1.isEmpty() && !sublist2.isEmpty()) {
                if (0 > sublist1.get(0).compareTo(sublist2.get(0))) {
                    sorted.add(sublist1.remove(0));
                } else {
                    sorted.add(sublist2.remove(0));
                }
            }

            //Add the remaining gofers to the list
            if (!sublist1.isEmpty()) {
                sorted.addAll(sublist1);
            } else {
                sorted.addAll(sublist2);
            }

            return sorted;

        } else {
            return members;
        }
    }
}
