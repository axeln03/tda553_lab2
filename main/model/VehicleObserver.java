package main.model;

public interface VehicleObserver {
    void onVehicleUpdate(Vehicle car);
    void onVehicleRemoval(Vehicle car);
}
