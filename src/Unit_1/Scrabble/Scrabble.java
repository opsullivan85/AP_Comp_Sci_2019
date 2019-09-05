package Unit_1.Scrabble;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Scrabble {
    public static void main(String[] args) throws FileNotFoundException {

        char[][] words = fileReader("src/Unit_1/Scrabble/words.txt");
        int[] wordPoints = getScrabblePoints(words);
        showWordPoints(words, wordPoints);
    }

    public static char[][] fileReader(String path) throws FileNotFoundException {
        Scanner s = new Scanner(new File(path));
        String[] wordStrings = s.nextLine().toLowerCase().split(" ");
        char[][] words = new char[wordStrings.length][];

        for (int i = 0; i < wordStrings.length; i++){
            words[i] = wordStrings[i].toCharArray();
        }

        return words;
    }

    public static int[] getScrabblePoints(char[][] words){
        final int[] points = {1, 3, 3, 2, 1, 4, 2, 4, 1, 8, 5, 1, 3, 1, 1, 3, 10, 1, 1, 1, 1, 4, 4, 8, 4, 10};
        int[] wordPoints = new int[words.length];

        for (int i = 0; i < words.length; i++){
            for (char letter : words[i]){
                wordPoints[i] += points[(int)letter - 97];
            }
        }

        return wordPoints;
    }

    public static void showWordPoints(char[][] words, int[] wordPoints){
        for (int i = 0; i < words.length; i++){
            System.out.printf("%s: %d%n", new String(words[i]), wordPoints[i]);
        }
    }
}
