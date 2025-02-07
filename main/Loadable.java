package main;

public interface Loadable<T>  {
        void loadOff();
        void loadOn(T t);
}
