package main;

import main.controller.CarController;
import main.controller.CarFrame;
import main.model.Model;
import main.model.Saab95;
import main.model.Volvo240;
import main.model.Workshop;
import main.view.MainView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class App {
    public static void main(String [] args){

        int delay = 10;
        Model model = new Model();
        Timer timer = new Timer(delay, new TimerListener(model));
        MainView view = new MainView(800,800);
        model.addVehicleObserver(view);
        model.addWorkshopObserver(view);

        model.addCar(new Saab95(0,0));

        CarFrame frame = new CarFrame("CarFrame 2.0", view);
        CarController cc = new CarController(model, frame);
        timer.start();
    }


    private static class TimerListener implements ActionListener {
        private Model model;

        public TimerListener(Model model){
            this.model = model;
        }

        public void actionPerformed(ActionEvent e) {
            model.updateVehicle();
        }
    }
}
