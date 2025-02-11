import main.*;
import org.junit.Test;
import static org.junit.Assert.*;

import java.awt.*;
import java.util.Vector;

public class TestCarTransport {

    CarTransport carTransport = new CarTransport(2, 100,Color.green, "Mercedes", 0, 0);
    Saab95 saab = new Saab95();



    @Test
    public void testRamp(){
        assertTrue(carTransport.getRamp());
        carTransport.lowerRamp();
        assertFalse(carTransport.getRamp());
    }


    @Test
    public void testRampStaysUp(){
        carTransport.gas(0.2);
        assertThrows(IllegalArgumentException.class, () -> {carTransport.lowerRamp();});
    }


    @Test
    public void testUnLoadUp(){
        carTransport.lowerRamp();
        carTransport.load(saab);
        carTransport.raiseRamp();
        assertThrows(IllegalArgumentException.class,() -> {carTransport.unLoad();});

    }

    @Test
    public void loadRampUp() {
        assertThrows(IllegalArgumentException.class, () -> {carTransport.load((saab));});
    }

    @Test
    public void testSamePosition(){
        carTransport.lowerRamp();
        carTransport.load(saab);
        carTransport.raiseRamp();
        carTransport.gas(0.5);
        assertEquals(carTransport.getX(),saab.getX(),0.001);
        assertEquals(carTransport.getY(),saab.getY(), 0.001);

    }

}
