package main.model;

import java.util.*;
import java.awt.*;
import java.util.List;

public class Model implements ControllerCallInterface {
    private VehicleListFunctions vehicles;
    private WorkshopList workshops;
    private List<VehicleObserver> vehicleObservers;
    private List<WorkshopObserver> workshopObservers;


    public Model() {
        this.vehicles = new VehicleListFunctions();
        this.workshops = new WorkshopList();
        this.vehicleObservers = new ArrayList<>();
        this.workshopObservers = new ArrayList<>();
    }


    // dessa 2 funktioner lägger till bilar utan controller
    public void addCar(Car car) {
        vehicles.addVehicle(car);
    }

    public void removeCar(Car car) {
        vehicles.removeVehicle(car);
    }


    // controller
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
        if (vehicles.size() < 6) {
            Car saab = GenerateObjects.createVolvo250(0, vehicles.size() * 100);
            vehicles.addVehicle(saab);
        }
    }

    public void removeCar() {
        if (vehicles.size() > 0) {
            int index = vehicles.size();
            Vehicle car = vehicles.get(index);
            vehicles.removeVehicle(car);
        }
    }


    void changeRuntimeDirection() {
        for (Vehicle car: vehicles) {
            if (car.getX() < 0) {
                car.stopEngine();
                car.setDirection(Direction.RIGHT);
                car.startEngine();
            } else if (car.getX() > 700) {
                car.stopEngine();
                car.setDirection(Direction.LEFT);
                car.startEngine();
            } else if (car.getY() < 0) {
                car.stopEngine();
                car.setDirection(Direction.DOWN);
                car.startEngine();
            } else if (car.getY() > 500) {
                car.stopEngine();
                car.setDirection(Direction.UP);
                car.startEngine();
            }
        }

    }

    //TODO Finish this up
    public void updateVehicle() {
        for(Vehicle car: vehicles){
            car.move();
            notifyVehicleObservers(car);
        }
    }

    public void addVehicleObserver(VehicleObserver observer){
        vehicleObservers.add(observer);
    }
    public void addWorkshopObserver(WorkshopObserver observer){
        workshopObservers.add(observer);
    }

    private void notifyVehicleObservers(Vehicle car){
        for(VehicleObserver observer: vehicleObservers){
            observer.onVehicleUpdate(car);
        }
    }


}


// Skapa update, collision med kant, collision med workshop
