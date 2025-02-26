package main.model;

import java.util.*;
import java.awt.*;

public class Model implements ControllerCallInterface {
    private VehicleListFunctions vehicles;
    private WorkshopList workshops;

    public Model(){
        this.vehicles = new VehicleListFunctions();
        this.workshops = new WorkshopList();
    }
}
