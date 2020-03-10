import java.util.*;

class Main {
    final static char C = ' ', X = 'x', S = 's', E = 'e', V = '.';

    //Unsolvable Maze
    private static char[][] mazeBase = {
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

    private static Location start = new Location(1, 1);
  
  /*
  //Solveable Maze
  private static char[][] mazeBase = {
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

  private static Location start = new Location(7, 5);
  */

    public static void main(String[] args) {
        print(mazeBase);

        System.out.println();
        solveQ();
        System.out.println();
        solveS();
    }

    public static void print(char[][] maze) {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                System.out.print(maze[i][j]);
                System.out.print(' ');
            }
            System.out.println();
        }
    }

    public static char[][] copy() {
        char[][] temp = new char[mazeBase.length][mazeBase[0].length];
        for (int i = 0; i < mazeBase.length; i++) {
            for (int j = 0; j < mazeBase[0].length; j++) {
                temp[i][j] = mazeBase[i][j];
            }
        }
        return temp;
    }

    public static void solveQ() {

    }

    public static void solveS() {

    }
}