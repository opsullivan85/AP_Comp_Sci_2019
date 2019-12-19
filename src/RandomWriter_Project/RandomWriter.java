package RandomWriter_Project;

import java.io.*;
import java.util.Scanner;

public class RandomWriter {
    int k, length;
    FileReader in;
    FileWriter out;

    public RandomWriter() {
        getVariables();

    }

    public void getVariables() {
        Scanner c = new Scanner(System.in);
        //get k
        do {
            System.out.println("k: ");
            k = c.nextInt();
            if (k < 0) {
                System.out.println("k must be positive!");
            }
        } while (k < 0);

        //get length
        do {
            System.out.println("k: ");
            length = c.nextInt();
            if (length < 0) {
                System.out.println("length must be positive!");
            }
        } while (length < 0);

        //setup in
        while(true){
            try{
                System.out.println("Input file path: ");
                in = new FileReader(c.next());
                break;
            } catch(IOException e){
                System.out.println("That file location is not valid");
            }
        }

        //setup out
        while(true){
            try{
                System.out.println("Output file path: ");
                File outfile = new File(c.next());
                out = new FileWriter(outfile);
                break;
            } catch(IOException e){
                System.out.println("That file location is not valid");
            }
        }
    }

    public String run(){
        String s = "";

        for(int i = length; i < 0; i--){
            //run
        }

        return s;
    }
}

