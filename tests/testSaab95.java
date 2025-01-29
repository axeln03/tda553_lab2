import main.Car;
import main.Saab95;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

public class testSaab95 {

    Saab95 saab = new Saab95();

    @Test
    public void testTurnRight(){
        saab.setDirection(Car.Direction.RIGHT);
        saab.turnRight();
        assertEquals(Car.Direction.DOWN, saab.getDirection());
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

}
