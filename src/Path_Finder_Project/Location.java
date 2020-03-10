package Path_Finder_Project;

import java.util.ArrayList;
import java.util.Arrays;

public class Location {
    private int x, y;
    private Maze maze;

    Location(int x, int y, Maze maze) {
        this.x = x;
        this.y = y;
        this.maze = maze;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public char query() {
        return maze.get(this);
    }

    public void set_explored() {
        assert this.query() == Constants.C ||
                this.query() == Constants.S : "set_explored should only be used on unexplored tiles or the start.";
        maze.set(this, Constants.V);
    }

    public void set(char c) {
        maze.set(this, c);
    }

    public boolean is_valid() {
        return (0 <= x &&
                0 <= y &&
                x <= maze.get_x_size() - 1 &&
                y <= maze.get_y_size() - 1);
    }

    public ArrayList<Location> get_surrounding_locations() {
        return new ArrayList<Location>(Arrays.asList(this.get_above(), this.get_below(), this.get_left(), this.get_right()));
    }

    public Location get_above() {
        return new Location(x, y + 1, maze);
    }

    public Location get_below() {
        return new Location(x, y - 1, maze);
    }

    public Location get_left() {
        return new Location(x - 1, y, maze);
    }

    public Location get_right() {
        return new Location(x + 1, y, maze);
    }

    public Maze get_maze() {
        return maze;
    }
}
