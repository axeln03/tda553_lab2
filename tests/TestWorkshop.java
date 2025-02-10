import main.*;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class TestWorkshop {
    Workshop<Volvo240> workshopVolvo = new Workshop<Volvo240>(40,"VolvoWorkshop");
    Workshop<Car> workshop = new Workshop<Car>(2, "Workshop");
    Workshop<Vehicle> workshopVehicle = new Workshop<>(3, "WorkshopV");
    CarTransport carTransport = new CarTransport(2,100, Color.black,"transport",0,0);
    Volvo240 volvo = new Volvo240();
    Volvo240 volvo2 = new Volvo240();
    Saab95 saab95 = new Saab95();



    @Test
    public void testMaxCapacityWorkshop(){
        carTransport.lowerRamp();
        carTransport.loadOn(volvo);
        workshop.loadOn(carTransport.loadOff());
        workshop.loadOn(volvo2);
        assertThrows(RuntimeException.class,() -> {
            workshop.loadOn(saab95);
        });
    }
    /*
    @Test
    public void testWrongCar() {
        workshopVolvo.loadOn(saab95);
    }
     */

    @Test
    public void testFlexibleWorkshop() {
        workshopVehicle.loadOn(carTransport);
        workshopVehicle.loadOn(saab95);
        workshopVehicle.loadOn(volvo);
        assertEquals(3, workshopVehicle.getStorage().size());
    }

    @Test
    public void testVolvo() {
        workshopVolvo.loadOn(volvo);
        assertTrue(workshopVolvo.loadOff() instanceof Volvo240);

    }
}
