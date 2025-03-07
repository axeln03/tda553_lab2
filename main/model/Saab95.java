package main.model;

import java.awt.*;

public class Saab95 extends Car {

    private boolean turboOn;

    public Saab95(int x, int y) {
        super(2, 125, Color.red, "Saab95", x, y);
        turboOn = false;
    }

    public void setTurboOn() {
        turboOn = true;
    }

    public void setTurboOff() {
        turboOn = false;
    }

    public boolean getTurboStatus() {
        return turboOn;
    }

    @Override
    public double speedFactor() {
        double turbo = 1;
        if (turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }

}
