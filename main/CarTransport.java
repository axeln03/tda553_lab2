package main;

import org.hamcrest.core.Is;

import java.awt.*;
import java.util.Stack;

public class CarTransport extends Truck implements RampFunction {
    private Storage<Car> storage = new Storage<>(5);
    private boolean ramp;


    public CarTransport(int nrDoors, double enginePower, Color color, String modelName, int x, int y) {
        super(nrDoors, enginePower, color, modelName, x, y);
        this.ramp = true;
    }

    @Override
    public void lowerRamp() {
        if (getCurrentSpeed() == 0) {
            ramp = false;
        } else {
            throw new IllegalArgumentException("Can't lower ramp while moving");
        }

    }

    @Override
    public void raiseRamp() {
        ramp = true;
    }

    public boolean getRamp() {
        return ramp;
    }

    public Stack<Car> getStorage() {
        return storage.getCurrentStorage();
    }


    public void load(Car car) {
        if ((storage.getCurrentSize() < storage.getMaxSize()) && (getCurrentSpeed() == 0) && relativeDistance(car) <= 100 && !getRamp()) {
            storage.loadOn(car);

            car.setX(this.getX());
            car.setY(this.getY());

            setLoaded(true);

        } else {
            throw new IllegalArgumentException("Car transporter is full");
        }
    }

    public Car unLoad() {
        if (!getRamp()) {
            Car removed = storage.loadOff();
            removed.setX(this.getX() - 5);
            removed.setY(this.getY() - 5);
            removed.setLoaded(false);

            return removed;
        } else {
            throw new IllegalArgumentException("Can't unload car while ramp is up");
        }
    }


    @Override
    public void gas(double amount) {
        if (getRamp()) {
            super.gas(amount);
        } else {
            throw new IllegalArgumentException("Can't move while ramp is down.");
        }
    }


}
