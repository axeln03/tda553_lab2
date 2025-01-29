package tests;

import main.Car;
import main.Saab95;
import org.junit.Test;

import static java.awt.Color.red;
import static org.junit.Assert.*;

public class TestSaab95 {

    Saab95 saab = new Saab95();

    @Test
    public void testTurbo() {
        saab.setTurboOn();
        assertTrue(saab.getTurboStatus());
        saab.setTurboOff();
        assertFalse(saab.getTurboStatus());
    }

    @Test
    public void  testNumberOfDoors() {
        assertEquals(2, saab.getNrDoors());
    }

    @Test
    public void testEnginePower() {
        assertTrue(125 == saab.getEnginePower()); // Didn't work with assertEquals()
    }


    @Test
    public void testColor() {
        assertEquals(red, saab.getColor());
    }


    @Test
    public void testTurnRight(){
        saab.setDirection(Car.Direction.UP);
        saab.turnRight();
        assertEquals(Car.Direction.RIGHT, saab.getDirection());
        saab.turnRight();
        assertEquals(Car.Direction.DOWN, saab.getDirection());
        saab.turnRight();
        assertEquals(Car.Direction.LEFT, saab.getDirection());
        saab.turnRight();
        assertEquals(Car.Direction.UP, saab.getDirection());
    }

    @Test
    public void testTurnLeft() {
        saab.setDirection(Car.Direction.UP);
        saab.turnLeft();
        assertEquals(Car.Direction.LEFT, saab.getDirection());
        saab.turnLeft();
        assertEquals(Car.Direction.DOWN, saab.getDirection());
        saab.turnLeft();
        assertEquals(Car.Direction.RIGHT, saab.getDirection());
        saab.turnLeft();
        assertEquals(Car.Direction.UP, saab.getDirection());

    }

    @Test
    public void testGasInterval(){
        double x = 1.1;
        double y = -0.1;
        assertThrows(IllegalArgumentException.class, () -> {saab.gas(x);});
        assertThrows(IllegalArgumentException.class, () -> {saab.gas(y);});
    }

    @Test
    public void testBrakeInterval(){
        double x = 1.1;
        double y = -0.1;
        assertThrows(IllegalArgumentException.class, () -> {saab.brake(x);});
        assertThrows(IllegalArgumentException.class, () -> {saab.brake(y);});
    }

    @Test
    public void testGasResult(){
        saab.setCurrentSpeed(2.0);
        saab.gas(0);
        assertTrue(2 <= saab.getCurrentSpeed());
    }

    @Test
    public void testBrakeResult(){
        saab.setCurrentSpeed(2.0);
        saab.brake(0.5);
        assertTrue(2 >= saab.getCurrentSpeed());
    }

}ö
