package main;

import java.awt.*;

public abstract class FlatbedTruck extends Truck {

    public FlatbedTruck(int nrDoors, double enginePower, Color color, String modelName, int x, int y) {
        super(nrDoors, enginePower, color, modelName, x, y);
    }


    public abstract void raiseBed(double amount);

    public abstract void lowerBed(double amount);
}
