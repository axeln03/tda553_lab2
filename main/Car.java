package main;

import java.awt.*;

public abstract class Car {

    private final int nrDoors; // Number of doors on the car
    private final double enginePower; // Engine power of the car
    private final String modelName; // The car model name
    private double currentSpeed; // The current speed of the car
    private Color color;// Color of the car
    private int x;
    private int y;
    private Direction direction;

    public Car(int nrDoors, double enginePower, Color color, String modelName) {
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;
        this.currentSpeed = currentSpeed;
        this.x = x;
        this.y = y;
        this.direction = Direction.RIGHT;
        stopEngine();
    }

    public enum Direction {
        UP, DOWN, LEFT, RIGHT
    }

    public int getNrDoors() {
        return nrDoors;
    }

    public double getEnginePower() {
        return enginePower;
    }

    public double getCurrentSpeed() {
        return currentSpeed;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color clr) {
        color = clr;
    }

    public void startEngine() {
        currentSpeed = 0.1;
    }

    public void stopEngine() {
        currentSpeed = 0;
    }

    public abstract double speedFactor();

    public void incrementSpeed(double amount) {
        double currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, getEnginePower());
    }

    public void decrementSpeed(double amount) {
        double currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount, 0);
    }


    public String getModelName() {
        return modelName;
    }

    // TODO fix this method according to lab pm
    public void gas(double amount) {
        incrementSpeed(amount);
    }


    // TODO fix this method according to lab pm
    public void brake(double amount) {
        decrementSpeed(amount);
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction newDirection) {
        direction = newDirection;
    }

    public void turnRight() {
        switch (direction) {
            case UP:
                setDirection(Direction.RIGHT);
                break;
            case RIGHT:
                setDirection(Direction.DOWN);
                break;
            case DOWN:
                setDirection(Direction.LEFT);
                break;
            case LEFT:
                setDirection(Direction.UP);
                break;
        }

    }

    public void turnLeft() {
        switch (direction) {
            case UP:
                setDirection(Direction.LEFT);
                break;
            case RIGHT:
                setDirection(Direction.UP);
                break;
            case DOWN:
                setDirection(Direction.RIGHT);
                break;
            case LEFT:
                setDirection(Direction.DOWN);
                break;
        }

    }

    public void move() {
        double currentSpeed = getCurrentSpeed();
        switch (direction) {
            case UP:
                y += currentSpeed;
                break;
            case RIGHT:
                x += currentSpeed;
                break;
            case DOWN:
                y -= currentSpeed;
                break;
            case LEFT:
                x -= currentSpeed;
                break;
        }
    }

}
