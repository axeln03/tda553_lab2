package main.view;

import com.sun.tools.javac.Main;
import main.model.*;

import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;

// This panel represents the animated part of the view with the car images.

public class MainView extends JPanel implements VehicleObserver, WorkshopObserver {

    // Just a single image, TODO: Generalize
    BufferedImage volvoImage;
    BufferedImage saabImage;
    BufferedImage scaniaImage;
    BufferedImage volvoWorkshopImage;


    HashMap<String, BufferedImage> imageHashMap = new HashMap<String, BufferedImage>();
    HashMap<Vehicle, Point> vehiclePointHashMap = new HashMap<>();
    HashMap<Workshop<?>, Point> workshopPointHashMap = new HashMap<>();


    //HashMap
    // To keep track of a single car's position

    @Override
    public void onVehicleUpdate(Vehicle car){
        vehiclePointHashMap.put(car, new Point((int) car.getX(),(int) car.getY()));
        repaint();
    }

    @Override
    public void onVehicleRemoval(Vehicle car){
        vehiclePointHashMap.remove(car);
        repaint();
    }

    @Override
    public void onWorkshopUpdate(Workshop<?> workshop){
        workshopPointHashMap.put(workshop, new Point((int) workshop.getX(), (int) workshop.getY()));
        repaint();
        }

    // Initializes the panel and reads the images
    public MainView(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y-240));
        this.setBackground(Color.green);
        // Print an error message in case file is not found with a try/catch block
        try {
            // You can remove the "pics" part if running outside of IntelliJ and
            // everything is in the same main folder.
            // volvoImage = ImageIO.read(new File("Volvo240.jpg"));

            // Rememember to rightclick src New -> Package -> name: pics -> MOVE *.jpg to pics.
            // if you are starting in IntelliJ.
            volvoImage = ImageIO.read(MainView.class.getResourceAsStream("pics/Volvo240.jpg"));
            saabImage = ImageIO.read(MainView.class.getResourceAsStream("pics/Saab95.jpg"));
            scaniaImage = ImageIO.read(MainView.class.getResourceAsStream("pics/Scania.jpg"));

            imageHashMap.put("Volvo240", volvoImage);
            imageHashMap.put("Saab95", saabImage);
            imageHashMap.put("Scania", scaniaImage);

            volvoWorkshopImage = ImageIO.read(MainView.class.getResourceAsStream("pics/VolvoBrand.jpg"));
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.s Change so workshop works the same as vehicles
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Vehicle car : vehiclePointHashMap.keySet()){
            g.drawImage(imageHashMap.get(car.getClass().getSimpleName()), vehiclePointHashMap.get(car).x, vehiclePointHashMap.get(car).y , null);
        }

        for(Workshop<?> workshop : workshopPointHashMap.keySet()) {
            g.drawImage(volvoWorkshopImage, workshopPointHashMap.get(workshop).x, workshopPointHashMap.get(workshop).y, null);
        }
    }


}
