package Ch_14_Practice;

import java.util.*;

public class practice {
    public static void main(String[] args) {
        System.out.println(postfix_operations("3 1 2 + *"));

        Queue<Double> q = new LinkedList<Double>(Arrays.asList(-1., 1., -2., 2., 0., 1.));
        System.out.println(split_queue(q));

        Queue<Integer> p = new LinkedList<Integer>(Arrays.asList(-1, 1, -2, -2, 1, -1));
        System.out.println(is_palindrome(p));
    }

    public static Number postfix_operations(String string) {
        Stack<Integer> stack = new Stack<>();
        String[] s = string.split(" ");
        int max = s.length;
        for (int i = 0; i < max; i++) {
            try {
                stack.push(Integer.parseInt(s[i]));
            } catch (NumberFormatException e) {
                switch (s[i]) {
                    case "+":
                        stack.push(stack.pop() + stack.pop());
                        break;
                    case "-":
                        stack.push(stack.pop() - stack.pop());
                        break;
                    case "*":
                        stack.push(stack.pop() * stack.pop());
                        break;
                    case "/":
                        stack.push(stack.pop() / stack.pop());
                        break;
                    default:
                        return -1;
                }
            }
        }

        return stack.pop();
    }

    public static Queue<Double> split_queue(Queue<Double> q) {
        Queue<Double> greater = new LinkedList<Double>();
        Queue<Double> less = new LinkedList<Double>();

        for (Double n : q) {
            if (n.compareTo(0.0) > 0) {
                greater.add(n);
            } else {
                less.add(n);
            }
        }

        less.addAll(greater);

        return less;
    }

    public static boolean is_palindrome(Queue<Integer> n) {
        Stack<Integer> stack = new Stack<>();
        Queue<Integer> queue = new LinkedList<>();

        for (Integer i : n) {
            stack.add(i);
            queue.add(i);
        }

        for (int i = stack.size() - 1; i >= 0; i--) {
            if (!stack.pop().equals(queue.remove())) {
                return false;
            }
        }
        return true;
    }
}
