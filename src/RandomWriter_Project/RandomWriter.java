package RandomWriter_Project;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

class RandomWriter {
    private int k, length;
    private String in;
    private FileWriter out;

    /**
     * First gets parameters from the user then runs the program
     */
    RandomWriter() {
        this.get_parameters();
        this.run();
    }

    /**
     * Gets a seed to start generating new characters from
     * This is called in the beginning
     * as well as whenever the program hits a dead end
     *
     * @return The new seed
     */
    private String get_seed() {
        int index = (new Random()).nextInt(in.length() - k);
        return in.substring(index, index + k);
    }

    /**
     * Gets parameters from the user
     */
    private void get_parameters() {
        Scanner c = new Scanner(System.in);

        //get k
        do {
            try {
                System.out.print("k: ");
                k = c.nextInt();

                if (k < 0) {
                    System.out.println("k must be positive!");
                }
            } catch (Exception e) {
                System.out.println("k must be an integer");
                k = -1;
            }

        } while (k < 0);

        //get length
        do {
            try {
                System.out.print("Length: ");

                length = c.nextInt();

                if (length < 0) {
                    System.out.println("length must greater than or equal to k!");
                }
            } catch (Exception e) {
                System.out.println("k must be an integer");
                length = -1;
            }
        } while (length < k);

        //setup in
        while (true) {
            try {
                System.out.print("Input file path: ");
                Scanner in_file = new Scanner(new File(c.next()));

                while (in_file.hasNext()) {
                    in += in_file.nextLine();
                }
                break;
            } catch (Exception e) {
                System.out.println("File path invalid.");
                e.printStackTrace();
            }
        }

        //setup out
        while (true) {
            try {
                System.out.print("Output file path: ");
                File outfile = new File(c.next());
                out = new FileWriter(outfile);
                break;
            } catch (IOException e) {
                System.out.println("That file location is not valid");
            }
        }
    }

    /**
     * @param key the string to find characters after
     * @return a character after one of the occurrences of the key
     */
    private String get_next_char(String key) {
        ArrayList<Character> chars = new ArrayList<>();

        //Builds a list of chars following the key
        for (int i = in.length() - k - 1; i >= 0; i--) {
            if (in.substring(i, i + k).equals(key)) {
                chars.add(in.charAt(i + k));
            }
        }

        if (chars.size() == 0) {
            //If chars is empty return a new seed
            return get_seed();
        } else {
            //Return a random char from chars
            return String.valueOf(chars.get((new Random()).nextInt(chars.size())));
        }

    }

    /**
     * Runs the program
     */
    private void run() {
        //The output string
        StringBuilder out_str = new StringBuilder(get_seed());

        //Builds up out_str
        while (out_str.length() < length) {
            out_str.append(get_next_char(out_str.substring(out_str.length() - k)));
        }

        System.out.println(out_str);

        //Write to the output
        try {
            out.write(out_str.toString());
            out.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

