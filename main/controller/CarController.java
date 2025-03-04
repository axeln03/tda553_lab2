package main.controller;


import main.model.*;
import main.view.*;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * This class represents the Controller part in the MVC pattern.
 * It's responsibilities is to listen to the View and responds in a appropriate manner by
 * modifying the model state and the updating the view.
 */

public class CarController {

    Model model;
    ControlPanel controlPanel;

    public CarController(Model model, ControlPanel controlPanel) {
        this.model = model;
        this.controlPanel = controlPanel;
        activeButtons();
    }


    public void activeButtons() {
        controlPanel.gasSpinner.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                controlPanel.gasAmount = (int) ((JSpinner)e.getSource()).getValue();
            }
        });
        controlPanel.gasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.gas(controlPanel.gasAmount);
            }
        });

        controlPanel.brakeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.brake(controlPanel.gasAmount);
            }
        });

        controlPanel.stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.stopAllCars();
            }
        });

        controlPanel.startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.startAllCars();
            }
        });

        controlPanel.turboOnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.turboOn();
            }
        });

        controlPanel.turboOffButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.turboOff();
            }
        });

        controlPanel.lowerBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.lowerBed();
            }
        });

        controlPanel.liftBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.raiseBed();
            }
        });

        controlPanel.addCarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.addCar();
            }
        });

        controlPanel.removeCarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.removeCar();
            }
        });
    }
}
