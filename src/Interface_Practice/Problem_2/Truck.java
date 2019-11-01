package Interface_Practice.Problem_2;

public class Truck implements Vehicle {

    private String color;
    private int numAxles;
    private int VIN;
    private int modelYear;
    private int horsepower;
    private boolean hasPlow;

    public Truck(String color, int numAxles, int VIN, int modelYear, int horsepower, boolean hasPlow) {
        this.color = color;
        this.numAxles = numAxles;
        this.VIN = VIN;
        this.modelYear = modelYear;
        this.horsepower = horsepower;
        this.hasPlow = hasPlow;
    }

    public int getHorsepower() {
        return horsepower;
    }

    public boolean getHasPlow() {
        return hasPlow;
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
        return "Truck{" +
                "color='" + color + '\'' +
                ", numAxles=" + numAxles +
                ", VIN=" + VIN +
                ", modelYear=" + modelYear +
                ", horsepower=" + horsepower +
                ", hasPlow=" + hasPlow +
                '}';
    }
}