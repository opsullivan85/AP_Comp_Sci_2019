package Ch_12_Practice;

public class domino {
    public int start() {
        return start;
    }

    public int end() {
        return end;
    }

    public String toString(){
        return(String.format("[%d|%d]", start, end));
    }

    int start;
    int end;

    public domino(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
