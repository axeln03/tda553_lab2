import main.Scania;
import main.Truck;
import org.junit.Test;
import static org.junit.Assert.*;



public class TestScania {
    Scania scania = new Scania();

    @Test
    public void testBedLimits(){
        scania.setCurrentSpeed(0);
        scania.raiseBed(100);
        assertEquals(scania.getCurrentBedAngle(),  70, 0.001);
        scania.lowerBed(100);
        assertEquals(scania.getCurrentBedAngle(),  0, 0.001);
    }
}
