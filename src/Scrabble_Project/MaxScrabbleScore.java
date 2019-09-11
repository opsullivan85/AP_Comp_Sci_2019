package Scrabble_Project;


/**
 *
 */
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
     * @param line The line to be processed
     */
    protected void processLine(String line) {
        //process each character from the current line
        //calculate sum of the scores for characters in that line
        int curScore = 0;

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
        //helper method to return the score for the character

        if (!Character.isLetter(c)) {
            return 0;
        }

        int rawScore = POINTS[Character.toLowerCase(c) - 'a'];

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