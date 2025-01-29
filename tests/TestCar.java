package tests;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;

import static java.awt.Color.black;
import static org.junit.Assert.*;


import main.Car;
import main.Saab95;
import main.Volvo240;

public class TestCar {


    Volvo240 volvo = new Volvo240();
    Saab95 saab = new Saab95();

    @Test
    public void testTurnRight() {
        volvo.setDirection(Car.Direction.UP);
        volvo.turnRight();
        assertEquals(Car.Direction.RIGHT, volvo.getDirection());
    }

    @Test
    public void testMove() {
        volvo.setDirection(Car.Direction.UP);
        double y = volvo.getY();
        volvo.setCurrentSpeed(10);
        volvo.move();
        assertTrue(y < volvo.getY());

    }

    @Test
    public void testTurnLeft() {
        volvo.setDirection(Car.Direction.UP);
        volvo.turnLeft();
        assertEquals(Car.Direction.LEFT, volvo.getDirection());
    }

    @Test
    public void  testNumberOfDoors() {
        assertEquals(4, volvo.getNrDoors());
    }

    @Test
    public void testColor() {
        assertEquals(black, volvo.getColor());
    }

}
