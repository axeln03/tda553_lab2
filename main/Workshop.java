package main;

import java.util.Stack;

public class Workshop<T extends Vehicle> implements Loadable<T> {
    private int maxCapacity;
    String name;
    private Storage<T> storage;

    public Workshop(int maxCapacity, String name) {
        this.maxCapacity = maxCapacity;
        this.name = name;
        this.storage = new Storage<T>(maxCapacity);
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

    public <U extends T> void loadOn(U car) {
        if (storage.getCurrentSize() < getMaxCapacity()) {
            storage.load(car);
        } else {
            throw new RuntimeException("The workshop is full!");
        }
    }

    public <U extends T> U loadOff() {
        return storage.deLoad();
    }

}
