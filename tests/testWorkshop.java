import main.CarTransport;
import main.Saab95;
import main.Volvo240;
import main.Car;
import main.Workshop;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class testWorkshop {
    Workshop<Volvo240> workshopVolvo = new Workshop<Volvo240>(40,"VolvoWorkshop");
    Workshop<Car> workshop = new Workshop<Car>(2, "Workshop");
    CarTransport carTransport = new CarTransport(2,100, Color.black,"transport",0,0);
    Volvo240 volvo = new Volvo240();
    Volvo240 volvo2 = new Volvo240();
    Saab95 saab95 = new Saab95();
    @Test
    public void testMaxWorkshop(){
        carTransport.lowerRamp();
        carTransport.loadOn(volvo);
        workshop.loadOn(carTransport.loadOff());
        workshop.loadOn(volvo2);
        assertThrows(RuntimeException.class,() -> {
            workshop.loadOn(saab95);
        });
    }
}
