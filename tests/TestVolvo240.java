package tests;

import main.Car;
import main.Saab95;
import org.junit.Test;

import static java.awt.Color.red;
import static org.junit.Assert.*;

public class TestVolvo240 {

    Saab95 volvo = new Saab95();


    @Test
    public void testNumberOfDoors() {
        assertEquals(2, volvo.getNrDoors());
    }

    @Test
    public void testEnginePower() {
        assertTrue(125 == volvo.getEnginePower()); // Didn't work with assertEquals()
    }


    @Test
    public void testColor() {
        assertEquals(red, volvo.getColor());
    }

    @Test
    public  void testModelName() {
        assertTrue("Saab95".equals(volvo.getModelName()));
    }


    @Test
    public void testTurnRight() {
        volvo.setDirection(Car.Direction.UP);
        volvo.turnRight();
        assertEquals(Car.Direction.RIGHT, volvo.getDirection());
        volvo.turnRight();
        assertEquals(Car.Direction.DOWN, volvo.getDirection());
        volvo.turnRight();
        assertEquals(Car.Direction.LEFT, volvo.getDirection());
        volvo.turnRight();
        assertEquals(Car.Direction.UP, volvo.getDirection());
    }

    @Test
    public void testTurnLeft() {
        volvo.setDirection(Car.Direction.UP);
        volvo.turnLeft();
        assertEquals(Car.Direction.LEFT, volvo.getDirection());
        volvo.turnLeft();
        assertEquals(Car.Direction.DOWN, volvo.getDirection());
        volvo.turnLeft();
        assertEquals(Car.Direction.RIGHT, volvo.getDirection());
        volvo.turnLeft();
        assertEquals(Car.Direction.UP, volvo.getDirection());

    }

    @Test
    public void testGasInterval() {
        double x = 1.1;
        double y = -0.1;
        assertThrows(IllegalArgumentException.class, () -> {
            volvo.gas(x);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            volvo.gas(y);
        });
    }

    @Test
    public void testBrakeInterval() {
        double x = 1.1;
        double y = -0.1;
        assertThrows(IllegalArgumentException.class, () -> {
            volvo.brake(x);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            volvo.brake(y);
        });
    }

    @Test
    public void testGasResult() {
        volvo.setCurrentSpeed(2.0);
        volvo.gas(0);
        assertTrue(2 <= volvo.getCurrentSpeed());
    }

    @Test
    public void testBrakeResult() {
        volvo.setCurrentSpeed(2.0);
        volvo.brake(0.5);
        assertTrue(2 >= volvo.getCurrentSpeed());
    }

    @Test
    public void testCurrentSpeedInterval() {
        double enginePower = volvo.getEnginePower();
        volvo.setCurrentSpeed(100);
        volvo.gas(1);
        assertTrue(enginePower == volvo.getCurrentSpeed());
        volvo.setCurrentSpeed(0);
        volvo.brake(1);
        assertTrue(0 == volvo.getCurrentSpeed());

    }

}
