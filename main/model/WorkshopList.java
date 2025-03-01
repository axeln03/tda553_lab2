package main.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class WorkshopList implements Iterable<Workshop<? extends Vehicle>> {
    private final List<Workshop<? extends Vehicle>> workshop = new ArrayList<>();

    void addWorkshop(Workshop<? extends Vehicle> w) {
        workshop.add(w);
    }

    void removeWorkshop(Workshop<? extends Vehicle> w) {
        workshop.remove(w);
    }

    @Override
    public Iterator<Workshop<? extends Vehicle>> iterator() {
        return workshop.iterator();
    }
}
