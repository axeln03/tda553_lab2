import main.model.*;
import org.junit.Test;
import static org.junit.Assert.*;



public class TestScania {
    Scania scania = new Scania(0,0);

    @Test
    public void testBedLimits(){
        scania.setCurrentSpeed(0);
        scania.raiseRamp();
        assertEquals(scania.getCurrentBedAngle(),  5, 0.001);
        scania.lowerRamp();
        assertEquals(scania.getCurrentBedAngle(),  0, 0.001);
    }
}
