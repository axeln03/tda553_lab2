package main;


import main.model.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/*
 * This class represents the Controller part in the MVC pattern.
 * It's responsibilities is to listen to the View and responds in a appropriate manner by
 * modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 10;
    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    ArrayList<Vehicle> cars = new ArrayList<>();
    private Workshop<Volvo240> volvo240Workshop = new Workshop<>(40,"volvoWorkshop");
    //methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();

        cc.cars.add(new Saab95());
        cc.cars.add(new Scania());
        cc.cars.add(new Volvo240());
        cc.cars.add(new Saab95());

        int i = 0;
        for(Vehicle car : cc.cars){
            car.setY(i);
            i += 100;
        }

        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);

        // Start the timer
        cc.timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Vehicle car : cars) {
                car.move();
                changeRuntimeDirection(car);
                int x = (int) Math.round(car.getX());
                int y = (int) Math.round(car.getY());
                frame.drawPanel.moveit(car, x, y);
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
                checkWorkshopCollision(car,x,y);
            }
        }
    }


    void changeRuntimeDirection(Vehicle car) {
        if (car.getX() < 0) {
            car.stopEngine();
            car.setDirection(Direction.RIGHT);
            car.startEngine();
        } else if (car.getX() > 700) {
            car.stopEngine();
            car.setDirection(Direction.LEFT);
            car.startEngine();
        } else if (car.getY() < 0) {
            car.stopEngine();
            car.setDirection(Direction.DOWN);
            car.startEngine();
        } else if (car.getY() > 500) {
            car.stopEngine();
            car.setDirection(Direction.UP);
            car.startEngine();
        }

    }

    void checkWorkshopCollision(Vehicle car,int x, int y){
        if(x >= 300 && x<=400 && y <= 395 && y >= 300 && car instanceof Volvo240 && !car.getIsLoaded()){
            car.stopEngine();
            volvo240Workshop.load((Volvo240) car);
            car.setLoaded(true);
            System.out.println(volvo240Workshop.getStorage());
        }
    }


}
