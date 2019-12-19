package Ch_12_Practice;

import java.util.ArrayList;
import java.util.Arrays;

public class Snowpacket {
    public static void main(String[] args){
        ArrayList<String> s = new ArrayList<>(Arrays.asList("this", "is", "a", "list", "of", "words"));
        String key = "o f";

        System.out.println(s.toString());

        s.sort(null);

        System.out.println(s.toString());
        System.out.println(key);
        System.out.println(str_search(s, key));
    }

    public static int str_search(ArrayList<String> s, String key){
        return (str_search(s, key,0, s.size()-1));
    }

    private static int str_search(ArrayList<String> s, String key, int start, int end){
        System.out.println(start + " " + end);
        int diff = s.get((start + end) / 2).compareTo(key);
        if (diff == 0){
            return ((start + end) / 2);
        } else if(start >= end){
            return (-1);
        }

        if (diff > 0){
            return str_search(s, key, ((start + end) / 2)+1, end);
        } else{
            return str_search(s, key, start, ((start + end) / 2)-1);
        }
    }
}
