import main.*;


import org.junit.Test;

import static java.awt.Color.black;
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
    public void testSpeedFactor() {
        assertTrue(1.25 == saab.speedFactor());
        saab.setTurboOn();
        assertTrue(1.625 == saab.speedFactor());
    }

    @Test
    public void testNumberOfDoors() {
        assertEquals(2, saab.getNrDoors());
    }

    @Test
    public void testEnginePower() {
        assertTrue(125 == saab.getEnginePower()); // Didn't work with assertEquals()
    }


    @Test
    public void testColor() {
        assertEquals(red, saab.getColor());
        saab.setColor(black);
        assertEquals(black,saab.getColor());
    }

    @Test
    public void testGetX(){
        assertTrue(0 == saab.getX());
    }

    @Test
    public void testGetY(){
        assertTrue(0 == saab.getY());
    }

    @Test
    public void testStartEngine(){
        saab.startEngine();
        assertEquals(0.1, saab.getCurrentSpeed(), 0.00001);
    }

    @Test
    public void testStopEngine(){
        saab.startEngine();
        saab.stopEngine();
        assertTrue(0 == saab.getCurrentSpeed());
    }

    @Test
    public  void testModelName() {
        assertTrue("Saab95".equals(saab.getModelName()));
    }


    @Test
    public void testTurnRight() {
        saab.setDirection(Direction.UP);
        saab.turnRight();
        assertEquals(Direction.RIGHT, saab.getDirection());
        saab.turnRight();
        assertEquals(Direction.DOWN, saab.getDirection());
        saab.turnRight();
        assertEquals(Direction.LEFT, saab.getDirection());
        saab.turnRight();
        assertEquals(Direction.UP, saab.getDirection());
    }

    @Test
    public void testTurnLeft() {
        saab.setDirection(Direction.UP);
        saab.turnLeft();
        assertEquals(Direction.LEFT, saab.getDirection());
        saab.turnLeft();
        assertEquals(Direction.DOWN, saab.getDirection());
        saab.turnLeft();
        assertEquals(Direction.RIGHT, saab.getDirection());
        saab.turnLeft();
        assertEquals(Direction.UP, saab.getDirection());

    }

    @Test
    public void testMove(){
        saab.setDirection(Direction.UP);
        saab.setCurrentSpeed(10);
        saab.move();
        assertEquals(10, saab.getY(), 0.0);
    }

    @Test
    public void testGasInterval() {
        double x = 1.1;
        double y = -0.1;
        assertThrows(IllegalArgumentException.class, () -> {
            saab.gas(x);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            saab.gas(y);
        });
    }

    @Test
    public void testBrakeInterval() {
        double x = 1.1;
        double y = -0.1;
        assertThrows(IllegalArgumentException.class, () -> {
            saab.brake(x);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            saab.brake(y);
        });
    }

    @Test
    public void testGasResult() {
        saab.setCurrentSpeed(2.0);
        saab.gas(0);
        assertTrue(2 <= saab.getCurrentSpeed());
    }

    @Test
    public void testBrakeResult() {
        saab.setCurrentSpeed(2.0);
        saab.brake(0.5);
        assertTrue(2 >= saab.getCurrentSpeed());
    }

    @Test
    public void testCurrentSpeedInterval() {
        double enginePower = saab.getEnginePower();
        saab.setCurrentSpeed(125);
        saab.gas(1);
        assertTrue(enginePower == saab.getCurrentSpeed());
        saab.setCurrentSpeed(0);
        saab.brake(1);
        assertTrue(0 == saab.getCurrentSpeed());

    }

}
