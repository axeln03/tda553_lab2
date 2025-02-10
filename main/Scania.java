package main;

import java.awt.*;

public class Scania extends FlatbedTruck {

    private double bedAngle;
    private final double bedSpeed = 5;


    public Scania() {
        super(2, 200, Color.green, "Scania", 0, 0);
        this.bedAngle = 0;
    }

    public double getCurrentBedAngle() {
        return bedAngle;
    }

    @Override
    public void raiseBed(double amount) {
        if (getCurrentSpeed() == 0) {
            bedAngle = Math.min(getCurrentBedAngle() + bedSpeed * amount, 70);
        } else {
            throw new IllegalArgumentException("Can't raise bed while moving");
        }
    }

    @Override
    public void lowerBed(double amount) {
        if (getCurrentSpeed() == 0) {
            bedAngle = Math.max(getCurrentBedAngle() - bedSpeed * amount, 0);
        } else {
            throw new IllegalArgumentException("Can't lower bed while moving");
        }
    }

    @Override
    public void gas(double value) {
        if (getCurrentBedAngle() == 0) {
            super.gas(value);
        } else {
            throw new IllegalArgumentException("Can't move while bed i up.");
        }
    }

}
