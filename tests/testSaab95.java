import main.Car;
import main.Saab95;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

public class testSaab95 {

    @Test
    public void testTurnRight(){
        Saab95 saab = new Saab95();
        saab.setDirection(Car.Direction.RIGHT);
        saab.turnRight();
        Assert.assertEquals(Car.Direction.DOWN, saab.getDirection());
    }
}
