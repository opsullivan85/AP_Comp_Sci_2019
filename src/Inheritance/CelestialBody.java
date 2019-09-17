package Inheritance;

import java.util.Arrays;

public class CelestialBody {
    private double[] position = new double[2];
    private double[] velocity = new double[2];
    private double[] accel = new double[2];
    private double time = 0.0;


    CelestialBody(double[] position, double[] velocity){

        this.position = position;
        this.velocity = velocity;

    }

    CelestialBody(double orbitRadius, double orbitVelocity){

        this.position = new double[]{orbitRadius, 0};
        this.velocity = new double[]{0, orbitVelocity};

    }

    public void run(int frames){
        double tau = 0.0027;
        double num = 4 * Math.pow(Math.PI, 2);

        for(int frame = 0; frame < frames; frame++) {
            for (int i = 1; i >= 0; i--) {
                accel[i] = -num * position[i] / Math.pow(Math.sqrt(Math.pow(this.position[0], 2) + Math.pow(this.position[1], 2)), 3);
                position[i] += tau * velocity[i];
                velocity[i] += tau * accel[i];
            }

            time += tau;
            System.out.println(this.toString() + " " + frame);
        }

    }

    public String toString() {
        return "CelestialBody{" +
                "position=" + Arrays.toString(position) +
                ", velocity=" + Arrays.toString(velocity) +
                ", accel=" + Arrays.toString(accel) +
                ", time=" + time +
                '}';
    }

}
