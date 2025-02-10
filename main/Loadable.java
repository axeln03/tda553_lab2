package main;

public interface Loadable<T>  {
        <U extends T> U loadOff();
        <U extends T> void loadOn(U t);
}
