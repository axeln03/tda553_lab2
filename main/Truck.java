package main;
import java.awt.*;

public abstract class Truck extends Car {

    public Truck(int nrDoors, double enginePower, Color color, String modelName, int x, int y) {
        super(nrDoors, enginePower, color, String modelName, x, y);
    }

    @Override
    public double speedFactor() {
        return getEnginePower() * 0.01;
    }

    public abstract void raiseBed(double amount);

    public abstract void lowerBed(double amount);
