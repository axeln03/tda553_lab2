
import main.model.*;

import org.junit.Test;

import static java.awt.Color.*;
import static org.junit.Assert.*;

public class TestVolvo240 {

    Volvo240 volvo = new Volvo240(0,0);


    @Test
    public void testNumberOfDoors() {
        assertEquals(4, volvo.getNrDoors());
    }

    @Test
    public void testEnginePower() {
        assertTrue(100 == volvo.getEnginePower()); // Didn't work with assertEquals()
    }


    @Test
    public void testColor() {
        assertEquals(black, volvo.getColor());
    }

    @Test
    public  void testModelName() {
        assertTrue("Volvo240".equals(volvo.getModelName()));
    }


    @Test
    public void testTurnRight() {
        volvo.setDirection(Direction.UP);
        volvo.turnRight();
        assertEquals(Direction.RIGHT, volvo.getDirection());
        volvo.turnRight();
        assertEquals(Direction.DOWN, volvo.getDirection());
        volvo.turnRight();
        assertEquals(Direction.LEFT, volvo.getDirection());
        volvo.turnRight();
        assertEquals(Direction.UP, volvo.getDirection());
    }

    @Test
    public void testTurnLeft() {
        volvo.setDirection(Direction.UP);
        volvo.turnLeft();
        assertEquals(Direction.LEFT, volvo.getDirection());
        volvo.turnLeft();
        assertEquals(Direction.DOWN, volvo.getDirection());
        volvo.turnLeft();
        assertEquals(Direction.RIGHT, volvo.getDirection());
        volvo.turnLeft();
        assertEquals(Direction.UP, volvo.getDirection());

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
