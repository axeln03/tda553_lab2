import main.Car;
import main.CarTransport;
import main.Saab95;
import org.junit.Test;
import static org.junit.Assert.*;

import java.awt.*;

public class TestCarTransport {

    CarTransport carTransport = new CarTransport(2, 100, Color.green, "Mercedes", 0, 0);
    Saab95 saab = new Saab95();

    @Test
    public void testUnLoadUp(){
        carTransport.lowerRamp();
        carTransport.loadOn(saab);
        carTransport.raiseRamp();
        assertThrows(IllegalArgumentException.class,() -> {carTransport.loadOff();});

    }


}
