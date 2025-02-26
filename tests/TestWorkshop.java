import main.model.*;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class TestWorkshop {
    Workshop<Volvo240> workshopVolvo = new Workshop<>(40,"VolvoWorkshop");
    Workshop<Vehicle> workshop = new Workshop<>(2, "Workshop");
    Workshop<Vehicle> workshopVehicle = new Workshop<>(3, "WorkshopV");
    CarTransport carTransport = new CarTransport(2,100, Color.black,"transport",0,0);
    Volvo240 volvo = new Volvo240();
    Volvo240 volvo2 = new Volvo240();
    Saab95 saab95 = new Saab95();



    @Test
    public void testMaxCapacityWorkshop(){
        carTransport.lowerRamp();
        carTransport.load(volvo);
        workshop.load(carTransport.unLoad());
        workshop.load(volvo2);
        assertThrows(RuntimeException.class,() -> {
            workshop.load(saab95);
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
        workshopVehicle.load(carTransport);
        workshopVehicle.load(saab95);
        workshopVehicle.load(volvo);
        System.out.println(workshopVehicle.unloadIndex(0));
        System.out.println(workshopVehicle.getStorage());
        assertEquals(2, workshopVehicle.getStorage().size());
    }

    @Test
    public void testVolvo() {
        workshopVolvo.load(volvo);
        assertTrue(workshopVolvo.unloadIndex(0) instanceof Volvo240);

    }
}
