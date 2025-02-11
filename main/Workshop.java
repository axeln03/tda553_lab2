package main;

import java.util.Stack;

public class Workshop<T> {
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

}
