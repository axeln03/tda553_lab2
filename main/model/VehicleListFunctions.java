package main.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class VehicleListFunctions implements Iterable<Vehicle> {
    private final List<Vehicle> vehicles = new ArrayList<>();

    void addVehicle(Vehicle v) {
        vehicles.add(v);
    }

    void removeVehicle(Vehicle v) {
        vehicles.remove(v);
    }

    @Override
    public Iterator<Vehicle> iterator() {
        return vehicles.iterator();
    }

    void move() {
        for (Vehicle v : vehicles) {
            v.move();
        }
    }

    void gas(double amount) {
        for (Vehicle v : vehicles) {
            v.gas(amount);
        }
    }

    void brake(double amount) {
        for (Vehicle v : vehicles) {
            v.brake(amount);
        }
    }

    void turboOn() {
        for (Vehicle v : vehicles) {
            if (v instanceof Saab95) {
                ((Saab95) v).setTurboOn();
            }
        }
    }

    void turboOff() {
        for (Vehicle v : vehicles) {
            if (v instanceof Saab95) {
                ((Saab95) v).setTurboOff();
            }
        }
    }

    void raiseBed() {
        for (Vehicle v : vehicles) {
            if (v instanceof Truck) {
                ((Truck) v).raiseRamp();
            }
        }
    }

    void lowerBed() {
        for (Vehicle v : vehicles) {
            if (v instanceof Truck) {
                ((Truck) v).lowerRamp();
            }
        }
    }


    void startAllCars() {
        for (Vehicle v : vehicles) {
            v.startEngine();
        }
    }

    void stopAllCars() {
        for (Vehicle v : vehicles) {
            v.stopEngine();
        }
    }
}