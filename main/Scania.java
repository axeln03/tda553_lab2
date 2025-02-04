package main;

import java.awt.*;

public class Scania extends Truck {

    private double bedAngle;
    private final double bedSpeed = 5;



    public Scania(){
        super(2, 200, Color.green, "Scania", 0, 0);
        this.bedAngle = 0;
    }

    public double getCurrentBedAngle() {
        return bedAngle;
    }

    @Override
    public void raiseBed(double amount) {
        if (getCurrentSpeed() == 0){
            bedAngle = Math.min(getCurrentBedAngle() + bedSpeed*amount, 70);
        }
        // TODO add raise exception
    }

    @Override
    public void lowerBed(double amount) {
        if (getCurrentSpeed() == 0) {
            bedAngle = Math.max(getCurrentBedAngle() - bedSpeed*amount, 0);
        }
        // TODO add raise exception
    }

    @Override
    public void gas(double amount) {
        if (getCurrentBedAngle() == 0) {
            super.gas(amount);
        }
    }
}
