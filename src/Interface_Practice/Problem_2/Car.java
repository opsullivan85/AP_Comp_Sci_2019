package Interface_Practice.Problem_2;

public class Car implements Vehicle {

    private String color;
    private int numAxles;
    private int VIN;
    private int modelYear;
    private double mileage;
    private int numCupHolders;

    public Car(String color, int nusAxles, int VIN, int modelYear, double mileage, int numCupHolders) {
        this.color = color;
        this.numAxles = nusAxles;
        this.VIN = VIN;
        this.modelYear = modelYear;
        this.mileage = mileage;
        this.numCupHolders = numCupHolders;
    }

    public double getmileage() {
        return mileage;
    }

    public int getNumCupHolders() {
        return numCupHolders;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public int getNumAxles() {
        return numAxles;
    }

    @Override
    public int getVIN() {
        return VIN;
    }

    @Override
    public int getModelYear() {
        return modelYear;
    }

    @Override
    public String toString() {
        return "Car{" +
                "color='" + color + '\'' +
                ", numAxles=" + numAxles +
                ", VIN=" + VIN +
                ", modelYear=" + modelYear +
                ", mileage=" + mileage +
                ", numCupHolders=" + numCupHolders +
                '}';
    }
}
