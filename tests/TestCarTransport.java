import main.Car;
import main.CarTransport;
import main.Saab95;
import org.junit.Test;
import static org.junit.Assert.*;

import java.awt.*;

public class TestCarTransport {

    CarTransport carTransport = new CarTransport(2, 100, Color.green, "Mercedes", 0, 0);
    Saab95 saab = new Saab95();

<<<<<<< HEAD
=======
    @Test
    public void testUnLoadUp(){
        carTransport.lowerRamp();
        carTransport.loadOn(saab);
        carTransport.raiseRamp();
        assertThrows(IllegalArgumentException.class,() -> {carTransport.loadOff();});

    }

    @Test
    public void testSamePosition(){
        carTransport.lowerRamp();
        carTransport.loadOn(saab);
        carTransport.raiseRamp();
        carTransport.gas(0.5);
        assertEquals(carTransport.getX(),saab.getX(),0.001);
        assertEquals(carTransport.getY(),saab.getY(), 0.001);

    }

>>>>>>> 57311c9c71ab0f26e5708d23ab8832a31eeb7e6a

}
