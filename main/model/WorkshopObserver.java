package main.model;

public interface WorkshopObserver {
    void onWorkshopUpdate(Workshop<?> workshop);
}
