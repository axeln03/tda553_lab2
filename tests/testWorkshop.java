import main.CarTransport;
import main.Saab95;
import main.Volvo240;
import main.Workshop;
import org.junit.Test;

import java.awt.*;

public class testWorkshop {
    Workshop<Volvo240> workshop = new Workshop<>(40,"VolvoWorkshop");
    CarTransport carTransport = new CarTransport(2,100, Color.black,"transport",0,0);
    Volvo240 volvo = new Volvo240();
    Saab95 saab95 = new Saab95();
    @Test
    public void testVolvoWorkshop(){
        carTransport.lowerRamp();
        carTransport.loadOn(volvo);
        workshop.loadOn(carTransport.loadOff());

    }
}
