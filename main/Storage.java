package main;

import java.util.Stack;

public class Storage<T extends Vehicle> {
    private final int capacity;
    private Stack<T> stack;


    public Storage(int capacity ){

        this.capacity = capacity;
        this.stack = new Stack<>();
    }
    public Stack<T> getCurrentStorage(){return stack;}
    public int getCurrentSize(){
        return stack.size();
    }
    public int getMaxSize(){
        return capacity;
    }
    public <U extends T> void load(U type){
        stack.push(type);
    }
    public <U extends T> U deLoad(){
        return (U) stack.pop();
    }
}
