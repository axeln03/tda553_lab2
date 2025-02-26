import main.model.Scania;
import org.junit.Test;
import static org.junit.Assert.*;



public class TestScania {
    Scania scania = new Scania();

    @Test
    public void testBedLimits(){
        scania.setCurrentSpeed(0);
        scania.raiseRamp();
        assertEquals(scania.getCurrentBedAngle(),  5, 0.001);
        scania.lowerRamp();
        assertEquals(scania.getCurrentBedAngle(),  0, 0.001);
    }
}
