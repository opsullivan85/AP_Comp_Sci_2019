package Interface_Practice.Problem_1;

public class Square implements Shapes {

    private double sideLen;

    Square(double sideLen) {
        this.sideLen = sideLen;
    }

    @Override
    public double getArea() {
        return sideLen * sideLen;
    }

    @Override
    public double getPerimeter() {
        return 4 * sideLen;
    }
}
