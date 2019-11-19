package Ch_12_Practice;

public class domino {
    public int first() {
        return first;
    }

    public int second() {
        return second;
    }

    public String toString(){
        return(String.format("[%d|%d]", first, second));
    }

    int first;
    int second;

    public domino(int first, int second) {
        this.first = first;
        this.second = second;
    }
}
