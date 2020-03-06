package Ch_11_Practice;

import java.util.*;

public class Practice {
    public static void main(String[] args) {

        ArrayList<Integer> a = sortAndRemoveDuplicates(new ArrayList<Integer>(Arrays.asList(1, 1, 4, 3, 2)));
        System.out.println("sortAndRemoveDuplicates");
        System.out.println(a.toString());
        System.out.println();

        //##############################################################################################################

        HashMap<String, Integer> map = new HashMap<>();
        map.put("a", 1);
        map.put("b", 2);
        map.put("c", 1);
        map.put("d", 1);
        map.put("e", 5);
        int b = rarest(map);
        System.out.println("rarest");
        System.out.println(b);
        System.out.println();

        ArrayList<Integer> c = partition(new ArrayList<>(Arrays.asList(1, 1, 4, 3, 2)), 4);
        System.out.println("partition");
        System.out.println(c.toString());
        System.out.println();

        //##############################################################################################################

        HashMap<Integer, Integer> a1 = new HashMap<>();
        a1.put(1, 3);
        a1.put(5, 8);
        a1.put(3, 3);
        a1.put(2, 0);
        a1.put(4, 1);

        HashMap<Integer, Integer> a2 = new HashMap<>();
        a2.put(1, 3);
        a2.put(2, 8); //
        a2.put(3, 3);
        a2.put(5, 0); //
        a2.put(4, 1);

        HashMap<Integer, Integer> a3 = intersect(a1, a2);
        System.out.println("intersection");
        System.out.println(a3.toString());


    }

    public static ArrayList<Integer> sortAndRemoveDuplicates(ArrayList<Integer> l) {
        Set<Integer> treeSet = new TreeSet<>();
        treeSet.addAll(l);
        l.clear();
        l.addAll(treeSet);
        return (l);
    }

    public static int rarest(HashMap<String, Integer> map) {
        ArrayList<Integer> values = new ArrayList<>(map.values());
        values.sort(null);
        int bestnum = values.size() + 1;
        int best = 0;
        int occurances;
        for (int i = values.size() - 1; i > 1; i--) {
            occurances = 0;
            while (i > 1 && values.get(i - 1) == values.get(i)) {
                i--;
                occurances++;
            }
            if (occurances < bestnum) {
                bestnum = occurances;
                best = values.get(i);
            } else if (occurances == bestnum) {
                if (values.get(i) < best) {
                    bestnum = occurances;
                    best = values.get(i);
                }
            }
        }
        return (best);
    }

    public static ArrayList<Integer> partition(ArrayList<Integer> list, int E) {
        list.sort(null);
        return list;
    }

    public static HashMap<Integer, Integer> intersect(HashMap<Integer, Integer>

                                                              A, HashMap<Integer, Integer> B) {

        Integer[] keys = A.keySet().toArray(new Integer[0]);
        Integer[] vals = A.values().toArray(new Integer[0]);
        int key;
        int val;
        HashMap<Integer, Integer> C = new HashMap<>();
        for (int i = keys.length - 1; i >= 0; i--) {
            key = keys[i];
            val = vals[i];
            if (B.remove(key, val))
                C.put(key, val);
        }
        return (C);
    }
}
