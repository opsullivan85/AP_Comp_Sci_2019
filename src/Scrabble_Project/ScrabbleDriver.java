package Scrabble_Project;

import java.io.IOException;
import java.util.Scanner;

/**
 * Prompts the user for a file then scans the file for
 * the line with the highest scrabble score
 */
public final class ScrabbleDriver {

    private static final Scanner s = new Scanner(System.in);

    public static void main(String[] args) {

        do {
            try {

                System.out.print("Enter the file name: ");
                String fileName = s.nextLine();

                TextFileAccessor scrab = new MaxScrabbleScore();

                scrab.openFile(fileName);
                scrab.processFile();
                System.out.println(scrab.getReportStr());


            } catch (IOException ioex) {
                ioex.printStackTrace();
            }
        } while (runAgain());
        s.close();
    }

    private static Boolean runAgain() {
        System.out.print("\nReRun? (y/n): ");
        String in = s.nextLine().toLowerCase();
        return (in.isEmpty() || in.charAt(0) == 'y');
    }
}