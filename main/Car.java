package main;

import java.awt.*;

public abstract class Car implements Movable {

    private final  int nrDoors; // Number of doors on the car
    private final  double enginePower; // Engine power of the car
    private  final String modelName;
    private  double currentSpeed; // The current speed of the car
    private  Color color; // Color of the car
     // The car model name


    public Car(int nrDoors, double enginePower, Color color, String modelName) {
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;
        stopEngine();
    }

    public int getNrDoors() {
        return nrDoors;
    }
    public double getEnginePower(){
        return enginePower;
    }
    public double getCurrentSpeed(){
        return currentSpeed;
    }
    public Color getColor(){
        return color;
    }

    public void setColor(Color clr){
        color = clr;
    }
    public void startEngine(){
        currentSpeed = 0.1;
    }
    public void stopEngine(){
        currentSpeed = 0;
    }

    public abstract double speedFactor();

    public String getModelName() {
        return modelName;
    }
}
