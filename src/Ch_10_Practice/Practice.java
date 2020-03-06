package Ch_10_Practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Practice {
    public static void main(String[] args) {
        ArrayList<String> words = new ArrayList<>(Arrays.asList("hello", "this", "is", "a", "test"));

        System.out.println(averageVowels(words));

        ArrayList<String> words2 = new ArrayList<>(Arrays.asList("How", "are", "you?"));

        System.out.println(doubleList(words2).toString());

        ArrayList<String> words3 = new ArrayList<>(Arrays.asList("to", "be", "or", "not", "to", "be", "that", "is", "the", "question"));

        ArrayList<String> tmp = removeInRange(words3, "free", "rich");

        System.out.println(tmp.toString());
    }

    public static float averageVowels(ArrayList<String> strings) {
        int numVowels = 0;
        int numWords = strings.size();

        String vowels = "aeiouAEIOU";
        for (String s : strings) {
            for (Character c : s.toCharArray()) {
                if (vowels.indexOf(c) != -1)
                    numVowels++;
            }
        }

        return ((float) numVowels / numWords);
    }

    public static ArrayList<String> doubleList(ArrayList<String> words) {
        for (int i = words.size() - 1; i >= 0; i--) {
            words.add(i, words.get(i));
        }
        return words;
    }

    public static ArrayList<String> removeInRange(ArrayList<String> words, String start, String end) {

        words.add(start);
        words.add(end);

        ArrayList<String> sorted = (ArrayList<String>) words.clone();

        Collections.sort(sorted);

        int startIndex = sorted.indexOf(start);
        int endIndex = sorted.indexOf(end) + 1;

        words.removeAll(sorted.subList(startIndex, endIndex));

        return words;
    }
}
