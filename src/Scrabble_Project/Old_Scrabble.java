package Scrabble_Project;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Old_Scrabble {
    public static void main(String[] args) throws FileNotFoundException {

        char[][] words = fileReader("src/Scrabble_Project/old_words.txt");
        int[] wordPoints = getScrabblePoints(words);
        showWordPoints(words, wordPoints);
    }

    /**
     * @param path The path to the file to open
     * @return An array of words from the next line in the file stored as cStrings
     * @throws FileNotFoundException if the path is invalid
     */
    private static char[][] fileReader(String path) throws FileNotFoundException {
        Scanner s = new Scanner(new File(path));

        //Grab a line as a string from the file,
        //make it lowercase, and split at the spaces
        String[] wordStrings = s.nextLine().toLowerCase().split(" ");

        char[][] words = new char[wordStrings.length][];

        //Convert the String array to an array of char arrays
        for (int i = 0; i < wordStrings.length; i++) {
            words[i] = wordStrings[i].toCharArray();
        }

        return words;
    }

    /**
     * @param words An array of cStrings to get the scrabble points for
     * @return An int array of scrabble points corresponding to the words
     */
    private static int[] getScrabblePoints(char[][] words) {
        //The array of point values for each letter
        final int[] points = {1, 3, 3, 2, 1, 4, 2, 4, 1, 8, 5, 1, 3, 1, 1, 3, 10, 1, 1, 1, 1, 4, 4, 8, 4, 10};
        int[] wordPoints = new int[words.length];

        //For each word
        for (int i = 0; i < words.length; i++) {
            //Add up the values of all characters in the word
            for (char letter : words[i]) {
                //Characters are cast to ints then reduced by 97 to index the points array
                wordPoints[i] += points[letter - 'a'];
            }
        }

        return wordPoints;
    }

    private static void showWordPoints(char[][] words, int[] wordPoints) {
        for (int i = 0; i < words.length; i++) {
            System.out.printf("%s: %d%n", new String(words[i]), wordPoints[i]);
        }
    }
}
