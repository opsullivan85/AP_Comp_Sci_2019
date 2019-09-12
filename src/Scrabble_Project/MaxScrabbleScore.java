package Scrabble_Project;

public class MaxScrabbleScore extends TextFileAccessor {

    /**
     * Stores the String of he best line encountered
     */
    private String bestLine;

    /**
     * Stores the current best score
     */
    private int bestScore = 0;


    /**
     * Stores the base point values for each letter
     */
    //Set up "score board"              {a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q,  r, s, t, u, v, w, x, y,  z}
    private static final int[] POINTS = {1, 3, 3, 2, 1, 4, 2, 4, 1, 8, 5, 1, 3, 1, 1, 3, 10, 1, 1, 1, 1, 4, 4, 8, 4, 10};

    MaxScrabbleScore() {
        //initialize variables in constructor
    }

    /**
     * Processes a string and compares it to the current highest scoring line
     * @param line The line to be processed
     */
    protected void processLine(String line) {
        //Running total of points for the line
        int curScore = 0;

        //Loop through characters in the line and add up their points
        for (int i = line.length() - 1; i >= 0; i--) {
            curScore += this.getScrabbleScore(line.charAt(i), i);
        }

        if (curScore > this.bestScore) {
            this.bestScore = curScore;
            this.bestLine = line;
        }

    }

    /**
     * @param c   The character to get the points for
     * @param pos The position of the character in the string
     * @return The score from the character and its position
     */
    private int getScrabbleScore(char c, int pos) {
        //Score is zero if the character is not a letter
        if (!Character.isLetter(c)) {
            return 0;
        }

        //Index POINTS using the character
        int rawScore = POINTS[Character.toLowerCase(c) - 'a'];

        //Calculate the positional modifier
        int modifier = 1;

        if (pos % 9 == 0)
            modifier = 3;
        if (pos % 4 == 0)
            modifier = 2;

        return (rawScore * modifier);
    }

    /**
     * @return A formatted String detailing the best line encountered
     */
    public String getReportStr() {
        //returns the score and the string that was entered
        return (String.format("Max scrabble score: %d for this line: %s", this.bestScore, this.bestLine));
    }

}