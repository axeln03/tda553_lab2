package main;

import main.controller.CarController;
import main.controller.ControlPanel;
import main.view.View;
import main.model.Model;
import main.model.Saab95;
import main.model.Volvo240;
import main.model.Workshop;
import main.view.GameView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class App {
    public static void main(String [] args){

        int delay = 10;
        Model model = new Model();
        Timer timer = new Timer(delay, new TimerListener(model));
        GameView gameView = new GameView(800,800);
        ControlPanel controlPanel = new ControlPanel();
        model.addVehicleObserver(gameView);
        model.addWorkshopObserver(gameView);

        model.addCar(new Saab95(0,0));
        model.addWorkshop(new Workshop<Saab95>(10,"Saab95Workshop",200,100));
        model.addWorkshop(new Workshop<Volvo240>(10,"Volvo240Workshop",300,300));


        View view = new View("CarFrame 2.0", gameView, controlPanel);
        CarController cc = new CarController(model, controlPanel);
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
