package main.view;

import main.model.Vehicle;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.util.HashMap;

// This panel represents the animated part of the view with the car images.

public class DrawPanel extends JPanel{

    // Just a single image, TODO: Generalize
    BufferedImage volvoImage;
    BufferedImage saabImage;
    BufferedImage scaniaImage;


    HashMap<String, BufferedImage> imageHashMap = new HashMap<String, BufferedImage>();
    HashMap<Vehicle, Point> pointHashMap = new HashMap<>();
    //HashMap
    // To keep track of a single car's position
    BufferedImage volvoWorkshopImage;
    Point volvoWorkshopPoint = new Point(300,300);
    Point point = new Point();
    // TODO: Make this general for all cars
    void moveit(Vehicle car, int x, int y){
        Point point = new Point(x,y);
        pointHashMap.put(car, point);
    }

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        // Print an error message in case file is not found with a try/catch block

    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.s
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Vehicle car : pointHashMap.keySet()){
            g.drawImage(imageHashMap.get(car.getClass().getSimpleName()), pointHashMap.get(car).x, pointHashMap.get(car).y , null);
        }

        g.drawImage(volvoWorkshopImage, volvoWorkshopPoint.x, volvoWorkshopPoint.y, null);
    }
}
