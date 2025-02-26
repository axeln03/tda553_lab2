package main.model;

import java.util.Stack;

public class Storage<T> implements Loadable<T> {
    private final int capacity;
    private Stack<T> stack;


    public Storage(int capacity) {

        this.capacity = capacity;
        this.stack = new Stack<>();
    }

    public Stack<T> getCurrentStorage() {
        return stack;
    }

    public int getCurrentSize() {
        return stack.size();
    }

    public int getMaxSize() {
        return capacity;
    }

    @Override
    public T loadOff() {
        return stack.pop();
    }

    @Override
    public void loadOn(T t) {
        stack.push(t);
    }

    public T removeIndex(int i){
        return stack.remove(i);
    }

    /*
    public <U extends T> void load(U type) {
        stack.push(type);
    }

    public <U extends T> U deLoad() {
        return (U) stack.pop();
    }

     */
}
