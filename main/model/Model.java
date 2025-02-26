package main.model;

import java.util.*;
import java.awt.*;

public class Model implements ControllerCallInterface {
    private VehicleListFunctions vehicles;
    private WorkshopList workshops;

    public Model() {
        this.vehicles = new VehicleListFunctions();
        this.workshops = new WorkshopList();
    }


    public void gas(double amount) {
        double gas = amount / 100;
        for (Vehicle car : vehicles
        ) {
            car.gas(gas);
        }
    }

    public void brake(double amount) {
        double brake = amount / 100;
        for (Vehicle car : vehicles
        ) {
            car.brake(brake);
        }
    }

    public void stopAllCars() {
        for (Vehicle car : vehicles
        ) {
            car.stopEngine();
        }
    }

    public void startAllCars() {
        vehicles.startAllCars();
    }

    public void turboOn() {
        vehicles.turboOn();
    }

    public void turboOff() {
        vehicles.turboOff();
    }

    public void raiseBed() {
        vehicles.raiseBed();
    }

    public void lowerBed() {
        vehicles.lowerBed();
    }

    public void addCar() {
        
    }
}
