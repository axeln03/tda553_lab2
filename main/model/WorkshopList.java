package main.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class WorkshopList implements Iterable<Workshop<? extends Car>> {
    private final List<Workshop<? extends Car>> workshop = new ArrayList<>();

    void addWorkshop(Workshop<? extends Car> w) {
        workshop.add(w);
    }

    void removeWorkshop(Workshop<? extends Car> w) {
        workshop.remove(w);
    }

    @Override
    public Iterator<Workshop<? extends Car>> iterator() {
        return workshop.iterator();
    }
}
