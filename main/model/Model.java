package main.model;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.awt.*;
import java.util.List;
import java.util.Timer;

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
        notifyVehicleObservers(car);
    }

    public void removeCar(Car car) {
        vehicles.removeVehicle(car);
        notifyVehicleObservers(car);

    }

    public void addWorkshop(Workshop<? extends Vehicle> workshop){
        workshops.addWorkshop(workshop);
        notifyWorkshopObservers(workshop);
    }


    // controller
    public void gas(double amount) {
        double gas = amount / 100;
        for (Vehicle car : vehicles
        ) {
            car.gas(gas);
            System.out.println(car.getCurrentSpeed());
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
        if (vehicles.size() % 3 == 0) {
            Car volvo240 = GenerateObjects.createVolvo250(0, vehicles.size() * 100);
            vehicles.addVehicle(volvo240);
            notifyVehicleObservers(volvo240);
        }
        else if (vehicles.size() % 3 == 1) {
            Car saab95 = GenerateObjects.createSaab95(0, vehicles.size() * 100);
            vehicles.addVehicle(saab95);
            notifyVehicleObservers(saab95);
        }
        else {
            Truck scania = GenerateObjects.createScania(0, vehicles.size() * 100);
            vehicles.addVehicle(scania);
            notifyVehicleObservers(scania);
        }
    }

    public void removeCar() {
        if (vehicles.size() > 0) {
            int index = vehicles.size() - 1;
            Vehicle car = vehicles.get(index);
            vehicles.removeVehicle(car);
            notifyVehicleObserversRemoval(car);

        }
    }


    void changeRuntimeDirection() {
        for (Vehicle car : vehicles) {
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
        for (Vehicle car : vehicles) {
            workshopCollision();
            car.move();
            changeRuntimeDirection();
            notifyVehicleObservers(car);
        }
    }

    public void addVehicleObserver(VehicleObserver observer) {
        vehicleObservers.add(observer);
    }

    public void addWorkshopObserver(WorkshopObserver observer) {
        workshopObservers.add(observer);
    }

    private void notifyVehicleObservers(Vehicle car) {
        for (VehicleObserver observer : vehicleObservers) {
            observer.onVehicleUpdate(car);
        }
    }

    private void notifyWorkshopObservers(Workshop<?> workshop) {
        for (WorkshopObserver observer : workshopObservers) {
            observer.onWorkshopUpdate(workshop);
        }
    }

    private void notifyVehicleObserversRemoval(Vehicle car) {
        for (VehicleObserver observer : vehicleObservers) {
            observer.onVehicleRemoval(car);
        }
    }

    private void workshopCollision(){
        for(Vehicle car : vehicles){
            for(Workshop<? extends Vehicle> workshop : workshops){
                //System.out.println(workshop.getX(), car.get);
                if(workshop.getName().contains(car.getModelName()) && !car.getIsLoaded() && collisionDistance(car, workshop)){
                    car.stopEngine();
                    car.setX(workshop.getX());
                    car.setY(workshop.getY());
                    loadIntoWorkshop(workshop, car);
                }
            }
        }
    }

    private boolean collisionDistance(Vehicle car, Workshop<?> workshop ){
        return (Math.abs(car.getX() - workshop.getX()) <= 10 && Math.abs(car.getY() - workshop.getY()) <= 10);
    }

    //Helper to load correctly
    private<T extends Vehicle> void loadIntoWorkshop(Workshop<T> workshop, Vehicle car){
        workshop.load((T) car);
        car.setLoaded(true);
    }


}
