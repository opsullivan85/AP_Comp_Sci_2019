package Unit_1.File_IO;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class File_IO {

    public static void main(String[] args) throws FileNotFoundException {

        File f = new File("src/Unit_1/File_IO/numbers.txt");
        Scanner s = new Scanner(f);
        evenNumbers(s);

        System.out.println("\n==================\n");

        f = new File("src/Unit_1/File_IO/duplicates.txt");
        s = new Scanner(f);
        printDuplicates(s);

        System.out.println("\n==================\n");

        f = new File("src/Unit_1/File_IO/coins.txt");
        s = new Scanner(f);
        coinFlip(s);

    }

    public static void evenNumbers(Scanner s){
        int nums = 0 ;
        int sum = 0;
        int evens = 0;
        int val;
        while(s.hasNextInt()){
            val = s.nextInt();
            sum += val;
            nums++;
            evens += 1 - (val % 2);
        }
        System.out.printf("%d numbers, sum = %d\n", nums, sum);
        System.out.printf("%d evens (%.1f%%)\n", evens, evens / (double)nums * 100);
    }

    public static void printDuplicates(Scanner s){
        String str;
        String[] words;
        int occurances = 0;
        while (s.hasNext()){

            str = s.nextLine();
            words = str.split(" ");

            for (int i = 0; i < words.length; i++){
                occurances = 1;
                while(i < words.length - 1 && words[i].equals(words[i+1])){
                    occurances++;
                    i++;
                }
                if(occurances > 1){
                    System.out.print(words[i] + "*" + occurances + " ");
                }
            }
            System.out.println();
        }
    }

    public static void coinFlip(Scanner s){
        String str;
        String[] words;
        int h, t;
        while (s.hasNext()){
            h = 0;
            t = 0;
            str = s.nextLine().toLowerCase();

            for (int c = 0; c < str.length(); c++){
                switch (str.charAt(c)){
                    case 'h':
                        h++;
                        break;
                    case 't':
                        t++;
                        break;
                }
            }
            System.out.printf("%d heads (%%%.1f)%n", h, (double) h / (h + t) * 100);
            if(h > t) {
                System.out.println("You Win!");
            }
            System.out.println();
        }
    }
}
