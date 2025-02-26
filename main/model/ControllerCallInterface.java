package main.model;

public interface ControllerCallInterface {

    public void gas(double amount);
    public void brake(double amount);
    public void turboOn();
    public void turboOff();
    public void raiseBed();
    public void lowerBed();
    public void startAllCars();
    public void stopAllCars();

    public void addCar();
    public void removeCar();

}
