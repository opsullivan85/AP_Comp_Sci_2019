package Unit_1.File_IO;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("src/Unit_1/File_IO/numbers.txt");
        Scanner s = new Scanner(f);
        evenNumbers(s);
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
        System.out.printf("%d evens (%f%%)\n", evens, evens / (double)nums * 100);
    }
}
