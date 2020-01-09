package RandomWriter_Project;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

class RandomWriter {
    private int k, length;
    private String in;
    private FileWriter out;

    RandomWriter(){
        this.get_parameters();
        this.run();
    }

    //This is called when a new seed is needed
    private String get_seed() {
        int index = (new Random()).nextInt(in.length() - k);
        return in.substring(index, index + k);
    }

    private void get_parameters() {
        Scanner c = new Scanner(System.in);
        //get k
        do {
            System.out.print("k: ");
            k = c.nextInt();
            if (k < 0) {
                System.out.println("k must be positive!");
            }
        } while (k < 0);

        //get length
        do {
            System.out.print("Length: ");
            length = c.nextInt();
            if (length < 0) {
                System.out.println("length must be positive!");
            }
        } while (length < 0);

        //setup in
        //in = "According to all known laws of aviation, there is no way a bee should be able to fly. Its wings are too small to get its fat little body off the ground.";
        while(true){
            try{
                System.out.print("Input file path: ");
                //System.out.println(c.next());
                Scanner in_file = new Scanner(new File(c.next()));

                while(in_file.hasNext()){
                    in += in_file.nextLine();
                }
                break;
            } catch (Exception e) {
                System.out.println("File path invalid.");
                e.printStackTrace();
            }
        }

        //setup out
        while(true){
            try{
                System.out.print("Output file path: ");
                File outfile = new File(c.next());
                out = new FileWriter(outfile);
                break;
            } catch(IOException e){
                System.out.println("That file location is not valid");
            }
        }
    }

    private String get_next_char(String key){
        //if the text does not contain the key get a new seed
        if (!in.contains(key)){
            return get_seed();
        } else {
            System.out.println("good");
            //get a random index in the text
            //return the character after the next occurance
            //of the key after or before the index
            Random r = new Random();
            int index = r.nextInt(in.length());
            if(in.substring(index).contains(key)){
                return String.valueOf(in.substring(index).charAt(key.indexOf(key) + key.length()));
            } else if(in.substring(0, index).contains(key)){
                return String.valueOf(in.substring(0, index).charAt(in.lastIndexOf(key) + key.length()));
            } else{
                return "[[Something has gone terribly wrong!]]";
            }
        }
    }

    private void run(){
        //The output string
        StringBuilder out_str = new StringBuilder(get_seed());

        for(int i = length; i > 0; i--){
            out_str.append(get_next_char(out_str.substring(out_str.length() - k)));
        }

        System.out.println(out_str);

        try{
            out.write(out_str.toString());
            out.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

