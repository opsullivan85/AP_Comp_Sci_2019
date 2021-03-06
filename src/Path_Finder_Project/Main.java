package Path_Finder_Project;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
    With the exception of the variable names and initialization, solveQ and solveS
    only differ in where the head is taken from. This means that solveS solves
    the mazes depth first, where solveQ solves the mazes breadth first.

    The way that my program works through the stack or queue reminds me of recursion.
 */

class Main {
    private final static char C = Constants.C, X = Constants.X, S = Constants.S, E = Constants.E, V = Constants.V;

    private char[][] possible_maze_base = {
            {X, X, X, X, X, X, X, X, X, X},
            {X, S, C, C, C, C, C, C, C, X},
            {X, C, C, C, X, C, X, X, C, X},
            {X, C, X, X, X, C, X, X, X, E},
            {X, C, C, C, C, X, X, X, C, X},
            {X, X, X, X, C, X, X, X, C, X},
            {X, X, X, X, C, X, C, C, C, X},
            {X, X, C, X, C, X, X, C, C, X},
            {X, X, C, C, C, C, C, C, C, X},
            {X, X, X, X, X, X, C, X, X, X}
    };
    private Maze possible_maze = new Maze(possible_maze_base, 1, 1);

    private char[][] impossible_maze_base = {
            {X, X, X, X, X, X, X, X, X, X, X, X, X, X, X},
            {X, C, C, C, C, C, C, X, C, C, C, C, C, C, X},
            {X, X, X, C, X, X, X, X, X, X, X, C, X, C, X},
            {X, C, X, C, C, C, C, C, C, C, C, C, X, C, X},
            {X, C, X, C, X, X, C, C, X, X, X, C, X, C, X},
            {X, C, C, C, X, C, C, C, C, C, X, C, X, C, X},
            {X, C, X, X, X, X, X, C, X, C, X, C, X, C, X},
            {X, C, C, C, C, S, C, C, X, C, C, X, E, C, X},
            {X, X, X, X, X, X, X, X, X, X, X, X, X, X, X}
    };
    private Maze impossible_maze = new Maze(impossible_maze_base, 7, 5);

    public void run() {
        Maze maze = impossible_maze;
        //Maze maze = possible_maze;

        System.out.println(maze.toString());
        System.out.println();

        solveQ(maze.copy());
        System.out.println();

        solveS(maze.copy());
        System.out.println();
    }

    public void solveQ(Maze maze) {
        Queue<Location> queue = new LinkedList<>();
        queue.add(maze.get_start());
        Location head;

        do {
            head = queue.remove();

            if (head.is_valid()) {
                if (head.query() == Constants.C || head.query() == Constants.S) {
                    queue.addAll(head.get_surrounding_locations());
                    head.set_explored();
                }

                if (head.query() == Constants.E) {
                    System.out.println("Queue: Escaped Successfully");
                    System.out.println(maze);
                    return;
                }
            }

        } while (!queue.isEmpty());


        System.out.println("Queue: Unable to Escape");
        System.out.println(maze);
    }

    public void solveS(Maze maze) {
        Stack<Location> stack = new Stack<>();
        stack.add(maze.get_start());
        Location head;

        do {
            head = stack.pop();

            if (head.is_valid()) {
                if (head.query() == Constants.C || head.query() == Constants.S) {
                    stack.addAll(head.get_surrounding_locations());
                    head.set_explored();
                }

                if (head.query() == Constants.E) {
                    System.out.println("Stack: Escaped Successfully");
                    System.out.println(maze);
                    return;
                }
            }

        } while (!stack.isEmpty());

        System.out.println("Stack: Unable to Escape");
        System.out.println(maze);
    }
}