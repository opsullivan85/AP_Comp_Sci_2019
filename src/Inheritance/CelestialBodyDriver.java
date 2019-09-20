package Inheritance;

import java.util.Scanner;

public class CelestialBodyDriver {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.print("orbitRadius: ");
        double orbitRadius = s.nextDouble();


        System.out.print("orbitVelocity: ");
        double orbitVelocity = s.nextDouble();

        CelestialBody b = new CelestialBody(orbitRadius, orbitVelocity);

        System.out.print("frames: ");
        int frames = s.nextInt();

        b.run(frames);


    }
}
