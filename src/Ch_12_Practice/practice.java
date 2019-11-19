package Ch_12_Practice;
import java.math.BigInteger;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;

public class practice {
    public static void main(String[] args){
        //for(int i = 1; i < 10; i++){
        //    System.out.println(fib(i));
        //}

        //System.out.println(fib(10000));
        //System.out.println(fib(100).divide(fib(99)));

        //System.out.println();
        //System.out.println(multiplyEvens(4));

        domino_set d = new domino_set(new ArrayList<domino>(Arrays.asList(
                new domino(6, 6),
                new domino(6, 4),
                new domino(4, 3),
                new domino(3, 3),
                new domino(3, 6),
                new domino(6, 1),
                new domino(1, 4),
                new domino(4, 2),
                new domino(2, 2),
                new domino(2, 1),
                new domino(1, 5),
                new domino(6, 6),
                new domino(6, 4),
                new domino(4, 3),
                new domino(3, 3),
                new domino(3, 6),
                new domino(6, 1),
                new domino(1, 4),
                new domino(4, 2),
                new domino(2, 2),
                new domino(2, 1),
                new domino(1, 5))));

        d.has_chain(6,2);
    }

    public static BigInteger fib(int index) throws IllegalArgumentException{
        if(index <= 0) {
            throw new IllegalArgumentException("'index' must be positive");
        } else{
            return(fib(index, new BigInteger("0"), new BigInteger("1")));
        }
    }

    private static BigInteger fib(int index, BigInteger cur, BigInteger prev){
        if(index == 1) {
            return (cur);
        } else{
            return (fib(index-1, cur.add(prev), cur));
        }
    }

    public static int multiplyEvens(int index){
        if(index <= 0) {
            throw new IllegalArgumentException("'index' must be positive");
        } else {
            return multiplyEvens(index, 1);
        }
    }

    private static int multiplyEvens(int index, int num){
        if(index == 0){
            return(num);
        } else{
            return multiplyEvens(index-1, num * (index * 2));
        }
    }
}
