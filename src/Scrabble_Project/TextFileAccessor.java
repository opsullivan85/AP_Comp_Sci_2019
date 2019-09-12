package Scrabble_Project;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;


abstract class TextFileAccessor {
    /**
     * The scanner to grab user input
     */
    private Scanner scan;

    /**
     * @param fileName The path for the file to be opened
     * @throws IOException If the path is invalid
     */
    public void openFile(String fileName) throws IOException {
        this.scan = new Scanner(new File(fileName));
    }

    /**
     * Processes the file line by line using the processLine method
     * then closes the scanner
     */
    void processFile() {
        while (scan.hasNextLine()) {
            this.processLine(scan.nextLine());
        }
        scan.close();
    }

    protected abstract void processLine(String line);

    public abstract String getReportStr();

}



