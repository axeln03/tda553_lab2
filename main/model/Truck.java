package main.model;

import java.awt.*;

public abstract class Truck extends Vehicle {


    public Truck(int nrDoors, double enginePower, Color color, String modelName, int x, int y){
        super(nrDoors, enginePower, color, modelName, x, y);
    }

    @Override
    public double speedFactor() {
        return getEnginePower() * 0.01;
    }

}
