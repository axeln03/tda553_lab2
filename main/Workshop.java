package main;

public class Workshop<T extends Car> implements Loadable<T> {
    private int maxCapacity;
    String name;
    private Storage<T> storage;

    public Workshop(int maxCapacity, String name){
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

    public Storage<T> getStorage() {
        return storage;
    }

    public void loadOn(T car) {
        if (storage.getCurrentSize() < getMaxCapacity()) {
            storage.load(car);
        }
        else {
            throw new RuntimeException("The workshop is full!");
        }
    }

    public T loadOff(){
        return storage.deLoad();
    }

}
