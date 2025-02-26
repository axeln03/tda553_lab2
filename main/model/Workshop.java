package main.model;

import java.util.Stack;

public class Workshop<T> {
    private int maxCapacity;
    String name;
    private Storage<T> storage;
    private double x;
    private double y;
    public Workshop(int maxCapacity, String name, double x, double y) {
        this.maxCapacity = maxCapacity;
        this.name = name;
        this.storage = new Storage<T>(maxCapacity);
        this.x = x;
        this.y = y;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public String getName() {
        return name;
    }

    public Stack<T> getStorage() {
        return storage.getCurrentStorage();
    }

    public void load(T t) {
        if (storage.getCurrentSize() < getMaxCapacity()) {
            storage.loadOn(t);

        } else {
            throw new RuntimeException("The workshop is full!");
        }
    }

    public T unloadIndex(int i) {
        return storage.removeIndex(i);
    }

    public void setX(double value) {
        x = value;
    }

    public void setY(double value) {
        y = value;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

}
