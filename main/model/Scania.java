package main.model;

import java.awt.*;

public class Scania extends Truck implements RampFunction {

    private double bedAngle;
    private final double bedSpeed = 5;


    public Scania() {
        super(2, 200, Color.green, "Scania", 0, 0);
        this.bedAngle = 0;
    }

    public void setBedAngle(double bedAngle) {
        this.bedAngle = bedAngle;
    }

    public double getBedAngle() {
        return bedAngle;
    }

    public double getBedSpeed() {
        return bedSpeed;
    }

    public double getCurrentBedAngle() {
        return bedAngle;
    }

    @Override
    public void raiseRamp() {
        if (getCurrentSpeed() == 0) {
            setBedAngle(Math.min(getCurrentBedAngle() + getBedSpeed(), 70));
        } else {
            throw new IllegalArgumentException("Can't raise bed while moving");
        }
    }

    @Override
    public void lowerRamp() {
        if (getCurrentSpeed() == 0) {
            setBedAngle(Math.max(getCurrentBedAngle() - getBedSpeed(), 0));
        }
    }

    @Override
    public void gas(double value) {
        if (getCurrentBedAngle() == 0) {
            super.gas(value);
        }
    }

}
