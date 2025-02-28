package main.model;

import java.awt.*;
import main.model.Vehicle.*;

public class GenerateObjects {
    public Car createSaab95(int x, int y) {
        return new Saab95(x, y);
    }

    public static Car createVolvo250(int x, int y) {
        return new Volvo240(x, y);
    }

    public static Truck createCarTransport(int x, int y) {
        return new CarTransport(2, 100, Color.green, "CarTransport", x, y);
    }

    public static Truck createScania(int x, int y) {
        return new Scania(x, y);
    }

    public static Workshop<Saab95> createSaab95Workshop(int maxCapacity, String name, double x, double y){

        return new Workshop<Saab95>(maxCapacity, name, x, y);
    }

    public static Workshop<Volvo240> createVolvo240Workshop(int maxCapacity, String name, double x, double y){
        return new Workshop<Volvo240>(maxCapacity, name, x, y);
    }
}
