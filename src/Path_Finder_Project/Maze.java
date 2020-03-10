package Path_Finder_Project;

import java.util.Arrays;

public class Maze {
    private char[][] maze;
    private Location start;

    Maze(char[][] maze, int start_x, int start_y) {
        this.maze = maze;
        this.start = new Location(start_x, start_y, this);
    }

    public Maze copy() {
        char[][] maze_copy = new char[maze.length][];
        for (int r = maze.length - 1; r >= 0; r--) {
            maze_copy[r] = maze[r].clone();
        }

        return new Maze(maze_copy, this.get_start().getX(), this.get_start().getY());
    }

    public Location get_start() {
        return start;
    }

    public char get(Location location) {
        return maze[location.getX()][location.getY()];
    }

    public void set(Location location, char c) {
        maze[location.getX()][location.getY()] = c;
    }

    public int get_x_size() {
        return maze.length;
    }

    public int get_y_size() {
        return maze[0].length;
    }

    @Override
    public String toString() {
        String s = "";
        for (char[] r : maze) {
            for (char c : r) {
                s += c + " ";
            }
            s += "\n";
        }

        return s;
    }


}
