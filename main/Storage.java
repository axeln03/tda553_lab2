package main;

import java.util.Stack;

public class Storage<T extends Vehicle> {
    private final int capacity;
    private Stack<T> stack;


    public Storage(int capacity ){

        this.capacity = capacity;
        this.stack = new Stack<>();
    }

    public int getCurrentSize(){
        return stack.size();
    }
    public int getMaxSize(){
        return capacity;
    }
    public void load(T type){
        stack.push(type);
    }
    public T deLoad(){
        return stack.pop();
    }
}
